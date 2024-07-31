package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Okio;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Address;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Call;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.CertificatePinner;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Connection;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ConnectionPool;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ConnectionSpec;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.EventListener;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Handshake;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.HttpUrl;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.OkHttpClient;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Protocol;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Route;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Version;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.OkHostnameVerifier;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpHeaders;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.Http1Codec;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.ErrorCode;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Codec;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Connection;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Stream;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RealConnection extends Http2Connection.AbstractC1044i implements Connection {

    /* renamed from: b */
    private final ConnectionPool f964b;

    /* renamed from: c */
    private final Route f965c;

    /* renamed from: d */
    private Socket f966d;

    /* renamed from: e */
    private Socket f967e;

    /* renamed from: f */
    private Handshake f968f;

    /* renamed from: g */
    private Protocol f969g;

    /* renamed from: h */
    private Http2Connection f970h;

    /* renamed from: i */
    private BufferedSource f971i;

    /* renamed from: j */
    private BufferedSink f972j;

    /* renamed from: k */
    public boolean f973k;

    /* renamed from: l */
    public int f974l;

    /* renamed from: m */
    public int f975m = 1;

    /* renamed from: n */
    public final List<Reference<StreamAllocation>> f976n = new ArrayList();

    /* renamed from: o */
    public long f977o = Long.MAX_VALUE;

    public RealConnection(ConnectionPool connectionPool, Route route) {
        this.f964b = connectionPool;
        this.f965c = route;
    }

    /* renamed from: e */
    private Request m58722e() {
        return new Request.C1083a().m58201a(this.f965c.m58446a().m58851k()).m58193b("Host", C1061c.m58476a(this.f965c.m58446a().m58851k(), true)).m58193b("Proxy-Connection", "Keep-Alive").m58193b("User-Agent", Version.m58447a()).m58204a();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007d A[Catch: IOException -> 0x00e1, TRY_LEAVE, TryCatch #0 {IOException -> 0x00e1, blocks: (B:16:0x0075, B:18:0x007d), top: B:59:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de A[ORIG_RETURN, RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m58734a(int r16, int r17, int r18, boolean r19, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Call r20, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.EventListener r21) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.RealConnection.m58734a(int, int, int, boolean, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p):void");
    }

    /* renamed from: b */
    public Handshake m58725b() {
        return this.f968f;
    }

    /* renamed from: c */
    public boolean m58724c() {
        return this.f970h != null;
    }

    /* renamed from: d */
    public Socket m58723d() {
        return this.f967e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f965c.m58446a().m58851k().m58307g());
        sb.append(":");
        sb.append(this.f965c.m58446a().m58851k().m58304j());
        sb.append(", proxy=");
        sb.append(this.f965c.m58445b());
        sb.append(" hostAddress=");
        sb.append(this.f965c.m58443d());
        sb.append(" cipherSuite=");
        Handshake handshake = this.f968f;
        sb.append(handshake != null ? handshake.m58345a() : "none");
        sb.append(" protocol=");
        sb.append(this.f969g);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: a */
    private void m58735a(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Request m58722e = m58722e();
        HttpUrl m58205g = m58722e.m58205g();
        for (int i4 = 0; i4 < 21; i4++) {
            m58733a(i, i2, call, eventListener);
            m58722e = m58732a(i2, i3, m58722e, m58205g);
            if (m58722e == null) {
                return;
            }
            C1061c.m58463a(this.f966d);
            this.f966d = null;
            this.f972j = null;
            this.f971i = null;
            eventListener.m58357a(call, this.f965c.m58443d(), this.f965c.m58445b(), null);
        }
    }

    /* renamed from: a */
    private void m58733a(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Proxy m58445b = this.f965c.m58445b();
        this.f966d = (m58445b.type() == Proxy.Type.DIRECT || m58445b.type() == Proxy.Type.HTTP) ? this.f965c.m58446a().m58853i().createSocket() : new Socket(m58445b);
        eventListener.m58358a(call, this.f965c.m58443d(), m58445b);
        this.f966d.setSoTimeout(i2);
        try {
            Platform.m58485b().mo58490a(this.f966d, this.f965c.m58443d(), i);
            try {
                this.f971i = Okio.m58926a(Okio.m58920b(this.f966d));
                this.f972j = Okio.m58927a(Okio.m58921a(this.f966d));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f965c.m58443d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* renamed from: a */
    private void m58729a(ConnectionSpecSelector connectionSpecSelector, Call call, EventListener eventListener) throws IOException {
        if (this.f965c.m58446a().m58852j() == null) {
            this.f969g = Protocol.HTTP_1_1;
            this.f967e = this.f966d;
            return;
        }
        eventListener.m58347g(call);
        m58730a(connectionSpecSelector);
        eventListener.m58363a(call, this.f968f);
        if (this.f969g == Protocol.HTTP_2) {
            this.f967e.setSoTimeout(0);
            Http2Connection m58613a = new Http2Connection.C1043h(true).m58611a(this.f967e, this.f965c.m58446a().m58851k().m58307g(), this.f971i, this.f972j).m58612a(this).m58613a();
            this.f970h = m58613a;
            m58613a.m58617c();
        }
    }

    /* renamed from: a */
    private void m58730a(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        Address m58446a = this.f965c.m58446a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) m58446a.m58852j().createSocket(this.f966d, m58446a.m58851k().m58307g(), m58446a.m58851k().m58304j(), true);
                try {
                    ConnectionSpec m58737a = connectionSpecSelector.m58737a(sSLSocket2);
                    if (m58737a.m58398c()) {
                        Platform.m58485b().mo58487a(sSLSocket2, m58446a.m58851k().m58307g(), m58446a.m58857e());
                    }
                    sSLSocket2.startHandshake();
                    Handshake m58344a = Handshake.m58344a(sSLSocket2.getSession());
                    if (m58446a.m58858d().verify(m58446a.m58851k().m58307g(), sSLSocket2.getSession())) {
                        m58446a.m58862a().m58420a(m58446a.m58851k().m58307g(), m58344a.m58343b());
                        String mo58482b = m58737a.m58398c() ? Platform.m58485b().mo58482b(sSLSocket2) : null;
                        this.f967e = sSLSocket2;
                        this.f971i = Okio.m58926a(Okio.m58920b(sSLSocket2));
                        this.f972j = Okio.m58927a(Okio.m58921a(this.f967e));
                        this.f968f = m58344a;
                        this.f969g = mo58482b != null ? Protocol.m58224a(mo58482b) : Protocol.HTTP_1_1;
                        Platform.m58485b().mo58488a(sSLSocket2);
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) m58344a.m58343b().get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + m58446a.m58851k().m58307g() + " not verified:\n    certificate: " + CertificatePinner.m58419a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.m58778a(x509Certificate));
                } catch (AssertionError e) {
                    e = e;
                    if (!C1061c.m58474a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        Platform.m58485b().mo58488a(sSLSocket);
                    }
                    C1061c.m58463a((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e2) {
            e = e2;
        }
    }

    /* renamed from: a */
    private Request m58732a(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + C1061c.m58476a(httpUrl, true) + " HTTP/1.1";
        while (true) {
            Http1Codec http1Codec = new Http1Codec(null, null, this.f971i, this.f972j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f971i.mo58555t().mo58870a(i, timeUnit);
            this.f972j.mo58560t().mo58870a(i2, timeUnit);
            http1Codec.m58686a(request.m58209c(), str);
            http1Codec.mo58645a();
            Response m58836a = http1Codec.mo58640a(false).m58828a(request).m58836a();
            long m58771a = HttpHeaders.m58771a(m58836a);
            if (m58771a == -1) {
                m58771a = 0;
            }
            Source m58684b = http1Codec.m58684b(m58771a);
            C1061c.m58456b(m58684b, Integer.MAX_VALUE, timeUnit);
            m58684b.close();
            int m58846c = m58836a.m58846c();
            if (m58846c == 200) {
                if (this.f971i.mo58905o().mo58901x() && this.f972j.mo58905o().mo58901x()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (m58846c == 407) {
                Request mo58820a = this.f965c.m58446a().m58855g().mo58820a(this.f965c, m58836a);
                if (mo58820a != null) {
                    if ("close".equalsIgnoreCase(m58836a.m58849a("Connection"))) {
                        return mo58820a;
                    }
                    request = mo58820a;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + m58836a.m58846c());
            }
        }
    }

    /* renamed from: a */
    public boolean m58731a(Address address, Route route) {
        if (this.f976n.size() >= this.f975m || this.f973k || !Internal.f891a.mo58238a(this.f965c.m58446a(), address)) {
            return false;
        }
        if (address.m58851k().m58307g().equals(mo58410a().m58446a().m58851k().m58307g())) {
            return true;
        }
        if (this.f970h != null && route != null && route.m58445b().type() == Proxy.Type.DIRECT && this.f965c.m58445b().type() == Proxy.Type.DIRECT && this.f965c.m58443d().equals(route.m58443d()) && route.m58446a().m58858d() == OkHostnameVerifier.f929a && m58728a(address.m58851k())) {
            try {
                address.m58862a().m58420a(address.m58851k().m58307g(), m58725b().m58343b());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m58728a(HttpUrl httpUrl) {
        if (httpUrl.m58304j() != this.f965c.m58446a().m58851k().m58304j()) {
            return false;
        }
        if (httpUrl.m58307g().equals(this.f965c.m58446a().m58851k().m58307g())) {
            return true;
        }
        return this.f968f != null && OkHostnameVerifier.f929a.m58779a(httpUrl.m58307g(), (X509Certificate) this.f968f.m58343b().get(0));
    }

    /* renamed from: a */
    public HttpCodec m58727a(OkHttpClient okHttpClient, Interceptor.InterfaceC1079a interfaceC1079a, StreamAllocation streamAllocation) throws SocketException {
        Http2Connection http2Connection = this.f970h;
        if (http2Connection != null) {
            return new Http2Codec(okHttpClient, interfaceC1079a, streamAllocation, http2Connection);
        }
        this.f967e.setSoTimeout(interfaceC1079a.mo58270d());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f971i.mo58555t().mo58870a(interfaceC1079a.mo58270d(), timeUnit);
        this.f972j.mo58560t().mo58870a(interfaceC1079a.mo58274a(), timeUnit);
        return new Http1Codec(okHttpClient, streamAllocation, this.f971i, this.f972j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Connection
    /* renamed from: a */
    public Route mo58410a() {
        return this.f965c;
    }

    /* renamed from: a */
    public boolean m58726a(boolean z) {
        if (this.f967e.isClosed() || this.f967e.isInputShutdown() || this.f967e.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.f970h;
        if (http2Connection != null) {
            return !http2Connection.m58636a();
        }
        if (z) {
            try {
                int soTimeout = this.f967e.getSoTimeout();
                try {
                    this.f967e.setSoTimeout(1);
                    return !this.f971i.mo58901x();
                } finally {
                    this.f967e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Connection.AbstractC1044i
    /* renamed from: a */
    public void mo58609a(Http2Stream http2Stream) throws IOException {
        http2Stream.m58578a(ErrorCode.REFUSED_STREAM);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Connection.AbstractC1044i
    /* renamed from: a */
    public void mo58610a(Http2Connection http2Connection) {
        synchronized (this.f964b) {
            this.f975m = http2Connection.m58622b();
        }
    }
}
