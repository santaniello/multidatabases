package com.example.multidatabases.repositories.database1;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Database1Repository extends MongoRepository<Database1Model, String> {
}