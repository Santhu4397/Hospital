package com.ty.Hospital.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.Dto.Bed;
import com.ty.Hospital.Dto.Branch;
import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.Dto.Floor;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Dto.Room;
import com.ty.Hospital.Service.BedService;
import com.ty.Hospital.dao.HospitalDao;
import com.ty.Hospital.util.Hospitalhelp;
import com.ty.Hospital.util.ResponseStructure;
@Service
public class BedServiceImpl implements BedService {

	@Autowired
	HospitalDao hospitalDao;

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> saveBed(Bed bed, int roomId) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> entity = null;
		List<Bed> beds = null;
		Hospitalhelp hospitalhelp = hospitalDao.getHospitalByRoomId(roomId);
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
					List<Floor> floors = building.getFloors();
					ListIterator<Floor> flooriterator = floors.listIterator();
					while (flooriterator.hasNext()) {
						Floor floor = flooriterator.next();
						List<Room> rooms = floor.getRooms();
						ListIterator<Room> roomiterator = rooms.listIterator();
						while (roomiterator.hasNext()) {
							Room room = roomiterator.next();
							beds = room.getBed();
							if (beds != null && room.getId() == hospitalhelp.getBranchs().getBuildings().getFloors()
									.getRooms().get_id()) {

								beds.add(bed);
								room.setBed(beds);

							} else if (room.getId() == hospitalhelp.getBranchs().getBuildings().getFloors().getRooms()
									.get_id()) {
								beds = new ArrayList<Bed>();
								beds.add(bed);
								room.setBed(beds);
							}
						}
					}

				}
			}

		}

		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(hospitalDao.updateHospitalById(hospital.getId(), hospital));
		structure.setMessage("Bed Saved Successfully");
		entity = new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		return entity;

	}

	@Override
	public ResponseEntity<ResponseStructure<Hospitalhelp>> getBedById(int bedId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Floor>>> getAllBed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> updateBed(Bed bed, int bedId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteBedById(int bedId) {
		// TODO Auto-generated method stub
		return null;
	}

}
