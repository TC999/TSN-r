package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003BD\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/c3;", "T", "R", "Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/l2;", "", "cause", "Lkotlin/f1;", "h0", "", "toString", "Lkotlinx/coroutines/selects/f;", "e", "Lkotlinx/coroutines/selects/f;", "select", "job", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "<init>", "(Lkotlinx/coroutines/l2;Lkotlinx/coroutines/selects/f;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c3<T, R> extends k2<l2> {

    /* renamed from: e  reason: collision with root package name */
    private final kotlinx.coroutines.selects.f<R> f59073e;

    /* renamed from: f  reason: collision with root package name */
    private final d2.p<T, kotlin.coroutines.c<? super R>, Object> f59074f;

    /* JADX WARN: Multi-variable type inference failed */
    public c3(@NotNull l2 l2Var, @NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        super(l2Var);
        this.f59073e = fVar;
        this.f59074f = pVar;
    }

    @Override // kotlinx.coroutines.f0
    public void h0(@Nullable Throwable th) {
        if (this.f59073e.p()) {
            ((l2) this.f60463d).Y0(this.f59073e, this.f59074f);
        }
    }

    @Override // d2.l
    public /* bridge */ /* synthetic */ kotlin.f1 invoke(Throwable th) {
        h0(th);
        return kotlin.f1.f55527a;
    }

    @Override // kotlinx.coroutines.internal.s
    @NotNull
    public String toString() {
        return "SelectAwaitOnCompletion[" + this.f59073e + ']';
    }
}
