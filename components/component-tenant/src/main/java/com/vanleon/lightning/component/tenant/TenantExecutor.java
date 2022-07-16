package com.vanleon.lightning.component.tenant;

import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class TenantExecutor {

    public static Executor getTtlExecutor(Executor executor) {
        return TtlExecutors.getTtlExecutor(executor);
    }

    public static ExecutorService getTtlExecutor(ExecutorService executorService) {
        return TtlExecutors.getTtlExecutorService(executorService);
    }

    public static ScheduledExecutorService getTtlScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        return TtlExecutors.getTtlScheduledExecutorService(scheduledExecutorService);
    }
}
