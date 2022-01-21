package com.app.app.service;

import com.app.app.annotation.ServiceMethodAnnotation;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public String createClient(String name, String surname) {
        return "Cliente creado";
    }

    public String getClients() {
        return "Listado de clientes";
    }

    public String getClient(Integer id) {
        return "Cliente con id: "+id;
    }

    @ServiceMethodAnnotation
    public String updateClient(Integer id, String name, String surname) {
        return "Cliente con id: "+id+" actualizado.";
    }

    @ServiceMethodAnnotation
    public String deleteClient(Integer id) {
        return "Cliente con id: "+id+" borrado.";
    }
}
