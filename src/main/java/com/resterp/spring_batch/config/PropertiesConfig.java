package com.resterp.spring_batch.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan(basePackages = "com.resterp.spring_batch")
public class PropertiesConfig {
}