package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.a8;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: BasePool.java */
/* renamed from: com.amap.api.col.3l.b8  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class b8 {

    /* renamed from: a  reason: collision with root package name */
    protected ThreadPoolExecutor f7273a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<a8, Future<?>> f7274b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    protected a8.a f7275c = new a();

    /* compiled from: BasePool.java */
    /* renamed from: com.amap.api.col.3l.b8$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements a8.a {
        a() {
        }

        @Override // com.amap.api.col.p0003l.a8.a
        public final void a(a8 a8Var) {
            b8.this.d(a8Var, true);
        }

        @Override // com.amap.api.col.p0003l.a8.a
        public final void b(a8 a8Var) {
            b8.this.d(a8Var, false);
        }
    }

    private synchronized void c(a8 a8Var, Future<?> future) {
        try {
            this.f7274b.put(a8Var, future);
        } catch (Throwable th) {
            u5.p(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    private synchronized boolean e(a8 a8Var) {
        boolean z3;
        try {
            z3 = this.f7274b.containsKey(a8Var);
        } catch (Throwable th) {
            u5.p(th, "TPool", "contain");
            th.printStackTrace();
            z3 = false;
        }
        return z3;
    }

    public final void a(long j4, TimeUnit timeUnit) {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f7273a;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.awaitTermination(j4, timeUnit);
            }
        } catch (InterruptedException unused) {
        }
    }

    public final void b(a8 a8Var) {
        ThreadPoolExecutor threadPoolExecutor;
        if (e(a8Var) || (threadPoolExecutor = this.f7273a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        a8Var.f7119f = this.f7275c;
        try {
            Future<?> submit = this.f7273a.submit(a8Var);
            if (submit == null) {
                return;
            }
            c(a8Var, submit);
        } catch (RejectedExecutionException e4) {
            u5.p(e4, "TPool", "addTask");
        }
    }

    protected final synchronized void d(a8 a8Var, boolean z3) {
        try {
            Future<?> remove = this.f7274b.remove(a8Var);
            if (z3 && remove != null) {
                remove.cancel(true);
            }
        } catch (Throwable th) {
            u5.p(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    public final Executor f() {
        return this.f7273a;
    }

    public final void g() {
        try {
            for (Map.Entry<a8, Future<?>> entry : this.f7274b.entrySet()) {
                Future<?> future = this.f7274b.get(entry.getKey());
                if (future != null) {
                    try {
                        future.cancel(true);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
            this.f7274b.clear();
        } catch (Throwable th) {
            u5.p(th, "TPool", "destroy");
            th.printStackTrace();
        }
        ThreadPoolExecutor threadPoolExecutor = this.f7273a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }
}
