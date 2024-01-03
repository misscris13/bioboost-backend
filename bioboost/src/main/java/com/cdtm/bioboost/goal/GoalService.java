package com.cdtm.bioboost.goal;

import com.cdtm.bioboost.goal.model.Goal;

import java.util.List;

public interface GoalService {

    List<Goal> findById(Long id);

    Goal findByName(String name);
}
