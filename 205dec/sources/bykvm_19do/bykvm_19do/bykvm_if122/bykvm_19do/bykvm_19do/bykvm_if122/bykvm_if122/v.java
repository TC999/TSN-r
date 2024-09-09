package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
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

/* compiled from: OkHttpClient.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class v implements Cloneable, e.a, e0 {
    static final List<w> A = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(w.HTTP_2, w.HTTP_1_1);
    static final List<k> B = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(k.f1312f, k.f1313g);

    /* renamed from: a  reason: collision with root package name */
    final n f1379a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f1380b;

    /* renamed from: c  reason: collision with root package name */
    final List<w> f1381c;

    /* renamed from: d  reason: collision with root package name */
    final List<k> f1382d;

    /* renamed from: e  reason: collision with root package name */
    final List<t> f1383e;

    /* renamed from: f  reason: collision with root package name */
    final List<t> f1384f;

    /* renamed from: g  reason: collision with root package name */
    final p.c f1385g;

    /* renamed from: h  reason: collision with root package name */
    final ProxySelector f1386h;

    /* renamed from: i  reason: collision with root package name */
    final m f1387i;

    /* renamed from: j  reason: collision with root package name */
    final c f1388j;

    /* renamed from: k  reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.d f1389k;

    /* renamed from: l  reason: collision with root package name */
    final SocketFactory f1390l;

    /* renamed from: m  reason: collision with root package name */
    final SSLSocketFactory f1391m;

    /* renamed from: n  reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c f1392n;

    /* renamed from: o  reason: collision with root package name */
    final HostnameVerifier f1393o;

    /* renamed from: p  reason: collision with root package name */
    final g f1394p;

    /* renamed from: q  reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b f1395q;

    /* renamed from: r  reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b f1396r;

    /* renamed from: s  reason: collision with root package name */
    final j f1397s;

    /* renamed from: t  reason: collision with root package name */
    final o f1398t;

    /* renamed from: u  reason: collision with root package name */
    final boolean f1399u;

    /* renamed from: v  reason: collision with root package name */
    final boolean f1400v;

    /* renamed from: w  reason: collision with root package name */
    final boolean f1401w;

    /* renamed from: x  reason: collision with root package name */
    final int f1402x;

    /* renamed from: y  reason: collision with root package name */
    final int f1403y;

    /* renamed from: z  reason: collision with root package name */
    final int f1404z;

    /* compiled from: OkHttpClient.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class a extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a {
        a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public void a(r.a aVar, String str) {
            aVar.a(str);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public void b(j jVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar) {
            jVar.b(cVar);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public void a(r.a aVar, String str, String str2) {
            aVar.b(str, str2);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public boolean a(j jVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar) {
            return jVar.a(cVar);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c a(j jVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, c0 c0Var) {
            return jVar.a(aVar, gVar, c0Var);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public boolean a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar2) {
            return aVar.a(aVar2);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public Socket a(j jVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar) {
            return jVar.a(aVar, gVar);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.d a(j jVar) {
            return jVar.f1308e;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public int a(a0.a aVar) {
            return aVar.f870c;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public void a(k kVar, SSLSocket sSLSocket, boolean z3) {
            kVar.a(sSLSocket, z3);
        }
    }

    /* compiled from: OkHttpClient.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static final class b {
        int A;

        /* renamed from: b  reason: collision with root package name */
        Proxy f1406b;

        /* renamed from: j  reason: collision with root package name */
        c f1414j;

        /* renamed from: k  reason: collision with root package name */
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.d f1415k;

        /* renamed from: m  reason: collision with root package name */
        SSLSocketFactory f1417m;

        /* renamed from: n  reason: collision with root package name */
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c f1418n;

        /* renamed from: q  reason: collision with root package name */
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b f1421q;

        /* renamed from: r  reason: collision with root package name */
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b f1422r;

        /* renamed from: s  reason: collision with root package name */
        j f1423s;

        /* renamed from: t  reason: collision with root package name */
        o f1424t;

        /* renamed from: u  reason: collision with root package name */
        boolean f1425u;

        /* renamed from: v  reason: collision with root package name */
        boolean f1426v;

        /* renamed from: w  reason: collision with root package name */
        boolean f1427w;

        /* renamed from: x  reason: collision with root package name */
        int f1428x;

        /* renamed from: y  reason: collision with root package name */
        int f1429y;

        /* renamed from: z  reason: collision with root package name */
        int f1430z;

        /* renamed from: e  reason: collision with root package name */
        final List<t> f1409e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        final List<t> f1410f = new ArrayList();

        /* renamed from: a  reason: collision with root package name */
        n f1405a = new n();

        /* renamed from: c  reason: collision with root package name */
        List<w> f1407c = v.A;

        /* renamed from: d  reason: collision with root package name */
        List<k> f1408d = v.B;

        /* renamed from: g  reason: collision with root package name */
        p.c f1411g = p.a(p.f1344a);

        /* renamed from: h  reason: collision with root package name */
        ProxySelector f1412h = ProxySelector.getDefault();

        /* renamed from: i  reason: collision with root package name */
        m f1413i = m.f1335a;

        /* renamed from: l  reason: collision with root package name */
        SocketFactory f1416l = SocketFactory.getDefault();

        /* renamed from: o  reason: collision with root package name */
        HostnameVerifier f1419o = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.e.f922a;

        /* renamed from: p  reason: collision with root package name */
        g f1420p = g.f1276c;

        public b() {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b bVar = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.f880a;
            this.f1421q = bVar;
            this.f1422r = bVar;
            this.f1423s = new j();
            this.f1424t = o.f1343a;
            this.f1425u = true;
            this.f1426v = true;
            this.f1427w = true;
            this.f1428x = 10000;
            this.f1429y = 10000;
            this.f1430z = 10000;
            this.A = 0;
        }

        public b a(long j4, TimeUnit timeUnit) {
            this.f1428x = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("timeout", j4, timeUnit);
            return this;
        }

        public b b(long j4, TimeUnit timeUnit) {
            this.f1429y = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("timeout", j4, timeUnit);
            return this;
        }

        public b c(long j4, TimeUnit timeUnit) {
            this.f1430z = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("timeout", j4, timeUnit);
            return this;
        }

        public b a(t tVar) {
            if (tVar != null) {
                this.f1409e.add(tVar);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public v a() {
            return new v(this);
        }
    }

    static {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a = new a();
    }

    public v() {
        this(new b());
    }

    private SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e4) {
            throw bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("No System TLS", (Exception) e4);
        }
    }

    private X509TrustManager y() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e4) {
            throw bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("No System TLS", (Exception) e4);
        }
    }

    public g b() {
        return this.f1394p;
    }

    public int c() {
        return this.f1402x;
    }

    public j d() {
        return this.f1397s;
    }

    public List<k> e() {
        return this.f1382d;
    }

    public m f() {
        return this.f1387i;
    }

    public n g() {
        return this.f1379a;
    }

    public o h() {
        return this.f1398t;
    }

    public p.c i() {
        return this.f1385g;
    }

    public boolean j() {
        return this.f1400v;
    }

    public boolean k() {
        return this.f1399u;
    }

    public HostnameVerifier l() {
        return this.f1393o;
    }

    public List<t> m() {
        return this.f1383e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.d n() {
        c cVar = this.f1388j;
        return cVar != null ? cVar.f1244a : this.f1389k;
    }

    public List<t> o() {
        return this.f1384f;
    }

    public List<w> p() {
        return this.f1381c;
    }

    public Proxy q() {
        return this.f1380b;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b r() {
        return this.f1395q;
    }

    public ProxySelector s() {
        return this.f1386h;
    }

    public int t() {
        return this.f1403y;
    }

    public boolean u() {
        return this.f1401w;
    }

    public SocketFactory v() {
        return this.f1390l;
    }

    public SSLSocketFactory w() {
        return this.f1391m;
    }

    public int x() {
        return this.f1404z;
    }

    v(b bVar) {
        boolean z3;
        this.f1379a = bVar.f1405a;
        this.f1380b = bVar.f1406b;
        this.f1381c = bVar.f1407c;
        List<k> list = bVar.f1408d;
        this.f1382d = list;
        this.f1383e = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bVar.f1409e);
        this.f1384f = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bVar.f1410f);
        this.f1385g = bVar.f1411g;
        this.f1386h = bVar.f1412h;
        this.f1387i = bVar.f1413i;
        this.f1388j = bVar.f1414j;
        this.f1389k = bVar.f1415k;
        this.f1390l = bVar.f1416l;
        loop0: while (true) {
            for (k kVar : list) {
                z3 = z3 || kVar.b();
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.f1417m;
        if (sSLSocketFactory == null && z3) {
            X509TrustManager y3 = y();
            this.f1391m = a(y3);
            this.f1392n = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c.a(y3);
        } else {
            this.f1391m = sSLSocketFactory;
            this.f1392n = bVar.f1418n;
        }
        this.f1393o = bVar.f1419o;
        this.f1394p = bVar.f1420p.a(this.f1392n);
        this.f1395q = bVar.f1421q;
        this.f1396r = bVar.f1422r;
        this.f1397s = bVar.f1423s;
        this.f1398t = bVar.f1424t;
        this.f1399u = bVar.f1425u;
        this.f1400v = bVar.f1426v;
        this.f1401w = bVar.f1427w;
        this.f1402x = bVar.f1428x;
        this.f1403y = bVar.f1429y;
        this.f1404z = bVar.f1430z;
        if (!this.f1383e.contains(null)) {
            if (this.f1384f.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + this.f1384f);
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + this.f1383e);
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b a() {
        return this.f1396r;
    }

    public e a(y yVar) {
        return x.a(this, yVar, false);
    }
}
