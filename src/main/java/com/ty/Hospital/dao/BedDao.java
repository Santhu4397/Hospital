package com.ty.Hospital.dao;

import java.util.List;

import com.ty.Hospital.Dto.Bed;

public interface BedDao {
	public Bed save(Bed bed, int roomId);

	public Bed getById(int bedId);

	public List<Bed> getAll();

	public Bed update(Bed bed, int bedId);

	public boolean delete(int bedId);

}
