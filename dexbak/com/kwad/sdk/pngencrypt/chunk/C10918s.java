package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.C10931k;
import com.kwad.sdk.pngencrypt.C10936n;
import kotlin.UByte;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.s */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10918s extends AbstractC10915p {
    private int aMJ;
    private int aMK;
    private int aML;
    private int aMM;
    private int[] aMN;

    public C10918s(C10931k c10931k) {
        super("tRNS", c10931k);
        this.aMN = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    /* renamed from: a */
    public final void mo24458a(C10901d c10901d) {
        C10931k c10931k = this.aLj;
        if (c10931k.aLq) {
            this.aMJ = C10936n.m24421f(c10901d.data, 0);
        } else if (c10931k.aLr) {
            int length = c10901d.data.length;
            this.aMN = new int[length];
            for (int i = 0; i < length; i++) {
                this.aMN[i] = c10901d.data[i] & UByte.f41242c;
            }
        } else {
            this.aMK = C10936n.m24421f(c10901d.data, 0);
            this.aML = C10936n.m24421f(c10901d.data, 2);
            this.aMM = C10936n.m24421f(c10901d.data, 4);
        }
    }
}
