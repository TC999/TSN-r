package com.amap.api.col.p0003l;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AmapCellGsm.java */
/* renamed from: com.amap.api.col.3l.kq  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class kq extends ko implements Serializable {

    /* renamed from: j  reason: collision with root package name */
    public int f8275j;

    /* renamed from: k  reason: collision with root package name */
    public int f8276k;

    /* renamed from: l  reason: collision with root package name */
    public int f8277l;

    /* renamed from: m  reason: collision with root package name */
    public int f8278m;

    /* renamed from: n  reason: collision with root package name */
    public int f8279n;

    /* renamed from: o  reason: collision with root package name */
    public int f8280o;

    public kq() {
        this.f8275j = 0;
        this.f8276k = 0;
        this.f8277l = Integer.MAX_VALUE;
        this.f8278m = Integer.MAX_VALUE;
        this.f8279n = Integer.MAX_VALUE;
        this.f8280o = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003l.ko
    /* renamed from: a */
    public final ko clone() {
        kq kqVar = new kq(this.f8268h, this.f8269i);
        kqVar.a(this);
        kqVar.f8275j = this.f8275j;
        kqVar.f8276k = this.f8276k;
        kqVar.f8277l = this.f8277l;
        kqVar.f8278m = this.f8278m;
        kqVar.f8279n = this.f8279n;
        kqVar.f8280o = this.f8280o;
        return kqVar;
    }

    @Override // com.amap.api.col.p0003l.ko
    public final String toString() {
        return "AmapCellGsm{lac=" + this.f8275j + ", cid=" + this.f8276k + ", psc=" + this.f8277l + ", arfcn=" + this.f8278m + ", bsic=" + this.f8279n + ", timingAdvance=" + this.f8280o + ", mcc='" + this.f8261a + "', mnc='" + this.f8262b + "', signalStrength=" + this.f8263c + ", asuLevel=" + this.f8264d + ", lastUpdateSystemMills=" + this.f8265e + ", lastUpdateUtcMills=" + this.f8266f + ", age=" + this.f8267g + ", main=" + this.f8268h + ", newApi=" + this.f8269i + '}';
    }

    public kq(boolean z3, boolean z4) {
        super(z3, z4);
        this.f8275j = 0;
        this.f8276k = 0;
        this.f8277l = Integer.MAX_VALUE;
        this.f8278m = Integer.MAX_VALUE;
        this.f8279n = Integer.MAX_VALUE;
        this.f8280o = Integer.MAX_VALUE;
    }
}
