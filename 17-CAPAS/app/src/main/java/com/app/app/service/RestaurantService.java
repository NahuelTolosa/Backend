package com.app.app.service;

import com.app.app.model.RestaurantModel;
import com.app.app.repository.RestaurantRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final ObjectMapper mapper;

    public List<RestaurantModel> findAll() {
        return this.restaurantRepository.findAll();
    }

    public RestaurantModel createRestaurant(RestaurantModel restaurant){
        try {
            mappingToString(restaurant);
            mappingToClass(restaurant);
            mappingToMap(restaurant);
            return this.restaurantRepository.save(restaurant);
        } catch (JsonProcessingException e) {

        }
        return restaurant;
    }

    public Map<String, RestaurantModel> restaurantToMap(String restaurant) throws JsonProcessingException {
        return mappingStringToMap(restaurant);
    }

    private void mappingToString(RestaurantModel Restaurant) throws JsonProcessingException {
        String RestaurantString = mapper.writeValueAsString(Restaurant);
    }

    private Map<String, RestaurantModel> mappingToMap(RestaurantModel Restaurant) throws JsonProcessingException {
        String RestaurantString = mapper.writeValueAsString(Restaurant);
        Map<String, RestaurantModel> RestaurantMap = mapper.readValue(RestaurantString, Map.class);
        return RestaurantMap;
    }

    private Map<String, RestaurantModel> mappingStringToMap(String Restaurant) throws JsonProcessingException {
        Map<String, RestaurantModel> RestaurantMap = mapper.readValue(Restaurant, Map.class);
        return RestaurantMap;
    }

    private void mappingToClass(RestaurantModel Restaurant) throws JsonProcessingException {
        String RestaurantString = mapper.writeValueAsString(Restaurant);
        var RestaurantClass = mapper.readValue(RestaurantString, RestaurantModel.class);
    }


}
