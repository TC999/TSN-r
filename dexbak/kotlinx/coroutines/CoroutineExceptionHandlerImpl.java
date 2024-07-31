package kotlinx.coroutines;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.C14520s;
import kotlin.sequences.Sequence;
import kotlin.sequences._Sequences;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\"\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\b¨\u0006\n"}, m12616d2 = {"Lkotlin/coroutines/f;", "context", "", "exception", "Lkotlin/f1;", "a", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Ljava/util/List;", "handlers", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.m0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CoroutineExceptionHandlerImpl {

    /* renamed from: a */
    private static final List<CoroutineExceptionHandler> f43176a;

    static {
        Sequence m6990h;
        List<CoroutineExceptionHandler> m7189V2;
        m6990h = C14520s.m6990h(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator());
        m7189V2 = _Sequences.m7189V2(m6990h);
        f43176a = m7189V2;
    }

    /* renamed from: a */
    public static final void m3997a(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th) {
        for (CoroutineExceptionHandler coroutineExceptionHandler : f43176a) {
            try {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, C15137n0.m3968c(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
