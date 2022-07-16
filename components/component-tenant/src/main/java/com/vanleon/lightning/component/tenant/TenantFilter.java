package com.vanleon.lightning.component.tenant;

public interface TenantFilter {

    default TenantContext getTenantContext() {
        return TenantContextHolder.get();
    }

    default void setTenantContext(TenantContext tenantContext) {
        TenantContextHolder.set(tenantContext);
    }

    default void removeTenantContext() {
        TenantContextHolder.remove();
    }
}
