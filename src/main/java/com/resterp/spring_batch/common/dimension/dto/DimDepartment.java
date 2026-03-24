package com.resterp.spring_batch.common.dimension.dto;


public class DimDepartment {

    private Integer departmentKey;
    private Integer departmentId;
    private String departmentName;
    private String managerName;

    public DimDepartment() {
    }

    public Integer getDepartmentKey() {
        return departmentKey;
    }

    public void setDepartmentKey(Integer departmentKey) {
        this.departmentKey = departmentKey;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return "DimDepartment{" +
                "departmentKey=" + departmentKey +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", managerName='" + managerName + '\'' +
                '}';
    }
}
