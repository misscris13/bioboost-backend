package com.cdtm.bioboost.goal;

import com.cdtm.bioboost.goal.model.Goal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoalRepository extends CrudRepository<Goal, Long> {

    Goal findByName(String name);
}
