package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.pngencrypt.C10931k;
import com.kwad.sdk.pngencrypt.PngjException;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10909j extends AbstractC10919t {
    private boolean aMu;
    private String aMv;
    private String aMw;

    public C10909j(C10931k c10931k) {
        super("iTXt", c10931k);
        this.aMu = false;
        this.aMv = "";
        this.aMw = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    /* renamed from: a */
    public final void mo24458a(C10901d c10901d) {
        int[] iArr = new int[3];
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = c10901d.data;
            if (i >= bArr.length) {
                break;
            }
            if (bArr[i] == 0) {
                iArr[i2] = i;
                i2++;
                if (i2 == 1) {
                    i += 2;
                }
                if (i2 == 3) {
                    break;
                }
            }
            i++;
        }
        if (i2 != 3) {
            C10331c.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk"));
        }
        this.key = C10899b.m24499d(c10901d.data, 0, iArr[0]);
        int i3 = iArr[0] + 1;
        byte[] bArr2 = c10901d.data;
        boolean z = bArr2[i3] != 0;
        this.aMu = z;
        int i4 = i3 + 1;
        if (z && bArr2[i4] != 0) {
            C10331c.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk - bad compression method "));
        }
        this.aMv = C10899b.m24499d(c10901d.data, i4, iArr[1] - i4);
        this.aMw = C10899b.m24498e(c10901d.data, iArr[1] + 1, (iArr[2] - iArr[1]) - 1);
        int i5 = iArr[2] + 1;
        if (this.aMu) {
            byte[] bArr3 = c10901d.data;
            this.aMO = C10899b.m24490j(C10899b.m24500b(bArr3, i5, bArr3.length - i5, false));
            return;
        }
        byte[] bArr4 = c10901d.data;
        this.aMO = C10899b.m24498e(bArr4, i5, bArr4.length - i5);
    }
}
