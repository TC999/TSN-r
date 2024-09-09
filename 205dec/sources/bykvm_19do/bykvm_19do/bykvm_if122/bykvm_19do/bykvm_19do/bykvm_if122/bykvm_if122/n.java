package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.x;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Dispatcher.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class n {

    /* renamed from: c  reason: collision with root package name */
    private Runnable f1338c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f1339d;

    /* renamed from: a  reason: collision with root package name */
    private int f1336a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f1337b = 5;

    /* renamed from: e  reason: collision with root package name */
    private final Deque<x.a> f1340e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    private final Deque<x.a> f1341f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    private final Deque<x> f1342g = new ArrayDeque();

    private void c() {
        if (this.f1341f.size() < this.f1336a && !this.f1340e.isEmpty()) {
            Iterator<x.a> it = this.f1340e.iterator();
            while (it.hasNext()) {
                x.a next = it.next();
                if (c(next) < this.f1337b) {
                    it.remove();
                    this.f1341f.add(next);
                    a().execute(next);
                }
                if (this.f1341f.size() >= this.f1336a) {
                    return;
                }
            }
        }
    }

    public synchronized ExecutorService a() {
        if (this.f1339d == null) {
            this.f1339d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("OkHttp Dispatcher", false));
        }
        return this.f1339d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(x.a aVar) {
        a(this.f1341f, aVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(x xVar) {
        a(this.f1342g, xVar, false);
    }

    public synchronized int b() {
        return this.f1341f.size() + this.f1342g.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(x.a aVar) {
        if (this.f1341f.size() < this.f1336a && c(aVar) < this.f1337b) {
            this.f1341f.add(aVar);
            a().execute(aVar);
        } else {
            this.f1340e.add(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(x xVar) {
        this.f1342g.add(xVar);
    }

    private <T> void a(Deque<T> deque, T t3, boolean z3) {
        int b4;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t3)) {
                if (z3) {
                    c();
                }
                b4 = b();
                runnable = this.f1338c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (b4 != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }

    private int c(x.a aVar) {
        int i4 = 0;
        for (x.a aVar2 : this.f1341f) {
            if (aVar2.c().equals(aVar.c())) {
                i4++;
            }
        }
        return i4;
    }
}
