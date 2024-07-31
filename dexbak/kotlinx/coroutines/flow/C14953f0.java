package kotlinx.coroutines.flow;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: SharingStarted.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\f"}, m12616d2 = {"Lkotlinx/coroutines/flow/f0;", "Lkotlinx/coroutines/flow/d0;", "Lkotlinx/coroutines/flow/h0;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/SharingCommand;", "a", "", "toString", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.f0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14953f0 implements InterfaceC14948d0 {
    @Override // kotlinx.coroutines.flow.InterfaceC14948d0
    @NotNull
    /* renamed from: a */
    public InterfaceC14958h<SharingStarted> mo4814a(@NotNull StateFlow<Integer> stateFlow) {
        return C15006k.m4698Q0(SharingStarted.START);
    }

    @NotNull
    public String toString() {
        return "SharingStarted.Eagerly";
    }
}
