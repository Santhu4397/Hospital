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
import com.ty.Hospital.Dto.Floor;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Dto.User;
import com.ty.Hospital.Repo.HospitalRepo;
import com.ty.Hospital.dao.HospitalDao;
import com.ty.Hospital.util.FloorHelp;
import com.ty.Hospital.util.Hospitalhelp;
import com.ty.Hospital.util.ListBean; 
import com.ty.Hospital.util.ListOfRoom;
import com.ty.Hospital.util.RoomsHelp;

@Repository
public class HospitalDaoImpl implements HospitalDao {

	@Autowired
	private HospitalRepo hospitalRepo;
	@Autowired

	private UserDaoImpl userDaoImpl;
	@Autowired
	MongoTemplate mongoTemplate;
	
	private final Gson gson = new Gson();

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
		ListBean bean = getListFloorByBuildingId(id);
		List<RoomsHelp> rooms = null;
		List<FloorHelp> floors = bean.get_id();
		
//		System.out.println(floors.size() + "=============================");
//		System.out.println(floors.get(0).getRooms().get(0));
		AggregateIterable<Document> output = null;
		Hospital hospital = hospitalRepo.getByBuildingId(id);
		System.out.println("hospital: " + hospital);

		MongoCollection<Document> collection = mongoTemplate.getCollection("Hospitals");

		if (floors != null && rooms == null) {
			System.out.println("###########################1");
			output = collection.aggregate(Arrays.asList(new Document("$unwind", new Document("path", "$branchs")),
					new Document("$unwind", new Document("path", "$branchs.buildings")),
					new Document("$unwind", new Document("path", "$branchs.buildings.floors")),
					new Document("$match", new Document("branchs.buildings._id", id))));

		} else if (floors != null && rooms != null) {
			System.out.println("###########################2");
			output = collection.aggregate(Arrays.asList(new Document("$unwind", new Document("path", "$branchs")),
					new Document("$unwind", new Document("path", "$branchs.buildings")),
					new Document("$unwind", new Document("path", "$branchs.buildings.floors")),
					new Document("$unwind", new Document("path", "$branchs.buildings.floors.rooms")),
					new Document("$match", new Document("branchs.buildings._id", id))));
		}
		else {
			System.out.println("###########################3");
			output = collection.aggregate(Arrays.asList(new Document("$unwind", new Document("path", "$branchs")),
					new Document("$unwind", new Document("path", "$branchs.buildings")),
					new Document("$match", new Document("branchs.buildings._id", id))));
		}

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@3" + output.first());

		Hospitalhelp hospitalhelp = null;
		for (Document dc : output) {

			System.out.println(dc.toJson() + "$$$$$$$$$$$$$$$$$$$$$>");
			hospitalhelp = gson.fromJson(dc.toJson(), Hospitalhelp.class);
			System.out.println(hospitalhelp.getBranchs());
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

		for (Document document : output) {
			System.out.println("*****" + document.toJson());
			hospitalhelp = gson.fromJson(document.toJson(), Hospitalhelp.class);
		}
		System.out.println(hospitalhelp);
		return hospitalhelp;
	}

	public ListBean getListFloorByBuildingId(int id) {
		MongoCollection<Document> collection = mongoTemplate.getCollection("Hospitals");
		AggregateIterable<Document> output = collection
				.aggregate(Arrays.asList(new Document("$unwind", new Document("path", "$branchs")),
						new Document("$unwind", new Document("path", "$branchs.buildings")),
						new Document("$match", new Document("branchs.buildings._id", id)),
						new Document("$project", new Document("branchs.buildings.floors", 1)),
						new Document("$group", new Document("_id", "$branchs.buildings.floors"))));
		ListBean building = null;

		for (Document document : output) {
			System.out.println("json: " + document.toJson());
			building = gson.fromJson(document.toJson(), ListBean.class);

		}
		return building;
	}

	public ListBean getListOfBranchesByHospitalId(int hospitalId) {
		MongoCollection<Document> collection = mongoTemplate.getCollection("Hospitals");
		AggregateIterable<Document> iterable = collection
				.aggregate(Arrays.asList(new Document("$match", new Document("_id", hospitalId)),
						new Document("$project", new Document("branchs", 1)),
						new Document("$group", new Document("_id", "$branchs")),
						new Document("$project", new Document("_id.buildings", 0))));
		ListBean bean = null;
		for (Document document : iterable) {
			System.out.println("json: " + document.toJson());
			bean = gson.fromJson(document.toJson(), ListBean.class);

		}
		return bean;

	}

	public ListBean getListOfBuildingByBranchId(int buildingId) {
		MongoCollection<Document> collection = mongoTemplate.getCollection("Hospitals");
		AggregateIterable<Document> iterable = collection
				.aggregate(Arrays.asList(new Document("$unwind", new Document("path", "$branchs")),
						new Document("$match", new Document("branchs._id", buildingId)),
						new Document("$project", new Document("branchs.buildings", 1)),
						new Document("$group", new Document("_id", "$branchs.buildings")),
						new Document("$project", new Document("_id.floors", 0))));
		ListBean bean = null;
		for (Document document : iterable) {
			System.out.println("json: " + document.toJson());
			bean = gson.fromJson(document.toJson(), ListBean.class);

		}
		return bean;

	}

	public ListOfRoom getListOfRoomsByFloorId(int floorID) {
		MongoCollection<Document> collection = mongoTemplate.getCollection("Hospitals");
		AggregateIterable<Document> iterable = collection
				.aggregate(Arrays.asList(new Document("$unwind", new Document("path", "$branchs")),
						new Document("$unwind", new Document("path", "$branchs.buildings")),
						new Document("$unwind", new Document("path", "$branchs.buildings.floors")),
						new Document("$match", new Document("branchs.buildings.floors._id", floorID)),
						new Document("$project", new Document("branchs.buildings.floors.rooms", 1)),
						new Document("$group", new Document("_id", "$branchs.buildings.floors.rooms"))));
		ListOfRoom bean = null;
		for (Document document : iterable) {
			System.out.println("json: " + document.toJson());
			bean = gson.fromJson(document.toJson(), ListOfRoom.class);

		}
		return bean;
	}
}
