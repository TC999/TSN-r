package com.amap.api.col.p0003l;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Rom.java */
/* renamed from: com.amap.api.col.3l.gv  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public enum gv {
    MIUI(q4.u("IeGlhb21p")),
    Flyme(q4.u("IbWVpenU")),
    RH(q4.u("IaHVhd2Vp")),
    ColorOS(q4.u("Ib3Bwbw")),
    FuntouchOS(q4.u("Idml2bw")),
    SmartisanOS(q4.u("Mc21hcnRpc2Fu")),
    AmigoOS(q4.u("IYW1pZ28")),
    EUI(q4.u("IbGV0dg")),
    Sense(q4.u("EaHRj")),
    LG(q4.u("EbGdl")),
    Google(q4.u("IZ29vZ2xl")),
    NubiaUI(q4.u("IbnViaWE")),
    Other("");
    

    /* renamed from: n  reason: collision with root package name */
    private String f7931n;

    /* renamed from: o  reason: collision with root package name */
    private int f7932o;

    /* renamed from: p  reason: collision with root package name */
    private String f7933p;

    /* renamed from: q  reason: collision with root package name */
    private String f7934q;

    /* renamed from: r  reason: collision with root package name */
    private String f7935r = Build.MANUFACTURER;

    gv(String str) {
        this.f7931n = str;
    }

    public final String a() {
        return this.f7931n;
    }

    public final String b() {
        return this.f7933p;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.f7932o + ", versionName='" + this.f7934q + "',ma=" + this.f7931n + "',manufacturer=" + this.f7935r + "'}";
    }

    public final void a(int i4) {
        this.f7932o = i4;
    }

    public final void b(String str) {
        this.f7934q = str;
    }

    public final void a(String str) {
        this.f7933p = str;
    }
}
