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
@Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$4"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$4$lambda$1<T> implements i<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f59926a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$4 f59927b;

    public FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$4$lambda$1(i iVar, FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$4 flowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$4) {
        this.f59926a = iVar;
        this.f59927b = flowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$4;
    }

    @Nullable
    public Object a(Object obj, @NotNull kotlin.coroutines.c cVar) {
        kotlin.jvm.internal.c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$4$lambda$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj2) {
                this.result = obj2;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$4$lambda$1.this.emit(null, this);
            }
        };
        kotlin.jvm.internal.c0.e(5);
        return this.f59927b.f59925b.invoke(this.f59926a, obj, cVar);
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
        return this.f59927b.f59925b.invoke(this.f59926a, obj, cVar);
    }
}
