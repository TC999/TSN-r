package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Collect.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1<T> implements i<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FlowKt__EmittersKt$transform$1 f59685a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ i f59686b;

    public FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(FlowKt__EmittersKt$transform$1 flowKt__EmittersKt$transform$1, i iVar) {
        this.f59685a = flowKt__EmittersKt$transform$1;
        this.f59686b = iVar;
    }

    @Nullable
    public Object a(Object obj, @NotNull kotlin.coroutines.c cVar) {
        kotlin.jvm.internal.c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj2) {
                this.result = obj2;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
            }
        };
        kotlin.jvm.internal.c0.e(5);
        return this.f59685a.$transform.invoke(this.f59686b, obj, cVar);
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
        return this.f59685a.$transform.invoke(this.f59686b, obj, cVar);
    }
}
