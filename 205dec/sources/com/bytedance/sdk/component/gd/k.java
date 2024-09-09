package com.bytedance.sdk.component.gd;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k implements ThreadFactory {

    /* renamed from: c  reason: collision with root package name */
    public final String f29843c;
    private final AtomicInteger sr;

    /* renamed from: w  reason: collision with root package name */
    private final ThreadGroup f29844w;
    private int xv;

    public k(String str) {
        this(5, str);
    }

    protected Thread c(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new com.bytedance.sdk.component.gd.sr.xv(threadGroup, runnable, str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f29844w;
        Thread c4 = c(threadGroup, runnable, this.f29843c + "_" + this.sr.getAndIncrement());
        if (c4.isDaemon()) {
            c4.setDaemon(false);
        }
        int i4 = this.xv;
        if (i4 > 10) {
            this.xv = 10;
        } else if (i4 < 1) {
            this.xv = 1;
        }
        c4.setPriority(this.xv);
        return c4;
    }

    public k(int i4, String str) {
        this.sr = new AtomicInteger(1);
        this.xv = i4;
        this.f29844w = new ThreadGroup("csj_g_" + str);
        StringBuilder sb = new StringBuilder();
        sb.append("csj_");
        sb.append(a.f29806w.f() ? "p" : "");
        sb.append(str);
        this.f29843c = sb.toString();
    }
}
