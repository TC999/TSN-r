package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ThreadPoolDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/l3;", "Lkotlinx/coroutines/t1;", "Lkotlin/f1;", "close", "", "toString", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadNo", "Ljava/util/concurrent/Executor;", "d", "Ljava/util/concurrent/Executor;", CampaignEx.JSON_KEY_AD_Q, "()Ljava/util/concurrent/Executor;", "executor", "", "e", "I", "nThreads", "f", "Ljava/lang/String;", "name", "<init>", "(ILjava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l3 extends t1 {

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f60488c = new AtomicInteger();
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Executor f60489d;

    /* renamed from: e  reason: collision with root package name */
    private final int f60490e;

    /* renamed from: f  reason: collision with root package name */
    private final String f60491f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ThreadPoolDispatcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "target", "Ljava/lang/Runnable;", "newThread"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            String str;
            l3 l3Var = l3.this;
            if (l3Var.f60490e == 1) {
                str = l3.this.f60491f;
            } else {
                str = l3.this.f60491f + "-" + l3.this.f60488c.incrementAndGet();
            }
            return new v2(l3Var, runnable, str);
        }
    }

    public l3(int i4, @NotNull String str) {
        this.f60490e = i4;
        this.f60491f = str;
        this.f60489d = Executors.newScheduledThreadPool(i4, new a());
        t();
    }

    @Override // kotlinx.coroutines.t1, kotlinx.coroutines.s1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor q3 = q();
        if (q3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.ExecutorService");
        }
        ((ExecutorService) q3).shutdown();
    }

    @Override // kotlinx.coroutines.s1
    @NotNull
    public Executor q() {
        return this.f60489d;
    }

    @Override // kotlinx.coroutines.t1, kotlinx.coroutines.l0
    @NotNull
    public String toString() {
        return "ThreadPoolDispatcher[" + this.f60490e + ", " + this.f60491f + ']';
    }
}
