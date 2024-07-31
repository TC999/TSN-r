package com.kwad.sdk.pngencrypt;

/* renamed from: com.kwad.sdk.pngencrypt.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10924e {
    final C10931k aKS;
    private int aKU;
    private int aKV;
    int aKW;
    int aKX;
    int aKY;
    int aKZ;
    int aLa;
    int aLb;
    private int aKT = 0;
    private int aLc = -1;
    private int aLd = -1;
    private int aLe = 0;
    private boolean aLg = false;
    int aLf = 0;

    public C10924e(C10931k c10931k) {
        this.aKS = c10931k;
        m24443dG(1);
        m24444dF(0);
    }

    /* renamed from: JX */
    private int m24446JX() {
        return m24447JW();
    }

    /* renamed from: dF */
    private void m24444dF(int i) {
        this.aLc = i;
        int i2 = (i * this.aKW) + this.aKY;
        this.aLd = i2;
        if (i2 < 0 || i2 >= this.aKS.aKU) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    /* renamed from: dG */
    private void m24443dG(int i) {
        if (this.aKT == i) {
            return;
        }
        this.aKT = i;
        byte[] m24442dH = m24442dH(i);
        byte b = m24442dH[0];
        this.aKX = b;
        byte b2 = m24442dH[1];
        this.aKW = b2;
        byte b3 = m24442dH[2];
        this.aKZ = b3;
        byte b4 = m24442dH[3];
        this.aKY = b4;
        C10931k c10931k = this.aKS;
        int i2 = c10931k.aKU;
        this.aKU = i2 > b4 ? (((i2 + b2) - 1) - b4) / b2 : 0;
        int i3 = c10931k.aKV;
        int i4 = i3 > b3 ? (((i3 + b) - 1) - b3) / b : 0;
        this.aKV = i4;
        if (i4 == 0) {
            this.aKU = 0;
        }
        int i5 = c10931k.aLo;
        this.aLb = b * i5;
        this.aLa = b3 * i5;
    }

    /* renamed from: dH */
    private static byte[] m24442dH(int i) {
        switch (i) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjException("bad interlace pass" + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: JR */
    public final boolean m24452JR() {
        int i;
        while (true) {
            this.aLe++;
            int i2 = this.aKU;
            if (i2 != 0 && (i = this.aLc) < i2 - 1) {
                m24444dF(i + 1);
                break;
            }
            int i3 = this.aKT;
            if (i3 == 7) {
                this.aLg = true;
                return false;
            }
            m24443dG(i3 + 1);
            if (this.aKU == 0) {
                this.aLe--;
            } else {
                m24444dF(0);
                break;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: JS */
    public final int m24451JS() {
        return this.aLc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: JT */
    public final int m24450JT() {
        return this.aLd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: JU */
    public final int m24449JU() {
        return this.aKT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: JV */
    public final int m24448JV() {
        return this.aKU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: JW */
    public final int m24447JW() {
        return this.aKV;
    }

    /* renamed from: JY */
    public final int m24445JY() {
        return ((this.aKS.aLt * m24446JX()) + 7) / 8;
    }
}
