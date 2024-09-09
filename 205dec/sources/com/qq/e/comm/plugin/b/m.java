package com.qq.e.comm.plugin.b;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private String f42030a;

    /* renamed from: b  reason: collision with root package name */
    private g f42031b;

    /* renamed from: c  reason: collision with root package name */
    private f f42032c;

    public m(String str, g gVar, int i4) {
        this.f42030a = str;
        this.f42031b = gVar;
        this.f42032c = e.a(gVar, i4);
    }

    public g a() {
        return this.f42031b;
    }

    public int b() {
        f fVar = this.f42032c;
        if (fVar == null) {
            return -1;
        }
        return fVar.a();
    }

    public String c() {
        return this.f42030a;
    }

    public int d() {
        f fVar = this.f42032c;
        if (fVar == null) {
            return -1;
        }
        return fVar.b();
    }

    public m(String str, g gVar, f fVar) {
        this.f42030a = str;
        this.f42031b = gVar;
        this.f42032c = fVar;
    }
}
