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
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FlowLiveData.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
final class FlowLiveDataConversions$asLiveData$1<T> extends SuspendLambda implements p<LiveDataScope<T>, c<? super f1>, Object> {
    final /* synthetic */ h $this_asLiveData;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asLiveData$1(h hVar, c cVar) {
        super(2, cVar);
        this.$this_asLiveData = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final c<f1> create(@Nullable Object obj, @NotNull c<?> completion) {
        f0.p(completion, "completion");
        FlowLiveDataConversions$asLiveData$1 flowLiveDataConversions$asLiveData$1 = new FlowLiveDataConversions$asLiveData$1(this.$this_asLiveData, completion);
        flowLiveDataConversions$asLiveData$1.L$0 = obj;
        return flowLiveDataConversions$asLiveData$1;
    }

    @Override // d2.p
    public final Object invoke(Object obj, c<? super f1> cVar) {
        return ((FlowLiveDataConversions$asLiveData$1) create(obj, cVar)).invokeSuspend(f1.f55527a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h4;
        h4 = b.h();
        int i4 = this.label;
        if (i4 == 0) {
            d0.n(obj);
            final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
            h hVar = this.$this_asLiveData;
            i<T> iVar = new i<T>() { // from class: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.i
                @Nullable
                public Object emit(Object obj2, @NotNull c cVar) {
                    Object h5;
                    Object emit = LiveDataScope.this.emit(obj2, cVar);
                    h5 = b.h();
                    return emit == h5 ? emit : f1.f55527a;
                }
            };
            this.label = 1;
            if (hVar.e(iVar, this) == h4) {
                return h4;
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            d0.n(obj);
        }
        return f1.f55527a;
    }
}
