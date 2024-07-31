package com.baidu.mobads.sdk.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.bd */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ThreadFactoryC2616bd implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f8654a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "TaskScheduler #" + this.f8654a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new C2617be(this));
        return thread;
    }
}
