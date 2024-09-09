package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.f1;
import kotlinx.coroutines.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Semaphore.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/sync/a;", "Lkotlinx/coroutines/m;", "", "cause", "Lkotlin/f1;", "a", "", "toString", "Lkotlinx/coroutines/sync/g;", "Lkotlinx/coroutines/sync/g;", "segment", "", "b", "I", "index", "<init>", "(Lkotlinx/coroutines/sync/g;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class a extends m {

    /* renamed from: a  reason: collision with root package name */
    private final g f60676a;

    /* renamed from: b  reason: collision with root package name */
    private final int f60677b;

    public a(@NotNull g gVar, int i4) {
        this.f60676a = gVar;
        this.f60677b = i4;
    }

    @Override // kotlinx.coroutines.n
    public void a(@Nullable Throwable th) {
        this.f60676a.s(this.f60677b);
    }

    @Override // d2.l
    public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
        a(th);
        return f1.f55527a;
    }

    @NotNull
    public String toString() {
        return "CancelSemaphoreAcquisitionHandler[" + this.f60676a + ", " + this.f60677b + ']';
    }
}
