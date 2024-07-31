package com.beizi.p051ad.lance.p062a;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.beizi.ad.lance.a.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiThreadFactory implements ThreadFactory {

    /* renamed from: a */
    private static final AtomicInteger f10796a = new AtomicInteger(1);

    /* renamed from: b */
    private final ThreadGroup f10797b;

    /* renamed from: c */
    private final AtomicInteger f10798c = new AtomicInteger(1);

    /* renamed from: d */
    private final String f10799d;

    /* renamed from: e */
    private final int f10800e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BeiZiThreadFactory(int i, String str) {
        ThreadGroup threadGroup;
        this.f10800e = i;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f10797b = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.f10799d = "BeiZi-adsdk-background-" + f10796a.getAndIncrement() + "-thread-";
            return;
        }
        this.f10799d = str + f10796a.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f10797b;
        Thread thread = new Thread(threadGroup, runnable, this.f10799d + this.f10798c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.f10800e == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}
