package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SafeCollector.common.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1<T> implements h<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f59736a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d2.p f59737b;

    public FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1(h hVar, d2.p pVar) {
        this.f59736a = hVar;
        this.f59737b = pVar;
    }

    @Override // kotlinx.coroutines.flow.h
    @Nullable
    public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
        Object h4;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        Object e4 = this.f59736a.e(new FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1(iVar, booleanRef, this), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return e4 == h4 ? e4 : f1.f55527a;
    }
}
