package com.resterp.spring_batch.common.tenant.provider;

import com.resterp.spring_batch.common.tenant.dto.TenantInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implémentation future basée sur la vraie base super admin.
 *
 * IMPORTANT :
 * - Cette classe n'est pas activée pour le moment.
 * - Quand la structure réelle de la base super admin sera connue,
 *   il faudra :
 *   1) décommenter @Service
 *   2) adapter la requête SQL
 *   3) adapter les noms des colonnes
 */
// @Service
public class DatabaseTenantProvider implements TenantProvider {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseTenantProvider(@Qualifier("superAdminDataSource") DataSource superAdminDataSource) {
        this.jdbcTemplate = new JdbcTemplate(superAdminDataSource);
    }

    @Override
    public List<TenantInfo> getAllTenants() {
        return jdbcTemplate.query(
                """
                select
                    tenant_id,
                    tenant_code,
                    tenant_name,
                    database_name,
                    schema_name,
                    active,
                    company_id
                from tenant_registry
                """,
                (rs, rowNum) -> new TenantInfo(
                        rs.getLong("tenant_id"),              // À adapter plus tard si le nom réel de colonne change
                        rs.getString("tenant_code"),          // À adapter plus tard si le nom réel de colonne change
                        rs.getString("tenant_name"),          // À adapter plus tard si le nom réel de colonne change
                        rs.getString("database_name"),        // À adapter plus tard si le nom réel de colonne change
                        rs.getString("schema_name"),          // À adapter plus tard si le nom réel de colonne change
                        rs.getBoolean("active"),            // À adapter plus tard si le nom réel de colonne change
                        rs.getLong("company_id")
                )
        );
    }

    @Override
    public List<TenantInfo> getActiveTenants() {
        return getAllTenants()
                .stream()
                .filter(tenant -> Boolean.TRUE.equals(tenant.getActive()))
                .collect(Collectors.toList());
    }
}