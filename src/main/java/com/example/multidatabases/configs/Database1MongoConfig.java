package com.example.multidatabases.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static com.example.multidatabases.configs.Database1MongoConfig.MONGO_TEMPLATE;

/**
 * @author Marcos Barbero
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.example.multidatabases.repositories.database1",
        mongoTemplateRef = MONGO_TEMPLATE)
public class Database1MongoConfig {

    protected static final String MONGO_TEMPLATE = "database1MongoTemplate";
}