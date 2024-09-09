package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CommonPool.kt */
@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u0010\u0019J&\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0082\b\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J#\u0010\u0010\u001a\u00020\u000f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\n\u0010\u0004\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u000f\u0010\u0018\u001a\u00020\u0016H\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001aH\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0016H\u0000\u00a2\u0006\u0004\b\u001e\u0010\u0019J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u0016H\u0016R\u0014\u0010$\u001a\u00020\u001f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020%8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u0010\u000e\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u00064"}, d2 = {"Lkotlinx/coroutines/x;", "Lkotlinx/coroutines/s1;", "T", "Lkotlin/Function0;", "block", "r", "(Ld2/a;)Ljava/lang/Object;", "Ljava/util/concurrent/ExecutorService;", "B", "t", "Ljava/util/concurrent/Executor;", "C", "Ljava/lang/Class;", "fjpClass", "executor", "", "E", "(Ljava/lang/Class;Ljava/util/concurrent/ExecutorService;)Z", "Lkotlin/coroutines/f;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlin/f1;", "dispatch", "H", "()V", "", "timeout", "G", "(J)V", "F", "", "toString", "close", "b", "Ljava/lang/String;", "DEFAULT_PARALLELISM_PROPERTY_NAME", "", "c", "I", "requestedParallelism", "d", "Z", "usePrivatePool", "pool", "Ljava/util/concurrent/Executor;", "D", "()I", "parallelism", CampaignEx.JSON_KEY_AD_Q, "()Ljava/util/concurrent/Executor;", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x extends s1 {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final String f60758b = "kotlinx.coroutines.default.parallelism";

    /* renamed from: c  reason: collision with root package name */
    private static final int f60759c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f60760d;

    /* renamed from: e  reason: collision with root package name */
    public static final x f60761e = new x();
    private static volatile Executor pool;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CommonPool.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "it", "Ljava/lang/Runnable;", "newThread"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f60762a;

        a(AtomicInteger atomicInteger) {
            this.f60762a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "CommonPool-worker-" + this.f60762a.incrementAndGet());
            thread.setDaemon(true);
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CommonPool.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/f1;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final b f60763a = new b();

        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CommonPool.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "it", "Lkotlin/f1;", "execute", "(Ljava/lang/Runnable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public static final c f60764a = new c();

        c() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            throw new RejectedExecutionException("CommonPool was shutdown");
        }
    }

    static {
        String str;
        int i4;
        Integer X0;
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null) {
            X0 = kotlin.text.v.X0(str);
            if (X0 != null && X0.intValue() >= 1) {
                i4 = X0.intValue();
            } else {
                throw new IllegalStateException(("Expected positive number in kotlinx.coroutines.default.parallelism, but has " + str).toString());
            }
        } else {
            i4 = -1;
        }
        f60759c = i4;
    }

    private x() {
    }

    private final ExecutorService B() {
        Class<?> cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return t();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            if (!f60760d && f60759c < 0) {
                try {
                    Method method = cls.getMethod("commonPool", new Class[0]);
                    Object invoke = method != null ? method.invoke(null, new Object[0]) : null;
                    if (!(invoke instanceof ExecutorService)) {
                        invoke = null;
                    }
                    executorService = (ExecutorService) invoke;
                } catch (Throwable unused2) {
                    executorService = null;
                }
                if (executorService != null) {
                    if (!f60761e.E(cls, executorService)) {
                        executorService = null;
                    }
                    if (executorService != null) {
                        return executorService;
                    }
                }
            }
            try {
                Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(f60761e.D()));
                if (!(newInstance instanceof ExecutorService)) {
                    newInstance = null;
                }
                executorService2 = (ExecutorService) newInstance;
            } catch (Throwable unused3) {
            }
            return executorService2 != null ? executorService2 : t();
        }
        return t();
    }

    private final synchronized Executor C() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = B();
            pool = executor;
        }
        return executor;
    }

    private final int D() {
        int n4;
        Integer valueOf = Integer.valueOf(f60759c);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        n4 = kotlin.ranges.q.n(Runtime.getRuntime().availableProcessors() - 1, 1);
        return n4;
    }

    private final <T> T r(d2.a<? extends T> aVar) {
        try {
            return aVar.invoke();
        } catch (Throwable unused) {
            return null;
        }
    }

    private final ExecutorService t() {
        return Executors.newFixedThreadPool(D(), new a(new AtomicInteger()));
    }

    public final boolean E(@NotNull Class<?> cls, @NotNull ExecutorService executorService) {
        executorService.submit(b.f60763a);
        Integer num = null;
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(invoke instanceof Integer)) {
                invoke = null;
            }
            num = (Integer) invoke;
        } catch (Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }

    public final synchronized void F() {
        G(0L);
        f60760d = false;
        pool = null;
    }

    public final synchronized void G(long j4) {
        Executor executor = pool;
        if (!(executor instanceof ExecutorService)) {
            executor = null;
        }
        ExecutorService executorService = (ExecutorService) executor;
        if (executorService != null) {
            executorService.shutdown();
            if (j4 > 0) {
                executorService.awaitTermination(j4, TimeUnit.MILLISECONDS);
            }
            for (Runnable runnable : executorService.shutdownNow()) {
                v0.f60753m.U(runnable);
            }
        }
        pool = c.f60764a;
    }

    public final synchronized void H() {
        G(0L);
        f60760d = true;
        pool = null;
    }

    @Override // kotlinx.coroutines.s1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.l0
    public void dispatch(@NotNull kotlin.coroutines.f fVar, @NotNull Runnable runnable) {
        Runnable runnable2;
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = C();
            }
            o3 b4 = p3.b();
            if (b4 == null || (runnable2 = b4.g(runnable)) == null) {
                runnable2 = runnable;
            }
            executor.execute(runnable2);
        } catch (RejectedExecutionException unused) {
            o3 b5 = p3.b();
            if (b5 != null) {
                b5.b();
            }
            v0.f60753m.U(runnable);
        }
    }

    @Override // kotlinx.coroutines.s1
    @NotNull
    public Executor q() {
        Executor executor = pool;
        return executor != null ? executor : C();
    }

    @Override // kotlinx.coroutines.l0
    @NotNull
    public String toString() {
        return "CommonPool";
    }
}
