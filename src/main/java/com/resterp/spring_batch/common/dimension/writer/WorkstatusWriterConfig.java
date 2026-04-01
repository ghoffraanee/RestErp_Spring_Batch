package com.resterp.spring_batch.common.dimension.writer;

import com.resterp.spring_batch.common.dimension.dto.DimWorkstatus;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class WorkstatusWriterConfig {

    @Bean
    public JdbcBatchItemWriter<DimWorkstatus> workstatusWriter(
            @Qualifier("dwDataSource") DataSource dwDataSource) {

        return new JdbcBatchItemWriterBuilder<DimWorkstatus>()
                .dataSource(dwDataSource)
                .sql("""
                        insert into dw.dim_workstatus
                        (
                            workstatus_id,
                            status_label
                        )
                        values
                        (
                            :workstatusId,
                            :statusLabel
                        )
                        on conflict (workstatus_id)
                        do update set
                            status_label = excluded.status_label,
                        """)
                .beanMapped()
                .build();
    }
}
