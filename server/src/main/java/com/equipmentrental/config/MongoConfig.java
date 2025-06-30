package com.equipmentrental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.client.MongoClient;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        // Replace with your MongoDB connection string
        return MongoClients.create("mongodb://localhost:27017/equipmentRental");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "equipmentRental");
    }
}