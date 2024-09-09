package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B>\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u001c\u0010\u0012\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/d3;", "R", "Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/l2;", "", "cause", "Lkotlin/f1;", "h0", "", "toString", "Lkotlinx/coroutines/selects/f;", "e", "Lkotlinx/coroutines/selects/f;", "select", "job", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "block", "<init>", "(Lkotlinx/coroutines/l2;Lkotlinx/coroutines/selects/f;Ld2/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class d3<R> extends k2<l2> {

    /* renamed from: e  reason: collision with root package name */
    private final kotlinx.coroutines.selects.f<R> f59541e;

    /* renamed from: f  reason: collision with root package name */
    private final d2.l<kotlin.coroutines.c<? super R>, Object> f59542f;

    /* JADX WARN: Multi-variable type inference failed */
    public d3(@NotNull l2 l2Var, @NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull d2.l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar) {
        super(l2Var);
        this.f59541e = fVar;
        this.f59542f = lVar;
    }

    @Override // kotlinx.coroutines.f0
    public void h0(@Nullable Throwable th) {
        if (this.f59541e.p()) {
            z2.a.b(this.f59542f, this.f59541e.t());
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
        return "SelectJoinOnCompletion[" + this.f59541e + ']';
    }
}
