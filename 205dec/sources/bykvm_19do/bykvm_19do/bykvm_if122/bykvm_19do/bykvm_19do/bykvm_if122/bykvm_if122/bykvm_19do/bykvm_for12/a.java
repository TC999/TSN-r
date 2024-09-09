package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.u;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z;
import java.io.IOException;
import java.util.List;

/* compiled from: BridgeInterceptor.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class a implements t {

    /* renamed from: a  reason: collision with root package name */
    private final m f923a;

    public a(m mVar) {
        this.f923a = mVar;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t
    public a0 a(t.a aVar) throws IOException {
        y b4 = aVar.b();
        y.a f4 = b4.f();
        z a4 = b4.a();
        if (a4 != null) {
            u b5 = a4.b();
            if (b5 != null) {
                f4.b("Content-Type", b5.toString());
            }
            long a5 = a4.a();
            if (a5 != -1) {
                f4.b("Content-Length", Long.toString(a5));
                f4.a("Transfer-Encoding");
            } else {
                f4.b("Transfer-Encoding", "chunked");
                f4.a("Content-Length");
            }
        }
        boolean z3 = false;
        if (b4.a("Host") == null) {
            f4.b("Host", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(b4.g(), false));
        }
        if (b4.a("Connection") == null) {
            f4.b("Connection", "Keep-Alive");
        }
        if (b4.a("Accept-Encoding") == null && b4.a("Range") == null) {
            z3 = true;
            f4.b("Accept-Encoding", "gzip");
        }
        List<l> a6 = this.f923a.a(b4.g());
        if (!a6.isEmpty()) {
            f4.b("Cookie", a(a6));
        }
        if (b4.a("User-Agent") == null) {
            f4.b("User-Agent", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.d.a());
        }
        a0 a7 = aVar.a(f4.a());
        e.a(this.f923a, b4.g(), a7.e());
        a0.a a8 = a7.h().a(b4);
        if (z3 && "gzip".equalsIgnoreCase(a7.a("Content-Encoding")) && e.b(a7)) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.j jVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.j(a7.a().c());
            a8.a(a7.e().a().b("Content-Encoding").b("Content-Length").a());
            a8.a(new h(a7.a("Content-Type"), -1L, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l.a(jVar)));
        }
        return a8.a();
    }

    private String a(List<l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 > 0) {
                sb.append("; ");
            }
            l lVar = list.get(i4);
            sb.append(lVar.a());
            sb.append('=');
            sb.append(lVar.b());
        }
        return sb.toString();
    }
}
