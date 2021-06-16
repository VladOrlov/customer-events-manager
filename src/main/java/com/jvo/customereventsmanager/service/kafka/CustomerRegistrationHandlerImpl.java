package com.jvo.customereventsmanager.service.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvo.customereventsmanager.dto.CustomerRegistrationEvent;
import com.jvo.customereventsmanager.service.CustomerRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerRegistrationHandlerImpl implements CustomerRegistrationHandler {

    private final CustomerRegistrationService customerRegistrationService;
    private final ObjectMapper objectMapper;

    public CustomerRegistrationHandlerImpl(CustomerRegistrationService customerRegistrationService, ObjectMapper objectMapper) {
        this.customerRegistrationService = customerRegistrationService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "customer-registrations")
    public void consumeMessage(String eventJson) {
        try {
            CustomerRegistrationEvent registrationEvent = objectMapper.readValue(eventJson, CustomerRegistrationEvent.class);
            customerRegistrationService.registerNewCustomer(registrationEvent);
        } catch (JsonProcessingException exception) {
            log.error(exception.getMessage());
        }
    }

}
