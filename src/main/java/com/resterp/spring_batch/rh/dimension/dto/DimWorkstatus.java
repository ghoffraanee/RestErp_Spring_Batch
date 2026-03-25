package com.resterp.spring_batch.rh.dimension.dto;


public class DimWorkstatus {

    private Integer workstatusKey;
    private Integer workstatusId;
    private String statusCode;
    private String statusLabel;
    private String statusGroup;

    public DimWorkstatus() {
    }

    public DimWorkstatus(Integer workstatusKey, Integer workstatusId, String statusCode,
                         String statusLabel, String statusGroup) {
        this.workstatusKey = workstatusKey;
        this.workstatusId = workstatusId;
        this.statusCode = statusCode;
        this.statusLabel = statusLabel;
        this.statusGroup = statusGroup;
    }

    public Integer getWorkstatusKey() {
        return workstatusKey;
    }

    public void setWorkstatusKey(Integer workstatusKey) {
        this.workstatusKey = workstatusKey;
    }

    public Integer getWorkstatusId() {
        return workstatusId;
    }

    public void setWorkstatusId(Integer workstatusId) {
        this.workstatusId = workstatusId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }

    public String getStatusGroup() {
        return statusGroup;
    }

    public void setStatusGroup(String statusGroup) {
        this.statusGroup = statusGroup;
    }

    @Override
    public String toString() {
        return "DimWorkstatus{" +
                "workstatusKey=" + workstatusKey +
                ", workstatusId=" + workstatusId +
                ", statusCode='" + statusCode + '\'' +
                ", statusLabel='" + statusLabel + '\'' +
                ", statusGroup='" + statusGroup + '\'' +
                '}';
    }
}
