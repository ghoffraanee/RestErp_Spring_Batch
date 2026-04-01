package com.resterp.spring_batch.common.dimension.processor;

import com.resterp.spring_batch.common.dimension.dto.DimWorkstatus;
import com.resterp.spring_batch.common.dimension.source.SourceWorkstatus;
import org.springframework.stereotype.Component;

@Component
public class WorkstatusProcessor {

    public DimWorkstatus process(SourceWorkstatus source) {
        DimWorkstatus dim = new DimWorkstatus();

        dim.setWorkstatusId(source.getWorkstatusId());
        dim.setStatusLabel(source.getStatusLabel());

        return dim;
    }
}
