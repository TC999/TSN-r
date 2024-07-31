package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.C10931k;
import com.kwad.sdk.pngencrypt.PngjException;
import kotlin.UByte;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10912m extends AbstractC10915p {
    private int aMA;
    private int[] aMB;

    public C10912m(C10931k c10931k) {
        super("PLTE", c10931k);
        this.aMA = 0;
    }

    /* renamed from: dW */
    private void m24461dW(int i) {
        this.aMA = i;
        if (i > 0 && i <= 256) {
            int[] iArr = this.aMB;
            if (iArr == null || iArr.length != i) {
                this.aMB = new int[i];
                return;
            }
            return;
        }
        throw new PngjException("invalid pallette - nentries=" + this.aMA);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    /* renamed from: a */
    public final void mo24458a(C10901d c10901d) {
        m24461dW(c10901d.len / 3);
        int i = 0;
        int i2 = 0;
        while (i < this.aMA) {
            byte[] bArr = c10901d.data;
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            m24462a(i, bArr[i2] & UByte.f41242c, bArr[i3] & UByte.f41242c, bArr[i4] & UByte.f41242c);
            i++;
            i2 = i4 + 1;
        }
    }

    /* renamed from: a */
    private void m24462a(int i, int i2, int i3, int i4) {
        this.aMB[i] = (i2 << 16) | (i3 << 8) | i4;
    }
}
