package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.f;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheInterceptor.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class a implements t {

    /* renamed from: a  reason: collision with root package name */
    final d f886a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CacheInterceptor.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class C0033a implements s {

        /* renamed from: a  reason: collision with root package name */
        boolean f887a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f888b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f889c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d f890d;

        C0033a(a aVar, e eVar, b bVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) {
            this.f888b = eVar;
            this.f889c = bVar;
            this.f890d = dVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            try {
                long a4 = this.f888b.a(cVar, j4);
                if (a4 == -1) {
                    if (!this.f887a) {
                        this.f887a = true;
                        this.f890d.close();
                    }
                    return -1L;
                }
                cVar.a(this.f890d.o(), cVar.f() - a4, a4);
                this.f890d.z();
                return a4;
            } catch (IOException e4) {
                if (!this.f887a) {
                    this.f887a = true;
                    this.f889c.a();
                }
                throw e4;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f887a && !bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                this.f887a = true;
                this.f889c.a();
            }
            this.f888b.close();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t t() {
            return this.f888b.t();
        }
    }

    public a(d dVar) {
        this.f886a = dVar;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t
    public a0 a(t.a aVar) throws IOException {
        d dVar = this.f886a;
        a0 b4 = dVar != null ? dVar.b(aVar.b()) : null;
        c a4 = new c.a(System.currentTimeMillis(), aVar.b(), b4).a();
        y yVar = a4.f891a;
        a0 a0Var = a4.f892b;
        d dVar2 = this.f886a;
        if (dVar2 != null) {
            dVar2.a(a4);
        }
        if (b4 != null && a0Var == null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(b4.a());
        }
        if (yVar == null && a0Var == null) {
            return new a0.a().a(aVar.b()).a(w.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1228c).b(-1L).a(System.currentTimeMillis()).a();
        }
        if (yVar == null) {
            return a0Var.h().a(a(a0Var)).a();
        }
        try {
            a0 a5 = aVar.a(yVar);
            if (a5 == null && b4 != null) {
            }
            if (a0Var != null) {
                if (a5.c() == 304) {
                    a0 a6 = a0Var.h().a(a(a0Var.e(), a5.e())).b(a5.l()).a(a5.j()).a(a(a0Var)).b(a(a5)).a();
                    a5.a().close();
                    this.f886a.a();
                    this.f886a.a(a0Var, a6);
                    return a6;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a0Var.a());
            }
            a0 a7 = a5.h().a(a(a0Var)).b(a(a5)).a();
            if (this.f886a != null) {
                if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.b(a7) && c.a(a7, yVar)) {
                    return a(this.f886a.a(a7), a7);
                }
                if (f.a(yVar.e())) {
                    try {
                        this.f886a.a(yVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return a7;
        } finally {
            if (b4 != null) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(b4.a());
            }
        }
    }

    private static a0 a(a0 a0Var) {
        return (a0Var == null || a0Var.a() == null) ? a0Var : a0Var.h().a((b0) null).a();
    }

    private a0 a(b bVar, a0 a0Var) throws IOException {
        r b4;
        if (bVar == null || (b4 = bVar.b()) == null) {
            return a0Var;
        }
        return a0Var.h().a(new h(a0Var.a("Content-Type"), a0Var.a().a(), l.a(new C0033a(this, a0Var.a().c(), bVar, l.a(b4))))).a();
    }

    private static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r rVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r rVar2) {
        r.a aVar = new r.a();
        int b4 = rVar.b();
        for (int i4 = 0; i4 < b4; i4++) {
            String a4 = rVar.a(i4);
            String b5 = rVar.b(i4);
            if ((!"Warning".equalsIgnoreCase(a4) || !b5.startsWith("1")) && (!a(a4) || rVar2.a(a4) == null)) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a.a(aVar, a4, b5);
            }
        }
        int b6 = rVar2.b();
        for (int i5 = 0; i5 < b6; i5++) {
            String a5 = rVar2.a(i5);
            if (!"Content-Length".equalsIgnoreCase(a5) && a(a5)) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a.a(aVar, a5, rVar2.b(i5));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
