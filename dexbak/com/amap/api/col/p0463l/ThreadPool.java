package com.amap.api.col.p0463l;

import com.amap.api.col.p0463l.BasicThreadFactory;
import java.lang.Thread;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.amap.api.col.3l.y7 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ThreadPool extends BasePool {

    /* renamed from: d */
    private static Thread.UncaughtExceptionHandler f5788d = new C2007a();

    /* renamed from: e */
    private static ThreadPool f5789e = new ThreadPool(new BasicThreadFactory.C1988b().m53509d(f5788d).m53510c("amap-global-threadPool").m53505h());

    /* compiled from: ThreadPool.java */
    /* renamed from: com.amap.api.col.3l.y7$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C2007a implements Thread.UncaughtExceptionHandler {
        C2007a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th) {
            SDKLogHandler.m53863p(th, "TPool", "ThreadPool");
        }
    }

    private ThreadPool(BasicThreadFactory basicThreadFactory) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(basicThreadFactory.m53523a(), basicThreadFactory.m53522b(), basicThreadFactory.m53520d(), TimeUnit.SECONDS, basicThreadFactory.m53521c(), basicThreadFactory);
            this.f3563a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    /* renamed from: h */
    public static ThreadPool m53398h() {
        return f5789e;
    }

    /* renamed from: i */
    public static ThreadPool m53397i(BasicThreadFactory basicThreadFactory) {
        return new ThreadPool(basicThreadFactory);
    }

    @Deprecated
    /* renamed from: j */
    public static synchronized ThreadPool m53396j() {
        ThreadPool threadPool;
        synchronized (ThreadPool.class) {
            if (f5789e == null) {
                f5789e = new ThreadPool(new BasicThreadFactory.C1988b().m53509d(f5788d).m53505h());
            }
            threadPool = f5789e;
        }
        return threadPool;
    }

    @Deprecated
    /* renamed from: k */
    public static ThreadPool m53395k() {
        return new ThreadPool(new BasicThreadFactory.C1988b().m53509d(f5788d).m53505h());
    }
}
