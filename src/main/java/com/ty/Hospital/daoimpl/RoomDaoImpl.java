package com.ty.Hospital.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.Dto.Room;
import com.ty.Hospital.Repo.RoomRepo;
import com.ty.Hospital.dao.RoomDao;
@Repository
public class RoomDaoImpl implements RoomDao {
	@Autowired
	private RoomRepo repo;

	@Override
	public Room saveRoom(Room room) {
		return repo.save(room);
	}

	@Override
	public List<Room> getAllRoomByFloorId(int floorID) {
		return repo.findAll();
	}

	@Override
	public Room updatRoom(Room room, int rid) {
		Room exsiting = getById(rid);
		if (exsiting != null) {
			
			exsiting.setFloor(room.getFloor());
			exsiting.setRoomNumber(room.getRoomNumber());
			exsiting.setType(room.getType());
		}
		return null;
	}

	@Override
	public Room getById(int rid) {
		 Optional<Room> optional=repo.findById(rid);
		 if(optional.isPresent()) {
			return optional.get();
		 }
		 return null;
	}

	@Override
	public boolean deleteRoom(int rid) {
		Room room=getById(rid);
		if(room!=null) {
			repo.delete(room);
			return true;
		}
		return false;
	}

}
