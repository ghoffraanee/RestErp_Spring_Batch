package com.resterp.spring_batch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class BatchMetadataConfig {

    private static final Logger log = LoggerFactory.getLogger(BatchMetadataConfig.class);

    @Bean
    public ApplicationRunner batchMetadataChecker(
            @Qualifier("dwDataSource") DataSource dwDataSource) {

        return args -> {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dwDataSource);

            try {
                Integer count = jdbcTemplate.queryForObject(
                        """
                        select count(*)
                        from information_schema.tables
                        where table_schema = 'public'
                          and table_name = 'batch_job_instance'
                        """,
                        Integer.class
                );

                if (count != null && count > 0) {
                    log.info("Spring Batch metadata tables found in DW database.");
                } else {
                    log.warn("Spring Batch metadata tables were NOT found in DW database.");
                    log.warn("Please create tables like BATCH_JOB_INSTANCE, BATCH_JOB_EXECUTION, etc.");
                }

            } catch (Exception e) {
                log.error("Error while checking Spring Batch metadata tables: {}", e.getMessage(), e);
            }
        };
    }
}