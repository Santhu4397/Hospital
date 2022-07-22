package com.ty.Hospital.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.Dto.Branch;
import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.Dto.Floor;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Dto.Room;
import com.ty.Hospital.Excipation.IdNotFound;
import com.ty.Hospital.Service.RoomService;
import com.ty.Hospital.dao.HospitalDao;
import com.ty.Hospital.util.Hospitalhelp;
import com.ty.Hospital.util.ListBean;
import com.ty.Hospital.util.ListOfRoom;
import com.ty.Hospital.util.ResponseStructure;
@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	HospitalDao hospitalDao;

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> saveRoom(Room room, int floorId) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> entity = null;
		List<Room> rooms = null;
		Hospitalhelp hospitalhelp = hospitalDao.getHospitalByFloorId(floorId);
		Hospital hospital = hospitalDao.getByBranchId(hospitalhelp.getBranchs().get_id());
		List<Branch> branchs = hospital.getBranchs();
		ListIterator<Branch> iterator = branchs.listIterator();
		while (iterator.hasNext()) {
			Branch branch = iterator.next();

			if (branch.getId() == hospitalhelp.getBranchs().get_id()) {

				List<Building> buildings = branch.getBuildings();
				ListIterator<Building> buildingiterator = buildings.listIterator();
				while (buildingiterator.hasNext()) {
					
					Building building = buildingiterator.next();
					if(building.getId()==hospitalhelp.getBranchs().getBuildings().get_id()) {
					System.out.println(building);
					List<Floor>	floors = building.getFloors();
					ListIterator<Floor> flooriterator=floors.listIterator();
					while(flooriterator.hasNext()) {
						Floor floor=flooriterator.next();
						rooms=floor.getRooms();
						if (rooms != null && floor.getId() == hospitalhelp.getBranchs().getBuildings().getFloors().get_id()) {

							rooms.add(room);
							floor.setRooms(rooms);

						} else if(floor.getId() == hospitalhelp.getBranchs().getBuildings().getFloors().get_id()){
							rooms = new ArrayList<Room>();
							rooms.add(room);
							floor.setRooms(rooms);
						}
					}
					}

				}
			}

		}

		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(hospitalDao.updateHospitalById(hospital.getId(), hospital));
		structure.setMessage("Room Saved Successfully");
		entity = new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		return entity;

	}

	@Override
	public ResponseEntity<ResponseStructure<Hospitalhelp>> getRoomById(int roomId) {
		ResponseStructure<Hospitalhelp> structure = new ResponseStructure<Hospitalhelp>();
		Hospitalhelp hospital=hospitalDao.getHospitalByRoomId(roomId);
		if(hospital!=null) {
			structure.setData(hospital);
			structure.setMessage("floor feached");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hospitalhelp>>(structure, HttpStatus.OK);
		}
		throw new IdNotFound(roomId+": floor Id not found");
	}

	@Override
	public ResponseEntity<ResponseStructure<ListOfRoom>> getAllRoomByFloorId(int floorID) {
		ResponseStructure<ListOfRoom> structure = new ResponseStructure<ListOfRoom>();
		ListOfRoom rooms=hospitalDao.getListOfRoomsByFloorId(floorID);
		System.out.println(rooms+"632444444444445");
		if(rooms!=null) {
			structure.setData(rooms);
			structure.setMessage("Rooms feached");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<ListOfRoom>>(structure, HttpStatus.OK);
		}
		throw new IdNotFound(floorID+": floor Id not found");
	}

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> updateRoom(Room room, int roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteRoomById(int roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
