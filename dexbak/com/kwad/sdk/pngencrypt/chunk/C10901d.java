package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.pngencrypt.C10936n;
import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10901d {
    public final byte[] aMa;
    private CRC32 aMd;
    public final String ahi;
    public final int len;
    public byte[] data = null;
    private long aMb = 0;
    public byte[] aMc = new byte[4];

    public C10901d(int i, String str, boolean z) {
        this.len = i;
        this.ahi = str;
        this.aMa = C10899b.m24497gi(str);
        for (int i2 = 0; i2 < 4; i2++) {
            byte[] bArr = this.aMa;
            if (bArr[i2] < 65 || bArr[i2] > 122 || (bArr[i2] > 90 && bArr[i2] < 97)) {
                C10331c.printStackTrace(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            m24489Kk();
        }
    }

    /* renamed from: Kk */
    private void m24489Kk() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Kl */
    public final ByteArrayInputStream m24488Kl() {
        return new ByteArrayInputStream(this.data);
    }

    /* renamed from: Km */
    public final long m24487Km() {
        return this.aMb;
    }

    /* renamed from: aD */
    public final void m24486aD(long j) {
        this.aMb = j;
    }

    /* renamed from: bI */
    public final void m24485bI(boolean z) {
        int value = (int) this.aMd.getValue();
        int m24420g = C10936n.m24420g(this.aMc, 0);
        if (value != m24420g) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.ahi, Long.valueOf(this.aMb), Integer.valueOf(m24420g), Integer.valueOf(value));
            if (z) {
                C10331c.printStackTrace(new PngjException(format));
            } else {
                C10331c.m26254d("PNG_ENCRYPT", format);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C10901d.class == obj.getClass()) {
            C10901d c10901d = (C10901d) obj;
            String str = this.ahi;
            if (str == null) {
                if (c10901d.ahi != null) {
                    return false;
                }
            } else if (!str.equals(c10901d.ahi)) {
                return false;
            }
            return this.aMb == c10901d.aMb;
        }
        return false;
    }

    /* renamed from: f */
    public final void m24484f(byte[] bArr, int i, int i2) {
        if (this.aMd == null) {
            this.aMd = new CRC32();
        }
        this.aMd.update(bArr, i, i2);
    }

    public final int hashCode() {
        String str = this.ahi;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.aMb;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + C10899b.m24492i(this.aMa) + " len=" + this.len;
    }
}
