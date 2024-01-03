package com.cdtm.bioboost.productgoal;

import com.cdtm.bioboost.product.model.Product;
import com.cdtm.bioboost.productgoal.model.ProductGoal;

import java.util.List;

public interface ProductGoalService {

    List<ProductGoal> findByGoalId(Long goalId);

    List<Product> findTop3(List<String> goalNames);
}
