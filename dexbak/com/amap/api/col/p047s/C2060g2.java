package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Looper;
import com.kwad.components.p208ad.splashscreen.monitor.SplashMonitorInfo;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SDKLogHandler.java */
/* renamed from: com.amap.api.col.s.g2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2060g2 extends C2041d2 implements Thread.UncaughtExceptionHandler {

    /* renamed from: f */
    private static WeakReference<Context> f6128f;

    /* renamed from: d */
    private Context f6130d;

    /* renamed from: e */
    private static Set<Integer> f6127e = Collections.synchronizedSet(new HashSet());

    /* renamed from: g */
    private static final ThreadFactory f6129g = new ThreadFactoryC2062b();

    /* compiled from: SDKLogHandler.java */
    /* renamed from: com.amap.api.col.s.g2$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C2061a extends AbstractRunnableC2229z3 {

        /* renamed from: b */
        final /* synthetic */ C2073i1 f6131b;

        /* renamed from: c */
        final /* synthetic */ boolean f6132c;

        C2061a(C2073i1 c2073i1, boolean z) {
            this.f6131b = c2073i1;
            this.f6132c = z;
        }

        @Override // com.amap.api.col.p047s.AbstractRunnableC2229z3
        /* renamed from: a */
        public final void mo52171a() {
            try {
                synchronized (Looper.getMainLooper()) {
                    C2051e2.m53021e(this.f6131b);
                }
                if (this.f6132c) {
                    C2068h2.m52956d(C2060g2.this.f6130d);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: SDKLogHandler.java */
    /* renamed from: com.amap.api.col.s.g2$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class ThreadFactoryC2062b implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f6134a = new AtomicInteger(1);

        /* compiled from: SDKLogHandler.java */
        /* renamed from: com.amap.api.col.s.g2$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        final class C2063a extends Thread {
            C2063a(Runnable runnable, String str) {
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

        ThreadFactoryC2062b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new C2063a(runnable, "pama#" + this.f6134a.getAndIncrement());
        }
    }

    private C2060g2(Context context) {
        this.f6130d = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.f6028a = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f6029b = true;
                return;
            }
            String obj = defaultUncaughtExceptionHandler.toString();
            if (!obj.startsWith("com.amap.apis.utils.core.dynamiccore") && (obj.indexOf("com.amap.api") != -1 || obj.indexOf("com.loc") != -1)) {
                this.f6029b = false;
                return;
            }
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.f6029b = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: g */
    public static synchronized C2060g2 m52980g(Context context, C2073i1 c2073i1) throws C2022bv {
        synchronized (C2060g2.class) {
            try {
                if (c2073i1 != null) {
                    if (c2073i1.m52918d() != null && !"".equals(c2073i1.m52918d())) {
                        if (!f6127e.add(Integer.valueOf(c2073i1.hashCode()))) {
                            return (C2060g2) C2041d2.f6027c;
                        }
                        C2041d2 c2041d2 = C2041d2.f6027c;
                        if (c2041d2 == null) {
                            C2041d2.f6027c = new C2060g2(context);
                        } else {
                            c2041d2.f6029b = false;
                        }
                        C2041d2 c2041d22 = C2041d2.f6027c;
                        c2041d22.mo52983c(c2073i1, c2041d22.f6029b);
                        return (C2060g2) C2041d2.f6027c;
                    }
                    throw new C2022bv("sdk name is invalid");
                }
                throw new C2022bv("sdk info is null");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: h */
    public static void m52979h(C2073i1 c2073i1, String str, C2022bv c2022bv) {
        m52977j(c2073i1, str, c2022bv.m53213c(), c2022bv.m53212d(), c2022bv.m53211e(), c2022bv.m53214b());
    }

    /* renamed from: i */
    public static void m52978i(C2073i1 c2073i1, String str, String str2, String str3, String str4) {
        m52977j(c2073i1, str, str2, str3, "", str4);
    }

    /* renamed from: j */
    public static void m52977j(C2073i1 c2073i1, String str, String str2, String str3, String str4, String str5) {
        try {
            if (C2041d2.f6027c != null) {
                C2041d2.f6027c.mo52984b(c2073i1, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, SplashMonitorInfo.ERROR_NET_MSG);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: k */
    public static void m52976k() {
        WeakReference<Context> weakReference = f6128f;
        if (weakReference != null && weakReference.get() != null) {
            C2051e2.m53023c(f6128f.get());
            return;
        }
        C2041d2 c2041d2 = C2041d2.f6027c;
        if (c2041d2 != null) {
            c2041d2.mo52985a();
        }
    }

    /* renamed from: l */
    public static void m52975l(C2073i1 c2073i1, String str, String str2) {
        try {
            C2041d2 c2041d2 = C2041d2.f6027c;
            if (c2041d2 != null) {
                c2041d2.mo52984b(c2073i1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: n */
    public static synchronized C2060g2 m52973n() {
        C2060g2 c2060g2;
        synchronized (C2060g2.class) {
            c2060g2 = (C2060g2) C2041d2.f6027c;
        }
        return c2060g2;
    }

    /* renamed from: o */
    public static void m52972o(Throwable th, String str, String str2) {
        try {
            C2041d2 c2041d2 = C2041d2.f6027c;
            if (c2041d2 != null) {
                c2041d2.mo52982d(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.C2041d2
    /* renamed from: a */
    public final void mo52985a() {
        C2051e2.m53023c(this.f6130d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.C2041d2
    /* renamed from: b */
    public final void mo52984b(C2073i1 c2073i1, String str, String str2) {
        C2068h2.m52952h(c2073i1, this.f6130d, str2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.C2041d2
    /* renamed from: c */
    public final void mo52983c(C2073i1 c2073i1, boolean z) {
        try {
            C2225y3.m52184e().m53246c(new C2061a(c2073i1, z));
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.C2041d2
    /* renamed from: d */
    public final void mo52982d(Throwable th, int i, String str, String str2) {
        C2068h2.m52953g(this.f6130d, th, i, str, str2);
    }

    /* renamed from: m */
    public final void m52974m(Throwable th, String str, String str2) {
        if (th == null) {
            return;
        }
        try {
            mo52982d(th, 1, str, str2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        mo52982d(th, 0, null, null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f6028a;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            this.f6028a.uncaughtException(thread, th);
        }
    }
}
