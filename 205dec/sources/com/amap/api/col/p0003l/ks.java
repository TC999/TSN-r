package com.amap.api.col.p0003l;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AmapCellWcdma.java */
/* renamed from: com.amap.api.col.3l.ks  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ks extends ko implements Serializable {

    /* renamed from: j  reason: collision with root package name */
    public int f8286j;

    /* renamed from: k  reason: collision with root package name */
    public int f8287k;

    /* renamed from: l  reason: collision with root package name */
    public int f8288l;

    /* renamed from: m  reason: collision with root package name */
    public int f8289m;

    public ks() {
        this.f8286j = 0;
        this.f8287k = 0;
        this.f8288l = Integer.MAX_VALUE;
        this.f8289m = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003l.ko
    /* renamed from: a */
    public final ko clone() {
        ks ksVar = new ks(this.f8268h, this.f8269i);
        ksVar.a(this);
        ksVar.f8286j = this.f8286j;
        ksVar.f8287k = this.f8287k;
        ksVar.f8288l = this.f8288l;
        ksVar.f8289m = this.f8289m;
        return ksVar;
    }

    @Override // com.amap.api.col.p0003l.ko
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.f8286j + ", cid=" + this.f8287k + ", psc=" + this.f8288l + ", uarfcn=" + this.f8289m + ", mcc='" + this.f8261a + "', mnc='" + this.f8262b + "', signalStrength=" + this.f8263c + ", asuLevel=" + this.f8264d + ", lastUpdateSystemMills=" + this.f8265e + ", lastUpdateUtcMills=" + this.f8266f + ", age=" + this.f8267g + ", main=" + this.f8268h + ", newApi=" + this.f8269i + '}';
    }

    public ks(boolean z3, boolean z4) {
        super(z3, z4);
        this.f8286j = 0;
        this.f8287k = 0;
        this.f8288l = Integer.MAX_VALUE;
        this.f8289m = Integer.MAX_VALUE;
    }
}
