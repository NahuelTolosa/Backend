package com.app.app.controller;

import com.app.app.model.RestaurantModel;
import com.app.app.service.RestaurantService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public List<RestaurantModel> findAll() {
        return this.restaurantService.findAll();
    }

    @PostMapping
    public RestaurantModel createRestaurant(@RequestBody RestaurantModel r) {
        return this.restaurantService.createRestaurant(r);
    }

    @PostMapping(path = "/map")
    private Map<String, RestaurantModel> restauranteMap(@RequestBody String restaurant) throws JsonProcessingException {
        return restaurantService.restaurantToMap(restaurant);
    }

}
