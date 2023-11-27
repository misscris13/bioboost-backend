package com.cdtm.bioboost.productgoal;

import com.cdtm.bioboost.goal.GoalService;
import com.cdtm.bioboost.goal.model.Goal;
import com.cdtm.bioboost.product.ProductService;
import com.cdtm.bioboost.product.model.Product;
import com.cdtm.bioboost.productgoal.model.ProductGoal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductGoalServiceImpl implements ProductGoalService {

    @Autowired
    ProductGoalRepository productGoalRepository;

    @Autowired
    GoalService goalService;

    @Autowired
    ProductService productService;

    public List<ProductGoal> findByGoalId(Long goalId) {

        return (List<ProductGoal>) this.productGoalRepository.findByGoalId(goalId);
    }

    public List<Product> findTop3(List<String> goalNames) {

        List<Goal> goals = new ArrayList<Goal>();
        List<ProductGoal> pg = new ArrayList<ProductGoal>();;
        HashMap<Long, Float> productWeights = new HashMap<>();

        productService.findAll().forEach(prod -> productWeights.put(prod.getId(), 0f));

        goalNames.forEach(name -> {

            pg.addAll(findByGoalId(goalService.findByName(name).getId()));

            pg.forEach(prod -> productWeights.replace(prod.getProduct().getId(), productWeights.get(prod.getProduct().getId()) + prod.getWeight()));

            pg.clear();
        });

        LinkedHashMap<Long, Float> productsByOrder =
                productWeights.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(e -> e.getKey(),
                                e -> e.getValue(),
                                (e1, e2) -> null, // or throw an exception
                                () -> new LinkedHashMap<Long, Float>()));

        List<Product> top3 = new ArrayList<Product>();

        List<Product> finalTop = top3;
        productsByOrder.forEach((key, value) -> {
            finalTop.add(productService.findById(key));
        });

        top3 = finalTop.subList(0, 2);

        return top3;
    }
}
