package com.resterp.spring_batch.common.lookup.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class DepartmentKeyLookupService {

    private final JdbcTemplate jdbcTemplate;

    public DepartmentKeyLookupService(@Qualifier("dwDataSource") DataSource dwDataSource) {
        this.jdbcTemplate = new JdbcTemplate(dwDataSource);
    }

    public Integer findDepartmentKeyByCompanyIdAndDepartmentId(Long companyId, Long departmentId) {
        Integer departmentKey = findOptionalDepartmentKeyByCompanyIdAndDepartmentId(companyId, departmentId);

        if (departmentKey == null) {
            throw new IllegalStateException(
                    "No department_key found in dw.dim_department for company_id=" + companyId +
                            " and department_id=" + departmentId
            );
        }

        return departmentKey;
    }

    public Integer findOptionalDepartmentKeyByCompanyIdAndDepartmentId(Long companyId, Long departmentId) {
        if (companyId == null) {
            throw new IllegalArgumentException("companyId must not be null");
        }

        if (departmentId == null) {
            throw new IllegalArgumentException("departmentId must not be null");
        }

        return jdbcTemplate.query(
                """
                select department_key
                from dw.dim_department
                where company_id = ?
                  and department_id = ?
                """,
                rs -> rs.next() ? rs.getInt("department_key") : null,
                companyId,
                departmentId
        );
    }
}
