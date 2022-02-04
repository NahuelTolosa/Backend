package com.app.app.repository;

import com.app.app.model.RestaurantModel;
import org.springframework.data.redis.core.RedisTemplate;

public class RestaurantRepository {

    private RedisTemplate<String, RestaurantModel> redisTemplate;

}
