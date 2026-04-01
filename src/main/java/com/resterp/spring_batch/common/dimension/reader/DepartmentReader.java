package com.resterp.spring_batch.common.dimension.reader;

import com.resterp.spring_batch.common.dimension.source.SourceDepartment;
import com.resterp.spring_batch.common.tenant.dto.TenantInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class DepartmentReader {

    private final JdbcTemplate jdbcTemplate;

    public DepartmentReader(@Qualifier("erpDataSource") DataSource erpDataSource) {
        this.jdbcTemplate = new JdbcTemplate(erpDataSource);
    }

    public List<SourceDepartment> readDepartments(TenantInfo tenantInfo) {
        String schemaName = tenantInfo.getSchemaName();

        String sql = """
                select
                    id,
                    name,
                    supervisor_id
                from %s.department
                order by id
                """.formatted(schemaName);

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            SourceDepartment department = new SourceDepartment();

            department.setDepartmentId(rs.getLong("id"));
            department.setName(rs.getString("name"));

            Object supervisorIdObj = rs.getObject("supervisor_id");
            if (supervisorIdObj != null) {
                department.setSupervisorId(((Number) supervisorIdObj).longValue());
            }

            // companyId injecté depuis le tenant courant
            if (tenantInfo.getTenantId() != null) {
                department.setCompanyId(tenantInfo.getCompanyId());
            }

            return department;
        });
    }
}
