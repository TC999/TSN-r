package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c extends b {
    protected k aKl;
    protected k aKm;
    protected e aKn;
    protected int aKo = -1;
    protected com.kwad.sdk.pngencrypt.chunk.e aKp = null;
    private long aKr = 0;
    private boolean aKs = true;
    private boolean aKt = false;
    private Set<String> aKu = new HashSet();
    private long aKv = 0;
    private long aKw = 0;
    private long aKx = 0;
    private ChunkLoadBehaviour aKz = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    protected final boolean aKq = false;
    private g aKy = new com.kwad.sdk.pngencrypt.chunk.a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: com.kwad.sdk.pngencrypt.c$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aKA;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            aKA = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aKA[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z3) {
    }

    private int JG() {
        return this.aKo;
    }

    private k JL() {
        return this.aKm;
    }

    private void gf(String str) {
        if (str.equals("IHDR")) {
            if (this.aKo < 0) {
                this.aKo = 0;
                return;
            }
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk " + str));
        } else if (str.equals("PLTE")) {
            int i4 = this.aKo;
            if (i4 != 0 && i4 != 1) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk here " + str));
                return;
            }
            this.aKo = 2;
        } else if (str.equals("IDAT")) {
            int i5 = this.aKo;
            if (i5 >= 0 && i5 <= 4) {
                this.aKo = 4;
                return;
            }
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk " + str));
        } else if (str.equals("IEND")) {
            if (this.aKo >= 4) {
                this.aKo = 6;
                return;
            }
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk " + str));
        } else {
            int i6 = this.aKo;
            if (i6 <= 1) {
                this.aKo = 1;
            } else if (i6 <= 3) {
                this.aKo = 3;
            } else {
                this.aKo = 5;
            }
        }
    }

    private static boolean gg(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.gj(str);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean JB() {
        return this.aKs;
    }

    public final boolean JH() {
        return JG() < 4;
    }

    public final j JI() {
        DeflatedChunksSet JD = JD();
        if (JD instanceof j) {
            return (j) JD;
        }
        return null;
    }

    public final k JJ() {
        return this.aKl;
    }

    public final e JK() {
        return this.aKn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.b
    public final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.Jz().ahi.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.Jz());
            k Ku = iVar.Ku();
            this.aKl = Ku;
            this.aKm = Ku;
            if (iVar.Ks()) {
                this.aKn = new e(this.aKm);
            }
            this.aKp = new com.kwad.sdk.pngencrypt.chunk.e(this.aKl);
        }
        ChunkReader.ChunkReaderMode chunkReaderMode = chunkReader.aJS;
        ChunkReader.ChunkReaderMode chunkReaderMode2 = ChunkReader.ChunkReaderMode.BUFFER;
        if (chunkReaderMode == chunkReaderMode2 && gg(chunkReader.Jz().ahi)) {
            this.aKr += chunkReader.Jz().len;
        }
        if (chunkReader.aJS == chunkReaderMode2 || this.aKt) {
            try {
                this.aKp.a(this.aKy.a(chunkReader.Jz(), JJ()), this.aKo);
            } catch (PngjException e4) {
                throw e4;
            }
        }
    }

    public final void aA(long j4) {
        this.aKv = j4;
    }

    public final void aB(long j4) {
        this.aKw = j4;
    }

    public final void aC(long j4) {
        this.aKx = j4;
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i4, int i5) {
        return super.b(bArr, i4, i5);
    }

    public final void bH(boolean z3) {
        this.aKs = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.b
    public final void c(int i4, String str, long j4) {
        gf(str);
        super.c(i4, str, j4);
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.aKo != 6) {
            this.aKo = 6;
        }
        super.close();
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final DeflatedChunksSet gd(String str) {
        return new j(str, this.aKq, JL(), this.aKn);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean ge(String str) {
        return str.equals("IDAT");
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean t(int i4, String str) {
        if (super.t(i4, str)) {
            return true;
        }
        if (this.aKv > 0 && i4 + JC() > this.aKv) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Maximum total bytes to read exceeeded: " + this.aKv + " offset:" + JC() + " len=" + i4));
        }
        if (this.aKu.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.gj(str)) {
            return false;
        }
        long j4 = this.aKw;
        if (j4 <= 0 || i4 <= j4) {
            long j5 = this.aKx;
            if (j5 <= 0 || i4 <= j5 - this.aKr) {
                int i5 = AnonymousClass1.aKA[this.aKz.ordinal()];
                if (i5 != 1) {
                    if (i5 == 2) {
                        return true;
                    }
                } else if (!com.kwad.sdk.pngencrypt.chunk.b.gl(str)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return true;
    }
}
