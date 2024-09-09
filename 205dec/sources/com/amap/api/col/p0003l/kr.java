package com.amap.api.col.p0003l;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AmapCellLte.java */
/* renamed from: com.amap.api.col.3l.kr  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class kr extends ko implements Serializable {

    /* renamed from: j  reason: collision with root package name */
    public int f8281j;

    /* renamed from: k  reason: collision with root package name */
    public int f8282k;

    /* renamed from: l  reason: collision with root package name */
    public int f8283l;

    /* renamed from: m  reason: collision with root package name */
    public int f8284m;

    /* renamed from: n  reason: collision with root package name */
    public int f8285n;

    public kr() {
        this.f8281j = 0;
        this.f8282k = 0;
        this.f8283l = Integer.MAX_VALUE;
        this.f8284m = Integer.MAX_VALUE;
        this.f8285n = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003l.ko
    /* renamed from: a */
    public final ko clone() {
        kr krVar = new kr(this.f8268h);
        krVar.a(this);
        krVar.f8281j = this.f8281j;
        krVar.f8282k = this.f8282k;
        krVar.f8283l = this.f8283l;
        krVar.f8284m = this.f8284m;
        krVar.f8285n = this.f8285n;
        return krVar;
    }

    @Override // com.amap.api.col.p0003l.ko
    public final String toString() {
        return "AmapCellLte{tac=" + this.f8281j + ", ci=" + this.f8282k + ", pci=" + this.f8283l + ", earfcn=" + this.f8284m + ", timingAdvance=" + this.f8285n + ", mcc='" + this.f8261a + "', mnc='" + this.f8262b + "', signalStrength=" + this.f8263c + ", asuLevel=" + this.f8264d + ", lastUpdateSystemMills=" + this.f8265e + ", lastUpdateUtcMills=" + this.f8266f + ", age=" + this.f8267g + ", main=" + this.f8268h + ", newApi=" + this.f8269i + '}';
    }

    public kr(boolean z3) {
        super(z3, true);
        this.f8281j = 0;
        this.f8282k = 0;
        this.f8283l = Integer.MAX_VALUE;
        this.f8284m = Integer.MAX_VALUE;
        this.f8285n = Integer.MAX_VALUE;
    }
}
