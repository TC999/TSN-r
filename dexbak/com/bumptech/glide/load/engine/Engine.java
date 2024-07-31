package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.C3770j;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.bumptech.glide.load.engine.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Engine implements EngineJobListener, MemoryCache.InterfaceC3603a, EngineResource.InterfaceC3642a {

    /* renamed from: j */
    private static final int f13792j = 150;

    /* renamed from: a */
    private final Jobs f13794a;

    /* renamed from: b */
    private final EngineKeyFactory f13795b;

    /* renamed from: c */
    private final MemoryCache f13796c;

    /* renamed from: d */
    private final C3633b f13797d;

    /* renamed from: e */
    private final ResourceRecycler f13798e;

    /* renamed from: f */
    private final C3635c f13799f;

    /* renamed from: g */
    private final C3631a f13800g;

    /* renamed from: h */
    private final ActiveResources f13801h;

    /* renamed from: i */
    private static final String f13791i = "Engine";

    /* renamed from: k */
    private static final boolean f13793k = Log.isLoggable(f13791i, 2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Engine.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.k$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3631a {

        /* renamed from: a */
        final DecodeJob.InterfaceC3621e f13802a;

        /* renamed from: b */
        final Pools.Pool<DecodeJob<?>> f13803b = FactoryPools.m44359e(150, new C3632a());

        /* renamed from: c */
        private int f13804c;

        /* compiled from: Engine.java */
        /* renamed from: com.bumptech.glide.load.engine.k$a$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3632a implements FactoryPools.InterfaceC3777d<DecodeJob<?>> {
            C3632a() {
            }

            @Override // com.bumptech.glide.util.pool.FactoryPools.InterfaceC3777d
            /* renamed from: b */
            public DecodeJob<?> mo44354a() {
                C3631a c3631a = C3631a.this;
                return new DecodeJob<>(c3631a.f13802a, c3631a.f13803b);
            }
        }

        C3631a(DecodeJob.InterfaceC3621e interfaceC3621e) {
            this.f13802a = interfaceC3621e;
        }

        /* renamed from: a */
        <R> DecodeJob<R> m45208a(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, DecodeJob.InterfaceC3618b<R> interfaceC3618b) {
            DecodeJob decodeJob = (DecodeJob) C3770j.m44392d(this.f13803b.acquire());
            int i3 = this.f13804c;
            this.f13804c = i3 + 1;
            return decodeJob.m45248m(glideContext, obj, engineKey, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, z3, options, interfaceC3618b, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Engine.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.k$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3633b {

        /* renamed from: a */
        final GlideExecutor f13806a;

        /* renamed from: b */
        final GlideExecutor f13807b;

        /* renamed from: c */
        final GlideExecutor f13808c;

        /* renamed from: d */
        final GlideExecutor f13809d;

        /* renamed from: e */
        final EngineJobListener f13810e;

        /* renamed from: f */
        final Pools.Pool<EngineJob<?>> f13811f = FactoryPools.m44359e(150, new C3634a());

        /* compiled from: Engine.java */
        /* renamed from: com.bumptech.glide.load.engine.k$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3634a implements FactoryPools.InterfaceC3777d<EngineJob<?>> {
            C3634a() {
            }

            @Override // com.bumptech.glide.util.pool.FactoryPools.InterfaceC3777d
            /* renamed from: b */
            public EngineJob<?> mo44354a() {
                C3633b c3633b = C3633b.this;
                return new EngineJob<>(c3633b.f13806a, c3633b.f13807b, c3633b.f13808c, c3633b.f13809d, c3633b.f13810e, c3633b.f13811f);
            }
        }

        C3633b(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener) {
            this.f13806a = glideExecutor;
            this.f13807b = glideExecutor2;
            this.f13808c = glideExecutor3;
            this.f13809d = glideExecutor4;
            this.f13810e = engineJobListener;
        }

        /* renamed from: a */
        <R> EngineJob<R> m45206a(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((EngineJob) C3770j.m44392d(this.f13811f.acquire())).m45190l(key, z, z2, z3, z4);
        }

        @VisibleForTesting
        /* renamed from: b */
        void m45205b() {
            Executors.m44413c(this.f13806a);
            Executors.m44413c(this.f13807b);
            Executors.m44413c(this.f13808c);
            Executors.m44413c(this.f13809d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Engine.java */
    /* renamed from: com.bumptech.glide.load.engine.k$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3635c implements DecodeJob.InterfaceC3621e {

        /* renamed from: a */
        private final DiskCache.InterfaceC3592a f13813a;

        /* renamed from: b */
        private volatile DiskCache f13814b;

        C3635c(DiskCache.InterfaceC3592a interfaceC3592a) {
            this.f13813a = interfaceC3592a;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.InterfaceC3621e
        /* renamed from: a */
        public DiskCache mo45203a() {
            if (this.f13814b == null) {
                synchronized (this) {
                    if (this.f13814b == null) {
                        this.f13814b = this.f13813a.build();
                    }
                    if (this.f13814b == null) {
                        this.f13814b = new DiskCacheAdapter();
                    }
                }
            }
            return this.f13814b;
        }

        @VisibleForTesting
        /* renamed from: b */
        synchronized void m45202b() {
            if (this.f13814b == null) {
                return;
            }
            this.f13814b.clear();
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: com.bumptech.glide.load.engine.k$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3636d {

        /* renamed from: a */
        private final EngineJob<?> f13815a;

        /* renamed from: b */
        private final ResourceCallback f13816b;

        C3636d(ResourceCallback resourceCallback, EngineJob<?> engineJob) {
            this.f13816b = resourceCallback;
            this.f13815a = engineJob;
        }

        /* renamed from: a */
        public void m45201a() {
            synchronized (Engine.this) {
                this.f13815a.m45183s(this.f13816b);
            }
        }
    }

    public Engine(MemoryCache memoryCache, DiskCache.InterfaceC3592a interfaceC3592a, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this(memoryCache, interfaceC3592a, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, null, null, null, null, null, null, z);
    }

    /* renamed from: f */
    private EngineResource<?> m45215f(Key key) {
        Resource<?> mo45318e = this.f13796c.mo45318e(key);
        if (mo45318e == null) {
            return null;
        }
        if (mo45318e instanceof EngineResource) {
            return (EngineResource) mo45318e;
        }
        return new EngineResource<>(mo45318e, true, true);
    }

    @Nullable
    /* renamed from: h */
    private EngineResource<?> m45213h(Key key, boolean z) {
        if (z) {
            EngineResource<?> m45425e = this.f13801h.m45425e(key);
            if (m45425e != null) {
                m45425e.m45172a();
            }
            return m45425e;
        }
        return null;
    }

    /* renamed from: i */
    private EngineResource<?> m45212i(Key key, boolean z) {
        if (z) {
            EngineResource<?> m45215f = m45215f(key);
            if (m45215f != null) {
                m45215f.m45172a();
                this.f13801h.m45429a(key, m45215f);
            }
            return m45215f;
        }
        return null;
    }

    /* renamed from: j */
    private static void m45211j(String str, long j, Key key) {
        Log.v(f13791i, str + " in " + LogTime.m44412a(j) + "ms, key: " + key);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.InterfaceC3603a
    /* renamed from: a */
    public void mo45217a(@NonNull Resource<?> resource) {
        this.f13798e.m45131a(resource);
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    /* renamed from: b */
    public synchronized void mo45175b(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource) {
        if (engineResource != null) {
            engineResource.m45168f(key, this);
            if (engineResource.m45170d()) {
                this.f13801h.m45429a(key, engineResource);
            }
        }
        this.f13794a.m45142e(key, engineJob);
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    /* renamed from: c */
    public synchronized void mo45174c(EngineJob<?> engineJob, Key key) {
        this.f13794a.m45142e(key, engineJob);
    }

    @Override // com.bumptech.glide.load.engine.EngineResource.InterfaceC3642a
    /* renamed from: d */
    public synchronized void mo45167d(Key key, EngineResource<?> engineResource) {
        this.f13801h.m45426d(key);
        if (engineResource.m45170d()) {
            this.f13796c.mo45319d(key, engineResource);
        } else {
            this.f13798e.m45131a(engineResource);
        }
    }

    /* renamed from: e */
    public void m45216e() {
        this.f13799f.mo45203a().clear();
    }

    /* renamed from: g */
    public synchronized <R> C3636d m45214g(GlideContext glideContext, Object obj, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor) {
        boolean z7 = f13793k;
        long m44411b = z7 ? LogTime.m44411b() : 0L;
        EngineKey m45173a = this.f13795b.m45173a(obj, key, i, i2, map, cls, cls2, options);
        EngineResource<?> m45213h = m45213h(m45173a, z3);
        if (m45213h != null) {
            resourceCallback.mo44551c(m45213h, DataSource.MEMORY_CACHE);
            if (z7) {
                m45211j("Loaded resource from active resources", m44411b, m45173a);
            }
            return null;
        }
        EngineResource<?> m45212i = m45212i(m45173a, z3);
        if (m45212i != null) {
            resourceCallback.mo44551c(m45212i, DataSource.MEMORY_CACHE);
            if (z7) {
                m45211j("Loaded resource from cache", m44411b, m45173a);
            }
            return null;
        }
        EngineJob<?> m45146a = this.f13794a.m45146a(m45173a, z6);
        if (m45146a != null) {
            m45146a.m45200a(resourceCallback, executor);
            if (z7) {
                m45211j("Added to existing load", m44411b, m45173a);
            }
            return new C3636d(resourceCallback, m45146a);
        }
        EngineJob<R> m45206a = this.f13797d.m45206a(m45173a, z3, z4, z5, z6);
        DecodeJob<R> m45208a = this.f13800g.m45208a(glideContext, obj, m45173a, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, z6, options, m45206a);
        this.f13794a.m45143d(m45173a, m45206a);
        m45206a.m45200a(resourceCallback, executor);
        m45206a.m45182t(m45208a);
        if (z7) {
            m45211j("Started new load", m44411b, m45173a);
        }
        return new C3636d(resourceCallback, m45206a);
    }

    /* renamed from: k */
    public void m45210k(Resource<?> resource) {
        if (resource instanceof EngineResource) {
            ((EngineResource) resource).m45169e();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @VisibleForTesting
    /* renamed from: l */
    public void m45209l() {
        this.f13797d.m45205b();
        this.f13799f.m45202b();
        this.f13801h.m45422h();
    }

    @VisibleForTesting
    Engine(MemoryCache memoryCache, DiskCache.InterfaceC3592a interfaceC3592a, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Jobs jobs, EngineKeyFactory engineKeyFactory, ActiveResources activeResources, C3633b c3633b, C3631a c3631a, ResourceRecycler resourceRecycler, boolean z) {
        this.f13796c = memoryCache;
        C3635c c3635c = new C3635c(interfaceC3592a);
        this.f13799f = c3635c;
        ActiveResources activeResources2 = activeResources == null ? new ActiveResources(z) : activeResources;
        this.f13801h = activeResources2;
        activeResources2.m45423g(this);
        this.f13795b = engineKeyFactory == null ? new EngineKeyFactory() : engineKeyFactory;
        this.f13794a = jobs == null ? new Jobs() : jobs;
        this.f13797d = c3633b == null ? new C3633b(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this) : c3633b;
        this.f13800g = c3631a == null ? new C3631a(c3635c) : c3631a;
        this.f13798e = resourceRecycler == null ? new ResourceRecycler() : resourceRecycler;
        memoryCache.mo45317f(this);
    }
}
