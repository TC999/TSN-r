package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlinx.coroutines.n1;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: EventLoop.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0004J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0004R\u0014\u0010\f\u001a\u00020\t8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/o1;", "Lkotlinx/coroutines/m1;", "Lkotlin/f1;", "N", "", "now", "Lkotlinx/coroutines/n1$c;", "delayedTask", "L", "Ljava/lang/Thread;", "K", "()Ljava/lang/Thread;", "thread", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class o1 extends m1 {
    @NotNull
    protected abstract Thread K();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L(long j4, @NotNull n1.c cVar) {
        v0.f60753m.Y(j4, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N() {
        Thread K = K();
        if (Thread.currentThread() != K) {
            o3 b4 = p3.b();
            if (b4 != null) {
                b4.c(K);
            } else {
                LockSupport.unpark(K);
            }
        }
    }
}
