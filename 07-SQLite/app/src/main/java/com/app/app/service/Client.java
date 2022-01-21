package com.app.app.service;

import com.app.app.model.ClientModel;

import java.util.List;

public interface Client {
    ClientModel createClient(ClientModel c);
    List<ClientModel> getClients();
    ClientModel getClient(Long id);
    ClientModel updateClient(ClientModel c, Long id);
    void deleteClient(ClientModel c, Long id);
}
