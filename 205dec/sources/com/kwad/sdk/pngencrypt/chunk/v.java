package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class v extends t {
    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i4 = 0;
        while (true) {
            bArr = dVar.data;
            if (i4 >= bArr.length) {
                i4 = -1;
                break;
            } else if (bArr[i4] == 0) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 < 0 || i4 > bArr.length - 2) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("bad zTXt chunk: no separator found"));
        }
        this.key = b.d(dVar.data, 0, i4);
        if (dVar.data[i4 + 1] != 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("bad zTXt chunk: unknown compression method"));
        }
        byte[] bArr2 = dVar.data;
        this.aMO = b.i(b.b(bArr2, i4 + 2, (bArr2.length - i4) - 2, false));
    }
}
