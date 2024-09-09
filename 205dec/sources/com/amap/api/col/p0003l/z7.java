package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.y7;
import java.lang.Thread;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ThreadPool.java */
/* renamed from: com.amap.api.col.3l.z7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class z7 extends b8 {

    /* renamed from: d  reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f9588d = new a();

    /* renamed from: e  reason: collision with root package name */
    private static z7 f9589e = new z7(new y7.b().d(f9588d).c("amap-global-threadPool").h());

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ThreadPool.java */
    /* renamed from: com.amap.api.col.3l.z7$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Thread.UncaughtExceptionHandler {
        a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th) {
            u5.p(th, "TPool", "ThreadPool");
        }
    }

    private z7(y7 y7Var) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(y7Var.a(), y7Var.b(), y7Var.d(), TimeUnit.SECONDS, y7Var.c(), y7Var);
            this.f7273a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            u5.p(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static z7 h() {
        return f9589e;
    }

    public static z7 i(y7 y7Var) {
        return new z7(y7Var);
    }

    @Deprecated
    public static synchronized z7 j() {
        z7 z7Var;
        synchronized (z7.class) {
            if (f9589e == null) {
                f9589e = new z7(new y7.b().d(f9588d).h());
            }
            z7Var = f9589e;
        }
        return z7Var;
    }

    @Deprecated
    public static z7 k() {
        return new z7(new y7.b().d(f9588d).h());
    }
}
