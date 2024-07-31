package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1<T> implements InterfaceC14958h<T> {

    /* renamed from: a */
    final /* synthetic */ InterfaceC14958h f42401a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC15284p f42402b;

    public FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1(InterfaceC14958h interfaceC14958h, InterfaceC15284p interfaceC15284p) {
        this.f42401a = interfaceC14958h;
        this.f42402b = interfaceC15284p;
    }

    @Override // kotlinx.coroutines.flow.InterfaceC14958h
    @Nullable
    /* renamed from: e */
    public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
        Object m8642h;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        Object mo4470e = this.f42401a.mo4470e(new FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1(flowCollector, booleanRef, this), interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo4470e == m8642h ? mo4470e : Unit.f41048a;
    }
}
