package com.resterp.spring_batch.common.dimension.writer;

import com.resterp.spring_batch.common.dimension.dto.DimDepartment;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DepartmentWriterConfig {

    @Bean
    public JdbcBatchItemWriter<DimDepartment> departmentWriter(
            @Qualifier("dwDataSource") DataSource dwDataSource) {

        return new JdbcBatchItemWriterBuilder<DimDepartment>()
                .dataSource(dwDataSource)
                .sql("""
                        insert into dw.dim_department
                        (
                            department_id,
                            company_id,
                            department_name,
                            manager_name
                        )
                        values
                        (
                            :departmentId,
                            :companyId,
                            :departmentName,
                            :managerName
                        )
                        on conflict (company_id, department_id)
                        do update set
                            department_name = excluded.department_name,
                            manager_name = excluded.manager_name
                        """)
                .beanMapped()
                .build();
    }
}
