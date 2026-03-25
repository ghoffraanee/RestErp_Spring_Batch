package com.resterp.spring_batch.common.dimension.source;

import java.time.LocalDateTime;

public class SourceUser {

    private Long userId;
    private String firstname;
    private String lastname;
    private String name;
    private String email;
    private Integer type;
    private Boolean active;
    private Integer gender;
    private LocalDateTime birthDate;
    private LocalDateTime contractStart;
    private LocalDateTime contractEnd;
    private Long departmentId;
    private Long companiesId;

    public SourceUser() {
    }

    public SourceUser(Long userId, String firstname, String lastname, String name,
                      String email, Integer type, Boolean active, Integer gender,
                      LocalDateTime birthDate, LocalDateTime contractStart,
                      LocalDateTime contractEnd, Long departmentId, Long companiesId) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.name = name;
        this.email = email;
        this.type = type;
        this.active = active;
        this.gender = gender;
        this.birthDate = birthDate;
        this.contractStart = contractStart;
        this.contractEnd = contractEnd;
        this.departmentId = departmentId;
        this.companiesId = companiesId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getContractStart() {
        return contractStart;
    }

    public void setContractStart(LocalDateTime contractStart) {
        this.contractStart = contractStart;
    }

    public LocalDateTime getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(LocalDateTime contractEnd) {
        this.contractEnd = contractEnd;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getCompaniesId() {
        return companiesId;
    }

    public void setCompaniesId(Long companiesId) {
        this.companiesId = companiesId;
    }

    @Override
    public String toString() {
        return "SourceUser{" +
                "userId=" + userId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", active=" + active +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", contractStart=" + contractStart +
                ", contractEnd=" + contractEnd +
                ", departmentId=" + departmentId +
                ", companiesId=" + companiesId +
                '}';
    }
}
