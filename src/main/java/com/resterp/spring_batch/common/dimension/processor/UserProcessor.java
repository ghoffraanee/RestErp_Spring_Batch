package com.resterp.spring_batch.common.dimension.processor;


import com.resterp.spring_batch.common.dimension.dto.DimUser;
import com.resterp.spring_batch.common.dimension.source.SourceUser;
import com.resterp.spring_batch.common.tenant.dto.TenantInfo;
import org.springframework.stereotype.Component;

@Component
public class UserProcessor {

    public DimUser process(SourceUser sourceUser, TenantInfo tenantInfo) {
        DimUser dimUser = new DimUser();

        dimUser.setUserId(sourceUser.getUserId() != null ? sourceUser.getUserId().intValue() : null);
        dimUser.setFullName(buildFullName(sourceUser));
        dimUser.setEmail(sourceUser.getEmail());
        dimUser.setType(mapUserType(sourceUser.getType()));
        dimUser.setActive(sourceUser.getActive());
        dimUser.setGender(mapGender(sourceUser.getGender()));

        if (sourceUser.getBirthDate() != null) {
            dimUser.setBirthDate(sourceUser.getBirthDate().toLocalDate());
        }

        if (sourceUser.getContractStart() != null) {
            dimUser.setContractStart(sourceUser.getContractStart().toLocalDate());
        }

        if (sourceUser.getContractEnd() != null) {
            dimUser.setContractEnd(sourceUser.getContractEnd().toLocalDate());
        }

        dimUser.setDepartmentId(sourceUser.getDepartmentId() != null ? sourceUser.getDepartmentId().intValue() : null);

        // Si companies_id existe dans la source, on le prend.
        // Sinon, comme tenant = company, on injecte le tenantId courant.
        if (sourceUser.getCompaniesId() != null) {
            dimUser.setCompanyId(sourceUser.getCompaniesId().intValue());
        } else if (tenantInfo.getTenantId() != null) {
            dimUser.setCompanyId(tenantInfo.getTenantId().intValue());
        } else {
            dimUser.setCompanyId(null);
        }

        return dimUser;
    }

    private String buildFullName(SourceUser sourceUser) {
        if (sourceUser.getName() != null && !sourceUser.getName().isBlank()) {
            return sourceUser.getName().trim();
        }

        String firstName = sourceUser.getFirstname() != null ? sourceUser.getFirstname().trim() : "";
        String lastName = sourceUser.getLastname() != null ? sourceUser.getLastname().trim() : "";

        String fullName = (firstName + " " + lastName).trim();
        return fullName.isBlank() ? null : fullName;
    }

    private String mapGender(Integer gender) {
//        if (gender == null) {
//            return null;
//        }

        return switch (gender) {
            case 0 -> "Male";
            case 1 -> "Female";
            default -> "Unknown";
        };
    }

    private String mapUserType(Integer type) {
//        if (type == null) {
//            return null;
//        }


        return switch (type) {
            case 0 -> "EMPLOYEE";
            case 1 -> "CONTRACTOR";
            case 2 -> "OFFBOARDING";
            case 3 -> "COMPANY_OWNER";
            default -> "UNKNOWN";
        };
    }
}