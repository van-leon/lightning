package com.vanleon.lightning.component.tenant;

public class TenantContext {

    private final String tenantId;

    public TenantContext(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }
}
