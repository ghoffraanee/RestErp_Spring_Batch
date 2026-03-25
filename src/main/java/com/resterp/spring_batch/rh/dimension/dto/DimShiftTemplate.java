package com.resterp.spring_batch.rh.dimension.dto;


import java.math.BigDecimal;
import java.time.LocalTime;

public class DimShiftTemplate {

    private Integer shiftTemplateKey;
    private Integer templateId;
    private Integer companyId;
    private String templateName;
    private LocalTime startTime;
    private LocalTime endTime;
    private BigDecimal workingHoursPlanned;
    private String pattern;

    public DimShiftTemplate() {
    }

    public DimShiftTemplate(Integer shiftTemplateKey, Integer templateId, String templateName,
                            LocalTime startTime, LocalTime endTime,
                            BigDecimal workingHoursPlanned, String pattern) {
        this.shiftTemplateKey = shiftTemplateKey;
        this.templateId = templateId;
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

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
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
                ", templateName='" + templateName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", workingHoursPlanned=" + workingHoursPlanned +
                ", pattern='" + pattern + '\'' +
                '}';
    }
}
