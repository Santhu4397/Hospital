package com.ty.Hospital.dao;

import java.util.List;

import com.ty.Hospital.Dto.Floor;

public interface FloorDao {

	public Floor saveFloorByBuilding(int buildingId, Floor floor);

	public Floor getFloorByID(int floorId);

	public List<Floor> getAllFloorsBasedOnBuilding(int buildingId);

	public Floor updateFloorByID(int floorId, Floor floor);

	public boolean deleteFloorById(int floorId);

}
