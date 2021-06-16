package com.jvo.customereventsmanager.domain.cassandra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("individual_limits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndividualLimits {

    @PrimaryKeyColumn(name = "individual_tax_number", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String individualTaxNumber;

    @Column("bets_limit")
    private Double betsLimit;

    @Column("bets_time_window")
    private Integer betsTimeWindow;

    @Column("deposits_limit")
    private Double depositsLimit;

    @Column("deposits_time_window")
    private Integer depositsTimeWindow;

    @Column("losses_limit")
    private Double lossesLimit;

    @Column("losses_time_window")
    private Integer lossesTimeWindow;

}
