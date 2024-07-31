package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Address;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Call;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.CertificatePinner;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.EventListener;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.HttpUrl;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.OkHttpClient;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.RequestBody;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ResponseBody;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Route;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.RealConnection;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.RouteException;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.StreamAllocation;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.ConnectionShutdownException;
import io.netty.handler.codec.http.HttpHeaders;
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

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.j */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: a */
    private final OkHttpClient f951a;

    /* renamed from: b */
    private final boolean f952b;

    /* renamed from: c */
    private StreamAllocation f953c;

    /* renamed from: d */
    private Object f954d;

    /* renamed from: e */
    private volatile boolean f955e;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.f951a = okHttpClient;
        this.f952b = z;
    }

    /* renamed from: a */
    public boolean m58746a() {
        return this.f955e;
    }

    /* renamed from: a */
    public void m58740a(Object obj) {
        this.f954d = obj;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor
    /* renamed from: a */
    public Response mo58275a(Interceptor.InterfaceC1079a interfaceC1079a) throws IOException {
        Response m58758a;
        Request m58745a;
        Request mo58272b = interfaceC1079a.mo58272b();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) interfaceC1079a;
        Call m58757e = realInterceptorChain.m58757e();
        EventListener m58755g = realInterceptorChain.m58755g();
        this.f953c = new StreamAllocation(this.f951a.m58261d(), m58743a(mo58272b.m58205g()), m58757e, m58755g, this.f954d);
        Response response = null;
        int i = 0;
        while (!this.f955e) {
            try {
                try {
                    m58758a = realInterceptorChain.m58758a(mo58272b, this.f953c, null, null);
                    if (response != null) {
                        m58758a = m58758a.m58841h().m58822c(response.m58841h().m58832a((ResponseBody) null).m58836a()).m58836a();
                    }
                    m58745a = m58745a(m58758a);
                } catch (RouteException e) {
                    if (!m58741a(e.m58718a(), false, mo58272b)) {
                        throw e.m58718a();
                    }
                } catch (IOException e2) {
                    if (!m58741a(e2, !(e2 instanceof ConnectionShutdownException), mo58272b)) {
                        throw e2;
                    }
                }
                if (m58745a == null) {
                    if (!this.f952b) {
                        this.f953c.m58691e();
                    }
                    return m58758a;
                }
                C1061c.m58475a(m58758a.m58850a());
                int i2 = i + 1;
                if (i2 <= 20) {
                    m58745a.m58212a();
                    if (!m58744a(m58758a, m58745a.m58205g())) {
                        this.f953c.m58691e();
                        this.f953c = new StreamAllocation(this.f951a.m58261d(), m58743a(m58745a.m58205g()), m58757e, m58755g, this.f954d);
                    } else if (this.f953c.m58704a() != null) {
                        throw new IllegalStateException("Closing the body of " + m58758a + " didn't close its backing stream. Bad interceptor?");
                    }
                    response = m58758a;
                    mo58272b = m58745a;
                    i = i2;
                } else {
                    this.f953c.m58691e();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                }
            } catch (Throwable th) {
                this.f953c.m58698a((IOException) null);
                this.f953c.m58691e();
                throw th;
            }
        }
        this.f953c.m58691e();
        throw new IOException("Canceled");
    }

    /* renamed from: a */
    private Address m58743a(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.m58306h()) {
            SSLSocketFactory m58242w = this.f951a.m58242w();
            hostnameVerifier = this.f951a.m58253l();
            sSLSocketFactory = m58242w;
            certificatePinner = this.f951a.m58263b();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.m58307g(), httpUrl.m58304j(), this.f951a.m58257h(), this.f951a.m58243v(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.f951a.m58247r(), this.f951a.m58248q(), this.f951a.m58249p(), this.f951a.m58260e(), this.f951a.m58246s());
    }

    /* renamed from: a */
    private boolean m58741a(IOException iOException, boolean z, Request request) {
        this.f953c.m58698a(iOException);
        if (this.f951a.m58244u()) {
            if (z) {
                request.m58212a();
            }
            return m58742a(iOException, z) && this.f953c.m58693c();
        }
        return false;
    }

    /* renamed from: a */
    private boolean m58742a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    /* renamed from: a */
    private Request m58745a(Response response) throws IOException {
        String m58849a;
        HttpUrl m58316b;
        Proxy m58248q;
        if (response != null) {
            RealConnection m58695b = this.f953c.m58695b();
            Route mo58410a = m58695b != null ? m58695b.mo58410a() : null;
            int m58846c = response.m58846c();
            String m58207e = response.m58838k().m58207e();
            if (m58846c == 307 || m58846c == 308) {
                if (!m58207e.equals("GET") && !m58207e.equals("HEAD")) {
                    return null;
                }
            } else if (m58846c != 401) {
                if (m58846c == 407) {
                    if (mo58410a != null) {
                        m58248q = mo58410a.m58445b();
                    } else {
                        m58248q = this.f951a.m58248q();
                    }
                    if (m58248q.type() == Proxy.Type.HTTP) {
                        return this.f951a.m58247r().mo58820a(mo58410a, response);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (m58846c == 408) {
                    if (this.f951a.m58244u()) {
                        response.m58838k().m58212a();
                        if (response.m58840i() == null || response.m58840i().m58846c() != 408) {
                            return response.m58838k();
                        }
                        return null;
                    }
                    return null;
                } else {
                    switch (m58846c) {
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
                return this.f951a.m58266a().mo58820a(mo58410a, response);
            }
            if (!this.f951a.m58255j() || (m58849a = response.m58849a(HttpHeaders.Names.LOCATION)) == null || (m58316b = response.m58838k().m58205g().m58316b(m58849a)) == null) {
                return null;
            }
            if (m58316b.m58301m().equals(response.m58838k().m58205g().m58301m()) || this.f951a.m58254k()) {
                Request.C1083a m58206f = response.m58838k().m58206f();
                if (HttpMethod.m58762b(m58207e)) {
                    boolean m58760d = HttpMethod.m58760d(m58207e);
                    if (HttpMethod.m58761c(m58207e)) {
                        m58206f.m58197a("GET", (RequestBody) null);
                    } else {
                        m58206f.m58197a(m58207e, m58760d ? response.m58838k().m58212a() : null);
                    }
                    if (!m58760d) {
                        m58206f.m58198a(HttpHeaders.Names.TRANSFER_ENCODING);
                        m58206f.m58198a("Content-Length");
                        m58206f.m58198a("Content-Type");
                    }
                }
                if (!m58744a(response, m58316b)) {
                    m58206f.m58198a("Authorization");
                }
                return m58206f.m58201a(m58316b).m58204a();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    private boolean m58744a(Response response, HttpUrl httpUrl) {
        HttpUrl m58205g = response.m58838k().m58205g();
        return m58205g.m58307g().equals(httpUrl.m58307g()) && m58205g.m58304j() == httpUrl.m58304j() && m58205g.m58301m().equals(httpUrl.m58301m());
    }
}
