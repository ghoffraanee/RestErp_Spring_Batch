package com.resterp.spring_batch.common.dimension.service;

import com.resterp.spring_batch.common.dimension.dto.DimDepartment;
import com.resterp.spring_batch.common.dimension.dto.DimUser;
import com.resterp.spring_batch.common.dimension.dto.DimWorkstatus;
import com.resterp.spring_batch.common.dimension.processor.DepartmentProcessor;
import com.resterp.spring_batch.common.dimension.processor.UserProcessor;
import com.resterp.spring_batch.common.dimension.processor.WorkstatusProcessor;
import com.resterp.spring_batch.common.dimension.reader.DepartmentReader;
import com.resterp.spring_batch.common.dimension.reader.UserReader;
import com.resterp.spring_batch.common.dimension.reader.WorkstatusReader;
import com.resterp.spring_batch.common.dimension.source.SourceDepartment;
import com.resterp.spring_batch.common.dimension.source.SourceUser;
import com.resterp.spring_batch.common.dimension.source.SourceWorkstatus;
import com.resterp.spring_batch.common.tenant.dto.TenantInfo;
import com.resterp.spring_batch.common.tenant.service.TenantContextService;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommonDimensionLoadService {

    private final TenantContextService tenantContextService;

    private final UserReader userReader;
    private final UserProcessor userProcessor;
    private final JdbcBatchItemWriter<DimUser> userWriter;

    private final DepartmentReader departmentReader;
    private final DepartmentProcessor departmentProcessor;
    private final JdbcBatchItemWriter<DimDepartment> departmentWriter;

    private final WorkstatusReader workstatusReader;
    private final WorkstatusProcessor workstatusProcessor;
    private final JdbcBatchItemWriter<DimWorkstatus> workstatusWriter;

    public CommonDimensionLoadService(TenantContextService tenantContextService,
                                      UserReader userReader,
                                      UserProcessor userProcessor,
                                      JdbcBatchItemWriter<DimUser> userWriter,
                                      DepartmentReader departmentReader,
                                      DepartmentProcessor departmentProcessor,
                                      JdbcBatchItemWriter<DimDepartment> departmentWriter,
                                      WorkstatusReader workstatusReader,
                                      WorkstatusProcessor workstatusProcessor,
                                      JdbcBatchItemWriter<DimWorkstatus> workstatusWriter) {
        this.tenantContextService = tenantContextService;
        this.userReader = userReader;
        this.userProcessor = userProcessor;
        this.userWriter = userWriter;
        this.departmentReader = departmentReader;
        this.departmentProcessor = departmentProcessor;
        this.departmentWriter = departmentWriter;
        this.workstatusReader = workstatusReader;
        this.workstatusProcessor = workstatusProcessor;
        this.workstatusWriter = workstatusWriter;
    }

    public void loadAllUsers() throws Exception {
        List<TenantInfo> activeTenants = tenantContextService.getActiveTenants();

        for (TenantInfo tenantInfo : activeTenants) {
            List<SourceUser> sourceUsers = userReader.readUsers(tenantInfo);
            List<DimUser> dimUsers = new ArrayList<>();

            for (SourceUser sourceUser : sourceUsers) {
                DimUser dimUser = userProcessor.process(sourceUser, tenantInfo);
                if (dimUser != null) {
                    dimUsers.add(dimUser);
                }
            }

            if (!dimUsers.isEmpty()) {
                userWriter.write(new Chunk<>(dimUsers));
            }
        }
    }

    public void loadAllDepartments() throws Exception {
        List<TenantInfo> activeTenants = tenantContextService.getActiveTenants();

        for (TenantInfo tenantInfo : activeTenants) {
            List<SourceDepartment> sourceDepartments = departmentReader.readDepartments(tenantInfo);
            List<DimDepartment> dimDepartments = new ArrayList<>();

            for (SourceDepartment sourceDepartment : sourceDepartments) {
                DimDepartment dimDepartment = departmentProcessor.process(sourceDepartment);
                if (dimDepartment != null) {
                    dimDepartments.add(dimDepartment);
                }
            }

            if (!dimDepartments.isEmpty()) {
                departmentWriter.write(new Chunk<>(dimDepartments));
            }
        }
    }

    public void loadAllWorkstatus() throws Exception {
        List<TenantInfo> activeTenants = tenantContextService.getActiveTenants();

        for (TenantInfo tenantInfo : activeTenants) {
            List<SourceWorkstatus> sourceWorkstatuses = workstatusReader.readWorkstatus(tenantInfo);
            List<DimWorkstatus> dimWorkstatuses = new ArrayList<>();

            for (SourceWorkstatus sourceWorkstatus : sourceWorkstatuses) {
                DimWorkstatus dimWorkstatus = workstatusProcessor.process(sourceWorkstatus);
                if (dimWorkstatus != null) {
                    dimWorkstatuses.add(dimWorkstatus);
                }
            }

            if (!dimWorkstatuses.isEmpty()) {
                workstatusWriter.write(new Chunk<>(dimWorkstatuses));
            }
        }
    }
}