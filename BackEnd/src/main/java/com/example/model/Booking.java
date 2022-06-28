package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.time.LocalDateTime;
import java.util.Objects;

/*
  @author emilia
  @project java_12
  @className Booking
  @version 1.0.0
  @since 19.04.2022.22.38
*/

@Document
public class Booking {

  @Id
  private String id;
  private String name;
  private String description;
  private int bookingId;
  private Client clientNum;
  private Room room;
  private LocalDateTime bookingDate;
  private LocalDateTime settlementDate;
  private LocalDateTime evictionDate;

  public Booking() {
  }

  public Booking(String name, String description, int bookingId, Client clientNum, Room room, LocalDateTime bookingDate, LocalDateTime settlementDate, LocalDateTime evictionDate) {
    this.name = name;
    this.description = description;
    this.bookingId = bookingId;
    this.clientNum = clientNum;
    this.room = room;
    this.bookingDate = bookingDate;
    this.settlementDate = settlementDate;
    this.evictionDate = evictionDate;
  }

  public Booking(String id, String name, String description, int bookingId, Client clientNum, Room room, LocalDateTime bookingDate, LocalDateTime settlementDate, LocalDateTime evictionDate) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.bookingId = bookingId;
    this.clientNum = clientNum;
    this.room = room;
    this.bookingDate = bookingDate;
    this.settlementDate = settlementDate;
    this.evictionDate = evictionDate;
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

  public int getBookingId() {
    return bookingId;
  }

  public void setBookingId(int bookingId) {
    this.bookingId = bookingId;
  }

  public Client getClientId() {
    return clientNum;
  }

  public void setClientId(Client clientId) {
    this.clientNum = clientId;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public LocalDateTime getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(LocalDateTime bookingDate) {
    this.bookingDate = bookingDate;
  }

  public LocalDateTime getSettlementDate() {
    return settlementDate;
  }

  public void setSettlementDate(LocalDateTime settlementDate) {
    this.settlementDate = settlementDate;
  }

  public LocalDateTime getEvictionDate() {
    return evictionDate;
  }

  public void setEvictionDate(LocalDateTime evictionDate) {
    this.evictionDate = evictionDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Booking booking = (Booking) o;
    return Objects.equals(getId(), booking.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "Booking{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", bookingId=" + bookingId +
            ", clientNum=" + clientNum +
            ", room=" + room +
            ", bookingDate=" + bookingDate +
            ", settlementDate=" + settlementDate +
            ", evictionDate=" + evictionDate +
            '}';
  }
}
