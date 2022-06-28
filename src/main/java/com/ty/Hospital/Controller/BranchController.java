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

import com.ty.Hospital.Dto.Branch;
import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.util.ResponseStructure;

@RestController
public class BranchController {
	
	@PostMapping("admin/{aid}/hospital/{hid}/branch")
	public ResponseEntity<ResponseStructure<Branch>> save(@RequestBody Branch branch,@PathVariable int aid,@PathVariable int hid) {
		return null;
	}
	@GetMapping("branch/{bid}")
	public ResponseEntity<ResponseStructure<Branch>> getById(@PathVariable int bid){
		return null;
	}
	@GetMapping("branch")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAll(){
		return null;
	}
	@PutMapping("admin/{aid}/branch")
	public ResponseEntity<ResponseStructure<Branch>> update(@RequestBody Building building,@PathVariable int bid,@PathVariable int aid){
		return null;
	}
	@DeleteMapping("branch")
	public ResponseEntity<ResponseStructure<Branch>> delete(@RequestParam int bid){
		return null;
	}

}
