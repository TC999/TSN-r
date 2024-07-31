package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108;

import android.support.p015v4.media.session.PlaybackStateCompat;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ForwardingTimeout;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Okio;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Headers;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.HttpUrl;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.OkHttpClient;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ResponseBody;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.RealResponseBody;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.RequestLine;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.StatusLine;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.StreamAllocation;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Http1Codec implements HttpCodec {

    /* renamed from: a */
    final OkHttpClient f1007a;

    /* renamed from: b */
    final StreamAllocation f1008b;

    /* renamed from: c */
    final BufferedSource f1009c;

    /* renamed from: d */
    final BufferedSink f1010d;

    /* renamed from: e */
    int f1011e = 0;

    /* renamed from: f */
    private long f1012f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1028c implements Sink {

        /* renamed from: a */
        private final ForwardingTimeout f1017a;

        /* renamed from: b */
        private boolean f1018b;

        C1028c() {
            this.f1017a = new ForwardingTimeout(Http1Codec.this.f1010d.mo58560t());
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
        /* renamed from: b */
        public void mo58561b(Buffer buffer, long j) throws IOException {
            if (this.f1018b) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            Http1Codec.this.f1010d.mo58917g(j);
            Http1Codec.this.f1010d.mo58918d("\r\n");
            Http1Codec.this.f1010d.mo58561b(buffer, j);
            Http1Codec.this.f1010d.mo58918d("\r\n");
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f1018b) {
                return;
            }
            this.f1018b = true;
            Http1Codec.this.f1010d.mo58918d("0\r\n\r\n");
            Http1Codec.this.m58687a(this.f1017a);
            Http1Codec.this.f1011e = 3;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f1018b) {
                return;
            }
            Http1Codec.this.f1010d.flush();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
        /* renamed from: t */
        public Timeout mo58560t() {
            return this.f1017a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1030e implements Sink {

        /* renamed from: a */
        private final ForwardingTimeout f1024a;

        /* renamed from: b */
        private boolean f1025b;

        /* renamed from: c */
        private long f1026c;

        C1030e(long j) {
            this.f1024a = new ForwardingTimeout(Http1Codec.this.f1010d.mo58560t());
            this.f1026c = j;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
        /* renamed from: b */
        public void mo58561b(Buffer buffer, long j) throws IOException {
            if (!this.f1025b) {
                C1061c.m58479a(buffer.m58947f(), 0L, j);
                if (j <= this.f1026c) {
                    Http1Codec.this.f1010d.mo58561b(buffer, j);
                    this.f1026c -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f1026c + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1025b) {
                return;
            }
            this.f1025b = true;
            if (this.f1026c <= 0) {
                Http1Codec.this.m58687a(this.f1024a);
                Http1Codec.this.f1011e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.f1025b) {
                return;
            }
            Http1Codec.this.f1010d.flush();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
        /* renamed from: t */
        public Timeout mo58560t() {
            return this.f1024a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a$f */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1031f extends AbstractC1027b {

        /* renamed from: e */
        private long f1028e;

        C1031f(Http1Codec http1Codec, long j) throws IOException {
            super();
            this.f1028e = j;
            if (j == 0) {
                m58679a(true, (IOException) null);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.Http1Codec.AbstractC1027b, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: a */
        public long mo58558a(Buffer buffer, long j) throws IOException {
            if (j >= 0) {
                if (!this.f1014b) {
                    long j2 = this.f1028e;
                    if (j2 == 0) {
                        return -1L;
                    }
                    long mo58558a = super.mo58558a(buffer, Math.min(j2, j));
                    if (mo58558a != -1) {
                        long j3 = this.f1028e - mo58558a;
                        this.f1028e = j3;
                        if (j3 == 0) {
                            m58679a(true, (IOException) null);
                        }
                        return mo58558a;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    m58679a(false, (IOException) protocolException);
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1014b) {
                return;
            }
            if (this.f1028e != 0 && !C1061c.m58477a(this, 100, TimeUnit.MILLISECONDS)) {
                m58679a(false, (IOException) null);
            }
            this.f1014b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a$g */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1032g extends AbstractC1027b {

        /* renamed from: e */
        private boolean f1029e;

        C1032g(Http1Codec http1Codec) {
            super();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.Http1Codec.AbstractC1027b, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: a */
        public long mo58558a(Buffer buffer, long j) throws IOException {
            if (j >= 0) {
                if (!this.f1014b) {
                    if (this.f1029e) {
                        return -1L;
                    }
                    long mo58558a = super.mo58558a(buffer, j);
                    if (mo58558a == -1) {
                        this.f1029e = true;
                        m58679a(true, (IOException) null);
                        return -1L;
                    }
                    return mo58558a;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1014b) {
                return;
            }
            if (!this.f1029e) {
                m58679a(false, (IOException) null);
            }
            this.f1014b = true;
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f1007a = okHttpClient;
        this.f1008b = streamAllocation;
        this.f1009c = bufferedSource;
        this.f1010d = bufferedSink;
    }

    /* renamed from: f */
    private String m58680f() throws IOException {
        String mo58907e = this.f1009c.mo58907e(this.f1012f);
        this.f1012f -= mo58907e.length();
        return mo58907e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec
    /* renamed from: a */
    public Sink mo58642a(Request request, long j) {
        if (HttpHeaders.Values.CHUNKED.equalsIgnoreCase(request.m58211a(HttpHeaders.Names.TRANSFER_ENCODING))) {
            return m58683c();
        }
        if (j != -1) {
            return m58688a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec
    /* renamed from: b */
    public void mo58639b() throws IOException {
        this.f1010d.flush();
    }

    /* renamed from: c */
    public Sink m58683c() {
        if (this.f1011e == 1) {
            this.f1011e = 2;
            return new C1028c();
        }
        throw new IllegalStateException("state: " + this.f1011e);
    }

    /* renamed from: d */
    public Source m58682d() throws IOException {
        if (this.f1011e == 4) {
            StreamAllocation streamAllocation = this.f1008b;
            if (streamAllocation != null) {
                this.f1011e = 5;
                streamAllocation.m58692d();
                return new C1032g(this);
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f1011e);
    }

    /* renamed from: e */
    public Headers m58681e() throws IOException {
        Headers.C1076a c1076a = new Headers.C1076a();
        while (true) {
            String m58680f = m58680f();
            if (m58680f.length() != 0) {
                Internal.f891a.mo58232a(c1076a, m58680f);
            } else {
                return c1076a.m58335a();
            }
        }
    }

    /* renamed from: b */
    public Source m58684b(long j) throws IOException {
        if (this.f1011e == 4) {
            this.f1011e = 5;
            return new C1031f(this, j);
        }
        throw new IllegalStateException("state: " + this.f1011e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public abstract class AbstractC1027b implements Source {

        /* renamed from: a */
        protected final ForwardingTimeout f1013a;

        /* renamed from: b */
        protected boolean f1014b;

        /* renamed from: c */
        protected long f1015c;

        private AbstractC1027b() {
            this.f1013a = new ForwardingTimeout(Http1Codec.this.f1009c.mo58555t());
            this.f1015c = 0L;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: a */
        public long mo58558a(Buffer buffer, long j) throws IOException {
            try {
                long mo58558a = Http1Codec.this.f1009c.mo58558a(buffer, j);
                if (mo58558a > 0) {
                    this.f1015c += mo58558a;
                }
                return mo58558a;
            } catch (IOException e) {
                m58679a(false, e);
                throw e;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: t */
        public Timeout mo58555t() {
            return this.f1013a;
        }

        /* renamed from: a */
        protected final void m58679a(boolean z, IOException iOException) throws IOException {
            Http1Codec http1Codec = Http1Codec.this;
            int i = http1Codec.f1011e;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                http1Codec.m58687a(this.f1013a);
                Http1Codec http1Codec2 = Http1Codec.this;
                http1Codec2.f1011e = 6;
                StreamAllocation streamAllocation = http1Codec2.f1008b;
                if (streamAllocation != null) {
                    streamAllocation.m58697a(!z, http1Codec2, this.f1015c, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + Http1Codec.this.f1011e);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec
    /* renamed from: a */
    public void mo58643a(Request request) throws IOException {
        m58686a(request.m58209c(), RequestLine.m58748a(request, this.f1008b.m58695b().mo58410a().m58445b().type()));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec
    /* renamed from: a */
    public ResponseBody mo58644a(Response response) throws IOException {
        StreamAllocation streamAllocation = this.f1008b;
        streamAllocation.f997f.m58349e(streamAllocation.f996e);
        String m58849a = response.m58849a("Content-Type");
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpHeaders.m58765b(response)) {
            return new RealResponseBody(m58849a, 0L, Okio.m58926a(m58684b(0L)));
        }
        if (HttpHeaders.Values.CHUNKED.equalsIgnoreCase(response.m58849a(HttpHeaders.Names.TRANSFER_ENCODING))) {
            return new RealResponseBody(m58849a, -1L, Okio.m58926a(m58685a(response.m58838k().m58205g())));
        }
        long m58771a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpHeaders.m58771a(response);
        if (m58771a != -1) {
            return new RealResponseBody(m58849a, m58771a, Okio.m58926a(m58684b(m58771a)));
        }
        return new RealResponseBody(m58849a, -1L, Okio.m58926a(m58682d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1029d extends AbstractC1027b {

        /* renamed from: e */
        private final HttpUrl f1020e;

        /* renamed from: f */
        private long f1021f;

        /* renamed from: g */
        private boolean f1022g;

        C1029d(HttpUrl httpUrl) {
            super();
            this.f1021f = -1L;
            this.f1022g = true;
            this.f1020e = httpUrl;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.Http1Codec.AbstractC1027b, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: a */
        public long mo58558a(Buffer buffer, long j) throws IOException {
            if (j >= 0) {
                if (!this.f1014b) {
                    if (this.f1022g) {
                        long j2 = this.f1021f;
                        if (j2 == 0 || j2 == -1) {
                            m58678a();
                            if (!this.f1022g) {
                                return -1L;
                            }
                        }
                        long mo58558a = super.mo58558a(buffer, Math.min(j, this.f1021f));
                        if (mo58558a != -1) {
                            this.f1021f -= mo58558a;
                            return mo58558a;
                        }
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        m58679a(false, (IOException) protocolException);
                        throw protocolException;
                    }
                    return -1L;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1014b) {
                return;
            }
            if (this.f1022g && !C1061c.m58477a(this, 100, TimeUnit.MILLISECONDS)) {
                m58679a(false, (IOException) null);
            }
            this.f1014b = true;
        }

        /* renamed from: a */
        private void m58678a() throws IOException {
            if (this.f1021f != -1) {
                Http1Codec.this.f1009c.mo58903v();
            }
            try {
                this.f1021f = Http1Codec.this.f1009c.mo58900y();
                String trim = Http1Codec.this.f1009c.mo58903v().trim();
                if (this.f1021f >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                    if (this.f1021f == 0) {
                        this.f1022g = false;
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpHeaders.m58770a(Http1Codec.this.f1007a.m58259f(), this.f1020e, Http1Codec.this.m58681e());
                        m58679a(true, (IOException) null);
                        return;
                    }
                    return;
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f1021f + trim + "\"");
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec
    /* renamed from: a */
    public void mo58645a() throws IOException {
        this.f1010d.flush();
    }

    /* renamed from: a */
    public void m58686a(Headers headers, String str) throws IOException {
        if (this.f1011e == 0) {
            this.f1010d.mo58918d(str).mo58918d("\r\n");
            int m58338b = headers.m58338b();
            for (int i = 0; i < m58338b; i++) {
                this.f1010d.mo58918d(headers.m58341a(i)).mo58918d(": ").mo58918d(headers.m58337b(i)).mo58918d("\r\n");
            }
            this.f1010d.mo58918d("\r\n");
            this.f1011e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f1011e);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec
    /* renamed from: a */
    public Response.C1017a mo58640a(boolean z) throws IOException {
        int i = this.f1011e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.f1011e);
        }
        try {
            StatusLine m58739a = StatusLine.m58739a(m58680f());
            Response.C1017a m58830a = new Response.C1017a().m58829a(m58739a.f956a).m58835a(m58739a.f957b).m58827a(m58739a.f958c).m58830a(m58681e());
            if (z && m58739a.f957b == 100) {
                return null;
            }
            this.f1011e = 4;
            return m58830a;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f1008b);
            iOException.initCause(e);
            throw iOException;
        }
    }

    /* renamed from: a */
    public Sink m58688a(long j) {
        if (this.f1011e == 1) {
            this.f1011e = 2;
            return new C1030e(j);
        }
        throw new IllegalStateException("state: " + this.f1011e);
    }

    /* renamed from: a */
    public Source m58685a(HttpUrl httpUrl) throws IOException {
        if (this.f1011e == 4) {
            this.f1011e = 5;
            return new C1029d(httpUrl);
        }
        throw new IllegalStateException("state: " + this.f1011e);
    }

    /* renamed from: a */
    void m58687a(ForwardingTimeout forwardingTimeout) {
        Timeout m58934g = forwardingTimeout.m58934g();
        forwardingTimeout.m58935a(Timeout.f846d);
        m58934g.mo58876a();
        m58934g.mo58875b();
    }
}
