package androidx.lifecycle;

import d2.a;
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
/* compiled from: CoroutineLiveData.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class BlockRunner$maybeRun$1 extends SuspendLambda implements p<q0, c<? super f1>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BlockRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockRunner$maybeRun$1(BlockRunner blockRunner, c cVar) {
        super(2, cVar);
        this.this$0 = blockRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final c<f1> create(@Nullable Object obj, @NotNull c<?> completion) {
        f0.p(completion, "completion");
        BlockRunner$maybeRun$1 blockRunner$maybeRun$1 = new BlockRunner$maybeRun$1(this.this$0, completion);
        blockRunner$maybeRun$1.L$0 = obj;
        return blockRunner$maybeRun$1;
    }

    @Override // d2.p
    public final Object invoke(q0 q0Var, c<? super f1> cVar) {
        return ((BlockRunner$maybeRun$1) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h4;
        CoroutineLiveData coroutineLiveData;
        p pVar;
        a aVar;
        h4 = b.h();
        int i4 = this.label;
        if (i4 == 0) {
            d0.n(obj);
            coroutineLiveData = this.this$0.liveData;
            LiveDataScopeImpl liveDataScopeImpl = new LiveDataScopeImpl(coroutineLiveData, ((q0) this.L$0).getCoroutineContext());
            pVar = this.this$0.block;
            this.label = 1;
            if (pVar.invoke(liveDataScopeImpl, this) == h4) {
                return h4;
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            d0.n(obj);
        }
        aVar = this.this$0.onDone;
        aVar.invoke();
        return f1.f55527a;
    }
}