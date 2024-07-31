package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.C10931k;
import com.kwad.sdk.pngencrypt.C10936n;
import com.kwad.sdk.pngencrypt.PngjException;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10913n extends AbstractC10910k {
    private String aMC;
    private int aMD;
    private int[] aME;

    public C10913n(C10931k c10931k) {
        super("sPLT", c10931k);
    }

    /* renamed from: Kw */
    public final String m24460Kw() {
        return this.aMC;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    /* renamed from: a */
    public final void mo24458a(C10901d c10901d) {
        byte[] bArr;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            bArr = c10901d.data;
            if (i7 >= bArr.length) {
                i7 = -1;
                break;
            } else if (bArr[i7] == 0) {
                break;
            } else {
                i7++;
            }
        }
        if (i7 > 0 && i7 <= bArr.length - 2) {
            this.aMC = C10899b.m24499d(bArr, 0, i7);
            int m24423e = C10936n.m24423e(c10901d.data, i7 + 1);
            this.aMD = m24423e;
            int i8 = i7 + 2;
            int length = (c10901d.data.length - i8) / (m24423e == 8 ? 6 : 10);
            this.aME = new int[length * 5];
            int i9 = i8;
            int i10 = 0;
            while (i6 < length) {
                if (this.aMD == 8) {
                    int i11 = i9 + 1;
                    i2 = C10936n.m24423e(c10901d.data, i9);
                    int i12 = i11 + 1;
                    i3 = C10936n.m24423e(c10901d.data, i11);
                    int i13 = i12 + 1;
                    i4 = C10936n.m24423e(c10901d.data, i12);
                    i = i13 + 1;
                    i5 = C10936n.m24423e(c10901d.data, i13);
                } else {
                    int m24421f = C10936n.m24421f(c10901d.data, i9);
                    int i14 = i9 + 2;
                    int m24421f2 = C10936n.m24421f(c10901d.data, i14);
                    int i15 = i14 + 2;
                    int m24421f3 = C10936n.m24421f(c10901d.data, i15);
                    int i16 = i15 + 2;
                    int m24421f4 = C10936n.m24421f(c10901d.data, i16);
                    i = i16 + 2;
                    i2 = m24421f;
                    i3 = m24421f2;
                    i4 = m24421f3;
                    i5 = m24421f4;
                }
                int m24421f5 = C10936n.m24421f(c10901d.data, i);
                int[] iArr = this.aME;
                int i17 = i10 + 1;
                iArr[i10] = i2;
                int i18 = i17 + 1;
                iArr[i17] = i3;
                int i19 = i18 + 1;
                iArr[i18] = i4;
                int i20 = i19 + 1;
                iArr[i19] = i5;
                iArr[i20] = m24421f5;
                i6++;
                i10 = i20 + 1;
                i9 = i + 2;
            }
            return;
        }
        throw new PngjException("bad sPLT chunk: no separator found");
    }
}
