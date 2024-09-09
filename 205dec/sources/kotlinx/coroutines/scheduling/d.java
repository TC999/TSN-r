package kotlinx.coroutines.scheduling;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.v0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Dispatcher.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010%\u001a\u00020\u000f\u0012\u0006\u0010'\u001a\u00020\u000f\u0012\u0006\u0010*\u001a\u00020\u001b\u0012\b\b\u0002\u0010-\u001a\u00020\r\u00a2\u0006\u0004\b2\u00103B'\b\u0016\u0012\b\b\u0002\u0010%\u001a\u00020\u000f\u0012\b\b\u0002\u0010'\u001a\u00020\u000f\u0012\b\b\u0002\u0010-\u001a\u00020\r\u00a2\u0006\u0004\b2\u00104B\u001d\b\u0017\u0012\b\b\u0002\u0010%\u001a\u00020\u000f\u0012\b\b\u0002\u0010'\u001a\u00020\u000f\u00a2\u0006\u0004\b2\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u001c\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ+\u0010\u0017\u001a\u00020\t2\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0005\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0015H\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u001f\u0010\u001aR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010*\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lkotlinx/coroutines/scheduling/d;", "Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "B", "Lkotlin/coroutines/f;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/f1;", "dispatch", "dispatchYield", "close", "", "toString", "", "parallelism", "Lkotlinx/coroutines/l0;", "t", "D", "Lkotlinx/coroutines/scheduling/j;", "", "tailDispatch", "C", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/j;Z)V", "G", "()V", "", "timeout", "F", "(J)V", "E", "b", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "coroutineScheduler", "c", "I", "corePoolSize", "d", "maxPoolSize", "e", "J", "idleWorkerKeepAliveNs", "f", "Ljava/lang/String;", "schedulerName", "Ljava/util/concurrent/Executor;", CampaignEx.JSON_KEY_AD_Q, "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(IIJLjava/lang/String;)V", "(IILjava/lang/String;)V", "(II)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d extends s1 {

    /* renamed from: b  reason: collision with root package name */
    private CoroutineScheduler f60594b;

    /* renamed from: c  reason: collision with root package name */
    private final int f60595c;

    /* renamed from: d  reason: collision with root package name */
    private final int f60596d;

    /* renamed from: e  reason: collision with root package name */
    private final long f60597e;

    /* renamed from: f  reason: collision with root package name */
    private final String f60598f;

    public /* synthetic */ d(int i4, int i5, long j4, String str, int i6, u uVar) {
        this(i4, i5, j4, (i6 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    private final CoroutineScheduler B() {
        return new CoroutineScheduler(this.f60595c, this.f60596d, this.f60597e, this.f60598f);
    }

    public static /* synthetic */ l0 w(d dVar, int i4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 1) != 0) {
                i4 = l.f60614d;
            }
            return dVar.t(i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
    }

    public final void C(@NotNull Runnable runnable, @NotNull j jVar, boolean z3) {
        try {
            this.f60594b.p(runnable, jVar, z3);
        } catch (RejectedExecutionException unused) {
            v0.f60753m.U(this.f60594b.k(runnable, jVar));
        }
    }

    @NotNull
    public final l0 D(int i4) {
        if (i4 > 0) {
            if (i4 <= this.f60595c) {
                return new f(this, i4, null, 0);
            }
            throw new IllegalArgumentException(("Expected parallelism level lesser than core pool size (" + this.f60595c + "), but have " + i4).toString());
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i4).toString());
    }

    public final void E() {
        G();
    }

    public final synchronized void F(long j4) {
        this.f60594b.C(j4);
    }

    public final synchronized void G() {
        this.f60594b.C(1000L);
        this.f60594b = B();
    }

    @Override // kotlinx.coroutines.s1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f60594b.close();
    }

    @Override // kotlinx.coroutines.l0
    public void dispatch(@NotNull kotlin.coroutines.f fVar, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.q(this.f60594b, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            v0.f60753m.dispatch(fVar, runnable);
        }
    }

    @Override // kotlinx.coroutines.l0
    public void dispatchYield(@NotNull kotlin.coroutines.f fVar, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.q(this.f60594b, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            v0.f60753m.dispatchYield(fVar, runnable);
        }
    }

    @Override // kotlinx.coroutines.s1
    @NotNull
    public Executor q() {
        return this.f60594b;
    }

    @NotNull
    public final l0 t(int i4) {
        if (i4 > 0) {
            return new f(this, i4, null, 1);
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i4).toString());
    }

    @Override // kotlinx.coroutines.l0
    @NotNull
    public String toString() {
        return super.toString() + "[scheduler = " + this.f60594b + ']';
    }

    public d(int i4, int i5, long j4, @NotNull String str) {
        this.f60595c = i4;
        this.f60596d = i5;
        this.f60597e = j4;
        this.f60598f = str;
        this.f60594b = B();
    }

    public /* synthetic */ d(int i4, int i5, String str, int i6, u uVar) {
        this((i6 & 1) != 0 ? l.f60615e : i4, (i6 & 2) != 0 ? l.f60616f : i5, (i6 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    public d(int i4, int i5, @NotNull String str) {
        this(i4, i5, l.f60617g, str);
    }

    public /* synthetic */ d(int i4, int i5, int i6, u uVar) {
        this((i6 & 1) != 0 ? l.f60615e : i4, (i6 & 2) != 0 ? l.f60616f : i5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ d(int i4, int i5) {
        this(i4, i5, l.f60617g, null, 8, null);
    }
}
