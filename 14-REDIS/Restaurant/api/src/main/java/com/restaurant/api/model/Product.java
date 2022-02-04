package com.restaurant.api.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable{
    private String productName;
    private Float price;
}
