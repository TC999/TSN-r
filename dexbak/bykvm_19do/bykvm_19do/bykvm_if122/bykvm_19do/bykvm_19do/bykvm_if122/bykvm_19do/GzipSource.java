package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.j */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class GzipSource implements Source {

    /* renamed from: b */
    private final BufferedSource f815b;

    /* renamed from: c */
    private final Inflater f816c;

    /* renamed from: d */
    private final InflaterSource f817d;

    /* renamed from: a */
    private int f814a = 0;

    /* renamed from: e */
    private final CRC32 f818e = new CRC32();

    public GzipSource(Source source) {
        if (source != null) {
            Inflater inflater = new Inflater(true);
            this.f816c = inflater;
            BufferedSource m58926a = Okio.m58926a(source);
            this.f815b = m58926a;
            this.f817d = new InflaterSource(m58926a, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    private void m58930b() throws IOException {
        m58931a("CRC", this.f815b.mo58902w(), (int) this.f818e.getValue());
        m58931a("ISIZE", this.f815b.mo58902w(), (int) this.f816c.getBytesWritten());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
    /* renamed from: a */
    public long mo58558a(Buffer buffer, long j) throws IOException {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (i == 0) {
            return 0L;
        } else {
            if (this.f814a == 0) {
                m58933a();
                this.f814a = 1;
            }
            if (this.f814a == 1) {
                long j2 = buffer.f805b;
                long mo58558a = this.f817d.mo58558a(buffer, j);
                if (mo58558a != -1) {
                    m58932a(buffer, j2, mo58558a);
                    return mo58558a;
                }
                this.f814a = 2;
            }
            if (this.f814a == 2) {
                m58930b();
                this.f814a = 3;
                if (!this.f815b.mo58901x()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f817d.close();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
    /* renamed from: t */
    public Timeout mo58555t() {
        return this.f815b.mo58555t();
    }

    /* renamed from: a */
    private void m58933a() throws IOException {
        this.f815b.mo58909c(10L);
        byte m58963a = this.f815b.mo58905o().m58963a(3L);
        boolean z = ((m58963a >> 1) & 1) == 1;
        if (z) {
            m58932a(this.f815b.mo58905o(), 0L, 10L);
        }
        m58931a("ID1ID2", 8075, this.f815b.readShort());
        this.f815b.skip(8L);
        if (((m58963a >> 2) & 1) == 1) {
            this.f815b.mo58909c(2L);
            if (z) {
                m58932a(this.f815b.mo58905o(), 0L, 2L);
            }
            long mo58904u = this.f815b.mo58905o().mo58904u();
            this.f815b.mo58909c(mo58904u);
            if (z) {
                m58932a(this.f815b.mo58905o(), 0L, mo58904u);
            }
            this.f815b.skip(mo58904u);
        }
        if (((m58963a >> 3) & 1) == 1) {
            long mo58915a = this.f815b.mo58915a((byte) 0);
            if (mo58915a != -1) {
                if (z) {
                    m58932a(this.f815b.mo58905o(), 0L, mo58915a + 1);
                }
                this.f815b.skip(mo58915a + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((m58963a >> 4) & 1) == 1) {
            long mo58915a2 = this.f815b.mo58915a((byte) 0);
            if (mo58915a2 != -1) {
                if (z) {
                    m58932a(this.f815b.mo58905o(), 0L, mo58915a2 + 1);
                }
                this.f815b.skip(mo58915a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            m58931a("FHCRC", this.f815b.mo58904u(), (short) this.f818e.getValue());
            this.f818e.reset();
        }
    }

    /* renamed from: a */
    private void m58932a(Buffer buffer, long j, long j2) {
        int i;
        Segment segment = buffer.f804a;
        while (true) {
            long j3 = segment.f837c - segment.f836b;
            if (j < j3) {
                break;
            }
            j -= j3;
            segment = segment.f840f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(segment.f837c - i, j2);
            this.f818e.update(segment.f835a, (int) (segment.f836b + j), min);
            j2 -= min;
            segment = segment.f840f;
            j = 0;
        }
    }

    /* renamed from: a */
    private void m58931a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
