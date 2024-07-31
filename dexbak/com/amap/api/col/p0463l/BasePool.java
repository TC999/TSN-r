package com.amap.api.col.p0463l;

import com.amap.api.col.p0463l.ThreadTask;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.amap.api.col.3l.a8 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class BasePool {

    /* renamed from: a */
    protected ThreadPoolExecutor f3563a;

    /* renamed from: b */
    private ConcurrentHashMap<ThreadTask, Future<?>> f3564b = new ConcurrentHashMap<>();

    /* renamed from: c */
    protected ThreadTask.InterfaceC2012a f3565c = new C1738a();

    /* compiled from: BasePool.java */
    /* renamed from: com.amap.api.col.3l.a8$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class C1738a implements ThreadTask.InterfaceC2012a {
        C1738a() {
        }

        @Override // com.amap.api.col.p0463l.ThreadTask.InterfaceC2012a
        /* renamed from: a */
        public final void mo53313a(ThreadTask threadTask) {
            BasePool.this.m55652d(threadTask, true);
        }

        @Override // com.amap.api.col.p0463l.ThreadTask.InterfaceC2012a
        /* renamed from: b */
        public final void mo53312b(ThreadTask threadTask) {
            BasePool.this.m55652d(threadTask, false);
        }
    }

    /* renamed from: c */
    private synchronized void m55653c(ThreadTask threadTask, Future<?> future) {
        try {
            this.f3564b.put(threadTask, future);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    private synchronized boolean m55651e(ThreadTask threadTask) {
        boolean z;
        try {
            z = this.f3564b.containsKey(threadTask);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "TPool", "contain");
            th.printStackTrace();
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public final void m55655a(long j, TimeUnit timeUnit) {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f3563a;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.awaitTermination(j, timeUnit);
            }
        } catch (InterruptedException unused) {
        }
    }

    /* renamed from: b */
    public final void m55654b(ThreadTask threadTask) {
        ThreadPoolExecutor threadPoolExecutor;
        if (m55651e(threadTask) || (threadPoolExecutor = this.f3563a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        threadTask.f5833f = this.f3565c;
        try {
            Future<?> submit = this.f3563a.submit(threadTask);
            if (submit == null) {
                return;
            }
            m55653c(threadTask, submit);
        } catch (RejectedExecutionException e) {
            SDKLogHandler.m53863p(e, "TPool", "addTask");
        }
    }

    /* renamed from: d */
    protected final synchronized void m55652d(ThreadTask threadTask, boolean z) {
        try {
            Future<?> remove = this.f3564b.remove(threadTask);
            if (z && remove != null) {
                remove.cancel(true);
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    /* renamed from: f */
    public final Executor m55650f() {
        return this.f3563a;
    }

    /* renamed from: g */
    public final void m55649g() {
        try {
            for (Map.Entry<ThreadTask, Future<?>> entry : this.f3564b.entrySet()) {
                Future<?> future = this.f3564b.get(entry.getKey());
                if (future != null) {
                    try {
                        future.cancel(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.f3564b.clear();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "TPool", "destroy");
            th.printStackTrace();
        }
        ThreadPoolExecutor threadPoolExecutor = this.f3563a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }
}
