package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Http2Reader.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class h implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    static final Logger f1142e = Logger.getLogger(e.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f1143a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1144b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1145c;

    /* renamed from: d  reason: collision with root package name */
    final d.a f1146d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface b {
        void a();

        void a(int i4, int i5, int i6, boolean z3);

        void a(int i4, int i5, List<c> list) throws IOException;

        void a(int i4, long j4);

        void a(int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar);

        void a(int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar);

        void a(boolean z3, int i4, int i5);

        void a(boolean z3, int i4, int i5, List<c> list);

        void a(boolean z3, int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i5) throws IOException;

        void a(boolean z3, n nVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, boolean z3) {
        this.f1143a = eVar;
        this.f1145c = z3;
        a aVar = new a(eVar);
        this.f1144b = aVar;
        this.f1146d = new d.a(4096, aVar);
    }

    private void b(b bVar, int i4, byte b4, int i5) throws IOException {
        if (i4 < 8) {
            e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i4));
            throw null;
        } else if (i5 == 0) {
            int readInt = this.f1143a.readInt();
            int readInt2 = this.f1143a.readInt();
            int i6 = i4 - 8;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b a4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.a(readInt2);
            if (a4 == null) {
                e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
                throw null;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.f800e;
            if (i6 > 0) {
                fVar = this.f1143a.d(i6);
            }
            bVar.a(readInt, a4, fVar);
        } else {
            e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    private void c(b bVar, int i4, byte b4, int i5) throws IOException {
        if (i5 != 0) {
            boolean z3 = (b4 & 1) != 0;
            short readByte = (b4 & 8) != 0 ? (short) (this.f1143a.readByte() & 255) : (short) 0;
            if ((b4 & 32) != 0) {
                a(bVar, i5);
                i4 -= 5;
            }
            bVar.a(z3, i5, -1, a(a(i4, b4, readByte), readByte, b4, i5));
            return;
        }
        e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    private void d(b bVar, int i4, byte b4, int i5) throws IOException {
        if (i4 != 8) {
            e.b("TYPE_PING length != 8: %s", Integer.valueOf(i4));
            throw null;
        } else if (i5 == 0) {
            bVar.a((b4 & 1) != 0, this.f1143a.readInt(), this.f1143a.readInt());
        } else {
            e.b("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    private void e(b bVar, int i4, byte b4, int i5) throws IOException {
        if (i4 != 5) {
            e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i4));
            throw null;
        } else if (i5 != 0) {
            a(bVar, i5);
        } else {
            e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void f(b bVar, int i4, byte b4, int i5) throws IOException {
        if (i5 != 0) {
            short readByte = (b4 & 8) != 0 ? (short) (this.f1143a.readByte() & 255) : (short) 0;
            bVar.a(i5, this.f1143a.readInt() & Integer.MAX_VALUE, a(a(i4 - 4, b4, readByte), readByte, b4, i5));
            return;
        }
        e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    }

    private void g(b bVar, int i4, byte b4, int i5) throws IOException {
        if (i4 != 4) {
            e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i4));
            throw null;
        } else if (i5 != 0) {
            int readInt = this.f1143a.readInt();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b a4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.a(readInt);
            if (a4 != null) {
                bVar.a(i5, a4);
            } else {
                e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                throw null;
            }
        } else {
            e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void h(b bVar, int i4, byte b4, int i5) throws IOException {
        if (i5 != 0) {
            e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b4 & 1) != 0) {
            if (i4 == 0) {
                bVar.a();
            } else {
                e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        } else if (i4 % 6 != 0) {
            e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i4));
            throw null;
        } else {
            n nVar = new n();
            for (int i6 = 0; i6 < i4; i6 += 6) {
                short readShort = this.f1143a.readShort();
                int readInt = this.f1143a.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort == 4) {
                        readShort = 7;
                        if (readInt < 0) {
                            e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                    } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                        e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        throw null;
                    }
                } else if (readInt != 0 && readInt != 1) {
                    e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    throw null;
                }
                nVar.a(readShort, readInt);
            }
            bVar.a(false, nVar);
        }
    }

    private void i(b bVar, int i4, byte b4, int i5) throws IOException {
        if (i4 != 4) {
            e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i4));
            throw null;
        }
        long readInt = this.f1143a.readInt() & 2147483647L;
        if (readInt != 0) {
            bVar.a(i5, readInt);
        } else {
            e.b("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
    }

    public void a(b bVar) throws IOException {
        if (this.f1145c) {
            if (a(true, bVar)) {
                return;
            }
            e.b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar = this.f1143a;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar = e.f1059a;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f d4 = eVar.d(fVar.e());
        Logger logger = f1142e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("<< CONNECTION %s", d4.b()));
        }
        if (fVar.equals(d4)) {
            return;
        }
        e.b("Expected a connection header but was %s", d4.h());
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1143a.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static final class a implements s {

        /* renamed from: a  reason: collision with root package name */
        private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f1147a;

        /* renamed from: b  reason: collision with root package name */
        int f1148b;

        /* renamed from: c  reason: collision with root package name */
        byte f1149c;

        /* renamed from: d  reason: collision with root package name */
        int f1150d;

        /* renamed from: e  reason: collision with root package name */
        int f1151e;

        /* renamed from: f  reason: collision with root package name */
        short f1152f;

        a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar) {
            this.f1147a = eVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            while (true) {
                int i4 = this.f1151e;
                if (i4 == 0) {
                    this.f1147a.skip(this.f1152f);
                    this.f1152f = (short) 0;
                    if ((this.f1149c & 4) != 0) {
                        return -1L;
                    }
                    a();
                } else {
                    long a4 = this.f1147a.a(cVar, Math.min(j4, i4));
                    if (a4 == -1) {
                        return -1L;
                    }
                    this.f1151e = (int) (this.f1151e - a4);
                    return a4;
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t t() {
            return this.f1147a.t();
        }

        private void a() throws IOException {
            int i4 = this.f1150d;
            int a4 = h.a(this.f1147a);
            this.f1151e = a4;
            this.f1148b = a4;
            byte readByte = (byte) (this.f1147a.readByte() & 255);
            this.f1149c = (byte) (this.f1147a.readByte() & 255);
            Logger logger = h.f1142e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a(true, this.f1150d, this.f1148b, readByte, this.f1149c));
            }
            int readInt = this.f1147a.readInt() & Integer.MAX_VALUE;
            this.f1150d = readInt;
            if (readByte != 9) {
                e.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            } else if (readInt == i4) {
            } else {
                e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }
    }

    public boolean a(boolean z3, b bVar) throws IOException {
        try {
            this.f1143a.c(9L);
            int a4 = a(this.f1143a);
            if (a4 < 0 || a4 > 16384) {
                e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a4));
                throw null;
            }
            byte readByte = (byte) (this.f1143a.readByte() & 255);
            if (z3 && readByte != 4) {
                e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                throw null;
            }
            byte readByte2 = (byte) (this.f1143a.readByte() & 255);
            int readInt = this.f1143a.readInt() & Integer.MAX_VALUE;
            Logger logger = f1142e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a(true, readInt, a4, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    a(bVar, a4, readByte2, readInt);
                    break;
                case 1:
                    c(bVar, a4, readByte2, readInt);
                    break;
                case 2:
                    e(bVar, a4, readByte2, readInt);
                    break;
                case 3:
                    g(bVar, a4, readByte2, readInt);
                    break;
                case 4:
                    h(bVar, a4, readByte2, readInt);
                    break;
                case 5:
                    f(bVar, a4, readByte2, readInt);
                    break;
                case 6:
                    d(bVar, a4, readByte2, readInt);
                    break;
                case 7:
                    b(bVar, a4, readByte2, readInt);
                    break;
                case 8:
                    i(bVar, a4, readByte2, readInt);
                    break;
                default:
                    this.f1143a.skip(a4);
                    break;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private List<c> a(int i4, short s3, byte b4, int i5) throws IOException {
        a aVar = this.f1144b;
        aVar.f1151e = i4;
        aVar.f1148b = i4;
        aVar.f1152f = s3;
        aVar.f1149c = b4;
        aVar.f1150d = i5;
        this.f1146d.c();
        return this.f1146d.a();
    }

    private void a(b bVar, int i4, byte b4, int i5) throws IOException {
        if (i5 == 0) {
            e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z3 = (b4 & 1) != 0;
        if (!((b4 & 32) != 0)) {
            short readByte = (b4 & 8) != 0 ? (short) (this.f1143a.readByte() & 255) : (short) 0;
            bVar.a(z3, i5, this.f1143a, a(i4, b4, readByte));
            this.f1143a.skip(readByte);
            return;
        }
        e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        throw null;
    }

    private void a(b bVar, int i4) throws IOException {
        int readInt = this.f1143a.readInt();
        bVar.a(i4, readInt & Integer.MAX_VALUE, (this.f1143a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    static int a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar) throws IOException {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    static int a(int i4, byte b4, short s3) throws IOException {
        if ((b4 & 8) != 0) {
            i4--;
        }
        if (s3 <= i4) {
            return (short) (i4 - s3);
        }
        e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s3), Integer.valueOf(i4));
        throw null;
    }
}
