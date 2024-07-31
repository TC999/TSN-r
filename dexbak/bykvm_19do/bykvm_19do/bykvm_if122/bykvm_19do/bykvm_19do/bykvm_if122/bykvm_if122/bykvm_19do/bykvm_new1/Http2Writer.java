package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Hpack;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
final class Http2Writer implements Closeable {

    /* renamed from: g */
    private static final Logger f1185g = Logger.getLogger(Http2.class.getName());

    /* renamed from: a */
    private final BufferedSink f1186a;

    /* renamed from: b */
    private final boolean f1187b;

    /* renamed from: c */
    private final Buffer f1188c;

    /* renamed from: d */
    private int f1189d;

    /* renamed from: e */
    private boolean f1190e;

    /* renamed from: f */
    final Hpack.C1034b f1191f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Writer(BufferedSink bufferedSink, boolean z) {
        this.f1186a = bufferedSink;
        this.f1187b = z;
        Buffer buffer = new Buffer();
        this.f1188c = buffer;
        this.f1191f = new Hpack.C1034b(buffer);
        this.f1189d = 16384;
    }

    /* renamed from: a */
    public synchronized void m58551a() throws IOException {
        if (!this.f1190e) {
            if (this.f1187b) {
                Logger logger = f1185g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(C1061c.m58464a(">> CONNECTION %s", Http2.f1066a.mo58885b()));
                }
                this.f1186a.write(Http2.f1066a.mo58879g());
                this.f1186a.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    /* renamed from: b */
    public int m58538b() {
        return this.f1189d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f1190e = true;
        this.f1186a.close();
    }

    public synchronized void flush() throws IOException {
        if (!this.f1190e) {
            this.f1186a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public synchronized void m58536b(Settings settings) throws IOException {
        if (!this.f1190e) {
            int i = 0;
            m58549a(0, settings.m58514d() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (settings.m58513d(i)) {
                    this.f1186a.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f1186a.writeInt(settings.m58521a(i));
                }
                i++;
            }
            this.f1186a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m58543a(Settings settings) throws IOException {
        if (!this.f1190e) {
            this.f1189d = settings.m58515c(this.f1189d);
            if (settings.m58518b() != -1) {
                this.f1191f.m58656a(settings.m58518b());
            }
            m58549a(0, 0, (byte) 4, (byte) 1);
            this.f1186a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    private void m58537b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.f1189d, j);
            long j2 = min;
            j -= j2;
            m58549a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f1186a.mo58561b(this.f1188c, j2);
        }
    }

    /* renamed from: a */
    public synchronized void m58548a(int i, int i2, List<Header> list) throws IOException {
        if (!this.f1190e) {
            this.f1191f.m58652a(list);
            long m58947f = this.f1188c.m58947f();
            int min = (int) Math.min(this.f1189d - 4, m58947f);
            long j = min;
            int i3 = (m58947f > j ? 1 : (m58947f == j ? 0 : -1));
            m58549a(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : (byte) 0);
            this.f1186a.writeInt(i2 & Integer.MAX_VALUE);
            this.f1186a.mo58561b(this.f1188c, j);
            if (i3 > 0) {
                m58537b(i, m58947f - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m58541a(boolean z, int i, int i2, List<Header> list) throws IOException {
        if (!this.f1190e) {
            m58539a(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m58546a(int i, ErrorCode errorCode) throws IOException {
        if (!this.f1190e) {
            if (errorCode.f1037a != -1) {
                m58549a(i, 4, (byte) 3, (byte) 0);
                this.f1186a.writeInt(errorCode.f1037a);
                this.f1186a.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m58540a(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (!this.f1190e) {
            m58550a(i, z ? (byte) 1 : (byte) 0, buffer, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    void m58550a(int i, byte b, Buffer buffer, int i2) throws IOException {
        m58549a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f1186a.mo58561b(buffer, i2);
        }
    }

    /* renamed from: a */
    public synchronized void m58542a(boolean z, int i, int i2) throws IOException {
        if (!this.f1190e) {
            m58549a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.f1186a.writeInt(i);
            this.f1186a.writeInt(i2);
            this.f1186a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m58545a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (!this.f1190e) {
            if (errorCode.f1037a != -1) {
                m58549a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f1186a.writeInt(i);
                this.f1186a.writeInt(errorCode.f1037a);
                if (bArr.length > 0) {
                    this.f1186a.write(bArr);
                }
                this.f1186a.flush();
            } else {
                Http2.m58648a("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m58547a(int i, long j) throws IOException {
        if (this.f1190e) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            m58549a(i, 4, (byte) 8, (byte) 0);
            this.f1186a.writeInt((int) j);
            this.f1186a.flush();
        } else {
            Http2.m58648a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
    }

    /* renamed from: a */
    public void m58549a(int i, int i2, byte b, byte b2) throws IOException {
        Logger logger = f1185g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.m58647a(false, i, i2, b, b2));
        }
        int i3 = this.f1189d;
        if (i2 > i3) {
            Http2.m58648a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        } else if ((Integer.MIN_VALUE & i) != 0) {
            Http2.m58648a("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        } else {
            m58544a(this.f1186a, i2);
            this.f1186a.writeByte(b & UByte.f41242c);
            this.f1186a.writeByte(b2 & UByte.f41242c);
            this.f1186a.writeInt(i & Integer.MAX_VALUE);
        }
    }

    /* renamed from: a */
    private static void m58544a(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    /* renamed from: a */
    void m58539a(boolean z, int i, List<Header> list) throws IOException {
        if (!this.f1190e) {
            this.f1191f.m58652a(list);
            long m58947f = this.f1188c.m58947f();
            int min = (int) Math.min(this.f1189d, m58947f);
            long j = min;
            int i2 = (m58947f > j ? 1 : (m58947f == j ? 0 : -1));
            byte b = i2 == 0 ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            m58549a(i, min, (byte) 1, b);
            this.f1186a.mo58561b(this.f1188c, j);
            if (i2 > 0) {
                m58537b(i, m58947f - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
