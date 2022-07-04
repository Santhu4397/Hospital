package com.ty.Hospital.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.Repo.BuildingRepo;
import com.ty.Hospital.dao.BuildingDao;

@Repository
public class BuildingDaoImpl implements BuildingDao {
	
	@Autowired
	private BuildingRepo repo;

	@Override
	public Building saveBuilding(Building building, int bid) {
		return repo.save(building); 
	}

	@Override
	public Building getBuildingById(int bid) {
		Optional<Building> building = repo.findById(bid);
		if(building.isPresent()) {
			return building.get();
		} else {
			return null;
		}
		
	}

	@Override
	public List<Building> getAllBuildings() {
		return repo.findAll();
	}

	@Override
	public Building updateBuilding(Building building, int bid) {
		Building exsiting=getBuildingById(bid);
		if(exsiting!=null) {
		//	exsiting.setBranch(building.getBranch());
			exsiting.setBuilding_Name(building.getBuilding_Name());
			exsiting.setFacilities(building.getFacilities());
			exsiting.setFloors(building.getFloors());
			exsiting.setUser(building.getUser());
			return repo.save(exsiting);
		}
		return null;
	}

	@Override
	public boolean deleteBuildingById(int id) {
		 Building building = getBuildingById(id);
		 if(building!=null) {
			 return true;
		 } else {
			 return false;
		 }
	}

}
