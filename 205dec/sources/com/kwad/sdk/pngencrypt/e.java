package com.kwad.sdk.pngencrypt;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    final k aKS;
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

    public e(k kVar) {
        this.aKS = kVar;
        dG(1);
        dF(0);
    }

    private int JX() {
        return JW();
    }

    private void dF(int i4) {
        this.aLc = i4;
        int i5 = (i4 * this.aKW) + this.aKY;
        this.aLd = i5;
        if (i5 < 0 || i5 >= this.aKS.aKU) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    private void dG(int i4) {
        if (this.aKT == i4) {
            return;
        }
        this.aKT = i4;
        byte[] dH = dH(i4);
        byte b4 = dH[0];
        this.aKX = b4;
        byte b5 = dH[1];
        this.aKW = b5;
        byte b6 = dH[2];
        this.aKZ = b6;
        byte b7 = dH[3];
        this.aKY = b7;
        k kVar = this.aKS;
        int i5 = kVar.aKU;
        this.aKU = i5 > b7 ? (((i5 + b5) - 1) - b7) / b5 : 0;
        int i6 = kVar.aKV;
        int i7 = i6 > b6 ? (((i6 + b4) - 1) - b6) / b4 : 0;
        this.aKV = i7;
        if (i7 == 0) {
            this.aKU = 0;
        }
        int i8 = kVar.aLo;
        this.aLb = b4 * i8;
        this.aLa = b6 * i8;
    }

    private static byte[] dH(int i4) {
        switch (i4) {
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
                throw new PngjException("bad interlace pass" + i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean JR() {
        int i4;
        while (true) {
            this.aLe++;
            int i5 = this.aKU;
            if (i5 != 0 && (i4 = this.aLc) < i5 - 1) {
                dF(i4 + 1);
                break;
            }
            int i6 = this.aKT;
            if (i6 == 7) {
                this.aLg = true;
                return false;
            }
            dG(i6 + 1);
            if (this.aKU == 0) {
                this.aLe--;
            } else {
                dF(0);
                break;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int JS() {
        return this.aLc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int JT() {
        return this.aLd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int JU() {
        return this.aKT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int JV() {
        return this.aKU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int JW() {
        return this.aKV;
    }

    public final int JY() {
        return ((this.aKS.aLt * JX()) + 7) / 8;
    }
}
