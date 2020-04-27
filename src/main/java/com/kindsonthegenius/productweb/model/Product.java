package com.kindsonthegenius.productweb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {

    @Id
    private String productId;
    private String name;
    private String code;;
    private String title;
    private String description;
    private String imgUrl;
    private Double price;
    private String productCategoryName;

    public Product(){

    }
}
