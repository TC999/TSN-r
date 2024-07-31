package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.C10931k;
import com.kwad.sdk.pngencrypt.C10936n;
import com.kwad.sdk.pngencrypt.PngjException;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.r */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10917r extends AbstractC10915p {
    private int aMG;
    private int aMH;
    private int aMI;
    private int hour;
    private int min;
    private int year;

    public C10917r(C10931k c10931k) {
        super("tIME", c10931k);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    /* renamed from: a */
    public final void mo24458a(C10901d c10901d) {
        if (c10901d.len == 7) {
            this.year = C10936n.m24421f(c10901d.data, 0);
            this.aMG = C10936n.m24423e(c10901d.data, 2);
            this.aMH = C10936n.m24423e(c10901d.data, 3);
            this.hour = C10936n.m24423e(c10901d.data, 4);
            this.min = C10936n.m24423e(c10901d.data, 5);
            this.aMI = C10936n.m24423e(c10901d.data, 6);
            return;
        }
        throw new PngjException("bad chunk " + c10901d);
    }
}
