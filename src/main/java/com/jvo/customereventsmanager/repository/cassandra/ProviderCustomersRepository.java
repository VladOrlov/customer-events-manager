package com.jvo.customereventsmanager.repository.cassandra;

import com.jvo.customereventsmanager.domain.cassandra.ProviderCustomer;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderCustomersRepository extends CassandraRepository<ProviderCustomer, String> {
}