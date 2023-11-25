package com.cdtm.bioboost.product;

import com.cdtm.bioboost.product.model.ProductDto;
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

    /**
     * Method that returns the top 3 products for the 3 goals
     */
    @Operation(summary = "Find top")
    @RequestMapping(path = "/top3", method = RequestMethod.POST)
    public List<ProductDto> findTop3(@RequestBody String[] goals) {

        return (this.productService.findTop3(goals)).stream().map(e -> mapper.map(e, ProductDto.class)).collect(Collectors.toList());
    }
}
