package com.resterp.spring_batch.common.dimension.reader;

import com.resterp.spring_batch.common.dimension.source.SourceWorkstatus;
import com.resterp.spring_batch.common.tenant.dto.TenantInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class WorkstatusReader {

    private final JdbcTemplate jdbcTemplate;

    public WorkstatusReader(@Qualifier("erpDataSource") DataSource erpDataSource) {
        this.jdbcTemplate = new JdbcTemplate(erpDataSource);
    }

    public List<SourceWorkstatus> readWorkstatus(TenantInfo tenantInfo) {
        String schema = tenantInfo.getSchemaName();

        String sql = """
                select
                    id,
                    columnname
                from %s.workstatus
                """.formatted(schema);

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            SourceWorkstatus ws = new SourceWorkstatus();

            ws.setWorkstatusId(rs.getLong("id"));
            ws.setStatusLabel(rs.getString("columnname"));
            ws.setCompanyId(tenantInfo.getCompanyId());

            return ws;
        });
    }
}
