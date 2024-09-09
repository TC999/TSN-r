package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Http2Writer.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
final class j implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    private static final Logger f1178g = Logger.getLogger(e.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d f1179a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1180b;

    /* renamed from: c  reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c f1181c;

    /* renamed from: d  reason: collision with root package name */
    private int f1182d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1183e;

    /* renamed from: f  reason: collision with root package name */
    final d.b f1184f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar, boolean z3) {
        this.f1179a = dVar;
        this.f1180b = z3;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
        this.f1181c = cVar;
        this.f1184f = new d.b(cVar);
        this.f1182d = 16384;
    }

    public synchronized void a() throws IOException {
        if (!this.f1183e) {
            if (this.f1180b) {
                Logger logger = f1178g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(">> CONNECTION %s", e.f1059a.b()));
                }
                this.f1179a.write(e.f1059a.g());
                this.f1179a.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public int b() {
        return this.f1182d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f1183e = true;
        this.f1179a.close();
    }

    public synchronized void flush() throws IOException {
        if (!this.f1183e) {
            this.f1179a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void b(n nVar) throws IOException {
        if (!this.f1183e) {
            int i4 = 0;
            a(0, nVar.d() * 6, (byte) 4, (byte) 0);
            while (i4 < 10) {
                if (nVar.d(i4)) {
                    this.f1179a.writeShort(i4 == 4 ? 3 : i4 == 7 ? 4 : i4);
                    this.f1179a.writeInt(nVar.a(i4));
                }
                i4++;
            }
            this.f1179a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(n nVar) throws IOException {
        if (!this.f1183e) {
            this.f1182d = nVar.c(this.f1182d);
            if (nVar.b() != -1) {
                this.f1184f.a(nVar.b());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.f1179a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    private void b(int i4, long j4) throws IOException {
        while (j4 > 0) {
            int min = (int) Math.min(this.f1182d, j4);
            long j5 = min;
            j4 -= j5;
            a(i4, min, (byte) 9, j4 == 0 ? (byte) 4 : (byte) 0);
            this.f1179a.b(this.f1181c, j5);
        }
    }

    public synchronized void a(int i4, int i5, List<c> list) throws IOException {
        if (!this.f1183e) {
            this.f1184f.a(list);
            long f4 = this.f1181c.f();
            int min = (int) Math.min(this.f1182d - 4, f4);
            long j4 = min;
            int i6 = (f4 > j4 ? 1 : (f4 == j4 ? 0 : -1));
            a(i4, min + 4, (byte) 5, i6 == 0 ? (byte) 4 : (byte) 0);
            this.f1179a.writeInt(i5 & Integer.MAX_VALUE);
            this.f1179a.b(this.f1181c, j4);
            if (i6 > 0) {
                b(i4, f4 - j4);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z3, int i4, int i5, List<c> list) throws IOException {
        if (!this.f1183e) {
            a(z3, i4, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i4, b bVar) throws IOException {
        if (!this.f1183e) {
            if (bVar.f1030a != -1) {
                a(i4, 4, (byte) 3, (byte) 0);
                this.f1179a.writeInt(bVar.f1030a);
                this.f1179a.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z3, int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, int i5) throws IOException {
        if (!this.f1183e) {
            a(i4, z3 ? (byte) 1 : (byte) 0, cVar, i5);
        } else {
            throw new IOException("closed");
        }
    }

    void a(int i4, byte b4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, int i5) throws IOException {
        a(i4, i5, (byte) 0, b4);
        if (i5 > 0) {
            this.f1179a.b(cVar, i5);
        }
    }

    public synchronized void a(boolean z3, int i4, int i5) throws IOException {
        if (!this.f1183e) {
            a(0, 8, (byte) 6, z3 ? (byte) 1 : (byte) 0);
            this.f1179a.writeInt(i4);
            this.f1179a.writeInt(i5);
            this.f1179a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i4, b bVar, byte[] bArr) throws IOException {
        if (!this.f1183e) {
            if (bVar.f1030a != -1) {
                a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f1179a.writeInt(i4);
                this.f1179a.writeInt(bVar.f1030a);
                if (bArr.length > 0) {
                    this.f1179a.write(bArr);
                }
                this.f1179a.flush();
            } else {
                e.a("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i4, long j4) throws IOException {
        if (this.f1183e) {
            throw new IOException("closed");
        }
        if (j4 != 0 && j4 <= 2147483647L) {
            a(i4, 4, (byte) 8, (byte) 0);
            this.f1179a.writeInt((int) j4);
            this.f1179a.flush();
        } else {
            e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j4));
            throw null;
        }
    }

    public void a(int i4, int i5, byte b4, byte b5) throws IOException {
        Logger logger = f1178g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.a(false, i4, i5, b4, b5));
        }
        int i6 = this.f1182d;
        if (i5 > i6) {
            e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i6), Integer.valueOf(i5));
            throw null;
        } else if ((Integer.MIN_VALUE & i4) != 0) {
            e.a("reserved bit set: %s", Integer.valueOf(i4));
            throw null;
        } else {
            a(this.f1179a, i5);
            this.f1179a.writeByte(b4 & 255);
            this.f1179a.writeByte(b5 & 255);
            this.f1179a.writeInt(i4 & Integer.MAX_VALUE);
        }
    }

    private static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar, int i4) throws IOException {
        dVar.writeByte((i4 >>> 16) & 255);
        dVar.writeByte((i4 >>> 8) & 255);
        dVar.writeByte(i4 & 255);
    }

    void a(boolean z3, int i4, List<c> list) throws IOException {
        if (!this.f1183e) {
            this.f1184f.a(list);
            long f4 = this.f1181c.f();
            int min = (int) Math.min(this.f1182d, f4);
            long j4 = min;
            int i5 = (f4 > j4 ? 1 : (f4 == j4 ? 0 : -1));
            byte b4 = i5 == 0 ? (byte) 4 : (byte) 0;
            if (z3) {
                b4 = (byte) (b4 | 1);
            }
            a(i4, min, (byte) 1, b4);
            this.f1179a.b(this.f1181c, j4);
            if (i5 > 0) {
                b(i4, f4 - j4);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
