package com.bytedance.sdk.component.w.c.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class f {

    /* renamed from: c  reason: collision with root package name */
    final byte[] f30439c;

    /* renamed from: f  reason: collision with root package name */
    f f30440f;

    /* renamed from: r  reason: collision with root package name */
    f f30441r;
    boolean sr;
    boolean ux;

    /* renamed from: w  reason: collision with root package name */
    int f30442w;
    int xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f() {
        this.f30439c = new byte[8192];
        this.ux = true;
        this.sr = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f c() {
        this.sr = true;
        return new f(this.f30439c, this.f30442w, this.xv, true, false);
    }

    public final f w() {
        f fVar = this.f30440f;
        f fVar2 = fVar != this ? fVar : null;
        f fVar3 = this.f30441r;
        if (fVar3 != null) {
            fVar3.f30440f = fVar;
        }
        f fVar4 = this.f30440f;
        if (fVar4 != null) {
            fVar4.f30441r = fVar3;
        }
        this.f30440f = null;
        this.f30441r = null;
        return fVar2;
    }

    public final f c(f fVar) {
        fVar.f30441r = this;
        fVar.f30440f = this.f30440f;
        this.f30440f.f30441r = fVar;
        this.f30440f = fVar;
        return fVar;
    }

    f(byte[] bArr, int i4, int i5, boolean z3, boolean z4) {
        this.f30439c = bArr;
        this.f30442w = i4;
        this.xv = i5;
        this.sr = z3;
        this.ux = z4;
    }
}
