package com.resterp.spring_batch.common.tenant.dto;

public class TenantInfo {

    private Long tenantId;
    private String tenantCode;
    private String tenantName;
    private String databaseName;
    private String schemaName;
    private Boolean active;
    private Long companyId;

    public TenantInfo() {
    }

    public TenantInfo(Long tenantId, String tenantCode, String tenantName,
                      String databaseName, String schemaName, Boolean active, Long companyId) {
        this.tenantId = tenantId;
        this.tenantCode = tenantCode;
        this.tenantName = tenantName;
        this.databaseName = databaseName;
        this.schemaName = schemaName;
        this.active = active;
        this.companyId = companyId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "TenantInfo{" +
                "tenantId=" + tenantId +
                ", tenantCode='" + tenantCode + '\'' +
                ", tenantName='" + tenantName + '\'' +
                ", databaseName='" + databaseName + '\'' +
                ", schemaName='" + schemaName + '\'' +
                ", active=" + active +
                ", companyId=" + companyId +
                '}';
    }
}