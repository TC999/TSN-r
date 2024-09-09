package com.beizi.fusion.g;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiThreadFactory.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class k implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f14942a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private final ThreadGroup f14943b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f14944c = new AtomicInteger(1);

    /* renamed from: d  reason: collision with root package name */
    private final String f14945d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14946e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(int i4, String str) {
        ThreadGroup threadGroup;
        this.f14946e = i4;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f14943b = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.f14945d = "afBg-" + f14942a.getAndIncrement() + "Td-";
            return;
        }
        this.f14945d = str + f14942a.getAndIncrement() + "Td-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f14943b;
        Thread thread = new Thread(threadGroup, runnable, this.f14945d + this.f14944c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.f14946e == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}
