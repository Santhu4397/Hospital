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
import com.ty.Hospital.Excipation.IdNotFound;
import com.ty.Hospital.Service.FloorService;
import com.ty.Hospital.dao.HospitalDao;
import com.ty.Hospital.util.Hospitalhelp;
import com.ty.Hospital.util.ResponseStructure;

@Service
public class FloorServiceImpl implements FloorService {

	@Autowired
	HospitalDao hospitalDao;

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> saveFloor(Floor floor, int buildingId) {
		
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> entity = null;
		List<Floor> floors = null;
		System.out.println("************************");
		Hospitalhelp hospitalhelp = hospitalDao.getByBuildingId(buildingId);
		System.out.println(hospitalhelp);
		System.out.println("1**********************1**************1");
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
					floors = building.getFloors();
					if (floors != null && building.getId() == hospitalhelp.getBranchs().getBuildings().get_id()) {
						
						floors.add(floor);
						building.setFloors(floors);

					} else if(building.getId() == hospitalhelp.getBranchs().getBuildings().get_id()){
						floors = new ArrayList<Floor>();
						floors.add(floor);
						building.setFloors(floors);
					}

				}
			}

		}

		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(hospitalDao.updateHospitalById(hospital.getId(), hospital));
		structure.setMessage("floor Saved Successfully");
		entity = new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		return entity;

	}

	@Override
	public ResponseEntity<ResponseStructure<Hospitalhelp>> getFloorById(int FloorId) {
		ResponseStructure<Hospitalhelp> structure = new ResponseStructure<Hospitalhelp>();
		Hospitalhelp hospital=hospitalDao.getHospitalByFloorId(FloorId);
		System.out.println(hospital.getBranchs().getBuildings());
		if(hospital!=null) {
			structure.setData(hospital);
			structure.setMessage("floor feached");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hospitalhelp>>(structure, HttpStatus.OK);
		}
		throw new IdNotFound(FloorId+": floor Id not found");
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Floor>>> getAllFloor(int buildingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> updateFloor(Floor floor, int FloorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteFloorById(int FloorId) {
		// TODO Auto-generated method stub
		return null;
	}


}
