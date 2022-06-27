package com.ty.Hospital.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.util.ResponseStructure;

@RestController
public class BuildingController {
	@PostMapping("building/branch/{bid}/user/{uid}")
	public ResponseEntity<ResponseStructure<Building>> save(@RequestBody Building building,@PathVariable int uid,@PathVariable int bid) {
		return null;
	}
	@GetMapping("building/{bid}")
	public ResponseEntity<ResponseStructure<Building>> getById(@PathVariable int bid){
		return null;
	}
	@GetMapping("building")
	public ResponseEntity<ResponseStructure<List<Building>>> getAll(){
		return null;
	}
	@PutMapping("building/{bid}/admin/{aid}")
	public ResponseEntity<ResponseStructure<Building>> update(@RequestBody Building building,@PathVariable int bid,@PathVariable int aid){
		return null;
	}
	@DeleteMapping("building")
	public ResponseEntity<ResponseStructure<Building>> delete(@RequestParam int id){
		return null;
	}

}
