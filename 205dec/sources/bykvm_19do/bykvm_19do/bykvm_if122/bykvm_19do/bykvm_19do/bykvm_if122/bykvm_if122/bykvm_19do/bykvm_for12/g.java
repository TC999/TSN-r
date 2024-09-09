package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.io.IOException;
import java.util.List;

/* compiled from: RealInterceptorChain.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class g implements t.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<t> f929a;

    /* renamed from: b  reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g f930b;

    /* renamed from: c  reason: collision with root package name */
    private final c f931c;

    /* renamed from: d  reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c f932d;

    /* renamed from: e  reason: collision with root package name */
    private final int f933e;

    /* renamed from: f  reason: collision with root package name */
    private final y f934f;

    /* renamed from: g  reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e f935g;

    /* renamed from: h  reason: collision with root package name */
    private final p f936h;

    /* renamed from: i  reason: collision with root package name */
    private final int f937i;

    /* renamed from: j  reason: collision with root package name */
    private final int f938j;

    /* renamed from: k  reason: collision with root package name */
    private final int f939k;

    /* renamed from: l  reason: collision with root package name */
    private int f940l;

    public g(List<t> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, c cVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar2, int i4, y yVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar, int i5, int i6, int i7) {
        this.f929a = list;
        this.f932d = cVar2;
        this.f930b = gVar;
        this.f931c = cVar;
        this.f933e = i4;
        this.f934f = yVar;
        this.f935g = eVar;
        this.f936h = pVar;
        this.f937i = i5;
        this.f938j = i6;
        this.f939k = i7;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public int a() {
        return this.f939k;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public y b() {
        return this.f934f;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public int c() {
        return this.f937i;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public int d() {
        return this.f938j;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e e() {
        return this.f935g;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.i f() {
        return this.f932d;
    }

    public p g() {
        return this.f936h;
    }

    public c h() {
        return this.f931c;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g i() {
        return this.f930b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public a0 a(y yVar) throws IOException {
        return a(yVar, this.f930b, this.f931c, this.f932d);
    }

    public a0 a(y yVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, c cVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar2) throws IOException {
        if (this.f933e < this.f929a.size()) {
            this.f940l++;
            if (this.f931c != null && !this.f932d.a(yVar.g())) {
                throw new IllegalStateException("network interceptor " + this.f929a.get(this.f933e - 1) + " must retain the same host and port");
            } else if (this.f931c != null && this.f940l > 1) {
                throw new IllegalStateException("network interceptor " + this.f929a.get(this.f933e - 1) + " must call proceed() exactly once");
            } else {
                g gVar2 = new g(this.f929a, gVar, cVar, cVar2, this.f933e + 1, yVar, this.f935g, this.f936h, this.f937i, this.f938j, this.f939k);
                t tVar = this.f929a.get(this.f933e);
                a0 a4 = tVar.a(gVar2);
                if (cVar != null && this.f933e + 1 < this.f929a.size() && gVar2.f940l != 1) {
                    throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
                } else if (a4 != null) {
                    if (a4.a() != null) {
                        return a4;
                    }
                    throw new IllegalStateException("interceptor " + tVar + " returned a response with no body");
                } else {
                    throw new NullPointerException("interceptor " + tVar + " returned null");
                }
            }
        }
        throw new AssertionError();
    }
}
