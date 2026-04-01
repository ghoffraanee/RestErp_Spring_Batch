package com.resterp.spring_batch.common.dimension.source;


public class SourceWorkstatus {

    private Long workstatusId;
    private Long companyId;
    private String statusLabel;

    public SourceWorkstatus() {
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
        return "SourceWorkstatus{" +
                "workstatusId=" + workstatusId +
                ", statusLabel='" + statusLabel + '\'' +
                '}';
    }
}
