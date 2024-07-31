package kotlinx.coroutines;

import com.tencent.connect.common.Constants;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: Executors.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0005¨\u0006\t"}, m12616d2 = {"Ljava/util/concurrent/ExecutorService;", "Lkotlinx/coroutines/s1;", "c", "(Ljava/util/concurrent/ExecutorService;)Lkotlinx/coroutines/s1;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/l0;", "b", "(Ljava/util/concurrent/Executor;)Lkotlinx/coroutines/l0;", "a", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.v1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15242v1 {
    @NotNull
    /* renamed from: a */
    public static final Executor m3534a(@NotNull CoroutineDispatcher coroutineDispatcher) {
        Executor mo3514p;
        AbstractC15168s1 abstractC15168s1 = (AbstractC15168s1) (!(coroutineDispatcher instanceof AbstractC15168s1) ? null : coroutineDispatcher);
        return (abstractC15168s1 == null || (mo3514p = abstractC15168s1.mo3514p()) == null) ? new ExecutorC14775e1(coroutineDispatcher) : mo3514p;
    }

    @JvmName(name = Constants.FROM)
    @NotNull
    /* renamed from: b */
    public static final CoroutineDispatcher m3533b(@NotNull Executor executor) {
        CoroutineDispatcher coroutineDispatcher;
        ExecutorC14775e1 executorC14775e1 = (ExecutorC14775e1) (!(executor instanceof ExecutorC14775e1) ? null : executor);
        return (executorC14775e1 == null || (coroutineDispatcher = executorC14775e1.f42280a) == null) ? new C15236u1(executor) : coroutineDispatcher;
    }

    @JvmName(name = Constants.FROM)
    @NotNull
    /* renamed from: c */
    public static final AbstractC15168s1 m3532c(@NotNull ExecutorService executorService) {
        return new C15236u1(executorService);
    }
}
