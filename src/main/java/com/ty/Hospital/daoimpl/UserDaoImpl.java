package com.ty.Hospital.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.Dto.User;
import com.ty.Hospital.Repo.UserRepo;
import com.ty.Hospital.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User saveUSer(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserById(int uid) {
		Optional<User> optional = userRepo.findById(uid);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User updateUserById(int uid, User user) {
		User existingUser = getUserById(uid);
		if (existingUser != null) {
			existingUser.setName(user.getName());
			existingUser.setAge(user.getAge());
			existingUser.setEmailId(user.getEmailId());
			existingUser.setGender(user.getGender());
			existingUser.setPhone(user.getPhone());
			existingUser.setPassword(user.getPassword());
		}
		return null;
	}

	@Override
	public boolean deleteUser(int uid) {
		User user = getUserById(uid);
		if (user != null) {
			userRepo.delete(user);
			return true;
		} else {
			return false;
		}
	}

}
