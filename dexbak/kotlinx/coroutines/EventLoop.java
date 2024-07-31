package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m12616d2 = {"Lkotlinx/coroutines/g;", "Lkotlinx/coroutines/n1;", "Ljava/lang/Thread;", "f", "Ljava/lang/Thread;", "M", "()Ljava/lang/Thread;", "thread", "<init>", "(Ljava/lang/Thread;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class EventLoop extends AbstractC15139n1 {
    @NotNull

    /* renamed from: f */
    private final Thread f43016f;

    public EventLoop(@NotNull Thread thread) {
        this.f43016f = thread;
    }

    @Override // kotlinx.coroutines.AbstractC15150o1
    @NotNull
    /* renamed from: M */
    protected Thread mo3543M() {
        return this.f43016f;
    }
}
