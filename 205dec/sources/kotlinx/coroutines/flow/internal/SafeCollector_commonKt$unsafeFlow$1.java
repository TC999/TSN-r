package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.f1;
import kotlin.jvm.internal.c0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SafeCollector.common.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SafeCollector_commonKt$unsafeFlow$1<T> implements kotlinx.coroutines.flow.h<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d2.p f60124a;

    public SafeCollector_commonKt$unsafeFlow$1(d2.p pVar) {
        this.f60124a = pVar;
    }

    @Override // kotlinx.coroutines.flow.h
    @Nullable
    public Object e(@NotNull kotlinx.coroutines.flow.i<? super T> iVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object invoke = this.f60124a.invoke(iVar, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return invoke == h4 ? invoke : f1.f55527a;
    }

    @Nullable
    public Object g(@NotNull kotlinx.coroutines.flow.i iVar, @NotNull final kotlin.coroutines.c cVar) {
        c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$unsafeFlow$1$collect$1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return SafeCollector_commonKt$unsafeFlow$1.this.e(null, this);
            }
        };
        c0.e(5);
        this.f60124a.invoke(iVar, cVar);
        return f1.f55527a;
    }
}
