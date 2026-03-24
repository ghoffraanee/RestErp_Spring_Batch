package com.resterp.spring_batch.common.tenant.provider;

import com.resterp.spring_batch.common.tenant.dto.TenantInfo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implémentation temporaire.
 * À remplacer plus tard par DatabaseTenantProvider
 * quand la vraie structure de la base super admin sera disponible.
 */
@Service
@Primary
public class StaticTenantProvider implements TenantProvider {

    @Override
    public List<TenantInfo> getAllTenants() {
        return List.of(
                new TenantInfo(
                        1L,                 // À modifier plus tard : vrai tenant_id venant de la BDD super admin
                        "TENANT_ALPHA",     // À modifier plus tard : vrai tenant_code
                        "Alpha Company",    // À modifier plus tard : vrai tenant_name
                        "erp_mt_db",        // À modifier plus tard : vrai database_name si nécessaire
                        "alpha",            // À modifier plus tard : vrai schema_name
                        true                // À modifier plus tard : vraie valeur active
                ),
                new TenantInfo(
                        2L,                 // À modifier plus tard : vrai tenant_id venant de la BDD super admin
                        "TENANT_BETA",      // À modifier plus tard : vrai tenant_code
                        "Beta Company",     // À modifier plus tard : vrai tenant_name
                        "erp_mt_db",        // À modifier plus tard : vrai database_name si nécessaire
                        "beta",             // À modifier plus tard : vrai schema_name
                        true                // À modifier plus tard : vraie valeur active
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