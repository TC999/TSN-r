package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class bi implements RejectedExecutionHandler {
    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        ThreadPoolExecutor threadPoolExecutor2;
        ThreadPoolExecutor threadPoolExecutor3;
        LinkedBlockingQueue linkedBlockingQueue;
        ThreadFactory threadFactory;
        az.h("ThreadPoolFactory").e("Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            threadPoolExecutor2 = bf.f12467d;
            if (threadPoolExecutor2 == null) {
                LinkedBlockingQueue unused = bf.f12468e = new LinkedBlockingQueue();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                linkedBlockingQueue = bf.f12468e;
                threadFactory = bf.f12469f;
                ThreadPoolExecutor unused2 = bf.f12467d = new ThreadPoolExecutor(2, 2, 60L, timeUnit, linkedBlockingQueue, threadFactory);
            }
        }
        threadPoolExecutor3 = bf.f12467d;
        threadPoolExecutor3.execute(runnable);
    }
}
