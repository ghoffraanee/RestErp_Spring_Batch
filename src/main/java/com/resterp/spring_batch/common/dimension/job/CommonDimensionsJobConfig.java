package com.resterp.spring_batch.common.dimension.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonDimensionsJobConfig {

    @Bean
    public Job loadCommonDimensionsJob(JobRepository jobRepository,
                                       Step loadDimUserStep,
                                       Step loadDimDepartmentStep) {

        return new JobBuilder("loadCommonDimensionsJob", jobRepository)
                .start(loadDimUserStep)
                .next(loadDimDepartmentStep)
                .next()
                .build();
    }
}
