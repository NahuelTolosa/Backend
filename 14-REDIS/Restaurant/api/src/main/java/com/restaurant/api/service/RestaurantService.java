package com.restaurant.api.service;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.api.Repository.RestaurantRepository;
import com.restaurant.api.model.Restaurant;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
@Slf4j
public class RestaurantService implements InitializingBean {

    @Autowired
    private RestaurantRepository repository;
    private ObjectMapper mapper;

    public boolean createRestaurant(Restaurant restaurant) {
        log.debug("Starting Create Method");
        try {
            String restaurantAsString = mapper.writeValueAsString(restaurant); // serializo
            log.info(restaurantAsString);
            return repository.save(restaurant);
        } catch (Exception error) {
            log.error("Error al momento de convertir a string \n" + error);
            return false;
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    }

    public Map<String, Restaurant> toMap(String restaurant) throws JsonProcessingException {
        Map<String, Restaurant> mappedRestaurant = mapper.readValue(restaurant, Map.class);
        return mappedRestaurant;
    }

}
