package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OfflineLocManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f3 {

    /* renamed from: a  reason: collision with root package name */
    static int f9841a = 1000;

    /* renamed from: b  reason: collision with root package name */
    static boolean f9842b = false;

    /* renamed from: c  reason: collision with root package name */
    private static WeakReference<c3> f9843c = null;

    /* renamed from: d  reason: collision with root package name */
    static int f9844d = 20;

    /* renamed from: e  reason: collision with root package name */
    private static int f9845e = 10;

    /* renamed from: f  reason: collision with root package name */
    static int f9846f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: OfflineLocManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a extends z3 {

        /* renamed from: b  reason: collision with root package name */
        private int f9847b = 2;

        /* renamed from: c  reason: collision with root package name */
        private Context f9848c;

        /* renamed from: d  reason: collision with root package name */
        private e3 f9849d;

        a(Context context) {
            this.f9848c = context;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            int i4 = this.f9847b;
            if (i4 == 1) {
                try {
                    synchronized (f3.class) {
                        String l4 = Long.toString(System.currentTimeMillis());
                        c3 a4 = i3.a(f3.f9843c);
                        i3.e(this.f9848c, a4, e2.f9826i, f3.f9841a, 2097152, "6");
                        if (a4.f9703e == null) {
                            a4.f9703e = new m2(new o2(new p2(new o2())));
                        }
                        d3.c(l4, this.f9849d.b(), a4);
                    }
                } catch (Throwable th) {
                    g2.o(th, "ofm", "aple");
                }
            } else if (i4 == 2) {
                try {
                    c3 a5 = i3.a(f3.f9843c);
                    i3.e(this.f9848c, a5, e2.f9826i, f3.f9841a, 2097152, "6");
                    a5.f9706h = 14400000;
                    if (a5.f9705g == null) {
                        a5.f9705g = new m3(new l3(this.f9848c, new q3(), new m2(new o2(new p2())), new String(s1.c()), x0.i(this.f9848c), c1.H(), c1.C(), c1.y(this.f9848c), c1.i(), Build.MANUFACTURER, Build.DEVICE, c1.M(), x0.f(this.f9848c), Build.MODEL, x0.g(this.f9848c), x0.d(this.f9848c), c1.w(this.f9848c), c1.j(this.f9848c), String.valueOf(Build.VERSION.SDK_INT), o1.a(this.f9848c).b()));
                    }
                    if (TextUtils.isEmpty(a5.f9707i)) {
                        a5.f9707i = "fKey";
                    }
                    Context context = this.f9848c;
                    a5.f9704f = new u3(context, a5.f9706h, a5.f9707i, new s3(context, f3.f9842b, f3.f9845e * 1024, f3.f9844d * 1024, "offLocKey", f3.f9846f * 1024));
                    d3.a(a5);
                } catch (Throwable th2) {
                    g2.o(th2, "ofm", "uold");
                }
            }
        }
    }

    public static void b(Context context) {
        y3.e().c(new a(context));
    }
}
