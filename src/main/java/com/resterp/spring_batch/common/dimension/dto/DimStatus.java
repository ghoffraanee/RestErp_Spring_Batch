package com.resterp.spring_batch.common.dimension.dto;


public class DimStatus {

    private Integer statusKey;
    private String statusCode;
    private String statusLabel;
    private String statusGroup;

    public DimStatus() {
    }

    public Integer getStatusKey() {
        return statusKey;
    }

    public void setStatusKey(Integer statusKey) {
        this.statusKey = statusKey;
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
        return "DimStatus{" +
                "statusKey=" + statusKey +
                ", statusCode='" + statusCode + '\'' +
                ", statusLabel='" + statusLabel + '\'' +
                ", statusGroup='" + statusGroup + '\'' +
                '}';
    }
}
