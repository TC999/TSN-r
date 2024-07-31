package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0086\b*\n\u0010\u0006\"\u00020\u00032\u00020\u0003¨\u0006\u0007"}, m12616d2 = {"Lkotlin/Function0;", "Lkotlin/f1;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "a", "Runnable", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.a3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Runnable {

    /* compiled from: Runnable.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, m12616d2 = {"Lkotlin/f1;", "run", "()V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.a3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class RunnableC14618a implements java.lang.Runnable {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15269a f41695a;

        public RunnableC14618a(InterfaceC15269a interfaceC15269a) {
            this.f41695a = interfaceC15269a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f41695a.invoke();
        }
    }

    @NotNull
    /* renamed from: a */
    public static final java.lang.Runnable m5743a(@NotNull InterfaceC15269a<Unit> interfaceC15269a) {
        return new RunnableC14618a(interfaceC15269a);
    }
}
