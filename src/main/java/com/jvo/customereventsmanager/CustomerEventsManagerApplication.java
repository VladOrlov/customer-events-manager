package com.jvo.customereventsmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.config.EnableCassandraAuditing;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableKafka
@EnableCassandraRepositories
@EnableCassandraAuditing
@EnableMongoRepositories
@EnableMongoAuditing
@SpringBootApplication
public class CustomerEventsManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerEventsManagerApplication.class, args);
    }

}
