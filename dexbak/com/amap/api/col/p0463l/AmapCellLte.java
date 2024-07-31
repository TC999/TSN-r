package com.amap.api.col.p0463l;

import java.io.Serializable;

/* renamed from: com.amap.api.col.3l.kr */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AmapCellLte extends AmapCell implements Serializable {

    /* renamed from: j */
    public int f4645j;

    /* renamed from: k */
    public int f4646k;

    /* renamed from: l */
    public int f4647l;

    /* renamed from: m */
    public int f4648m;

    /* renamed from: n */
    public int f4649n;

    public AmapCellLte() {
        this.f4645j = 0;
        this.f4646k = 0;
        this.f4647l = Integer.MAX_VALUE;
        this.f4648m = Integer.MAX_VALUE;
        this.f4649n = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0463l.AmapCell
    /* renamed from: a */
    public final AmapCell clone() {
        AmapCellLte amapCellLte = new AmapCellLte(this.f4632h);
        amapCellLte.m54599a(this);
        amapCellLte.f4645j = this.f4645j;
        amapCellLte.f4646k = this.f4646k;
        amapCellLte.f4647l = this.f4647l;
        amapCellLte.f4648m = this.f4648m;
        amapCellLte.f4649n = this.f4649n;
        return amapCellLte;
    }

    @Override // com.amap.api.col.p0463l.AmapCell
    public final String toString() {
        return "AmapCellLte{tac=" + this.f4645j + ", ci=" + this.f4646k + ", pci=" + this.f4647l + ", earfcn=" + this.f4648m + ", timingAdvance=" + this.f4649n + ", mcc='" + this.f4625a + "', mnc='" + this.f4626b + "', signalStrength=" + this.f4627c + ", asuLevel=" + this.f4628d + ", lastUpdateSystemMills=" + this.f4629e + ", lastUpdateUtcMills=" + this.f4630f + ", age=" + this.f4631g + ", main=" + this.f4632h + ", newApi=" + this.f4633i + '}';
    }

    public AmapCellLte(boolean z) {
        super(z, true);
        this.f4645j = 0;
        this.f4646k = 0;
        this.f4647l = Integer.MAX_VALUE;
        this.f4648m = Integer.MAX_VALUE;
        this.f4649n = Integer.MAX_VALUE;
    }
}
