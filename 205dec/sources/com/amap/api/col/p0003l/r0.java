package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OfflineDBOperation.java */
/* renamed from: com.amap.api.col.3l.r0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class r0 {

    /* renamed from: b  reason: collision with root package name */
    private static volatile r0 f8852b;

    /* renamed from: c  reason: collision with root package name */
    private static d6 f8853c;

    /* renamed from: a  reason: collision with root package name */
    private Context f8854a;

    private r0(Context context) {
        this.f8854a = context;
        f8853c = i(context);
    }

    public static r0 b(Context context) {
        if (f8852b == null) {
            synchronized (r0.class) {
                if (f8852b == null) {
                    f8852b = new r0(context);
                }
            }
        }
        return f8852b;
    }

    private static List<String> d(List<o0> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (o0 o0Var : list) {
                arrayList.add(o0Var.a());
            }
        }
        return arrayList;
    }

    private synchronized void g(String str, int i4, long j4, long[] jArr, long[] jArr2) {
        if (l()) {
            f8853c.h(new n0(str, j4, i4, jArr[0], jArr2[0]), n0.a(str));
        }
    }

    private static void h(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return;
        }
        String b4 = o0.b(str);
        if (f8853c.p(b4, o0.class).size() > 0) {
            f8853c.j(b4, o0.class);
        }
        String[] split = str2.split(";");
        ArrayList arrayList = new ArrayList();
        for (String str3 : split) {
            arrayList.add(new o0(str, str3));
        }
        f8853c.l(arrayList);
    }

    private static d6 i(Context context) {
        try {
            return new d6(context, q0.a());
        } catch (Throwable th) {
            u5.p(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    private boolean l() {
        if (f8853c == null) {
            f8853c = i(this.f8854a);
        }
        return f8853c != null;
    }

    public final synchronized m0 a(String str) {
        if (l()) {
            List p3 = f8853c.p(p0.f(str), m0.class);
            if (p3.size() > 0) {
                return (m0) p3.get(0);
            }
            return null;
        }
        return null;
    }

    public final ArrayList<m0> c() {
        ArrayList<m0> arrayList = new ArrayList<>();
        if (l()) {
            for (m0 m0Var : f8853c.p("", m0.class)) {
                arrayList.add(m0Var);
            }
            return arrayList;
        }
        return arrayList;
    }

    public final synchronized void e(m0 m0Var) {
        if (l()) {
            f8853c.h(m0Var, p0.h(m0Var.j()));
            h(m0Var.e(), m0Var.k());
        }
    }

    public final void f(String str, int i4, long j4, long j5, long j6) {
        if (l()) {
            g(str, i4, j4, new long[]{j5, 0, 0, 0, 0}, new long[]{j6, 0, 0, 0, 0});
        }
    }

    public final synchronized List<String> j(String str) {
        ArrayList arrayList = new ArrayList();
        if (l()) {
            arrayList.addAll(d(f8853c.p(o0.b(str), o0.class)));
            return arrayList;
        }
        return arrayList;
    }

    public final synchronized void k(m0 m0Var) {
        if (l()) {
            f8853c.j(p0.h(m0Var.j()), p0.class);
            f8853c.j(o0.b(m0Var.e()), o0.class);
            f8853c.j(n0.a(m0Var.e()), n0.class);
        }
    }

    public final synchronized void m(String str) {
        if (l()) {
            f8853c.j(p0.f(str), p0.class);
            f8853c.j(o0.b(str), o0.class);
            f8853c.j(n0.a(str), n0.class);
        }
    }

    public final synchronized String n(String str) {
        if (l()) {
            List p3 = f8853c.p(p0.h(str), p0.class);
            return p3.size() > 0 ? ((p0) p3.get(0)).c() : null;
        }
        return null;
    }
}
