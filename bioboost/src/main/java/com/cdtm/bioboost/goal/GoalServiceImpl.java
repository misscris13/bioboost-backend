package com.cdtm.bioboost.goal;

import com.cdtm.bioboost.goal.model.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {

    @Autowired
    GoalRepository goalRepository;

    public List<Goal> findById(Long id) {

        return (List<Goal>) this.goalRepository.findById(id).orElse(null);
    }

    public Goal findByName(String name) {

        return (Goal) this.goalRepository.findByName(name);
    }
}
