package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Share.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BG\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u00a2\u0006\u0002\b\u0012\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/flow/m0;", "T", "Lkotlinx/coroutines/flow/x;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "Lkotlinx/coroutines/flow/x;", "sharedFlow", "", "d", "()Ljava/util/List;", "replayCache", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "action", "<init>", "(Lkotlinx/coroutines/flow/x;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class m0<T> implements x<T> {

    /* renamed from: a  reason: collision with root package name */
    private final x<T> f60207a;

    /* renamed from: b  reason: collision with root package name */
    private final d2.p<i<? super T>, kotlin.coroutines.c<? super f1>, Object> f60208b;

    /* JADX WARN: Multi-variable type inference failed */
    public m0(@NotNull x<? extends T> xVar, @NotNull d2.p<? super i<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        this.f60207a = xVar;
        this.f60208b = pVar;
    }

    @Override // kotlinx.coroutines.flow.x
    @NotNull
    public List<T> d() {
        return this.f60207a.d();
    }

    @Override // kotlinx.coroutines.flow.h
    @Nullable
    public Object e(@NotNull i<? super T> iVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object e4 = this.f60207a.e(new l0(iVar, this.f60208b), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return e4 == h4 ? e4 : f1.f55527a;
    }
}
