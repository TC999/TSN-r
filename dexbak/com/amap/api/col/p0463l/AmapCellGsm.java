package com.amap.api.col.p0463l;

import java.io.Serializable;

/* renamed from: com.amap.api.col.3l.kq */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AmapCellGsm extends AmapCell implements Serializable {

    /* renamed from: j */
    public int f4639j;

    /* renamed from: k */
    public int f4640k;

    /* renamed from: l */
    public int f4641l;

    /* renamed from: m */
    public int f4642m;

    /* renamed from: n */
    public int f4643n;

    /* renamed from: o */
    public int f4644o;

    public AmapCellGsm() {
        this.f4639j = 0;
        this.f4640k = 0;
        this.f4641l = Integer.MAX_VALUE;
        this.f4642m = Integer.MAX_VALUE;
        this.f4643n = Integer.MAX_VALUE;
        this.f4644o = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0463l.AmapCell
    /* renamed from: a */
    public final AmapCell clone() {
        AmapCellGsm amapCellGsm = new AmapCellGsm(this.f4632h, this.f4633i);
        amapCellGsm.m54599a(this);
        amapCellGsm.f4639j = this.f4639j;
        amapCellGsm.f4640k = this.f4640k;
        amapCellGsm.f4641l = this.f4641l;
        amapCellGsm.f4642m = this.f4642m;
        amapCellGsm.f4643n = this.f4643n;
        amapCellGsm.f4644o = this.f4644o;
        return amapCellGsm;
    }

    @Override // com.amap.api.col.p0463l.AmapCell
    public final String toString() {
        return "AmapCellGsm{lac=" + this.f4639j + ", cid=" + this.f4640k + ", psc=" + this.f4641l + ", arfcn=" + this.f4642m + ", bsic=" + this.f4643n + ", timingAdvance=" + this.f4644o + ", mcc='" + this.f4625a + "', mnc='" + this.f4626b + "', signalStrength=" + this.f4627c + ", asuLevel=" + this.f4628d + ", lastUpdateSystemMills=" + this.f4629e + ", lastUpdateUtcMills=" + this.f4630f + ", age=" + this.f4631g + ", main=" + this.f4632h + ", newApi=" + this.f4633i + '}';
    }

    public AmapCellGsm(boolean z, boolean z2) {
        super(z, z2);
        this.f4639j = 0;
        this.f4640k = 0;
        this.f4641l = Integer.MAX_VALUE;
        this.f4642m = Integer.MAX_VALUE;
        this.f4643n = Integer.MAX_VALUE;
        this.f4644o = Integer.MAX_VALUE;
    }
}
