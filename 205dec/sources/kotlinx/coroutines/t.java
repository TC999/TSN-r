package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/t;", "Lkotlinx/coroutines/f2;", "Lkotlinx/coroutines/e2;", "", "cause", "Lkotlin/f1;", "h0", "", "toString", "Lkotlinx/coroutines/p;", "e", "Lkotlinx/coroutines/p;", "child", "parent", "<init>", "(Lkotlinx/coroutines/e2;Lkotlinx/coroutines/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t extends f2<e2> {
    @JvmField
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final p<?> f60713e;

    public t(@NotNull e2 e2Var, @NotNull p<?> pVar) {
        super(e2Var);
        this.f60713e = pVar;
    }

    @Override // kotlinx.coroutines.f0
    public void h0(@Nullable Throwable th) {
        p<?> pVar = this.f60713e;
        pVar.F(pVar.w(this.f60463d));
    }

    @Override // d2.l
    public /* bridge */ /* synthetic */ kotlin.f1 invoke(Throwable th) {
        h0(th);
        return kotlin.f1.f55527a;
    }

    @Override // kotlinx.coroutines.internal.s
    @NotNull
    public String toString() {
        return "ChildContinuation[" + this.f60713e + ']';
    }
}
