package com.ty.Hospital.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.Dto.Facility;
import com.ty.Hospital.Repo.FacilityRepo;
import com.ty.Hospital.dao.BuildingDao;
import com.ty.Hospital.dao.FacilityDao;

public class FacilityDaoImpl implements FacilityDao {

	@Autowired
	private BuildingDao buildingDao;

	@Autowired
	private FacilityRepo repo2;

	@Override
	public Facility saveFacility(Facility facility, int buildingId) {
		Building building = buildingDao.getBuildingById(buildingId);
		facility.setBuilding(building);
		return repo2.save(facility);
	}

	@Override
	public Facility getFacilityById(int facilityId) {
		Optional<Facility> facility = repo2.findById(facilityId);
		if (facility.isPresent()) {
			return facility.get();
		}
		return null;
	}

	@Override
	public List<Facility> getAllFacilitys() {
		List<Facility> facilities = repo2.findAll();
		if (facilities.isEmpty()) {
			return null;
		} else {
			return facilities;
		}
	}

	@Override
	public Facility updateFacility(Facility facility, int facilityId) {
		Facility facility2 = getFacilityById(facilityId);
		if (facility2 != null) {
			facility2.setId(facility.getId());
			facility2.setCost(facility.getCost());
			facility2.setUser(facility.getUser());
			facility2.setBuilding(facility.getBuilding());
			facility2.setDiagnosticType(facility.getDiagnosticType());
			return repo2.save(facility2);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteFacilityById(int facilityId) {
		Facility facility = getFacilityById(facilityId);
		if (facility != null) {
			repo2.delete(facility);
			return true;
		} else {
			return false;
		}
	}

}
