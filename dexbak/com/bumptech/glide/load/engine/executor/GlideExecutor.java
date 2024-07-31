package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.bumptech.glide.load.engine.executor.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class GlideExecutor implements ExecutorService {

    /* renamed from: b */
    private static final String f13684b = "source";

    /* renamed from: c */
    private static final String f13685c = "disk-cache";

    /* renamed from: d */
    private static final int f13686d = 1;

    /* renamed from: e */
    private static final String f13687e = "GlideExecutor";

    /* renamed from: f */
    private static final String f13688f = "source-unlimited";

    /* renamed from: g */
    private static final String f13689g = "animation";

    /* renamed from: h */
    private static final long f13690h = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: i */
    private static final int f13691i = 4;

    /* renamed from: j */
    private static volatile int f13692j;

    /* renamed from: a */
    private final ExecutorService f13693a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.load.engine.executor.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class ThreadFactoryC3609a implements ThreadFactory {

        /* renamed from: e */
        private static final int f13694e = 9;

        /* renamed from: a */
        private final String f13695a;

        /* renamed from: b */
        final InterfaceC3611b f13696b;

        /* renamed from: c */
        final boolean f13697c;

        /* renamed from: d */
        private int f13698d;

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.engine.executor.a$a$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3610a extends Thread {
            C3610a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (ThreadFactoryC3609a.this.f13697c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    ThreadFactoryC3609a.this.f13696b.mo45285a(th);
                }
            }
        }

        ThreadFactoryC3609a(String str, InterfaceC3611b interfaceC3611b, boolean z) {
            this.f13695a = str;
            this.f13696b = interfaceC3611b;
            this.f13697c = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C3610a c3610a;
            c3610a = new C3610a(runnable, "glide-" + this.f13695a + "-thread-" + this.f13698d);
            this.f13698d = this.f13698d + 1;
            return c3610a;
        }
    }

    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.load.engine.executor.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3611b {

        /* renamed from: a */
        public static final InterfaceC3611b f13700a = new C3612a();

        /* renamed from: b */
        public static final InterfaceC3611b f13701b;

        /* renamed from: c */
        public static final InterfaceC3611b f13702c;

        /* renamed from: d */
        public static final InterfaceC3611b f13703d;

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.engine.executor.a$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3612a implements InterfaceC3611b {
            C3612a() {
            }

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.InterfaceC3611b
            /* renamed from: a */
            public void mo45285a(Throwable th) {
            }
        }

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.engine.executor.a$b$b */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3613b implements InterfaceC3611b {
            C3613b() {
            }

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.InterfaceC3611b
            /* renamed from: a */
            public void mo45285a(Throwable th) {
                if (th == null || !Log.isLoggable(GlideExecutor.f13687e, 6)) {
                    return;
                }
                Log.e(GlideExecutor.f13687e, "Request threw uncaught throwable", th);
            }
        }

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.engine.executor.a$b$c */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3614c implements InterfaceC3611b {
            C3614c() {
            }

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.InterfaceC3611b
            /* renamed from: a */
            public void mo45285a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            C3613b c3613b = new C3613b();
            f13701b = c3613b;
            f13702c = new C3614c();
            f13703d = c3613b;
        }

        /* renamed from: a */
        void mo45285a(Throwable th);
    }

    @VisibleForTesting
    GlideExecutor(ExecutorService executorService) {
        this.f13693a = executorService;
    }

    /* renamed from: a */
    public static int m45295a() {
        if (f13692j == 0) {
            f13692j = Math.min(4, RuntimeCompat.m45284a());
        }
        return f13692j;
    }

    /* renamed from: b */
    public static GlideExecutor m45294b() {
        return m45293c(m45295a() >= 4 ? 2 : 1, InterfaceC3611b.f13703d);
    }

    /* renamed from: c */
    public static GlideExecutor m45293c(int i, InterfaceC3611b interfaceC3611b) {
        return new GlideExecutor(new ThreadPoolExecutor(0, i, f13690h, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC3609a(f13689g, interfaceC3611b, true)));
    }

    /* renamed from: d */
    public static GlideExecutor m45292d() {
        return m45291e(1, f13685c, InterfaceC3611b.f13703d);
    }

    /* renamed from: e */
    public static GlideExecutor m45291e(int i, String str, InterfaceC3611b interfaceC3611b) {
        return new GlideExecutor(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC3609a(str, interfaceC3611b, true)));
    }

    /* renamed from: f */
    public static GlideExecutor m45290f(InterfaceC3611b interfaceC3611b) {
        return m45291e(1, f13685c, interfaceC3611b);
    }

    /* renamed from: g */
    public static GlideExecutor m45289g() {
        return m45288h(m45295a(), "source", InterfaceC3611b.f13703d);
    }

    /* renamed from: h */
    public static GlideExecutor m45288h(int i, String str, InterfaceC3611b interfaceC3611b) {
        return new GlideExecutor(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC3609a(str, interfaceC3611b, false)));
    }

    /* renamed from: i */
    public static GlideExecutor m45287i(InterfaceC3611b interfaceC3611b) {
        return m45288h(m45295a(), "source", interfaceC3611b);
    }

    /* renamed from: j */
    public static GlideExecutor m45286j() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f13690h, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC3609a(f13688f, InterfaceC3611b.f13703d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f13693a.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f13693a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f13693a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f13693a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f13693a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f13693a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f13693a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f13693a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f13693a.submit(runnable);
    }

    public String toString() {
        return this.f13693a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f13693a.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f13693a.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f13693a.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f13693a.submit(callable);
    }
}
