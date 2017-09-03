package com.guilherme.miguel.mongodb.config;

import com.github.mongobee.Mongobee;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Migrations configuration.
 *
 * @author Miguel Guilherme
 */
@Configuration
public class MigrationConfig {

    private static String CHANGE_LOGS_SCAN_PACKAGE = "com.guilherme.miguel.mongodb.changelog";

    @Bean
    public Mongobee mongobee(MongoClient mongoClient, MongoTemplate mongoTemplate, Environment environment) {
        Mongobee runner = new Mongobee(mongoClient);
        runner.setDbName(mongoTemplate.getDb().getName());
        runner.setChangeLogsScanPackage(CHANGE_LOGS_SCAN_PACKAGE);
        runner.setSpringEnvironment(environment);
        runner.setMongoTemplate(mongoTemplate);

        return runner;
    }

}
