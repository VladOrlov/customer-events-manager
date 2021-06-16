package com.jvo.customereventsmanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndividualLimitsUpdateEvent {

    private String individualTaxNumber;

    private Double betsLimit;

    private Integer betsTimeWindow;

    private Double depositsLimit;

    private Integer depositsTimeWindow;

    private Double lossesLimit;

    private Integer lossesTimeWindow;

}
