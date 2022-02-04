package com.restaurant.api.Repository;

import com.restaurant.api.model.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean save(Restaurant restaurant) {
        this.redisTemplate.opsForHash().put("restaurant", restaurant.getId(), restaurant);
        return true;
    }

}
