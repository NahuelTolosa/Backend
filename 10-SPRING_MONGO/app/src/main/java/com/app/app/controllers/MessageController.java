package com.app.app.controllers;

import com.app.app.models.MessageModel;
import com.app.app.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce")
public class MessageController{

    private static final Logger logger = LogManager.getLogger(MessageController.class);

    @Autowired
    MessageService messageService;

    @GetMapping("/messages")
    public List<MessageModel> findAll() {
        logger.info("CONTROLLER: Solicitud de listado de documentos");
        return messageService.findAll();
    }

    @PostMapping("/messages")
    public MessageModel createMessage(@RequestBody MessageModel m) {
        logger.info("CONTROLLER: Creación de un nuevo documento");
        return messageService.createMessage(m);
    }

    @DeleteMapping("/messages")
    public void deleteMessage (@RequestParam String name) {
        messageService.deleteMessage(name);
        logger.info("CONTROLLER: Eliminación de documento");
    }
}
