package com.ty.Hospital.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.Hospital.Dto.Floor;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Dto.Room;
import com.ty.Hospital.util.Hospitalhelp;
import com.ty.Hospital.util.ListBean;
import com.ty.Hospital.util.ListOfRoom;
import com.ty.Hospital.util.ResponseStructure;

public interface RoomService {
	
	public ResponseEntity<ResponseStructure<Hospital>> saveRoom(Room room, int floorId);

	public ResponseEntity<ResponseStructure<Hospitalhelp>> getRoomById(int roomId);

	public ResponseEntity<ResponseStructure<ListOfRoom>> getAllRoomByFloorId(int floorID);

	public ResponseEntity<ResponseStructure<Hospital>> updateRoom(Room room, int roomId);

	public ResponseEntity<ResponseStructure<String>> deleteRoomById(int roomId);
}
