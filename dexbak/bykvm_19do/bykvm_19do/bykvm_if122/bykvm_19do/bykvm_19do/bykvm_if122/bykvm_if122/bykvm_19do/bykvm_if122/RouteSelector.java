package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Address;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Call;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.EventListener;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.HttpUrl;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Route;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RouteSelector {

    /* renamed from: a */
    private final Address f981a;

    /* renamed from: b */
    private final RouteDatabase f982b;

    /* renamed from: c */
    private final Call f983c;

    /* renamed from: d */
    private final EventListener f984d;

    /* renamed from: f */
    private int f986f;

    /* renamed from: e */
    private List<Proxy> f985e = Collections.emptyList();

    /* renamed from: g */
    private List<InetSocketAddress> f987g = Collections.emptyList();

    /* renamed from: h */
    private final List<Route> f988h = new ArrayList();

    /* compiled from: RouteSelector.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.f$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1024a {

        /* renamed from: a */
        private final List<Route> f989a;

        /* renamed from: b */
        private int f990b = 0;

        C1024a(List<Route> list) {
            this.f989a = list;
        }

        /* renamed from: a */
        public List<Route> m58707a() {
            return new ArrayList(this.f989a);
        }

        /* renamed from: b */
        public boolean m58706b() {
            return this.f990b < this.f989a.size();
        }

        /* renamed from: c */
        public Route m58705c() {
            if (m58706b()) {
                List<Route> list = this.f989a;
                int i = this.f990b;
                this.f990b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        this.f981a = address;
        this.f982b = routeDatabase;
        this.f983c = call;
        this.f984d = eventListener;
        m58713a(address.m58851k(), address.m58856f());
    }

    /* renamed from: c */
    private boolean m58709c() {
        return this.f986f < this.f985e.size();
    }

    /* renamed from: d */
    private Proxy m58708d() throws IOException {
        if (m58709c()) {
            List<Proxy> list = this.f985e;
            int i = this.f986f;
            this.f986f = i + 1;
            Proxy proxy = list.get(i);
            m58711a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f981a.m58851k().m58307g() + "; exhausted proxy configurations: " + this.f985e);
    }

    /* renamed from: a */
    public boolean m58715a() {
        return m58709c() || !this.f988h.isEmpty();
    }

    /* renamed from: b */
    public C1024a m58710b() throws IOException {
        if (m58715a()) {
            ArrayList arrayList = new ArrayList();
            while (m58709c()) {
                Proxy m58708d = m58708d();
                int size = this.f987g.size();
                for (int i = 0; i < size; i++) {
                    Route route = new Route(this.f981a, m58708d, this.f987g.get(i));
                    if (this.f982b.m58719c(route)) {
                        this.f988h.add(route);
                    } else {
                        arrayList.add(route);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f988h);
                this.f988h.clear();
            }
            return new C1024a(arrayList);
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    public void m58714a(Route route, IOException iOException) {
        if (route.m58445b().type() != Proxy.Type.DIRECT && this.f981a.m58854h() != null) {
            this.f981a.m58854h().connectFailed(this.f981a.m58851k().m58300n(), route.m58445b().address(), iOException);
        }
        this.f982b.m58720b(route);
    }

    /* renamed from: a */
    private void m58713a(HttpUrl httpUrl, Proxy proxy) {
        List<Proxy> m58458a;
        if (proxy != null) {
            this.f985e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f981a.m58854h().select(httpUrl.m58300n());
            if (select != null && !select.isEmpty()) {
                m58458a = C1061c.m58460a(select);
            } else {
                m58458a = C1061c.m58458a(Proxy.NO_PROXY);
            }
            this.f985e = m58458a;
        }
        this.f986f = 0;
    }

    /* renamed from: a */
    private void m58711a(Proxy proxy) throws IOException {
        String m58307g;
        int m58304j;
        this.f987g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                m58307g = m58712a(inetSocketAddress);
                m58304j = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            m58307g = this.f981a.m58851k().m58307g();
            m58304j = this.f981a.m58851k().m58304j();
        }
        if (m58304j >= 1 && m58304j <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f987g.add(InetSocketAddress.createUnresolved(m58307g, m58304j));
                return;
            }
            this.f984d.m58360a(this.f983c, m58307g);
            List<InetAddress> mo58368a = this.f981a.m58859c().mo58368a(m58307g);
            if (!mo58368a.isEmpty()) {
                this.f984d.m58359a(this.f983c, m58307g, mo58368a);
                int size = mo58368a.size();
                for (int i = 0; i < size; i++) {
                    this.f987g.add(new InetSocketAddress(mo58368a.get(i), m58304j));
                }
                return;
            }
            throw new UnknownHostException(this.f981a.m58859c() + " returned no addresses for " + m58307g);
        }
        throw new SocketException("No route to " + m58307g + ":" + m58304j + "; port is out of range");
    }

    /* renamed from: a */
    static String m58712a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
