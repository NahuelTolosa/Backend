package com.app.app.service;

import com.app.app.annotation.ServiceMethodAnnotation;
import com.app.app.model.ClientModel;
import com.app.app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService implements Client {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientModel createClient(ClientModel c) {
        return clientRepository.save(c);
    }

    @Override
    public List<ClientModel> getClients() {
        List<ClientModel> clients =  new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    @Override
    public ClientModel getClient(Long id) {
        return clientRepository.findById(id).get();
    }

    @ServiceMethodAnnotation
    @Override
    public ClientModel updateClient(ClientModel c, Long id) {
        c.setId(id);
        return clientRepository.save(c);
    }

    @ServiceMethodAnnotation
    @Override
    public void deleteClient(ClientModel c, Long id) {
        c.setId(id);
        clientRepository.delete(c);
    }
}
