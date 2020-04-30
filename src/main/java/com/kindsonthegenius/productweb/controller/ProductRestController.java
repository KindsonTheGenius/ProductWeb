package com.kindsonthegenius.productweb.controller;

import com.kindsonthegenius.productweb.api.ProductService;
import com.kindsonthegenius.productweb.client.ProductServiceProxy;
import com.kindsonthegenius.productweb.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@EnableFeignClients(basePackageClasses = ProductServiceProxy.class)
@ComponentScan(basePackageClasses = ProductServiceProxy.class)
public class ProductRestController implements ProductService {

   // @Autowired
    private ProductServiceProxy productServiceProxy;

    @Autowired
    public ProductRestController(ProductServiceProxy productServiceProxy) {
        this.productServiceProxy = productServiceProxy;
    }

    @Override
    @GetMapping("/productsweb")
    public List<Product> getAllProducts() {

        return productServiceProxy.getAllProducts();
    }

    @Override
    @GetMapping("/productsweb/{productId}")
    public Product getProduct(@PathVariable("productId") String productId) {
        return productServiceProxy.getProduct(productId);
    }
}
