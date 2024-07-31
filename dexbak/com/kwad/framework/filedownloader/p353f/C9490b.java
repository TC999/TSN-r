package com.kwad.framework.filedownloader.p353f;

import com.kwad.sdk.core.threads.C10512c;
import com.kwad.sdk.core.threads.p410a.C10509b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.kwad.framework.filedownloader.f.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9490b {
    private static volatile ThreadPoolExecutor aii;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.framework.filedownloader.f.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class ThreadFactoryC9491a implements ThreadFactory {
        private static final AtomicInteger aij = new AtomicInteger(1);
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        ThreadFactoryC9491a(String str) {
            this.namePrefix = C9501f.m28504bx(str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.group;
            Thread thread = new Thread(threadGroup, runnable, "ksad-" + this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    @Deprecated
    /* renamed from: a */
    public static ThreadPoolExecutor m28553a(int i, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        if (m28550wJ()) {
            return m28549wK();
        }
        C10509b c10509b = new C10509b(i, i, 15L, TimeUnit.SECONDS, linkedBlockingQueue, new ThreadFactoryC9491a(str));
        C10512c.m25576a(c10509b, "ksad-" + str);
        c10509b.allowCoreThreadTimeOut(true);
        return c10509b;
    }

    @Deprecated
    /* renamed from: bq */
    public static ThreadPoolExecutor m28552bq(String str) {
        if (m28550wJ()) {
            return m28549wK();
        }
        C10509b c10509b = new C10509b(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryC9491a(str));
        C10512c.m25576a(c10509b, "ksad-" + str);
        return c10509b;
    }

    @Deprecated
    /* renamed from: o */
    public static ThreadPoolExecutor m28551o(int i, String str) {
        if (m28550wJ()) {
            return m28549wK();
        }
        return m28553a(i, new LinkedBlockingQueue(), str);
    }

    /* renamed from: wJ */
    private static boolean m28550wJ() {
        InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
        if (interfaceC10970h != null) {
            return interfaceC10970h.mo24324wJ();
        }
        return false;
    }

    /* renamed from: wK */
    private static ThreadPoolExecutor m28549wK() {
        if (aii == null) {
            synchronized (C9490b.class) {
                if (aii == null) {
                    C10509b c10509b = new C10509b(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC9491a(""));
                    aii = c10509b;
                    C10512c.m25576a(c10509b, "ksad-filedownload-default");
                }
            }
        }
        return aii;
    }
}
