package com.resterp.spring_batch.common.dimension.writer;

import com.resterp.spring_batch.common.dimension.dto.DimUser;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class UserWriterConfig {

    @Bean
    public JdbcBatchItemWriter<DimUser> userWriter(
            @Qualifier("dwDataSource") DataSource dwDataSource) {

        return new JdbcBatchItemWriterBuilder<DimUser>()
                .dataSource(dwDataSource)
                .sql("""
                        insert into dw.dim_user
                        (
                            user_id,
                            full_name,
                            email,
                            type,
                            active,
                            gender,
                            birth_date,
                            contract_start,
                            contract_end,
                            department_id,
                            company_id
                        )
                        values
                        (
                            :userId,
                            :fullName,
                            :email,
                            :type,
                            :active,
                            :gender,
                            :birthDate,
                            :contractStart,
                            :contractEnd,
                            :departmentId,
                            :companyId
                        )
                        on conflict (company_id, user_id)
                        do update set
                            full_name = excluded.full_name,
                            email = excluded.email,
                            type = excluded.type,
                            active = excluded.active,
                            gender = excluded.gender,
                            birth_date = excluded.birth_date,
                            contract_start = excluded.contract_start,
                            contract_end = excluded.contract_end,
                            department_id = excluded.department_id
                        """)
                .beanMapped()
                .build();
    }
}