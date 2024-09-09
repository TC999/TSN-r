package com.bytedance.sdk.component.xv.w;

import android.os.Bundle;
import com.bytedance.sdk.component.xv.w.ba;
import com.bytedance.sdk.component.xv.w.fp;
import com.bytedance.sdk.component.xv.w.n;
import com.bytedance.sdk.component.xv.w.s;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class j implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    static final List<ls> f31022c = com.bytedance.sdk.component.xv.w.c.xv.c(ls.HTTP_2, ls.HTTP_1_1);

    /* renamed from: w  reason: collision with root package name */
    static final List<k> f31023w = com.bytedance.sdk.component.xv.w.c.xv.c(k.f31054c, k.xv);

    /* renamed from: a  reason: collision with root package name */
    final xv f31024a;
    final int ba;
    final com.bytedance.sdk.component.xv.w.c.c.f bk;
    final int ck;
    final List<u> ev;

    /* renamed from: f  reason: collision with root package name */
    final List<k> f31025f;
    final com.bytedance.sdk.component.xv.w.c.gd.xv fp;
    final w fz;
    final boolean gb;
    final fp.c gd;

    /* renamed from: i  reason: collision with root package name */
    final p f31026i;
    final HostnameVerifier ia;

    /* renamed from: j  reason: collision with root package name */
    final boolean f31027j;

    /* renamed from: k  reason: collision with root package name */
    final bk f31028k;
    final boolean ls;

    /* renamed from: n  reason: collision with root package name */
    final int f31029n;

    /* renamed from: p  reason: collision with root package name */
    final ProxySelector f31030p;

    /* renamed from: q  reason: collision with root package name */
    final ys f31031q;

    /* renamed from: r  reason: collision with root package name */
    final List<u> f31032r;

    /* renamed from: s  reason: collision with root package name */
    final r f31033s;
    final Proxy sr;

    /* renamed from: t  reason: collision with root package name */
    final SocketFactory f31034t;

    /* renamed from: u  reason: collision with root package name */
    final w f31035u;
    final List<ls> ux;
    final t xv;

    /* renamed from: y  reason: collision with root package name */
    public Set<String> f31036y;
    final SSLSocketFactory ys;

    /* renamed from: z  reason: collision with root package name */
    final int f31037z;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        SocketFactory f31038a;
        public Set<String> ba;
        SSLSocketFactory bk;

        /* renamed from: c  reason: collision with root package name */
        t f31039c;
        int ck;
        public TimeUnit eq;
        ProxySelector ev;

        /* renamed from: f  reason: collision with root package name */
        final List<u> f31040f;
        r fp;
        p fz;
        public int gb;
        bk gd;

        /* renamed from: i  reason: collision with root package name */
        boolean f31041i;
        w ia;

        /* renamed from: j  reason: collision with root package name */
        boolean f31042j;

        /* renamed from: k  reason: collision with root package name */
        com.bytedance.sdk.component.xv.w.c.c.f f31043k;
        public int ls;
        public TimeUnit me;

        /* renamed from: n  reason: collision with root package name */
        public int f31044n;

        /* renamed from: p  reason: collision with root package name */
        xv f31045p;

        /* renamed from: q  reason: collision with root package name */
        boolean f31046q;

        /* renamed from: r  reason: collision with root package name */
        fp.c f31047r;

        /* renamed from: s  reason: collision with root package name */
        w f31048s;
        List<k> sr;

        /* renamed from: t  reason: collision with root package name */
        com.bytedance.sdk.component.xv.w.c.gd.xv f31049t;

        /* renamed from: u  reason: collision with root package name */
        ys f31050u;
        public final List<u> ux;

        /* renamed from: w  reason: collision with root package name */
        Proxy f31051w;
        public List<ls> xv;

        /* renamed from: y  reason: collision with root package name */
        public TimeUnit f31052y;
        HostnameVerifier ys;

        /* renamed from: z  reason: collision with root package name */
        public Bundle f31053z;

        public c() {
            this("");
        }

        public c c(long j4, TimeUnit timeUnit) {
            this.ls = com.bytedance.sdk.component.xv.w.c.xv.c("timeout", j4, timeUnit);
            return this;
        }

        public c w(long j4, TimeUnit timeUnit) {
            this.gb = com.bytedance.sdk.component.xv.w.c.xv.c("timeout", j4, timeUnit);
            return this;
        }

        public c xv(long j4, TimeUnit timeUnit) {
            this.f31044n = com.bytedance.sdk.component.xv.w.c.xv.c("timeout", j4, timeUnit);
            return this;
        }

        public c(String str) {
            this.ux = new ArrayList();
            this.f31040f = new ArrayList();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f31052y = timeUnit;
            this.eq = timeUnit;
            this.me = timeUnit;
            this.f31039c = new t(str);
            this.xv = j.f31022c;
            this.sr = j.f31023w;
            this.f31047r = fp.c(fp.f30999c);
            this.ev = ProxySelector.getDefault();
            this.gd = bk.f30728c;
            this.f31038a = SocketFactory.getDefault();
            this.ys = com.bytedance.sdk.component.xv.w.c.gd.ux.f30782c;
            this.fp = r.f31091c;
            w wVar = w.f31114c;
            this.ia = wVar;
            this.f31048s = wVar;
            this.fz = new p();
            this.f31050u = ys.f31128c;
            this.f31041i = true;
            this.f31046q = true;
            this.f31042j = true;
            this.ls = 10000;
            this.gb = 10000;
            this.f31044n = 10000;
            this.ck = 0;
        }

        public c c(u uVar) {
            if (uVar != null) {
                this.ux.add(uVar);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public c c(Set<String> set) {
            this.ba = set;
            return this;
        }

        public j c() {
            return new j(this);
        }
    }

    static {
        com.bytedance.sdk.component.xv.w.c.c.f30735c = new com.bytedance.sdk.component.xv.w.c.c() { // from class: com.bytedance.sdk.component.xv.w.j.1
            @Override // com.bytedance.sdk.component.xv.w.c.c
            public void c(s.c cVar, String str) {
                cVar.c(str);
            }

            @Override // com.bytedance.sdk.component.xv.w.c.c
            public void w(p pVar, com.bytedance.sdk.component.xv.w.c.w.xv xvVar) {
                pVar.c(xvVar);
            }

            @Override // com.bytedance.sdk.component.xv.w.c.c
            public void c(s.c cVar, String str, String str2) {
                cVar.w(str, str2);
            }

            @Override // com.bytedance.sdk.component.xv.w.c.c
            public boolean c(p pVar, com.bytedance.sdk.component.xv.w.c.w.xv xvVar) {
                return pVar.w(xvVar);
            }

            @Override // com.bytedance.sdk.component.xv.w.c.c
            public com.bytedance.sdk.component.xv.w.c.w.xv c(p pVar, com.bytedance.sdk.component.xv.w.c cVar, com.bytedance.sdk.component.xv.w.c.w.r rVar, eq eqVar) {
                return pVar.c(cVar, rVar, eqVar);
            }

            @Override // com.bytedance.sdk.component.xv.w.c.c
            public boolean c(com.bytedance.sdk.component.xv.w.c cVar, com.bytedance.sdk.component.xv.w.c cVar2) {
                return cVar.c(cVar2);
            }

            @Override // com.bytedance.sdk.component.xv.w.c.c
            public Socket c(p pVar, com.bytedance.sdk.component.xv.w.c cVar, com.bytedance.sdk.component.xv.w.c.w.r rVar) {
                return pVar.c(cVar, rVar);
            }

            @Override // com.bytedance.sdk.component.xv.w.c.c
            public com.bytedance.sdk.component.xv.w.c.w.sr c(p pVar) {
                return pVar.f31074c;
            }

            @Override // com.bytedance.sdk.component.xv.w.c.c
            public int c(ba.c cVar) {
                return cVar.xv;
            }

            @Override // com.bytedance.sdk.component.xv.w.c.c
            public void c(k kVar, SSLSocket sSLSocket, boolean z3) {
                kVar.c(sSLSocket, z3);
            }
        };
    }

    public j() {
        this(new c());
    }

    private SSLSocketFactory c(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e4) {
            throw com.bytedance.sdk.component.xv.w.c.xv.c("No System TLS", (Exception) e4);
        }
    }

    private X509TrustManager gb() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e4) {
            throw com.bytedance.sdk.component.xv.w.c.xv.c("No System TLS", (Exception) e4);
        }
    }

    public r a() {
        return this.f31033s;
    }

    public w bk() {
        return this.f31035u;
    }

    public ys ev() {
        return this.f31031q;
    }

    public bk f() {
        return this.f31028k;
    }

    public boolean fp() {
        return this.f31027j;
    }

    public t fz() {
        return this.xv;
    }

    public SocketFactory gd() {
        return this.f31034t;
    }

    public List<k> i() {
        return this.f31025f;
    }

    public boolean ia() {
        return this.ls;
    }

    public List<u> j() {
        return this.ev;
    }

    public HostnameVerifier k() {
        return this.ia;
    }

    public fp.c ls() {
        return this.gd;
    }

    public SSLSocketFactory p() {
        return this.ys;
    }

    public List<u> q() {
        return this.f31032r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.component.xv.w.c.c.f r() {
        xv xvVar = this.f31024a;
        return xvVar != null ? xvVar.f31115c : this.bk;
    }

    public boolean s() {
        return this.gb;
    }

    public Proxy sr() {
        return this.sr;
    }

    public w t() {
        return this.fz;
    }

    public List<ls> u() {
        return this.ux;
    }

    public ProxySelector ux() {
        return this.f31030p;
    }

    public int w() {
        return this.ck;
    }

    public int xv() {
        return this.f31037z;
    }

    public p ys() {
        return this.f31026i;
    }

    j(c cVar) {
        boolean z3;
        this.xv = cVar.f31039c;
        this.sr = cVar.f31051w;
        this.ux = cVar.xv;
        List<k> list = cVar.sr;
        this.f31025f = list;
        this.f31032r = com.bytedance.sdk.component.xv.w.c.xv.c(cVar.ux);
        this.ev = com.bytedance.sdk.component.xv.w.c.xv.c(cVar.f31040f);
        this.gd = cVar.f31047r;
        this.f31030p = cVar.ev;
        this.f31028k = cVar.gd;
        this.f31024a = cVar.f31045p;
        this.bk = cVar.f31043k;
        this.f31034t = cVar.f31038a;
        this.f31036y = cVar.ba;
        loop0: while (true) {
            for (k kVar : list) {
                z3 = z3 || kVar.c();
            }
        }
        SSLSocketFactory sSLSocketFactory = cVar.bk;
        if (sSLSocketFactory == null && z3) {
            X509TrustManager gb = gb();
            this.ys = c(gb);
            this.fp = com.bytedance.sdk.component.xv.w.c.gd.xv.c(gb);
        } else {
            this.ys = sSLSocketFactory;
            this.fp = cVar.f31049t;
        }
        this.ia = cVar.ys;
        this.f31033s = cVar.fp.c(this.fp);
        this.fz = cVar.ia;
        this.f31035u = cVar.f31048s;
        p pVar = cVar.fz;
        this.f31026i = pVar;
        if (pVar != null) {
            pVar.c(cVar.f31053z);
        }
        this.f31031q = cVar.f31050u;
        this.f31027j = cVar.f31041i;
        this.ls = cVar.f31046q;
        this.gb = cVar.f31042j;
        this.f31029n = cVar.ls;
        this.ck = cVar.gb;
        this.f31037z = cVar.f31044n;
        this.ba = cVar.ck;
        if (!this.f31032r.contains(null)) {
            if (this.ev.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + this.ev);
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + this.f31032r);
    }

    public int c() {
        return this.f31029n;
    }

    public ux c(n nVar) {
        return gb.c(this, nVar, false);
    }

    public boolean c(String str, boolean z3) {
        com.bytedance.sdk.component.xv.w.c.w.xv c4;
        try {
            n.c cVar = new n.c();
            cVar.c(str);
            synchronized (this.f31026i) {
                c4 = com.bytedance.sdk.component.xv.w.c.c.f30735c.c(this.f31026i, c(cVar.c().c()), null, null);
            }
            if (c4 == null) {
                return false;
            }
            if (c4.f30938w == 0) {
                return true;
            }
            return c4.c(z3);
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    private com.bytedance.sdk.component.xv.w.c c(fz fzVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        r rVar;
        if (fzVar.sr()) {
            SSLSocketFactory p3 = p();
            hostnameVerifier = k();
            sSLSocketFactory = p3;
            rVar = a();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            rVar = null;
        }
        return new com.bytedance.sdk.component.xv.w.c(fzVar.r(), fzVar.ev(), ev(), gd(), sSLSocketFactory, hostnameVerifier, rVar, t(), sr(), u(), i(), ux());
    }
}
