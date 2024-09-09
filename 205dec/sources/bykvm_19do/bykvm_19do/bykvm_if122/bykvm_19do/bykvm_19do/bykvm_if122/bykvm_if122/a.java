package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Address.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    final s f844a;

    /* renamed from: b  reason: collision with root package name */
    final o f845b;

    /* renamed from: c  reason: collision with root package name */
    final SocketFactory f846c;

    /* renamed from: d  reason: collision with root package name */
    final b f847d;

    /* renamed from: e  reason: collision with root package name */
    final List<w> f848e;

    /* renamed from: f  reason: collision with root package name */
    final List<k> f849f;

    /* renamed from: g  reason: collision with root package name */
    final ProxySelector f850g;

    /* renamed from: h  reason: collision with root package name */
    final Proxy f851h;

    /* renamed from: i  reason: collision with root package name */
    final SSLSocketFactory f852i;

    /* renamed from: j  reason: collision with root package name */
    final HostnameVerifier f853j;

    /* renamed from: k  reason: collision with root package name */
    final g f854k;

    public a(String str, int i4, o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b bVar, Proxy proxy, List<w> list, List<k> list2, ProxySelector proxySelector) {
        this.f844a = new s.a().e(sSLSocketFactory != null ? "https" : "http").c(str).a(i4).a();
        if (oVar != null) {
            this.f845b = oVar;
            if (socketFactory != null) {
                this.f846c = socketFactory;
                if (bVar != null) {
                    this.f847d = bVar;
                    if (list != null) {
                        this.f848e = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(list);
                        if (list2 != null) {
                            this.f849f = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(list2);
                            if (proxySelector != null) {
                                this.f850g = proxySelector;
                                this.f851h = proxy;
                                this.f852i = sSLSocketFactory;
                                this.f853j = hostnameVerifier;
                                this.f854k = gVar;
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

    public g a() {
        return this.f854k;
    }

    public List<k> b() {
        return this.f849f;
    }

    public o c() {
        return this.f845b;
    }

    public HostnameVerifier d() {
        return this.f853j;
    }

    public List<w> e() {
        return this.f848e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f844a.equals(aVar.f844a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public Proxy f() {
        return this.f851h;
    }

    public b g() {
        return this.f847d;
    }

    public ProxySelector h() {
        return this.f850g;
    }

    public int hashCode() {
        int hashCode = (((((((((((this.f844a.hashCode() + 527) * 31) + this.f845b.hashCode()) * 31) + this.f847d.hashCode()) * 31) + this.f848e.hashCode()) * 31) + this.f849f.hashCode()) * 31) + this.f850g.hashCode()) * 31;
        Proxy proxy = this.f851h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f852i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f853j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        g gVar = this.f854k;
        return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
    }

    public SocketFactory i() {
        return this.f846c;
    }

    public SSLSocketFactory j() {
        return this.f852i;
    }

    public s k() {
        return this.f844a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f844a.g());
        sb.append(":");
        sb.append(this.f844a.j());
        if (this.f851h != null) {
            sb.append(", proxy=");
            sb.append(this.f851h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f850g);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.f845b.equals(aVar.f845b) && this.f847d.equals(aVar.f847d) && this.f848e.equals(aVar.f848e) && this.f849f.equals(aVar.f849f) && this.f850g.equals(aVar.f850g) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f851h, aVar.f851h) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f852i, aVar.f852i) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f853j, aVar.f853j) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f854k, aVar.f854k) && k().j() == aVar.k().j();
    }
}
