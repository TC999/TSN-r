package com.amap.api.col.s;

import com.amap.api.col.s.x3;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ThreadPool.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class y3 extends a4 {

    /* renamed from: d  reason: collision with root package name */
    private static y3 f10542d = new y3(new x3.b().a("amap-global-threadPool").b());

    private y3(x3 x3Var) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(x3Var.a(), x3Var.b(), x3Var.d(), TimeUnit.SECONDS, x3Var.c(), x3Var);
            this.f9636a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            g2.o(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static y3 e() {
        return f10542d;
    }
}
