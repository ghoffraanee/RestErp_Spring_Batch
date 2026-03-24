package com.resterp.spring_batch.common.dimension.dto;


import java.time.LocalDateTime;

public class DimJobOffer {

    private Integer jobOfferKey;      // PK (surrogate key)
    private Integer jobOfferId;       // ID source
    private String title;
    private String contractType;
    private Integer departmentId;
    private String status;
    private LocalDateTime postingDate;
    private Integer createdByUserId;

    // ===== Constructeurs =====

    public DimJobOffer() {
    }

    public DimJobOffer(Integer jobOfferKey, Integer jobOfferId, String title,
                       String contractType, Integer departmentId,
                       String status, LocalDateTime postingDate,
                       Integer createdByUserId) {
        this.jobOfferKey = jobOfferKey;
        this.jobOfferId = jobOfferId;
        this.title = title;
        this.contractType = contractType;
        this.departmentId = departmentId;
        this.status = status;
        this.postingDate = postingDate;
        this.createdByUserId = createdByUserId;
    }

    // ===== Getters & Setters =====

    public Integer getJobOfferKey() {
        return jobOfferKey;
    }

    public void setJobOfferKey(Integer jobOfferKey) {
        this.jobOfferKey = jobOfferKey;
    }

    public Integer getJobOfferId() {
        return jobOfferId;
    }

    public void setJobOfferId(Integer jobOfferId) {
        this.jobOfferId = jobOfferId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDateTime postingDate) {
        this.postingDate = postingDate;
    }

    public Integer getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Integer createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    // ===== toString =====

    @Override
    public String toString() {
        return "DimJobOffer{" +
                "jobOfferKey=" + jobOfferKey +
                ", jobOfferId=" + jobOfferId +
                ", title='" + title + '\'' +
                ", contractType='" + contractType + '\'' +
                ", departmentId=" + departmentId +
                ", status='" + status + '\'' +
                ", postingDate=" + postingDate +
                ", createdByUserId=" + createdByUserId +
                '}';
    }
}
