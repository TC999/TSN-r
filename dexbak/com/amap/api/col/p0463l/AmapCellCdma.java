package com.amap.api.col.p0463l;

import java.io.Serializable;

/* renamed from: com.amap.api.col.3l.kp */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AmapCellCdma extends AmapCell implements Serializable {

    /* renamed from: j */
    public int f4634j;

    /* renamed from: k */
    public int f4635k;

    /* renamed from: l */
    public int f4636l;

    /* renamed from: m */
    public int f4637m;

    /* renamed from: n */
    public int f4638n;

    public AmapCellCdma() {
        this.f4634j = 0;
        this.f4635k = 0;
        this.f4636l = 0;
    }

    @Override // com.amap.api.col.p0463l.AmapCell
    /* renamed from: a */
    public final AmapCell clone() {
        AmapCellCdma amapCellCdma = new AmapCellCdma(this.f4632h, this.f4633i);
        amapCellCdma.m54599a(this);
        amapCellCdma.f4634j = this.f4634j;
        amapCellCdma.f4635k = this.f4635k;
        amapCellCdma.f4636l = this.f4636l;
        amapCellCdma.f4637m = this.f4637m;
        amapCellCdma.f4638n = this.f4638n;
        return amapCellCdma;
    }

    @Override // com.amap.api.col.p0463l.AmapCell
    public final String toString() {
        return "AmapCellCdma{sid=" + this.f4634j + ", nid=" + this.f4635k + ", bid=" + this.f4636l + ", latitude=" + this.f4637m + ", longitude=" + this.f4638n + ", mcc='" + this.f4625a + "', mnc='" + this.f4626b + "', signalStrength=" + this.f4627c + ", asuLevel=" + this.f4628d + ", lastUpdateSystemMills=" + this.f4629e + ", lastUpdateUtcMills=" + this.f4630f + ", age=" + this.f4631g + ", main=" + this.f4632h + ", newApi=" + this.f4633i + '}';
    }

    public AmapCellCdma(boolean z, boolean z2) {
        super(z, z2);
        this.f4634j = 0;
        this.f4635k = 0;
        this.f4636l = 0;
    }
}
