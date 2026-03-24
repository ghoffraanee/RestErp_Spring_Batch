package com.resterp.spring_batch.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DebugRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DebugRunner.class);

    private final Environment environment;

    public DebugRunner(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void run(String... args) {
        log.info("=== DEBUG RUNNER START ===");

        log.info("Application name: {}", environment.getProperty("spring.application.name"));
        log.info("Active profiles: {}", Arrays.toString(environment.getActiveProfiles()));

        log.info("SuperAdmin datasource URL: {}", environment.getProperty("app.datasource.superadmin.url"));
        log.info("ERP datasource URL: {}", environment.getProperty("app.datasource.erp.url"));
        log.info("DW datasource URL: {}", environment.getProperty("app.datasource.dw.url"));

        log.info("=== DEBUG RUNNER END ===");
    }
}