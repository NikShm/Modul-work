package com.example.service.client.interfaces;
/*
 * Interface IClientService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.model.Client;

import java.util.List;

public interface IClientService {
    Client create(Client client);
    Client get(String id);

    Client update(Client client);
    void delete(String id);
    List<Client> getAll();
}
