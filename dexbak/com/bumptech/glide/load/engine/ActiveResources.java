package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.util.C3770j;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bumptech.glide.load.engine.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ActiveResources {

    /* renamed from: a */
    private final boolean f13540a;

    /* renamed from: b */
    private final Executor f13541b;
    @VisibleForTesting

    /* renamed from: c */
    final Map<Key, C3578d> f13542c;

    /* renamed from: d */
    private final ReferenceQueue<EngineResource<?>> f13543d;

    /* renamed from: e */
    private EngineResource.InterfaceC3642a f13544e;

    /* renamed from: f */
    private volatile boolean f13545f;
    @Nullable

    /* renamed from: g */
    private volatile InterfaceC3577c f13546g;

    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.load.engine.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class ThreadFactoryC3574a implements ThreadFactory {

        /* compiled from: ActiveResources.java */
        /* renamed from: com.bumptech.glide.load.engine.a$a$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class RunnableC3575a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Runnable f13547a;

            RunnableC3575a(Runnable runnable) {
                this.f13547a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f13547a.run();
            }
        }

        ThreadFactoryC3574a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC3575a(runnable), "glide-active-resources");
        }
    }

    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.load.engine.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class RunnableC3576b implements Runnable {
        RunnableC3576b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActiveResources.this.m45428b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.a$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3577c {
        /* renamed from: a */
        void m45421a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.a$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3578d extends WeakReference<EngineResource<?>> {

        /* renamed from: a */
        final Key f13550a;

        /* renamed from: b */
        final boolean f13551b;
        @Nullable

        /* renamed from: c */
        Resource<?> f13552c;

        C3578d(@NonNull Key key, @NonNull EngineResource<?> engineResource, @NonNull ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z) {
            super(engineResource, referenceQueue);
            this.f13550a = (Key) C3770j.m44392d(key);
            this.f13552c = (engineResource.m45170d() && z) ? (Resource) C3770j.m44392d(engineResource.m45171c()) : null;
            this.f13551b = engineResource.m45170d();
        }

        /* renamed from: a */
        void m45420a() {
            this.f13552c = null;
            clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActiveResources(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactoryC3574a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m45429a(Key key, EngineResource<?> engineResource) {
        C3578d put = this.f13542c.put(key, new C3578d(key, engineResource, this.f13543d, this.f13540a));
        if (put != null) {
            put.m45420a();
        }
    }

    /* renamed from: b */
    void m45428b() {
        while (!this.f13545f) {
            try {
                m45427c((C3578d) this.f13543d.remove());
                InterfaceC3577c interfaceC3577c = this.f13546g;
                if (interfaceC3577c != null) {
                    interfaceC3577c.m45421a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* renamed from: c */
    void m45427c(@NonNull C3578d c3578d) {
        Resource<?> resource;
        synchronized (this.f13544e) {
            synchronized (this) {
                this.f13542c.remove(c3578d.f13550a);
                if (c3578d.f13551b && (resource = c3578d.f13552c) != null) {
                    EngineResource<?> engineResource = new EngineResource<>(resource, true, false);
                    engineResource.m45168f(c3578d.f13550a, this.f13544e);
                    this.f13544e.mo45167d(c3578d.f13550a, engineResource);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized void m45426d(Key key) {
        C3578d remove = this.f13542c.remove(key);
        if (remove != null) {
            remove.m45420a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: e */
    public synchronized EngineResource<?> m45425e(Key key) {
        C3578d c3578d = this.f13542c.get(key);
        if (c3578d == null) {
            return null;
        }
        EngineResource<?> engineResource = c3578d.get();
        if (engineResource == null) {
            m45427c(c3578d);
        }
        return engineResource;
    }

    @VisibleForTesting
    /* renamed from: f */
    void m45424f(InterfaceC3577c interfaceC3577c) {
        this.f13546g = interfaceC3577c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m45423g(EngineResource.InterfaceC3642a interfaceC3642a) {
        synchronized (interfaceC3642a) {
            synchronized (this) {
                this.f13544e = interfaceC3642a;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: h */
    public void m45422h() {
        this.f13545f = true;
        Executor executor = this.f13541b;
        if (executor instanceof ExecutorService) {
            com.bumptech.glide.util.Executors.m44413c((ExecutorService) executor);
        }
    }

    @VisibleForTesting
    ActiveResources(boolean z, Executor executor) {
        this.f13542c = new HashMap();
        this.f13543d = new ReferenceQueue<>();
        this.f13540a = z;
        this.f13541b = executor;
        executor.execute(new RunnableC3576b());
    }
}
