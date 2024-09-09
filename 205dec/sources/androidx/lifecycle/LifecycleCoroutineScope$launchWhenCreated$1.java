package androidx.lifecycle;

import d2.p;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Lifecycle.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", f = "Lifecycle.kt", i = {0}, l = {74}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class LifecycleCoroutineScope$launchWhenCreated$1 extends SuspendLambda implements p<q0, c<? super f1>, Object> {
    final /* synthetic */ p $block;
    Object L$0;
    int label;
    private q0 p$;
    final /* synthetic */ LifecycleCoroutineScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleCoroutineScope$launchWhenCreated$1(LifecycleCoroutineScope lifecycleCoroutineScope, p pVar, c cVar) {
        super(2, cVar);
        this.this$0 = lifecycleCoroutineScope;
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final c<f1> create(@Nullable Object obj, @NotNull c<?> completion) {
        f0.q(completion, "completion");
        LifecycleCoroutineScope$launchWhenCreated$1 lifecycleCoroutineScope$launchWhenCreated$1 = new LifecycleCoroutineScope$launchWhenCreated$1(this.this$0, this.$block, completion);
        lifecycleCoroutineScope$launchWhenCreated$1.p$ = (q0) obj;
        return lifecycleCoroutineScope$launchWhenCreated$1;
    }

    @Override // d2.p
    public final Object invoke(q0 q0Var, c<? super f1> cVar) {
        return ((LifecycleCoroutineScope$launchWhenCreated$1) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h4;
        h4 = b.h();
        int i4 = this.label;
        if (i4 == 0) {
            d0.n(obj);
            q0 q0Var = this.p$;
            Lifecycle lifecycle$lifecycle_runtime_ktx_release = this.this$0.getLifecycle$lifecycle_runtime_ktx_release();
            p pVar = this.$block;
            this.L$0 = q0Var;
            this.label = 1;
            if (PausingDispatcherKt.whenCreated(lifecycle$lifecycle_runtime_ktx_release, pVar, this) == h4) {
                return h4;
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            q0 q0Var2 = (q0) this.L$0;
            d0.n(obj);
        }
        return f1.f55527a;
    }
}
