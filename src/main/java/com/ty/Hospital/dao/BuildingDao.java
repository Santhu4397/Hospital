package com.ty.Hospital.dao;

import java.util.List;

import com.ty.Hospital.Dto.Building;

public interface BuildingDao {
	public Building saveBuilding(Building building, int bid);

	public Building getBuildingById(int bid);

	public List<Building> getAllBuildings();

	public Building updateBuilding(Building building, int bid);

	public boolean deleteBuildingById(int id);

}
