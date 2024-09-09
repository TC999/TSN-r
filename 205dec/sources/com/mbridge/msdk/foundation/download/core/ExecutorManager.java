package com.mbridge.msdk.foundation.download.core;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ExecutorManager {
    private static ExecutorManager instance;
    private final ExecutorSupplier executorSupplier;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static final class ClassHolder {
        private static final ExecutorManager EXECUTOR_MANAGER = new ExecutorManager();

        private ClassHolder() {
        }
    }

    public static ExecutorManager getInstance() {
        return ClassHolder.EXECUTOR_MANAGER;
    }

    public static void shutDown() {
        if (instance != null) {
            instance = null;
        }
    }

    public ExecutorSupplier getExecutorSupplier() {
        return this.executorSupplier;
    }

    private ExecutorManager() {
        this.executorSupplier = new DefaultExecutorSupplier();
    }
}
