package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.p;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ActiveResources.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f16863a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f16864b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    final Map<com.bumptech.glide.load.c, d> f16865c;

    /* renamed from: d  reason: collision with root package name */
    private final ReferenceQueue<p<?>> f16866d;

    /* renamed from: e  reason: collision with root package name */
    private p.a f16867e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f16868f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private volatile c f16869g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.load.engine.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class ThreadFactoryC0164a implements ThreadFactory {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: ActiveResources.java */
        /* renamed from: com.bumptech.glide.load.engine.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class RunnableC0165a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Runnable f16870a;

            RunnableC0165a(Runnable runnable) {
                this.f16870a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f16870a.run();
            }
        }

        ThreadFactoryC0164a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0165a(runnable), "glide-active-resources");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ActiveResources.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface c {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class d extends WeakReference<p<?>> {

        /* renamed from: a  reason: collision with root package name */
        final com.bumptech.glide.load.c f16873a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f16874b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        u<?> f16875c;

        d(@NonNull com.bumptech.glide.load.c cVar, @NonNull p<?> pVar, @NonNull ReferenceQueue<? super p<?>> referenceQueue, boolean z3) {
            super(pVar, referenceQueue);
            this.f16873a = (com.bumptech.glide.load.c) com.bumptech.glide.util.j.d(cVar);
            this.f16875c = (pVar.d() && z3) ? (u) com.bumptech.glide.util.j.d(pVar.c()) : null;
            this.f16874b = pVar.d();
        }

        void a() {
            this.f16875c = null;
            clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(boolean z3) {
        this(z3, Executors.newSingleThreadExecutor(new ThreadFactoryC0164a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(com.bumptech.glide.load.c cVar, p<?> pVar) {
        d put = this.f16865c.put(cVar, new d(cVar, pVar, this.f16866d, this.f16863a));
        if (put != null) {
            put.a();
        }
    }

    void b() {
        while (!this.f16868f) {
            try {
                c((d) this.f16866d.remove());
                c cVar = this.f16869g;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(@NonNull d dVar) {
        u<?> uVar;
        synchronized (this.f16867e) {
            synchronized (this) {
                this.f16865c.remove(dVar.f16873a);
                if (dVar.f16874b && (uVar = dVar.f16875c) != null) {
                    p<?> pVar = new p<>(uVar, true, false);
                    pVar.f(dVar.f16873a, this.f16867e);
                    this.f16867e.d(dVar.f16873a, pVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(com.bumptech.glide.load.c cVar) {
        d remove = this.f16865c.remove(cVar);
        if (remove != null) {
            remove.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public synchronized p<?> e(com.bumptech.glide.load.c cVar) {
        d dVar = this.f16865c.get(cVar);
        if (dVar == null) {
            return null;
        }
        p<?> pVar = dVar.get();
        if (pVar == null) {
            c(dVar);
        }
        return pVar;
    }

    @VisibleForTesting
    void f(c cVar) {
        this.f16869g = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f16867e = aVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public void h() {
        this.f16868f = true;
        Executor executor = this.f16864b;
        if (executor instanceof ExecutorService) {
            com.bumptech.glide.util.d.c((ExecutorService) executor);
        }
    }

    @VisibleForTesting
    a(boolean z3, Executor executor) {
        this.f16865c = new HashMap();
        this.f16866d = new ReferenceQueue<>();
        this.f16863a = z3;
        this.f16864b = executor;
        executor.execute(new b());
    }
}
