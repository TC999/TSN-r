package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* compiled from: Executors.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/z2;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlin/f1;", "run", "Lkotlinx/coroutines/l0;", "a", "Lkotlinx/coroutines/l0;", "dispatcher", "Lkotlinx/coroutines/o;", "b", "Lkotlinx/coroutines/o;", "continuation", "<init>", "(Lkotlinx/coroutines/l0;Lkotlinx/coroutines/o;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.z2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class RunnableC15266z2 implements Runnable {

    /* renamed from: a */
    private final CoroutineDispatcher f43460a;

    /* renamed from: b */
    private final InterfaceC15146o<Unit> f43461b;

    /* JADX WARN: Multi-variable type inference failed */
    public RunnableC15266z2(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull InterfaceC15146o<? super Unit> interfaceC15146o) {
        this.f43460a = coroutineDispatcher;
        this.f43461b = interfaceC15146o;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43461b.mo3916I(this.f43460a, Unit.f41048a);
    }
}
