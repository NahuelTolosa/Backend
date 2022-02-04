package com.restaurant.api.controller;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restaurant.api.model.Restaurant;
import com.restaurant.api.service.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")

public class MainController {

    @Autowired
    RestaurantService service;

    @PostMapping
    public String addRestaurant(@RequestBody Restaurant restaurant) {
        boolean isAdded = service.createRestaurant(restaurant);
        if (isAdded) {
            return "Restaurant successfully added";
        } else
            return "Unable to add Restaurant";
    }

    @PostMapping("/asMap")
    public Map<String, Restaurant> asMap(@RequestBody String restaurant) {
        try {
            return service.toMap(restaurant);
        } catch (JsonProcessingException e) {
            return null;
        }

    }

}
