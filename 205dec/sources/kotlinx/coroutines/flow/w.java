package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Builders.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012-\u0010\f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u00a2\u0006\u0002\b\u000b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/flow/w;", "T", "Lkotlinx/coroutines/flow/a;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "g", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class w<T> extends a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final d2.p<i<? super T>, kotlin.coroutines.c<? super f1>, Object> f60311a;

    /* JADX WARN: Multi-variable type inference failed */
    public w(@NotNull d2.p<? super i<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        this.f60311a = pVar;
    }

    @Override // kotlinx.coroutines.flow.a
    @Nullable
    public Object g(@NotNull i<? super T> iVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object invoke = this.f60311a.invoke(iVar, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return invoke == h4 ? invoke : f1.f55527a;
    }
}
