package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Address;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Call;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ConnectionPool;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.EventListener;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.OkHttpClient;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Route;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpCodec;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.RouteSelector;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.ConnectionShutdownException;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.ErrorCode;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.StreamResetException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class StreamAllocation {

    /* renamed from: o */
    static final /* synthetic */ boolean f991o = true;

    /* renamed from: a */
    public final Address f992a;

    /* renamed from: b */
    private RouteSelector.C1024a f993b;

    /* renamed from: c */
    private Route f994c;

    /* renamed from: d */
    private final ConnectionPool f995d;

    /* renamed from: e */
    public final Call f996e;

    /* renamed from: f */
    public final EventListener f997f;

    /* renamed from: g */
    private final Object f998g;

    /* renamed from: h */
    private final RouteSelector f999h;

    /* renamed from: i */
    private int f1000i;

    /* renamed from: j */
    private RealConnection f1001j;

    /* renamed from: k */
    private boolean f1002k;

    /* renamed from: l */
    private boolean f1003l;

    /* renamed from: m */
    private boolean f1004m;

    /* renamed from: n */
    private HttpCodec f1005n;

    /* compiled from: StreamAllocation.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1025a extends WeakReference<StreamAllocation> {

        /* renamed from: a */
        public final Object f1006a;

        C1025a(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.f1006a = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.f995d = connectionPool;
        this.f992a = address;
        this.f996e = call;
        this.f997f = eventListener;
        this.f999h = new RouteSelector(address, m58689g(), call, eventListener);
        this.f998g = obj;
    }

    /* renamed from: f */
    private Socket m58690f() {
        if (f991o || Thread.holdsLock(this.f995d)) {
            RealConnection realConnection = this.f1001j;
            if (realConnection == null || !realConnection.f973k) {
                return null;
            }
            return m58696a(false, false, true);
        }
        throw new AssertionError();
    }

    /* renamed from: g */
    private RouteDatabase m58689g() {
        return Internal.f891a.mo58237a(this.f995d);
    }

    /* renamed from: a */
    public HttpCodec m58699a(OkHttpClient okHttpClient, Interceptor.InterfaceC1079a interfaceC1079a, boolean z) {
        try {
            HttpCodec m58727a = m58702a(interfaceC1079a.mo58271c(), interfaceC1079a.mo58270d(), interfaceC1079a.mo58274a(), okHttpClient.m58244u(), z).m58727a(okHttpClient, interfaceC1079a, this);
            synchronized (this.f995d) {
                this.f1005n = m58727a;
            }
            return m58727a;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* renamed from: b */
    public synchronized RealConnection m58695b() {
        return this.f1001j;
    }

    /* renamed from: c */
    public boolean m58693c() {
        RouteSelector.C1024a c1024a;
        return this.f994c != null || ((c1024a = this.f993b) != null && c1024a.m58706b()) || this.f999h.m58715a();
    }

    /* renamed from: d */
    public void m58692d() {
        RealConnection realConnection;
        Socket m58696a;
        synchronized (this.f995d) {
            realConnection = this.f1001j;
            m58696a = m58696a(true, false, false);
            if (this.f1001j != null) {
                realConnection = null;
            }
        }
        C1061c.m58463a(m58696a);
        if (realConnection != null) {
            this.f997f.m58352b(this.f996e, realConnection);
        }
    }

    /* renamed from: e */
    public void m58691e() {
        RealConnection realConnection;
        Socket m58696a;
        synchronized (this.f995d) {
            realConnection = this.f1001j;
            m58696a = m58696a(false, true, false);
            if (this.f1001j != null) {
                realConnection = null;
            }
        }
        C1061c.m58463a(m58696a);
        if (realConnection != null) {
            this.f997f.m58352b(this.f996e, realConnection);
        }
    }

    public String toString() {
        RealConnection m58695b = m58695b();
        return m58695b != null ? m58695b.toString() : this.f992a.toString();
    }

    /* renamed from: b */
    private void m58694b(RealConnection realConnection) {
        int size = realConnection.f976n.size();
        for (int i = 0; i < size; i++) {
            if (realConnection.f976n.get(i).get() == this) {
                realConnection.f976n.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    private RealConnection m58702a(int i, int i2, int i3, boolean z, boolean z2) throws IOException {
        while (true) {
            RealConnection m58703a = m58703a(i, i2, i3, z);
            synchronized (this.f995d) {
                if (m58703a.f974l == 0) {
                    return m58703a;
                }
                if (m58703a.m58726a(z2)) {
                    return m58703a;
                }
                m58692d();
            }
        }
    }

    /* renamed from: a */
    private RealConnection m58703a(int i, int i2, int i3, boolean z) throws IOException {
        RealConnection realConnection;
        Socket m58690f;
        RealConnection realConnection2;
        Socket socket;
        Route route;
        boolean z2;
        boolean z3;
        RouteSelector.C1024a c1024a;
        synchronized (this.f995d) {
            if (!this.f1003l) {
                if (this.f1005n == null) {
                    if (!this.f1004m) {
                        realConnection = this.f1001j;
                        m58690f = m58690f();
                        realConnection2 = this.f1001j;
                        socket = null;
                        if (realConnection2 != null) {
                            realConnection = null;
                        } else {
                            realConnection2 = null;
                        }
                        if (!this.f1002k) {
                            realConnection = null;
                        }
                        if (realConnection2 == null) {
                            Internal.f891a.mo58235a(this.f995d, this.f992a, this, null);
                            RealConnection realConnection3 = this.f1001j;
                            if (realConnection3 != null) {
                                realConnection2 = realConnection3;
                                z2 = true;
                                route = null;
                            } else {
                                route = this.f994c;
                            }
                        } else {
                            route = null;
                        }
                        z2 = false;
                    } else {
                        throw new IOException("Canceled");
                    }
                } else {
                    throw new IllegalStateException("codec != null");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        C1061c.m58463a(m58690f);
        if (realConnection != null) {
            this.f997f.m58352b(this.f996e, realConnection);
        }
        if (z2) {
            this.f997f.m58364a(this.f996e, realConnection2);
        }
        if (realConnection2 != null) {
            return realConnection2;
        }
        if (route != null || ((c1024a = this.f993b) != null && c1024a.m58706b())) {
            z3 = false;
        } else {
            this.f993b = this.f999h.m58710b();
            z3 = true;
        }
        synchronized (this.f995d) {
            if (this.f1004m) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<Route> m58707a = this.f993b.m58707a();
                int size = m58707a.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    Route route2 = m58707a.get(i4);
                    Internal.f891a.mo58235a(this.f995d, this.f992a, this, route2);
                    RealConnection realConnection4 = this.f1001j;
                    if (realConnection4 != null) {
                        this.f994c = route2;
                        realConnection2 = realConnection4;
                        z2 = true;
                        break;
                    }
                    i4++;
                }
            }
            if (!z2) {
                if (route == null) {
                    route = this.f993b.m58705c();
                }
                this.f994c = route;
                this.f1000i = 0;
                realConnection2 = new RealConnection(this.f995d, route);
                m58700a(realConnection2, false);
            }
        }
        if (z2) {
            this.f997f.m58364a(this.f996e, realConnection2);
            return realConnection2;
        }
        realConnection2.m58734a(i, i2, i3, z, this.f996e, this.f997f);
        m58689g().m58721a(realConnection2.mo58410a());
        synchronized (this.f995d) {
            this.f1002k = true;
            Internal.f891a.mo58230b(this.f995d, realConnection2);
            if (realConnection2.m58724c()) {
                socket = Internal.f891a.mo58236a(this.f995d, this.f992a, this);
                realConnection2 = this.f1001j;
            }
        }
        C1061c.m58463a(socket);
        this.f997f.m58364a(this.f996e, realConnection2);
        return realConnection2;
    }

    /* renamed from: a */
    public void m58697a(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        RealConnection realConnection;
        Socket m58696a;
        boolean z2;
        this.f997f.m58353b(this.f996e, j);
        synchronized (this.f995d) {
            if (httpCodec != null) {
                if (httpCodec == this.f1005n) {
                    if (!z) {
                        this.f1001j.f974l++;
                    }
                    realConnection = this.f1001j;
                    m58696a = m58696a(z, false, true);
                    if (this.f1001j != null) {
                        realConnection = null;
                    }
                    z2 = this.f1003l;
                }
            }
            throw new IllegalStateException("expected " + this.f1005n + " but was " + httpCodec);
        }
        C1061c.m58463a(m58696a);
        if (realConnection != null) {
            this.f997f.m58352b(this.f996e, realConnection);
        }
        if (iOException != null) {
            this.f997f.m58361a(this.f996e, iOException);
        } else if (z2) {
            this.f997f.m58367a(this.f996e);
        }
    }

    /* renamed from: a */
    public HttpCodec m58704a() {
        HttpCodec httpCodec;
        synchronized (this.f995d) {
            httpCodec = this.f1005n;
        }
        return httpCodec;
    }

    /* renamed from: a */
    private Socket m58696a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (f991o || Thread.holdsLock(this.f995d)) {
            if (z3) {
                this.f1005n = null;
            }
            if (z2) {
                this.f1003l = true;
            }
            RealConnection realConnection = this.f1001j;
            if (realConnection != null) {
                if (z) {
                    realConnection.f973k = true;
                }
                if (this.f1005n == null) {
                    if (this.f1003l || realConnection.f973k) {
                        m58694b(realConnection);
                        if (this.f1001j.f976n.isEmpty()) {
                            this.f1001j.f977o = System.nanoTime();
                            if (Internal.f891a.mo58234a(this.f995d, this.f1001j)) {
                                socket = this.f1001j.m58723d();
                                this.f1001j = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.f1001j = null;
                        return socket;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m58698a(IOException iOException) {
        RealConnection realConnection;
        boolean z;
        Socket m58696a;
        synchronized (this.f995d) {
            realConnection = null;
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).f1205a;
                ErrorCode errorCode2 = ErrorCode.REFUSED_STREAM;
                if (errorCode == errorCode2) {
                    this.f1000i++;
                }
                if (errorCode != errorCode2 || this.f1000i > 1) {
                    this.f994c = null;
                    z = true;
                }
                z = false;
            } else {
                RealConnection realConnection2 = this.f1001j;
                if (realConnection2 != null && (!realConnection2.m58724c() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.f1001j.f974l == 0) {
                        Route route = this.f994c;
                        if (route != null && iOException != null) {
                            this.f999h.m58714a(route, iOException);
                        }
                        this.f994c = null;
                    }
                    z = true;
                }
                z = false;
            }
            RealConnection realConnection3 = this.f1001j;
            m58696a = m58696a(z, false, true);
            if (this.f1001j == null && this.f1002k) {
                realConnection = realConnection3;
            }
        }
        C1061c.m58463a(m58696a);
        if (realConnection != null) {
            this.f997f.m58352b(this.f996e, realConnection);
        }
    }

    /* renamed from: a */
    public void m58700a(RealConnection realConnection, boolean z) {
        if (!f991o && !Thread.holdsLock(this.f995d)) {
            throw new AssertionError();
        }
        if (this.f1001j == null) {
            this.f1001j = realConnection;
            this.f1002k = z;
            realConnection.f976n.add(new C1025a(this, this.f998g));
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public Socket m58701a(RealConnection realConnection) {
        if (f991o || Thread.holdsLock(this.f995d)) {
            if (this.f1005n == null && this.f1001j.f976n.size() == 1) {
                Socket m58696a = m58696a(true, false, false);
                this.f1001j = realConnection;
                realConnection.f976n.add(this.f1001j.f976n.get(0));
                return m58696a;
            }
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }
}
