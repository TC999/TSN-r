package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.util.pool.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: EngineJob.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class l<R> implements h.b<R>, a.f {

    /* renamed from: x  reason: collision with root package name */
    private static final c f17135x = new c();

    /* renamed from: a  reason: collision with root package name */
    final e f17136a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.util.pool.c f17137b;

    /* renamed from: c  reason: collision with root package name */
    private final Pools.Pool<l<?>> f17138c;

    /* renamed from: d  reason: collision with root package name */
    private final c f17139d;

    /* renamed from: e  reason: collision with root package name */
    private final m f17140e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.executor.a f17141f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.executor.a f17142g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.executor.a f17143h;

    /* renamed from: i  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.executor.a f17144i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicInteger f17145j;

    /* renamed from: k  reason: collision with root package name */
    private com.bumptech.glide.load.c f17146k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f17147l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f17148m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f17149n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f17150o;

    /* renamed from: p  reason: collision with root package name */
    private u<?> f17151p;

    /* renamed from: q  reason: collision with root package name */
    DataSource f17152q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f17153r;

    /* renamed from: s  reason: collision with root package name */
    GlideException f17154s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f17155t;

    /* renamed from: u  reason: collision with root package name */
    p<?> f17156u;

    /* renamed from: v  reason: collision with root package name */
    private h<R> f17157v;

    /* renamed from: w  reason: collision with root package name */
    private volatile boolean f17158w;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: EngineJob.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final com.bumptech.glide.request.i f17159a;

        a(com.bumptech.glide.request.i iVar) {
            this.f17159a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (l.this) {
                if (l.this.f17136a.b(this.f17159a)) {
                    l.this.e(this.f17159a);
                }
                l.this.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: EngineJob.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final com.bumptech.glide.request.i f17161a;

        b(com.bumptech.glide.request.i iVar) {
            this.f17161a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (l.this) {
                if (l.this.f17136a.b(this.f17161a)) {
                    l.this.f17156u.a();
                    l.this.f(this.f17161a);
                    l.this.s(this.f17161a);
                }
                l.this.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: EngineJob.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class c {
        c() {
        }

        public <R> p<R> a(u<R> uVar, boolean z3) {
            return new p<>(uVar, z3, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: EngineJob.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        final com.bumptech.glide.request.i f17163a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f17164b;

        d(com.bumptech.glide.request.i iVar, Executor executor) {
            this.f17163a = iVar;
            this.f17164b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f17163a.equals(((d) obj).f17163a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17163a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: EngineJob.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class e implements Iterable<d> {

        /* renamed from: a  reason: collision with root package name */
        private final List<d> f17165a;

        e() {
            this(new ArrayList(2));
        }

        private static d d(com.bumptech.glide.request.i iVar) {
            return new d(iVar, com.bumptech.glide.util.d.a());
        }

        void a(com.bumptech.glide.request.i iVar, Executor executor) {
            this.f17165a.add(new d(iVar, executor));
        }

        boolean b(com.bumptech.glide.request.i iVar) {
            return this.f17165a.contains(d(iVar));
        }

        e c() {
            return new e(new ArrayList(this.f17165a));
        }

        void clear() {
            this.f17165a.clear();
        }

        void e(com.bumptech.glide.request.i iVar) {
            this.f17165a.remove(d(iVar));
        }

        boolean isEmpty() {
            return this.f17165a.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.f17165a.iterator();
        }

        int size() {
            return this.f17165a.size();
        }

        e(List<d> list) {
            this.f17165a = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(com.bumptech.glide.load.engine.executor.a aVar, com.bumptech.glide.load.engine.executor.a aVar2, com.bumptech.glide.load.engine.executor.a aVar3, com.bumptech.glide.load.engine.executor.a aVar4, m mVar, Pools.Pool<l<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, mVar, pool, f17135x);
    }

    private com.bumptech.glide.load.engine.executor.a j() {
        if (this.f17148m) {
            return this.f17143h;
        }
        return this.f17149n ? this.f17144i : this.f17142g;
    }

    private boolean n() {
        return this.f17155t || this.f17153r || this.f17158w;
    }

    private synchronized void r() {
        if (this.f17146k != null) {
            this.f17136a.clear();
            this.f17146k = null;
            this.f17156u = null;
            this.f17151p = null;
            this.f17155t = false;
            this.f17158w = false;
            this.f17153r = false;
            this.f17157v.v(false);
            this.f17157v = null;
            this.f17154s = null;
            this.f17152q = null;
            this.f17138c.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(com.bumptech.glide.request.i iVar, Executor executor) {
        this.f17137b.c();
        this.f17136a.a(iVar, executor);
        boolean z3 = true;
        if (this.f17153r) {
            k(1);
            executor.execute(new b(iVar));
        } else if (this.f17155t) {
            k(1);
            executor.execute(new a(iVar));
        } else {
            if (this.f17158w) {
                z3 = false;
            }
            com.bumptech.glide.util.j.a(z3, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void b(GlideException glideException) {
        synchronized (this) {
            this.f17154s = glideException;
        }
        o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.h.b
    public void c(u<R> uVar, DataSource dataSource) {
        synchronized (this) {
            this.f17151p = uVar;
            this.f17152q = dataSource;
        }
        p();
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void d(h<?> hVar) {
        j().execute(hVar);
    }

    synchronized void e(com.bumptech.glide.request.i iVar) {
        try {
            iVar.b(this.f17154s);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.engine.b(th);
        }
    }

    synchronized void f(com.bumptech.glide.request.i iVar) {
        try {
            iVar.c(this.f17156u, this.f17152q);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.engine.b(th);
        }
    }

    void g() {
        if (n()) {
            return;
        }
        this.f17158w = true;
        this.f17157v.b();
        this.f17140e.c(this, this.f17146k);
    }

    @Override // com.bumptech.glide.util.pool.a.f
    @NonNull
    public com.bumptech.glide.util.pool.c h() {
        return this.f17137b;
    }

    synchronized void i() {
        this.f17137b.c();
        com.bumptech.glide.util.j.a(n(), "Not yet complete!");
        int decrementAndGet = this.f17145j.decrementAndGet();
        com.bumptech.glide.util.j.a(decrementAndGet >= 0, "Can't decrement below 0");
        if (decrementAndGet == 0) {
            p<?> pVar = this.f17156u;
            if (pVar != null) {
                pVar.e();
            }
            r();
        }
    }

    synchronized void k(int i4) {
        p<?> pVar;
        com.bumptech.glide.util.j.a(n(), "Not yet complete!");
        if (this.f17145j.getAndAdd(i4) == 0 && (pVar = this.f17156u) != null) {
            pVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized l<R> l(com.bumptech.glide.load.c cVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f17146k = cVar;
        this.f17147l = z3;
        this.f17148m = z4;
        this.f17149n = z5;
        this.f17150o = z6;
        return this;
    }

    synchronized boolean m() {
        return this.f17158w;
    }

    void o() {
        synchronized (this) {
            this.f17137b.c();
            if (this.f17158w) {
                r();
            } else if (!this.f17136a.isEmpty()) {
                if (!this.f17155t) {
                    this.f17155t = true;
                    com.bumptech.glide.load.c cVar = this.f17146k;
                    e c4 = this.f17136a.c();
                    k(c4.size() + 1);
                    this.f17140e.b(this, cVar, null);
                    Iterator<d> it = c4.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.f17164b.execute(new a(next.f17163a));
                    }
                    i();
                    return;
                }
                throw new IllegalStateException("Already failed once");
            } else {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
        }
    }

    void p() {
        synchronized (this) {
            this.f17137b.c();
            if (this.f17158w) {
                this.f17151p.recycle();
                r();
            } else if (!this.f17136a.isEmpty()) {
                if (!this.f17153r) {
                    this.f17156u = this.f17139d.a(this.f17151p, this.f17147l);
                    this.f17153r = true;
                    e c4 = this.f17136a.c();
                    k(c4.size() + 1);
                    this.f17140e.b(this, this.f17146k, this.f17156u);
                    Iterator<d> it = c4.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.f17164b.execute(new b(next.f17163a));
                    }
                    i();
                    return;
                }
                throw new IllegalStateException("Already have resource");
            } else {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return this.f17150o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void s(com.bumptech.glide.request.i iVar) {
        boolean z3;
        this.f17137b.c();
        this.f17136a.e(iVar);
        if (this.f17136a.isEmpty()) {
            g();
            if (!this.f17153r && !this.f17155t) {
                z3 = false;
                if (z3 && this.f17145j.get() == 0) {
                    r();
                }
            }
            z3 = true;
            if (z3) {
                r();
            }
        }
    }

    public synchronized void t(h<R> hVar) {
        com.bumptech.glide.load.engine.executor.a j4;
        this.f17157v = hVar;
        if (hVar.B()) {
            j4 = this.f17141f;
        } else {
            j4 = j();
        }
        j4.execute(hVar);
    }

    @VisibleForTesting
    l(com.bumptech.glide.load.engine.executor.a aVar, com.bumptech.glide.load.engine.executor.a aVar2, com.bumptech.glide.load.engine.executor.a aVar3, com.bumptech.glide.load.engine.executor.a aVar4, m mVar, Pools.Pool<l<?>> pool, c cVar) {
        this.f17136a = new e();
        this.f17137b = com.bumptech.glide.util.pool.c.a();
        this.f17145j = new AtomicInteger();
        this.f17141f = aVar;
        this.f17142g = aVar2;
        this.f17143h = aVar3;
        this.f17144i = aVar4;
        this.f17140e = mVar;
        this.f17138c = pool;
        this.f17139d = cVar;
    }
}
