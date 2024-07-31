package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlinx.coroutines.AbstractC15139n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: EventLoop.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0004J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0004R\u0014\u0010\f\u001a\u00020\t8$X¤\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/o1;", "Lkotlinx/coroutines/m1;", "Lkotlin/f1;", "P", "", "now", "Lkotlinx/coroutines/n1$c;", "delayedTask", "N", "Ljava/lang/Thread;", "M", "()Ljava/lang/Thread;", "thread", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.o1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC15150o1 extends AbstractC15133m1 {
    @NotNull
    /* renamed from: M */
    protected abstract Thread mo3543M();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: N */
    public final void m3935N(long j, @NotNull AbstractC15139n1.AbstractRunnableC15142c abstractRunnableC15142c) {
        DefaultExecutor.f43436m.m3957a0(j, abstractRunnableC15142c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: P */
    public final void m3934P() {
        Thread mo3543M = mo3543M();
        if (Thread.currentThread() != mo3543M) {
            InterfaceC15152o3 m3872b = C15156p3.m3872b();
            if (m3872b != null) {
                m3872b.m3930c(mo3543M);
            } else {
                LockSupport.unpark(mo3543M);
            }
        }
    }
}
