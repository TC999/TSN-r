package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Hpack;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Http2Reader implements Closeable {

    /* renamed from: e */
    static final Logger f1149e = Logger.getLogger(Http2.class.getName());

    /* renamed from: a */
    private final BufferedSource f1150a;

    /* renamed from: b */
    private final C1050a f1151b;

    /* renamed from: c */
    private final boolean f1152c;

    /* renamed from: d */
    final Hpack.C1033a f1153d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1051b {
        /* renamed from: a */
        void mo58591a();

        /* renamed from: a */
        void mo58590a(int i, int i2, int i3, boolean z);

        /* renamed from: a */
        void mo58589a(int i, int i2, List<Header> list) throws IOException;

        /* renamed from: a */
        void mo58588a(int i, long j);

        /* renamed from: a */
        void mo58587a(int i, ErrorCode errorCode);

        /* renamed from: a */
        void mo58586a(int i, ErrorCode errorCode, ByteString byteString);

        /* renamed from: a */
        void mo58585a(boolean z, int i, int i2);

        /* renamed from: a */
        void mo58584a(boolean z, int i, int i2, List<Header> list);

        /* renamed from: a */
        void mo58583a(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        /* renamed from: a */
        void mo58582a(boolean z, Settings settings);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.f1150a = bufferedSource;
        this.f1152c = z;
        C1050a c1050a = new C1050a(bufferedSource);
        this.f1151b = c1050a;
        this.f1153d = new Hpack.C1033a(4096, c1050a);
    }

    /* renamed from: b */
    private void m58600b(InterfaceC1051b interfaceC1051b, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            Http2.m58646b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            int readInt = this.f1150a.readInt();
            int readInt2 = this.f1150a.readInt();
            int i3 = i - 8;
            ErrorCode m58677a = ErrorCode.m58677a(readInt2);
            if (m58677a == null) {
                Http2.m58646b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
                throw null;
            }
            ByteString byteString = ByteString.f807e;
            if (i3 > 0) {
                byteString = this.f1150a.mo58908d(i3);
            }
            interfaceC1051b.mo58586a(readInt, m58677a, byteString);
        } else {
            Http2.m58646b("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: c */
    private void m58599c(InterfaceC1051b interfaceC1051b, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            short readByte = (b & 8) != 0 ? (short) (this.f1150a.readByte() & UByte.f41242c) : (short) 0;
            if ((b & 32) != 0) {
                m58603a(interfaceC1051b, i2);
                i -= 5;
            }
            interfaceC1051b.mo58584a(z, i2, -1, m58606a(m58607a(i, b, readByte), readByte, b, i2));
            return;
        }
        Http2.m58646b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    /* renamed from: d */
    private void m58598d(InterfaceC1051b interfaceC1051b, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            Http2.m58646b("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            interfaceC1051b.mo58585a((b & 1) != 0, this.f1150a.readInt(), this.f1150a.readInt());
        } else {
            Http2.m58646b("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: e */
    private void m58597e(InterfaceC1051b interfaceC1051b, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            Http2.m58646b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            throw null;
        } else if (i2 != 0) {
            m58603a(interfaceC1051b, i2);
        } else {
            Http2.m58646b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: f */
    private void m58596f(InterfaceC1051b interfaceC1051b, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            short readByte = (b & 8) != 0 ? (short) (this.f1150a.readByte() & UByte.f41242c) : (short) 0;
            interfaceC1051b.mo58589a(i2, this.f1150a.readInt() & Integer.MAX_VALUE, m58606a(m58607a(i - 4, b, readByte), readByte, b, i2));
            return;
        }
        Http2.m58646b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    }

    /* renamed from: g */
    private void m58595g(InterfaceC1051b interfaceC1051b, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            Http2.m58646b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            throw null;
        } else if (i2 != 0) {
            int readInt = this.f1150a.readInt();
            ErrorCode m58677a = ErrorCode.m58677a(readInt);
            if (m58677a != null) {
                interfaceC1051b.mo58587a(i2, m58677a);
            } else {
                Http2.m58646b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                throw null;
            }
        } else {
            Http2.m58646b("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: h */
    private void m58594h(InterfaceC1051b interfaceC1051b, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            Http2.m58646b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b & 1) != 0) {
            if (i == 0) {
                interfaceC1051b.mo58591a();
            } else {
                Http2.m58646b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        } else if (i % 6 != 0) {
            Http2.m58646b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        } else {
            Settings settings = new Settings();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short readShort = this.f1150a.readShort();
                int readInt = this.f1150a.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort == 4) {
                        readShort = 7;
                        if (readInt < 0) {
                            Http2.m58646b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                    } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                        Http2.m58646b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        throw null;
                    }
                } else if (readInt != 0 && readInt != 1) {
                    Http2.m58646b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    throw null;
                }
                settings.m58520a(readShort, readInt);
            }
            interfaceC1051b.mo58582a(false, settings);
        }
    }

    /* renamed from: i */
    private void m58593i(InterfaceC1051b interfaceC1051b, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            Http2.m58646b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            throw null;
        }
        long readInt = this.f1150a.readInt() & 2147483647L;
        if (readInt != 0) {
            interfaceC1051b.mo58588a(i2, readInt);
        } else {
            Http2.m58646b("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
    }

    /* renamed from: a */
    public void m58604a(InterfaceC1051b interfaceC1051b) throws IOException {
        if (this.f1152c) {
            if (m58601a(true, interfaceC1051b)) {
                return;
            }
            Http2.m58646b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        BufferedSource bufferedSource = this.f1150a;
        ByteString byteString = Http2.f1066a;
        ByteString mo58908d = bufferedSource.mo58908d(byteString.mo58881e());
        Logger logger = f1149e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C1061c.m58464a("<< CONNECTION %s", mo58908d.mo58885b()));
        }
        if (byteString.equals(mo58908d)) {
            return;
        }
        Http2.m58646b("Expected a connection header but was %s", mo58908d.mo58878h());
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1150a.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1050a implements Source {

        /* renamed from: a */
        private final BufferedSource f1154a;

        /* renamed from: b */
        int f1155b;

        /* renamed from: c */
        byte f1156c;

        /* renamed from: d */
        int f1157d;

        /* renamed from: e */
        int f1158e;

        /* renamed from: f */
        short f1159f;

        C1050a(BufferedSource bufferedSource) {
            this.f1154a = bufferedSource;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: a */
        public long mo58558a(Buffer buffer, long j) throws IOException {
            while (true) {
                int i = this.f1158e;
                if (i == 0) {
                    this.f1154a.skip(this.f1159f);
                    this.f1159f = (short) 0;
                    if ((this.f1156c & 4) != 0) {
                        return -1L;
                    }
                    m58592a();
                } else {
                    long mo58558a = this.f1154a.mo58558a(buffer, Math.min(j, i));
                    if (mo58558a == -1) {
                        return -1L;
                    }
                    this.f1158e = (int) (this.f1158e - mo58558a);
                    return mo58558a;
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: t */
        public Timeout mo58555t() {
            return this.f1154a.mo58555t();
        }

        /* renamed from: a */
        private void m58592a() throws IOException {
            int i = this.f1157d;
            int m58605a = Http2Reader.m58605a(this.f1154a);
            this.f1158e = m58605a;
            this.f1155b = m58605a;
            byte readByte = (byte) (this.f1154a.readByte() & UByte.f41242c);
            this.f1156c = (byte) (this.f1154a.readByte() & UByte.f41242c);
            Logger logger = Http2Reader.f1149e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.m58647a(true, this.f1157d, this.f1155b, readByte, this.f1156c));
            }
            int readInt = this.f1154a.readInt() & Integer.MAX_VALUE;
            this.f1157d = readInt;
            if (readByte != 9) {
                Http2.m58646b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            } else if (readInt == i) {
            } else {
                Http2.m58646b("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }
    }

    /* renamed from: a */
    public boolean m58601a(boolean z, InterfaceC1051b interfaceC1051b) throws IOException {
        try {
            this.f1150a.mo58909c(9L);
            int m58605a = m58605a(this.f1150a);
            if (m58605a < 0 || m58605a > 16384) {
                Http2.m58646b("FRAME_SIZE_ERROR: %s", Integer.valueOf(m58605a));
                throw null;
            }
            byte readByte = (byte) (this.f1150a.readByte() & UByte.f41242c);
            if (z && readByte != 4) {
                Http2.m58646b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                throw null;
            }
            byte readByte2 = (byte) (this.f1150a.readByte() & UByte.f41242c);
            int readInt = this.f1150a.readInt() & Integer.MAX_VALUE;
            Logger logger = f1149e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.m58647a(true, readInt, m58605a, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    m58602a(interfaceC1051b, m58605a, readByte2, readInt);
                    break;
                case 1:
                    m58599c(interfaceC1051b, m58605a, readByte2, readInt);
                    break;
                case 2:
                    m58597e(interfaceC1051b, m58605a, readByte2, readInt);
                    break;
                case 3:
                    m58595g(interfaceC1051b, m58605a, readByte2, readInt);
                    break;
                case 4:
                    m58594h(interfaceC1051b, m58605a, readByte2, readInt);
                    break;
                case 5:
                    m58596f(interfaceC1051b, m58605a, readByte2, readInt);
                    break;
                case 6:
                    m58598d(interfaceC1051b, m58605a, readByte2, readInt);
                    break;
                case 7:
                    m58600b(interfaceC1051b, m58605a, readByte2, readInt);
                    break;
                case 8:
                    m58593i(interfaceC1051b, m58605a, readByte2, readInt);
                    break;
                default:
                    this.f1150a.skip(m58605a);
                    break;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private List<Header> m58606a(int i, short s, byte b, int i2) throws IOException {
        C1050a c1050a = this.f1151b;
        c1050a.f1158e = i;
        c1050a.f1155b = i;
        c1050a.f1159f = s;
        c1050a.f1156c = b;
        c1050a.f1157d = i2;
        this.f1153d.m58668c();
        return this.f1153d.m58674a();
    }

    /* renamed from: a */
    private void m58602a(InterfaceC1051b interfaceC1051b, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            Http2.m58646b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b & 1) != 0;
        if (!((b & 32) != 0)) {
            short readByte = (b & 8) != 0 ? (short) (this.f1150a.readByte() & UByte.f41242c) : (short) 0;
            interfaceC1051b.mo58583a(z, i2, this.f1150a, m58607a(i, b, readByte));
            this.f1150a.skip(readByte);
            return;
        }
        Http2.m58646b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        throw null;
    }

    /* renamed from: a */
    private void m58603a(InterfaceC1051b interfaceC1051b, int i) throws IOException {
        int readInt = this.f1150a.readInt();
        interfaceC1051b.mo58590a(i, readInt & Integer.MAX_VALUE, (this.f1150a.readByte() & UByte.f41242c) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    /* renamed from: a */
    static int m58605a(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & UByte.f41242c) | ((bufferedSource.readByte() & UByte.f41242c) << 16) | ((bufferedSource.readByte() & UByte.f41242c) << 8);
    }

    /* renamed from: a */
    static int m58607a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        Http2.m58646b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }
}
