package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Collect.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "a", "I", "index", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__CollectKt$collectIndexed$2<T> implements i<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f59661a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d2.q f59662b;

    public FlowKt__CollectKt$collectIndexed$2(d2.q qVar) {
        this.f59662b = qVar;
    }

    @Nullable
    public Object a(Object obj, @NotNull final kotlin.coroutines.c cVar) {
        kotlin.jvm.internal.c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collectIndexed$2$emit$1
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
        kotlin.jvm.internal.c0.e(5);
        d2.q qVar = this.f59662b;
        int i4 = this.f59661a;
        this.f59661a = i4 + 1;
        if (i4 >= 0) {
            return qVar.invoke(Integer.valueOf(i4), obj, cVar);
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object emit(T t3, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        d2.q qVar = this.f59662b;
        int i4 = this.f59661a;
        this.f59661a = i4 + 1;
        if (i4 >= 0) {
            Object invoke = qVar.invoke(kotlin.coroutines.jvm.internal.a.f(i4), t3, cVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            return invoke == h4 ? invoke : f1.f55527a;
        }
        throw new ArithmeticException("Index overflow has happened");
    }
}