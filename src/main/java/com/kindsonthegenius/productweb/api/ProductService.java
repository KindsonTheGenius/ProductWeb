package com.kindsonthegenius.productweb.api;


import com.kindsonthegenius.productweb.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {

    @GetMapping("/products")
    public List<Product> getAllProducts();

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable("productId") String productId);
}
