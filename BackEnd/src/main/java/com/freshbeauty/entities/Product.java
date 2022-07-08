package com.freshbeauty.entities;

import com.freshbeauty.enums.CategoryType;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project FreshBeauty
 * @class Product
 * @since 7/6/2022 - 19.02
 **/
@Entity
@Table(name="product")
@TypeDef(name="enum", typeClass = PostgreSQLEnumType.class)
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name", length = 128, nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="brandid", nullable = false)
    private Brand brand;

    @Column(name="price", nullable = false)
    private BigDecimal price;

    @Column(name="category", nullable = false)
    @Enumerated(EnumType.STRING)
    @Type(type="enum")
    private CategoryType category;

    @Column(name="color", nullable = false)
    private String color;

    @Column(name="volume", length = 8)
    private String volume;

    @Column(name="photopath", length = 512, nullable = false)
    private String photoPath;

    @Column(name="createdat")
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand=" + brand +
                ", price=" + price +
                ", category=" + category +
                ", color='" + color + '\'' +
                ", volume='" + volume + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", createdAt=" + createdAt +
                '}';
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
