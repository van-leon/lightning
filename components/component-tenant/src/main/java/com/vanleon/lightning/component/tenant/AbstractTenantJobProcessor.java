package com.vanleon.lightning.component.tenant;

import java.util.List;

public abstract class AbstractTenantJobProcessor<T> implements TenantFilter {

    public void process(T jobParam) {
        List<TenantContext> tenantContextList = listTenantContext(jobParam);
        for (TenantContext tenantContext : tenantContextList) {
            setTenantContext(tenantContext);
            try {
                doProcess(jobParam);
            } finally {
                removeTenantContext();
            }
        }
    }

    public abstract List<TenantContext> listTenantContext(T jobParam);

    public abstract void doProcess(T jobParam);
}
