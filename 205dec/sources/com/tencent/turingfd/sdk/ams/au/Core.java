package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class Core extends Draco {

    /* renamed from: c  reason: collision with root package name */
    public int f51976c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float f51977d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f51978e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f51979f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f51980g = 0.0f;

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Dorado dorado) {
        dorado.a(this.f51976c, 0);
        dorado.a(this.f51977d, 1);
        dorado.a(this.f51978e, 2);
        float f4 = this.f51979f;
        if (f4 != 0.0f) {
            dorado.a(f4, 3);
        }
        float f5 = this.f51980g;
        if (f5 != 0.0f) {
            dorado.a(f5, 4);
        }
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Cygnus cygnus) {
        this.f51976c = cygnus.a(this.f51976c, 0, true);
        this.f51977d = cygnus.a(this.f51977d, 1, true);
        this.f51978e = cygnus.a(this.f51978e, 2, true);
        this.f51979f = cygnus.a(this.f51979f, 3, false);
        this.f51980g = cygnus.a(this.f51980g, 4, false);
    }
}
