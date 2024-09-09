package com.amap.api.col.s;

import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RequestCacheControl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class n {

    /* renamed from: b  reason: collision with root package name */
    private static volatile n f10022b;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, o> f10023a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RequestCacheControl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f10024a = true;

        /* renamed from: b  reason: collision with root package name */
        private long f10025b = 86400;

        /* renamed from: c  reason: collision with root package name */
        private int f10026c = 10;

        /* renamed from: d  reason: collision with root package name */
        private double f10027d = 0.0d;

        public final void a(double d4) {
            this.f10027d = d4;
        }

        public final void b(int i4) {
            this.f10026c = i4;
        }

        public final void c(long j4) {
            this.f10025b = j4;
        }

        public final void d(boolean z3) {
            this.f10024a = z3;
        }

        public final boolean e() {
            return this.f10024a;
        }

        public final long f() {
            return this.f10025b;
        }

        public final int g() {
            return this.f10026c;
        }

        public final double h() {
            return this.f10027d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RequestCacheControl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        String f10028a;

        /* renamed from: b  reason: collision with root package name */
        Object f10029b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                String str = this.f10028a;
                if (str == null) {
                    return bVar.f10028a == null && this.f10029b == bVar.f10029b;
                } else if (str.equals(bVar.f10028a) && this.f10029b == bVar.f10029b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.f10028a;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            Object obj = this.f10029b;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RequestCacheControl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        Object f10030a;

        /* renamed from: b  reason: collision with root package name */
        boolean f10031b;

        public c(Object obj, boolean z3) {
            this.f10030a = obj;
            this.f10031b = z3;
        }
    }

    public static n b() {
        if (f10022b == null) {
            synchronized (n.class) {
                if (f10022b == null) {
                    f10022b = new n();
                }
            }
        }
        return f10022b;
    }

    public final c a(b bVar) {
        c a4;
        if (bVar == null) {
            return null;
        }
        for (o oVar : this.f10023a.values()) {
            if (oVar != null && (a4 = oVar.a(bVar)) != null) {
                return a4;
            }
        }
        return null;
    }

    public final synchronized o c(String str) {
        return this.f10023a.get(str);
    }

    public final void d(a aVar) {
        if (aVar == null) {
            return;
        }
        for (o oVar : this.f10023a.values()) {
            if (oVar != null) {
                oVar.c(aVar);
            }
        }
    }

    public final void e(b bVar, Object obj) {
        for (o oVar : this.f10023a.values()) {
            if (oVar != null) {
                oVar.d(bVar, obj);
            }
        }
    }

    public final void f(String str, a aVar) {
        o oVar;
        if (str == null || aVar == null || (oVar = this.f10023a.get(str)) == null) {
            return;
        }
        oVar.c(aVar);
    }

    public final synchronized void g(String str, o oVar) {
        this.f10023a.put(str, oVar);
    }

    public final boolean h(b bVar) {
        if (bVar == null) {
            return false;
        }
        for (o oVar : this.f10023a.values()) {
            if (oVar != null && oVar.j(bVar)) {
                return true;
            }
        }
        return false;
    }
}
