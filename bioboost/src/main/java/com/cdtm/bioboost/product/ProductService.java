package com.cdtm.bioboost.product;

import com.cdtm.bioboost.product.model.Product;

import java.util.List;

public interface ProductService {

    Product findById(Long id);

    List<Product> findAll();
}
