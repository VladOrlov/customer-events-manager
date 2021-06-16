package com.jvo.customereventsmanager.repository.mongo;

import com.jvo.customereventsmanager.domain.mongo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findCustomerByExternalId(String externalId);

    boolean existsCustomerByExternalId(String externalId);

}