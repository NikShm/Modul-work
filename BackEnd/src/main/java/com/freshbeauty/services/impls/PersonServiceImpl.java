package com.freshbeauty.services.impls;


import com.freshbeauty.dto.UserDTO;
import com.freshbeauty.entities.Person;
import com.freshbeauty.mappers.UserMapper;
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
    private final UserMapper mapper;

    public PersonServiceImpl(PersonRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDTO checkUser(String login,String password) {
        Person person = repository.findByLoginAndPassword(login,password);
        return person == null? null: mapper.toDto(person);
    }
}
