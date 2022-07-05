package com.ty.Hospital.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Dto.User;
import com.ty.Hospital.Repo.HospitalRepo;
import com.ty.Hospital.dao.HospitalDao;

@Repository
public class HospitalDaoImpl implements HospitalDao {

	@Autowired
	private HospitalRepo hospitalRepo;
	@Autowired
	private UserDaoImpl userDaoImpl;

	@Override
	public Hospital saveHospital(Hospital hospital, int userId) {
		User user = userDaoImpl.getUserById(userId);
		hospital.setUser(user);
		return hospitalRepo.save(hospital);
	}

	@Override
	public Hospital getHospitalById(int hid) {
		Optional<Hospital> optional = hospitalRepo.findById(hid);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Hospital> getAllHospital() {
		return hospitalRepo.findAll();
	}

	@Override
	public Hospital updateHospitalById(int hid, Hospital hospital) {
		Hospital exsiting = getHospitalById(hid);
		if (exsiting != null) {
			// exsiting.setBranchs(hospital.getBranchs());
			exsiting.setEmail(hospital.getEmail());
			exsiting.setGst(hospital.getGst());
			exsiting.setName(hospital.getName());
			exsiting.setPhone(hospital.getPhone());
			exsiting.setWebsite(hospital.getWebsite());
			exsiting.setBranchs(hospital.getBranchs());
			// User user = userDaoImpl.getUserById(hospital.getUser().getId());
//			if (user != null) {
//				exsiting.setUser(hospital.getUser());
//			}
			return hospitalRepo.save(exsiting);
		}
		return null;
	}

	@Override
	public boolean deleteHospital(int hid) {
		Hospital hospital = getHospitalById(hid);
		if (hospital != null) {
			hospitalRepo.delete(hospital);
			return true;
		}
		return false;
	}

	@Override
	public Hospital getByBranchId(int id) {
		return hospitalRepo.getBybranchId(id);
	}

	@Override
	public Hospital getByBuildingId(int id) {
		return hospitalRepo.getByBuildingId(id);
	}

}
