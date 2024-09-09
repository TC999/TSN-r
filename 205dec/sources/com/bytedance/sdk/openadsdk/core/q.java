package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class q {

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f34486c;

    /* renamed from: f  reason: collision with root package name */
    private static volatile Handler f34487f;

    /* renamed from: w  reason: collision with root package name */
    public static AtomicBoolean f34488w = new AtomicBoolean(false);
    public static AtomicBoolean xv = new AtomicBoolean(false);
    public static AtomicBoolean sr = new AtomicBoolean(false);
    public static final long ux = SystemClock.elapsedRealtime();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static final class c implements com.bytedance.sdk.component.ux.ys {
        private c() {
        }

        @Override // com.bytedance.sdk.component.ux.ys
        @ATSMethod(1)
        public com.bytedance.sdk.component.ux.p c(String str) {
            return com.bytedance.sdk.openadsdk.r.w.c().c(str);
        }

        @Override // com.bytedance.sdk.component.ux.ys
        @ATSMethod(3)
        public void w(double d4) {
            com.bytedance.sdk.openadsdk.r.w.c().w(d4);
        }

        @Override // com.bytedance.sdk.component.ux.ys
        @ATSMethod(4)
        public void xv(double d4) {
            com.bytedance.sdk.openadsdk.r.w.c().xv(d4);
        }

        @Override // com.bytedance.sdk.component.ux.ys
        @ATSMethod(2)
        public void c(double d4) {
            com.bytedance.sdk.openadsdk.r.w.c().c(d4);
        }

        @Override // com.bytedance.sdk.component.ux.ys
        @ATSMethod(8)
        public boolean w(String str, String str2, String str3) {
            return com.bytedance.sdk.openadsdk.r.w.c().w(str, str2, str3);
        }

        @Override // com.bytedance.sdk.component.ux.ys
        @ATSMethod(5)
        public void c() {
            com.bytedance.sdk.openadsdk.r.w.c().c();
        }

        @Override // com.bytedance.sdk.component.ux.ys
        @ATSMethod(6)
        public InputStream c(String str, String str2) {
            return com.bytedance.sdk.openadsdk.r.w.c().c(str, str2);
        }

        @Override // com.bytedance.sdk.component.ux.ys
        @ATSMethod(7)
        public InputStream c(String str, String str2, String str3) {
            return com.bytedance.sdk.openadsdk.r.w.c().c(str, str2, str3);
        }
    }

    public static void c() {
        Context context;
        if (sr.get() || !ls.w().n() || (context = ls.getContext()) == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.q.ux.c().w().c(context, true, new com.bytedance.sdk.openadsdk.core.q.sr(context));
        } catch (Exception unused) {
        }
        sr.set(true);
    }

    private static void ev() {
        com.bytedance.sdk.openadsdk.core.xv.ux.c().f(UUID.randomUUID().toString());
    }

    public static Handler f() {
        if (f34487f == null) {
            synchronized (q.class) {
                if (f34487f == null) {
                    f34487f = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f34487f;
    }

    private static void r() {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(invoke, true);
        } catch (Throwable unused) {
        }
    }

    public static void sr() {
        com.bytedance.sdk.component.adexpress.c.c.c.c().c(new com.bytedance.sdk.component.adexpress.c.c.xv() { // from class: com.bytedance.sdk.openadsdk.core.q.2
            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public int a() {
                return ls.w().rh();
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public boolean bk() {
                return com.bytedance.sdk.openadsdk.core.multipro.w.xv();
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public int c() {
                if (ls.w() == null) {
                    return 0;
                }
                return ls.w().gp();
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public int ev() {
                return 0;
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public com.bytedance.sdk.component.ev.w.w f() {
                return com.bytedance.sdk.openadsdk.core.q.ux.c().w().xv();
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public int fp() {
                return com.bytedance.sdk.openadsdk.core.eq.xk.sr(ls.getContext());
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public int gd() {
                return ls.w().rd();
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public Context getContext() {
                return ls.getContext();
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public int k() {
                return k.sr().me();
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public int p() {
                return ls.w().jv();
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public String r() {
                return k.sr().ev();
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public com.bytedance.sdk.component.adexpress.c.xv.c sr() {
                return ls.c().c(1);
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public ExecutorService t() {
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public com.bytedance.sdk.component.ev.w.c ux() {
                return com.bytedance.sdk.openadsdk.core.q.ux.c().w().sr();
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public Handler w() {
                return q.f();
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public void xv() {
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.xv
            public ExecutorService ys() {
                return null;
            }
        });
    }

    public static void ux() {
        com.bytedance.sdk.component.adexpress.c.c.c.c().c(new com.bytedance.sdk.component.adexpress.c.c.w() { // from class: com.bytedance.sdk.openadsdk.core.q.3
            @Override // com.bytedance.sdk.component.adexpress.c.c.w
            public int delete(String str, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.core.multipro.c.c.delete(ls.getContext(), str, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.w
            public void insert(String str, ContentValues contentValues) {
                com.bytedance.sdk.openadsdk.core.multipro.c.c.insert(ls.getContext(), str, contentValues);
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.w
            public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return com.bytedance.sdk.openadsdk.core.multipro.c.c.query(ls.getContext(), str, strArr, str2, strArr2, str3, str4, str5);
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.w
            public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.core.multipro.c.c.update(ls.getContext(), str, contentValues, str2, strArr);
            }
        });
        com.bytedance.sdk.component.adexpress.c.c.c.c().c(new com.bytedance.sdk.component.adexpress.c.c.sr() { // from class: com.bytedance.sdk.openadsdk.core.q.4
            @Override // com.bytedance.sdk.component.adexpress.c.c.sr
            public void c(final int i4) {
                com.bytedance.sdk.openadsdk.core.fz.a.c().ux(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.q.4.1
                    @Override // com.bytedance.sdk.openadsdk.p.c.c
                    public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                        return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().w(i4).r(p.c(i4));
                    }
                });
            }
        });
        com.bytedance.sdk.component.adexpress.c.c.c.c().c(new c());
        com.bytedance.sdk.component.adexpress.c.c.c.c().c(new com.bytedance.sdk.component.adexpress.c.c.ux() { // from class: com.bytedance.sdk.openadsdk.core.q.5
            @Override // com.bytedance.sdk.component.adexpress.c.c.ux
            public void delete(String str, String str2) {
                com.bytedance.sdk.openadsdk.core.xv.w.c().delete(str, str2);
            }

            @Override // com.bytedance.sdk.component.adexpress.c.c.ux
            public void update(String str, com.bytedance.sdk.component.adexpress.c.xv.xv xvVar) {
                com.bytedance.sdk.openadsdk.core.xv.w.c().update(str, xvVar);
            }
        });
    }

    public static void w() {
        ls.w().c(1);
        if (!sr.get()) {
            c();
        }
        Context context = ls.getContext();
        if (context == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.q.ux.c().w().c(context, com.bytedance.sdk.openadsdk.core.multipro.w.xv());
        } catch (Exception unused) {
        }
    }

    public static void xv() {
        com.bytedance.sdk.component.f.c c4 = xv.c();
        long w3 = c4.w("sdk_first_init_timestamp", 0L);
        if (w3 == 0) {
            w3 = System.currentTimeMillis();
            c4.c("sdk_first_init_timestamp", w3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String w4 = com.bytedance.sdk.openadsdk.core.eq.wv.w(w3, currentTimeMillis);
        long w5 = c4.w("sdk_init_timestamp", 0L);
        StringBuilder sb = new StringBuilder();
        sb.append(w5 != 0 ? (currentTimeMillis - w5) / 1000 : 0L);
        sb.append("");
        com.bytedance.sdk.openadsdk.core.fz.a.c().c(w4, sb.toString());
        c4.c("sdk_init_timestamp", System.currentTimeMillis());
    }

    public static void c(Context context) {
        f34488w.set(true);
        xv.set(true);
        r();
        com.bytedance.sdk.openadsdk.core.eq.xk.c(context);
        ev();
        String xv2 = i.xv();
        com.bytedance.sdk.component.utils.a.xv("appLogID", "" + xv2);
        if (!TextUtils.isEmpty(xv2)) {
            com.bytedance.sdk.openadsdk.core.fz.w.c(xv2);
        }
        if (com.bytedance.sdk.openadsdk.c.c.c.c() != null) {
            com.bytedance.sdk.openadsdk.c.c.c.c().c(xv2);
        }
        com.bytedance.sdk.component.adexpress.c.w.w.c();
        if (com.bytedance.sdk.openadsdk.core.xv.f.c(context)) {
            com.bytedance.sdk.component.utils.ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.q.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.utils.a.f("lqmt", "res preload doing,  Sdk.iB: true  Quitwork: " + k.sr().ia());
                    if (k.sr().ia()) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.ugeno.ux.c.w().xv();
                }
            }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        } else {
            com.bytedance.sdk.openadsdk.core.ugeno.ux.c.w().xv();
        }
    }
}
