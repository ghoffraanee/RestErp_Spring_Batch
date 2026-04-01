package com.resterp.spring_batch.common.dimension.source;

import java.time.LocalDateTime;

public class SourceDepartment {

    private Long departmentId;
    private String name;
    private Long companyId;
    private Long supervisorId;


    public SourceDepartment() {
    }

    public SourceDepartment(Long departmentId, String name,
                            Long companyId, Long supervisorId) {
        this.departmentId = departmentId;
        this.name = name;
        this.companyId = companyId;
        this.supervisorId = supervisorId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }


    @Override
    public String toString() {
        return "SourceDepartment{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", companyId=" + companyId +
                ", supervisorId=" + supervisorId +
                '}';
    }
}
