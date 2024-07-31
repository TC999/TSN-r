package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.C10931k;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10916q extends AbstractC10919t {
    public C10916q(C10931k c10931k) {
        super("tEXt", c10931k);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    /* renamed from: a */
    public final void mo24458a(C10901d c10901d) {
        byte[] bArr;
        int i = 0;
        while (true) {
            bArr = c10901d.data;
            if (i >= bArr.length || bArr[i] == 0) {
                break;
            }
            i++;
        }
        this.key = C10899b.m24499d(bArr, 0, i);
        int i2 = i + 1;
        byte[] bArr2 = c10901d.data;
        this.aMO = i2 < bArr2.length ? C10899b.m24499d(bArr2, i2, bArr2.length - i2) : "";
    }
}
