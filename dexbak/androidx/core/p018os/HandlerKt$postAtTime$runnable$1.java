package androidx.core.p018os;

import kotlin.Metadata;
import p617l1.InterfaceC15269a;

/* compiled from: Handler.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, m12616d2 = {"Lkotlin/f1;", "run", "()V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.os.HandlerKt$postAtTime$runnable$1 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    final /* synthetic */ InterfaceC15269a $action;

    public HandlerKt$postAtTime$runnable$1(InterfaceC15269a interfaceC15269a) {
        this.$action = interfaceC15269a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
