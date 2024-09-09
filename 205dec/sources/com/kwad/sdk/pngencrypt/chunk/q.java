package com.kwad.sdk.pngencrypt.chunk;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class q extends t {
    public q(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i4 = 0;
        while (true) {
            bArr = dVar.data;
            if (i4 >= bArr.length || bArr[i4] == 0) {
                break;
            }
            i4++;
        }
        this.key = b.d(bArr, 0, i4);
        int i5 = i4 + 1;
        byte[] bArr2 = dVar.data;
        this.aMO = i5 < bArr2.length ? b.d(bArr2, i5, bArr2.length - i5) : "";
    }
}
