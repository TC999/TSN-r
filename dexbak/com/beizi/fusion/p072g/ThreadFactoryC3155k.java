package com.beizi.fusion.p072g;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BeiZiThreadFactory.java */
/* renamed from: com.beizi.fusion.g.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ThreadFactoryC3155k implements ThreadFactory {

    /* renamed from: a */
    private static final AtomicInteger f11387a = new AtomicInteger(1);

    /* renamed from: b */
    private final ThreadGroup f11388b;

    /* renamed from: c */
    private final AtomicInteger f11389c = new AtomicInteger(1);

    /* renamed from: d */
    private final String f11390d;

    /* renamed from: e */
    private final int f11391e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadFactoryC3155k(int i, String str) {
        ThreadGroup threadGroup;
        this.f11391e = i;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f11388b = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.f11390d = "afBg-" + f11387a.getAndIncrement() + "Td-";
            return;
        }
        this.f11390d = str + f11387a.getAndIncrement() + "Td-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f11388b;
        Thread thread = new Thread(threadGroup, runnable, this.f11390d + this.f11389c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.f11391e == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}
