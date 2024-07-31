package com.amap.api.col.p0463l;

import android.os.Build;

/* renamed from: com.amap.api.col.3l.gv */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public enum Rom {
    MIUI(C1925p4.m54183u("IeGlhb21p")),
    Flyme(C1925p4.m54183u("IbWVpenU")),
    RH(C1925p4.m54183u("IaHVhd2Vp")),
    ColorOS(C1925p4.m54183u("Ib3Bwbw")),
    FuntouchOS(C1925p4.m54183u("Idml2bw")),
    SmartisanOS(C1925p4.m54183u("Mc21hcnRpc2Fu")),
    AmigoOS(C1925p4.m54183u("IYW1pZ28")),
    EUI(C1925p4.m54183u("IbGV0dg")),
    Sense(C1925p4.m54183u("EaHRj")),
    LG(C1925p4.m54183u("EbGdl")),
    Google(C1925p4.m54183u("IZ29vZ2xl")),
    NubiaUI(C1925p4.m54183u("IbnViaWE")),
    Other("");
    

    /* renamed from: n */
    private String f4362n;

    /* renamed from: o */
    private int f4363o;

    /* renamed from: p */
    private String f4364p;

    /* renamed from: q */
    private String f4365q;

    /* renamed from: r */
    private String f4366r = Build.MANUFACTURER;

    Rom(String str) {
        this.f4362n = str;
    }

    /* renamed from: a */
    public final String m54873a() {
        return this.f4362n;
    }

    /* renamed from: b */
    public final String m54870b() {
        return this.f4364p;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.f4363o + ", versionName='" + this.f4365q + "',ma=" + this.f4362n + "',manufacturer=" + this.f4366r + "'}";
    }

    /* renamed from: a */
    public final void m54872a(int i) {
        this.f4363o = i;
    }

    /* renamed from: b */
    public final void m54869b(String str) {
        this.f4365q = str;
    }

    /* renamed from: a */
    public final void m54871a(String str) {
        this.f4364p = str;
    }
}
