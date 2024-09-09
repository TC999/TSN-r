package com.bytedance.sdk.component.gd.c;

import com.bytedance.sdk.component.gd.a;
import com.bytedance.sdk.component.gd.k;
import java.util.concurrent.ThreadFactory;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements ThreadFactory {

    /* renamed from: c  reason: collision with root package name */
    private final ThreadFactory f29834c;

    /* renamed from: w  reason: collision with root package name */
    private final int f29835w;

    public sr(ThreadFactory threadFactory, int i4) {
        if (threadFactory == null) {
            this.f29834c = new k("default");
        } else {
            this.f29834c = threadFactory;
        }
        this.f29835w = i4;
    }

    public final String c() {
        return this.f29834c.getClass().getName();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f29834c.newThread(runnable);
        return w() ? new r(newThread) : newThread;
    }

    protected boolean w() {
        return a.f29806w.c(this.f29835w);
    }
}
