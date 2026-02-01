package com.gymcrm.trainer_workload_service.config;

import org.springframework.boot.test.context.TestConfiguration;

/**
 * Test configuration for MongoDB.
 * 
 * Note: Testcontainers is disabled due to Docker Desktop connectivity issues on Windows.
 * Tests use the existing MongoDB container from docker-compose (port 27017).
 * 
 * To enable Testcontainers in the future (when Docker Desktop connectivity is fixed):
 * 1. Uncomment the mongoDBContainer() method below
 * 2. Add @ServiceConnection annotation
 * 3. The MongoDB URI in application-test.properties will be automatically configured
 */
@TestConfiguration(proxyBeanMethods = false)
public class MongoTestConfig {
    
    // Testcontainers MongoDB configuration - DISABLED due to Docker connectivity issues
    // Uncomment when Docker Desktop connectivity is working:
    /*
    @Bean
    @ServiceConnection
    public MongoDBContainer mongoDBContainer() {
        return new MongoDBContainer("mongo:latest");
    }
    */
}
