package com.mbridge.msdk.foundation.download.core;

import java.util.concurrent.ExecutorService;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface ExecutorSupplier {
    ExecutorService getBackgroundTasks();

    ExecutorService getDownloadResultTasks();

    DownloadExecutor getDownloadTasks();

    ExecutorService getLruCacheThreadTasks();
}
