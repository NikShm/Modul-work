package com.example.model;

/*
  @author emilia
  @project java_12
  @className Rooms
  @version 1.0.0
  @since 19.04.2022.22.30
*/

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Room {
  @Id
  private String id;
  private String name;
  private String description;
  private Client clientNum;
  private int room;
  private int numOfPeople;
  private ComfortLevel comfortLevel;
  private int price;


  public Room() {
  }

  public Room(String name, String description, Client clientNum, int room, int numOfPeople, ComfortLevel comfortLevel, int price) {
    this.name = name;
    this.description = description;
    this.clientNum = clientNum;
    this.room = room;
    this.numOfPeople = numOfPeople;
    this.comfortLevel = comfortLevel;
    this.price = price;
  }

  public Room(String id, String name, String description, Client clientNum, int room, int numOfPeople, ComfortLevel comfortLevel, int price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.clientNum = clientNum;
    this.room = room;
    this.numOfPeople = numOfPeople;
    this.comfortLevel = comfortLevel;
    this.price = price;
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

  public Client getClientNum() {
    return clientNum;
  }

  public void setClientId(Client clientId) {
    this.clientNum = clientNum;
  }

  public int getRoom() {
    return room;
  }

  public void setRoom(int room) {
    this.room = room;
  }

  public int getNumOfPeople() {
    return numOfPeople;
  }

  public void setNumOfPeople(int numOfPeople) {
    this.numOfPeople = numOfPeople;
  }

  public ComfortLevel getComfortLevel() {
    return comfortLevel;
  }

  public void setComfortLevel(ComfortLevel comfortLevel) {
    this.comfortLevel = comfortLevel;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Room rooms = (Room) o;
    return Objects.equals(getId(), rooms.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "Rooms{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", clientNum=" + clientNum +
            ", room=" + room +
            ", numOfPeople=" + numOfPeople +
            ", comfortLevel=" + comfortLevel +
            ", price=" + price +
            '}';
  }
}
