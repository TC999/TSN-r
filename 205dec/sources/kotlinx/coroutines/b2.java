package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CancellableContinuationImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B0\u0012'\u0010\f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\bj\u0002`\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/b2;", "Lkotlinx/coroutines/m;", "", "cause", "Lkotlin/f1;", "a", "", "toString", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Ld2/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class b2 extends m {

    /* renamed from: a  reason: collision with root package name */
    private final d2.l<Throwable, kotlin.f1> f59057a;

    /* JADX WARN: Multi-variable type inference failed */
    public b2(@NotNull d2.l<? super Throwable, kotlin.f1> lVar) {
        this.f59057a = lVar;
    }

    @Override // kotlinx.coroutines.n
    public void a(@Nullable Throwable th) {
        this.f59057a.invoke(th);
    }

    @Override // d2.l
    public /* bridge */ /* synthetic */ kotlin.f1 invoke(Throwable th) {
        a(th);
        return kotlin.f1.f55527a;
    }

    @NotNull
    public String toString() {
        return "InvokeOnCancel[" + u0.a(this.f59057a) + '@' + u0.b(this) + ']';
    }
}
