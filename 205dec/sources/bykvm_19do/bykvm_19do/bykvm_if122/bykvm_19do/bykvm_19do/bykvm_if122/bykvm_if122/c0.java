package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* compiled from: Route.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    final a f1245a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f1246b;

    /* renamed from: c  reason: collision with root package name */
    final InetSocketAddress f1247c;

    public c0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f1245a = aVar;
            this.f1246b = proxy;
            this.f1247c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public a a() {
        return this.f1245a;
    }

    public Proxy b() {
        return this.f1246b;
    }

    public boolean c() {
        return this.f1245a.f852i != null && this.f1246b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f1247c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (c0Var.f1245a.equals(this.f1245a) && c0Var.f1246b.equals(this.f1246b) && c0Var.f1247c.equals(this.f1247c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f1245a.hashCode() + 527) * 31) + this.f1246b.hashCode()) * 31) + this.f1247c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f1247c + "}";
    }
}
