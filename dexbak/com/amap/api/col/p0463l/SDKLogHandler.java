package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Looper;
import com.kwad.components.p208ad.splashscreen.monitor.SplashMonitorInfo;
import com.stub.StubApp;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.amap.api.col.3l.t5 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SDKLogHandler extends BasicLogHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: e */
    private static ExecutorService f5380e;

    /* renamed from: g */
    private static WeakReference<Context> f5382g;

    /* renamed from: d */
    private Context f5384d;

    /* renamed from: f */
    private static Set<Integer> f5381f = Collections.synchronizedSet(new HashSet());

    /* renamed from: h */
    private static final ThreadFactory f5383h = new ThreadFactoryC1948b();

    /* compiled from: SDKLogHandler.java */
    /* renamed from: com.amap.api.col.3l.t5$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1947a extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ SDKInfo f5385a;

        /* renamed from: b */
        final /* synthetic */ boolean f5386b;

        C1947a(SDKInfo sDKInfo, boolean z) {
            this.f5385a = sDKInfo;
            this.f5386b = z;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            try {
                synchronized (Looper.getMainLooper()) {
                    Log.m54110e(this.f5385a);
                }
                if (this.f5386b) {
                    ErrorLogManager.m53783e(SDKLogHandler.this.f5384d);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: SDKLogHandler.java */
    /* renamed from: com.amap.api.col.3l.t5$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class ThreadFactoryC1948b implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f5388a = new AtomicInteger(1);

        /* compiled from: SDKLogHandler.java */
        /* renamed from: com.amap.api.col.3l.t5$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        final class C1949a extends Thread {
            C1949a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        }

        ThreadFactoryC1948b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new C1949a(runnable, "pama#" + this.f5388a.getAndIncrement());
        }
    }

    private SDKLogHandler(Context context) {
        this.f5384d = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.f5074a = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f5075b = true;
                return;
            }
            String obj = defaultUncaughtExceptionHandler.toString();
            if (!obj.startsWith("com.amap.apis.utils.core.dynamiccore") && (obj.indexOf("com.amap.api") != -1 || obj.indexOf("com.loc") != -1)) {
                this.f5075b = false;
                return;
            }
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.f5075b = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: g */
    public static synchronized SDKLogHandler m53872g(Context context, SDKInfo sDKInfo) throws AMapCoreException {
        synchronized (SDKLogHandler.class) {
            try {
                if (sDKInfo != null) {
                    if (sDKInfo.m54400a() != null && !"".equals(sDKInfo.m54400a())) {
                        if (!f5381f.add(Integer.valueOf(sDKInfo.hashCode()))) {
                            return (SDKLogHandler) BasicLogHandler.f5073c;
                        }
                        BasicLogHandler basicLogHandler = BasicLogHandler.f5073c;
                        if (basicLogHandler == null) {
                            BasicLogHandler.f5073c = new SDKLogHandler(context);
                        } else {
                            basicLogHandler.f5075b = false;
                        }
                        BasicLogHandler basicLogHandler2 = BasicLogHandler.f5073c;
                        basicLogHandler2.mo53875c(sDKInfo, basicLogHandler2.f5075b);
                        return (SDKLogHandler) BasicLogHandler.f5073c;
                    }
                    throw new AMapCoreException("sdk name is invalid");
                }
                throw new AMapCoreException("sdk info is null");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: h */
    public static void m53871h(Context context) {
        if (context == null) {
            return;
        }
        try {
            f5382g = new WeakReference<>(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i */
    public static void m53870i(Context context, SDKInfo sDKInfo, String str, String str2, String str3) {
        ErrorLogManager.m53781g(context, sDKInfo, str, 0, str2, str3);
    }

    /* renamed from: j */
    public static void m53869j(SDKInfo sDKInfo, String str, AMapCoreException aMapCoreException) {
        if (aMapCoreException != null) {
            m53867l(sDKInfo, str, aMapCoreException.m55003c(), aMapCoreException.m55002d(), aMapCoreException.m55001e(), aMapCoreException.m55004b());
        }
    }

    /* renamed from: k */
    public static void m53868k(SDKInfo sDKInfo, String str, String str2, String str3, String str4) {
        m53867l(sDKInfo, str, str2, str3, "", str4);
    }

    /* renamed from: l */
    public static void m53867l(SDKInfo sDKInfo, String str, String str2, String str3, String str4, String str5) {
        try {
            if (BasicLogHandler.f5073c != null) {
                BasicLogHandler.f5073c.mo53876b(sDKInfo, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, SplashMonitorInfo.ERROR_NET_MSG);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: m */
    public static synchronized void m53866m() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        synchronized (SDKLogHandler.class) {
            try {
                ExecutorService executorService = f5380e;
                if (executorService != null) {
                    executorService.shutdown();
                }
                DiskLruCache.m54501d();
                if (BasicLogHandler.f5073c != null) {
                    Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                    BasicLogHandler basicLogHandler = BasicLogHandler.f5073c;
                    if (defaultUncaughtExceptionHandler == basicLogHandler && (uncaughtExceptionHandler = basicLogHandler.f5074a) != null) {
                        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                    }
                }
                BasicLogHandler.f5073c = null;
            }
        }
    }

    /* renamed from: n */
    public static void m53865n(Context context, SDKInfo sDKInfo, String str, String str2, String str3) {
        ErrorLogManager.m53781g(context, sDKInfo, str, 1, str2, str3);
    }

    /* renamed from: o */
    public static void m53864o(SDKInfo sDKInfo, String str, String str2) {
        try {
            BasicLogHandler basicLogHandler = BasicLogHandler.f5073c;
            if (basicLogHandler != null) {
                basicLogHandler.mo53876b(sDKInfo, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: p */
    public static void m53863p(Throwable th, String str, String str2) {
        try {
            BasicLogHandler basicLogHandler = BasicLogHandler.f5073c;
            if (basicLogHandler != null) {
                basicLogHandler.mo53874d(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: q */
    public static void m53862q() {
        WeakReference<Context> weakReference = f5382g;
        if (weakReference != null && weakReference.get() != null) {
            Log.m54112c(f5382g.get());
            return;
        }
        BasicLogHandler basicLogHandler = BasicLogHandler.f5073c;
        if (basicLogHandler != null) {
            basicLogHandler.mo53877a();
        }
    }

    @Deprecated
    /* renamed from: r */
    public static synchronized ExecutorService m53861r() {
        ExecutorService executorService;
        synchronized (SDKLogHandler.class) {
            try {
                ExecutorService executorService2 = f5380e;
                if (executorService2 == null || executorService2.isShutdown()) {
                    f5380e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), f5383h);
                }
            } catch (Throwable unused) {
            }
            executorService = f5380e;
        }
        return executorService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0463l.BasicLogHandler
    /* renamed from: a */
    public final void mo53877a() {
        Log.m54112c(this.f5384d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0463l.BasicLogHandler
    /* renamed from: b */
    public final void mo53876b(SDKInfo sDKInfo, String str, String str2) {
        ErrorLogManager.m53776l(sDKInfo, this.f5384d, str2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0463l.BasicLogHandler
    /* renamed from: c */
    public final void mo53875c(SDKInfo sDKInfo, boolean z) {
        try {
            ThreadPool.m53398h().m55654b(new C1947a(sDKInfo, z));
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0463l.BasicLogHandler
    /* renamed from: d */
    public final void mo53874d(Throwable th, int i, String str, String str2) {
        ErrorLogManager.m53777k(this.f5384d, th, i, str, str2);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        mo53874d(th, 0, null, null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f5074a;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            this.f5074a.uncaughtException(thread, th);
        }
    }
}
