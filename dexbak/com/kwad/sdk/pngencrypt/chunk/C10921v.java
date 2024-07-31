package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.pngencrypt.C10931k;
import com.kwad.sdk.pngencrypt.PngjException;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.v */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10921v extends AbstractC10919t {
    public C10921v(C10931k c10931k) {
        super("zTXt", c10931k);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    /* renamed from: a */
    public final void mo24458a(C10901d c10901d) {
        byte[] bArr;
        int i = 0;
        while (true) {
            bArr = c10901d.data;
            if (i >= bArr.length) {
                i = -1;
                break;
            } else if (bArr[i] == 0) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0 || i > bArr.length - 2) {
            C10331c.printStackTrace(new PngjException("bad zTXt chunk: no separator found"));
        }
        this.key = C10899b.m24499d(c10901d.data, 0, i);
        if (c10901d.data[i + 1] != 0) {
            C10331c.printStackTrace(new PngjException("bad zTXt chunk: unknown compression method"));
        }
        byte[] bArr2 = c10901d.data;
        this.aMO = C10899b.m24492i(C10899b.m24500b(bArr2, i + 2, (bArr2.length - i) - 2, false));
    }
}
