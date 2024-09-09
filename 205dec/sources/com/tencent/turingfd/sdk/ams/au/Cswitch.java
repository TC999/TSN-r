package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.switch  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class Cswitch extends Draco {

    /* renamed from: c  reason: collision with root package name */
    public String f52361c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f52362d = "";

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Dorado dorado) {
        dorado.a(this.f52361c, 0);
        dorado.a(this.f52362d, 1);
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Cygnus cygnus) {
        this.f52361c = cygnus.b(0, true);
        this.f52362d = cygnus.b(1, true);
    }
}
