package com.example.service.room.interfaces;
/*
 * Interface IRoomService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.model.Room;

import java.util.List;

public interface IRoomService {
    Room create(Room room);
    Room get(String id);
    Room update(Room room);
    void delete(String id);
    List<Room> getAll();
}
