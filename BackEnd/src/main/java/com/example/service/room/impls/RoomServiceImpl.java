package com.example.service.room.impls;
/*
 * Interface RoomServiceImpl
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.model.Room;
import com.example.repository.IClientMongoRepository;
import com.example.repository.IRoomMongoRepository;
import com.example.service.room.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    IRoomMongoRepository roomMongoRepository;


    @Override
    public Room create(Room room) {
        return roomMongoRepository.save(room);
    }

    @Override
    public Room get(String id) {

        return null;
    }

    @Override
    public Room update(Room room) {

        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Room> getAll() {
        return null;
    }
}
