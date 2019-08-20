package com.example.multidatabases.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static com.example.multidatabases.configs.Database2MongoConfig.MONGO_TEMPLATE;

/**
 * @author Marcos Barbero
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.example.multidatabases.repositories.database2",
        mongoTemplateRef = MONGO_TEMPLATE)
public class Database2MongoConfig {

    protected static final String MONGO_TEMPLATE = "database2MongoTemplate";
}