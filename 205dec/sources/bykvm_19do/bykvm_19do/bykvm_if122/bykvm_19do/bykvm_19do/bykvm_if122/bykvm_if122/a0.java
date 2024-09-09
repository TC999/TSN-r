package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import java.io.Closeable;

/* compiled from: Response.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class a0 implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final y f855a;

    /* renamed from: b  reason: collision with root package name */
    final w f856b;

    /* renamed from: c  reason: collision with root package name */
    final int f857c;

    /* renamed from: d  reason: collision with root package name */
    final String f858d;

    /* renamed from: e  reason: collision with root package name */
    final q f859e;

    /* renamed from: f  reason: collision with root package name */
    final r f860f;

    /* renamed from: g  reason: collision with root package name */
    final b0 f861g;

    /* renamed from: h  reason: collision with root package name */
    final a0 f862h;

    /* renamed from: i  reason: collision with root package name */
    final a0 f863i;

    /* renamed from: j  reason: collision with root package name */
    final a0 f864j;

    /* renamed from: k  reason: collision with root package name */
    final long f865k;

    /* renamed from: l  reason: collision with root package name */
    final long f866l;

    /* renamed from: m  reason: collision with root package name */
    private volatile d f867m;

    /* compiled from: Response.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        y f868a;

        /* renamed from: b  reason: collision with root package name */
        w f869b;

        /* renamed from: c  reason: collision with root package name */
        int f870c;

        /* renamed from: d  reason: collision with root package name */
        String f871d;

        /* renamed from: e  reason: collision with root package name */
        q f872e;

        /* renamed from: f  reason: collision with root package name */
        r.a f873f;

        /* renamed from: g  reason: collision with root package name */
        b0 f874g;

        /* renamed from: h  reason: collision with root package name */
        a0 f875h;

        /* renamed from: i  reason: collision with root package name */
        a0 f876i;

        /* renamed from: j  reason: collision with root package name */
        a0 f877j;

        /* renamed from: k  reason: collision with root package name */
        long f878k;

        /* renamed from: l  reason: collision with root package name */
        long f879l;

        public a() {
            this.f870c = -1;
            this.f873f = new r.a();
        }

        private void d(a0 a0Var) {
            if (a0Var.f861g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(y yVar) {
            this.f868a = yVar;
            return this;
        }

        public a b(a0 a0Var) {
            if (a0Var != null) {
                a("networkResponse", a0Var);
            }
            this.f875h = a0Var;
            return this;
        }

        public a c(a0 a0Var) {
            if (a0Var != null) {
                d(a0Var);
            }
            this.f877j = a0Var;
            return this;
        }

        public a a(w wVar) {
            this.f869b = wVar;
            return this;
        }

        public a a(int i4) {
            this.f870c = i4;
            return this;
        }

        public a b(long j4) {
            this.f878k = j4;
            return this;
        }

        a(a0 a0Var) {
            this.f870c = -1;
            this.f868a = a0Var.f855a;
            this.f869b = a0Var.f856b;
            this.f870c = a0Var.f857c;
            this.f871d = a0Var.f858d;
            this.f872e = a0Var.f859e;
            this.f873f = a0Var.f860f.a();
            this.f874g = a0Var.f861g;
            this.f875h = a0Var.f862h;
            this.f876i = a0Var.f863i;
            this.f877j = a0Var.f864j;
            this.f878k = a0Var.f865k;
            this.f879l = a0Var.f866l;
        }

        public a a(String str) {
            this.f871d = str;
            return this;
        }

        public a a(q qVar) {
            this.f872e = qVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f873f.a(str, str2);
            return this;
        }

        public a a(r rVar) {
            this.f873f = rVar.a();
            return this;
        }

        public a a(b0 b0Var) {
            this.f874g = b0Var;
            return this;
        }

        public a a(a0 a0Var) {
            if (a0Var != null) {
                a("cacheResponse", a0Var);
            }
            this.f876i = a0Var;
            return this;
        }

        private void a(String str, a0 a0Var) {
            if (a0Var.f861g == null) {
                if (a0Var.f862h == null) {
                    if (a0Var.f863i == null) {
                        if (a0Var.f864j == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public a a(long j4) {
            this.f879l = j4;
            return this;
        }

        public a0 a() {
            if (this.f868a != null) {
                if (this.f869b != null) {
                    if (this.f870c >= 0) {
                        if (this.f871d != null) {
                            return new a0(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f870c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    a0(a aVar) {
        this.f855a = aVar.f868a;
        this.f856b = aVar.f869b;
        this.f857c = aVar.f870c;
        this.f858d = aVar.f871d;
        this.f859e = aVar.f872e;
        this.f860f = aVar.f873f.a();
        this.f861g = aVar.f874g;
        this.f862h = aVar.f875h;
        this.f863i = aVar.f876i;
        this.f864j = aVar.f877j;
        this.f865k = aVar.f878k;
        this.f866l = aVar.f879l;
    }

    public String a(String str) {
        return a(str, null);
    }

    public d b() {
        d dVar = this.f867m;
        if (dVar != null) {
            return dVar;
        }
        d a4 = d.a(this.f860f);
        this.f867m = a4;
        return a4;
    }

    public int c() {
        return this.f857c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b0 b0Var = this.f861g;
        if (b0Var != null) {
            b0Var.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public q d() {
        return this.f859e;
    }

    public r e() {
        return this.f860f;
    }

    public boolean f() {
        int i4 = this.f857c;
        return i4 >= 200 && i4 < 300;
    }

    public String g() {
        return this.f858d;
    }

    public a h() {
        return new a(this);
    }

    public a0 i() {
        return this.f864j;
    }

    public long j() {
        return this.f866l;
    }

    public y k() {
        return this.f855a;
    }

    public long l() {
        return this.f865k;
    }

    public String toString() {
        return "Response{protocol=" + this.f856b + ", code=" + this.f857c + ", message=" + this.f858d + ", url=" + this.f855a.g() + '}';
    }

    public String a(String str, String str2) {
        String a4 = this.f860f.a(str);
        return a4 != null ? a4 : str2;
    }

    public b0 a() {
        return this.f861g;
    }
}
