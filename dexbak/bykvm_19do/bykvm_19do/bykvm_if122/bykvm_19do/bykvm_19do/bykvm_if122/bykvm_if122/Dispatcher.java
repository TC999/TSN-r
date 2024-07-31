package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.RealCall;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.n */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Dispatcher {

    /* renamed from: c */
    private Runnable f1345c;

    /* renamed from: d */
    private ExecutorService f1346d;

    /* renamed from: a */
    private int f1343a = 64;

    /* renamed from: b */
    private int f1344b = 5;

    /* renamed from: e */
    private final Deque<RealCall.C1082a> f1347e = new ArrayDeque();

    /* renamed from: f */
    private final Deque<RealCall.C1082a> f1348f = new ArrayDeque();

    /* renamed from: g */
    private final Deque<RealCall> f1349g = new ArrayDeque();

    /* renamed from: c */
    private void m58370c() {
        if (this.f1348f.size() < this.f1343a && !this.f1347e.isEmpty()) {
            Iterator<RealCall.C1082a> it = this.f1347e.iterator();
            while (it.hasNext()) {
                RealCall.C1082a next = it.next();
                if (m58369c(next) < this.f1344b) {
                    it.remove();
                    this.f1348f.add(next);
                    m58377a().execute(next);
                }
                if (this.f1348f.size() >= this.f1343a) {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized ExecutorService m58377a() {
        if (this.f1346d == null) {
            this.f1346d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), C1061c.m58465a("OkHttp Dispatcher", false));
        }
        return this.f1346d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m58372b(RealCall.C1082a c1082a) {
        m58374a(this.f1348f, c1082a, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m58371b(RealCall realCall) {
        m58374a(this.f1349g, realCall, false);
    }

    /* renamed from: b */
    public synchronized int m58373b() {
        return this.f1348f.size() + this.f1349g.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m58376a(RealCall.C1082a c1082a) {
        if (this.f1348f.size() < this.f1343a && m58369c(c1082a) < this.f1344b) {
            this.f1348f.add(c1082a);
            m58377a().execute(c1082a);
        } else {
            this.f1347e.add(c1082a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m58375a(RealCall realCall) {
        this.f1349g.add(realCall);
    }

    /* renamed from: a */
    private <T> void m58374a(Deque<T> deque, T t, boolean z) {
        int m58373b;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    m58370c();
                }
                m58373b = m58373b();
                runnable = this.f1345c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (m58373b != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }

    /* renamed from: c */
    private int m58369c(RealCall.C1082a c1082a) {
        int i = 0;
        for (RealCall.C1082a c1082a2 : this.f1348f) {
            if (c1082a2.m58213c().equals(c1082a.m58213c())) {
                i++;
            }
        }
        return i;
    }
}
