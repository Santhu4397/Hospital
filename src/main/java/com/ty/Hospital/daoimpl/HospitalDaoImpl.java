package com.ty.Hospital.daoimpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Dto.User;
import com.ty.Hospital.Repo.HospitalRepo;
import com.ty.Hospital.dao.HospitalDao;
import com.ty.Hospital.util.Hospitalhelp;

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

		Hospital hospital = hospitalRepo.getByBranchId(id);
		System.out.println(hospital);
		return hospital;
	}

	@Override
	public Hospitalhelp getByBuildingId(int id) {
//mongo client
//		CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
//				fromProviders(PojoCodecProvider.builder().automatic(true).build()));
//		MongoClientSettings clientSettings=MongoClientSettings.builder().codecRegistry(codecRegistry).build();
//		MongoClient client=MongoClients.create(clientSettings);
//		MongoDatabase database=client.getDatabase("Hospital").withCodecRegistry(codecRegistry);
//		MongoCollection<Hospital> collection = database.getCollection("Hospitals",Hospital.class);
//		Hospital hospital=collection.find(Filters.eq("branchs.buildings._id",id)).first();
//		System.out.println(hospital.getBranchs());	
//		ArrayList<Hospital> output = collection
//				.aggregate(Arrays.asList(new Document("$unwind", new Document("path", "$branchs")),
//						new Document("$unwind", new Document("path", "$branchs.buildings")),
//						new Document("$match", new Document("branchs.buildings._id", id))), Hospital.class)
//				.into(new ArrayList<Hospital>());
//		System.out.println("output: " + output);
//		Hospital hashMap = (Hospital) output.get(0);
//		System.out.println(hashMap);
		// mongo template
		MongoCollection<Document> collection = mongoTemplate.getCollection("Hospitals");
		AggregateIterable<Document> output = collection
				.aggregate(Arrays.asList(new Document("$unwind", new Document("path", "$branchs")),
						new Document("$unwind", new Document("path", "$branchs.buildings")),
						new Document("$match", new Document("branchs.buildings._id", id))));

		Gson gson = new Gson();
		Hospitalhelp hospitalhelp = null;
		for (Document dc : output) {
			System.out.println(dc.toJson());
			hospitalhelp = gson.fromJson(dc.toJson(), Hospitalhelp.class);
			System.out.println(hospitalhelp.getBranchs());
			// System.out.println(dc.get("branchs"));
			// System.out.println(dc);
//			System.out.println(dc.toJson());
//			 ObjectMapper mapper = new ObjectMapper();
//			Object object=gson.fromJson(dc.toJson(), Hospital.class);
//			//Object object=dc.get("branchs", Hospital.class);
//			 System.out.println(object);
////		 	Object hospital=dc.get("branchs");
////		 	System.out.println(hospital);
////			System.out.println(hospital);
//			JSONObject root = new JSONObject(dc.toJson());
//			JSONArray	hospitals=root.getJSONArray("branchs");
//						

//		 System.out.println("branch name"+branch2.getCity());
//		  System.out.println("object "+dc);
//		  System.out.println("branch "+dc.get("branchs"));
//		  System.out.println("branch Id "+dc.get("branchs.buildings"));
			// hospital=(Hospital)dc.get("branchs");

		}

		return hospitalhelp;
	}

	public Hospitalhelp getHospitalByFloorId(int id) {

		MongoCollection<Document> collection = mongoTemplate.getCollection("Hospitals");
		AggregateIterable<Document> output = collection
				.aggregate(Arrays.asList(new Document("$unwind", new Document("path", "$branchs")),
						new Document("$unwind", new Document("path", "$branchs.buildings")),
						new Document("$unwind", new Document("path", "$branchs.buildings.floors")),
						new Document("$match", new Document("branchs.buildings.floors._id", id))));
		Hospitalhelp hospitalhelp = null;
		Gson gson = new Gson();
		for (Document document : output) {

			hospitalhelp = gson.fromJson(document.toJson(), Hospitalhelp.class);
		}

		return hospitalhelp;
	}

	public Hospitalhelp getHospitalByRoomId(int id) {

		MongoCollection<Document> collection = mongoTemplate.getCollection("Hospitals");
		AggregateIterable<Document> output = collection
				.aggregate(Arrays.asList(new Document("$unwind", new Document("path", "$branchs")),
						new Document("$unwind", new Document("path", "$branchs.buildings")),
						new Document("$unwind", new Document("path", "$branchs.buildings.floors")),
						new Document("$unwind", new Document("path", "$branchs.buildings.floors.rooms")),
						new Document("$match", new Document("branchs.buildings.floors.rooms._id", id))));
		Hospitalhelp hospitalhelp = null;
		Gson gson = new Gson();
		for (Document document : output) {
			System.out.println("*****" + document.toJson());
			hospitalhelp = gson.fromJson(document.toJson(), Hospitalhelp.class);
		}
		System.out.println(hospitalhelp);
		return hospitalhelp;
	}

}
