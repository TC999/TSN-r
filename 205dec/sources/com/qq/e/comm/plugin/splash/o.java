package com.qq.e.comm.plugin.splash;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.u1;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f46151a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f46152b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f46153c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static volatile long f46154d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewGroup f46155c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f46156d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f46157e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ b f46158f;

        a(ViewGroup viewGroup, com.qq.e.comm.plugin.n0.c cVar, boolean z3, b bVar) {
            this.f46155c = viewGroup;
            this.f46156d = cVar;
            this.f46157e = z3;
            this.f46158f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            int b4 = f1.b(com.qq.e.comm.plugin.d0.a.d().a(), this.f46155c.getHeight());
            d1.a("###\u5e7f\u544a\u5bb9\u5668\u7269\u7406\u9ad8\u5ea6=" + b4 + "dp", new Object[0]);
            Rect rect = new Rect();
            boolean globalVisibleRect = this.f46155c.getGlobalVisibleRect(rect);
            int b5 = f1.b(com.qq.e.comm.plugin.d0.a.d().a(), rect.height());
            d1.a("###\u5f00\u5c4f\u5bb9\u5668\u5728\u5c4f\u5e55\u4e2d\u7684\u53ef\u89c1\u6027=" + globalVisibleRect, new Object[0]);
            d1.a("###\u5f00\u5c4f\u5bb9\u5668\u5728\u5c4f\u5e55\u4e2d\u7684\u53ef\u89c1\u9ad8\u5ea6=" + b5 + "dp", new Object[0]);
            boolean x3 = com.qq.e.comm.plugin.d0.a.d().c().x();
            int g4 = com.qq.e.comm.plugin.d0.a.d().c().g();
            int i4 = com.qq.e.comm.plugin.d0.a.d().c().i();
            if (x3) {
                max = Math.min(i4, g4);
            } else {
                max = Math.max(i4, g4);
            }
            int i5 = (b5 * 100) / max;
            n.a(this.f46156d, i5);
            double a4 = j.a(this.f46157e, x3);
            d1.a("###\u5f00\u5c4f\u5c4f\u5e55\u9ad8\u5ea6=" + max + "dp \u5bb9\u5668\u5728\u5c4f\u5e55\u4e2d\u7684\u53ef\u89c1\u9ad8\u5ea6:" + b5 + "dp rate:" + i5 + " require min rate:" + (100.0d * a4), new Object[0]);
            double d4 = (double) max;
            Double.isNaN(d4);
            int i6 = (int) (d4 * a4);
            if (globalVisibleRect && b4 >= i6 && b5 >= i6) {
                this.f46158f.a(true, 0);
                return;
            }
            GDTLogger.e("\u5e7f\u544a\u5bb9\u5668\u7684\u9ad8\u5ea6\u5fc5\u987b >= \u624b\u673a\u7684\u9ad8\u5ea6 * " + a4 + "\uff0c\u5426\u5219\u5c06\u4e0d\u8fdb\u884c\u66dd\u5149\u4e0a\u62a5\u548c\u8ba1\u8d39\uff0c\u5f53\u524d\u7684\u9ad8\u5ea6\u4e3a\uff1a" + b5 + "dp");
            this.f46158f.a(false, 4005);
            v.a(9130072, this.f46156d, Integer.valueOf(x3 ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b {
        void a(boolean z3, int i4);
    }

    public static boolean a(String str) {
        synchronized (f46152b) {
            String str2 = "preloadTime" + str;
            long a4 = u1.a(str2, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            long a5 = (j.a() * 1000) + a4;
            d1.a("preload last called time:" + a4 + " current:" + currentTimeMillis + " next:" + a5, new Object[0]);
            if (a4 != 0 && currentTimeMillis <= a5) {
                return false;
            }
            u1.b(str2, currentTimeMillis);
            return true;
        }
    }

    public static int b(String str) {
        int a4;
        synchronized (f46153c) {
            String str2 = "preloadOfflineIndex" + str;
            a4 = u1.a(str2, 0);
            d1.a("getOfflineAdIndex:" + a4, new Object[0]);
            u1.b(str2, a4 + 1);
        }
        return a4;
    }

    public static int c(String str) {
        int a4;
        synchronized (f46151a) {
            a4 = u1.a("splashPlayround" + str, 0);
        }
        return a4;
    }

    public static void d(String str) {
        synchronized (f46151a) {
            int a4 = u1.a("splashPlayround" + str, 0);
            u1.b("splashPlayround" + str, a4 + 1);
        }
    }

    public static void e(String str) {
        synchronized (f46153c) {
            u1.b("preloadOfflineIndex" + str, 0);
        }
    }

    public static synchronized void c() {
        synchronized (o.class) {
            f46154d = 0L;
        }
    }

    public static boolean b() {
        if (com.qq.e.comm.plugin.d0.a.d().f().a("SplashAvoidMultiClick", 1) == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (f46154d != 0 && currentTimeMillis - f46154d < 100) {
                f46154d = currentTimeMillis;
                return true;
            }
            f46154d = currentTimeMillis;
            return false;
        }
        return false;
    }

    public static int a() {
        return u1.a("usePreloadTime", 5);
    }

    public static void a(int i4) {
        u1.b("usePreloadTime", i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view) {
        return view != null && view.getVisibility() == 0 && view.isShown() && view.getWindowVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ViewGroup viewGroup, boolean z3, b bVar, com.qq.e.comm.plugin.n0.c cVar) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.post(new a(viewGroup, cVar, z3, bVar));
    }
}
