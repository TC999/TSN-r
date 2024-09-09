package com.bytedance.sdk.component.xv.w.c.xv;

import com.bytedance.sdk.component.xv.w.ba;
import com.bytedance.sdk.component.xv.w.ck;
import com.bytedance.sdk.component.xv.w.eq;
import com.bytedance.sdk.component.xv.w.fz;
import com.bytedance.sdk.component.xv.w.j;
import com.bytedance.sdk.component.xv.w.n;
import com.bytedance.sdk.component.xv.w.u;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class p implements u {

    /* renamed from: c  reason: collision with root package name */
    private final j f30955c;
    private Object sr;
    private volatile boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private final boolean f30956w;
    private com.bytedance.sdk.component.xv.w.c.w.r xv;

    public p(j jVar, boolean z3) {
        this.f30955c = jVar;
        this.f30956w = z3;
    }

    public void c() {
        this.ux = true;
        com.bytedance.sdk.component.xv.w.c.w.r rVar = this.xv;
        if (rVar != null) {
            rVar.ux();
        }
    }

    public boolean w() {
        return this.ux;
    }

    public void c(Object obj) {
        this.sr = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006f  */
    @Override // com.bytedance.sdk.component.xv.w.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.xv.w.ba c(com.bytedance.sdk.component.xv.w.u.c r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 735
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.w.c.xv.p.c(com.bytedance.sdk.component.xv.w.u$c):com.bytedance.sdk.component.xv.w.ba");
    }

    private com.bytedance.sdk.component.xv.w.c c(fz fzVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        com.bytedance.sdk.component.xv.w.r rVar;
        if (fzVar.sr()) {
            SSLSocketFactory p3 = this.f30955c.p();
            hostnameVerifier = this.f30955c.k();
            sSLSocketFactory = p3;
            rVar = this.f30955c.a();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            rVar = null;
        }
        return new com.bytedance.sdk.component.xv.w.c(fzVar.r(), fzVar.ev(), this.f30955c.ev(), this.f30955c.gd(), sSLSocketFactory, hostnameVerifier, rVar, this.f30955c.t(), this.f30955c.sr(), this.f30955c.u(), this.f30955c.i(), this.f30955c.ux());
    }

    private boolean c(IOException iOException, boolean z3, n nVar) {
        this.xv.c(iOException);
        if (this.f30955c.s()) {
            return !(z3 && (nVar.sr() instanceof a)) && c(iOException, z3) && this.xv.f();
        }
        return false;
    }

    private boolean c(IOException iOException, boolean z3) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z3 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private n c(ba baVar) throws IOException {
        String c4;
        fz xv;
        Proxy sr;
        if (baVar != null) {
            com.bytedance.sdk.component.xv.w.c.w.xv w3 = this.xv.w();
            eq c5 = w3 != null ? w3.c() : null;
            int xv2 = baVar.xv();
            String w4 = baVar.c().w();
            if (xv2 == 307 || xv2 == 308) {
                if (!w4.equals("GET") && !w4.equals("HEAD")) {
                    return null;
                }
            } else if (xv2 != 401) {
                if (xv2 == 407) {
                    if (c5 != null) {
                        sr = c5.w();
                    } else {
                        sr = this.f30955c.sr();
                    }
                    if (sr.type() == Proxy.Type.HTTP) {
                        return this.f30955c.t().c(c5, baVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (xv2 == 408) {
                    if (this.f30955c.s() && !(baVar.c().sr() instanceof a)) {
                        if (baVar.k() == null || baVar.k().xv() != 408) {
                            return baVar.c();
                        }
                        return null;
                    }
                    return null;
                } else {
                    switch (xv2) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                }
            } else {
                return this.f30955c.bk().c(c5, baVar);
            }
            if (!this.f30955c.ia() || (c4 = baVar.c("Location")) == null || (xv = baVar.c().c().xv(c4)) == null) {
                return null;
            }
            if (xv.xv().equals(baVar.c().c().xv()) || this.f30955c.fp()) {
                n.c f4 = baVar.c().f();
                if (f.xv(w4)) {
                    boolean sr2 = f.sr(w4);
                    if (f.ux(w4)) {
                        f4.c("GET", (ck) null);
                    } else {
                        f4.c(w4, sr2 ? baVar.c().sr() : null);
                    }
                    if (!sr2) {
                        f4.w("Transfer-Encoding");
                        f4.w("Content-Length");
                        f4.w("Content-Type");
                    }
                }
                if (!c(baVar, xv)) {
                    f4.w("Authorization");
                }
                return f4.c(xv).c();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    private boolean c(ba baVar, fz fzVar) {
        fz c4 = baVar.c().c();
        return c4.r().equals(fzVar.r()) && c4.ev() == fzVar.ev() && c4.xv().equals(fzVar.xv());
    }
}
