package com.resterp.spring_batch.common.dimension.processor;

import com.resterp.spring_batch.common.dimension.dto.DimDepartment;
import com.resterp.spring_batch.common.dimension.source.SourceDepartment;
import com.resterp.spring_batch.common.lookup.service.UserFullNameLookupService;
import org.springframework.stereotype.Component;

@Component
public class DepartmentProcessor {

    private final UserFullNameLookupService userFullNameLookupService;

    public DepartmentProcessor(UserFullNameLookupService userFullNameLookupService) {
        this.userFullNameLookupService = userFullNameLookupService;
    }

    public DimDepartment process(SourceDepartment sourceDepartment) {
        DimDepartment dimDepartment = new DimDepartment();

        dimDepartment.setDepartmentId(sourceDepartment.getDepartmentId());
        dimDepartment.setCompanyId(sourceDepartment.getCompanyId());
        dimDepartment.setDepartmentName(sourceDepartment.getName());

        String managerName = null;

        if (sourceDepartment.getSupervisorId() != null && sourceDepartment.getCompanyId() != null) {
            managerName = userFullNameLookupService.findOptionalFullNameByCompanyIdAndUserId(
                    sourceDepartment.getCompanyId(),
                    sourceDepartment.getSupervisorId()
            );
        }

        dimDepartment.setManagerName(managerName);

        return dimDepartment;
    }
}