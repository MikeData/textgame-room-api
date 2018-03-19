package com.spring.restapi.repositories;

import com.spring.restapi.models.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, String> {

    //@Override
    //Room findById(String Id);

    @Override
    void delete(Room deleted);
}
