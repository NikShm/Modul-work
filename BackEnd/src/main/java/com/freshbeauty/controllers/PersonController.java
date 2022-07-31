package com.freshbeauty.controllers;

import com.freshbeauty.dto.UserDTO;
import com.freshbeauty.services.impls.PersonServiceImpl;
import org.springframework.web.bind.annotation.*;

/*
@author Микола
@project FreshBeauty
@class PersonController
@version 1.0.0
@since 01.08.2022 - 16.59
*/
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/user", produces = "application/json")
public class PersonController {
    private final PersonServiceImpl service;

    public PersonController(PersonServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/login={login}/password={password}")
    public UserDTO getRole(@PathVariable String login,@PathVariable String password){
        return service.checkUser(login,password);
    }
}
