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
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$5"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5$lambda$1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14904xaa78f19a<T> implements FlowCollector<T> {

    /* renamed from: a */
    final /* synthetic */ FlowCollector f42594a;

    /* renamed from: b */
    final /* synthetic */ FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5 f42595b;

    public C14904xaa78f19a(FlowCollector flowCollector, FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5 flowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5) {
        this.f42594a = flowCollector;
        this.f42595b = flowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5;
    }

    @Nullable
    /* renamed from: a */
    public Object m4863a(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
        InlineMarker.m8227e(4);
        new ContinuationImpl(interfaceC14268c) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5$lambda$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj2) {
                this.result = obj2;
                this.label |= Integer.MIN_VALUE;
                return C14904xaa78f19a.this.emit(null, this);
            }
        };
        InlineMarker.m8227e(5);
        return this.f42595b.f42593b.invoke(this.f42594a, obj, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
        return this.f42595b.f42593b.invoke(this.f42594a, obj, interfaceC14268c);
    }
}
