package com.kwad.sdk.pngencrypt;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class k {
    public final int aKU;
    public final int aKV;
    public final int aLn;
    public final int aLo;
    public final boolean aLp;
    public final boolean aLq;
    public final boolean aLr;
    public final boolean aLs;
    public final int aLt;
    public final int aLu;
    public final int aLv;
    public final int aLw;
    public final int aLx;
    private long aLy = -1;
    private long aLz = -1;

    public k(int i4, int i5, int i6, boolean z3, boolean z4, boolean z5) {
        this.aKV = i4;
        this.aKU = i5;
        this.aLp = z3;
        this.aLr = z5;
        this.aLq = z4;
        if (z4 && z5) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        int i7 = (z4 || z5) ? z3 ? 2 : 1 : z3 ? 4 : 3;
        this.aLo = i7;
        this.aLn = i6;
        boolean z6 = i6 < 8;
        this.aLs = z6;
        int i8 = i7 * i6;
        this.aLt = i8;
        this.aLu = (i8 + 7) / 8;
        int i9 = ((i8 * i4) + 7) / 8;
        this.aLv = i9;
        int i10 = i7 * i4;
        this.aLw = i10;
        this.aLx = z6 ? i9 : i10;
        if (i6 == 1 || i6 == 2 || i6 == 4) {
            if (!z5 && !z4) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + i6);
            }
        } else if (i6 != 8) {
            if (i6 != 16) {
                throw new PngjException("invalid bitdepth=" + i6);
            } else if (z5) {
                throw new PngjException("indexed can't have bitdepth=" + i6);
            }
        }
        if (i4 <= 0 || i4 > 16777216) {
            throw new PngjException("invalid cols=" + i4 + " ???");
        } else if (i5 > 0 && i5 <= 16777216) {
            if (i10 <= 0) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i5 + " ???");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            return this.aLp == kVar.aLp && this.aLn == kVar.aLn && this.aKV == kVar.aKV && this.aLq == kVar.aLq && this.aLr == kVar.aLr && this.aKU == kVar.aKU;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.aLp ? 1231 : 1237) + 31) * 31) + this.aLn) * 31) + this.aKV) * 31) + (this.aLq ? 1231 : 1237)) * 31) + (this.aLr ? 1231 : 1237)) * 31) + this.aKU;
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.aKV + ", rows=" + this.aKU + ", bitDepth=" + this.aLn + ", channels=" + this.aLo + ", alpha=" + this.aLp + ", greyscale=" + this.aLq + ", indexed=" + this.aLr + "]";
    }
}
