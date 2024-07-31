package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Executors.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m12616d2 = {"Lkotlinx/coroutines/u1;", "Lkotlinx/coroutines/t1;", "Ljava/util/concurrent/Executor;", "c", "Ljava/util/concurrent/Executor;", "p", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(Ljava/util/concurrent/Executor;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.u1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C15236u1 extends AbstractC15226t1 {
    @NotNull

    /* renamed from: c */
    private final Executor f43425c;

    public C15236u1(@NotNull Executor executor) {
        this.f43425c = executor;
        m3592r();
    }

    @Override // kotlinx.coroutines.AbstractC15168s1
    @NotNull
    /* renamed from: p */
    public Executor mo3514p() {
        return this.f43425c;
    }
}
