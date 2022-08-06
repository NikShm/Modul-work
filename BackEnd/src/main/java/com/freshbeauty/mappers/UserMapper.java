package com.freshbeauty.mappers;
import com.freshbeauty.dto.UserDTO;
import com.freshbeauty.entities.Person;
import org.springframework.stereotype.Component;



/*
@author Микола
@project FreshBeauty
@class UserMapper
@version 1.0.0
@since 03.08.2022 - 15.19
*/
@Component
public class UserMapper {

    public UserDTO toDto(Person entity) {
        UserDTO dto = new UserDTO();
        dto.setRole(entity.getRole());
        dto.setLogin(entity.getLogin());
        return dto;
    }
}
