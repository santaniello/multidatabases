package com.example.multidatabases.configs;

import com.mongodb.MongoClient;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import lombok.RequiredArgsConstructor;

/**
 * @author Marcos Barbero
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MultipleMongoProperties.class)
public class MultipleMongoConfig {

    private final MultipleMongoProperties mongoProperties;

    @Primary
    @Bean(name = Database1MongoConfig.MONGO_TEMPLATE)
    public MongoTemplate database1MongoTemplate() throws Exception {
        return new MongoTemplate(database1Factory(this.mongoProperties.getDatabase1()));
    }

    @Bean(name = Database2MongoConfig.MONGO_TEMPLATE)
    public MongoTemplate database2MongoTemplate() throws Exception {
        return new MongoTemplate(database2Factory(this.mongoProperties.getDatabase2()));
    }

    @Bean
    @Primary
    public MongoDbFactory database1Factory(final MongoProperties mongo) {
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }

    @Bean
    public MongoDbFactory database2Factory(final MongoProperties mongo) {
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }

}