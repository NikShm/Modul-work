package com.freshbeauty.dto;

/*
@author Микола
@project FreshBeauty
@class BrandDTO
@version 1.0.0
@since 04.07.2022 - 17.04
*/
public class BrandDTO {
    private Integer id;
    private String name;

    public BrandDTO() {
    }

    public BrandDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "BrandDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
