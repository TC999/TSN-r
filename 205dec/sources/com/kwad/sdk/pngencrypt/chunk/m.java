package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class m extends p {
    private int aMA;
    private int[] aMB;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.aMA = 0;
    }

    private void dW(int i4) {
        this.aMA = i4;
        if (i4 > 0 && i4 <= 256) {
            int[] iArr = this.aMB;
            if (iArr == null || iArr.length != i4) {
                this.aMB = new int[i4];
                return;
            }
            return;
        }
        throw new PngjException("invalid pallette - nentries=" + this.aMA);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        dW(dVar.len / 3);
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.aMA) {
            byte[] bArr = dVar.data;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            a(i4, bArr[i5] & 255, bArr[i6] & 255, bArr[i7] & 255);
            i4++;
            i5 = i7 + 1;
        }
    }

    private void a(int i4, int i5, int i6, int i7) {
        this.aMB[i4] = (i5 << 16) | (i6 << 8) | i7;
    }
}
