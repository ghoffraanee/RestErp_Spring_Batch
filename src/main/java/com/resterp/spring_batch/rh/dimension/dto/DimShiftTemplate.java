package com.resterp.spring_batch.rh.dimension.dto;


import java.math.BigDecimal;
import java.time.LocalTime;

public class DimShiftTemplate {

    private Integer shiftTemplateKey;
    private Long templateId;
    private Long companyId;
    private String templateName;
    private LocalTime startTime;
    private LocalTime endTime;
    private BigDecimal workingHoursPlanned;
    private String pattern;

    public DimShiftTemplate() {
    }

    public DimShiftTemplate(Integer shiftTemplateKey, Long templateId, Long companyId, String templateName,
                            LocalTime startTime, LocalTime endTime,
                            BigDecimal workingHoursPlanned, String pattern) {
        this.shiftTemplateKey = shiftTemplateKey;
        this.templateId = templateId;
        this.companyId = companyId;
        this.templateName = templateName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workingHoursPlanned = workingHoursPlanned;
        this.pattern = pattern;
    }

    public Integer getShiftTemplateKey() {
        return shiftTemplateKey;
    }

    public void setShiftTemplateKey(Integer shiftTemplateKey) {
        this.shiftTemplateKey = shiftTemplateKey;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getWorkingHoursPlanned() {
        return workingHoursPlanned;
    }

    public void setWorkingHoursPlanned(BigDecimal workingHoursPlanned) {
        this.workingHoursPlanned = workingHoursPlanned;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "DimShiftTemplate{" +
                "shiftTemplateKey=" + shiftTemplateKey +
                ", templateId=" + templateId +
                ", companyId=" + companyId +
                ", templateName='" + templateName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", workingHoursPlanned=" + workingHoursPlanned +
                ", pattern='" + pattern + '\'' +
                '}';
    }
}
