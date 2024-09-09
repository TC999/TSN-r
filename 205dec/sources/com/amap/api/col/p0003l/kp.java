package com.amap.api.col.p0003l;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AmapCellCdma.java */
/* renamed from: com.amap.api.col.3l.kp  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class kp extends ko implements Serializable {

    /* renamed from: j  reason: collision with root package name */
    public int f8270j;

    /* renamed from: k  reason: collision with root package name */
    public int f8271k;

    /* renamed from: l  reason: collision with root package name */
    public int f8272l;

    /* renamed from: m  reason: collision with root package name */
    public int f8273m;

    /* renamed from: n  reason: collision with root package name */
    public int f8274n;

    public kp() {
        this.f8270j = 0;
        this.f8271k = 0;
        this.f8272l = 0;
    }

    @Override // com.amap.api.col.p0003l.ko
    /* renamed from: a */
    public final ko clone() {
        kp kpVar = new kp(this.f8268h, this.f8269i);
        kpVar.a(this);
        kpVar.f8270j = this.f8270j;
        kpVar.f8271k = this.f8271k;
        kpVar.f8272l = this.f8272l;
        kpVar.f8273m = this.f8273m;
        kpVar.f8274n = this.f8274n;
        return kpVar;
    }

    @Override // com.amap.api.col.p0003l.ko
    public final String toString() {
        return "AmapCellCdma{sid=" + this.f8270j + ", nid=" + this.f8271k + ", bid=" + this.f8272l + ", latitude=" + this.f8273m + ", longitude=" + this.f8274n + ", mcc='" + this.f8261a + "', mnc='" + this.f8262b + "', signalStrength=" + this.f8263c + ", asuLevel=" + this.f8264d + ", lastUpdateSystemMills=" + this.f8265e + ", lastUpdateUtcMills=" + this.f8266f + ", age=" + this.f8267g + ", main=" + this.f8268h + ", newApi=" + this.f8269i + '}';
    }

    public kp(boolean z3, boolean z4) {
        super(z3, z4);
        this.f8270j = 0;
        this.f8271k = 0;
        this.f8272l = 0;
    }
}
