package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SDKLogHandler.java */
/* renamed from: com.amap.api.col.3l.u5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class u5 extends q5 implements Thread.UncaughtExceptionHandler {

    /* renamed from: e  reason: collision with root package name */
    private static ExecutorService f9153e;

    /* renamed from: g  reason: collision with root package name */
    private static WeakReference<Context> f9155g;

    /* renamed from: d  reason: collision with root package name */
    private Context f9157d;

    /* renamed from: f  reason: collision with root package name */
    private static Set<Integer> f9154f = Collections.synchronizedSet(new HashSet());

    /* renamed from: h  reason: collision with root package name */
    private static final ThreadFactory f9156h = new b();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: SDKLogHandler.java */
    /* renamed from: com.amap.api.col.3l.u5$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p4 f9158a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f9159b;

        a(p4 p4Var, boolean z3) {
            this.f9158a = p4Var;
            this.f9159b = z3;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            try {
                synchronized (Looper.getMainLooper()) {
                    r5.e(this.f9158a);
                }
                if (this.f9159b) {
                    v5.e(u5.this.f9157d);
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
    /* renamed from: com.amap.api.col.3l.u5$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f9161a = new AtomicInteger(1);

        /* compiled from: SDKLogHandler.java */
        /* renamed from: com.amap.api.col.3l.u5$b$a */
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
            return new a(runnable, "pama#" + this.f9161a.getAndIncrement());
        }
    }

    /* compiled from: ErrorLogManager.java */
    /* renamed from: com.amap.api.col.3l.u5$c */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class c extends z7 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a7 f9163a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f9164b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f9165c;

        c(a7 a7Var, Context context, d dVar) {
            this.f9163a = a7Var;
            this.f9164b = context;
            this.f9165c = dVar;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [com.amap.api.col.3l.l7, com.amap.api.col.3l.o7] */
        /* JADX WARN: Type inference failed for: r3v0, types: [com.amap.api.col.3l.i6, com.amap.api.col.3l.j6] */
        /* JADX WARN: Type inference failed for: r5v0, types: [com.amap.api.col.3l.p7, com.amap.api.col.3l.o7] */
        /* JADX WARN: Type inference failed for: r6v0, types: [com.amap.api.col.3l.i6, com.amap.api.col.3l.h6] */
        /* JADX WARN: Type inference failed for: r7v0, types: [com.amap.api.col.3l.i6, com.amap.api.col.3l.k6] */
        /* JADX WARN: Type inference failed for: r9v0, types: [com.amap.api.col.3l.k7, com.amap.api.col.3l.o7] */
        public final void runTask() {
            try {
                synchronized (u5.class) {
                    a7 a7Var = this.f9163a;
                    if (a7Var.g == null) {
                        a7Var.g = new l7(new k7(this.f9164b, new p7(), new h6((i6) new j6((i6) new k6())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", new Object[]{e4.j(this.f9164b), h4.P(), h4.Z(this.f9164b), e4.g(this.f9164b), Build.MODEL, e4.e(this.f9164b), e4.h(this.f9164b), Build.VERSION.RELEASE}));
                    }
                    int a4 = b7.a(this.f9163a);
                    d dVar = this.f9165c;
                    if (dVar != null) {
                        dVar.a(a4);
                    }
                }
            } catch (Throwable th) {
                t5.p(th, "lg", "pul");
            }
        }
    }

    /* compiled from: ErrorLogManager.java */
    /* renamed from: com.amap.api.col.3l.u5$d */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface d {
        void a(int i4);
    }

    private u5(Context context) {
        this.f9157d = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.f8831a = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f8832b = true;
                return;
            }
            String obj = defaultUncaughtExceptionHandler.toString();
            if (!obj.startsWith("com.amap.apis.utils.core.dynamiccore") && (obj.indexOf("com.amap.api") != -1 || obj.indexOf("com.loc") != -1)) {
                this.f8832b = false;
                return;
            }
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.f8832b = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized u5 g(Context context, p4 p4Var) throws fk {
        synchronized (u5.class) {
            try {
                if (p4Var != null) {
                    if (p4Var.a() != null && !"".equals(p4Var.a())) {
                        if (!f9154f.add(Integer.valueOf(p4Var.hashCode()))) {
                            return (u5) q5.f8830c;
                        }
                        q5 q5Var = q5.f8830c;
                        if (q5Var == null) {
                            q5.f8830c = new u5(context);
                        } else {
                            q5Var.f8832b = false;
                        }
                        q5 q5Var2 = q5.f8830c;
                        q5Var2.c(p4Var, q5Var2.f8832b);
                        return (u5) q5.f8830c;
                    }
                    throw new fk("sdk name is invalid");
                }
                throw new fk("sdk info is null");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void h(Context context) {
        if (context == null) {
            return;
        }
        try {
            f9155g = new WeakReference<>(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        } catch (Throwable unused) {
        }
    }

    public static void i(Context context, p4 p4Var, String str, String str2, String str3) {
        v5.g(context, p4Var, str, 0, str2, str3);
    }

    public static void j(p4 p4Var, String str, fk fkVar) {
        if (fkVar != null) {
            l(p4Var, str, fkVar.c(), fkVar.d(), fkVar.e(), fkVar.b());
        }
    }

    public static void k(p4 p4Var, String str, String str2, String str3, String str4) {
        l(p4Var, str, str2, str3, "", str4);
    }

    public static void l(p4 p4Var, String str, String str2, String str3, String str4, String str5) {
        try {
            if (q5.f8830c != null) {
                q5.f8830c.b(p4Var, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void m() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        synchronized (u5.class) {
            try {
                ExecutorService executorService = f9153e;
                if (executorService != null) {
                    executorService.shutdown();
                }
                n6.d();
                if (q5.f8830c != null) {
                    Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                    q5 q5Var = q5.f8830c;
                    if (defaultUncaughtExceptionHandler == q5Var && (uncaughtExceptionHandler = q5Var.f8831a) != null) {
                        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                    }
                }
                q5.f8830c = null;
            }
        }
    }

    public static void n(Context context, p4 p4Var, String str, String str2, String str3) {
        v5.g(context, p4Var, str, 1, str2, str3);
    }

    public static void o(p4 p4Var, String str, String str2) {
        try {
            q5 q5Var = q5.f8830c;
            if (q5Var != null) {
                q5Var.b(p4Var, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void p(Throwable th, String str, String str2) {
        try {
            q5 q5Var = q5.f8830c;
            if (q5Var != null) {
                q5Var.d(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void q() {
        WeakReference<Context> weakReference = f9155g;
        if (weakReference != null && weakReference.get() != null) {
            r5.c(f9155g.get());
            return;
        }
        q5 q5Var = q5.f8830c;
        if (q5Var != null) {
            q5Var.a();
        }
    }

    @Deprecated
    public static synchronized ExecutorService r() {
        ExecutorService executorService;
        synchronized (u5.class) {
            try {
                ExecutorService executorService2 = f9153e;
                if (executorService2 == null || executorService2.isShutdown()) {
                    f9153e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), f9156h);
                }
            } catch (Throwable unused) {
            }
            executorService = f9153e;
        }
        return executorService;
    }

    @Override // com.amap.api.col.p0003l.q5
    protected final void a() {
        r5.c(this.f9157d);
    }

    @Override // com.amap.api.col.p0003l.q5
    protected final void b(p4 p4Var, String str, String str2) {
        v5.l(p4Var, this.f9157d, str2, str);
    }

    @Override // com.amap.api.col.p0003l.q5
    protected final void c(p4 p4Var, boolean z3) {
        try {
            z7.h().b(new a(p4Var, z3));
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.q5
    protected final void d(Throwable th, int i4, String str, String str2) {
        v5.k(this.f9157d, th, i4, str, str2);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        d(th, 0, null, null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f8831a;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            this.f8831a.uncaughtException(thread, th);
        }
    }
}
