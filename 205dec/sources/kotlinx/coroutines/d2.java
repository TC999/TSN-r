package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B8\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\nj\u0002`\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/d2;", "Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/e2;", "", "cause", "Lkotlin/f1;", "h0", "", "toString", "job", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlinx/coroutines/e2;Ld2/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d2 extends k2<e2> {

    /* renamed from: e  reason: collision with root package name */
    private final d2.l<Throwable, kotlin.f1> f59540e;

    /* JADX WARN: Multi-variable type inference failed */
    public d2(@NotNull e2 e2Var, @NotNull d2.l<? super Throwable, kotlin.f1> lVar) {
        super(e2Var);
        this.f59540e = lVar;
    }

    @Override // kotlinx.coroutines.f0
    public void h0(@Nullable Throwable th) {
        this.f59540e.invoke(th);
    }

    @Override // d2.l
    public /* bridge */ /* synthetic */ kotlin.f1 invoke(Throwable th) {
        h0(th);
        return kotlin.f1.f55527a;
    }

    @Override // kotlinx.coroutines.internal.s
    @NotNull
    public String toString() {
        return "InvokeOnCompletion[" + u0.a(this) + '@' + u0.b(this) + ']';
    }
}
