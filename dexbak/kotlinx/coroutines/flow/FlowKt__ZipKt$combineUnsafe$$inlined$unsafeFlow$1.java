package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.Combine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15284p;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: SafeCollector.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1<R> implements InterfaceC14958h<R> {

    /* renamed from: a */
    final /* synthetic */ InterfaceC14958h[] f42643a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC15284p f42644b;

    public FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1(InterfaceC14958h[] interfaceC14958hArr, InterfaceC15284p interfaceC15284p) {
        this.f42643a = interfaceC14958hArr;
        this.f42644b = interfaceC15284p;
    }

    @Override // kotlinx.coroutines.flow.InterfaceC14958h
    @Nullable
    /* renamed from: e */
    public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
        Object m8642h;
        Object m4805a = Combine.m4805a(flowCollector, this.f42643a, Zip.m4858a(), new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1(null, this), interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m4805a == m8642h ? m4805a : Unit.f41048a;
    }

    @Nullable
    /* renamed from: f */
    public Object m4836f(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
        InlineMarker.m8227e(4);
        new ContinuationImpl(interfaceC14268c) { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1.this.mo4470e(null, this);
            }
        };
        InlineMarker.m8227e(5);
        InterfaceC14958h[] interfaceC14958hArr = this.f42643a;
        InterfaceC15269a m4858a = Zip.m4858a();
        FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1 flowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1 = new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1(null, this);
        InlineMarker.m8227e(0);
        Combine.m4805a(flowCollector, interfaceC14958hArr, m4858a, flowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1, interfaceC14268c);
        InlineMarker.m8227e(2);
        InlineMarker.m8227e(1);
        return Unit.f41048a;
    }
}
