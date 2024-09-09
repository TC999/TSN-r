package com.hp.hpl.sparta;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: BuildDocument.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
class a implements f, m {

    /* renamed from: c  reason: collision with root package name */
    private final n f37347c;

    /* renamed from: d  reason: collision with root package name */
    private g f37348d;

    /* renamed from: e  reason: collision with root package name */
    private final e f37349e;

    /* renamed from: f  reason: collision with root package name */
    private o f37350f;

    public a() {
        this(null);
    }

    @Override // com.hp.hpl.sparta.o
    public String a() {
        o oVar = this.f37350f;
        if (oVar != null) {
            return oVar.a();
        }
        return null;
    }

    @Override // com.hp.hpl.sparta.m
    public o b() {
        return this.f37350f;
    }

    @Override // com.hp.hpl.sparta.m
    public void c() {
    }

    @Override // com.hp.hpl.sparta.o
    public int d() {
        o oVar = this.f37350f;
        if (oVar != null) {
            return oVar.d();
        }
        return -1;
    }

    @Override // com.hp.hpl.sparta.m
    public void e(g gVar) {
        this.f37348d = this.f37348d.e();
    }

    @Override // com.hp.hpl.sparta.f
    public e f() {
        return this.f37349e;
    }

    @Override // com.hp.hpl.sparta.m
    public void g() {
    }

    @Override // com.hp.hpl.sparta.m
    public void h(o oVar) {
        this.f37350f = oVar;
        this.f37349e.D(oVar.toString());
    }

    @Override // com.hp.hpl.sparta.m
    public void i(char[] cArr, int i4, int i5) {
        g gVar = this.f37348d;
        if (gVar.G() instanceof r) {
            ((r) gVar.G()).z(cArr, i4, i5);
        } else {
            gVar.y(new r(new String(cArr, i4, i5)));
        }
    }

    @Override // com.hp.hpl.sparta.m
    public void j(g gVar) {
        g gVar2 = this.f37348d;
        if (gVar2 == null) {
            this.f37349e.C(gVar);
        } else {
            gVar2.x(gVar);
        }
        this.f37348d = gVar;
    }

    @Override // com.hp.hpl.sparta.o
    public String toString() {
        if (this.f37350f != null) {
            return "BuildDoc: " + this.f37350f.toString();
        }
        return null;
    }

    public a(n nVar) {
        this.f37348d = null;
        this.f37349e = new e();
        this.f37350f = null;
        this.f37347c = nVar == null ? o.f37423a : nVar;
    }
}
