package com.ty.Hospital.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.Dto.Bed;
import com.ty.Hospital.Dto.Room;
import com.ty.Hospital.Repo.BedRepository;
import com.ty.Hospital.dao.BedDao;

@Repository
public class BedDaoImpl implements BedDao {

	@Autowired
	private RoomDaoImpl impl;

	@Autowired
	private BedRepository repository;

	@Override
	public Bed save(Bed bed, int roomId) {
		Room room = impl.getById(roomId);
		if (room != null) {
			return repository.save(bed);
		}
		return null;
	}

	@Override
	public Bed getById(int bedId) {
		Optional<Bed> bed = repository.findById(bedId);
		if (bed.isPresent()) {
			return bed.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Bed> getAll() {
		return repository.findAll();
	}

	@Override
	public Bed update(Bed bed, int bedId) {
		Bed bed2 = repository.getBedById(bedId);
		if (bed2 != null) {
			bed2.setBedNumber(bed.getBedNumber());
			bed2.setEncounters(bed.getEncounters());
			bed2.setId(bed.getId());
			bed2.setRoom(bed.getRoom());
			bed2.setType(bed.getType());
			bed2.setUser(bed.getUser());
			return bed;
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(int bedId) {
		Bed bed = getById(bedId);
		if(bed!=null) {
			repository.delete(bed);
			return true;
		} else {
		return false;
		}
	}

}
