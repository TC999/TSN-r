package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Executors.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0005\u00a8\u0006\t"}, d2 = {"Ljava/util/concurrent/ExecutorService;", "Lkotlinx/coroutines/s1;", "c", "(Ljava/util/concurrent/ExecutorService;)Lkotlinx/coroutines/s1;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/l0;", "b", "(Ljava/util/concurrent/Executor;)Lkotlinx/coroutines/l0;", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v1 {
    @NotNull
    public static final Executor a(@NotNull l0 l0Var) {
        Executor q3;
        s1 s1Var = (s1) (!(l0Var instanceof s1) ? null : l0Var);
        return (s1Var == null || (q3 = s1Var.q()) == null) ? new e1(l0Var) : q3;
    }

    @JvmName(name = "from")
    @NotNull
    public static final l0 b(@NotNull Executor executor) {
        l0 l0Var;
        e1 e1Var = (e1) (!(executor instanceof e1) ? null : executor);
        return (e1Var == null || (l0Var = e1Var.f59625a) == null) ? new u1(executor) : l0Var;
    }

    @JvmName(name = "from")
    @NotNull
    public static final s1 c(@NotNull ExecutorService executorService) {
        return new u1(executorService);
    }
}
