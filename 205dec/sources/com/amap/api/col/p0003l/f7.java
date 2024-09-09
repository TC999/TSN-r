package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: OfflineLocManager.java */
/* renamed from: com.amap.api.col.3l.f7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f7 {

    /* renamed from: a  reason: collision with root package name */
    static int f7721a = 1000;

    /* renamed from: b  reason: collision with root package name */
    static boolean f7722b = false;

    /* renamed from: c  reason: collision with root package name */
    private static WeakReference<b7> f7723c = null;

    /* renamed from: d  reason: collision with root package name */
    static int f7724d = 20;

    /* renamed from: e  reason: collision with root package name */
    private static int f7725e = 10;

    /* renamed from: f  reason: collision with root package name */
    static int f7726f;

    @Deprecated
    public static synchronized void b(int i4, boolean z3) {
        synchronized (f7.class) {
            f7721a = i4;
            f7722b = z3;
        }
    }

    public static synchronized void c(int i4, boolean z3, int i5, int i6) {
        synchronized (f7.class) {
            f7721a = i4;
            f7722b = z3;
            i5 = (i5 < 10 || i5 > 100) ? 20 : 20;
            f7724d = i5;
            if (i5 / 5 > f7725e) {
                f7725e = i5 / 5;
            }
            f7726f = i6;
        }
    }

    public static void d(Context context) {
        z7.h().b(new a(context, 2));
    }

    public static synchronized void e(e7 e7Var, Context context) {
        synchronized (f7.class) {
            z7.h().b(new a(context, e7Var));
        }
    }

    /* compiled from: OfflineLocManager.java */
    /* renamed from: com.amap.api.col.3l.f7$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class a extends a8 {

        /* renamed from: a  reason: collision with root package name */
        private int f7727a;

        /* renamed from: b  reason: collision with root package name */
        private Context f7728b;

        /* renamed from: c  reason: collision with root package name */
        private e7 f7729c;

        a(Context context, int i4) {
            this.f7728b = context;
            this.f7727a = i4;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            int i4 = this.f7727a;
            if (i4 == 1) {
                try {
                    synchronized (f7.class) {
                        String l4 = Long.toString(System.currentTimeMillis());
                        b7 a4 = i7.a(f7.f7723c);
                        i7.f(this.f7728b, a4, r5.f8900i, f7.f7721a, 2097152, "6");
                        if (a4.f7268e == null) {
                            a4.f7268e = new i6(new k6(new l6(new k6())));
                        }
                        c7.c(l4, this.f7729c.b(), a4);
                    }
                } catch (Throwable th) {
                    u5.p(th, "ofm", "aple");
                }
            } else if (i4 == 2) {
                try {
                    b7 a5 = i7.a(f7.f7723c);
                    i7.f(this.f7728b, a5, r5.f8900i, f7.f7721a, 2097152, "6");
                    a5.f7271h = 14400000;
                    if (a5.f7270g == null) {
                        a5.f7270g = new m7(new l7(this.f7728b, new q7(), new i6(new k6(new l6())), new String(f5.c()), e4.j(this.f7728b), i4.P(), i4.I(), i4.F(this.f7728b), i4.n(), Build.MANUFACTURER, Build.DEVICE, i4.U(), e4.g(this.f7728b), Build.MODEL, e4.h(this.f7728b), e4.e(this.f7728b), i4.D(this.f7728b), i4.o(this.f7728b), String.valueOf(Build.VERSION.SDK_INT), w4.a(this.f7728b).b()));
                    }
                    if (TextUtils.isEmpty(a5.f7272i)) {
                        a5.f7272i = "fKey";
                    }
                    Context context = this.f7728b;
                    a5.f7269f = new v7(context, a5.f7271h, a5.f7272i, new t7(context, f7.f7722b, f7.f7725e * 1024, f7.f7724d * 1024, "offLocKey", f7.f7726f * 1024));
                    c7.a(a5);
                } catch (Throwable th2) {
                    u5.p(th2, "ofm", "uold");
                }
            }
        }

        a(Context context, e7 e7Var) {
            this(context, 1);
            this.f7729c = e7Var;
        }
    }
}
