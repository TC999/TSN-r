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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GlideExecutor.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class a implements ExecutorService {

    /* renamed from: b  reason: collision with root package name */
    private static final String f17007b = "source";

    /* renamed from: c  reason: collision with root package name */
    private static final String f17008c = "disk-cache";

    /* renamed from: d  reason: collision with root package name */
    private static final int f17009d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final String f17010e = "GlideExecutor";

    /* renamed from: f  reason: collision with root package name */
    private static final String f17011f = "source-unlimited";

    /* renamed from: g  reason: collision with root package name */
    private static final String f17012g = "animation";

    /* renamed from: h  reason: collision with root package name */
    private static final long f17013h = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: i  reason: collision with root package name */
    private static final int f17014i = 4;

    /* renamed from: j  reason: collision with root package name */
    private static volatile int f17015j;

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f17016a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.load.engine.executor.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class ThreadFactoryC0167a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        private static final int f17017e = 9;

        /* renamed from: a  reason: collision with root package name */
        private final String f17018a;

        /* renamed from: b  reason: collision with root package name */
        final b f17019b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f17020c;

        /* renamed from: d  reason: collision with root package name */
        private int f17021d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.engine.executor.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class C0168a extends Thread {
            C0168a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (ThreadFactoryC0167a.this.f17020c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    ThreadFactoryC0167a.this.f17019b.a(th);
                }
            }
        }

        ThreadFactoryC0167a(String str, b bVar, boolean z3) {
            this.f17018a = str;
            this.f17019b = bVar;
            this.f17020c = z3;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C0168a c0168a;
            c0168a = new C0168a(runnable, "glide-" + this.f17018a + "-thread-" + this.f17021d);
            this.f17021d = this.f17021d + 1;
            return c0168a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: GlideExecutor.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f17023a = new C0169a();

        /* renamed from: b  reason: collision with root package name */
        public static final b f17024b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f17025c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f17026d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.engine.executor.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class C0169a implements b {
            C0169a() {
            }

            @Override // com.bumptech.glide.load.engine.executor.a.b
            public void a(Throwable th) {
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.engine.executor.a$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class C0170b implements b {
            C0170b() {
            }

            @Override // com.bumptech.glide.load.engine.executor.a.b
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: GlideExecutor.java */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class c implements b {
            c() {
            }

            @Override // com.bumptech.glide.load.engine.executor.a.b
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            C0170b c0170b = new C0170b();
            f17024b = c0170b;
            f17025c = new c();
            f17026d = c0170b;
        }

        void a(Throwable th);
    }

    @VisibleForTesting
    a(ExecutorService executorService) {
        this.f17016a = executorService;
    }

    public static int a() {
        if (f17015j == 0) {
            f17015j = Math.min(4, com.bumptech.glide.load.engine.executor.b.a());
        }
        return f17015j;
    }

    public static a b() {
        return c(a() >= 4 ? 2 : 1, b.f17026d);
    }

    public static a c(int i4, b bVar) {
        return new a(new ThreadPoolExecutor(0, i4, f17013h, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0167a("animation", bVar, true)));
    }

    public static a d() {
        return e(1, "disk-cache", b.f17026d);
    }

    public static a e(int i4, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i4, i4, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0167a(str, bVar, true)));
    }

    public static a f(b bVar) {
        return e(1, "disk-cache", bVar);
    }

    public static a g() {
        return h(a(), "source", b.f17026d);
    }

    public static a h(int i4, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i4, i4, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0167a(str, bVar, false)));
    }

    public static a i(b bVar) {
        return h(a(), "source", bVar);
    }

    public static a j() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f17013h, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0167a("source-unlimited", b.f17026d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j4, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f17016a.awaitTermination(j4, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f17016a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f17016a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f17016a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f17016a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f17016a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f17016a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f17016a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f17016a.submit(runnable);
    }

    public String toString() {
        return this.f17016a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j4, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f17016a.invokeAll(collection, j4, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j4, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f17016a.invokeAny(collection, j4, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t3) {
        return this.f17016a.submit(runnable, t3);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f17016a.submit(callable);
    }
}
