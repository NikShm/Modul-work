package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/*
  @author emilia
  @project java_12
  @className Discount
  @version 1.0.0
  @since 19.04.2022.22.54
*/
@Document
public class Discount {
  @Id
  private String id;
  private String name;
  private String description;
  private int discount;
  private String discountName;
  private int discountValue;

  private DiscountType discountTypes;

  public Discount() {
  }

  public Discount(String name, String description, int discount, String discountName, int discountValue, DiscountType discountTypes) {
    this.name = name;
    this.description = description;
    this.discount = discount;
    this.discountName = discountName;
    this.discountValue = discountValue;
    this.discountTypes = discountTypes;
  }

  public Discount(String id, String name, String description, int discount, String discountName, int discountValue, DiscountType discountTypes) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.discount = discount;
    this.discountName = discountName;
    this.discountValue = discountValue;
    this.discountTypes = discountTypes;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public int getDiscount() {
    return discount;
  }

  public void setDiscount(int discount) {
    this.discount = discount;
  }

  public String getDiscountName() {
    return discountName;
  }

  public void setDiscountName(String discountName) {
    this.discountName = discountName;
  }

  public int getDiscountValue() {
    return discountValue;
  }

  public void setDiscountValue(int discountValue) {
    this.discountValue = discountValue;
  }

  public DiscountType getDiscountTypes() {
    return discountTypes;
  }

  public void setDiscountTypes(DiscountType discountTypes) {
    this.discountTypes = discountTypes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Discount discount = (Discount) o;
    return Objects.equals(getId(), discount.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "Discount{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", discount=" + discount +
            ", discountName='" + discountName + '\'' +
            ", discountValue=" + discountValue +
            ", discountTypes=" + discountTypes +
            '}';
  }
}
