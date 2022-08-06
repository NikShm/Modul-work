package com.freshbeauty.entities;


import com.freshbeauty.dto.UserDTO;
import com.freshbeauty.enums.RoleType;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/*
@author Микола
@project FreshBeauty
@class Person
@version 1.0.0
@since 01.08.2022 - 16.35
*/
@Entity
@Table(name="person")
public class Person {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="role", nullable = false)
    @Enumerated(EnumType.STRING)
    @Type(type = "enum")
    private RoleType role;
    @Column(name="login", length = 128, nullable = false)
    private String login;
    @Column(name="password", length = 32, nullable = false)
    private String password;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
