package com.jvo.customereventsmanager.dto;

import com.jvo.customereventsmanager.domain.mongo.Customer;
import com.jvo.customereventsmanager.domain.mongo.Individual;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegistrationResult {

    private Optional<Customer> optionalCustomer;

    private Optional<Individual> optionalPerson;

}
