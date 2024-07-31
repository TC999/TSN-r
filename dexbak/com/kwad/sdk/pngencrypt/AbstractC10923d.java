package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.pngencrypt.ChunkReader;

/* renamed from: com.kwad.sdk.pngencrypt.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10923d extends ChunkReader {
    protected final DeflatedChunksSet aKB;
    protected boolean aKC;
    protected boolean aKD;
    protected byte[] aKE;
    protected int aKF;

    public AbstractC10923d(int i, String str, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.aKC = false;
        this.aKD = false;
        this.aKF = -1;
        this.aKB = deflatedChunksSet;
        deflatedChunksSet.m24541a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    /* renamed from: JA */
    public void mo24455JA() {
        int m24420g;
        if (!this.aKD || this.aKF < 0 || (m24420g = C10936n.m24420g(this.aKE, 0)) == this.aKF) {
            return;
        }
        C10331c.printStackTrace(new PngjException("bad chunk sequence for fDAT chunk " + m24420g + " expected " + this.aKF));
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    /* renamed from: a */
    protected final void mo24454a(int i, byte[] bArr, int i2, int i3) {
        if (this.aKD && i < 4) {
            while (i < 4 && i3 > 0) {
                this.aKE[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.aKB.m24540c(bArr, i2, i3);
            if (this.aKC) {
                System.arraycopy(bArr, i2, m24546Jz().data, this.aJU, i3);
            }
        }
    }

    /* renamed from: dD */
    public final void m24453dD(int i) {
        this.aKF = i;
    }
}
