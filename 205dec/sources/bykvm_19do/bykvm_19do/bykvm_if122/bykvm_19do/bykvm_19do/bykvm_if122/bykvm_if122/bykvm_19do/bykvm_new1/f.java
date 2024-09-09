package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: Http2Codec.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class f implements bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c {

    /* renamed from: e  reason: collision with root package name */
    private static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1063e;

    /* renamed from: f  reason: collision with root package name */
    private static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1064f;

    /* renamed from: g  reason: collision with root package name */
    private static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1065g;

    /* renamed from: h  reason: collision with root package name */
    private static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1066h;

    /* renamed from: i  reason: collision with root package name */
    private static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1067i;

    /* renamed from: j  reason: collision with root package name */
    private static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1068j;

    /* renamed from: k  reason: collision with root package name */
    private static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1069k;

    /* renamed from: l  reason: collision with root package name */
    private static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1070l;

    /* renamed from: m  reason: collision with root package name */
    private static final List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f> f1071m;

    /* renamed from: n  reason: collision with root package name */
    private static final List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f> f1072n;

    /* renamed from: a  reason: collision with root package name */
    private final t.a f1073a;

    /* renamed from: b  reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g f1074b;

    /* renamed from: c  reason: collision with root package name */
    private final g f1075c;

    /* renamed from: d  reason: collision with root package name */
    private i f1076d;

    static {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f c4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c("connection");
        f1063e = c4;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f c5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c("host");
        f1064f = c5;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f c6 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c("keep-alive");
        f1065g = c6;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f c7 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c("proxy-connection");
        f1066h = c7;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f c8 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c("transfer-encoding");
        f1067i = c8;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f c9 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c("te");
        f1068j = c9;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f c10 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c("encoding");
        f1069k = c10;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f c11 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c("upgrade");
        f1070l = c11;
        f1071m = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(c4, c5, c6, c7, c9, c8, c10, c11, c.f1033f, c.f1034g, c.f1035h, c.f1036i);
        f1072n = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(c4, c5, c6, c7, c9, c8, c10, c11);
    }

    public f(v vVar, t.a aVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, g gVar2) {
        this.f1073a = aVar;
        this.f1074b = gVar;
        this.f1075c = gVar2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public r a(y yVar, long j4) {
        return this.f1076d.d();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public void b() throws IOException {
        this.f1075c.flush();
    }

    public static List<c> b(y yVar) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r c4 = yVar.c();
        ArrayList arrayList = new ArrayList(c4.b() + 4);
        arrayList.add(new c(c.f1033f, yVar.e()));
        arrayList.add(new c(c.f1034g, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.i.a(yVar.g())));
        String a4 = yVar.a("Host");
        if (a4 != null) {
            arrayList.add(new c(c.f1036i, a4));
        }
        arrayList.add(new c(c.f1035h, yVar.g().m()));
        int b4 = c4.b();
        for (int i4 = 0; i4 < b4; i4++) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f c5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c(c4.a(i4).toLowerCase(Locale.US));
            if (!f1071m.contains(c5)) {
                arrayList.add(new c(c5, c4.b(i4)));
            }
        }
        return arrayList;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public void a(y yVar) throws IOException {
        if (this.f1076d != null) {
            return;
        }
        i a4 = this.f1075c.a(b(yVar), yVar.a() != null);
        this.f1076d = a4;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a4.h().a(this.f1073a.d(), timeUnit);
        this.f1076d.l().a(this.f1073a.a(), timeUnit);
    }

    /* compiled from: Http2Codec.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class a extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.h {

        /* renamed from: b  reason: collision with root package name */
        boolean f1077b;

        /* renamed from: c  reason: collision with root package name */
        long f1078c;

        a(s sVar) {
            super(sVar);
            this.f1077b = false;
            this.f1078c = 0L;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            try {
                long a4 = a().a(cVar, j4);
                if (a4 > 0) {
                    this.f1078c += a4;
                }
                return a4;
            } catch (IOException e4) {
                a(e4);
                throw e4;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.h, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }

        private void a(IOException iOException) {
            if (this.f1077b) {
                return;
            }
            this.f1077b = true;
            f fVar = f.this;
            fVar.f1074b.a(false, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c) fVar, this.f1078c, iOException);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public void a() throws IOException {
        this.f1076d.d().close();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public a0.a a(boolean z3) throws IOException {
        a0.a a4 = a(this.f1076d.j());
        if (z3 && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a.a(a4) == 100) {
            return null;
        }
        return a4;
    }

    public static a0.a a(List<c> list) throws IOException {
        r.a aVar = new r.a();
        int size = list.size();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.k kVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            c cVar = list.get(i4);
            if (cVar == null) {
                if (kVar != null && kVar.f950b == 100) {
                    aVar = new r.a();
                    kVar = null;
                }
            } else {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar = cVar.f1037a;
                String h4 = cVar.f1038b.h();
                if (fVar.equals(c.f1032e)) {
                    kVar = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.k.a("HTTP/1.1 " + h4);
                } else if (!f1072n.contains(fVar)) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a.a(aVar, fVar.h(), h4);
                }
            }
        }
        if (kVar != null) {
            return new a0.a().a(w.HTTP_2).a(kVar.f950b).a(kVar.f951c).a(aVar.a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public b0 a(a0 a0Var) throws IOException {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar = this.f1074b;
        gVar.f990f.e(gVar.f989e);
        return new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.h(a0Var.a("Content-Type"), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.a(a0Var), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l.a(new a(this.f1076d.e())));
    }
}
