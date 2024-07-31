package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Call;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.EventListener;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Headers;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.InternalCache;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.CertificateChainCleaner;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.OkHostnameVerifier;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.RealConnection;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.RouteDatabase;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.StreamAllocation;
import com.clj.fastble.BleManager;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class OkHttpClient implements Cloneable, Call.InterfaceC1065a, WebSocket {

    /* renamed from: A */
    static final List<Protocol> f1386A = C1061c.m58458a(Protocol.HTTP_2, Protocol.HTTP_1_1);

    /* renamed from: B */
    static final List<ConnectionSpec> f1387B = C1061c.m58458a(ConnectionSpec.f1319f, ConnectionSpec.f1320g);

    /* renamed from: a */
    final Dispatcher f1388a;

    /* renamed from: b */
    final Proxy f1389b;

    /* renamed from: c */
    final List<Protocol> f1390c;

    /* renamed from: d */
    final List<ConnectionSpec> f1391d;

    /* renamed from: e */
    final List<Interceptor> f1392e;

    /* renamed from: f */
    final List<Interceptor> f1393f;

    /* renamed from: g */
    final EventListener.InterfaceC1075c f1394g;

    /* renamed from: h */
    final ProxySelector f1395h;

    /* renamed from: i */
    final CookieJar f1396i;

    /* renamed from: j */
    final Cache f1397j;

    /* renamed from: k */
    final InternalCache f1398k;

    /* renamed from: l */
    final SocketFactory f1399l;

    /* renamed from: m */
    final SSLSocketFactory f1400m;

    /* renamed from: n */
    final CertificateChainCleaner f1401n;

    /* renamed from: o */
    final HostnameVerifier f1402o;

    /* renamed from: p */
    final CertificatePinner f1403p;

    /* renamed from: q */
    final Authenticator f1404q;

    /* renamed from: r */
    final Authenticator f1405r;

    /* renamed from: s */
    final ConnectionPool f1406s;

    /* renamed from: t */
    final Dns f1407t;

    /* renamed from: u */
    final boolean f1408u;

    /* renamed from: v */
    final boolean f1409v;

    /* renamed from: w */
    final boolean f1410w;

    /* renamed from: x */
    final int f1411x;

    /* renamed from: y */
    final int f1412y;

    /* renamed from: z */
    final int f1413z;

    /* compiled from: OkHttpClient.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1080a extends Internal {
        C1080a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal
        /* renamed from: a */
        public void mo58232a(Headers.C1076a c1076a, String str) {
            c1076a.m58334a(str);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal
        /* renamed from: b */
        public void mo58230b(ConnectionPool connectionPool, RealConnection realConnection) {
            connectionPool.m58404b(realConnection);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal
        /* renamed from: a */
        public void mo58231a(Headers.C1076a c1076a, String str, String str2) {
            c1076a.m58331b(str, str2);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal
        /* renamed from: a */
        public boolean mo58234a(ConnectionPool connectionPool, RealConnection realConnection) {
            return connectionPool.m58406a(realConnection);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal
        /* renamed from: a */
        public RealConnection mo58235a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
            return connectionPool.m58407a(address, streamAllocation, route);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal
        /* renamed from: a */
        public boolean mo58238a(Address address, Address address2) {
            return address.m58861a(address2);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal
        /* renamed from: a */
        public Socket mo58236a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
            return connectionPool.m58408a(address, streamAllocation);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal
        /* renamed from: a */
        public RouteDatabase mo58237a(ConnectionPool connectionPool) {
            return connectionPool.f1315e;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal
        /* renamed from: a */
        public int mo58239a(Response.C1017a c1017a) {
            return c1017a.f877c;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal
        /* renamed from: a */
        public void mo58233a(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
            connectionSpec.m58401a(sSLSocket, z);
        }
    }

    /* compiled from: OkHttpClient.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1081b {

        /* renamed from: A */
        int f1414A;

        /* renamed from: b */
        Proxy f1416b;

        /* renamed from: j */
        Cache f1424j;

        /* renamed from: k */
        InternalCache f1425k;

        /* renamed from: m */
        SSLSocketFactory f1427m;

        /* renamed from: n */
        CertificateChainCleaner f1428n;

        /* renamed from: q */
        Authenticator f1431q;

        /* renamed from: r */
        Authenticator f1432r;

        /* renamed from: s */
        ConnectionPool f1433s;

        /* renamed from: t */
        Dns f1434t;

        /* renamed from: u */
        boolean f1435u;

        /* renamed from: v */
        boolean f1436v;

        /* renamed from: w */
        boolean f1437w;

        /* renamed from: x */
        int f1438x;

        /* renamed from: y */
        int f1439y;

        /* renamed from: z */
        int f1440z;

        /* renamed from: e */
        final List<Interceptor> f1419e = new ArrayList();

        /* renamed from: f */
        final List<Interceptor> f1420f = new ArrayList();

        /* renamed from: a */
        Dispatcher f1415a = new Dispatcher();

        /* renamed from: c */
        List<Protocol> f1417c = OkHttpClient.f1386A;

        /* renamed from: d */
        List<ConnectionSpec> f1418d = OkHttpClient.f1387B;

        /* renamed from: g */
        EventListener.InterfaceC1075c f1421g = EventListener.m58355a(EventListener.f1351a);

        /* renamed from: h */
        ProxySelector f1422h = ProxySelector.getDefault();

        /* renamed from: i */
        CookieJar f1423i = CookieJar.f1342a;

        /* renamed from: l */
        SocketFactory f1426l = SocketFactory.getDefault();

        /* renamed from: o */
        HostnameVerifier f1429o = OkHostnameVerifier.f929a;

        /* renamed from: p */
        CertificatePinner f1430p = CertificatePinner.f1283c;

        public C1081b() {
            Authenticator authenticator = Authenticator.f887a;
            this.f1431q = authenticator;
            this.f1432r = authenticator;
            this.f1433s = new ConnectionPool();
            this.f1434t = Dns.f1350a;
            this.f1435u = true;
            this.f1436v = true;
            this.f1437w = true;
            this.f1438x = BleManager.f22896l;
            this.f1439y = BleManager.f22896l;
            this.f1440z = BleManager.f22896l;
            this.f1414A = 0;
        }

        /* renamed from: a */
        public C1081b m58228a(long j, TimeUnit timeUnit) {
            this.f1438x = C1061c.m58467a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: b */
        public C1081b m58226b(long j, TimeUnit timeUnit) {
            this.f1439y = C1061c.m58467a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: c */
        public C1081b m58225c(long j, TimeUnit timeUnit) {
            this.f1440z = C1061c.m58467a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: a */
        public C1081b m58227a(Interceptor interceptor) {
            if (interceptor != null) {
                this.f1419e.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        /* renamed from: a */
        public OkHttpClient m58229a() {
            return new OkHttpClient(this);
        }
    }

    static {
        Internal.f891a = new C1080a();
    }

    public OkHttpClient() {
        this(new C1081b());
    }

    /* renamed from: a */
    private SSLSocketFactory m58264a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw C1061c.m58466a("No System TLS", (Exception) e);
        }
    }

    /* renamed from: y */
    private X509TrustManager m58240y() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw C1061c.m58466a("No System TLS", (Exception) e);
        }
    }

    /* renamed from: b */
    public CertificatePinner m58263b() {
        return this.f1403p;
    }

    /* renamed from: c */
    public int m58262c() {
        return this.f1411x;
    }

    /* renamed from: d */
    public ConnectionPool m58261d() {
        return this.f1406s;
    }

    /* renamed from: e */
    public List<ConnectionSpec> m58260e() {
        return this.f1391d;
    }

    /* renamed from: f */
    public CookieJar m58259f() {
        return this.f1396i;
    }

    /* renamed from: g */
    public Dispatcher m58258g() {
        return this.f1388a;
    }

    /* renamed from: h */
    public Dns m58257h() {
        return this.f1407t;
    }

    /* renamed from: i */
    public EventListener.InterfaceC1075c m58256i() {
        return this.f1394g;
    }

    /* renamed from: j */
    public boolean m58255j() {
        return this.f1409v;
    }

    /* renamed from: k */
    public boolean m58254k() {
        return this.f1408u;
    }

    /* renamed from: l */
    public HostnameVerifier m58253l() {
        return this.f1402o;
    }

    /* renamed from: m */
    public List<Interceptor> m58252m() {
        return this.f1392e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public InternalCache m58251n() {
        Cache cache = this.f1397j;
        return cache != null ? cache.f1251a : this.f1398k;
    }

    /* renamed from: o */
    public List<Interceptor> m58250o() {
        return this.f1393f;
    }

    /* renamed from: p */
    public List<Protocol> m58249p() {
        return this.f1390c;
    }

    /* renamed from: q */
    public Proxy m58248q() {
        return this.f1389b;
    }

    /* renamed from: r */
    public Authenticator m58247r() {
        return this.f1404q;
    }

    /* renamed from: s */
    public ProxySelector m58246s() {
        return this.f1395h;
    }

    /* renamed from: t */
    public int m58245t() {
        return this.f1412y;
    }

    /* renamed from: u */
    public boolean m58244u() {
        return this.f1410w;
    }

    /* renamed from: v */
    public SocketFactory m58243v() {
        return this.f1399l;
    }

    /* renamed from: w */
    public SSLSocketFactory m58242w() {
        return this.f1400m;
    }

    /* renamed from: x */
    public int m58241x() {
        return this.f1413z;
    }

    OkHttpClient(C1081b c1081b) {
        boolean z;
        this.f1388a = c1081b.f1415a;
        this.f1389b = c1081b.f1416b;
        this.f1390c = c1081b.f1417c;
        List<ConnectionSpec> list = c1081b.f1418d;
        this.f1391d = list;
        this.f1392e = C1061c.m58460a(c1081b.f1419e);
        this.f1393f = C1061c.m58460a(c1081b.f1420f);
        this.f1394g = c1081b.f1421g;
        this.f1395h = c1081b.f1422h;
        this.f1396i = c1081b.f1423i;
        this.f1397j = c1081b.f1424j;
        this.f1398k = c1081b.f1425k;
        this.f1399l = c1081b.f1426l;
        loop0: while (true) {
            for (ConnectionSpec connectionSpec : list) {
                z = z || connectionSpec.m58400b();
            }
        }
        SSLSocketFactory sSLSocketFactory = c1081b.f1427m;
        if (sSLSocketFactory == null && z) {
            X509TrustManager m58240y = m58240y();
            this.f1400m = m58264a(m58240y);
            this.f1401n = CertificateChainCleaner.m58789a(m58240y);
        } else {
            this.f1400m = sSLSocketFactory;
            this.f1401n = c1081b.f1428n;
        }
        this.f1402o = c1081b.f1429o;
        this.f1403p = c1081b.f1430p.m58422a(this.f1401n);
        this.f1404q = c1081b.f1431q;
        this.f1405r = c1081b.f1432r;
        this.f1406s = c1081b.f1433s;
        this.f1407t = c1081b.f1434t;
        this.f1408u = c1081b.f1435u;
        this.f1409v = c1081b.f1436v;
        this.f1410w = c1081b.f1437w;
        this.f1411x = c1081b.f1438x;
        this.f1412y = c1081b.f1439y;
        this.f1413z = c1081b.f1440z;
        if (!this.f1392e.contains(null)) {
            if (this.f1393f.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + this.f1393f);
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + this.f1392e);
    }

    /* renamed from: a */
    public Authenticator m58266a() {
        return this.f1405r;
    }

    /* renamed from: a */
    public Call m58265a(Request request) {
        return RealCall.m58220a(this, request, false);
    }
}
