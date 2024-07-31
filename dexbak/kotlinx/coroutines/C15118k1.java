package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, m12616d2 = {"Lkotlinx/coroutines/k1;", "Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/e2;", "", "cause", "Lkotlin/f1;", "f0", "", "toString", "Lkotlinx/coroutines/i1;", "e", "Lkotlinx/coroutines/i1;", "handle", "job", "<init>", "(Lkotlinx/coroutines/e2;Lkotlinx/coroutines/i1;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.k1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15118k1 extends AbstractC15119k2<Job> {

    /* renamed from: e */
    private final InterfaceC15064i1 f43145e;

    public C15118k1(@NotNull Job job, @NotNull InterfaceC15064i1 interfaceC15064i1) {
        super(job);
        this.f43145e = interfaceC15064i1;
    }

    @Override // kotlinx.coroutines.CompletionHandler
    /* renamed from: f0 */
    public void mo3495f0(@Nullable Throwable th) {
        this.f43145e.dispose();
    }

    @Override // p617l1.InterfaceC15280l
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo3495f0(th);
        return Unit.f41048a;
    }

    @Override // kotlinx.coroutines.internal.C15094s
    @NotNull
    public String toString() {
        return "DisposeOnCompletion[" + this.f43145e + ']';
    }
}
