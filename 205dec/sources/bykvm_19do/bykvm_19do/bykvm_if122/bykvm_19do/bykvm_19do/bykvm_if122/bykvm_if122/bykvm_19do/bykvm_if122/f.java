package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
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

/* compiled from: RouteSelector.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a f974a;

    /* renamed from: b  reason: collision with root package name */
    private final d f975b;

    /* renamed from: c  reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e f976c;

    /* renamed from: d  reason: collision with root package name */
    private final p f977d;

    /* renamed from: f  reason: collision with root package name */
    private int f979f;

    /* renamed from: e  reason: collision with root package name */
    private List<Proxy> f978e = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    private List<InetSocketAddress> f980g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    private final List<c0> f981h = new ArrayList();

    /* compiled from: RouteSelector.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<c0> f982a;

        /* renamed from: b  reason: collision with root package name */
        private int f983b = 0;

        a(List<c0> list) {
            this.f982a = list;
        }

        public List<c0> a() {
            return new ArrayList(this.f982a);
        }

        public boolean b() {
            return this.f983b < this.f982a.size();
        }

        public c0 c() {
            if (b()) {
                List<c0> list = this.f982a;
                int i4 = this.f983b;
                this.f983b = i4 + 1;
                return list.get(i4);
            }
            throw new NoSuchElementException();
        }
    }

    public f(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, d dVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar) {
        this.f974a = aVar;
        this.f975b = dVar;
        this.f976c = eVar;
        this.f977d = pVar;
        a(aVar.k(), aVar.f());
    }

    private boolean c() {
        return this.f979f < this.f978e.size();
    }

    private Proxy d() throws IOException {
        if (c()) {
            List<Proxy> list = this.f978e;
            int i4 = this.f979f;
            this.f979f = i4 + 1;
            Proxy proxy = list.get(i4);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f974a.k().g() + "; exhausted proxy configurations: " + this.f978e);
    }

    public boolean a() {
        return c() || !this.f981h.isEmpty();
    }

    public a b() throws IOException {
        if (a()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy d4 = d();
                int size = this.f980g.size();
                for (int i4 = 0; i4 < size; i4++) {
                    c0 c0Var = new c0(this.f974a, d4, this.f980g.get(i4));
                    if (this.f975b.c(c0Var)) {
                        this.f981h.add(c0Var);
                    } else {
                        arrayList.add(c0Var);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f981h);
                this.f981h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    public void a(c0 c0Var, IOException iOException) {
        if (c0Var.b().type() != Proxy.Type.DIRECT && this.f974a.h() != null) {
            this.f974a.h().connectFailed(this.f974a.k().n(), c0Var.b().address(), iOException);
        }
        this.f975b.b(c0Var);
    }

    private void a(s sVar, Proxy proxy) {
        List<Proxy> a4;
        if (proxy != null) {
            this.f978e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f974a.h().select(sVar.n());
            if (select != null && !select.isEmpty()) {
                a4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(select);
            } else {
                a4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(Proxy.NO_PROXY);
            }
            this.f978e = a4;
        }
        this.f979f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String g4;
        int j4;
        this.f980g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                g4 = a(inetSocketAddress);
                j4 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            g4 = this.f974a.k().g();
            j4 = this.f974a.k().j();
        }
        if (j4 >= 1 && j4 <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f980g.add(InetSocketAddress.createUnresolved(g4, j4));
                return;
            }
            this.f977d.a(this.f976c, g4);
            List<InetAddress> a4 = this.f974a.c().a(g4);
            if (!a4.isEmpty()) {
                this.f977d.a(this.f976c, g4, a4);
                int size = a4.size();
                for (int i4 = 0; i4 < size; i4++) {
                    this.f980g.add(new InetSocketAddress(a4.get(i4), j4));
                }
                return;
            }
            throw new UnknownHostException(this.f974a.c() + " returned no addresses for " + g4);
        }
        throw new SocketException("No route to " + g4 + ":" + j4 + "; port is out of range");
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
