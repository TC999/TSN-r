package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;

/* compiled from: Request.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    final s f1445a;

    /* renamed from: b  reason: collision with root package name */
    final String f1446b;

    /* renamed from: c  reason: collision with root package name */
    final r f1447c;

    /* renamed from: d  reason: collision with root package name */
    final z f1448d;

    /* renamed from: e  reason: collision with root package name */
    final Object f1449e;

    /* renamed from: f  reason: collision with root package name */
    private volatile d f1450f;

    y(a aVar) {
        this.f1445a = aVar.f1451a;
        this.f1446b = aVar.f1452b;
        this.f1447c = aVar.f1453c.a();
        this.f1448d = aVar.f1454d;
        Object obj = aVar.f1455e;
        this.f1449e = obj == null ? this : obj;
    }

    public String a(String str) {
        return this.f1447c.a(str);
    }

    public d b() {
        d dVar = this.f1450f;
        if (dVar != null) {
            return dVar;
        }
        d a4 = d.a(this.f1447c);
        this.f1450f = a4;
        return a4;
    }

    public r c() {
        return this.f1447c;
    }

    public boolean d() {
        return this.f1445a.h();
    }

    public String e() {
        return this.f1446b;
    }

    public a f() {
        return new a(this);
    }

    public s g() {
        return this.f1445a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f1446b);
        sb.append(", url=");
        sb.append(this.f1445a);
        sb.append(", tag=");
        Object obj = this.f1449e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    /* compiled from: Request.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        s f1451a;

        /* renamed from: b  reason: collision with root package name */
        String f1452b;

        /* renamed from: c  reason: collision with root package name */
        r.a f1453c;

        /* renamed from: d  reason: collision with root package name */
        z f1454d;

        /* renamed from: e  reason: collision with root package name */
        Object f1455e;

        public a() {
            this.f1452b = "GET";
            this.f1453c = new r.a();
        }

        public a a(s sVar) {
            if (sVar != null) {
                this.f1451a = sVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a b(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                s d4 = s.d(str);
                if (d4 != null) {
                    return a(d4);
                }
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            throw new NullPointerException("url == null");
        }

        public a a(String str, String str2) {
            this.f1453c.a(str, str2);
            return this;
        }

        a(y yVar) {
            this.f1451a = yVar.f1445a;
            this.f1452b = yVar.f1446b;
            this.f1454d = yVar.f1448d;
            this.f1455e = yVar.f1449e;
            this.f1453c = yVar.f1447c.a();
        }

        public a a(String str) {
            this.f1453c.b(str);
            return this;
        }

        public a a(r rVar) {
            this.f1453c = rVar.a();
            return this;
        }

        public a a(d dVar) {
            String dVar2 = dVar.toString();
            return dVar2.isEmpty() ? a("Cache-Control") : b("Cache-Control", dVar2);
        }

        public a a(z zVar) {
            return a("POST", zVar);
        }

        public a b(String str, String str2) {
            this.f1453c.c(str, str2);
            return this;
        }

        public a a(String str, z zVar) {
            if (str != null) {
                if (str.length() != 0) {
                    if (zVar != null && !bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.f.b(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    } else if (zVar == null && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.f.e(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    } else {
                        this.f1452b = str;
                        this.f1454d = zVar;
                        return this;
                    }
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public a b() {
            return a("GET", (z) null);
        }

        public a a(Object obj) {
            this.f1455e = obj;
            return this;
        }

        public y a() {
            if (this.f1451a != null) {
                return new y(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    public z a() {
        return this.f1448d;
    }
}
