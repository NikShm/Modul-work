package com.freshbeauty.services.impls;


import com.freshbeauty.dto.UserDTO;
import com.freshbeauty.entities.Person;
import com.freshbeauty.repositories.PersonRepository;
import com.freshbeauty.services.IPersonService;
import org.springframework.stereotype.Service;

/*
@author Микола
@project FreshBeauty
@class PersonServiceImpl
@version 1.0.0
@since 01.08.2022 - 16.47
*/
@Service
public class PersonServiceImpl implements IPersonService{
    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDTO checkUser(String login,String password) {
        UserDTO userDTO = new UserDTO();
        Person person = repository.findByLogin(login);
        if(person != null) {
            userDTO.setRole(person.getRole());
        }else {
            userDTO.setRole("NONE");
        }
        return userDTO;
    }
}
