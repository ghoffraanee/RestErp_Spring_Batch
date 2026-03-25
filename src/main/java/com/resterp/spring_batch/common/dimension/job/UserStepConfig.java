package com.resterp.spring_batch.common.dimension.job;

import com.resterp.spring_batch.common.dimension.service.CommonDimensionLoadService;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class UserStepConfig {

    @Bean
    public Step loadDimUserStep(JobRepository jobRepository,
                                PlatformTransactionManager transactionManager,
                                CommonDimensionLoadService commonDimensionLoadService) {

        return new StepBuilder("loadDimUserStep", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    commonDimensionLoadService.loadAllUsers();
                    return org.springframework.batch.repeat.RepeatStatus.FINISHED;
                }, transactionManager)
                .build();
    }
}
