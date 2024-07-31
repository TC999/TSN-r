package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.RealConnection;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.RouteDatabase;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.StreamAllocation;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.j */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ConnectionPool {

    /* renamed from: g */
    private static final Executor f1309g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1061c.m58465a("OkHttp ConnectionPool", true));

    /* renamed from: h */
    static final /* synthetic */ boolean f1310h = true;

    /* renamed from: a */
    private final int f1311a;

    /* renamed from: b */
    private final long f1312b;

    /* renamed from: c */
    private final Runnable f1313c;

    /* renamed from: d */
    private final Deque<RealConnection> f1314d;

    /* renamed from: e */
    final RouteDatabase f1315e;

    /* renamed from: f */
    boolean f1316f;

    /* compiled from: ConnectionPool.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.j$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class RunnableC1069a implements Runnable {
        RunnableC1069a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long m58409a = ConnectionPool.this.m58409a(System.nanoTime());
                if (m58409a == -1) {
                    return;
                }
                if (m58409a > 0) {
                    long j = m58409a / 1000000;
                    long j2 = m58409a - (1000000 * j);
                    synchronized (ConnectionPool.this) {
                        try {
                            ConnectionPool.this.wait(j, (int) j2);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public RealConnection m58407a(Address address, StreamAllocation streamAllocation, Route route) {
        if (f1310h || Thread.holdsLock(this)) {
            for (RealConnection realConnection : this.f1314d) {
                if (realConnection.m58731a(address, route)) {
                    streamAllocation.m58700a(realConnection, true);
                    return realConnection;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m58404b(RealConnection realConnection) {
        if (!f1310h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f1316f) {
            this.f1316f = true;
            f1309g.execute(this.f1313c);
        }
        this.f1314d.add(realConnection);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.f1313c = new RunnableC1069a();
        this.f1314d = new ArrayDeque();
        this.f1315e = new RouteDatabase();
        this.f1311a = i;
        this.f1312b = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Socket m58408a(Address address, StreamAllocation streamAllocation) {
        if (f1310h || Thread.holdsLock(this)) {
            for (RealConnection realConnection : this.f1314d) {
                if (realConnection.m58731a(address, null) && realConnection.m58724c() && realConnection != streamAllocation.m58695b()) {
                    return streamAllocation.m58701a(realConnection);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m58406a(RealConnection realConnection) {
        if (f1310h || Thread.holdsLock(this)) {
            if (!realConnection.f973k && this.f1311a != 0) {
                notifyAll();
                return false;
            }
            this.f1314d.remove(realConnection);
            return true;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    long m58409a(long j) {
        synchronized (this) {
            RealConnection realConnection = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (RealConnection realConnection2 : this.f1314d) {
                if (m58405a(realConnection2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - realConnection2.f977o;
                    if (j3 > j2) {
                        realConnection = realConnection2;
                        j2 = j3;
                    }
                }
            }
            long j4 = this.f1312b;
            if (j2 < j4 && i <= this.f1311a) {
                if (i > 0) {
                    return j4 - j2;
                } else if (i2 > 0) {
                    return j4;
                } else {
                    this.f1316f = false;
                    return -1L;
                }
            }
            this.f1314d.remove(realConnection);
            C1061c.m58463a(realConnection.m58723d());
            return 0L;
        }
    }

    /* renamed from: a */
    private int m58405a(RealConnection realConnection, long j) {
        List<Reference<StreamAllocation>> list = realConnection.f976n;
        int i = 0;
        while (i < list.size()) {
            Reference<StreamAllocation> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Platform.m58485b().mo58491a("A connection to " + realConnection.mo58410a().m58446a().m58851k() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.C1025a) reference).f1006a);
                list.remove(i);
                realConnection.f973k = true;
                if (list.isEmpty()) {
                    realConnection.f977o = j - this.f1312b;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
