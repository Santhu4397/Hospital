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

import com.ty.Hospital.Dto.User;
import com.ty.Hospital.Repo.UserRepo;
import com.ty.Hospital.Service.SequenceGeneratorService;
import com.ty.Hospital.util.ResponseStructure;

@RestController
public class UserController {
	@Autowired
	UserRepo repo;
	@Autowired
	SequenceGeneratorService service;

	@PostMapping("user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		user.setId(service.generateSequence(User.SEQUENCE_NAME));
		return null;
	}
	@GetMapping("user/uid/{id}")
	public ResponseEntity<ResponseStructure<User>> getByID(@RequestParam int id){
		return null;
	}
	@GetMapping("user")
	public ResponseEntity<ResponseStructure<List<User>>> getAll(){
		return null;
	}
	@PutMapping("user/update/{id}")
	public ResponseEntity<ResponseStructure<User>> update(@PathVariable int id){
		return null;
	}
	@DeleteMapping("user")
	public ResponseEntity<ResponseStructure<Boolean>> deleteById(@RequestParam int id){
		return null;
	}

}
