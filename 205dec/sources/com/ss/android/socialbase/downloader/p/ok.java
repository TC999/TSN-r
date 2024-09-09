package com.ss.android.socialbase.downloader.p;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f50140a;
    private final boolean bl;
    private final String ok;

    public ok(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.f50140a.incrementAndGet();
        Thread thread = new Thread(runnable, this.ok + "-" + incrementAndGet);
        if (!this.bl) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }

    public ok(String str, boolean z3) {
        this.f50140a = new AtomicInteger();
        this.ok = str;
        this.bl = z3;
    }
}
