package com.amap.api.col.p0463l;

import java.io.Serializable;

/* renamed from: com.amap.api.col.3l.ko */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AmapCell implements Serializable {

    /* renamed from: a */
    public String f4625a;

    /* renamed from: b */
    public String f4626b;

    /* renamed from: c */
    public int f4627c;

    /* renamed from: d */
    public int f4628d;

    /* renamed from: e */
    public long f4629e;

    /* renamed from: f */
    public long f4630f;

    /* renamed from: g */
    public int f4631g;

    /* renamed from: h */
    public boolean f4632h;

    /* renamed from: i */
    public boolean f4633i;

    public AmapCell() {
        this.f4625a = "";
        this.f4626b = "";
        this.f4627c = 99;
        this.f4628d = Integer.MAX_VALUE;
        this.f4629e = 0L;
        this.f4630f = 0L;
        this.f4631g = 0;
        this.f4633i = true;
    }

    /* renamed from: a */
    private static int m54598a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            ALLog.m54456a(e);
            return 0;
        }
    }

    @Override // 
    /* renamed from: a */
    public abstract AmapCell clone();

    /* renamed from: b */
    public final int m54597b() {
        return m54598a(this.f4625a);
    }

    /* renamed from: c */
    public final int m54596c() {
        return m54598a(this.f4626b);
    }

    public String toString() {
        return "AmapCell{mcc=" + this.f4625a + ", mnc=" + this.f4626b + ", signalStrength=" + this.f4627c + ", asulevel=" + this.f4628d + ", lastUpdateSystemMills=" + this.f4629e + ", lastUpdateUtcMills=" + this.f4630f + ", age=" + this.f4631g + ", main=" + this.f4632h + ", newapi=" + this.f4633i + '}';
    }

    /* renamed from: a */
    public final void m54599a(AmapCell amapCell) {
        this.f4625a = amapCell.f4625a;
        this.f4626b = amapCell.f4626b;
        this.f4627c = amapCell.f4627c;
        this.f4628d = amapCell.f4628d;
        this.f4629e = amapCell.f4629e;
        this.f4630f = amapCell.f4630f;
        this.f4631g = amapCell.f4631g;
        this.f4632h = amapCell.f4632h;
        this.f4633i = amapCell.f4633i;
    }

    public AmapCell(boolean z, boolean z2) {
        this.f4625a = "";
        this.f4626b = "";
        this.f4627c = 99;
        this.f4628d = Integer.MAX_VALUE;
        this.f4629e = 0L;
        this.f4630f = 0L;
        this.f4631g = 0;
        this.f4632h = z;
        this.f4633i = z2;
    }
}
