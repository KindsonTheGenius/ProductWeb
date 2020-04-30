package com.kindsonthegenius.productweb.client;

import com.kindsonthegenius.productweb.api.ProductService;
import com.kindsonthegenius.productweb.component.ProductAlternateServerComponent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//ProductServer1: 8080
@FeignClient(
        name="product-proxy",
        url = "http://localhost:8080",
        fallback = ProductAlternateServerComponent.class)
public interface ProductServiceProxy extends ProductService {
}
