package com.restaurant.api.model;


import java.io.Serializable;

import lombok.Data;

@Data
public class City implements Serializable{
    private String cityName;
    private String country;


}
