package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class Berry extends Draco implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public int f51918c = 0;

    /* renamed from: d  reason: collision with root package name */
    public String f51919d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f51920e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f51921f = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f51922g = "";

    /* renamed from: h  reason: collision with root package name */
    public long f51923h = 0;

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Dorado dorado) {
        dorado.a(this.f51918c, 0);
        dorado.a(this.f51919d, 1);
        int i4 = this.f51920e;
        if (i4 != 0) {
            dorado.a(i4, 3);
        }
        int i5 = this.f51921f;
        if (i5 != 0) {
            dorado.a(i5, 4);
        }
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Cygnus cygnus) {
        this.f51918c = cygnus.a(this.f51918c, 0, true);
        this.f51919d = cygnus.b(1, true);
        this.f51920e = cygnus.a(this.f51920e, 3, false);
        this.f51921f = cygnus.a(this.f51921f, 4, false);
        this.f51922g = cygnus.b(5, false);
        this.f51923h = cygnus.a(this.f51923h, 6, false);
    }
}
