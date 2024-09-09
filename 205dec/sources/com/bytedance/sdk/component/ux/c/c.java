package com.bytedance.sdk.component.ux.c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements ThreadFactory {

    /* renamed from: c  reason: collision with root package name */
    private final ThreadGroup f30232c;

    /* renamed from: w  reason: collision with root package name */
    private final AtomicInteger f30233w = new AtomicInteger(1);

    public c(String str) {
        this.f30232c = new ThreadGroup("tt_img_" + str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f30232c;
        com.bytedance.sdk.component.gd.sr.xv xvVar = new com.bytedance.sdk.component.gd.sr.xv(threadGroup, runnable, "tt_img_" + this.f30233w.getAndIncrement());
        if (xvVar.isDaemon()) {
            xvVar.setDaemon(false);
        }
        return xvVar;
    }
}
