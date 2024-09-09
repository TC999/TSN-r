package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f extends e {
    private final List<PngChunk> aMi;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + Kn().size() + " queue: " + this.aMi.size();
    }
}
