package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.C10931k;
import com.kwad.sdk.pngencrypt.PngjException;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10914o extends AbstractC10915p {
    private byte aMF;

    public C10914o(C10931k c10931k) {
        super("sTER", c10931k);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    /* renamed from: a */
    public final void mo24458a(C10901d c10901d) {
        if (c10901d.len == 1) {
            this.aMF = c10901d.data[0];
            return;
        }
        throw new PngjException("bad chunk length " + c10901d);
    }
}
