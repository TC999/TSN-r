package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.f1;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SafeCollector.common.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1<R> implements h<R> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h[] f59958a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d2.p f59959b;

    public FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1(h[] hVarArr, d2.p pVar) {
        this.f59958a = hVarArr;
        this.f59959b = pVar;
    }

    @Override // kotlinx.coroutines.flow.h
    @Nullable
    public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
        Object h4;
        Object a4 = CombineKt.a(iVar, this.f59958a, FlowKt__ZipKt.a(), new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1(null, this), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return a4 == h4 ? a4 : f1.f55527a;
    }

    @Nullable
    public Object g(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
        kotlin.jvm.internal.c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1.this.e(null, this);
            }
        };
        kotlin.jvm.internal.c0.e(5);
        h[] hVarArr = this.f59958a;
        d2.a a4 = FlowKt__ZipKt.a();
        FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1 flowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1 = new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1(null, this);
        kotlin.jvm.internal.c0.e(0);
        CombineKt.a(iVar, hVarArr, a4, flowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1, cVar);
        kotlin.jvm.internal.c0.e(2);
        kotlin.jvm.internal.c0.e(1);
        return f1.f55527a;
    }
}
