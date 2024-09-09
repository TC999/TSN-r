package com.bytedance.sdk.component.xv.w.c.w;

import com.bytedance.sdk.component.xv.c.a;
import com.bytedance.sdk.component.xv.w.ba;
import com.bytedance.sdk.component.xv.w.c.ux.r;
import com.bytedance.sdk.component.xv.w.eq;
import com.bytedance.sdk.component.xv.w.fp;
import com.bytedance.sdk.component.xv.w.fz;
import com.bytedance.sdk.component.xv.w.gd;
import com.bytedance.sdk.component.xv.w.ia;
import com.bytedance.sdk.component.xv.w.j;
import com.bytedance.sdk.component.xv.w.k;
import com.bytedance.sdk.component.xv.w.ls;
import com.bytedance.sdk.component.xv.w.n;
import com.bytedance.sdk.component.xv.w.p;
import com.bytedance.sdk.component.xv.w.u;
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

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class xv extends r.w implements gd {

    /* renamed from: a  reason: collision with root package name */
    private ls f30932a;
    private com.bytedance.sdk.component.xv.w.c.ux.r bk;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30933c;
    private final eq ev;
    private Socket gd;

    /* renamed from: k  reason: collision with root package name */
    private ia f30934k;

    /* renamed from: p  reason: collision with root package name */
    private Socket f30935p;

    /* renamed from: r  reason: collision with root package name */
    private final p f30936r;

    /* renamed from: t  reason: collision with root package name */
    private com.bytedance.sdk.component.xv.c.ux f30937t;

    /* renamed from: w  reason: collision with root package name */
    public int f30938w;
    private com.bytedance.sdk.component.xv.c.sr ys;
    public int xv = 1;
    public final List<Reference<r>> sr = new ArrayList();
    public long ux = Long.MAX_VALUE;

    public xv(p pVar, eq eqVar) {
        this.f30936r = pVar;
        this.ev = eqVar;
    }

    private n f() {
        return new n.c().c(this.ev.c().c()).c("Host", com.bytedance.sdk.component.xv.w.c.xv.c(this.ev.c().c(), true)).c("Proxy-Connection", "Keep-Alive").c("User-Agent", com.bytedance.sdk.component.xv.w.c.sr.c()).c();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007d A[Catch: IOException -> 0x00e1, TRY_LEAVE, TryCatch #0 {IOException -> 0x00e1, blocks: (B:16:0x0075, B:18:0x007d), top: B:59:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(int r16, int r17, int r18, boolean r19, com.bytedance.sdk.component.xv.w.ux r20, com.bytedance.sdk.component.xv.w.fp r21) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.w.c.w.xv.c(int, int, int, boolean, com.bytedance.sdk.component.xv.w.ux, com.bytedance.sdk.component.xv.w.fp):void");
    }

    public ia sr() {
        return this.f30934k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.ev.c().c().r());
        sb.append(":");
        sb.append(this.ev.c().c().ev());
        sb.append(", proxy=");
        sb.append(this.ev.w());
        sb.append(" hostAddress=");
        sb.append(this.ev.xv());
        sb.append(" cipherSuite=");
        ia iaVar = this.f30934k;
        sb.append(iaVar != null ? iaVar.w() : "none");
        sb.append(" protocol=");
        sb.append(this.f30932a);
        sb.append('}');
        return sb.toString();
    }

    public boolean ux() {
        return this.bk != null;
    }

    public void w() {
        com.bytedance.sdk.component.xv.w.c.xv.c(this.gd);
    }

    public Socket xv() {
        return this.f30935p;
    }

    private void c(int i4, int i5, int i6, com.bytedance.sdk.component.xv.w.ux uxVar, fp fpVar) throws IOException {
        n f4 = f();
        fz c4 = f4.c();
        for (int i7 = 0; i7 < 21; i7++) {
            c(i4, i5, uxVar, fpVar);
            f4 = c(i5, i6, f4, c4);
            if (f4 == null) {
                return;
            }
            com.bytedance.sdk.component.xv.w.c.xv.c(this.gd);
            this.gd = null;
            this.ys = null;
            this.f30937t = null;
            fpVar.c(uxVar, this.ev.xv(), this.ev.w(), null);
        }
    }

    private void c(int i4, int i5, com.bytedance.sdk.component.xv.w.ux uxVar, fp fpVar) throws IOException {
        Proxy w3 = this.ev.w();
        this.gd = (w3.type() == Proxy.Type.DIRECT || w3.type() == Proxy.Type.HTTP) ? this.ev.c().xv().createSocket() : new Socket(w3);
        fpVar.c(uxVar, this.ev.xv(), w3);
        this.gd.setSoTimeout(i5);
        try {
            com.bytedance.sdk.component.xv.w.c.r.ux.w().c(this.gd, this.ev.xv(), i4);
            try {
                this.f30937t = a.c(a.w(this.gd));
                this.ys = a.c(a.c(this.gd));
            } catch (NullPointerException e4) {
                if ("throw with null exception".equals(e4.getMessage())) {
                    throw new IOException(e4);
                }
            }
        } catch (ConnectException e5) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.ev.xv());
            connectException.initCause(e5);
            throw connectException;
        }
    }

    private void c(w wVar, com.bytedance.sdk.component.xv.w.ux uxVar, fp fpVar) throws IOException {
        if (this.ev.c().gd() == null) {
            this.f30932a = ls.HTTP_1_1;
            this.f30935p = this.gd;
            return;
        }
        fpVar.w(uxVar);
        c(wVar);
        fpVar.c(uxVar, this.f30934k);
        try {
            if (this.f30932a == ls.HTTP_2) {
                this.f30935p.setSoTimeout(0);
                com.bytedance.sdk.component.xv.w.c.ux.r c4 = new r.c(true).c(this.f30935p, this.ev.c().c().r(), this.f30937t, this.ys).c(this).c();
                this.bk = c4;
                c4.xv();
            }
        } catch (Throwable unused) {
        }
    }

    private void c(w wVar) throws IOException {
        com.bytedance.sdk.component.xv.w.c c4 = this.ev.c();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) c4.gd().createSocket(this.gd, c4.c().r(), c4.c().ev(), true);
                try {
                    k c5 = wVar.c(sSLSocket2);
                    if (c5.sr()) {
                        com.bytedance.sdk.component.xv.w.c.r.ux.w().c(sSLSocket2, c4.c().r(), c4.ux());
                    }
                    try {
                        sSLSocket2.startHandshake();
                    } catch (Throwable unused) {
                    }
                    ia c6 = ia.c(sSLSocket2.getSession());
                    if (c4.p().verify(c4.c().r(), sSLSocket2.getSession())) {
                        c4.k().c(c4.c().r(), c6.xv());
                        String c7 = c5.sr() ? com.bytedance.sdk.component.xv.w.c.r.ux.w().c(sSLSocket2) : null;
                        this.f30935p = sSLSocket2;
                        this.f30937t = a.c(a.w(sSLSocket2));
                        this.ys = a.c(a.c(this.f30935p));
                        this.f30934k = c6;
                        this.f30932a = c7 != null ? ls.c(c7) : ls.HTTP_1_1;
                        com.bytedance.sdk.component.xv.w.c.r.ux.w().w(sSLSocket2);
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) c6.xv().get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + c4.c().r() + " not verified:\n    certificate: " + com.bytedance.sdk.component.xv.w.r.c((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.component.xv.w.c.gd.ux.c(x509Certificate));
                } catch (AssertionError e4) {
                    e = e4;
                    if (!com.bytedance.sdk.component.xv.w.c.xv.c(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        com.bytedance.sdk.component.xv.w.c.r.ux.w().w(sSLSocket);
                    }
                    com.bytedance.sdk.component.xv.w.c.xv.c((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e5) {
            e = e5;
        }
    }

    private n c(int i4, int i5, n nVar, fz fzVar) throws IOException {
        String str = "CONNECT " + com.bytedance.sdk.component.xv.w.c.xv.c(fzVar, true) + " HTTP/1.1";
        while (true) {
            com.bytedance.sdk.component.xv.w.c.sr.c cVar = new com.bytedance.sdk.component.xv.w.c.sr.c(null, null, this.f30937t, this.ys);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f30937t.c().c(i4, timeUnit);
            this.ys.c().c(i5, timeUnit);
            cVar.c(nVar.xv(), str);
            cVar.w();
            ba c4 = cVar.c(false).c(nVar).c();
            long c5 = com.bytedance.sdk.component.xv.w.c.xv.ux.c(c4);
            if (c5 == -1) {
                c5 = 0;
            }
            com.bytedance.sdk.component.xv.c.fz w3 = cVar.w(c5);
            com.bytedance.sdk.component.xv.w.c.xv.w(w3, Integer.MAX_VALUE, timeUnit);
            w3.close();
            int xv = c4.xv();
            if (xv == 200) {
                if (this.f30937t.xv().ux() && this.ys.xv().ux()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (xv == 407) {
                n c6 = this.ev.c().sr().c(this.ev, c4);
                if (c6 != null) {
                    if ("close".equalsIgnoreCase(c4.c("Connection"))) {
                        return c6;
                    }
                    nVar = c6;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + c4.xv());
            }
        }
    }

    public boolean c(com.bytedance.sdk.component.xv.w.c cVar, eq eqVar) {
        if (this.sr.size() >= this.xv || this.f30933c || !com.bytedance.sdk.component.xv.w.c.c.f30735c.c(this.ev.c(), cVar)) {
            return false;
        }
        if (cVar.c().r().equals(c().c().c().r())) {
            return true;
        }
        if (this.bk != null && eqVar != null && eqVar.w().type() == Proxy.Type.DIRECT && this.ev.w().type() == Proxy.Type.DIRECT && this.ev.xv().equals(eqVar.xv()) && eqVar.c().p() == com.bytedance.sdk.component.xv.w.c.gd.ux.f30782c && c(cVar.c())) {
            try {
                cVar.k().c(cVar.c().r(), sr().xv());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean c(fz fzVar) {
        if (fzVar.ev() != this.ev.c().c().ev()) {
            return false;
        }
        if (fzVar.r().equals(this.ev.c().c().r())) {
            return true;
        }
        return this.f30934k != null && com.bytedance.sdk.component.xv.w.c.gd.ux.f30782c.c(fzVar.r(), (X509Certificate) this.f30934k.xv().get(0));
    }

    public com.bytedance.sdk.component.xv.w.c.xv.xv c(j jVar, u.c cVar, r rVar) throws SocketException {
        if (this.bk != null) {
            return new com.bytedance.sdk.component.xv.w.c.ux.f(jVar, cVar, rVar, this.bk);
        }
        this.f30935p.setSoTimeout(cVar.xv());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f30937t.c().c(cVar.xv(), timeUnit);
        this.ys.c().c(cVar.sr(), timeUnit);
        return new com.bytedance.sdk.component.xv.w.c.sr.c(jVar, rVar, this.f30937t, this.ys);
    }

    @Override // com.bytedance.sdk.component.xv.w.gd
    public eq c() {
        return this.ev;
    }

    public boolean c(boolean z3) {
        if (this.f30935p.isClosed() || this.f30935p.isInputShutdown() || this.f30935p.isOutputShutdown()) {
            return false;
        }
        com.bytedance.sdk.component.xv.w.c.ux.r rVar = this.bk;
        if (rVar != null) {
            return !rVar.sr();
        }
        if (z3) {
            try {
                int soTimeout = this.f30935p.getSoTimeout();
                try {
                    this.f30935p.setSoTimeout(1);
                    return !this.f30937t.ux();
                } finally {
                    this.f30935p.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.xv.w.c.ux.r.w
    public void c(com.bytedance.sdk.component.xv.w.c.ux.gd gdVar) throws IOException {
        gdVar.c(com.bytedance.sdk.component.xv.w.c.ux.w.REFUSED_STREAM);
    }

    @Override // com.bytedance.sdk.component.xv.w.c.ux.r.w
    public void c(com.bytedance.sdk.component.xv.w.c.ux.r rVar) {
        synchronized (this.f30936r) {
            this.xv = rVar.c();
        }
    }
}
