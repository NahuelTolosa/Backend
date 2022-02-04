package com.app.app.service;

import com.app.app.cache.Cache;
import com.app.app.model.RestaurantModel;
import com.app.app.repository.RestaurantRepositoryMongoDB;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final Cache<RestaurantModel> cache;

    private final RestaurantRepositoryMongoDB restaurantMongoDB;
    private final ObjectMapper mapper;

    //CREATE
    public RestaurantModel createRestaurant(RestaurantModel restaurant){
        try {
            var data = restaurantMongoDB.save(restaurant); //lo almacena en la DB
            return saveRestaurantInCache(restaurant);//Lo almacena en caché y lo retorna
        } catch (JsonProcessingException e) { }

        return restaurant;
    }

    //READ
    public List<RestaurantModel> findAll() {
        return this.restaurantMongoDB.findAll();//Lee de la DB
    }

    //READ
    public RestaurantModel findById(String id) {
        try {

            //Busca en la caché
            var dataFromCache = cache.findById(id, RestaurantModel.class);
            if (!Objects.isNull(dataFromCache)) return dataFromCache;

            //Si no encuentra, busca en la DB
            var dataFromDatabase = restaurantMongoDB.findById(id).orElseThrow(null);
            return saveRestaurantInCache(dataFromDatabase); //Si lo encunetra, lo almacena en caché y lo retorna

        } catch (JsonProcessingException e) { }

        return null;

    }


    //AUX
    private RestaurantModel saveRestaurantInCache(RestaurantModel restaurant) throws JsonProcessingException {
        return cache.create(restaurant.getId(), restaurant);
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
