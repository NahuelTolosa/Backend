package com.app.app.cache;

import com.app.app.utils.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Map;

@RequiredArgsConstructor
public class Cache<T> implements ICache<T> {

    private final RedisTemplate<String,T> redisTemplate;
    private HashOperations<String,String,String> hashOperations;
    private final ObjectMapper objectMapper;

    @PostConstruct
    void setHashOperations() {
        hashOperations = this.redisTemplate.opsForHash();
        this.redisTemplate.expire(Constants.NAME_MAP_RESTAURANT, Duration.ofMillis(60000));
    }

    @Override //CREATE
    public T create(String key, T data) {
        try {
            hashOperations.put(Constants.NAME_MAP_RESTAURANT, key, serializeItem(data));
            return data;
        } catch (JsonProcessingException e) { }
        return data;
    }

    @Override //READ
    public T findById(String key, Class<T> classValue) {
        try {
            var item = hashOperations.get(Constants.NAME_MAP_RESTAURANT, key);
            if (item == null) return null;
            return deserializeItem(item, classValue);
        } catch (JsonProcessingException e) { }
        return null;
    }

    @Override
    public void delete(T data) {

    }

    @Override
    public Map<String, T> bodyToMap(String data) {
        return null;
    }

    private String serializeItem(T item) throws JsonProcessingException {
        var serializeItem = objectMapper.writeValueAsString(item);
        return serializeItem;
    }

    private T deserializeItem(String jsonInput, Class<T> classValue) throws JsonProcessingException {
        return objectMapper.readValue(jsonInput, classValue);
    }
}
