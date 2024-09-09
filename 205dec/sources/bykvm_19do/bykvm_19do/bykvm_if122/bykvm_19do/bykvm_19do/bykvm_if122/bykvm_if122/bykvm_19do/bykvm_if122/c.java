package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.i;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.k;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.q;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
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

/* compiled from: RealConnection.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class c extends g.i implements i {

    /* renamed from: b  reason: collision with root package name */
    private final j f957b;

    /* renamed from: c  reason: collision with root package name */
    private final c0 f958c;

    /* renamed from: d  reason: collision with root package name */
    private Socket f959d;

    /* renamed from: e  reason: collision with root package name */
    private Socket f960e;

    /* renamed from: f  reason: collision with root package name */
    private q f961f;

    /* renamed from: g  reason: collision with root package name */
    private w f962g;

    /* renamed from: h  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g f963h;

    /* renamed from: i  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f964i;

    /* renamed from: j  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d f965j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f966k;

    /* renamed from: l  reason: collision with root package name */
    public int f967l;

    /* renamed from: m  reason: collision with root package name */
    public int f968m = 1;

    /* renamed from: n  reason: collision with root package name */
    public final List<Reference<g>> f969n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public long f970o = Long.MAX_VALUE;

    public c(j jVar, c0 c0Var) {
        this.f957b = jVar;
        this.f958c = c0Var;
    }

    private y e() {
        return new y.a().a(this.f958c.a().k()).b("Host", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f958c.a().k(), true)).b("Proxy-Connection", "Keep-Alive").b("User-Agent", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.d.a()).a();
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
    public void a(int r16, int r17, int r18, boolean r19, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e r20, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p r21) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c.a(int, int, int, boolean, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p):void");
    }

    public q b() {
        return this.f961f;
    }

    public boolean c() {
        return this.f963h != null;
    }

    public Socket d() {
        return this.f960e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f958c.a().k().g());
        sb.append(":");
        sb.append(this.f958c.a().k().j());
        sb.append(", proxy=");
        sb.append(this.f958c.b());
        sb.append(" hostAddress=");
        sb.append(this.f958c.d());
        sb.append(" cipherSuite=");
        q qVar = this.f961f;
        sb.append(qVar != null ? qVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f962g);
        sb.append('}');
        return sb.toString();
    }

    private void a(int i4, int i5, int i6, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar) throws IOException {
        y e4 = e();
        s g4 = e4.g();
        for (int i7 = 0; i7 < 21; i7++) {
            a(i4, i5, eVar, pVar);
            e4 = a(i5, i6, e4, g4);
            if (e4 == null) {
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f959d);
            this.f959d = null;
            this.f965j = null;
            this.f964i = null;
            pVar.a(eVar, this.f958c.d(), this.f958c.b(), null);
        }
    }

    private void a(int i4, int i5, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar) throws IOException {
        Proxy b4 = this.f958c.b();
        this.f959d = (b4.type() == Proxy.Type.DIRECT || b4.type() == Proxy.Type.HTTP) ? this.f958c.a().i().createSocket() : new Socket(b4);
        pVar.a(eVar, this.f958c.d(), b4);
        this.f959d.setSoTimeout(i5);
        try {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(this.f959d, this.f958c.d(), i4);
            try {
                this.f964i = l.a(l.b(this.f959d));
                this.f965j = l.a(l.a(this.f959d));
            } catch (NullPointerException e4) {
                if ("throw with null exception".equals(e4.getMessage())) {
                    throw new IOException(e4);
                }
            }
        } catch (ConnectException e5) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f958c.d());
            connectException.initCause(e5);
            throw connectException;
        }
    }

    private void a(b bVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar) throws IOException {
        if (this.f958c.a().j() == null) {
            this.f962g = w.HTTP_1_1;
            this.f960e = this.f959d;
            return;
        }
        pVar.g(eVar);
        a(bVar);
        pVar.a(eVar, this.f961f);
        if (this.f962g == w.HTTP_2) {
            this.f960e.setSoTimeout(0);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g a4 = new g.h(true).a(this.f960e, this.f958c.a().k().g(), this.f964i, this.f965j).a(this).a();
            this.f963h = a4;
            a4.c();
        }
    }

    private void a(b bVar) throws IOException {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a a4 = this.f958c.a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) a4.j().createSocket(this.f959d, a4.k().g(), a4.k().j(), true);
                try {
                    k a5 = bVar.a(sSLSocket2);
                    if (a5.c()) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(sSLSocket2, a4.k().g(), a4.e());
                    }
                    sSLSocket2.startHandshake();
                    q a6 = q.a(sSLSocket2.getSession());
                    if (a4.d().verify(a4.k().g(), sSLSocket2.getSession())) {
                        a4.a().a(a4.k().g(), a6.b());
                        String b4 = a5.c() ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().b(sSLSocket2) : null;
                        this.f960e = sSLSocket2;
                        this.f964i = l.a(l.b(sSLSocket2));
                        this.f965j = l.a(l.a(this.f960e));
                        this.f961f = a6;
                        this.f962g = b4 != null ? w.a(b4) : w.HTTP_1_1;
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(sSLSocket2);
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) a6.b().get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + a4.k().g() + " not verified:\n    certificate: " + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.e.a(x509Certificate));
                } catch (AssertionError e4) {
                    e = e4;
                    if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(sSLSocket);
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e5) {
            e = e5;
        }
    }

    private y a(int i4, int i5, y yVar, s sVar) throws IOException {
        String str = "CONNECT " + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(sVar, true) + " HTTP/1.1";
        while (true) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a aVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a(null, null, this.f964i, this.f965j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f964i.t().a(i4, timeUnit);
            this.f965j.t().a(i5, timeUnit);
            aVar.a(yVar.c(), str);
            aVar.a();
            a0 a4 = aVar.a(false).a(yVar).a();
            long a5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.a(a4);
            if (a5 == -1) {
                a5 = 0;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s b4 = aVar.b(a5);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b(b4, Integer.MAX_VALUE, timeUnit);
            b4.close();
            int c4 = a4.c();
            if (c4 == 200) {
                if (this.f964i.o().x() && this.f965j.o().x()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (c4 == 407) {
                y a6 = this.f958c.a().g().a(this.f958c, a4);
                if (a6 != null) {
                    if ("close".equalsIgnoreCase(a4.a("Connection"))) {
                        return a6;
                    }
                    yVar = a6;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + a4.c());
            }
        }
    }

    public boolean a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, c0 c0Var) {
        if (this.f969n.size() >= this.f968m || this.f966k || !bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a.a(this.f958c.a(), aVar)) {
            return false;
        }
        if (aVar.k().g().equals(a().a().k().g())) {
            return true;
        }
        if (this.f963h != null && c0Var != null && c0Var.b().type() == Proxy.Type.DIRECT && this.f958c.b().type() == Proxy.Type.DIRECT && this.f958c.d().equals(c0Var.d()) && c0Var.a().d() == bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.e.f922a && a(aVar.k())) {
            try {
                aVar.a().a(aVar.k().g(), b().b());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean a(s sVar) {
        if (sVar.j() != this.f958c.a().k().j()) {
            return false;
        }
        if (sVar.g().equals(this.f958c.a().k().g())) {
            return true;
        }
        return this.f961f != null && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.e.f922a.a(sVar.g(), (X509Certificate) this.f961f.b().get(0));
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c a(v vVar, t.a aVar, g gVar) throws SocketException {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g gVar2 = this.f963h;
        if (gVar2 != null) {
            return new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.f(vVar, aVar, gVar, gVar2);
        }
        this.f960e.setSoTimeout(aVar.d());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f964i.t().a(aVar.d(), timeUnit);
        this.f965j.t().a(aVar.a(), timeUnit);
        return new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a(vVar, gVar, this.f964i, this.f965j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.i
    public c0 a() {
        return this.f958c;
    }

    public boolean a(boolean z3) {
        if (this.f960e.isClosed() || this.f960e.isInputShutdown() || this.f960e.isOutputShutdown()) {
            return false;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g gVar = this.f963h;
        if (gVar != null) {
            return !gVar.a();
        }
        if (z3) {
            try {
                int soTimeout = this.f960e.getSoTimeout();
                try {
                    this.f960e.setSoTimeout(1);
                    return !this.f964i.x();
                } finally {
                    this.f960e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g.i
    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar) throws IOException {
        iVar.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.REFUSED_STREAM);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g.i
    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g gVar) {
        synchronized (this.f957b) {
            this.f968m = gVar.b();
        }
    }
}
