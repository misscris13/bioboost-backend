package com.cdtm.bioboost.productgoal;

import com.cdtm.bioboost.product.ProductService;
import com.cdtm.bioboost.product.model.ProductDto;
import com.cdtm.bioboost.productgoal.model.ProductGoalDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "ProductGoal", description = "API of ProductGoal")
@RequestMapping(value = "/productgoal")
@RestController
@CrossOrigin(origins = "*")
public class ProductGoalController {

    @Autowired
    private ProductGoalService productGoalService;

    @Autowired
    ModelMapper mapper;

    @Operation(summary = "Find by goal id")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public void findByGoalId(@PathVariable("id") Long id) {

        this.productGoalService.findByGoalId(id);
    }

    /**
     * Method that returns the top 3 products for the 3 goals
     */
    @Operation(summary = "Find top")
    @RequestMapping(path = "/top3", method = RequestMethod.POST)
    public List<ProductDto> findTop3(@RequestBody String[] goals) {

        return (this.productGoalService.findTop3(Arrays.asList(goals))).stream().map(e -> mapper.map(e, ProductDto.class)).collect(Collectors.toList());
    }
}
