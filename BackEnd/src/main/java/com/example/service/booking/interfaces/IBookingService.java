package com.example.service.booking.interfaces;
/*
 * Interface IClientService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.model.Booking;

import java.util.List;

public interface IBookingService {
    Booking create(Booking booking);
    Booking get(String id);
    Booking update(Booking booking);
    void delete(String id);
    List<Booking> getAll();
}
