package com.amap.api.col.s;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SDKLogHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g2 extends d2 implements Thread.UncaughtExceptionHandler {

    /* renamed from: f  reason: collision with root package name */
    private static WeakReference<Context> f9856f;

    /* renamed from: d  reason: collision with root package name */
    private Context f9858d;

    /* renamed from: e  reason: collision with root package name */
    private static Set<Integer> f9855e = Collections.synchronizedSet(new HashSet());

    /* renamed from: g  reason: collision with root package name */
    private static final ThreadFactory f9857g = new b();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: SDKLogHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a extends z3 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i1 f9859b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f9860c;

        a(i1 i1Var, boolean z3) {
            this.f9859b = i1Var;
            this.f9860c = z3;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            try {
                synchronized (Looper.getMainLooper()) {
                    e2.e(this.f9859b);
                }
                if (this.f9860c) {
                    h2.d(g2.this.f9858d);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: SDKLogHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f9862a = new AtomicInteger(1);

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: SDKLogHandler.java */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        final class a extends Thread {
            a(Runnable runnable, String str) {
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

        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new a(runnable, "pama#" + this.f9862a.getAndIncrement());
        }
    }

    private g2(Context context) {
        this.f9858d = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.f9756a = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f9757b = true;
                return;
            }
            String obj = defaultUncaughtExceptionHandler.toString();
            if (!obj.startsWith("com.amap.apis.utils.core.dynamiccore") && (obj.indexOf("com.amap.api") != -1 || obj.indexOf("com.loc") != -1)) {
                this.f9757b = false;
                return;
            }
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.f9757b = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized g2 g(Context context, i1 i1Var) throws bv {
        synchronized (g2.class) {
            try {
                if (i1Var != null) {
                    if (i1Var.d() != null && !"".equals(i1Var.d())) {
                        if (!f9855e.add(Integer.valueOf(i1Var.hashCode()))) {
                            return (g2) d2.f9755c;
                        }
                        d2 d2Var = d2.f9755c;
                        if (d2Var == null) {
                            d2.f9755c = new g2(context);
                        } else {
                            d2Var.f9757b = false;
                        }
                        d2 d2Var2 = d2.f9755c;
                        d2Var2.c(i1Var, d2Var2.f9757b);
                        return (g2) d2.f9755c;
                    }
                    throw new bv("sdk name is invalid");
                }
                throw new bv("sdk info is null");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void h(i1 i1Var, String str, bv bvVar) {
        j(i1Var, str, bvVar.c(), bvVar.d(), bvVar.e(), bvVar.b());
    }

    public static void i(i1 i1Var, String str, String str2, String str3, String str4) {
        j(i1Var, str, str2, str3, "", str4);
    }

    public static void j(i1 i1Var, String str, String str2, String str3, String str4, String str5) {
        try {
            if (d2.f9755c != null) {
                d2.f9755c.b(i1Var, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static void k() {
        WeakReference<Context> weakReference = f9856f;
        if (weakReference != null && weakReference.get() != null) {
            e2.c(f9856f.get());
            return;
        }
        d2 d2Var = d2.f9755c;
        if (d2Var != null) {
            d2Var.a();
        }
    }

    public static void l(i1 i1Var, String str, String str2) {
        try {
            d2 d2Var = d2.f9755c;
            if (d2Var != null) {
                d2Var.b(i1Var, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized g2 n() {
        g2 g2Var;
        synchronized (g2.class) {
            g2Var = (g2) d2.f9755c;
        }
        return g2Var;
    }

    public static void o(Throwable th, String str, String str2) {
        try {
            d2 d2Var = d2.f9755c;
            if (d2Var != null) {
                d2Var.d(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.d2
    public final void a() {
        e2.c(this.f9858d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.d2
    public final void b(i1 i1Var, String str, String str2) {
        h2.h(i1Var, this.f9858d, str2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.d2
    public final void c(i1 i1Var, boolean z3) {
        try {
            y3.e().c(new a(i1Var, z3));
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.d2
    public final void d(Throwable th, int i4, String str, String str2) {
        h2.g(this.f9858d, th, i4, str, str2);
    }

    public final void m(Throwable th, String str, String str2) {
        if (th == null) {
            return;
        }
        try {
            d(th, 1, str, str2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        d(th, 0, null, null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f9756a;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            this.f9756a.uncaughtException(thread, th);
        }
    }
}
