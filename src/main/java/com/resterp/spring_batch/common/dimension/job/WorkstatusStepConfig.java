package com.resterp.spring_batch.common.dimension.job;

import com.resterp.spring_batch.common.dimension.service.CommonDimensionLoadService;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

public class WorkstatusStepConfig {

    @Bean
    public Step loadDimWorkStatusStep(JobRepository jobRepository,
                                      PlatformTransactionManager transactionManager,
                                      CommonDimensionLoadService commonDimensionLoadService) {

        return new StepBuilder("loadDimWorkStatusStep", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    commonDimensionLoadService.loadAllWorkStatus();
                    return org.springframework.batch.repeat.RepeatStatus.FINISHED;
                }, transactionManager)
                .build();
    }
}
