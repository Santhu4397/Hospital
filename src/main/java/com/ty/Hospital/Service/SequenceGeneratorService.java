package com.ty.Hospital.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ty.Hospital.Dto.Branch_Sequences;
import com.ty.Hospital.Dto.Building_Sequences;
import com.ty.Hospital.Dto.DataBase_Sequens;
import com.ty.Hospital.Dto.Encounter_Sequences;
import com.ty.Hospital.Dto.Facility_Sequences;
import com.ty.Hospital.Dto.Floor_Sequences;
import com.ty.Hospital.Dto.Hospital_Sequences;
import com.ty.Hospital.Dto.Room_Sequences;

@Service
public class SequenceGeneratorService {
	private MongoOperations mongoOperations;

	@Autowired
	public SequenceGeneratorService(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	public int generateHospitalSequence(String seqName) {

		Hospital_Sequences counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), Hospital_Sequences.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }
    public  int generateBranchSequence(String seqName) {

       Branch_Sequences counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                Branch_Sequences.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }
    public  int generateBuildingSequence(String seqName) {

        Building_Sequences counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                Building_Sequences.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }
    


	public int generateFloorSequence(String seqName) {

		Floor_Sequences counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), Floor_Sequences.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

	}

	public int generateRoomSequence(String seqName) {

		Room_Sequences counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), Room_Sequences.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

	}

	public int generateEncounterSequence(String seqName) {

		Encounter_Sequences counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), Encounter_Sequences.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

	}

	public int generateFacilitySequence(String seqName) {

		Facility_Sequences counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), Facility_Sequences.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

	}

	public int generateSequence(String seqName) {

		DataBase_Sequens counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), DataBase_Sequens.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

	}

}
