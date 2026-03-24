package com.resterp.spring_batch.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Désactivé pour le moment.
// Active-le plus tard si tu veux piloter les jobs par module.
//@Component
public class ModuleRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ModuleRunner.class);

    @Override
    public void run(String... args) {
        log.info("ModuleRunner initialized.");
        log.info("This runner can later be used to launch a specific module: RH, FINANCE, SALES, etc.");
    }
}