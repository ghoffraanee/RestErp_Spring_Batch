package com.resterp.spring_batch.common.lookup.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class UserKeyLookupService {

    private final JdbcTemplate jdbcTemplate;

    public UserKeyLookupService(@Qualifier("dwDataSource") DataSource dwDataSource) {
        this.jdbcTemplate = new JdbcTemplate(dwDataSource);
    }

    public Integer findUserKeyByCompanyIdAndUserId(Integer companyId, Integer userId) {
        if (companyId == null) {
            throw new IllegalArgumentException("companyId must not be null");
        }

        if (userId == null) {
            throw new IllegalArgumentException("userId must not be null");
        }

        Integer userKey = jdbcTemplate.query(
                """
                select user_key
                from dw.dim_user
                where company_id = ?
                  and user_id = ?
                """,
                rs -> rs.next() ? rs.getInt("user_key") : null,
                companyId,
                userId
        );

        if (userKey == null) {
            throw new IllegalStateException(
                    "No user_key found in dw.dim_user for company_id=" + companyId + " and user_id=" + userId
            );
        }

        return userKey;
    }
}