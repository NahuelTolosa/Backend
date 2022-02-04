package com.restaurant.api.model;

import org.springframework.data.annotation.Id;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Restaurant implements Serializable {
    @Id
    private String id;
    private String name;
    private City city;
    private Menu foodMenu;
    private Menu drinksMenu;
    private String open_hour;
    private String close_hour;
    private LocalDate date_Created;

}