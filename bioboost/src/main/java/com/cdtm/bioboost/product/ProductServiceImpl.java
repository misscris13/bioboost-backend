package com.cdtm.bioboost.product;

import com.cdtm.bioboost.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product findById(Long id) {

        return this.productRepository.findById(id).orElse(null);
    }

    public List<Product> findAll() {

        return (List<Product>) this.productRepository.findAll();
    }
}
