package kotlinx.coroutines.flow;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Collect.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$$special$$inlined$collect$2"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1<T> implements FlowCollector<T> {

    /* renamed from: a */
    final /* synthetic */ FlowCollector f42457a;

    /* renamed from: b */
    final /* synthetic */ FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2 f42458b;

    public FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1(FlowCollector flowCollector, FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2 flowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2) {
        this.f42457a = flowCollector;
        this.f42458b = flowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2;
    }

    @Nullable
    /* renamed from: a */
    public Object m4944a(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
        InlineMarker.m8227e(4);
        new ContinuationImpl(interfaceC14268c) { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj2) {
                this.result = obj2;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1.this.emit(null, this);
            }
        };
        InlineMarker.m8227e(5);
        return this.f42458b.f42456b.invoke(this.f42457a, obj, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
        return this.f42458b.f42456b.invoke(this.f42457a, obj, interfaceC14268c);
    }
}
