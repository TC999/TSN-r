package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/x2;", "T", "Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/l2;", "", "cause", "Lkotlin/f1;", "h0", "", "toString", "Lkotlinx/coroutines/p;", "e", "Lkotlinx/coroutines/p;", "continuation", "job", "<init>", "(Lkotlinx/coroutines/l2;Lkotlinx/coroutines/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x2<T> extends k2<l2> {

    /* renamed from: e  reason: collision with root package name */
    private final p<T> f60766e;

    /* JADX WARN: Multi-variable type inference failed */
    public x2(@NotNull l2 l2Var, @NotNull p<? super T> pVar) {
        super(l2Var);
        this.f60766e = pVar;
    }

    @Override // kotlinx.coroutines.f0
    public void h0(@Nullable Throwable th) {
        Object y02 = ((l2) this.f60463d).y0();
        if (y02 instanceof d0) {
            p<T> pVar = this.f60766e;
            Throwable th2 = ((d0) y02).f59534a;
            Result.a aVar = Result.Companion;
            pVar.resumeWith(Result.m119constructorimpl(kotlin.d0.a(th2)));
            return;
        }
        p<T> pVar2 = this.f60766e;
        Object o4 = m2.o(y02);
        Result.a aVar2 = Result.Companion;
        pVar2.resumeWith(Result.m119constructorimpl(o4));
    }

    @Override // d2.l
    public /* bridge */ /* synthetic */ kotlin.f1 invoke(Throwable th) {
        h0(th);
        return kotlin.f1.f55527a;
    }

    @Override // kotlinx.coroutines.internal.s
    @NotNull
    public String toString() {
        return "ResumeAwaitOnCompletion[" + this.f60766e + ']';
    }
}
