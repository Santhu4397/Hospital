package com.ty.Hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Repo.HospitalRepo;
import com.ty.Hospital.Service.SequenceGeneratorService;
import com.ty.Hospital.util.ResponseStructure;

@RestController
public class HospitalController {
	@Autowired
	private HospitalRepo repo;
	
	@Autowired
	SequenceGeneratorService service;
	
	@PostMapping("hospital/admin/{aid}")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital,@PathVariable int aid) {
		hospital.setId(service.generateHospitalSequence(Hospital.SEQUENCE_NAME));
		return null;
	}
	@GetMapping("hospital/hid/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> getById(@RequestParam int id){
		return null;
	}
	@GetMapping("hospital")
	public ResponseEntity<ResponseStructure<List<Hospital>>> getall(){
		return null;
	}
	@PutMapping("hospital/{hid}/admin/{aid}")
	public ResponseEntity<ResponseStructure<Hospital>> update(@RequestBody Hospital hospital, @PathVariable int hid ,@PathVariable int aid){
		return null;
	}
	@DeleteMapping("hospital")
	public ResponseEntity<ResponseStructure<Boolean>> delete(@RequestParam int id){
		return null;
	}
	
}
