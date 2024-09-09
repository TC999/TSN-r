package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/v;", "Lkotlinx/coroutines/f2;", "Lkotlinx/coroutines/l2;", "Lkotlinx/coroutines/u;", "", "cause", "Lkotlin/f1;", "h0", "", "g", "", "toString", "Lkotlinx/coroutines/w;", "e", "Lkotlinx/coroutines/w;", "childJob", "parent", "<init>", "(Lkotlinx/coroutines/l2;Lkotlinx/coroutines/w;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v extends f2<l2> implements u {
    @JvmField
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final w f60745e;

    public v(@NotNull l2 l2Var, @NotNull w wVar) {
        super(l2Var);
        this.f60745e = wVar;
    }

    @Override // kotlinx.coroutines.u
    public boolean g(@NotNull Throwable th) {
        return ((l2) this.f60463d).h0(th);
    }

    @Override // kotlinx.coroutines.f0
    public void h0(@Nullable Throwable th) {
        this.f60745e.i((u2) this.f60463d);
    }

    @Override // d2.l
    public /* bridge */ /* synthetic */ kotlin.f1 invoke(Throwable th) {
        h0(th);
        return kotlin.f1.f55527a;
    }

    @Override // kotlinx.coroutines.internal.s
    @NotNull
    public String toString() {
        return "ChildHandle[" + this.f60745e + ']';
    }
}
