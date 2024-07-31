package com.kwad.sdk.pngencrypt;

/* renamed from: com.kwad.sdk.pngencrypt.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10931k {
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

    public C10931k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.aKV = i;
        this.aKU = i2;
        this.aLp = z;
        this.aLr = z3;
        this.aLq = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        int i4 = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.aLo = i4;
        this.aLn = i3;
        boolean z4 = i3 < 8;
        this.aLs = z4;
        int i5 = i4 * i3;
        this.aLt = i5;
        this.aLu = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.aLv = i6;
        int i7 = i4 * i;
        this.aLw = i7;
        this.aLx = z4 ? i6 : i7;
        if (i3 == 1 || i3 == 2 || i3 == 4) {
            if (!z3 && !z2) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + i3);
            }
        } else if (i3 != 8) {
            if (i3 != 16) {
                throw new PngjException("invalid bitdepth=" + i3);
            } else if (z3) {
                throw new PngjException("indexed can't have bitdepth=" + i3);
            }
        }
        if (i <= 0 || i > 16777216) {
            throw new PngjException("invalid cols=" + i + " ???");
        } else if (i2 > 0 && i2 <= 16777216) {
            if (i7 <= 0) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i2 + " ???");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C10931k.class == obj.getClass()) {
            C10931k c10931k = (C10931k) obj;
            return this.aLp == c10931k.aLp && this.aLn == c10931k.aLn && this.aKV == c10931k.aKV && this.aLq == c10931k.aLq && this.aLr == c10931k.aLr && this.aKU == c10931k.aKU;
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
