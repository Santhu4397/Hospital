package com.ty.Hospital.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Dto.User;
import com.ty.Hospital.Excipation.IdNotFound;
import com.ty.Hospital.Service.HospitalService;
import com.ty.Hospital.dao.HospitalDao;
import com.ty.Hospital.dao.UserDao;
import com.ty.Hospital.util.ResponseStructure;
@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private UserDao userDao;
	@Override
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital,int aid) {
		User user=userDao.getUserById(aid);
		if(user!=null) {
		ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("hospital Created succesfuly");
		structure.setData(hospitalDao.saveHospital(hospital, aid));
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		}
		throw new IdNotFound(aid+"Admin id not found");
		
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital() {
		ResponseStructure<List<Hospital>> structure=new ResponseStructure<List<Hospital>>();
		structure.setData(hospitalDao.getAllHospital());
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("List Hospitals");
		return new ResponseEntity<ResponseStructure<List<Hospital>>>(structure, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> getById(int hid) {
		Hospital hospital=hospitalDao.getHospitalById(hid);
		if(hospital!=null) {
			ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(hospital);
			structure.setMessage("hosital");
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		}
		 throw new IdNotFound(hid+"hospital id not found");
	}

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> updatHospital(int hid, Hospital hospital) {
		Hospital existinghospital=hospitalDao.getHospitalById(hid);
		if(existinghospital!=null) {
			ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(hospitalDao.updateHospitalById(hid, hospital));
			structure.setMessage("hosital");
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		}
		 throw new IdNotFound(hid+"hospital id not found");
	}
	

	@Override
	public ResponseEntity<ResponseStructure<Boolean>> deleteHospital(int hid) {
		Hospital hospital=hospitalDao.getHospitalById(hid);
		if(hospital!=null) {
			ResponseStructure<Boolean> structure=new ResponseStructure<Boolean>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(hospitalDao.deleteHospital(hid));
			structure.setMessage("hosital deleted");
			return new ResponseEntity<ResponseStructure<Boolean>>(structure, HttpStatus.OK);
		}
		 throw new IdNotFound(hid+"hospital id not found");
	}

}
