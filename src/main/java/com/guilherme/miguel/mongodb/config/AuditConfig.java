package com.guilherme.miguel.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * Database audit configuration.
 *
 * @author Miguel Guilherme
 */
@Configuration
@EnableMongoAuditing
public class AuditConfig {
}
