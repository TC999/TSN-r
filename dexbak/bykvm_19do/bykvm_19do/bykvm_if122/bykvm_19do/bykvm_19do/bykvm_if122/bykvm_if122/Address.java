package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.HttpUrl;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Address {

    /* renamed from: a */
    final HttpUrl f851a;

    /* renamed from: b */
    final Dns f852b;

    /* renamed from: c */
    final SocketFactory f853c;

    /* renamed from: d */
    final Authenticator f854d;

    /* renamed from: e */
    final List<Protocol> f855e;

    /* renamed from: f */
    final List<ConnectionSpec> f856f;

    /* renamed from: g */
    final ProxySelector f857g;

    /* renamed from: h */
    final Proxy f858h;

    /* renamed from: i */
    final SSLSocketFactory f859i;

    /* renamed from: j */
    final HostnameVerifier f860j;

    /* renamed from: k */
    final CertificatePinner f861k;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.f851a = new HttpUrl.C1077a().m58281e(sSLSocketFactory != null ? "https" : IDataSource.f43971a).m58286c(str).m58297a(i).m58298a();
        if (dns != null) {
            this.f852b = dns;
            if (socketFactory != null) {
                this.f853c = socketFactory;
                if (authenticator != null) {
                    this.f854d = authenticator;
                    if (list != null) {
                        this.f855e = C1061c.m58460a(list);
                        if (list2 != null) {
                            this.f856f = C1061c.m58460a(list2);
                            if (proxySelector != null) {
                                this.f857g = proxySelector;
                                this.f858h = proxy;
                                this.f859i = sSLSocketFactory;
                                this.f860j = hostnameVerifier;
                                this.f861k = certificatePinner;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    /* renamed from: a */
    public CertificatePinner m58862a() {
        return this.f861k;
    }

    /* renamed from: b */
    public List<ConnectionSpec> m58860b() {
        return this.f856f;
    }

    /* renamed from: c */
    public Dns m58859c() {
        return this.f852b;
    }

    /* renamed from: d */
    public HostnameVerifier m58858d() {
        return this.f860j;
    }

    /* renamed from: e */
    public List<Protocol> m58857e() {
        return this.f855e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (this.f851a.equals(address.f851a) && m58861a(address)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public Proxy m58856f() {
        return this.f858h;
    }

    /* renamed from: g */
    public Authenticator m58855g() {
        return this.f854d;
    }

    /* renamed from: h */
    public ProxySelector m58854h() {
        return this.f857g;
    }

    public int hashCode() {
        int hashCode = (((((((((((this.f851a.hashCode() + 527) * 31) + this.f852b.hashCode()) * 31) + this.f854d.hashCode()) * 31) + this.f855e.hashCode()) * 31) + this.f856f.hashCode()) * 31) + this.f857g.hashCode()) * 31;
        Proxy proxy = this.f858h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f859i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f860j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner = this.f861k;
        return hashCode4 + (certificatePinner != null ? certificatePinner.hashCode() : 0);
    }

    /* renamed from: i */
    public SocketFactory m58853i() {
        return this.f853c;
    }

    /* renamed from: j */
    public SSLSocketFactory m58852j() {
        return this.f859i;
    }

    /* renamed from: k */
    public HttpUrl m58851k() {
        return this.f851a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f851a.m58307g());
        sb.append(":");
        sb.append(this.f851a.m58304j());
        if (this.f858h != null) {
            sb.append(", proxy=");
            sb.append(this.f858h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f857g);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m58861a(Address address) {
        return this.f852b.equals(address.f852b) && this.f854d.equals(address.f854d) && this.f855e.equals(address.f855e) && this.f856f.equals(address.f856f) && this.f857g.equals(address.f857g) && C1061c.m58473a(this.f858h, address.f858h) && C1061c.m58473a(this.f859i, address.f859i) && C1061c.m58473a(this.f860j, address.f860j) && C1061c.m58473a(this.f861k, address.f861k) && m58851k().m58304j() == address.m58851k().m58304j();
    }
}
