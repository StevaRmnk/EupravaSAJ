package com.example.Gradjanin.Repository;

import com.example.Gradjanin.Model.Gradjanin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradjaninRepository  extends MongoRepository<Gradjanin, String> {

}
