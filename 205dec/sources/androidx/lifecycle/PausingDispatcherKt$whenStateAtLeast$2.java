package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d2.p;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: PausingDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "Lkotlinx/coroutines/q0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", i = {0, 0, 0, 0}, l = {163}, m = "invokeSuspend", n = {"$this$withContext", "job", "dispatcher", "controller"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class PausingDispatcherKt$whenStateAtLeast$2<T> extends SuspendLambda implements p<q0, c<? super T>, Object> {
    final /* synthetic */ p $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private q0 p$;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, p pVar, c cVar) {
        super(2, cVar);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final c<f1> create(@Nullable Object obj, @NotNull c<?> completion) {
        f0.q(completion, "completion");
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, completion);
        pausingDispatcherKt$whenStateAtLeast$2.p$ = (q0) obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    @Override // d2.p
    public final Object invoke(q0 q0Var, Object obj) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(q0Var, (c) obj)).invokeSuspend(f1.f55527a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h4;
        LifecycleController lifecycleController;
        h4 = b.h();
        int i4 = this.label;
        if (i4 == 0) {
            d0.n(obj);
            q0 q0Var = this.p$;
            e2 e2Var = (e2) q0Var.getCoroutineContext().get(e2.f59626i0);
            if (e2Var != null) {
                PausingDispatcher pausingDispatcher = new PausingDispatcher();
                LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, e2Var);
                try {
                    p pVar = this.$block;
                    this.L$0 = q0Var;
                    this.L$1 = e2Var;
                    this.L$2 = pausingDispatcher;
                    this.L$3 = lifecycleController2;
                    this.label = 1;
                    obj = h.i(pausingDispatcher, pVar, this);
                    if (obj == h4) {
                        return h4;
                    }
                    lifecycleController = lifecycleController2;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController = lifecycleController2;
                    lifecycleController.finish();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            lifecycleController = (LifecycleController) this.L$3;
            PausingDispatcher pausingDispatcher2 = (PausingDispatcher) this.L$2;
            e2 e2Var2 = (e2) this.L$1;
            q0 q0Var2 = (q0) this.L$0;
            try {
                d0.n(obj);
            } catch (Throwable th2) {
                th = th2;
                lifecycleController.finish();
                throw th;
            }
        }
        lifecycleController.finish();
        return obj;
    }
}
