package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g;
import com.bykv.vk.component.ttvideo.player.C;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ConnectionPool.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class j {

    /* renamed from: g  reason: collision with root package name */
    private static final Executor f1302g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("OkHttp ConnectionPool", true));

    /* renamed from: h  reason: collision with root package name */
    static final /* synthetic */ boolean f1303h = true;

    /* renamed from: a  reason: collision with root package name */
    private final int f1304a;

    /* renamed from: b  reason: collision with root package name */
    private final long f1305b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f1306c;

    /* renamed from: d  reason: collision with root package name */
    private final Deque<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c> f1307d;

    /* renamed from: e  reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.d f1308e;

    /* renamed from: f  reason: collision with root package name */
    boolean f1309f;

    /* compiled from: ConnectionPool.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long a4 = j.this.a(System.nanoTime());
                if (a4 == -1) {
                    return;
                }
                if (a4 > 0) {
                    long j4 = a4 / C.MICROS_PER_SECOND;
                    long j5 = a4 - (C.MICROS_PER_SECOND * j4);
                    synchronized (j.this) {
                        try {
                            j.this.wait(j4, (int) j5);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, c0 c0Var) {
        if (f1303h || Thread.holdsLock(this)) {
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar : this.f1307d) {
                if (cVar.a(aVar, c0Var)) {
                    gVar.a(cVar, true);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar) {
        if (!f1303h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f1309f) {
            this.f1309f = true;
            f1302g.execute(this.f1306c);
        }
        this.f1307d.add(cVar);
    }

    public j(int i4, long j4, TimeUnit timeUnit) {
        this.f1306c = new a();
        this.f1307d = new ArrayDeque();
        this.f1308e = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.d();
        this.f1304a = i4;
        this.f1305b = timeUnit.toNanos(j4);
        if (j4 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Socket a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar) {
        if (f1303h || Thread.holdsLock(this)) {
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar : this.f1307d) {
                if (cVar.a(aVar, null) && cVar.c() && cVar != gVar.b()) {
                    return gVar.a(cVar);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar) {
        if (f1303h || Thread.holdsLock(this)) {
            if (!cVar.f966k && this.f1304a != 0) {
                notifyAll();
                return false;
            }
            this.f1307d.remove(cVar);
            return true;
        }
        throw new AssertionError();
    }

    long a(long j4) {
        synchronized (this) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar = null;
            long j5 = Long.MIN_VALUE;
            int i4 = 0;
            int i5 = 0;
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar2 : this.f1307d) {
                if (a(cVar2, j4) > 0) {
                    i5++;
                } else {
                    i4++;
                    long j6 = j4 - cVar2.f970o;
                    if (j6 > j5) {
                        cVar = cVar2;
                        j5 = j6;
                    }
                }
            }
            long j7 = this.f1305b;
            if (j5 < j7 && i4 <= this.f1304a) {
                if (i4 > 0) {
                    return j7 - j5;
                } else if (i5 > 0) {
                    return j7;
                } else {
                    this.f1309f = false;
                    return -1L;
                }
            }
            this.f1307d.remove(cVar);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(cVar.d());
            return 0L;
        }
    }

    private int a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar, long j4) {
        List<Reference<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g>> list = cVar.f969n;
        int i4 = 0;
        while (i4 < list.size()) {
            Reference<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g> reference = list.get(i4);
            if (reference.get() != null) {
                i4++;
            } else {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a("A connection to " + cVar.a().a().k() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f999a);
                list.remove(i4);
                cVar.f966k = true;
                if (list.isEmpty()) {
                    cVar.f970o = j4 - this.f1305b;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
