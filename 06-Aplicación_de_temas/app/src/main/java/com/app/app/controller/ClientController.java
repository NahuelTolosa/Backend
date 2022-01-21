package com.app.app.controller;

import com.app.app.handle.AppException;
import com.app.app.service.ClientService;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private static final Logger logger = LogManager.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String getClients() {
        logger.info("CONTROLLER: Obtención de cientes");
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public String getClient(@PathVariable Integer id) {

        logger.info("CONTROLLER: Obtención del cliente con id: "+id);
        return clientService.getClient(id);
    }

    @PostMapping
    public String createClient(@RequestParam String name, @RequestParam String surname) {
        logger.info("CONTROLLER: Creacion de cliente.");
        return clientService.createClient(name, surname);
    }

    @PutMapping(value = "/{id}")
    public String updateClient(@PathVariable Integer id, @RequestParam String name, @RequestParam String surname) throws AppException {

        if(id <= 0) {
            throw new AppException("CONTROLLER: No existe un usario con ese id");
        }else {
            logger.info("CONTROLLER: Actualizacion de cliente con id: "+id);
        }

        return clientService.updateClient(id,name,surname);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteClient(@PathVariable Integer id) {

        logger.info("CONTROLLER: Eliminación de cliente con id: "+id);
        return clientService.deleteClient(id);
    }


}
