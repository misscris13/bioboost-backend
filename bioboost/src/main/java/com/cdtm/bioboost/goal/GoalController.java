package com.cdtm.bioboost.goal;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Goal", description = "API of Goal")
@RequestMapping(value = "/goal")
@RestController
@CrossOrigin(origins = "*")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @Autowired
    ModelMapper mapper;

    @Operation(summary = "Find by id")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public void findById(@PathVariable(name = "id", required = true) Long id) {

        this.goalService.findById(id);
    }
}
