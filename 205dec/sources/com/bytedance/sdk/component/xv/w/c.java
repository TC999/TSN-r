package com.bytedance.sdk.component.xv.w;

import com.bytedance.sdk.component.xv.w.fz;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    final fz f30729c;
    final Proxy ev;

    /* renamed from: f  reason: collision with root package name */
    final List<k> f30730f;
    final SSLSocketFactory gd;

    /* renamed from: k  reason: collision with root package name */
    final r f30731k;

    /* renamed from: p  reason: collision with root package name */
    final HostnameVerifier f30732p;

    /* renamed from: r  reason: collision with root package name */
    final ProxySelector f30733r;
    final w sr;
    final List<ls> ux;

    /* renamed from: w  reason: collision with root package name */
    final ys f30734w;
    final SocketFactory xv;

    public c(String str, int i4, ys ysVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, r rVar, w wVar, Proxy proxy, List<ls> list, List<k> list2, ProxySelector proxySelector) {
        this.f30729c = new fz.c().c(sSLSocketFactory != null ? "https" : "http").sr(str).c(i4).xv();
        if (ysVar != null) {
            this.f30734w = ysVar;
            if (socketFactory != null) {
                this.xv = socketFactory;
                if (wVar != null) {
                    this.sr = wVar;
                    if (list != null) {
                        this.ux = com.bytedance.sdk.component.xv.w.c.xv.c(list);
                        if (list2 != null) {
                            this.f30730f = com.bytedance.sdk.component.xv.w.c.xv.c(list2);
                            if (proxySelector != null) {
                                this.f30733r = proxySelector;
                                this.ev = proxy;
                                this.gd = sSLSocketFactory;
                                this.f30732p = hostnameVerifier;
                                this.f30731k = rVar;
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

    public fz c() {
        return this.f30729c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f30729c.equals(cVar.f30729c) && c(cVar)) {
                return true;
            }
        }
        return false;
    }

    public Proxy ev() {
        return this.ev;
    }

    public List<k> f() {
        return this.f30730f;
    }

    public SSLSocketFactory gd() {
        return this.gd;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f30729c.hashCode()) * 31) + this.f30734w.hashCode()) * 31) + this.sr.hashCode()) * 31) + this.ux.hashCode()) * 31) + this.f30730f.hashCode()) * 31) + this.f30733r.hashCode()) * 31;
        Proxy proxy = this.ev;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.gd;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f30732p;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        r rVar = this.f30731k;
        return hashCode4 + (rVar != null ? rVar.hashCode() : 0);
    }

    public r k() {
        return this.f30731k;
    }

    public HostnameVerifier p() {
        return this.f30732p;
    }

    public ProxySelector r() {
        return this.f30733r;
    }

    public w sr() {
        return this.sr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f30729c.r());
        sb.append(":");
        sb.append(this.f30729c.ev());
        if (this.ev != null) {
            sb.append(", proxy=");
            sb.append(this.ev);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f30733r);
        }
        sb.append("}");
        return sb.toString();
    }

    public List<ls> ux() {
        return this.ux;
    }

    public ys w() {
        return this.f30734w;
    }

    public SocketFactory xv() {
        return this.xv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(c cVar) {
        return this.f30734w.equals(cVar.f30734w) && this.sr.equals(cVar.sr) && this.ux.equals(cVar.ux) && this.f30730f.equals(cVar.f30730f) && this.f30733r.equals(cVar.f30733r) && com.bytedance.sdk.component.xv.w.c.xv.c(this.ev, cVar.ev) && com.bytedance.sdk.component.xv.w.c.xv.c(this.gd, cVar.gd) && com.bytedance.sdk.component.xv.w.c.xv.c(this.f30732p, cVar.f30732p) && com.bytedance.sdk.component.xv.w.c.xv.c(this.f30731k, cVar.f30731k) && c().ev() == cVar.c().ev();
    }
}
