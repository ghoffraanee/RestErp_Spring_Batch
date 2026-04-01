package com.resterp.spring_batch.common.dimension.dto;


public class DimWorkstatus {

    private Integer workstatusKey;
    private Long workstatusId;
    private Long companyId;
    private String statusLabel;

    public DimWorkstatus() {
    }

    public DimWorkstatus(Integer workstatusKey, Long workstatusId, Long companyId, String statusLabel) {
        this.workstatusKey = workstatusKey;
        this.workstatusId = workstatusId;
        this.companyId = companyId;
        this.statusLabel = statusLabel;
    }

    public Integer getWorkstatusKey() {
        return workstatusKey;
    }

    public void setWorkstatusKey(Integer workstatusKey) {
        this.workstatusKey = workstatusKey;
    }

    public Long getWorkstatusId() {
        return workstatusId;
    }

    public void setWorkstatusId(Long workstatusId) {
        this.workstatusId = workstatusId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }

    @Override
    public String toString() {
        return "DimWorkstatus{" +
                "workstatusKey=" + workstatusKey +
                ", workstatusId=" + workstatusId +
                ", companyId=" + companyId +
                ", statusLabel='" + statusLabel + '\'' +
                '}';
    }
}
