package com.example.model;

/*
  @author emilia
  @project java_12
  @className Settlement
  @version 1.0.0
  @since 19.04.2022.22.26
*/

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document
public class Settlement {
  @Id
  private String id;
  private String name;
  private String description;
  private Client clientNum;
  private Room roomNumber;
  private LocalDate settlement;
  private LocalDate release;
  private String comments;

  public Settlement() {
  }

  public Settlement(String name, String description, Client clientNum, Room roomNumber, LocalDate settlement, LocalDate release, String comments) {
    this.name = name;
    this.description = description;
    this.clientNum = clientNum;
    this.roomNumber = roomNumber;
    this.settlement = settlement;
    this.release = release;
    this.comments = comments;
  }

  public Settlement(String id, String name, String description, Client clientNum, Room roomNumber, LocalDate settlement, LocalDate release, String comments) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.clientNum = clientNum;
    this.roomNumber = roomNumber;
    this.settlement = settlement;
    this.release = release;
    this.comments = comments;
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

  public Client getClientId() {
    return clientNum;
  }

  public void setClientId(Client clientNum) {
    this.clientNum = clientNum;
  }

  public Room getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(Room roomNumber) {
    this.roomNumber = roomNumber;
  }

  public LocalDate getSettlement() {
    return settlement;
  }

  public void setSettlement(LocalDate settlement) {
    this.settlement = settlement;
  }

  public LocalDate getRelease() {
    return release;
  }

  public void setRelease(LocalDate release) {
    this.release = release;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Settlement that = (Settlement) o;
    return Objects.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "Settlement{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", clientNum=" + clientNum +
            ", roomNumber=" + roomNumber +
            ", settlement=" + settlement +
            ", release=" + release +
            ", comments='" + comments + '\'' +
            '}';
  }
}
