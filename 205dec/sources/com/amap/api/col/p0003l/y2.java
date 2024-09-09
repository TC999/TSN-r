package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ThreadUtil.java */
/* renamed from: com.amap.api.col.3l.y2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class y2 {

    /* renamed from: b  reason: collision with root package name */
    private static volatile y2 f9516b;

    /* renamed from: a  reason: collision with root package name */
    private z7 f9517a;

    private y2() {
        this.f9517a = null;
        this.f9517a = z2.b("AMapThreadUtil");
    }

    public static y2 a() {
        if (f9516b == null) {
            synchronized (y2.class) {
                if (f9516b == null) {
                    f9516b = new y2();
                }
            }
        }
        return f9516b;
    }

    public static void c() {
        if (f9516b != null) {
            try {
                if (f9516b.f9517a != null) {
                    f9516b.f9517a.g();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            f9516b.f9517a = null;
            f9516b = null;
        }
    }

    public static void d(a8 a8Var) {
        if (a8Var != null) {
            try {
                a8Var.cancelTask();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b(a8 a8Var) {
        try {
            this.f9517a.b(a8Var);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
