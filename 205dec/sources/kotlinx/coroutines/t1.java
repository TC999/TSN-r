package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlinx.coroutines.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Executors.kt */
@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b$\u0010\u0011J*\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u000f\u0010\u0010\u001a\u00020\u000eH\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0016J\u001e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016J$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010 \u001a\u00020\u001fH\u0016R\u0016\u0010#\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006%"}, d2 = {"Lkotlinx/coroutines/t1;", "Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/z0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/coroutines/f;", "context", "", "timeMillis", "Ljava/util/concurrent/ScheduledFuture;", "w", "Ljava/util/concurrent/RejectedExecutionException;", "exception", "Lkotlin/f1;", "r", "t", "()V", "dispatch", "Lkotlinx/coroutines/o;", "continuation", "d", "Lkotlinx/coroutines/i1;", "f", "close", "", "toString", "", "other", "", "equals", "", "hashCode", "b", "Z", "removesFutureOnCancellation", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class t1 extends s1 implements z0 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f60723b;

    private final void r(kotlin.coroutines.f fVar, RejectedExecutionException rejectedExecutionException) {
        h2.g(fVar, r1.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture<?> w(Runnable runnable, kotlin.coroutines.f fVar, long j4) {
        try {
            Executor q3 = q();
            if (!(q3 instanceof ScheduledExecutorService)) {
                q3 = null;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) q3;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService.schedule(runnable, j4, TimeUnit.MILLISECONDS);
            }
            return null;
        } catch (RejectedExecutionException e4) {
            r(fVar, e4);
            return null;
        }
    }

    @Override // kotlinx.coroutines.s1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor q3 = q();
        if (!(q3 instanceof ExecutorService)) {
            q3 = null;
        }
        ExecutorService executorService = (ExecutorService) q3;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.z0
    public void d(long j4, @NotNull o<? super kotlin.f1> oVar) {
        ScheduledFuture<?> w3 = this.f60723b ? w(new z2(this, oVar), oVar.getContext(), j4) : null;
        if (w3 != null) {
            h2.x(oVar, w3);
        } else {
            v0.f60753m.d(j4, oVar);
        }
    }

    @Override // kotlinx.coroutines.l0
    public void dispatch(@NotNull kotlin.coroutines.f fVar, @NotNull Runnable runnable) {
        Runnable runnable2;
        try {
            Executor q3 = q();
            o3 b4 = p3.b();
            if (b4 == null || (runnable2 = b4.g(runnable)) == null) {
                runnable2 = runnable;
            }
            q3.execute(runnable2);
        } catch (RejectedExecutionException e4) {
            o3 b5 = p3.b();
            if (b5 != null) {
                b5.b();
            }
            r(fVar, e4);
            f1.c().dispatch(fVar, runnable);
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof t1) && ((t1) obj).q() == q();
    }

    @Override // kotlinx.coroutines.z0
    @NotNull
    public i1 f(long j4, @NotNull Runnable runnable, @NotNull kotlin.coroutines.f fVar) {
        ScheduledFuture<?> w3 = this.f60723b ? w(runnable, fVar, j4) : null;
        if (w3 != null) {
            return new h1(w3);
        }
        return v0.f60753m.f(j4, runnable, fVar);
    }

    public int hashCode() {
        return System.identityHashCode(q());
    }

    @Override // kotlinx.coroutines.z0
    @Nullable
    public Object o(long j4, @NotNull kotlin.coroutines.c<? super kotlin.f1> cVar) {
        return z0.a.a(this, j4, cVar);
    }

    public final void t() {
        this.f60723b = kotlinx.coroutines.internal.e.c(q());
    }

    @Override // kotlinx.coroutines.l0
    @NotNull
    public String toString() {
        return q().toString();
    }
}
