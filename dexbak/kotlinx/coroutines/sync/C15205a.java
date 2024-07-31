package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.AbstractC15132m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Semaphore.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, m12616d2 = {"Lkotlinx/coroutines/sync/a;", "Lkotlinx/coroutines/m;", "", "cause", "Lkotlin/f1;", "a", "", "toString", "Lkotlinx/coroutines/sync/g;", "Lkotlinx/coroutines/sync/g;", "segment", "", "b", "I", "index", "<init>", "(Lkotlinx/coroutines/sync/g;I)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.sync.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C15205a extends AbstractC15132m {

    /* renamed from: a */
    private final C15224g f43359a;

    /* renamed from: b */
    private final int f43360b;

    public C15205a(@NotNull C15224g c15224g, int i) {
        this.f43359a = c15224g;
        this.f43360b = i;
    }

    @Override // kotlinx.coroutines.AbstractC15136n
    /* renamed from: a */
    public void mo3521a(@Nullable Throwable th) {
        this.f43359a.m3604s(this.f43360b);
    }

    @Override // p617l1.InterfaceC15280l
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo3521a(th);
        return Unit.f41048a;
    }

    @NotNull
    public String toString() {
        return "CancelSemaphoreAcquisitionHandler[" + this.f43359a + ", " + this.f43360b + ']';
    }
}
