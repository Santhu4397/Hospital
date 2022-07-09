package com.ty.Hospital.daoimpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.json.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.ty.Hospital.Dto.Branch;
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
	@Autowired
	MongoTemplate mongoTemplate;

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

		MongoCollection<Document> collection = mongoTemplate.getCollection("Hospitals");
		AggregateIterable<Document> output = collection
				.aggregate(Arrays.asList(new Document("$unwind", new Document("path", "$branchs")),
						new Document("$unwind", new Document("path", "$branchs.buildings")),
						new Document("$match", new Document("branchs.buildings._id", id))));
		Gson gson = new Gson();
			
		for (Document dc : output) {
			System.out.println(dc.toJson());
			//gson.fromJson(dc.toJson(), Hospital.class);
			Branch branch=dc.get("branchs", Branch.class);
		 	Object hospital=dc.get("branchs");
		 	System.out.println(hospital);
		 	System.out.println(branch);
//			System.out.println(hospital);
			JSONObject root = new JSONObject(dc.toJson());
			JSONArray	hospitals=root.getJSONArray("branchs");
						
		
//		 System.out.println("branch name"+branch2.getCity());
//		  System.out.println("object "+dc);
//		  System.out.println("branch "+dc.get("branchs"));
//		  System.out.println("branch Id "+dc.get("branchs.buildings"));
			// hospital=(Hospital)dc.get("branchs");

		}

		return null;
	}

}
