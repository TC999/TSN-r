package kotlinx.coroutines.scheduling;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.AbstractC15168s1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: Dispatcher.kt */
@InternalCoroutinesApi
@Metadata(m12618bv = {}, m12617d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010%\u001a\u00020\u000f\u0012\u0006\u0010'\u001a\u00020\u000f\u0012\u0006\u0010*\u001a\u00020\u001b\u0012\b\b\u0002\u0010-\u001a\u00020\r¢\u0006\u0004\b2\u00103B'\b\u0016\u0012\b\b\u0002\u0010%\u001a\u00020\u000f\u0012\b\b\u0002\u0010'\u001a\u00020\u000f\u0012\b\b\u0002\u0010-\u001a\u00020\r¢\u0006\u0004\b2\u00104B\u001d\b\u0017\u0012\b\b\u0002\u0010%\u001a\u00020\u000f\u0012\b\b\u0002\u0010'\u001a\u00020\u000f¢\u0006\u0004\b2\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u001c\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ+\u0010\u0017\u001a\u00020\t2\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0005\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0000¢\u0006\u0004\b\u001f\u0010\u001aR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010*\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00066"}, m12616d2 = {"Lkotlinx/coroutines/scheduling/d;", "Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "s", "Lkotlin/coroutines/f;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/f1;", "dispatch", "dispatchYield", "close", "", "toString", "", "parallelism", "Lkotlinx/coroutines/l0;", CampaignEx.JSON_KEY_AD_Q, "v", "Lkotlinx/coroutines/scheduling/j;", "", "tailDispatch", "u", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/j;Z)V", "F", "()V", "", "timeout", "C", "(J)V", "B", "b", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "coroutineScheduler", "c", "I", "corePoolSize", "d", "maxPoolSize", "e", "J", "idleWorkerKeepAliveNs", "f", "Ljava/lang/String;", "schedulerName", "Ljava/util/concurrent/Executor;", "p", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(IIJLjava/lang/String;)V", "(IILjava/lang/String;)V", "(II)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.scheduling.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C15177d extends AbstractC15168s1 {

    /* renamed from: b */
    private CoroutineScheduler f43277b;

    /* renamed from: c */
    private final int f43278c;

    /* renamed from: d */
    private final int f43279d;

    /* renamed from: e */
    private final long f43280e;

    /* renamed from: f */
    private final String f43281f;

    public /* synthetic */ C15177d(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j, (i3 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    /* renamed from: r */
    public static /* synthetic */ CoroutineDispatcher m3745r(C15177d c15177d, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = C15184l.f43297d;
            }
            return c15177d.m3746q(i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
    }

    /* renamed from: s */
    private final CoroutineScheduler m3744s() {
        return new CoroutineScheduler(this.f43278c, this.f43279d, this.f43280e, this.f43281f);
    }

    /* renamed from: B */
    public final void m3749B() {
        m3747F();
    }

    /* renamed from: C */
    public final synchronized void m3748C(long j) {
        this.f43277b.m3800J(j);
    }

    /* renamed from: F */
    public final synchronized void m3747F() {
        this.f43277b.m3800J(1000L);
        this.f43277b = m3744s();
    }

    @Override // kotlinx.coroutines.AbstractC15168s1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f43277b.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.m3776r(this.f43277b, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.f43436m.dispatch(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.m3776r(this.f43277b, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.f43436m.dispatchYield(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.AbstractC15168s1
    @NotNull
    /* renamed from: p */
    public Executor mo3514p() {
        return this.f43277b;
    }

    @NotNull
    /* renamed from: q */
    public final CoroutineDispatcher m3746q(int i) {
        if (i > 0) {
            return new ExecutorC15178f(this, i, null, 1);
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i).toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return super.toString() + "[scheduler = " + this.f43277b + ']';
    }

    /* renamed from: u */
    public final void m3743u(@NotNull Runnable runnable, @NotNull InterfaceC15182j interfaceC15182j, boolean z) {
        try {
            this.f43277b.m3777q(runnable, interfaceC15182j, z);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.f43436m.m3961W(this.f43277b.m3782k(runnable, interfaceC15182j));
        }
    }

    @NotNull
    /* renamed from: v */
    public final CoroutineDispatcher m3742v(int i) {
        if (i > 0) {
            if (i <= this.f43278c) {
                return new ExecutorC15178f(this, i, null, 0);
            }
            throw new IllegalArgumentException(("Expected parallelism level lesser than core pool size (" + this.f43278c + "), but have " + i).toString());
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i).toString());
    }

    public C15177d(int i, int i2, long j, @NotNull String str) {
        this.f43278c = i;
        this.f43279d = i2;
        this.f43280e = j;
        this.f43281f = str;
        this.f43277b = m3744s();
    }

    public /* synthetic */ C15177d(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? C15184l.f43298e : i, (i3 & 2) != 0 ? C15184l.f43299f : i2, (i3 & 4) != 0 ? C15184l.f43295b : str);
    }

    public C15177d(int i, int i2, @NotNull String str) {
        this(i, i2, C15184l.f43300g, str);
    }

    public /* synthetic */ C15177d(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? C15184l.f43298e : i, (i3 & 2) != 0 ? C15184l.f43299f : i2);
    }

    @Annotations(level = DeprecationLevel.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ C15177d(int i, int i2) {
        this(i, i2, C15184l.f43300g, null, 8, null);
    }
}
