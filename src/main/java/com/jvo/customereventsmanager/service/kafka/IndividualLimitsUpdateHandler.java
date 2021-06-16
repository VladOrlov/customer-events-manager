package com.jvo.customereventsmanager.service.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvo.customereventsmanager.dto.IndividualLimitsUpdateEvent;
import com.jvo.customereventsmanager.service.IndividualLimitsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IndividualLimitsUpdateHandler {

    private final ObjectMapper objectMapper;
    private final IndividualLimitsService individualLimitsService;

    public IndividualLimitsUpdateHandler(IndividualLimitsService individualLimitsService, ObjectMapper objectMapper) {
        this.individualLimitsService = individualLimitsService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "individual-limits")
    public void consumeMessage(String eventJson) {
        try {
            IndividualLimitsUpdateEvent individualLimitsUpdateEvent = objectMapper.readValue(eventJson, IndividualLimitsUpdateEvent.class);
            individualLimitsService.updatePersonLimits(individualLimitsUpdateEvent);
        } catch (JsonProcessingException exception) {
            log.error(exception.getMessage());
        }
    }
}
