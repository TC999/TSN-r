package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z;
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

/* compiled from: RetryAndFollowUpInterceptor.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class j implements t {

    /* renamed from: a  reason: collision with root package name */
    private final v f944a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f945b;

    /* renamed from: c  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g f946c;

    /* renamed from: d  reason: collision with root package name */
    private Object f947d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f948e;

    public j(v vVar, boolean z3) {
        this.f944a = vVar;
        this.f945b = z3;
    }

    public boolean a() {
        return this.f948e;
    }

    public void a(Object obj) {
        this.f947d = obj;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t
    public a0 a(t.a aVar) throws IOException {
        a0 a4;
        y a5;
        y b4 = aVar.b();
        g gVar = (g) aVar;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e e4 = gVar.e();
        p g4 = gVar.g();
        this.f946c = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g(this.f944a.d(), a(b4.g()), e4, g4, this.f947d);
        a0 a0Var = null;
        int i4 = 0;
        while (!this.f948e) {
            try {
                try {
                    a4 = gVar.a(b4, this.f946c, null, null);
                    if (a0Var != null) {
                        a4 = a4.h().c(a0Var.h().a((b0) null).a()).a();
                    }
                    a5 = a(a4);
                } catch (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.e e5) {
                    if (!a(e5.a(), false, b4)) {
                        throw e5.a();
                    }
                } catch (IOException e6) {
                    if (!a(e6, !(e6 instanceof bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.a), b4)) {
                        throw e6;
                    }
                }
                if (a5 == null) {
                    if (!this.f945b) {
                        this.f946c.e();
                    }
                    return a4;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a4.a());
                int i5 = i4 + 1;
                if (i5 <= 20) {
                    a5.a();
                    if (!a(a4, a5.g())) {
                        this.f946c.e();
                        this.f946c = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g(this.f944a.d(), a(a5.g()), e4, g4, this.f947d);
                    } else if (this.f946c.a() != null) {
                        throw new IllegalStateException("Closing the body of " + a4 + " didn't close its backing stream. Bad interceptor?");
                    }
                    a0Var = a4;
                    b4 = a5;
                    i4 = i5;
                } else {
                    this.f946c.e();
                    throw new ProtocolException("Too many follow-up requests: " + i5);
                }
            } catch (Throwable th) {
                this.f946c.a((IOException) null);
                this.f946c.e();
                throw th;
            }
        }
        this.f946c.e();
        throw new IOException("Canceled");
    }

    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a a(s sVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.g gVar;
        if (sVar.h()) {
            SSLSocketFactory w3 = this.f944a.w();
            hostnameVerifier = this.f944a.l();
            sSLSocketFactory = w3;
            gVar = this.f944a.b();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a(sVar.g(), sVar.j(), this.f944a.h(), this.f944a.v(), sSLSocketFactory, hostnameVerifier, gVar, this.f944a.r(), this.f944a.q(), this.f944a.p(), this.f944a.e(), this.f944a.s());
    }

    private boolean a(IOException iOException, boolean z3, y yVar) {
        this.f946c.a(iOException);
        if (this.f944a.u()) {
            if (z3) {
                yVar.a();
            }
            return a(iOException, z3) && this.f946c.c();
        }
        return false;
    }

    private boolean a(IOException iOException, boolean z3) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z3 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private y a(a0 a0Var) throws IOException {
        String a4;
        s b4;
        Proxy q3;
        if (a0Var != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c b5 = this.f946c.b();
            c0 a5 = b5 != null ? b5.a() : null;
            int c4 = a0Var.c();
            String e4 = a0Var.k().e();
            if (c4 == 307 || c4 == 308) {
                if (!e4.equals("GET") && !e4.equals("HEAD")) {
                    return null;
                }
            } else if (c4 != 401) {
                if (c4 == 407) {
                    if (a5 != null) {
                        q3 = a5.b();
                    } else {
                        q3 = this.f944a.q();
                    }
                    if (q3.type() == Proxy.Type.HTTP) {
                        return this.f944a.r().a(a5, a0Var);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (c4 == 408) {
                    if (this.f944a.u()) {
                        a0Var.k().a();
                        if (a0Var.i() == null || a0Var.i().c() != 408) {
                            return a0Var.k();
                        }
                        return null;
                    }
                    return null;
                } else {
                    switch (c4) {
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
                return this.f944a.a().a(a5, a0Var);
            }
            if (!this.f944a.j() || (a4 = a0Var.a("Location")) == null || (b4 = a0Var.k().g().b(a4)) == null) {
                return null;
            }
            if (b4.m().equals(a0Var.k().g().m()) || this.f944a.k()) {
                y.a f4 = a0Var.k().f();
                if (f.b(e4)) {
                    boolean d4 = f.d(e4);
                    if (f.c(e4)) {
                        f4.a("GET", (z) null);
                    } else {
                        f4.a(e4, d4 ? a0Var.k().a() : null);
                    }
                    if (!d4) {
                        f4.a("Transfer-Encoding");
                        f4.a("Content-Length");
                        f4.a("Content-Type");
                    }
                }
                if (!a(a0Var, b4)) {
                    f4.a("Authorization");
                }
                return f4.a(b4).a();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    private boolean a(a0 a0Var, s sVar) {
        s g4 = a0Var.k().g();
        return g4.g().equals(sVar.g()) && g4.j() == sVar.j() && g4.m().equals(sVar.m());
    }
}
