package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.k */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class InflaterSource implements Source {

    /* renamed from: a */
    private final BufferedSource f819a;

    /* renamed from: b */
    private final Inflater f820b;

    /* renamed from: c */
    private int f821c;

    /* renamed from: d */
    private boolean f822d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f819a = bufferedSource;
            this.f820b = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    /* renamed from: b */
    private void m58928b() throws IOException {
        int i = this.f821c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f820b.getRemaining();
        this.f821c -= remaining;
        this.f819a.skip(remaining);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
    /* renamed from: a */
    public long mo58558a(Buffer buffer, long j) throws IOException {
        Segment m58953b;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (this.f822d) {
                throw new IllegalStateException("closed");
            }
            if (i == 0) {
                return 0L;
            }
            while (true) {
                boolean m58929a = m58929a();
                try {
                    m58953b = buffer.m58953b(1);
                    int inflate = this.f820b.inflate(m58953b.f835a, m58953b.f837c, (int) Math.min(j, 8192 - m58953b.f837c));
                    if (inflate > 0) {
                        m58953b.f837c += inflate;
                        long j2 = inflate;
                        buffer.f805b += j2;
                        return j2;
                    } else if (this.f820b.finished() || this.f820b.needsDictionary()) {
                        break;
                    } else if (m58929a) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            m58928b();
            if (m58953b.f836b == m58953b.f837c) {
                buffer.f804a = m58953b.m58895b();
                SegmentPool.m58892a(m58953b);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f822d) {
            return;
        }
        this.f820b.end();
        this.f822d = true;
        this.f819a.close();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
    /* renamed from: t */
    public Timeout mo58555t() {
        return this.f819a.mo58555t();
    }

    /* renamed from: a */
    public final boolean m58929a() throws IOException {
        if (this.f820b.needsInput()) {
            m58928b();
            if (this.f820b.getRemaining() == 0) {
                if (this.f819a.mo58901x()) {
                    return true;
                }
                Segment segment = this.f819a.mo58905o().f804a;
                int i = segment.f837c;
                int i2 = segment.f836b;
                int i3 = i - i2;
                this.f821c = i3;
                this.f820b.setInput(segment.f835a, i2, i3);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }
}
