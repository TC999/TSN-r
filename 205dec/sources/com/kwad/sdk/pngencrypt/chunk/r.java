package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class r extends p {
    private int aMG;
    private int aMH;
    private int aMI;
    private int hour;
    private int min;
    private int year;

    public r(com.kwad.sdk.pngencrypt.k kVar) {
        super("tIME", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len == 7) {
            this.year = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            this.aMG = com.kwad.sdk.pngencrypt.n.e(dVar.data, 2);
            this.aMH = com.kwad.sdk.pngencrypt.n.e(dVar.data, 3);
            this.hour = com.kwad.sdk.pngencrypt.n.e(dVar.data, 4);
            this.min = com.kwad.sdk.pngencrypt.n.e(dVar.data, 5);
            this.aMI = com.kwad.sdk.pngencrypt.n.e(dVar.data, 6);
            return;
        }
        throw new PngjException("bad chunk " + dVar);
    }
}
