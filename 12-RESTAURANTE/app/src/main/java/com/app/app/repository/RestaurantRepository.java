package com.app.app.repository;

import com.app.app.model.RestaurantModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface RestaurantRepository extends MongoRepository<RestaurantModel, Serializable> { }
