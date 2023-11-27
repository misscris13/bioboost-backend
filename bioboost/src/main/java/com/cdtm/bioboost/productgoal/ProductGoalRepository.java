package com.cdtm.bioboost.productgoal;

import com.cdtm.bioboost.productgoal.model.ProductGoal;
import com.cdtm.bioboost.productgoal.model.ProductGoalId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductGoalRepository extends CrudRepository<ProductGoal, ProductGoalId> {

    List<ProductGoal> findByGoalId(Long goalId);
}