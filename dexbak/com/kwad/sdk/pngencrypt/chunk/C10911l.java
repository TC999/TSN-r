package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.C10931k;
import com.kwad.sdk.pngencrypt.C10936n;
import com.kwad.sdk.pngencrypt.PngjException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10911l extends AbstractC10915p {
    private long aMx;
    private long aMy;
    private int aMz;

    public C10911l(C10931k c10931k) {
        super("oFFs", c10931k);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    /* renamed from: a */
    public final void mo24458a(C10901d c10901d) {
        if (c10901d.len == 9) {
            long m24420g = C10936n.m24420g(c10901d.data, 0);
            this.aMx = m24420g;
            if (m24420g < 0) {
                this.aMx = m24420g + IjkMediaMeta.AV_CH_WIDE_RIGHT;
            }
            long m24420g2 = C10936n.m24420g(c10901d.data, 4);
            this.aMy = m24420g2;
            if (m24420g2 < 0) {
                this.aMy = m24420g2 + IjkMediaMeta.AV_CH_WIDE_RIGHT;
            }
            this.aMz = C10936n.m24423e(c10901d.data, 8);
            return;
        }
        throw new PngjException("bad chunk length " + c10901d);
    }
}
