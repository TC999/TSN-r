package androidx.lifecycle;

import androidx.annotation.MainThread;
import d2.a;
import d2.p;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.j;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CoroutineLiveData.kt */
@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Be\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012-\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013\u00a2\u0006\u0002\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Landroidx/lifecycle/BlockRunner;", "T", "", "Lkotlin/f1;", "maybeRun", "cancel", "Lkotlinx/coroutines/e2;", "runningJob", "Lkotlinx/coroutines/e2;", "cancellationJob", "Landroidx/lifecycle/CoroutineLiveData;", "liveData", "Landroidx/lifecycle/CoroutineLiveData;", "", "timeoutInMs", "J", "Lkotlinx/coroutines/q0;", "scope", "Lkotlinx/coroutines/q0;", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/c;", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlin/Function0;", "onDone", "<init>", "(Landroidx/lifecycle/CoroutineLiveData;Ld2/p;JLkotlinx/coroutines/q0;Ld2/a;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class BlockRunner<T> {
    private final p<LiveDataScope<T>, c<? super f1>, Object> block;
    private e2 cancellationJob;
    private final CoroutineLiveData<T> liveData;
    private final a<f1> onDone;
    private e2 runningJob;
    private final q0 scope;
    private final long timeoutInMs;

    /* JADX WARN: Multi-variable type inference failed */
    public BlockRunner(@NotNull CoroutineLiveData<T> liveData, @NotNull p<? super LiveDataScope<T>, ? super c<? super f1>, ? extends Object> block, long j4, @NotNull q0 scope, @NotNull a<f1> onDone) {
        f0.p(liveData, "liveData");
        f0.p(block, "block");
        f0.p(scope, "scope");
        f0.p(onDone, "onDone");
        this.liveData = liveData;
        this.block = block;
        this.timeoutInMs = j4;
        this.scope = scope;
        this.onDone = onDone;
    }

    @MainThread
    public final void cancel() {
        e2 f4;
        if (this.cancellationJob == null) {
            f4 = j.f(this.scope, kotlinx.coroutines.f1.e().q(), null, new BlockRunner$cancel$1(this, null), 2, null);
            this.cancellationJob = f4;
            return;
        }
        throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
    }

    @MainThread
    public final void maybeRun() {
        e2 f4;
        e2 e2Var = this.cancellationJob;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        f4 = j.f(this.scope, null, null, new BlockRunner$maybeRun$1(this, null), 3, null);
        this.runningJob = f4;
    }
}
