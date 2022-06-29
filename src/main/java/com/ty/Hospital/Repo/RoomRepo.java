package com.ty.Hospital.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ty.Hospital.Dto.Room;

public interface RoomRepo extends MongoRepository<Room, Integer> {

}
