package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Route {

    /* renamed from: a */
    final Address f1252a;

    /* renamed from: b */
    final Proxy f1253b;

    /* renamed from: c */
    final InetSocketAddress f1254c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f1252a = address;
            this.f1253b = proxy;
            this.f1254c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    /* renamed from: a */
    public Address m58446a() {
        return this.f1252a;
    }

    /* renamed from: b */
    public Proxy m58445b() {
        return this.f1253b;
    }

    /* renamed from: c */
    public boolean m58444c() {
        return this.f1252a.f859i != null && this.f1253b.type() == Proxy.Type.HTTP;
    }

    /* renamed from: d */
    public InetSocketAddress m58443d() {
        return this.f1254c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (route.f1252a.equals(this.f1252a) && route.f1253b.equals(this.f1253b) && route.f1254c.equals(this.f1254c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f1252a.hashCode() + 527) * 31) + this.f1253b.hashCode()) * 31) + this.f1254c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f1254c + "}";
    }
}
