package com.kwad.sdk.pngencrypt;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode aJS;
    private final com.kwad.sdk.pngencrypt.chunk.d aJT;
    private boolean aJW;
    protected int aJU = 0;
    private int aJV = 0;
    protected ErrorBehaviour aJX = ErrorBehaviour.STRICT;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i4, String str, long j4, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i4 < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.aJS = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i4, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.aJT = dVar;
        dVar.aD(j4);
        this.aJW = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    protected abstract void JA();

    public final com.kwad.sdk.pngencrypt.chunk.d Jz() {
        return this.aJT;
    }

    protected abstract void a(int i4, byte[] bArr, int i5, int i6);

    @Override // com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i4, int i5) {
        int i6 = 0;
        if (i5 == 0) {
            return 0;
        }
        if (i5 < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("negative length??"));
        }
        if (this.aJU == 0 && this.aJV == 0 && this.aJW) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.aJT;
            dVar.f(dVar.aMa, 0, 4);
        }
        com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.aJT;
        int i7 = dVar2.len - this.aJU;
        if (i7 > i5) {
            i7 = i5;
        }
        if (i7 > 0 || this.aJV == 0) {
            if (this.aJW && this.aJS != ChunkReaderMode.BUFFER && i7 > 0) {
                dVar2.f(bArr, i4, i7);
            }
            ChunkReaderMode chunkReaderMode = this.aJS;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.aJT.data;
                if (bArr2 != bArr && i7 > 0) {
                    System.arraycopy(bArr, i4, bArr2, this.aJU, i7);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.aJU, bArr, i4, i7);
            }
            this.aJU += i7;
            i4 += i7;
            i5 -= i7;
        }
        int i8 = this.aJU;
        com.kwad.sdk.pngencrypt.chunk.d dVar3 = this.aJT;
        if (i8 == dVar3.len) {
            int i9 = this.aJV;
            int i10 = 4 - i9;
            if (i10 <= i5) {
                i5 = i10;
            }
            if (i5 > 0) {
                byte[] bArr3 = dVar3.aMc;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i4, bArr3, i9, i5);
                }
                int i11 = this.aJV + i5;
                this.aJV = i11;
                if (i11 == 4) {
                    if (this.aJW) {
                        if (this.aJS == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar4 = this.aJT;
                            dVar4.f(dVar4.data, 0, dVar4.len);
                        }
                        this.aJT.bI(this.aJX == ErrorBehaviour.STRICT);
                    }
                    JA();
                }
            }
            i6 = i5;
        }
        if (i7 > 0 || i6 > 0) {
            return i7 + i6;
        }
        return -1;
    }

    public final void bG(boolean z3) {
        this.aJW = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChunkReader chunkReader = (ChunkReader) obj;
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.aJT;
            if (dVar == null) {
                if (chunkReader.aJT != null) {
                    return false;
                }
            } else if (!dVar.equals(chunkReader.aJT)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aJT;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aJV == 4;
    }

    public String toString() {
        return this.aJT.toString();
    }
}
