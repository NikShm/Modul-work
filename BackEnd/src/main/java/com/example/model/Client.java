package com.example.model;

/*
  @author emilia
  @project java_12
  @className Clients
  @version 1.0.0
  @since 19.04.2022.22.20
*/

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class Client {
  @Id
  private String id;
  private String name;
  private String description;
  private String clientNum;
  private String clientName;
  private String clientSurname;
  private String clientMiddleName;
  private String clientPassportData;
  private DiscountType discount;

  public Client() {
  }

  public Client(String name, String description, String clientNum, String clientName, String clientSurname, String clientMiddleName, String clientPassportData, DiscountType discount) {
    this.name = name;
    this.description = description;
    this.clientNum = clientNum;
    this.clientName = clientName;
    this.clientSurname = clientSurname;
    this.clientMiddleName = clientMiddleName;
    this.clientPassportData = clientPassportData;
    this.discount = discount;
  }

  public Client(String id, String name, String description, String clientNum, String clientName, String clientSurname, String clientMiddleName, String clientPassportData, DiscountType discount) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.clientNum = clientNum;
    this.clientName = clientName;
    this.clientSurname = clientSurname;
    this.clientMiddleName = clientMiddleName;
    this.clientPassportData = clientPassportData;
    this.discount = discount;
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

  public String getClientNum() {
    return clientNum;
  }

  public void setClientNum(String clientNum) {
    this.clientNum = clientNum;
  }

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public String getClientSurname() {
    return clientSurname;
  }

  public void setClientSurname(String clientSurname) {
    this.clientSurname = clientSurname;
  }

  public String getClientMiddleName() {
    return clientMiddleName;
  }

  public void setClientMiddleName(String clientMiddleName) {
    this.clientMiddleName = clientMiddleName;
  }

  public String getClientPassportData() {
    return clientPassportData;
  }

  public void setClientPassportData(String clientPassportData) {
    this.clientPassportData = clientPassportData;
  }

  public DiscountType getDiscount() {
    return discount;
  }

  public void setDiscount(DiscountType discount) {
    this.discount = discount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Client clients = (Client) o;
    return Objects.equals(getId(), clients.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "Clients{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", clientNum='" + clientNum + '\'' +
            ", clientName='" + clientName + '\'' +
            ", clientSurname='" + clientSurname + '\'' +
            ", clientMiddleName='" + clientMiddleName + '\'' +
            ", clientPassportData='" + clientPassportData + '\'' +
            ", discounts=" + discount +
            '}';
  }
}
