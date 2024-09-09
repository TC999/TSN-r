package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class b implements f, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] aJY;
    private final int aJZ;
    private byte[] aKa;
    private int aKb;
    protected boolean aKc;
    protected boolean aKd;
    private int aKe;
    private long aKf;
    private DeflatedChunksSet aKg;
    private ChunkReader aKh;
    private long aKi;
    private ErrorBehaviour aKj;
    protected boolean closed;

    public b() {
        this(n.Kd());
    }

    private static String JE() {
        return "IHDR";
    }

    private static String JF() {
        return "IEND";
    }

    private ChunkReader a(String str, int i4, long j4, boolean z3) {
        return new ChunkReader(i4, str, j4, z3 ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void JA() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void a(int i5, byte[] bArr, int i6, int i7) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("should never happen"));
            }
        };
    }

    private static void h(byte[] bArr) {
        if (Arrays.equals(bArr, n.Kd())) {
            return;
        }
        com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad signature:" + Arrays.toString(bArr)));
    }

    protected boolean JB() {
        return true;
    }

    public final long JC() {
        return this.aKf;
    }

    public final DeflatedChunksSet JD() {
        return this.aKg;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int b(byte[] bArr, int i4, int i5) {
        if (this.closed) {
            return -1;
        }
        if (i5 == 0) {
            return 0;
        }
        if (i5 < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("This should not happen. Bad length: " + i5));
        }
        if (this.aKc) {
            ChunkReader chunkReader = this.aKh;
            if (chunkReader != null && !chunkReader.isDone()) {
                int b4 = this.aKh.b(bArr, i4, i5);
                if (b4 < 0) {
                    return -1;
                }
                int i6 = b4 + 0;
                this.aKf += b4;
                return i6;
            }
            int i7 = this.aKb;
            int i8 = 8 - i7;
            if (i8 <= i5) {
                i5 = i8;
            }
            System.arraycopy(bArr, i4, this.aKa, i7, i5);
            int i9 = this.aKb + i5;
            this.aKb = i9;
            int i10 = i5 + 0;
            this.aKf += i5;
            if (i9 == 8) {
                this.aKe++;
                c(n.g(this.aKa, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.aKa, 4), this.aKf - 8);
                this.aKb = 0;
                return i10;
            }
            return i10;
        }
        int i11 = this.aJZ;
        int i12 = this.aKb;
        int i13 = i11 - i12;
        if (i13 <= i5) {
            i5 = i13;
        }
        System.arraycopy(bArr, i4, this.aKa, i12, i5);
        int i14 = this.aKb + i5;
        this.aKb = i14;
        if (i14 == this.aJZ) {
            h(this.aKa);
            this.aKb = 0;
            this.aKc = true;
        }
        int i15 = i5 + 0;
        this.aKf += i5;
        return i15;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i4, String str, long j4) {
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.aLZ.matcher(str).matches()) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk id: " + str));
        }
        if (i4 < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk len: " + i4));
        }
        if (str.equals("IDAT")) {
            this.aKi += i4;
        }
        boolean JB = JB();
        boolean t3 = t(i4, str);
        boolean ge = ge(str);
        DeflatedChunksSet deflatedChunksSet = this.aKg;
        boolean gh = (deflatedChunksSet == null || deflatedChunksSet.isClosed()) ? false : this.aKg.gh(str);
        if (ge && !t3) {
            if (!gh) {
                DeflatedChunksSet deflatedChunksSet2 = this.aKg;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    com.kwad.sdk.core.e.c.printStackTrace(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.aKg = gd(str);
            }
            this.aKh = new d(i4, str, JB, j4, this.aKg) { // from class: com.kwad.sdk.pngencrypt.b.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                public final void JA() {
                    super.JA();
                    b.this.a(this);
                }
            };
        } else {
            this.aKh = a(str, i4, j4, t3);
        }
        ChunkReader chunkReader = this.aKh;
        if (chunkReader == null || JB) {
            return;
        }
        chunkReader.bG(false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.aKg;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    protected abstract DeflatedChunksSet gd(String str);

    protected boolean ge(String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aKd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(int i4, String str) {
        return false;
    }

    private b(byte[] bArr) {
        this.aKa = new byte[8];
        this.aKb = 0;
        this.aKc = false;
        this.aKd = false;
        this.closed = false;
        this.aKe = 0;
        this.aKf = 0L;
        this.aKj = ErrorBehaviour.STRICT;
        this.aJY = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.aJZ = length;
        this.aKc = length <= 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChunkReader chunkReader) {
        if (this.aKe == 1 && !JE().equals(chunkReader.Jz().ahi)) {
            String str = "Bad first chunk: " + chunkReader.Jz().ahi + " expected: " + JE();
            if (this.aKj.f38658c < ErrorBehaviour.SUPER_LENIENT.f38658c) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException(str));
            } else {
                com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", str);
            }
        }
        JF();
        if (chunkReader.Jz().ahi.equals(JF())) {
            this.aKd = true;
            close();
        }
    }
}
