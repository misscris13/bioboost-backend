package com.cdtm.bioboost.product;

import com.cdtm.bioboost.product.model.ProductDto;
import com.cdtm.bioboost.productgoal.model.ProductGoalDto;
import com.cdtm.bioboost.user.model.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Product", description = "API of Product")
@RequestMapping(value = "/product")
@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    ModelMapper mapper;

    @Operation(summary = "Find Product")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ProductDto findById(@PathVariable("id") Long id) {

        return mapper.map(this.productService.findById(id), ProductDto.class);
    }
}
