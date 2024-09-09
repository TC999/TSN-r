package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.i1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CoroutineLiveData.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0010\u0019\u001a\u00020\f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Landroidx/lifecycle/LiveDataScopeImpl;", "T", "Landroidx/lifecycle/LiveDataScope;", "Landroidx/lifecycle/LiveData;", "source", "Lkotlinx/coroutines/i1;", "emitSource", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/c;)Ljava/lang/Object;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/f;", "coroutineContext", "Lkotlin/coroutines/f;", "Landroidx/lifecycle/CoroutineLiveData;", "target", "Landroidx/lifecycle/CoroutineLiveData;", "getTarget$lifecycle_livedata_ktx_release", "()Landroidx/lifecycle/CoroutineLiveData;", "setTarget$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/CoroutineLiveData;)V", "getLatestValue", "()Ljava/lang/Object;", "latestValue", "context", "<init>", "(Landroidx/lifecycle/CoroutineLiveData;Lkotlin/coroutines/f;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {
    private final f coroutineContext;
    @NotNull
    private CoroutineLiveData<T> target;

    public LiveDataScopeImpl(@NotNull CoroutineLiveData<T> target, @NotNull f context) {
        f0.p(target, "target");
        f0.p(context, "context");
        this.target = target;
        this.coroutineContext = context.plus(f1.e().q());
    }

    @Override // androidx.lifecycle.LiveDataScope
    @Nullable
    public Object emit(T t3, @NotNull c<? super kotlin.f1> cVar) {
        Object h4;
        Object i4 = h.i(this.coroutineContext, new LiveDataScopeImpl$emit$2(this, t3, null), cVar);
        h4 = b.h();
        return i4 == h4 ? i4 : kotlin.f1.f55527a;
    }

    @Override // androidx.lifecycle.LiveDataScope
    @Nullable
    public Object emitSource(@NotNull LiveData<T> liveData, @NotNull c<? super i1> cVar) {
        return h.i(this.coroutineContext, new LiveDataScopeImpl$emitSource$2(this, liveData, null), cVar);
    }

    @Override // androidx.lifecycle.LiveDataScope
    @Nullable
    public T getLatestValue() {
        return this.target.getValue();
    }

    @NotNull
    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_ktx_release() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata_ktx_release(@NotNull CoroutineLiveData<T> coroutineLiveData) {
        f0.p(coroutineLiveData, "<set-?>");
        this.target = coroutineLiveData;
    }
}
