package com.example.multidatabases.configs;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author Felipe Santaniello
 */
@Data
@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {
    private MongoProperties database1 = new MongoProperties();
    private MongoProperties database2 = new MongoProperties();
}