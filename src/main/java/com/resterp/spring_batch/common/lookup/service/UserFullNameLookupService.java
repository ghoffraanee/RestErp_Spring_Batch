package com.resterp.spring_batch.common.lookup.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class UserFullNameLookupService {

    private final JdbcTemplate jdbcTemplate;

    public UserFullNameLookupService(@Qualifier("dwDataSource") DataSource dwDataSource) {
        this.jdbcTemplate = new JdbcTemplate(dwDataSource);
    }

    public String findFullNameByCompanyIdAndUserId(Long companyId, Long userId) {
        String fullName = findOptionalFullNameByCompanyIdAndUserId(companyId, userId);

        if (fullName == null) {
            throw new IllegalStateException(
                    "No full_name found in dw.dim_user for company_id=" + companyId + " and user_id=" + userId
            );
        }

        return fullName;
    }

    public String findOptionalFullNameByCompanyIdAndUserId(Long companyId, Long userId) {
        if (companyId == null) {
            throw new IllegalArgumentException("companyId must not be null");
        }

        if (userId == null) {
            throw new IllegalArgumentException("userId must not be null");
        }

        return jdbcTemplate.query(
                """
                select full_name
                from dw.dim_user
                where company_id = ?
                  and user_id = ?
                """,
                rs -> rs.next() ? rs.getString("full_name") : null,
                companyId,
                userId
        );
    }
}