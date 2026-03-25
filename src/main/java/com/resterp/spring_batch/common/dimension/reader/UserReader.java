package com.resterp.spring_batch.common.dimension.reader;

import com.resterp.spring_batch.common.dimension.source.SourceUser;
import com.resterp.spring_batch.common.tenant.dto.TenantInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

@Component
public class UserReader {

    private final JdbcTemplate jdbcTemplate;

    public UserReader(@Qualifier("erpDataSource") DataSource erpDataSource) {
        this.jdbcTemplate = new JdbcTemplate(erpDataSource);
    }

    public List<SourceUser> readUsers(TenantInfo tenant) {
        String schemaName = tenant.getSchemaName();

        String sql = """
                select
                    user_id,
                    firstname,
                    lastname,
                    name,
                    email,
                    type,
                    active,
                    gender,
                    birth_date,
                    contract_start,
                    contract_end,
                    department_id,
                    companies_id
                from %s.users_table
                order by user_id
                """.formatted(schemaName);

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            SourceUser user = new SourceUser();

            user.setUserId(rs.getLong("user_id"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setType((Integer) rs.getObject("type"));
            user.setActive((Boolean) rs.getObject("active"));
            user.setGender((Integer) rs.getObject("gender"));

            Timestamp birthDateTs = rs.getTimestamp("birth_date");
            if (birthDateTs != null) {
                user.setBirthDate(birthDateTs.toLocalDateTime());
            }

            Timestamp contractStartTs = rs.getTimestamp("contract_start");
            if (contractStartTs != null) {
                user.setContractStart(contractStartTs.toLocalDateTime());
            }

            Timestamp contractEndTs = rs.getTimestamp("contract_end");
            if (contractEndTs != null) {
                user.setContractEnd(contractEndTs.toLocalDateTime());
            }

            user.setDepartmentId((Long) rs.getObject("department_id"));
            user.setCompaniesId((Long) rs.getObject("companies_id"));

            return user;
        });
    }
}