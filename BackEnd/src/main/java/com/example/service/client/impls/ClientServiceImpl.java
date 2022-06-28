package com.example.service.client.impls;

/*
 * Interface ClientServiceImpl
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.model.Client;
import com.example.repository.IClientMongoRepository;
import com.example.service.client.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    List<Client> list = new ArrayList<>(
            Arrays.asList(
                    new Client("1", "Stepan Bandera", "VIP Client", "380101010101","Stepan", "Bandera", "Androyovich", "UKR; M", null),
                    new Client("2", "Viacheslav Chornovil", "VIP Client", "380202020202","Viacheslav", "Chornovil", "Maksymovych", "UKR; M", null),
                    new Client("3", "Roman Shukhevych", "VIP Client", "380303030303","Roman", "Shukhevych", "Yosypovych", "UKR; M", null)
            )
    );

    @Autowired
    IClientMongoRepository clientMongoRepository;

    @PostConstruct
    void init(){
        clientMongoRepository.saveAll(list);
    }

    @Override
    public Client create(Client client) {
        return clientMongoRepository.save(client);
    }

    @Override
    public Client get(String id) {
        return clientMongoRepository.findById(id).orElse(null);
    }

    @Override
    public Client update(Client client) {
        return clientMongoRepository.save(client);
    }

    @Override
    public void delete(String id) {

        clientMongoRepository.deleteById(id);
    }


    @Override
    public List<Client> getAll() {
        return
                clientMongoRepository.findAll();
    }
}
