package com.ty.Hospital.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.Dto.Floor;
import com.ty.Hospital.Repo.FloorRepository;
import com.ty.Hospital.dao.BuildingDao;
import com.ty.Hospital.dao.FloorDao;
@Repository
public class FloorDaoImpl implements FloorDao {

	@Autowired
	public FloorRepository floorRepository;

	@Autowired
	public BuildingDao buildingDao;

	@Override
	public Floor saveFloorByBuilding(int buildingId, Floor floor) {
//		Building building = buildingDao.getBuildingById(buildingId);
//		floor.setBuilding(building);
		return floorRepository.save(floor);
	}

	@Override
	public Floor getFloorByID(int floorId) {
		Optional<Floor> floor = floorRepository.findById(floorId);
		if (floor.isPresent()) {
			return floor.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Floor> getAllFloorsBasedOnBuilding(int buildingId) {
		Building building = buildingDao.getBuildingById(buildingId);
		return building.getFloors();
	}

	@Override
	public Floor updateFloorByID(int floorId, Floor floor) {
		Floor existingFloor = getFloorByID(floorId);
		if (existingFloor != null) {
			existingFloor.setFloorNumber(floor.getFloorNumber());
			existingFloor.setType(floor.getType());
			return floorRepository.save(existingFloor);
		}
		return null;
	}

	@Override
	public boolean deleteFloorById(int floorId) {
		Floor floor = getFloorByID(floorId);
		if (floor != null) {
			floorRepository.delete(floor);
			return true;
		}
		return false;
	}

}
