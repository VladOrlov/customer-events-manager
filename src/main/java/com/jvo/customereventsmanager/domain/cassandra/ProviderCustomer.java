package com.jvo.customereventsmanager.domain.cassandra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.time.Instant;

@Table("provider_customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderCustomer {

    @PrimaryKeyColumn(name = "provider_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String providerId;

    @PrimaryKeyColumn(name = "customer_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String customerId;

    @PrimaryKeyColumn(name = "registration_date", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Timestamp registrationDate;

    @Column("individual_tax_number")
    private String individualTaxNumber;

    @CreatedDate
    private Instant dateCreated;

    @LastModifiedDate
    private Instant dateUpdated;

}
