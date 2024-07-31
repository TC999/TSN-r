package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ForwardingSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Okio;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Headers;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.OkHttpClient;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Protocol;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ResponseBody;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpHeaders;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.RealResponseBody;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.RequestLine;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.StatusLine;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.StreamAllocation;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Http2Codec implements HttpCodec {

    /* renamed from: e */
    private static final ByteString f1070e;

    /* renamed from: f */
    private static final ByteString f1071f;

    /* renamed from: g */
    private static final ByteString f1072g;

    /* renamed from: h */
    private static final ByteString f1073h;

    /* renamed from: i */
    private static final ByteString f1074i;

    /* renamed from: j */
    private static final ByteString f1075j;

    /* renamed from: k */
    private static final ByteString f1076k;

    /* renamed from: l */
    private static final ByteString f1077l;

    /* renamed from: m */
    private static final List<ByteString> f1078m;

    /* renamed from: n */
    private static final List<ByteString> f1079n;

    /* renamed from: a */
    private final Interceptor.InterfaceC1079a f1080a;

    /* renamed from: b */
    final StreamAllocation f1081b;

    /* renamed from: c */
    private final Http2Connection f1082c;

    /* renamed from: d */
    private Http2Stream f1083d;

    static {
        ByteString m58937c = ByteString.m58937c("connection");
        f1070e = m58937c;
        ByteString m58937c2 = ByteString.m58937c("host");
        f1071f = m58937c2;
        ByteString m58937c3 = ByteString.m58937c("keep-alive");
        f1072g = m58937c3;
        ByteString m58937c4 = ByteString.m58937c("proxy-connection");
        f1073h = m58937c4;
        ByteString m58937c5 = ByteString.m58937c("transfer-encoding");
        f1074i = m58937c5;
        ByteString m58937c6 = ByteString.m58937c("te");
        f1075j = m58937c6;
        ByteString m58937c7 = ByteString.m58937c("encoding");
        f1076k = m58937c7;
        ByteString m58937c8 = ByteString.m58937c("upgrade");
        f1077l = m58937c8;
        f1078m = C1061c.m58458a(m58937c, m58937c2, m58937c3, m58937c4, m58937c6, m58937c5, m58937c7, m58937c8, Header.f1040f, Header.f1041g, Header.f1042h, Header.f1043i);
        f1079n = C1061c.m58458a(m58937c, m58937c2, m58937c3, m58937c4, m58937c6, m58937c5, m58937c7, m58937c8);
    }

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.InterfaceC1079a interfaceC1079a, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        this.f1080a = interfaceC1079a;
        this.f1081b = streamAllocation;
        this.f1082c = http2Connection;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec
    /* renamed from: a */
    public Sink mo58642a(Request request, long j) {
        return this.f1083d.m58572d();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec
    /* renamed from: b */
    public void mo58639b() throws IOException {
        this.f1082c.flush();
    }

    /* renamed from: b */
    public static List<Header> m58638b(Request request) {
        Headers m58209c = request.m58209c();
        ArrayList arrayList = new ArrayList(m58209c.m58338b() + 4);
        arrayList.add(new Header(Header.f1040f, request.m58207e()));
        arrayList.add(new Header(Header.f1041g, RequestLine.m58749a(request.m58205g())));
        String m58211a = request.m58211a("Host");
        if (m58211a != null) {
            arrayList.add(new Header(Header.f1043i, m58211a));
        }
        arrayList.add(new Header(Header.f1042h, request.m58205g().m58301m()));
        int m58338b = m58209c.m58338b();
        for (int i = 0; i < m58338b; i++) {
            ByteString m58937c = ByteString.m58937c(m58209c.m58341a(i).toLowerCase(Locale.US));
            if (!f1078m.contains(m58937c)) {
                arrayList.add(new Header(m58937c, m58209c.m58337b(i)));
            }
        }
        return arrayList;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec
    /* renamed from: a */
    public void mo58643a(Request request) throws IOException {
        if (this.f1083d != null) {
            return;
        }
        Http2Stream m58625a = this.f1082c.m58625a(m58638b(request), request.m58212a() != null);
        this.f1083d = m58625a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        m58625a.m58567h().mo58870a(this.f1080a.mo58270d(), timeUnit);
        this.f1083d.m58563l().mo58870a(this.f1080a.mo58274a(), timeUnit);
    }

    /* compiled from: Http2Codec.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.f$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C1035a extends ForwardingSource {

        /* renamed from: b */
        boolean f1084b;

        /* renamed from: c */
        long f1085c;

        C1035a(Source source) {
            super(source);
            this.f1084b = false;
            this.f1085c = 0L;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: a */
        public long mo58558a(Buffer buffer, long j) throws IOException {
            try {
                long mo58558a = m58936a().mo58558a(buffer, j);
                if (mo58558a > 0) {
                    this.f1085c += mo58558a;
                }
                return mo58558a;
            } catch (IOException e) {
                m58637a(e);
                throw e;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ForwardingSource, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            m58637a(null);
        }

        /* renamed from: a */
        private void m58637a(IOException iOException) {
            if (this.f1084b) {
                return;
            }
            this.f1084b = true;
            Http2Codec http2Codec = Http2Codec.this;
            http2Codec.f1081b.m58697a(false, (HttpCodec) http2Codec, this.f1085c, iOException);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec
    /* renamed from: a */
    public void mo58645a() throws IOException {
        this.f1083d.m58572d().close();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec
    /* renamed from: a */
    public Response.C1017a mo58640a(boolean z) throws IOException {
        Response.C1017a m58641a = m58641a(this.f1083d.m58565j());
        if (z && Internal.f891a.mo58239a(m58641a) == 100) {
            return null;
        }
        return m58641a;
    }

    /* renamed from: a */
    public static Response.C1017a m58641a(List<Header> list) throws IOException {
        Headers.C1076a c1076a = new Headers.C1076a();
        int size = list.size();
        StatusLine statusLine = null;
        for (int i = 0; i < size; i++) {
            Header header = list.get(i);
            if (header == null) {
                if (statusLine != null && statusLine.f957b == 100) {
                    c1076a = new Headers.C1076a();
                    statusLine = null;
                }
            } else {
                ByteString byteString = header.f1044a;
                String mo58878h = header.f1045b.mo58878h();
                if (byteString.equals(Header.f1039e)) {
                    statusLine = StatusLine.m58739a("HTTP/1.1 " + mo58878h);
                } else if (!f1079n.contains(byteString)) {
                    Internal.f891a.mo58231a(c1076a, byteString.mo58878h(), mo58878h);
                }
            }
        }
        if (statusLine != null) {
            return new Response.C1017a().m58829a(Protocol.HTTP_2).m58835a(statusLine.f957b).m58827a(statusLine.f958c).m58830a(c1076a.m58335a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec
    /* renamed from: a */
    public ResponseBody mo58644a(Response response) throws IOException {
        StreamAllocation streamAllocation = this.f1081b;
        streamAllocation.f997f.m58349e(streamAllocation.f996e);
        return new RealResponseBody(response.m58849a("Content-Type"), HttpHeaders.m58771a(response), Okio.m58926a(new C1035a(this.f1083d.m58570e())));
    }
}
