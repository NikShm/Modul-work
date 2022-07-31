package com.freshbeauty.dto;


/*
@author Микола
@project FreshBeauty
@class UserDTO
@version 1.0.0
@since 01.08.2022 - 16.44
*/
public class UserDTO {
    private String role;

    @Override
    public String toString() {
        return "UserDTO{" +
                "role='" + role + '\'' +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
