package com.amap.api.col.p047s;

import com.amap.api.col.p047s.ThreadFactoryC2209x3;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPool.java */
/* renamed from: com.amap.api.col.s.y3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2225y3 extends AbstractC2019a4 {

    /* renamed from: d */
    private static C2225y3 f6819d = new C2225y3(new ThreadFactoryC2209x3.C2211b().m52266a("amap-global-threadPool").m52265b());

    private C2225y3(ThreadFactoryC2209x3 threadFactoryC2209x3) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadFactoryC2209x3.m52277a(), threadFactoryC2209x3.m52276b(), threadFactoryC2209x3.m52274d(), TimeUnit.SECONDS, threadFactoryC2209x3.m52275c(), threadFactoryC2209x3);
            this.f5886a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            C2060g2.m52972o(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    public static C2225y3 m52184e() {
        return f6819d;
    }
}
