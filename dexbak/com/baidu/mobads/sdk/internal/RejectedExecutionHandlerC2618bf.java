package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.baidu.mobads.sdk.internal.bf */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class RejectedExecutionHandlerC2618bf implements RejectedExecutionHandler {
    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        ThreadPoolExecutor threadPoolExecutor2;
        ThreadPoolExecutor threadPoolExecutor3;
        LinkedBlockingQueue linkedBlockingQueue;
        ThreadFactory threadFactory;
        C2607aw.m50898h("ThreadPoolFactory").mo50864e("Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            threadPoolExecutor2 = C2615bc.f8650d;
            if (threadPoolExecutor2 == null) {
                LinkedBlockingQueue unused = C2615bc.f8651e = new LinkedBlockingQueue();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                linkedBlockingQueue = C2615bc.f8651e;
                threadFactory = C2615bc.f8652f;
                ThreadPoolExecutor unused2 = C2615bc.f8650d = new ThreadPoolExecutor(2, 2, 60L, timeUnit, linkedBlockingQueue, threadFactory);
            }
        }
        threadPoolExecutor3 = C2615bc.f8650d;
        threadPoolExecutor3.execute(runnable);
    }
}
