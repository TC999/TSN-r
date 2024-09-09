package com.amap.api.col.s;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Rom.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public enum da {
    MIUI(j1.t("IeGlhb21p")),
    Flyme(j1.t("IbWVpenU")),
    RH(j1.t("IaHVhd2Vp")),
    ColorOS(j1.t("Ib3Bwbw")),
    FuntouchOS(j1.t("Idml2bw")),
    SmartisanOS(j1.t("Mc21hcnRpc2Fu")),
    AmigoOS(j1.t("IYW1pZ28")),
    EUI(j1.t("IbGV0dg")),
    Sense(j1.t("EaHRj")),
    LG(j1.t("EbGdl")),
    Google(j1.t("IZ29vZ2xl")),
    NubiaUI(j1.t("IbnViaWE")),
    Other("");
    

    /* renamed from: n  reason: collision with root package name */
    private String f9772n;

    /* renamed from: o  reason: collision with root package name */
    private int f9773o;

    /* renamed from: p  reason: collision with root package name */
    private String f9774p;

    /* renamed from: q  reason: collision with root package name */
    private String f9775q;

    /* renamed from: r  reason: collision with root package name */
    private String f9776r = Build.MANUFACTURER;

    da(String str) {
        this.f9772n = str;
    }

    public final String a() {
        return this.f9772n;
    }

    public final String b() {
        return this.f9774p;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.f9773o + ", versionName='" + this.f9775q + "',ma=" + this.f9772n + "',manufacturer=" + this.f9776r + "'}";
    }

    public final void a(int i4) {
        this.f9773o = i4;
    }

    public final void b(String str) {
        this.f9775q = str;
    }

    public final void a(String str) {
        this.f9774p = str;
    }
}
