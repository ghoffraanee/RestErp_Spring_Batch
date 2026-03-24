package com.resterp.spring_batch.common.dimension.dto;

public class DimCompany {

    private Integer companyKey;
    private Integer companyId;
    private String companyName;
    private String city;

    public DimCompany() {
    }

    public Integer getCompanyKey() {
        return companyKey;
    }

    public void setCompanyKey(Integer companyKey) {
        this.companyKey = companyKey;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "DimCompany{" +
                "companyKey=" + companyKey +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
