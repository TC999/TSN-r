package kotlinx.coroutines.flow;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15285q;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Collect.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "a", "I", "index", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlowKt__CollectKt$collectIndexed$2<T> implements FlowCollector<T> {

    /* renamed from: a */
    private int f42316a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC15285q f42317b;

    public FlowKt__CollectKt$collectIndexed$2(InterfaceC15285q interfaceC15285q) {
        this.f42317b = interfaceC15285q;
    }

    @Nullable
    /* renamed from: a */
    public Object m5002a(Object obj, @NotNull final InterfaceC14268c interfaceC14268c) {
        InlineMarker.m8227e(4);
        new ContinuationImpl(interfaceC14268c) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collectIndexed$2$emit$1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj2) {
                this.result = obj2;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__CollectKt$collectIndexed$2.this.emit(null, this);
            }
        };
        InlineMarker.m8227e(5);
        InterfaceC15285q interfaceC15285q = this.f42317b;
        int i = this.f42316a;
        this.f42316a = i + 1;
        if (i >= 0) {
            return interfaceC15285q.invoke(Integer.valueOf(i), obj, interfaceC14268c);
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        InterfaceC15285q interfaceC15285q = this.f42317b;
        int i = this.f42316a;
        this.f42316a = i + 1;
        if (i >= 0) {
            Object invoke = interfaceC15285q.invoke(boxing.m8626f(i), t, interfaceC14268c);
            m8642h = C14287b.m8642h();
            return invoke == m8642h ? invoke : Unit.f41048a;
        }
        throw new ArithmeticException("Index overflow has happened");
    }
}
