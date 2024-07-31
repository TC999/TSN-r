package com.p521ss.android.socialbase.downloader.p555p;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.ss.android.socialbase.downloader.p.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ThreadFactoryC12662ok implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f35725a;

    /* renamed from: bl */
    private final boolean f35726bl;

    /* renamed from: ok */
    private final String f35727ok;

    public ThreadFactoryC12662ok(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.f35725a.incrementAndGet();
        Thread thread = new Thread(runnable, this.f35727ok + "-" + incrementAndGet);
        if (!this.f35726bl) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }

    public ThreadFactoryC12662ok(String str, boolean z) {
        this.f35725a = new AtomicInteger();
        this.f35727ok = str;
        this.f35726bl = z;
    }
}
