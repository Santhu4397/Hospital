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
import com.ty.Hospital.Service.HospitalService;
import com.ty.Hospital.Service.SequenceGeneratorService;
import com.ty.Hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;

	@Autowired
	SequenceGeneratorService service;

	@PostMapping("/admin/{aid}/hospital")
	@ApiOperation("To Save Hospital By AdminId")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save Hospital Data Successfully"),
			@ApiResponse(code = 400, message = "bad request for Data/AdminId Does not found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital,
			@PathVariable @ApiParam("AdminID") int aid) {
		hospital.setId(service.generateHospitalSequence(Hospital.SEQUENCE_NAME));
		return hospitalService.saveHospital(hospital, aid);
	}

	@GetMapping("hospital/hid/{id}")
	@ApiOperation("To Fetch Hospital By Id ")
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetch Hospital Data Successfully"),
			@ApiResponse(code = 400, message = "bad request for Data/HospitalId Does not found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospital>> getById(@PathVariable @ApiParam("HospitalID") int id) {
		return hospitalService.getById(id);
	}

	@GetMapping("hospital")
	
	@ApiOperation("To Fetch Hospital")
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetch Hospital Data Successfully"),
			@ApiResponse(code = 400, message = "bad request for Data"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<List<Hospital>>> getall() {
		return hospitalService.getAllHospital();
	}

	@PutMapping("/admin/{aid}/hospital/{hid}")
	@ApiOperation("To Update Hospital By hospitalid and AdminId")
	@ApiResponses({ @ApiResponse(code = 200, message = "Update Hospital Data Successfully"),
			@ApiResponse(code = 400, message = "bad request for Data/AdminId (or)hospital Id Does not found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospital>> update(@RequestBody Hospital hospital,
			@PathVariable @ApiParam("HospitalID") int hid, @PathVariable @ApiParam("AdminID") int aid) {
		return hospitalService.updatHospital(hid, hospital);
	}

	@DeleteMapping("hospital")
	@ApiOperation("To Delete Hospital By hospitalId")
	@ApiResponses({ @ApiResponse(code = 200, message = "Update Hospital Data Successfully"),
			@ApiResponse(code = 400, message = "bad request for Data/hospital Id Does not found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Boolean>> delete(@RequestParam @ApiParam("HospitalID") int id) {
		return hospitalService.deleteHospital(id);
	}

}
