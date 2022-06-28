package com.example.service.booking.impls;
/*
 * Interface BookingServiceImpl
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.model.Booking;
import com.example.service.booking.interfaces.IBookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements IBookingService {
    @Override
    public Booking create(Booking booking) {
        return null;
    }

    @Override
    public Booking get(String id) {
        return null;
    }

    @Override
    public Booking update(Booking booking) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Booking> getAll() {
        return null;
    }
}
