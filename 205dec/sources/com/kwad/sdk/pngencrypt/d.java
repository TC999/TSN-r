package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class d extends ChunkReader {
    protected final DeflatedChunksSet aKB;
    protected boolean aKC;
    protected boolean aKD;
    protected byte[] aKE;
    protected int aKF;

    public d(int i4, String str, long j4, DeflatedChunksSet deflatedChunksSet) {
        super(i4, str, j4, ChunkReader.ChunkReaderMode.PROCESS);
        this.aKC = false;
        this.aKD = false;
        this.aKF = -1;
        this.aKB = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void JA() {
        int g4;
        if (!this.aKD || this.aKF < 0 || (g4 = n.g(this.aKE, 0)) == this.aKF) {
            return;
        }
        com.kwad.sdk.core.e.c.printStackTrace(new PngjException("bad chunk sequence for fDAT chunk " + g4 + " expected " + this.aKF));
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    protected final void a(int i4, byte[] bArr, int i5, int i6) {
        if (this.aKD && i4 < 4) {
            while (i4 < 4 && i6 > 0) {
                this.aKE[i4] = bArr[i5];
                i4++;
                i5++;
                i6--;
            }
        }
        if (i6 > 0) {
            this.aKB.c(bArr, i5, i6);
            if (this.aKC) {
                System.arraycopy(bArr, i5, Jz().data, this.aJU, i6);
            }
        }
    }

    public final void dD(int i4) {
        this.aKF = i4;
    }
}
