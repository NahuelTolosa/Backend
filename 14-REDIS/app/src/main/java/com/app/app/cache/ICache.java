package com.app.app.cache;

import java.util.Map;

public interface ICache<T> {

    T findById(String key, Class<T> classValue);
    T create(String key, T data);
    void delete(T data);
    Map<String,T> bodyToMap(String data);
}
