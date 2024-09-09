package kotlinx.coroutines;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineExceptionHandlerImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\"\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\n"}, d2 = {"Lkotlin/coroutines/f;", "context", "", "exception", "Lkotlin/f1;", "a", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Ljava/util/List;", "handlers", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m0 {

    /* renamed from: a  reason: collision with root package name */
    private static final List<CoroutineExceptionHandler> f60493a;

    static {
        kotlin.sequences.m h4;
        List<CoroutineExceptionHandler> V2;
        h4 = kotlin.sequences.s.h(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator());
        V2 = SequencesKt___SequencesKt.V2(h4);
        f60493a = V2;
    }

    public static final void a(@NotNull kotlin.coroutines.f fVar, @NotNull Throwable th) {
        for (CoroutineExceptionHandler coroutineExceptionHandler : f60493a) {
            try {
                coroutineExceptionHandler.handleException(fVar, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, n0.c(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
