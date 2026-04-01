package com.resterp.spring_batch.common.lookup.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class WorkstatusKeyLookupService {

    private final JdbcTemplate jdbcTemplate;

    public WorkstatusKeyLookupService(@Qualifier("dwDataSource") DataSource dwDataSource) {
        this.jdbcTemplate = new JdbcTemplate(dwDataSource);
    }

    public Integer findWorkstatusKeyByCompanyIdAndWorkstatusId(Long companyId, Long workstatusId) {
        Integer workstatusKey = findOptionalWorkstatusKeyByCompanyIdAndWorkstatusId(companyId, workstatusId);

        if (workstatusKey == null) {
            throw new IllegalStateException(
                    "No workstatust_key found in dw.dim_workstatus for company_id=" + companyId +
                            " and workstatus_id=" + workstatusId
            );
        }

        return workstatusKey;
    }

    public Integer findOptionalWorkstatusKeyByCompanyIdAndWorkstatusId(Long companyId, Long workstatusId) {
        if (companyId == null) {
            throw new IllegalArgumentException("companyId must not be null");
        }

        if (workstatusId == null) {
            throw new IllegalArgumentException("workstatusId must not be null");
        }

        return jdbcTemplate.query(
                """
                select workstatus_key
                from dw.dim_workstatus
                where company_id = ?
                  and workstatus_id = ?
                """,
                rs -> rs.next() ? rs.getInt("workstatus_key") : null,
                companyId,
                workstatusId
        );
    }

}
