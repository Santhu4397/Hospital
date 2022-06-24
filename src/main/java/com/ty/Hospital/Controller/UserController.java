package com.ty.Hospital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital.Controller.Repo.UserRepo;
import com.ty.Hospital.Dto.User;
import com.ty.Hospital.Service.SequenceGeneratorService;

@RestController
public class UserController {
	@Autowired
	UserRepo repo;
	@Autowired
	SequenceGeneratorService service;

	@PostMapping("user")
	public User saveUser(@RequestBody User user) {
		user.setId(service.generateSequence(User.SEQUENCE_NAME));
		return repo.save(user);

	}

}
