package com.resterp.spring_batch.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Désactivé pour le moment.
// Quand ton premier vrai job sera prêt, décommente @Component.
//@Component
public class EtlJobRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(EtlJobRunner.class);

    private final JobLauncher jobLauncher;
    private final Job loadDimTenantJob;

    public EtlJobRunner(
            JobLauncher jobLauncher,
            @Qualifier("loadDimTenantJob") Job loadDimTenantJob) {
        this.jobLauncher = jobLauncher;
        this.loadDimTenantJob = loadDimTenantJob;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting ETL main runner...");

        jobLauncher.run(
                loadDimTenantJob,
                new JobParametersBuilder()
                        .addLong("time", System.currentTimeMillis())
                        .toJobParameters()
        );

        log.info("ETL main runner finished.");
    }
}