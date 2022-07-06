package com.freshbeauty.controllers;

import com.freshbeauty.entities.Brand;

/*
@author Микола
@project AngularTest
@class BrandDTO
@version 1.0.0
@since 04.07.2022 - 17.04
*/
public class BrandDTO {
    private Integer id;
    private String name;
    private String myName;

    public BrandDTO() {
    }

    public BrandDTO(Brand brand) {
        id = brand.getId();
        name = brand.getName();
    }

    public Brand toEntity() {
        Brand brand = new Brand();
        brand.setId(id);
        brand.setName(name);
        return brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }
}
