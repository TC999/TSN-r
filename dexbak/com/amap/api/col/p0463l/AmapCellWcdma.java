package com.amap.api.col.p0463l;

import java.io.Serializable;

/* renamed from: com.amap.api.col.3l.ks */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AmapCellWcdma extends AmapCell implements Serializable {

    /* renamed from: j */
    public int f4650j;

    /* renamed from: k */
    public int f4651k;

    /* renamed from: l */
    public int f4652l;

    /* renamed from: m */
    public int f4653m;

    public AmapCellWcdma() {
        this.f4650j = 0;
        this.f4651k = 0;
        this.f4652l = Integer.MAX_VALUE;
        this.f4653m = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0463l.AmapCell
    /* renamed from: a */
    public final AmapCell clone() {
        AmapCellWcdma amapCellWcdma = new AmapCellWcdma(this.f4632h, this.f4633i);
        amapCellWcdma.m54599a(this);
        amapCellWcdma.f4650j = this.f4650j;
        amapCellWcdma.f4651k = this.f4651k;
        amapCellWcdma.f4652l = this.f4652l;
        amapCellWcdma.f4653m = this.f4653m;
        return amapCellWcdma;
    }

    @Override // com.amap.api.col.p0463l.AmapCell
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.f4650j + ", cid=" + this.f4651k + ", psc=" + this.f4652l + ", uarfcn=" + this.f4653m + ", mcc='" + this.f4625a + "', mnc='" + this.f4626b + "', signalStrength=" + this.f4627c + ", asuLevel=" + this.f4628d + ", lastUpdateSystemMills=" + this.f4629e + ", lastUpdateUtcMills=" + this.f4630f + ", age=" + this.f4631g + ", main=" + this.f4632h + ", newApi=" + this.f4633i + '}';
    }

    public AmapCellWcdma(boolean z, boolean z2) {
        super(z, z2);
        this.f4650j = 0;
        this.f4651k = 0;
        this.f4652l = Integer.MAX_VALUE;
        this.f4653m = Integer.MAX_VALUE;
    }
}
