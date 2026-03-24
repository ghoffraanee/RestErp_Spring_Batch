package com.resterp.spring_batch.common.tenant.provider;

import com.resterp.spring_batch.common.tenant.dto.TenantInfo;

import java.util.List;

public interface TenantProvider {

    List<TenantInfo> getAllTenants();

    List<TenantInfo> getActiveTenants();
}