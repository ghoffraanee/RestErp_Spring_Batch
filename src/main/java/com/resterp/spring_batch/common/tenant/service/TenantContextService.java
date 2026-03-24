package com.resterp.spring_batch.common.tenant.service;

import com.resterp.spring_batch.common.tenant.dto.TenantInfo;
import com.resterp.spring_batch.common.tenant.provider.TenantProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantContextService {

    private final TenantProvider tenantProvider;

    public TenantContextService(TenantProvider tenantProvider) {
        this.tenantProvider = tenantProvider;
    }

    public List<TenantInfo> getAllTenants() {
        return tenantProvider.getAllTenants();
    }

    public List<TenantInfo> getActiveTenants() {
        return tenantProvider.getActiveTenants();
    }

    public TenantInfo getTenantByCode(String tenantCode) {
        return tenantProvider.getAllTenants()
                .stream()
                .filter(tenant -> tenant.getTenantCode() != null)
                .filter(tenant -> tenant.getTenantCode().equalsIgnoreCase(tenantCode))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("No tenant found with code: " + tenantCode));
    }

    public TenantInfo getTenantBySchema(String schemaName) {
        return tenantProvider.getAllTenants()
                .stream()
                .filter(tenant -> tenant.getSchemaName() != null)
                .filter(tenant -> tenant.getSchemaName().equalsIgnoreCase(schemaName))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("No tenant found with schema: " + schemaName));
    }
}