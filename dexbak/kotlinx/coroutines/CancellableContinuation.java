package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\t¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/j1;", "Lkotlinx/coroutines/m;", "", "cause", "Lkotlin/f1;", "a", "", "toString", "Lkotlinx/coroutines/i1;", "Lkotlinx/coroutines/i1;", "handle", "<init>", "(Lkotlinx/coroutines/i1;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.j1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CancellableContinuation extends AbstractC15132m {

    /* renamed from: a */
    private final InterfaceC15064i1 f43139a;

    public CancellableContinuation(@NotNull InterfaceC15064i1 interfaceC15064i1) {
        this.f43139a = interfaceC15064i1;
    }

    @Override // kotlinx.coroutines.AbstractC15136n
    /* renamed from: a */
    public void mo3521a(@Nullable Throwable th) {
        this.f43139a.dispose();
    }

    @Override // p617l1.InterfaceC15280l
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo3521a(th);
        return Unit.f41048a;
    }

    @NotNull
    public String toString() {
        return "DisposeOnCancel[" + this.f43139a + ']';
    }
}
