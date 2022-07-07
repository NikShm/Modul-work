package com.freshbeauty.dto;

import com.freshbeauty.enums.CategoryType;

import java.math.BigDecimal;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project FreshBeauty
 * @class ProductDTO
 * @since 7/7/2022 - 08.27
 **/
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private String brandName;
    private Integer brandId;
    private BigDecimal price;
    private CategoryType category;
    private String color;
    private String volume;
    private String photoPath;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String name, String description, String brandName, Integer brandId, BigDecimal price, CategoryType category, String color, String volume, String photoPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brandName = brandName;
        this.brandId = brandId;
        this.price = price;
        this.category = category;
        this.color = color;
        this.volume = volume;
        this.photoPath = photoPath;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brandName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", volume='" + volume + '\'' +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
