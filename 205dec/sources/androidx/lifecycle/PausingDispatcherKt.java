package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d2.p;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: PausingDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aF\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u00a2\u0006\u0002\b\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001aF\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u00a2\u0006\u0002\b\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\u000b\u001aF\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u00a2\u0006\u0002\b\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\t\u001aF\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u00a2\u0006\u0002\b\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\u000b\u001aF\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u00a2\u0006\u0002\b\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\t\u001aF\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u00a2\u0006\u0002\b\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000b\u001aN\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u00a2\u0006\u0002\b\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"T", "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/Function2;", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "whenCreated", "(Landroidx/lifecycle/LifecycleOwner;Ld2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;Ld2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "whenStarted", "whenResumed", "Landroidx/lifecycle/Lifecycle$State;", "minState", "whenStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Ld2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class PausingDispatcherKt {
    @Nullable
    public static final <T> Object whenCreated(@NotNull LifecycleOwner lifecycleOwner, @NotNull p<? super q0, ? super c<? super T>, ? extends Object> pVar, @NotNull c<? super T> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        f0.h(lifecycle, "lifecycle");
        return whenCreated(lifecycle, pVar, cVar);
    }

    @Nullable
    public static final <T> Object whenResumed(@NotNull LifecycleOwner lifecycleOwner, @NotNull p<? super q0, ? super c<? super T>, ? extends Object> pVar, @NotNull c<? super T> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        f0.h(lifecycle, "lifecycle");
        return whenResumed(lifecycle, pVar, cVar);
    }

    @Nullable
    public static final <T> Object whenStarted(@NotNull LifecycleOwner lifecycleOwner, @NotNull p<? super q0, ? super c<? super T>, ? extends Object> pVar, @NotNull c<? super T> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        f0.h(lifecycle, "lifecycle");
        return whenStarted(lifecycle, pVar, cVar);
    }

    @Nullable
    public static final <T> Object whenStateAtLeast(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull p<? super q0, ? super c<? super T>, ? extends Object> pVar, @NotNull c<? super T> cVar) {
        return h.i(f1.e().q(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, pVar, null), cVar);
    }

    @Nullable
    public static final <T> Object whenCreated(@NotNull Lifecycle lifecycle, @NotNull p<? super q0, ? super c<? super T>, ? extends Object> pVar, @NotNull c<? super T> cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, pVar, cVar);
    }

    @Nullable
    public static final <T> Object whenResumed(@NotNull Lifecycle lifecycle, @NotNull p<? super q0, ? super c<? super T>, ? extends Object> pVar, @NotNull c<? super T> cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, pVar, cVar);
    }

    @Nullable
    public static final <T> Object whenStarted(@NotNull Lifecycle lifecycle, @NotNull p<? super q0, ? super c<? super T>, ? extends Object> pVar, @NotNull c<? super T> cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, pVar, cVar);
    }
}
