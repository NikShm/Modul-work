package com.example.controller.client;

/*
 * Classname ClientRestController
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.model.Client;
import com.example.service.client.impls.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientRestController {

    @Autowired
    ClientServiceImpl service;

    @RequestMapping("/")
    List<Client> showAll(){
        return service.getAll();
    }

    @RequestMapping("/{id}")
    Client showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping("/")
    Client createOne(@RequestBody Client client) {
        return service.create(client);
    }

    @PutMapping("/")
    Client updateOne(@RequestBody Client client) {
        return service.update(client);
    }
}
