package com.cdtm.bioboost.product;

import com.cdtm.bioboost.product.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends CrudRepository<Product, Long> {


}