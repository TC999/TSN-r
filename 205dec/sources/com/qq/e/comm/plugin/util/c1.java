package com.qq.e.comm.plugin.util;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c1 {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f46385a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicBoolean f46386b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private static volatile long f46387c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f46388c;

        a(Context context) {
            this.f46388c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c1.e(this.f46388c);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f46389c;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements MessageQueue.IdleHandler {
            a() {
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                try {
                    c1.f(b.this.f46389c);
                    return false;
                } catch (Throwable unused) {
                    return false;
                }
            }
        }

        b(Context context) {
            this.f46389c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.myQueue().addIdleHandler(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f46391c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f46392d;

        c(Context context, boolean z3) {
            this.f46391c = context;
            this.f46392d = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.qq.e.comm.plugin.q0.h a4 = new com.qq.e.comm.plugin.q0.d(this.f46391c).a();
                if (this.f46392d) {
                    com.qq.e.comm.plugin.d0.a.d().c().a(a4.f());
                }
                a4.e();
            } catch (Throwable unused) {
            }
        }
    }

    private static void c(Context context) {
        if (o.c()) {
            new p1().h();
        }
    }

    private static void d(Context context) {
        if (GlobalSetting.isAgreePrivacyStrategy() && com.qq.e.comm.plugin.d0.a.d().f().a("adson", 1) == 1) {
            ((com.qq.e.comm.plugin.m.c.b) com.qq.e.comm.plugin.m.b.f44641g.b()).a(context, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context) {
        g(context);
        h(context);
        c(context);
        com.qq.e.comm.plugin.n.d.a();
        com.qq.e.comm.plugin.util.u2.e.b().a();
        com.qq.e.comm.plugin.p0.e.a().b();
        com.qq.e.comm.plugin.f.b.d().f();
        com.qq.e.comm.plugin.f.e.d().b(context);
        com.qq.e.comm.plugin.l0.h.b.h();
        j(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context) {
        com.qq.e.comm.plugin.apkmanager.k.e().g();
    }

    private static void g(Context context) {
        boolean b4 = r2.b();
        String defaultUserAgent = (!b4 || Build.VERSION.SDK_INT < 17) ? null : WebSettings.getDefaultUserAgent(context);
        if (!TextUtils.isEmpty(defaultUserAgent)) {
            com.qq.e.comm.plugin.d0.a.d().c().a(defaultUserAgent);
            a(context, false);
            return;
        }
        a(context, b4);
    }

    private static void h(Context context) {
        if (r2.c()) {
            com.qq.e.comm.plugin.d0.a.d().c().c();
        }
        com.qq.e.comm.plugin.j.c.a.a();
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                Class.forName("com.qq.e.comm.plugin.util.t1");
            } catch (Exception unused) {
            }
        }
        d(context);
    }

    private static void i(Context context) {
        if (context == null || com.qq.e.comm.plugin.d0.a.d().f().a("bgac", 0) == 0 || !(context.getApplicationContext() instanceof Application)) {
            return;
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(j.b());
    }

    private static void j(Context context) {
        if (System.currentTimeMillis() - u1.a("iret", 0L) < 86400000) {
            return;
        }
        u1.b("iret", System.currentTimeMillis());
        com.qq.e.comm.plugin.s0.b.g();
        z0.b();
        com.qq.e.comm.plugin.f.e.d().e();
        com.qq.e.comm.plugin.apkmanager.x.d.i();
        if (e1.h() >= 460) {
            com.qq.e.comm.plugin.n0.v.a(9130003, null, Integer.valueOf(r2.a()), Integer.valueOf(com.qq.e.comm.plugin.d0.a.d().c().l()), null);
        }
        k(context);
        com.qq.e.comm.plugin.n0.v.a(9200007, null, Integer.valueOf(z1.c() ? 1 : 2), Integer.valueOf(z1.a()), null);
        com.qq.e.comm.plugin.j.c.a.b();
        if (!GlobalSetting.isEnableVideoDownloadingCache()) {
            com.qq.e.comm.plugin.n0.v.a(1130124, (com.qq.e.comm.plugin.n0.c) null);
        }
        z0.a(context);
        com.qq.e.comm.plugin.m0.b.a();
    }

    private static void k(Context context) {
        int i4;
        int i5 = -1;
        try {
            Class.forName("com.tencent.bugly.crashreport.CrashReport");
            i4 = 1;
        } catch (Exception e4) {
            d1.a(e4.getMessage());
            i4 = -1;
        }
        try {
            i5 = context.getApplicationInfo().targetSdkVersion;
        } catch (Exception e5) {
            d1.a(e5.getMessage());
        }
        com.qq.e.comm.plugin.n0.v.a(9200006, null, Integer.valueOf(i4), Integer.valueOf(i5), null);
    }

    public static void a(Context context, JSONObject jSONObject) {
        com.qq.e.comm.plugin.d0.a.d().b(context, jSONObject);
        com.qq.e.comm.plugin.d.d.i().a(context, "e_qq_com_dog");
        v0.a(context);
        com.qq.e.comm.plugin.d0.a.d().f().j();
        u.b().c();
        i(context);
        p.b().a(context);
        if (e1.h() < 560) {
            a((JSONObject) null);
        }
    }

    public static boolean b() {
        return f46385a.get();
    }

    public static void a(JSONObject jSONObject) {
        if (f46385a.compareAndSet(false, true)) {
            f46387c = SystemClock.elapsedRealtime();
            com.qq.e.comm.plugin.d0.a.d().b(jSONObject);
            Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
            com.qq.e.comm.plugin.v.a.a().a(a4);
            com.qq.e.comm.plugin.m0.a.l().a(a4);
            a2.a(a4);
            com.qq.e.comm.plugin.i0.l.f.c().p();
            com.qq.e.comm.plugin.dl.i.a();
            com.qq.e.comm.dynamic.c.a().a(true);
            g2.a().a(true);
            x.c();
            com.qq.e.comm.plugin.edgeanalytics.b.c().d();
            com.qq.e.comm.plugin.edgeanalytics.a.a(1);
            com.qq.e.comm.plugin.apkmanager.e.d().e();
            g.e().a(true);
            d0.f46406b.submit(new a(a4));
            p0.a((Runnable) new b(a4));
            com.qq.e.comm.plugin.n0.v.a();
            f46386b.set(true);
        }
    }

    public static long a() {
        return f46387c;
    }

    private static void a(Context context, boolean z3) {
        boolean z4 = false;
        if ((z3 || com.qq.e.comm.plugin.d0.a.d().f().a("piwv", 0) == 1) ? true : true) {
            p0.d(new c(context, z3));
        }
    }
}
