package com.jvo.customereventsmanager.repository.cassandra;

import com.jvo.customereventsmanager.domain.cassandra.IndividualLimits;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndividualLimitsRepository extends CassandraRepository<IndividualLimits, String> {

    Optional<IndividualLimits> findByIndividualTaxNumber(String individualTaxNumber);

}
