package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class e {
    final com.kwad.sdk.pngencrypt.k aKl;
    List<PngChunk> aMe = new ArrayList();
    boolean aMf = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.aKl = kVar;
    }

    private static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        if (str2 == null) {
            return b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
                @Override // com.kwad.sdk.pngencrypt.chunk.c
                public final boolean a(PngChunk pngChunk) {
                    return pngChunk.ahi.equals(str);
                }
            });
        }
        return b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                if (pngChunk.ahi.equals(str)) {
                    if (!(pngChunk instanceof t) || ((t) pngChunk).getKey().equals(str2)) {
                        return !(pngChunk instanceof n) || ((n) pngChunk).Kw().equals(str2);
                    }
                    return false;
                }
                return false;
            }
        });
    }

    public final List<PngChunk> Kn() {
        return this.aMe;
    }

    public final List<? extends PngChunk> am(String str, String str2) {
        return a(this.aMe, str, str2);
    }

    public String toString() {
        return "ChunkList: read: " + this.aMe.size();
    }

    public final void a(PngChunk pngChunk, int i4) {
        pngChunk.dO(i4);
        this.aMe.add(pngChunk);
        if (pngChunk.ahi.equals("PLTE")) {
            this.aMf = true;
        }
    }
}
