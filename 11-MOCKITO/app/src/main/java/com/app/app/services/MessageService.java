package com.app.app.services;

import com.app.app.models.MessageModel;
import com.app.app.repositories.MessageRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRespository messageRespository;

    public List<MessageModel> findAll() {
        return messageRespository.findAll();
    }

    public MessageModel createMessage (MessageModel m) {
        return messageRespository.save(m);
    }

    public void deleteMessage(String name) {
        messageRespository.deleteById(messageRespository.findByName(name).getId());
    }

    public MessageModel findByName (String name) {
        return messageRespository.findByName(name);
    }
}
