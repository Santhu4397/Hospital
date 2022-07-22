package com.ty.Hospital.dao;

import java.util.List;

import com.ty.Hospital.Dto.Room;

public interface RoomDao {

	public Room saveRoom(Room room);

	public List<Room> getAllRoomByFloorId(int floorId);

	public Room updatRoom(Room room, int rid);

	public Room getById(int rid);

	public boolean deleteRoom(int rid);

}
