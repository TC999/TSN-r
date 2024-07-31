package com.amap.api.col.p047s;

import android.os.Build;

/* compiled from: Rom.java */
/* renamed from: com.amap.api.col.s.da */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public enum EnumC2043da {
    MIUI(C2079j1.m52857t("IeGlhb21p")),
    Flyme(C2079j1.m52857t("IbWVpenU")),
    RH(C2079j1.m52857t("IaHVhd2Vp")),
    ColorOS(C2079j1.m52857t("Ib3Bwbw")),
    FuntouchOS(C2079j1.m52857t("Idml2bw")),
    SmartisanOS(C2079j1.m52857t("Mc21hcnRpc2Fu")),
    AmigoOS(C2079j1.m52857t("IYW1pZ28")),
    EUI(C2079j1.m52857t("IbGV0dg")),
    Sense(C2079j1.m52857t("EaHRj")),
    LG(C2079j1.m52857t("EbGdl")),
    Google(C2079j1.m52857t("IZ29vZ2xl")),
    NubiaUI(C2079j1.m52857t("IbnViaWE")),
    Other("");
    

    /* renamed from: n */
    private String f6044n;

    /* renamed from: o */
    private int f6045o;

    /* renamed from: p */
    private String f6046p;

    /* renamed from: q */
    private String f6047q;

    /* renamed from: r */
    private String f6048r = Build.MANUFACTURER;

    EnumC2043da(String str) {
        this.f6044n = str;
    }

    /* renamed from: a */
    public final String m53078a() {
        return this.f6044n;
    }

    /* renamed from: b */
    public final String m53075b() {
        return this.f6046p;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.f6045o + ", versionName='" + this.f6047q + "',ma=" + this.f6044n + "',manufacturer=" + this.f6048r + "'}";
    }

    /* renamed from: a */
    public final void m53077a(int i) {
        this.f6045o = i;
    }

    /* renamed from: b */
    public final void m53074b(String str) {
        this.f6047q = str;
    }

    /* renamed from: a */
    public final void m53076a(String str) {
        this.f6046p = str;
    }
}
