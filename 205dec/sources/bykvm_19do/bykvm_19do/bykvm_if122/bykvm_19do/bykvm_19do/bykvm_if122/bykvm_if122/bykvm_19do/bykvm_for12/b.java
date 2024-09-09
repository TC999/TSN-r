package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: CallServerInterceptor.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class b implements t {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f924a;

    /* compiled from: CallServerInterceptor.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static final class a extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.g {

        /* renamed from: b  reason: collision with root package name */
        long f925b;

        a(r rVar) {
            super(rVar);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.g, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            super.b(cVar, j4);
            this.f925b += j4;
        }
    }

    public b(boolean z3) {
        this.f924a = z3;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t
    public a0 a(t.a aVar) throws IOException {
        a0 a4;
        g gVar = (g) aVar;
        c h4 = gVar.h();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g i4 = gVar.i();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar = (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c) gVar.f();
        y b4 = gVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.g().d(gVar.e());
        h4.a(b4);
        gVar.g().a(gVar.e(), b4);
        a0.a aVar2 = null;
        if (f.b(b4.e()) && b4.a() != null) {
            if ("100-continue".equalsIgnoreCase(b4.a("Expect"))) {
                h4.b();
                gVar.g().f(gVar.e());
                aVar2 = h4.a(true);
            }
            if (aVar2 == null) {
                gVar.g().c(gVar.e());
                a aVar3 = new a(h4.a(b4, b4.a().a()));
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d a5 = l.a(aVar3);
                b4.a().a(a5);
                a5.close();
                gVar.g().a(gVar.e(), aVar3.f925b);
            } else if (!cVar.c()) {
                i4.d();
            }
        }
        h4.a();
        if (aVar2 == null) {
            gVar.g().f(gVar.e());
            aVar2 = h4.a(false);
        }
        a0 a6 = aVar2.a(b4).a(i4.b().b()).b(currentTimeMillis).a(System.currentTimeMillis()).a();
        gVar.g().a(gVar.e(), a6);
        int c4 = a6.c();
        if (this.f924a && c4 == 101) {
            a4 = a6.h().a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1228c).a();
        } else {
            a4 = a6.h().a(h4.a(a6)).a();
        }
        if ("close".equalsIgnoreCase(a4.k().a("Connection")) || "close".equalsIgnoreCase(a4.a("Connection"))) {
            i4.d();
        }
        if ((c4 == 204 || c4 == 205) && a4.a().a() > 0) {
            throw new ProtocolException("HTTP " + c4 + " had non-zero Content-Length: " + a4.a().a());
        }
        return a4;
    }
}
