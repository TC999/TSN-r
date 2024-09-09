package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class l extends p {
    private long aMx;
    private long aMy;
    private int aMz;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len == 9) {
            long g4 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
            this.aMx = g4;
            if (g4 < 0) {
                this.aMx = g4 + 4294967296L;
            }
            long g5 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
            this.aMy = g5;
            if (g5 < 0) {
                this.aMy = g5 + 4294967296L;
            }
            this.aMz = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
            return;
        }
        throw new PngjException("bad chunk length " + dVar);
    }
}
