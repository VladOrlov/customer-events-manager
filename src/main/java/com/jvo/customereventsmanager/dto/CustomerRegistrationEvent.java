package com.jvo.customereventsmanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerRegistrationEvent {

    private String customerId;

    private String firstName;

    private String lastName;

    private String individualTaxNumber;

    private String passport;

    private Integer age;

    private String gender;

    private String phone;

    private String email;

    private String gameProvider;

}
