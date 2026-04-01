package com.resterp.spring_batch.common.dimension.job;

import com.resterp.spring_batch.common.dimension.service.CommonDimensionLoadService;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DepartmentStepConfig {

    @Bean
    public Step loadDimDepartmentStep(JobRepository jobRepository,
                                      PlatformTransactionManager transactionManager,
                                      CommonDimensionLoadService commonDimensionLoadService) {

        return new StepBuilder("loadDimDepartmentStep", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    commonDimensionLoadService.loadAllDepartments();
                    return org.springframework.batch.repeat.RepeatStatus.FINISHED;
                }, transactionManager)
                .build();
    }
}
