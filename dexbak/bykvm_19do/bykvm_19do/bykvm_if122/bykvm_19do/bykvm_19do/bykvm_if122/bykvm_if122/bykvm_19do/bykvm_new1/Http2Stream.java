package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Http2Stream {

    /* renamed from: l */
    static final /* synthetic */ boolean f1160l = true;

    /* renamed from: b */
    long f1162b;

    /* renamed from: c */
    final int f1163c;

    /* renamed from: d */
    final Http2Connection f1164d;

    /* renamed from: e */
    private List<Header> f1165e;

    /* renamed from: f */
    private boolean f1166f;

    /* renamed from: g */
    private final C1053b f1167g;

    /* renamed from: h */
    final C1052a f1168h;

    /* renamed from: a */
    long f1161a = 0;

    /* renamed from: i */
    final C1054c f1169i = new C1054c();

    /* renamed from: j */
    final C1054c f1170j = new C1054c();

    /* renamed from: k */
    ErrorCode f1171k = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1052a implements Sink {

        /* renamed from: e */
        static final /* synthetic */ boolean f1172e = true;

        /* renamed from: a */
        private final Buffer f1173a = new Buffer();

        /* renamed from: b */
        boolean f1174b;

        /* renamed from: c */
        boolean f1175c;

        C1052a() {
        }

        /* renamed from: a */
        private void m58562a(boolean z) throws IOException {
            Http2Stream http2Stream;
            long min;
            Http2Stream http2Stream2;
            synchronized (Http2Stream.this) {
                Http2Stream.this.f1170j.m58971g();
                while (true) {
                    http2Stream = Http2Stream.this;
                    if (http2Stream.f1162b > 0 || this.f1175c || this.f1174b || http2Stream.f1171k != null) {
                        break;
                    }
                    http2Stream.m58564k();
                }
                http2Stream.f1170j.m58552k();
                Http2Stream.this.m58576b();
                min = Math.min(Http2Stream.this.f1162b, this.f1173a.m58947f());
                http2Stream2 = Http2Stream.this;
                http2Stream2.f1162b -= min;
            }
            http2Stream2.f1170j.m58971g();
            try {
                Http2Stream http2Stream3 = Http2Stream.this;
                http2Stream3.f1164d.m58629a(http2Stream3.f1163c, z && min == this.f1173a.m58947f(), this.f1173a, min);
            } finally {
                Http2Stream.this.f1170j.m58552k();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
        /* renamed from: b */
        public void mo58561b(Buffer buffer, long j) throws IOException {
            if (!f1172e && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            this.f1173a.mo58561b(buffer, j);
            while (this.f1173a.m58947f() >= 16384) {
                m58562a(false);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f1172e && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                if (this.f1174b) {
                    return;
                }
                if (!Http2Stream.this.f1168h.f1175c) {
                    if (this.f1173a.m58947f() > 0) {
                        while (this.f1173a.m58947f() > 0) {
                            m58562a(true);
                        }
                    } else {
                        Http2Stream http2Stream = Http2Stream.this;
                        http2Stream.f1164d.m58629a(http2Stream.f1163c, true, (Buffer) null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.f1174b = true;
                }
                Http2Stream.this.f1164d.flush();
                Http2Stream.this.m58581a();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (!f1172e && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                Http2Stream.this.m58576b();
            }
            while (this.f1173a.m58947f() > 0) {
                m58562a(false);
                Http2Stream.this.f1164d.flush();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
        /* renamed from: t */
        public Timeout mo58560t() {
            return Http2Stream.this.f1170j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1054c extends AsyncTimeout {
        C1054c() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout
        /* renamed from: b */
        protected IOException mo58554b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout
        /* renamed from: i */
        protected void mo58553i() {
            Http2Stream.this.m58575b(ErrorCode.CANCEL);
        }

        /* renamed from: k */
        public void m58552k() throws IOException {
            if (m58970h()) {
                throw mo58554b((IOException) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, List<Header> list) {
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list != null) {
            this.f1163c = i;
            this.f1164d = http2Connection;
            this.f1162b = http2Connection.f1102n.m58516c();
            C1053b c1053b = new C1053b(http2Connection.f1101m.m58516c());
            this.f1167g = c1053b;
            C1052a c1052a = new C1052a();
            this.f1168h = c1052a;
            c1053b.f1182e = z2;
            c1052a.f1175c = z;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    /* renamed from: a */
    public void m58578a(ErrorCode errorCode) throws IOException {
        if (m58571d(errorCode)) {
            this.f1164d.m58620b(this.f1163c, errorCode);
        }
    }

    /* renamed from: b */
    public void m58575b(ErrorCode errorCode) {
        if (m58571d(errorCode)) {
            this.f1164d.m58615c(this.f1163c, errorCode);
        }
    }

    /* renamed from: c */
    public int m58574c() {
        return this.f1163c;
    }

    /* renamed from: d */
    public Sink m58572d() {
        synchronized (this) {
            if (!this.f1166f && !m58569f()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f1168h;
    }

    /* renamed from: e */
    public Source m58570e() {
        return this.f1167g;
    }

    /* renamed from: f */
    public boolean m58569f() {
        return this.f1164d.f1089a == ((this.f1163c & 1) == 1);
    }

    /* renamed from: g */
    public synchronized boolean m58568g() {
        if (this.f1171k != null) {
            return false;
        }
        C1053b c1053b = this.f1167g;
        if (c1053b.f1182e || c1053b.f1181d) {
            C1052a c1052a = this.f1168h;
            if (c1052a.f1175c || c1052a.f1174b) {
                if (this.f1166f) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: h */
    public Timeout m58567h() {
        return this.f1169i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public void m58566i() {
        boolean m58568g;
        if (!f1160l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f1167g.f1182e = true;
            m58568g = m58568g();
            notifyAll();
        }
        if (m58568g) {
            return;
        }
        this.f1164d.m58614d(this.f1163c);
    }

    /* renamed from: j */
    public synchronized List<Header> m58565j() throws IOException {
        List<Header> list;
        if (m58569f()) {
            this.f1169i.m58971g();
            while (this.f1165e == null && this.f1171k == null) {
                m58564k();
            }
            this.f1169i.m58552k();
            list = this.f1165e;
            if (list != null) {
                this.f1165e = null;
            } else {
                throw new StreamResetException(this.f1171k);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    /* renamed from: k */
    void m58564k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    /* renamed from: l */
    public Timeout m58563l() {
        return this.f1170j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized void m58573c(ErrorCode errorCode) {
        if (this.f1171k == null) {
            this.f1171k = errorCode;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m58577a(List<Header> list) {
        boolean z;
        if (!f1160l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = true;
            this.f1166f = true;
            if (this.f1165e == null) {
                this.f1165e = list;
                z = m58568g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f1165e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f1165e = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f1164d.m58614d(this.f1163c);
    }

    /* renamed from: b */
    void m58576b() throws IOException {
        C1052a c1052a = this.f1168h;
        if (!c1052a.f1174b) {
            if (!c1052a.f1175c) {
                ErrorCode errorCode = this.f1171k;
                if (errorCode != null) {
                    throw new StreamResetException(errorCode);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    /* renamed from: d */
    private boolean m58571d(ErrorCode errorCode) {
        if (f1160l || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f1171k != null) {
                    return false;
                }
                if (this.f1167g.f1182e && this.f1168h.f1175c) {
                    return false;
                }
                this.f1171k = errorCode;
                notifyAll();
                this.f1164d.m58614d(this.f1163c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m58579a(BufferedSource bufferedSource, int i) throws IOException {
        if (!f1160l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f1167g.m58557a(bufferedSource, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http2Stream.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1053b implements Source {

        /* renamed from: g */
        static final /* synthetic */ boolean f1177g = true;

        /* renamed from: a */
        private final Buffer f1178a = new Buffer();

        /* renamed from: b */
        private final Buffer f1179b = new Buffer();

        /* renamed from: c */
        private final long f1180c;

        /* renamed from: d */
        boolean f1181d;

        /* renamed from: e */
        boolean f1182e;

        C1053b(long j) {
            this.f1180c = j;
        }

        /* renamed from: b */
        private void m58556b() throws IOException {
            Http2Stream.this.f1169i.m58971g();
            while (this.f1179b.m58947f() == 0 && !this.f1182e && !this.f1181d) {
                try {
                    Http2Stream http2Stream = Http2Stream.this;
                    if (http2Stream.f1171k != null) {
                        break;
                    }
                    http2Stream.m58564k();
                } finally {
                    Http2Stream.this.f1169i.m58552k();
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: a */
        public long mo58558a(Buffer buffer, long j) throws IOException {
            if (j >= 0) {
                synchronized (Http2Stream.this) {
                    m58556b();
                    m58559a();
                    if (this.f1179b.m58947f() == 0) {
                        return -1L;
                    }
                    Buffer buffer2 = this.f1179b;
                    long mo58558a = buffer2.mo58558a(buffer, Math.min(j, buffer2.m58947f()));
                    Http2Stream http2Stream = Http2Stream.this;
                    long j2 = http2Stream.f1161a + mo58558a;
                    http2Stream.f1161a = j2;
                    if (j2 >= http2Stream.f1164d.f1101m.m58516c() / 2) {
                        Http2Stream http2Stream2 = Http2Stream.this;
                        http2Stream2.f1164d.m58634a(http2Stream2.f1163c, http2Stream2.f1161a);
                        Http2Stream.this.f1161a = 0L;
                    }
                    synchronized (Http2Stream.this.f1164d) {
                        Http2Connection http2Connection = Http2Stream.this.f1164d;
                        long j3 = http2Connection.f1099k + mo58558a;
                        http2Connection.f1099k = j3;
                        if (j3 >= http2Connection.f1101m.m58516c() / 2) {
                            Http2Connection http2Connection2 = Http2Stream.this.f1164d;
                            http2Connection2.m58634a(0, http2Connection2.f1099k);
                            Http2Stream.this.f1164d.f1099k = 0L;
                        }
                    }
                    return mo58558a;
                }
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Http2Stream.this) {
                this.f1181d = true;
                this.f1179b.m58966a();
                Http2Stream.this.notifyAll();
            }
            Http2Stream.this.m58581a();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: t */
        public Timeout mo58555t() {
            return Http2Stream.this.f1169i;
        }

        /* renamed from: a */
        void m58557a(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!f1177g && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.f1182e;
                    z2 = true;
                    z3 = this.f1179b.m58947f() + j > this.f1180c;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    Http2Stream.this.m58575b(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j);
                    return;
                } else {
                    long mo58558a = bufferedSource.mo58558a(this.f1178a, j);
                    if (mo58558a != -1) {
                        j -= mo58558a;
                        synchronized (Http2Stream.this) {
                            if (this.f1179b.m58947f() != 0) {
                                z2 = false;
                            }
                            this.f1179b.m58958a(this.f1178a);
                            if (z2) {
                                Http2Stream.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        /* renamed from: a */
        private void m58559a() throws IOException {
            if (!this.f1181d) {
                ErrorCode errorCode = Http2Stream.this.f1171k;
                if (errorCode != null) {
                    throw new StreamResetException(errorCode);
                }
                return;
            }
            throw new IOException("stream closed");
        }
    }

    /* renamed from: a */
    void m58581a() throws IOException {
        boolean z;
        boolean m58568g;
        if (!f1160l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            C1053b c1053b = this.f1167g;
            if (!c1053b.f1182e && c1053b.f1181d) {
                C1052a c1052a = this.f1168h;
                if (c1052a.f1175c || c1052a.f1174b) {
                    z = true;
                    m58568g = m58568g();
                }
            }
            z = false;
            m58568g = m58568g();
        }
        if (z) {
            m58578a(ErrorCode.CANCEL);
        } else if (m58568g) {
        } else {
            this.f1164d.m58614d(this.f1163c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m58580a(long j) {
        this.f1162b += j;
        if (j > 0) {
            notifyAll();
        }
    }
}
