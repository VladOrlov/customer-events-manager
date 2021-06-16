package com.jvo.customereventsmanager.service;

import com.jvo.customereventsmanager.domain.cassandra.ProviderCustomer;
import com.jvo.customereventsmanager.domain.mongo.Customer;
import com.jvo.customereventsmanager.domain.mongo.Individual;
import com.jvo.customereventsmanager.dto.CustomerRegistrationEvent;
import com.jvo.customereventsmanager.dto.CustomerRegistrationResult;
import com.jvo.customereventsmanager.repository.cassandra.ProviderCustomersRepository;
import com.jvo.customereventsmanager.repository.mongo.CustomerRepository;
import com.jvo.customereventsmanager.repository.mongo.IndividualRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerRegistrationService {

    private final CustomerRepository customerRepository;
    private final IndividualRepository individualRepository;
    private final ProviderCustomersRepository providerCustomersRepository;

    public CustomerRegistrationService(CustomerRepository customerRepository,
                                       IndividualRepository individualRepository,
                                       ProviderCustomersRepository providerCustomersRepository) {
        this.customerRepository = customerRepository;
        this.individualRepository = individualRepository;
        this.providerCustomersRepository = providerCustomersRepository;
    }

    public CustomerRegistrationResult registerNewCustomer(CustomerRegistrationEvent customerRegistrationEvent) {

        CustomerRegistrationResult customerRegistrationResult = new CustomerRegistrationResult();

        boolean isCustomerRegistered = customerRepository.existsCustomerByExternalId(customerRegistrationEvent.getGameProvider());

        if (!isCustomerRegistered) {
            customerRegistrationResult.setOptionalCustomer(
                    Optional.of(customerRepository.save(getCustomerEntity(customerRegistrationEvent))));

            providerCustomersRepository.save(getProviderCustomerEntity(customerRegistrationEvent));

        }

        boolean isPersonRegistered = individualRepository.existsById(customerRegistrationEvent.getIndividualTaxNumber());

        if (!isPersonRegistered) {
            customerRegistrationResult.setOptionalPerson(
                    Optional.of(individualRepository.save(getPersonEntity(customerRegistrationEvent))));
        }

        return customerRegistrationResult;
    }

    private ProviderCustomer getProviderCustomerEntity(CustomerRegistrationEvent customerRegistrationEvent) {
        ProviderCustomer providerCustomer = new ProviderCustomer();
        providerCustomer.setProviderId(customerRegistrationEvent.getGameProvider());
        providerCustomer.setCustomerId(customerRegistrationEvent.getCustomerId());
        providerCustomer.setRegistrationDate(Timestamp.valueOf(LocalDateTime.now()));
        providerCustomer.setIndividualTaxNumber(customerRegistrationEvent.getIndividualTaxNumber());

        return providerCustomer;
    }

    private Individual getPersonEntity(CustomerRegistrationEvent customerRegistrationEvent) {
        Individual individual = new Individual();
        individual.setIndividualTaxNumber(customerRegistrationEvent.getIndividualTaxNumber());
        individual.setPassport(customerRegistrationEvent.getPassport());
        individual.setFirstName(customerRegistrationEvent.getFirstName());
        individual.setLastName(customerRegistrationEvent.getLastName());
        individual.setAge(customerRegistrationEvent.getAge());
        individual.setGender(customerRegistrationEvent.getGender());
        individual.setPhone(customerRegistrationEvent.getPhone());
        individual.setEmail(customerRegistrationEvent.getEmail());

        return individual;
    }

    private Customer getCustomerEntity(CustomerRegistrationEvent customerRegistrationEvent) {
        Customer customer = new Customer();
        customer.setGameProvider(customerRegistrationEvent.getGameProvider());
        customer.setExternalId(customerRegistrationEvent.getCustomerId());
        customer.setIndividualTaxNumber(customerRegistrationEvent.getIndividualTaxNumber());
        customer.setPhone(customerRegistrationEvent.getPhone());
        customer.setEmail(customerRegistrationEvent.getEmail());

        return customer;
    }
}
