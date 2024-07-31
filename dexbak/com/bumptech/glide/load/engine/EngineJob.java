package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.C3770j;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.bumptech.glide.load.engine.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class EngineJob<R> implements DecodeJob.InterfaceC3618b<R>, FactoryPools.InterfaceC3779f {

    /* renamed from: x */
    private static final C3639c f13818x = new C3639c();

    /* renamed from: a */
    final C3641e f13819a;

    /* renamed from: b */
    private final StateVerifier f13820b;

    /* renamed from: c */
    private final Pools.Pool<EngineJob<?>> f13821c;

    /* renamed from: d */
    private final C3639c f13822d;

    /* renamed from: e */
    private final EngineJobListener f13823e;

    /* renamed from: f */
    private final GlideExecutor f13824f;

    /* renamed from: g */
    private final GlideExecutor f13825g;

    /* renamed from: h */
    private final GlideExecutor f13826h;

    /* renamed from: i */
    private final GlideExecutor f13827i;

    /* renamed from: j */
    private final AtomicInteger f13828j;

    /* renamed from: k */
    private Key f13829k;

    /* renamed from: l */
    private boolean f13830l;

    /* renamed from: m */
    private boolean f13831m;

    /* renamed from: n */
    private boolean f13832n;

    /* renamed from: o */
    private boolean f13833o;

    /* renamed from: p */
    private Resource<?> f13834p;

    /* renamed from: q */
    DataSource f13835q;

    /* renamed from: r */
    private boolean f13836r;

    /* renamed from: s */
    GlideException f13837s;

    /* renamed from: t */
    private boolean f13838t;

    /* renamed from: u */
    EngineResource<?> f13839u;

    /* renamed from: v */
    private DecodeJob<R> f13840v;

    /* renamed from: w */
    private volatile boolean f13841w;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineJob.java */
    /* renamed from: com.bumptech.glide.load.engine.l$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class RunnableC3637a implements Runnable {

        /* renamed from: a */
        private final ResourceCallback f13842a;

        RunnableC3637a(ResourceCallback resourceCallback) {
            this.f13842a = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (EngineJob.this) {
                if (EngineJob.this.f13819a.m45179b(this.f13842a)) {
                    EngineJob.this.m45196e(this.f13842a);
                }
                EngineJob.this.m45193i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineJob.java */
    /* renamed from: com.bumptech.glide.load.engine.l$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class RunnableC3638b implements Runnable {

        /* renamed from: a */
        private final ResourceCallback f13844a;

        RunnableC3638b(ResourceCallback resourceCallback) {
            this.f13844a = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (EngineJob.this) {
                if (EngineJob.this.f13819a.m45179b(this.f13844a)) {
                    EngineJob.this.f13839u.m45172a();
                    EngineJob.this.m45195f(this.f13844a);
                    EngineJob.this.m45183s(this.f13844a);
                }
                EngineJob.this.m45193i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.l$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3639c {
        C3639c() {
        }

        /* renamed from: a */
        public <R> EngineResource<R> m45181a(Resource<R> resource, boolean z) {
            return new EngineResource<>(resource, z, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* renamed from: com.bumptech.glide.load.engine.l$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3640d {

        /* renamed from: a */
        final ResourceCallback f13846a;

        /* renamed from: b */
        final Executor f13847b;

        C3640d(ResourceCallback resourceCallback, Executor executor) {
            this.f13846a = resourceCallback;
            this.f13847b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C3640d) {
                return this.f13846a.equals(((C3640d) obj).f13846a);
            }
            return false;
        }

        public int hashCode() {
            return this.f13846a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* renamed from: com.bumptech.glide.load.engine.l$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3641e implements Iterable<C3640d> {

        /* renamed from: a */
        private final List<C3640d> f13848a;

        C3641e() {
            this(new ArrayList(2));
        }

        /* renamed from: d */
        private static C3640d m45177d(ResourceCallback resourceCallback) {
            return new C3640d(resourceCallback, Executors.m44415a());
        }

        /* renamed from: a */
        void m45180a(ResourceCallback resourceCallback, Executor executor) {
            this.f13848a.add(new C3640d(resourceCallback, executor));
        }

        /* renamed from: b */
        boolean m45179b(ResourceCallback resourceCallback) {
            return this.f13848a.contains(m45177d(resourceCallback));
        }

        /* renamed from: c */
        C3641e m45178c() {
            return new C3641e(new ArrayList(this.f13848a));
        }

        void clear() {
            this.f13848a.clear();
        }

        /* renamed from: e */
        void m45176e(ResourceCallback resourceCallback) {
            this.f13848a.remove(m45177d(resourceCallback));
        }

        boolean isEmpty() {
            return this.f13848a.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<C3640d> iterator() {
            return this.f13848a.iterator();
        }

        int size() {
            return this.f13848a.size();
        }

        C3641e(List<C3640d> list) {
            this.f13848a = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pools.Pool<EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, pool, f13818x);
    }

    /* renamed from: j */
    private GlideExecutor m45192j() {
        if (this.f13831m) {
            return this.f13826h;
        }
        return this.f13832n ? this.f13827i : this.f13825g;
    }

    /* renamed from: n */
    private boolean m45188n() {
        return this.f13838t || this.f13836r || this.f13841w;
    }

    /* renamed from: r */
    private synchronized void m45184r() {
        if (this.f13829k != null) {
            this.f13819a.clear();
            this.f13829k = null;
            this.f13839u = null;
            this.f13834p = null;
            this.f13838t = false;
            this.f13841w = false;
            this.f13836r = false;
            this.f13840v.m45239v(false);
            this.f13840v = null;
            this.f13837s = null;
            this.f13835q = null;
            this.f13821c.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m45200a(ResourceCallback resourceCallback, Executor executor) {
        this.f13820b.mo44343c();
        this.f13819a.m45180a(resourceCallback, executor);
        boolean z = true;
        if (this.f13836r) {
            m45191k(1);
            executor.execute(new RunnableC3638b(resourceCallback));
        } else if (this.f13838t) {
            m45191k(1);
            executor.execute(new RunnableC3637a(resourceCallback));
        } else {
            if (this.f13841w) {
                z = false;
            }
            C3770j.m44395a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.InterfaceC3618b
    /* renamed from: b */
    public void mo45199b(GlideException glideException) {
        synchronized (this) {
            this.f13837s = glideException;
        }
        m45187o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.InterfaceC3618b
    /* renamed from: c */
    public void mo45198c(Resource<R> resource, DataSource dataSource) {
        synchronized (this) {
            this.f13834p = resource;
            this.f13835q = dataSource;
        }
        m45186p();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.InterfaceC3618b
    /* renamed from: d */
    public void mo45197d(DecodeJob<?> decodeJob) {
        m45192j().execute(decodeJob);
    }

    /* renamed from: e */
    synchronized void m45196e(ResourceCallback resourceCallback) {
        try {
            resourceCallback.mo44552b(this.f13837s);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* renamed from: f */
    synchronized void m45195f(ResourceCallback resourceCallback) {
        try {
            resourceCallback.mo44551c(this.f13839u, this.f13835q);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* renamed from: g */
    void m45194g() {
        if (m45188n()) {
            return;
        }
        this.f13841w = true;
        this.f13840v.m45256b();
        this.f13823e.mo45174c(this, this.f13829k);
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.InterfaceC3779f
    @NonNull
    /* renamed from: h */
    public StateVerifier mo44353h() {
        return this.f13820b;
    }

    /* renamed from: i */
    synchronized void m45193i() {
        this.f13820b.mo44343c();
        C3770j.m44395a(m45188n(), "Not yet complete!");
        int decrementAndGet = this.f13828j.decrementAndGet();
        C3770j.m44395a(decrementAndGet >= 0, "Can't decrement below 0");
        if (decrementAndGet == 0) {
            EngineResource<?> engineResource = this.f13839u;
            if (engineResource != null) {
                engineResource.m45169e();
            }
            m45184r();
        }
    }

    /* renamed from: k */
    synchronized void m45191k(int i) {
        EngineResource<?> engineResource;
        C3770j.m44395a(m45188n(), "Not yet complete!");
        if (this.f13828j.getAndAdd(i) == 0 && (engineResource = this.f13839u) != null) {
            engineResource.m45172a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: l */
    public synchronized EngineJob<R> m45190l(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f13829k = key;
        this.f13830l = z;
        this.f13831m = z2;
        this.f13832n = z3;
        this.f13833o = z4;
        return this;
    }

    /* renamed from: m */
    synchronized boolean m45189m() {
        return this.f13841w;
    }

    /* renamed from: o */
    void m45187o() {
        synchronized (this) {
            this.f13820b.mo44343c();
            if (this.f13841w) {
                m45184r();
            } else if (!this.f13819a.isEmpty()) {
                if (!this.f13838t) {
                    this.f13838t = true;
                    Key key = this.f13829k;
                    C3641e m45178c = this.f13819a.m45178c();
                    m45191k(m45178c.size() + 1);
                    this.f13823e.mo45175b(this, key, null);
                    Iterator<C3640d> it = m45178c.iterator();
                    while (it.hasNext()) {
                        C3640d next = it.next();
                        next.f13847b.execute(new RunnableC3637a(next.f13846a));
                    }
                    m45193i();
                    return;
                }
                throw new IllegalStateException("Already failed once");
            } else {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
        }
    }

    /* renamed from: p */
    void m45186p() {
        synchronized (this) {
            this.f13820b.mo44343c();
            if (this.f13841w) {
                this.f13834p.recycle();
                m45184r();
            } else if (!this.f13819a.isEmpty()) {
                if (!this.f13836r) {
                    this.f13839u = this.f13822d.m45181a(this.f13834p, this.f13830l);
                    this.f13836r = true;
                    C3641e m45178c = this.f13819a.m45178c();
                    m45191k(m45178c.size() + 1);
                    this.f13823e.mo45175b(this, this.f13829k, this.f13839u);
                    Iterator<C3640d> it = m45178c.iterator();
                    while (it.hasNext()) {
                        C3640d next = it.next();
                        next.f13847b.execute(new RunnableC3638b(next.f13846a));
                    }
                    m45193i();
                    return;
                }
                throw new IllegalStateException("Already have resource");
            } else {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public boolean m45185q() {
        return this.f13833o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public synchronized void m45183s(ResourceCallback resourceCallback) {
        boolean z;
        this.f13820b.mo44343c();
        this.f13819a.m45176e(resourceCallback);
        if (this.f13819a.isEmpty()) {
            m45194g();
            if (!this.f13836r && !this.f13838t) {
                z = false;
                if (z && this.f13828j.get() == 0) {
                    m45184r();
                }
            }
            z = true;
            if (z) {
                m45184r();
            }
        }
    }

    /* renamed from: t */
    public synchronized void m45182t(DecodeJob<R> decodeJob) {
        GlideExecutor m45192j;
        this.f13840v = decodeJob;
        if (decodeJob.m45257B()) {
            m45192j = this.f13824f;
        } else {
            m45192j = m45192j();
        }
        m45192j.execute(decodeJob);
    }

    @VisibleForTesting
    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pools.Pool<EngineJob<?>> pool, C3639c c3639c) {
        this.f13819a = new C3641e();
        this.f13820b = StateVerifier.m44345a();
        this.f13828j = new AtomicInteger();
        this.f13824f = glideExecutor;
        this.f13825g = glideExecutor2;
        this.f13826h = glideExecutor3;
        this.f13827i = glideExecutor4;
        this.f13823e = engineJobListener;
        this.f13821c = pool;
        this.f13822d = c3639c;
    }
}
