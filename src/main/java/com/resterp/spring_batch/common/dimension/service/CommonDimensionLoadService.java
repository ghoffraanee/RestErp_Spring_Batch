package com.resterp.spring_batch.common.dimension.service;

import com.resterp.spring_batch.common.dimension.dto.DimUser;
import com.resterp.spring_batch.common.dimension.processor.UserProcessor;
import com.resterp.spring_batch.common.dimension.reader.UserReader;
import com.resterp.spring_batch.common.dimension.source.SourceUser;
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

    public CommonDimensionLoadService(TenantContextService tenantContextService,
                                      UserReader userReader,
                                      UserProcessor userProcessor,
                                      JdbcBatchItemWriter<DimUser> userWriter) {
        this.tenantContextService = tenantContextService;
        this.userReader = userReader;
        this.userProcessor = userProcessor;
        this.userWriter = userWriter;
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
}