package com.vanleon.lightning.component.tenant;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.Objects;

public class TenantContextHolder {

    private static final TransmittableThreadLocal<TenantContext> LOCAL = new TransmittableThreadLocal<>();

    protected static void set(TenantContext tenantContext) {
        Objects.requireNonNull(tenantContext, "tenant context can not be null");
        LOCAL.set(tenantContext);
    }

    protected static TenantContext get() {
        TenantContext tenantContext = LOCAL.get();
        Objects.requireNonNull(tenantContext, "tenant context can not be null");
        return tenantContext;
    }

    protected static void remove() {
        LOCAL.remove();
    }
}
