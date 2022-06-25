package com.ty.Hospital.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ty.Hospital.Dto.DataBase_Sequens;
import com.ty.Hospital.Dto.Hospital_Sequences;

@Service
public class SequenceGeneratorService {
    private  MongoOperations mongoOperations;

   @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public  int generateHospitalSequence(String seqName) {

        Hospital_Sequences counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                Hospital_Sequences.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }
    
    public  int generateSequence(String seqName) {

        DataBase_Sequens counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DataBase_Sequens.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }



}
