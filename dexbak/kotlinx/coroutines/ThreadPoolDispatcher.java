package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, m12616d2 = {"Lkotlinx/coroutines/l3;", "Lkotlinx/coroutines/t1;", "Lkotlin/f1;", "close", "", "toString", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadNo", "Ljava/util/concurrent/Executor;", "d", "Ljava/util/concurrent/Executor;", "p", "()Ljava/util/concurrent/Executor;", "executor", "", "e", "I", "nThreads", "f", "Ljava/lang/String;", "name", "<init>", "(ILjava/lang/String;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.l3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ThreadPoolDispatcher extends AbstractC15226t1 {

    /* renamed from: c */
    private final AtomicInteger f43171c = new AtomicInteger();
    @NotNull

    /* renamed from: d */
    private final Executor f43172d;

    /* renamed from: e */
    private final int f43173e;

    /* renamed from: f */
    private final String f43174f;

    /* compiled from: ThreadPoolDispatcher.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, m12616d2 = {"<anonymous>", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "target", "Ljava/lang/Runnable;", "newThread"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.l3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class ThreadFactoryC15131a implements ThreadFactory {
        ThreadFactoryC15131a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            String str;
            ThreadPoolDispatcher threadPoolDispatcher = ThreadPoolDispatcher.this;
            if (threadPoolDispatcher.f43173e == 1) {
                str = ThreadPoolDispatcher.this.f43174f;
            } else {
                str = ThreadPoolDispatcher.this.f43174f + "-" + ThreadPoolDispatcher.this.f43171c.incrementAndGet();
            }
            return new C15243v2(threadPoolDispatcher, runnable, str);
        }
    }

    public ThreadPoolDispatcher(int i, @NotNull String str) {
        this.f43173e = i;
        this.f43174f = str;
        this.f43172d = Executors.newScheduledThreadPool(i, new ThreadFactoryC15131a());
        m3592r();
    }

    @Override // kotlinx.coroutines.AbstractC15226t1, kotlinx.coroutines.AbstractC15168s1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor mo3514p = mo3514p();
        if (mo3514p == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.ExecutorService");
        }
        ((ExecutorService) mo3514p).shutdown();
    }

    @Override // kotlinx.coroutines.AbstractC15168s1
    @NotNull
    /* renamed from: p */
    public Executor mo3514p() {
        return this.f43172d;
    }

    @Override // kotlinx.coroutines.AbstractC15226t1, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "ThreadPoolDispatcher[" + this.f43173e + ", " + this.f43174f + ']';
    }
}
