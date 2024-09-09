package com.qq.e.comm.plugin.n0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends b {

    /* renamed from: e  reason: collision with root package name */
    private int f44744e;

    /* renamed from: f  reason: collision with root package name */
    private int f44745f;

    public e(String str) {
        super(str);
    }

    @Override // com.qq.e.comm.plugin.n0.b
    protected String d() {
        return "ei";
    }

    public void d(int i4) {
        this.f44744e = i4;
        a("error_code", Integer.valueOf(i4));
    }

    public int f() {
        return this.f44745f;
    }

    public int g() {
        return this.f44744e;
    }

    public e(int i4) {
        super(i4);
    }

    public void b(int i4) {
        if (i4 > 0) {
            a("adcnt", Integer.valueOf(i4));
        }
    }

    public void c(int i4) {
        this.f44745f = i4;
        a("enum_code", Integer.valueOf(i4));
    }

    public void a(com.qq.e.comm.plugin.d0.e.d dVar) {
        if (dVar != null) {
            a("ct", Integer.valueOf(dVar.a()));
        }
    }
}
