package com.spring.restapi.controllers;

import com.spring.restapi.models.Room;
import com.spring.restapi.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @Autowired
    RoomRepository RoomRepository;

    @RequestMapping(method=RequestMethod.GET, value="/rooms")
    public Iterable<Room> Room() {
        return RoomRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/rooms")
    public String save(@RequestBody Room Room) {
        RoomRepository.save(Room);

        return Room.getId();
    }

    @RequestMapping(method=RequestMethod.GET, value="/rooms/{id}")
    public Room show(@PathVariable String id) {
        return RoomRepository.findById(id).orElse(null);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/rooms/{id}")
    public Room update(@PathVariable String id, @RequestBody Room Room) {
        Room room = RoomRepository.findById(id).orElse(null);
        if(Room.getRoomName() != null)
            room.setRoomName(Room.getRoomName());
        if(Room.getRoomDesc() != null)
            room.setRoomDesc(Room.getRoomDesc());
        if(Room.getRoomImage() != null)
            room.setRoomImage(Room.getRoomImage());
        RoomRepository.save(room);
        return room;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/rooms/{id}")
    public String delete(@PathVariable String id) {
        Room Room = RoomRepository.findById(id).orElse(null);
        RoomRepository.delete(Room);

        return "room deleted";
    }
}