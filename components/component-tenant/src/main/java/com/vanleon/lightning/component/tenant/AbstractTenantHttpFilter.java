package com.vanleon.lightning.component.tenant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public abstract class AbstractTenantHttpFilter implements Filter, TenantFilter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        doInit(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            TenantContext tenantContext = getTenantContext(request);
            setTenantContext(tenantContext);
            chain.doFilter(request, response);
        } finally {
            removeTenantContext();
        }
    }

    @Override
    public void destroy() {
        doDestroy();
    }

    public abstract TenantContext getTenantContext(ServletRequest request);

    public abstract void doInit(FilterConfig filterConfig);

    public abstract void doDestroy();
}
