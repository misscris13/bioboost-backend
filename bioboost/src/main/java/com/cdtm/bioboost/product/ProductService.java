package com.cdtm.bioboost.product;

import com.cdtm.bioboost.product.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findTop3(String[] goals);
}
