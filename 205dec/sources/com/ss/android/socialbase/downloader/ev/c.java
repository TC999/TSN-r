package com.ss.android.socialbase.downloader.ev;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c implements ThreadFactory {

    /* renamed from: c  reason: collision with root package name */
    private final String f49534c;

    /* renamed from: w  reason: collision with root package name */
    private final AtomicInteger f49535w;
    private final boolean xv;

    public c(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.f49535w.incrementAndGet();
        com.bytedance.sdk.component.gd.sr.xv xvVar = new com.bytedance.sdk.component.gd.sr.xv(runnable, this.f49534c + "-" + incrementAndGet);
        if (!this.xv) {
            if (xvVar.isDaemon()) {
                xvVar.setDaemon(false);
            }
            if (xvVar.getPriority() != 5) {
                xvVar.setPriority(5);
            }
        }
        return xvVar;
    }

    public c(String str, boolean z3) {
        this.f49535w = new AtomicInteger();
        this.f49534c = str;
        this.xv = z3;
    }
}
