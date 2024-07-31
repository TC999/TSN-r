package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: CancellableContinuationImpl.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B0\u0012'\u0010\f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\bj\u0002`\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/b2;", "Lkotlinx/coroutines/m;", "", "cause", "Lkotlin/f1;", "a", "", "toString", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Ll1/l;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.b2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14629b2 extends AbstractC15132m {

    /* renamed from: a */
    private final InterfaceC15280l<Throwable, Unit> f41712a;

    /* JADX WARN: Multi-variable type inference failed */
    public C14629b2(@NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        this.f41712a = interfaceC15280l;
    }

    @Override // kotlinx.coroutines.AbstractC15136n
    /* renamed from: a */
    public void mo3521a(@Nullable Throwable th) {
        this.f41712a.invoke(th);
    }

    @Override // p617l1.InterfaceC15280l
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo3521a(th);
        return Unit.f41048a;
    }

    @NotNull
    public String toString() {
        return "InvokeOnCancel[" + DebugStrings.m3554a(this.f41712a) + '@' + DebugStrings.m3553b(this) + ']';
    }
}
