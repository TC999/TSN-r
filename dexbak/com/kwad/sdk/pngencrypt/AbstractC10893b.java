package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.C10899b;
import java.io.Closeable;
import java.util.Arrays;

/* renamed from: com.kwad.sdk.pngencrypt.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10893b implements InterfaceC10925f, Closeable {
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

    public AbstractC10893b() {
        this(C10936n.m24426Kd());
    }

    /* renamed from: JE */
    private static String m24530JE() {
        return "IHDR";
    }

    /* renamed from: JF */
    private static String m24529JF() {
        return "IEND";
    }

    /* renamed from: a */
    private ChunkReader m24528a(String str, int i, long j, boolean z) {
        return new ChunkReader(i, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            /* renamed from: JA */
            protected final void mo24455JA() {
                AbstractC10893b.this.mo24519a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            /* renamed from: a */
            protected final void mo24454a(int i2, byte[] bArr, int i3, int i4) {
                C10331c.printStackTrace(new PngjException("should never happen"));
            }
        };
    }

    /* renamed from: h */
    private static void m24527h(byte[] bArr) {
        if (Arrays.equals(bArr, C10936n.m24426Kd())) {
            return;
        }
        C10331c.printStackTrace(new PngjException("Bad signature:" + Arrays.toString(bArr)));
    }

    /* renamed from: JB */
    protected boolean mo24526JB() {
        return true;
    }

    /* renamed from: JC */
    public final long m24532JC() {
        return this.aKf;
    }

    /* renamed from: JD */
    public final DeflatedChunksSet m24531JD() {
        return this.aKg;
    }

    @Override // com.kwad.sdk.pngencrypt.InterfaceC10925f
    /* renamed from: b */
    public int mo24441b(byte[] bArr, int i, int i2) {
        if (this.closed) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            C10331c.printStackTrace(new PngjException("This should not happen. Bad length: " + i2));
        }
        if (this.aKc) {
            ChunkReader chunkReader = this.aKh;
            if (chunkReader != null && !chunkReader.isDone()) {
                int mo24441b = this.aKh.mo24441b(bArr, i, i2);
                if (mo24441b < 0) {
                    return -1;
                }
                int i3 = mo24441b + 0;
                this.aKf += mo24441b;
                return i3;
            }
            int i4 = this.aKb;
            int i5 = 8 - i4;
            if (i5 <= i2) {
                i2 = i5;
            }
            System.arraycopy(bArr, i, this.aKa, i4, i2);
            int i6 = this.aKb + i2;
            this.aKb = i6;
            int i7 = i2 + 0;
            this.aKf += i2;
            if (i6 == 8) {
                this.aKe++;
                mo24514c(C10936n.m24420g(this.aKa, 0), C10899b.m24491i(this.aKa, 4), this.aKf - 8);
                this.aKb = 0;
                return i7;
            }
            return i7;
        }
        int i8 = this.aJZ;
        int i9 = this.aKb;
        int i10 = i8 - i9;
        if (i10 <= i2) {
            i2 = i10;
        }
        System.arraycopy(bArr, i, this.aKa, i9, i2);
        int i11 = this.aKb + i2;
        this.aKb = i11;
        if (i11 == this.aJZ) {
            m24527h(this.aKa);
            this.aKb = 0;
            this.aKc = true;
        }
        int i12 = i2 + 0;
        this.aKf += i2;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void mo24514c(int i, String str, long j) {
        if (str.length() != 4 || !C10899b.aLZ.matcher(str).matches()) {
            C10331c.printStackTrace(new PngjException("Bad chunk id: " + str));
        }
        if (i < 0) {
            C10331c.printStackTrace(new PngjException("Bad chunk len: " + i));
        }
        if (str.equals("IDAT")) {
            this.aKi += i;
        }
        boolean mo24526JB = mo24526JB();
        boolean mo24509t = mo24509t(i, str);
        boolean mo24512ge = mo24512ge(str);
        DeflatedChunksSet deflatedChunksSet = this.aKg;
        boolean m24538gh = (deflatedChunksSet == null || deflatedChunksSet.isClosed()) ? false : this.aKg.m24538gh(str);
        if (mo24512ge && !mo24509t) {
            if (!m24538gh) {
                DeflatedChunksSet deflatedChunksSet2 = this.aKg;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    C10331c.printStackTrace(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.aKg = mo24513gd(str);
            }
            this.aKh = new AbstractC10923d(i, str, mo24526JB, j, this.aKg) { // from class: com.kwad.sdk.pngencrypt.b.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.kwad.sdk.pngencrypt.AbstractC10923d, com.kwad.sdk.pngencrypt.ChunkReader
                /* renamed from: JA */
                public final void mo24455JA() {
                    super.mo24455JA();
                    AbstractC10893b.this.mo24519a(this);
                }
            };
        } else {
            this.aKh = m24528a(str, i, j, mo24509t);
        }
        ChunkReader chunkReader = this.aKh;
        if (chunkReader == null || mo24526JB) {
            return;
        }
        chunkReader.m24545bG(false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.aKg;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    /* renamed from: gd */
    protected abstract DeflatedChunksSet mo24513gd(String str);

    /* renamed from: ge */
    protected boolean mo24512ge(String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.InterfaceC10925f
    public final boolean isDone() {
        return this.aKd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t */
    public boolean mo24509t(int i, String str) {
        return false;
    }

    private AbstractC10893b(byte[] bArr) {
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
    /* renamed from: a */
    public void mo24519a(ChunkReader chunkReader) {
        if (this.aKe == 1 && !m24530JE().equals(chunkReader.m24546Jz().ahi)) {
            String str = "Bad first chunk: " + chunkReader.m24546Jz().ahi + " expected: " + m24530JE();
            if (this.aKj.f29668c < ErrorBehaviour.SUPER_LENIENT.f29668c) {
                C10331c.printStackTrace(new PngjException(str));
            } else {
                C10331c.m26254d("PNG_ENCRYPT", str);
            }
        }
        m24529JF();
        if (chunkReader.m24546Jz().ahi.equals(m24529JF())) {
            this.aKd = true;
            close();
        }
    }
}
