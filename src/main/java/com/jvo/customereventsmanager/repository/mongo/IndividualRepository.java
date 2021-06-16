package com.jvo.customereventsmanager.repository.mongo;

import com.jvo.customereventsmanager.domain.mongo.Individual;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends MongoRepository<Individual, String> {

}
