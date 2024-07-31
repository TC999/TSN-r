package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.pngencrypt.chunk.C10901d;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class ChunkReader implements InterfaceC10925f {
    public final ChunkReaderMode aJS;
    private final C10901d aJT;
    private boolean aJW;
    protected int aJU = 0;
    private int aJV = 0;
    protected ErrorBehaviour aJX = ErrorBehaviour.STRICT;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            C10331c.printStackTrace(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.aJS = chunkReaderMode;
        C10901d c10901d = new C10901d(i, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.aJT = c10901d;
        c10901d.m24486aD(j);
        this.aJW = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    /* renamed from: JA */
    protected abstract void mo24455JA();

    /* renamed from: Jz */
    public final C10901d m24546Jz() {
        return this.aJT;
    }

    /* renamed from: a */
    protected abstract void mo24454a(int i, byte[] bArr, int i2, int i3);

    @Override // com.kwad.sdk.pngencrypt.InterfaceC10925f
    /* renamed from: b */
    public final int mo24441b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            C10331c.printStackTrace(new PngjException("negative length??"));
        }
        if (this.aJU == 0 && this.aJV == 0 && this.aJW) {
            C10901d c10901d = this.aJT;
            c10901d.m24484f(c10901d.aMa, 0, 4);
        }
        C10901d c10901d2 = this.aJT;
        int i4 = c10901d2.len - this.aJU;
        if (i4 > i2) {
            i4 = i2;
        }
        if (i4 > 0 || this.aJV == 0) {
            if (this.aJW && this.aJS != ChunkReaderMode.BUFFER && i4 > 0) {
                c10901d2.m24484f(bArr, i, i4);
            }
            ChunkReaderMode chunkReaderMode = this.aJS;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.aJT.data;
                if (bArr2 != bArr && i4 > 0) {
                    System.arraycopy(bArr, i, bArr2, this.aJU, i4);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                mo24454a(this.aJU, bArr, i, i4);
            }
            this.aJU += i4;
            i += i4;
            i2 -= i4;
        }
        int i5 = this.aJU;
        C10901d c10901d3 = this.aJT;
        if (i5 == c10901d3.len) {
            int i6 = this.aJV;
            int i7 = 4 - i6;
            if (i7 <= i2) {
                i2 = i7;
            }
            if (i2 > 0) {
                byte[] bArr3 = c10901d3.aMc;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i, bArr3, i6, i2);
                }
                int i8 = this.aJV + i2;
                this.aJV = i8;
                if (i8 == 4) {
                    if (this.aJW) {
                        if (this.aJS == ChunkReaderMode.BUFFER) {
                            C10901d c10901d4 = this.aJT;
                            c10901d4.m24484f(c10901d4.data, 0, c10901d4.len);
                        }
                        this.aJT.m24485bI(this.aJX == ErrorBehaviour.STRICT);
                    }
                    mo24455JA();
                }
            }
            i3 = i2;
        }
        if (i4 > 0 || i3 > 0) {
            return i4 + i3;
        }
        return -1;
    }

    /* renamed from: bG */
    public final void m24545bG(boolean z) {
        this.aJW = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChunkReader chunkReader = (ChunkReader) obj;
            C10901d c10901d = this.aJT;
            if (c10901d == null) {
                if (chunkReader.aJT != null) {
                    return false;
                }
            } else if (!c10901d.equals(chunkReader.aJT)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        C10901d c10901d = this.aJT;
        return (c10901d == null ? 0 : c10901d.hashCode()) + 31;
    }

    @Override // com.kwad.sdk.pngencrypt.InterfaceC10925f
    public final boolean isDone() {
        return this.aJV == 4;
    }

    public String toString() {
        return this.aJT.toString();
    }
}
