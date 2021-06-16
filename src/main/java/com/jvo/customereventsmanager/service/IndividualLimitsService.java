package com.jvo.customereventsmanager.service;

import com.jvo.customereventsmanager.domain.cassandra.IndividualLimits;
import com.jvo.customereventsmanager.dto.IndividualLimitsUpdateEvent;
import com.jvo.customereventsmanager.repository.cassandra.IndividualLimitsRepository;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IndividualLimitsService {

    private final IndividualLimitsRepository individualLimitsRepository;
    private final ModelMapper mapper = new ModelMapper();

    public IndividualLimitsService(IndividualLimitsRepository individualLimitsRepository) {
        this.individualLimitsRepository = individualLimitsRepository;
    }

    public IndividualLimits updatePersonLimits(IndividualLimitsUpdateEvent limitsUpdateEvent){
        return individualLimitsRepository.findByIndividualTaxNumber(limitsUpdateEvent.getIndividualTaxNumber())
                .map(limits -> updateExistingLimits(limitsUpdateEvent, limits))
                .orElseGet(() -> addPersonLimits(limitsUpdateEvent));
    }

    @NotNull
    private IndividualLimits addPersonLimits(IndividualLimitsUpdateEvent limitsUpdateEvent) {
        return individualLimitsRepository.save(mapper.map(limitsUpdateEvent, IndividualLimits.class));
    }

    private IndividualLimits updateExistingLimits(IndividualLimitsUpdateEvent limitsUpdateEvent, IndividualLimits limits) {
        mapper.map(limitsUpdateEvent, limits);
        return individualLimitsRepository.save(limits);
    }

}
