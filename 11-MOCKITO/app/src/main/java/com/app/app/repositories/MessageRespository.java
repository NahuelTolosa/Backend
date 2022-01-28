package com.app.app.repositories;

import com.app.app.models.MessageModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface MessageRespository extends MongoRepository<MessageModel, Serializable> {
    public MessageModel findByName(String name);
}
