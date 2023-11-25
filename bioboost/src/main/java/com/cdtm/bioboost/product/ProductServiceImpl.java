package com.cdtm.bioboost.product;

import com.cdtm.bioboost.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findTop3(String[] goals) {

        return (List<Product>) this.productRepository.findTop3(goals);
    }
}
