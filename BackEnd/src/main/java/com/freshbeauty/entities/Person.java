package com.freshbeauty.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private Integer id;
    @Column(name="role")
    private String role;
    @Column(name="login")
    private String login;
    @Column(name="password")
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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
