package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
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
import kotlin.coroutines.CoroutineContext;
import kotlin.ranges._Ranges;
import kotlin.text.StringNumberConversions;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b2\u0010\u0019J&\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0082\b¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J#\u0010\u0010\u001a\u00020\u000f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\n\u0010\u0004\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u000f\u0010\u0018\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001e\u0010\u0019J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u0016H\u0016R\u0014\u0010$\u001a\u00020\u001f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0018R\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010\u000e\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00063"}, m12616d2 = {"Lkotlinx/coroutines/x;", "Lkotlinx/coroutines/s1;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "block", CampaignEx.JSON_KEY_AD_Q, "(Ll1/a;)Ljava/lang/Object;", "Ljava/util/concurrent/ExecutorService;", "s", "r", "Ljava/util/concurrent/Executor;", "B", "Ljava/lang/Class;", "fjpClass", "executor", "", "F", "(Ljava/lang/Class;Ljava/util/concurrent/ExecutorService;)Z", "Lkotlin/coroutines/f;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlin/f1;", "dispatch", "I", "()V", "", "timeout", "H", "(J)V", "G", "", "toString", "close", "b", "Ljava/lang/String;", "DEFAULT_PARALLELISM_PROPERTY_NAME", "", "c", "requestedParallelism", "d", "Z", "usePrivatePool", "pool", "Ljava/util/concurrent/Executor;", "C", "()I", "parallelism", "p", "()Ljava/util/concurrent/Executor;", "<init>", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.x */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CommonPool extends AbstractC15168s1 {
    @NotNull

    /* renamed from: b */
    public static final String f43441b = "kotlinx.coroutines.default.parallelism";

    /* renamed from: c */
    private static final int f43442c;

    /* renamed from: d */
    private static boolean f43443d;

    /* renamed from: e */
    public static final CommonPool f43444e = new CommonPool();
    private static volatile Executor pool;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonPool.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, m12616d2 = {"<anonymous>", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "it", "Ljava/lang/Runnable;", "newThread"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.x$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class ThreadFactoryC15249a implements ThreadFactory {

        /* renamed from: a */
        final /* synthetic */ AtomicInteger f43445a;

        ThreadFactoryC15249a(AtomicInteger atomicInteger) {
            this.f43445a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "CommonPool-worker-" + this.f43445a.incrementAndGet());
            thread.setDaemon(true);
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonPool.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, m12616d2 = {"Lkotlin/f1;", "run", "()V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.x$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class RunnableC15250b implements Runnable {

        /* renamed from: a */
        public static final RunnableC15250b f43446a = new RunnableC15250b();

        RunnableC15250b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonPool.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "it", "Lkotlin/f1;", "execute", "(Ljava/lang/Runnable;)V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.x$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class ExecutorC15251c implements Executor {

        /* renamed from: a */
        public static final ExecutorC15251c f43447a = new ExecutorC15251c();

        ExecutorC15251c() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            throw new RejectedExecutionException("CommonPool was shutdown");
        }
    }

    static {
        String str;
        int i;
        Integer m6630X0;
        try {
            str = System.getProperty(f43441b);
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null) {
            m6630X0 = StringNumberConversions.m6630X0(str);
            if (m6630X0 != null && m6630X0.intValue() >= 1) {
                i = m6630X0.intValue();
            } else {
                throw new IllegalStateException(("Expected positive number in kotlinx.coroutines.default.parallelism, but has " + str).toString());
            }
        } else {
            i = -1;
        }
        f43442c = i;
    }

    private CommonPool() {
    }

    /* renamed from: B */
    private final synchronized Executor m3520B() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = m3511s();
            pool = executor;
        }
        return executor;
    }

    /* renamed from: C */
    private final int m3519C() {
        int m7481n;
        Integer valueOf = Integer.valueOf(f43442c);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        m7481n = _Ranges.m7481n(Runtime.getRuntime().availableProcessors() - 1, 1);
        return m7481n;
    }

    /* renamed from: q */
    private final <T> T m3513q(InterfaceC15269a<? extends T> interfaceC15269a) {
        try {
            return interfaceC15269a.invoke();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: r */
    private final ExecutorService m3512r() {
        return Executors.newFixedThreadPool(m3519C(), new ThreadFactoryC15249a(new AtomicInteger()));
    }

    /* renamed from: s */
    private final ExecutorService m3511s() {
        Class<?> cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return m3512r();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            if (!f43443d && f43442c < 0) {
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
                    if (!f43444e.m3518F(cls, executorService)) {
                        executorService = null;
                    }
                    if (executorService != null) {
                        return executorService;
                    }
                }
            }
            try {
                Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(f43444e.m3519C()));
                if (!(newInstance instanceof ExecutorService)) {
                    newInstance = null;
                }
                executorService2 = (ExecutorService) newInstance;
            } catch (Throwable unused3) {
            }
            return executorService2 != null ? executorService2 : m3512r();
        }
        return m3512r();
    }

    /* renamed from: F */
    public final boolean m3518F(@NotNull Class<?> cls, @NotNull ExecutorService executorService) {
        executorService.submit(RunnableC15250b.f43446a);
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

    /* renamed from: G */
    public final synchronized void m3517G() {
        m3516H(0L);
        f43443d = false;
        pool = null;
    }

    /* renamed from: H */
    public final synchronized void m3516H(long j) {
        Executor executor = pool;
        if (!(executor instanceof ExecutorService)) {
            executor = null;
        }
        ExecutorService executorService = (ExecutorService) executor;
        if (executorService != null) {
            executorService.shutdown();
            if (j > 0) {
                executorService.awaitTermination(j, TimeUnit.MILLISECONDS);
            }
            for (Runnable runnable : executorService.shutdownNow()) {
                DefaultExecutor.f43436m.m3961W(runnable);
            }
        }
        pool = ExecutorC15251c.f43447a;
    }

    /* renamed from: I */
    public final synchronized void m3515I() {
        m3516H(0L);
        f43443d = true;
        pool = null;
    }

    @Override // kotlinx.coroutines.AbstractC15168s1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Runnable runnable2;
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = m3520B();
            }
            InterfaceC15152o3 m3872b = C15156p3.m3872b();
            if (m3872b == null || (runnable2 = m3872b.m3926g(runnable)) == null) {
                runnable2 = runnable;
            }
            executor.execute(runnable2);
        } catch (RejectedExecutionException unused) {
            InterfaceC15152o3 m3872b2 = C15156p3.m3872b();
            if (m3872b2 != null) {
                m3872b2.m3931b();
            }
            DefaultExecutor.f43436m.m3961W(runnable);
        }
    }

    @Override // kotlinx.coroutines.AbstractC15168s1
    @NotNull
    /* renamed from: p */
    public Executor mo3514p() {
        Executor executor = pool;
        return executor != null ? executor : m3520B();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "CommonPool";
    }
}
