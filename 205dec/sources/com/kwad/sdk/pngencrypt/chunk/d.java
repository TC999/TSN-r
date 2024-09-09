package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    public final byte[] aMa;
    private CRC32 aMd;
    public final String ahi;
    public final int len;
    public byte[] data = null;
    private long aMb = 0;
    public byte[] aMc = new byte[4];

    public d(int i4, String str, boolean z3) {
        this.len = i4;
        this.ahi = str;
        this.aMa = b.gi(str);
        for (int i5 = 0; i5 < 4; i5++) {
            byte[] bArr = this.aMa;
            if (bArr[i5] < 65 || bArr[i5] > 122 || (bArr[i5] > 90 && bArr[i5] < 97)) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z3) {
            Kk();
        }
    }

    private void Kk() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ByteArrayInputStream Kl() {
        return new ByteArrayInputStream(this.data);
    }

    public final long Km() {
        return this.aMb;
    }

    public final void aD(long j4) {
        this.aMb = j4;
    }

    public final void bI(boolean z3) {
        int value = (int) this.aMd.getValue();
        int g4 = com.kwad.sdk.pngencrypt.n.g(this.aMc, 0);
        if (value != g4) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.ahi, Long.valueOf(this.aMb), Integer.valueOf(g4), Integer.valueOf(value));
            if (z3) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException(format));
            } else {
                com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", format);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            String str = this.ahi;
            if (str == null) {
                if (dVar.ahi != null) {
                    return false;
                }
            } else if (!str.equals(dVar.ahi)) {
                return false;
            }
            return this.aMb == dVar.aMb;
        }
        return false;
    }

    public final void f(byte[] bArr, int i4, int i5) {
        if (this.aMd == null) {
            this.aMd = new CRC32();
        }
        this.aMd.update(bArr, i4, i5);
    }

    public final int hashCode() {
        String str = this.ahi;
        int hashCode = str == null ? 0 : str.hashCode();
        long j4 = this.aMb;
        return ((hashCode + 31) * 31) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + b.i(this.aMa) + " len=" + this.len;
    }
}
