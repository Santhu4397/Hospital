package com.ty.Hospital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital.Controller.Repo.HospitalRepo;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Dto.User;
import com.ty.Hospital.Service.SequenceGeneratorService;

@RestController
public class HospitalController {
	@Autowired
	private HospitalRepo repo;
	
	@Autowired
	SequenceGeneratorService service;
	
	@PostMapping("hospital")
	public Hospital saveHospital(@RequestBody Hospital hospital) {
		hospital.setId(service.generateSequence(User.SEQUENCE_NAME));
		return repo.save(hospital);
	}
}
