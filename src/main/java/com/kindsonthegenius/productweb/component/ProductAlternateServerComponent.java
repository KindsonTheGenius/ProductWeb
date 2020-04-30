package com.kindsonthegenius.productweb.component;

import com.kindsonthegenius.productweb.api.ProductService;
import com.kindsonthegenius.productweb.client.ProductAlternateServiceProxy;
import com.kindsonthegenius.productweb.client.ProductServiceProxy;
import com.kindsonthegenius.productweb.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@EnableFeignClients(basePackageClasses = ProductAlternateServiceProxy.class)
@ComponentScan(basePackageClasses = ProductAlternateServiceProxy.class)
@Component
public class ProductAlternateServerComponent implements ProductServiceProxy {

    Logger logger = LoggerFactory.getLogger(ProductAlternateServerComponent.class);

    private ProductAlternateServiceProxy productAlternateServiceProxy;

    @Autowired
    public ProductAlternateServerComponent(ProductAlternateServiceProxy productAlternateServiceProxy) {
        this.productAlternateServiceProxy = productAlternateServiceProxy;
    }

    @Override
    public List<Product> getAllProducts() {
        logger.info("Delegating to the Indian Server...");
        return productAlternateServiceProxy.getAllProducts();
    }

    @Override
    public Product getProduct(String productId) {
        logger.info("Delegating to the Indian Server...");
        return productAlternateServiceProxy.getProduct(productId);
    }
}
