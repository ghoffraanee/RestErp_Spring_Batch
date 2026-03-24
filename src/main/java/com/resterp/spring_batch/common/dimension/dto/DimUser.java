package com.resterp.spring_batch.common.dimension.dto;


import java.time.LocalDate;

public class DimUser {

    private Integer userKey;
    private Integer userId;
    private String fullName;
    private String email;
    private String type;
    private Boolean active;
    private String gender;
    private LocalDate birthDate;
    private LocalDate contractStart;
    private LocalDate contractEnd;
    private Integer departmentId;
    private Integer companyId;

    public DimUser() {
    }

    public Integer getUserKey() {
        return userKey;
    }

    public void setUserKey(Integer userKey) {
        this.userKey = userKey;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getContractStart() {
        return contractStart;
    }

    public void setContractStart(LocalDate contractStart) {
        this.contractStart = contractStart;
    }

    public LocalDate getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(LocalDate contractEnd) {
        this.contractEnd = contractEnd;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "DimUser{" +
                "userKey=" + userKey +
                ", userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", active=" + active +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", contractStart=" + contractStart +
                ", contractEnd=" + contractEnd +
                ", departmentId=" + departmentId +
                ", companyId=" + companyId +
                '}';
    }
}
