package com.amap.api.col.s;

import com.amap.api.col.s.z3;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BasePool.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class a4 {

    /* renamed from: a  reason: collision with root package name */
    protected ThreadPoolExecutor f9636a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<z3, Future<?>> f9637b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    protected z3.a f9638c = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BasePool.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements z3.a {
        a() {
        }

        @Override // com.amap.api.col.s.z3.a
        public final void a(z3 z3Var) {
            a4.this.a(z3Var);
        }
    }

    private synchronized void b(z3 z3Var, Future<?> future) {
        try {
            this.f9637b.put(z3Var, future);
        } catch (Throwable th) {
            g2.o(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    private synchronized boolean d(z3 z3Var) {
        boolean z3;
        try {
            z3 = this.f9637b.containsKey(z3Var);
        } catch (Throwable th) {
            g2.o(th, "TPool", "contain");
            th.printStackTrace();
            z3 = false;
        }
        return z3;
    }

    protected final synchronized void a(z3 z3Var) {
        try {
            this.f9637b.remove(z3Var);
        } catch (Throwable th) {
            g2.o(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    public final void c(z3 z3Var) {
        ThreadPoolExecutor threadPoolExecutor;
        if (d(z3Var) || (threadPoolExecutor = this.f9636a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        z3Var.f10552a = this.f9638c;
        try {
            Future<?> submit = this.f9636a.submit(z3Var);
            if (submit == null) {
                return;
            }
            b(z3Var, submit);
        } catch (RejectedExecutionException e4) {
            g2.o(e4, "TPool", "addTask");
        }
    }
}
