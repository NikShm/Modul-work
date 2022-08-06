package com.freshbeauty.dto;


import com.freshbeauty.enums.RoleType;

/*
@author Микола
@project FreshBeauty
@class UserDTO
@version 1.0.0
@since 01.08.2022 - 16.44
*/
public class UserDTO {
    private String login;
    private RoleType role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "UserDTO{" +
                "role='" + role + '\'' +
                '}';
    }
}
