package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CancellableContinuation.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/w2;", "Lkotlinx/coroutines/e;", "", "cause", "Lkotlin/f1;", "a", "", "toString", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/s;", "node", "<init>", "(Lkotlinx/coroutines/internal/s;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class w2 extends e {

    /* renamed from: a  reason: collision with root package name */
    private final kotlinx.coroutines.internal.s f60757a;

    public w2(@NotNull kotlinx.coroutines.internal.s sVar) {
        this.f60757a = sVar;
    }

    @Override // kotlinx.coroutines.n
    public void a(@Nullable Throwable th) {
        this.f60757a.a0();
    }

    @Override // d2.l
    public /* bridge */ /* synthetic */ kotlin.f1 invoke(Throwable th) {
        a(th);
        return kotlin.f1.f55527a;
    }

    @NotNull
    public String toString() {
        return "RemoveOnCancel[" + this.f60757a + ']';
    }
}
