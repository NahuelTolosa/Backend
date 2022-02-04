package com.restaurant.api.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Menu implements Serializable{
    private Product[] products;

}
