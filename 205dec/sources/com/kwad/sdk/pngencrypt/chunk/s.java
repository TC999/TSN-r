package com.kwad.sdk.pngencrypt.chunk;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class s extends p {
    private int aMJ;
    private int aMK;
    private int aML;
    private int aMM;
    private int[] aMN;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.aMN = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.aLj;
        if (kVar.aLq) {
            this.aMJ = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
        } else if (kVar.aLr) {
            int length = dVar.data.length;
            this.aMN = new int[length];
            for (int i4 = 0; i4 < length; i4++) {
                this.aMN[i4] = dVar.data[i4] & 255;
            }
        } else {
            this.aMK = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            this.aML = com.kwad.sdk.pngencrypt.n.f(dVar.data, 2);
            this.aMM = com.kwad.sdk.pngencrypt.n.f(dVar.data, 4);
        }
    }
}
