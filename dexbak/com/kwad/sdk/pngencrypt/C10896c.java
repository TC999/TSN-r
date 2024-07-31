package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.C10898a;
import com.kwad.sdk.pngencrypt.chunk.C10899b;
import com.kwad.sdk.pngencrypt.chunk.C10902e;
import com.kwad.sdk.pngencrypt.chunk.C10908i;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.kwad.sdk.pngencrypt.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10896c extends AbstractC10893b {
    protected C10931k aKl;
    protected C10931k aKm;
    protected C10924e aKn;
    protected int aKo = -1;
    protected C10902e aKp = null;
    private long aKr = 0;
    private boolean aKs = true;
    private boolean aKt = false;
    private Set<String> aKu = new HashSet();
    private long aKv = 0;
    private long aKw = 0;
    private long aKx = 0;
    private ChunkLoadBehaviour aKz = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    protected final boolean aKq = false;
    private InterfaceC10926g aKy = new C10898a();

    /* renamed from: com.kwad.sdk.pngencrypt.c$1 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static /* synthetic */ class C108971 {
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

    public C10896c(boolean z) {
    }

    /* renamed from: JG */
    private int m24525JG() {
        return this.aKo;
    }

    /* renamed from: JL */
    private C10931k m24520JL() {
        return this.aKm;
    }

    /* renamed from: gf */
    private void m24511gf(String str) {
        if (str.equals("IHDR")) {
            if (this.aKo < 0) {
                this.aKo = 0;
                return;
            }
            C10331c.printStackTrace(new PngjException("unexpected chunk " + str));
        } else if (str.equals("PLTE")) {
            int i = this.aKo;
            if (i != 0 && i != 1) {
                C10331c.printStackTrace(new PngjException("unexpected chunk here " + str));
                return;
            }
            this.aKo = 2;
        } else if (str.equals("IDAT")) {
            int i2 = this.aKo;
            if (i2 >= 0 && i2 <= 4) {
                this.aKo = 4;
                return;
            }
            C10331c.printStackTrace(new PngjException("unexpected chunk " + str));
        } else if (str.equals("IEND")) {
            if (this.aKo >= 4) {
                this.aKo = 6;
                return;
            }
            C10331c.printStackTrace(new PngjException("unexpected chunk " + str));
        } else {
            int i3 = this.aKo;
            if (i3 <= 1) {
                this.aKo = 1;
            } else if (i3 <= 3) {
                this.aKo = 3;
            } else {
                this.aKo = 5;
            }
        }
    }

    /* renamed from: gg */
    private static boolean m24510gg(String str) {
        return !C10899b.m24496gj(str);
    }

    @Override // com.kwad.sdk.pngencrypt.AbstractC10893b
    /* renamed from: JB */
    protected final boolean mo24526JB() {
        return this.aKs;
    }

    /* renamed from: JH */
    public final boolean m24524JH() {
        return m24525JG() < 4;
    }

    /* renamed from: JI */
    public final C10929j m24523JI() {
        DeflatedChunksSet m24531JD = m24531JD();
        if (m24531JD instanceof C10929j) {
            return (C10929j) m24531JD;
        }
        return null;
    }

    /* renamed from: JJ */
    public final C10931k m24522JJ() {
        return this.aKl;
    }

    /* renamed from: JK */
    public final C10924e m24521JK() {
        return this.aKn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.AbstractC10893b
    /* renamed from: a */
    public final void mo24519a(ChunkReader chunkReader) {
        super.mo24519a(chunkReader);
        if (chunkReader.m24546Jz().ahi.equals("IHDR")) {
            C10908i c10908i = new C10908i(null);
            c10908i.mo24458a(chunkReader.m24546Jz());
            C10931k m24471Ku = c10908i.m24471Ku();
            this.aKl = m24471Ku;
            this.aKm = m24471Ku;
            if (c10908i.m24473Ks()) {
                this.aKn = new C10924e(this.aKm);
            }
            this.aKp = new C10902e(this.aKl);
        }
        ChunkReader.ChunkReaderMode chunkReaderMode = chunkReader.aJS;
        ChunkReader.ChunkReaderMode chunkReaderMode2 = ChunkReader.ChunkReaderMode.BUFFER;
        if (chunkReaderMode == chunkReaderMode2 && m24510gg(chunkReader.m24546Jz().ahi)) {
            this.aKr += chunkReader.m24546Jz().len;
        }
        if (chunkReader.aJS == chunkReaderMode2 || this.aKt) {
            try {
                this.aKp.m24482a(this.aKy.mo24440a(chunkReader.m24546Jz(), m24522JJ()), this.aKo);
            } catch (PngjException e) {
                throw e;
            }
        }
    }

    /* renamed from: aA */
    public final void m24518aA(long j) {
        this.aKv = j;
    }

    /* renamed from: aB */
    public final void m24517aB(long j) {
        this.aKw = j;
    }

    /* renamed from: aC */
    public final void m24516aC(long j) {
        this.aKx = j;
    }

    @Override // com.kwad.sdk.pngencrypt.AbstractC10893b, com.kwad.sdk.pngencrypt.InterfaceC10925f
    /* renamed from: b */
    public final int mo24441b(byte[] bArr, int i, int i2) {
        return super.mo24441b(bArr, i, i2);
    }

    /* renamed from: bH */
    public final void m24515bH(boolean z) {
        this.aKs = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.AbstractC10893b
    /* renamed from: c */
    public final void mo24514c(int i, String str, long j) {
        m24511gf(str);
        super.mo24514c(i, str, j);
    }

    @Override // com.kwad.sdk.pngencrypt.AbstractC10893b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.aKo != 6) {
            this.aKo = 6;
        }
        super.close();
    }

    @Override // com.kwad.sdk.pngencrypt.AbstractC10893b
    /* renamed from: gd */
    protected final DeflatedChunksSet mo24513gd(String str) {
        return new C10929j(str, this.aKq, m24520JL(), this.aKn);
    }

    @Override // com.kwad.sdk.pngencrypt.AbstractC10893b
    /* renamed from: ge */
    protected final boolean mo24512ge(String str) {
        return str.equals("IDAT");
    }

    @Override // com.kwad.sdk.pngencrypt.AbstractC10893b
    /* renamed from: t */
    public final boolean mo24509t(int i, String str) {
        if (super.mo24509t(i, str)) {
            return true;
        }
        if (this.aKv > 0 && i + m24532JC() > this.aKv) {
            C10331c.printStackTrace(new PngjException("Maximum total bytes to read exceeeded: " + this.aKv + " offset:" + m24532JC() + " len=" + i));
        }
        if (this.aKu.contains(str)) {
            return true;
        }
        if (C10899b.m24496gj(str)) {
            return false;
        }
        long j = this.aKw;
        if (j <= 0 || i <= j) {
            long j2 = this.aKx;
            if (j2 <= 0 || i <= j2 - this.aKr) {
                int i2 = C108971.aKA[this.aKz.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        return true;
                    }
                } else if (!C10899b.m24494gl(str)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return true;
    }
}
