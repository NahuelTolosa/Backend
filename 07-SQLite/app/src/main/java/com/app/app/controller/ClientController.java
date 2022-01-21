package com.app.app.controller;

import com.app.app.model.ClientModel;
import com.app.app.service.ClientService;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private static final Logger logger = LogManager.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;


    @GetMapping
    public List<ClientModel> getClients ( ) {
        logger.info("CONTROLLER: Obtención de cientes");
        return clientService.getClients();
    }

    @GetMapping("/client/{id}")
    public ClientModel getClient ( @PathVariable Long id) {
        logger.info("CONTROLLER: Obtención del cliente con id: "+id);
        return clientService.getClient(id);
    }

    @PostMapping
    public ClientModel createClient ( @RequestBody ClientModel c) {
        logger.info("CONTROLLER: Creacion de cliente.");
        return clientService.createClient(c);
    }

    @PutMapping(value = "/client/{id}")
    public ClientModel updateClient ( @RequestBody ClientModel c, @PathVariable Long id) {
        logger.info("CONTROLLER: Actualizacion de cliente con id: "+id);
        return clientService.updateClient(c, id);
    }

    @DeleteMapping(value = "/client/{id}")
    public void deleteClient (ClientModel c, @PathVariable Long id) {
        clientService.deleteClient(c, id);
        logger.info("CONTROLLER: Eliminación de cliente con id: "+id);
    }

}
