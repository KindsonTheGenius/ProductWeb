package com.kindsonthegenius.productweb.client;

import com.kindsonthegenius.productweb.api.ProductService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value="product-proxy", url = "http://localhost:8080")
public interface ProductServiceProxy extends ProductService {
}
