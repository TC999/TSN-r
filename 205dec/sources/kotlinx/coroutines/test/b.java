package kotlinx.coroutines.test;

import d2.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: TestCoroutineContext.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0002\b\u0004H\u0007\u00a8\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/test/a;", "testContext", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "testBody", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b {
    @Deprecated(level = DeprecationLevel.WARNING, message = "This API has been deprecated to integrate with Structured Concurrency.", replaceWith = @ReplaceWith(expression = "testContext.runBlockingTest(testBody)", imports = {"kotlin.coroutines.test"}))
    public static final void a(@NotNull a aVar, @NotNull l<? super a, f1> lVar) {
        lVar.invoke(aVar);
        List<Throwable> K = aVar.K();
        boolean z3 = true;
        if (!(K instanceof Collection) || !K.isEmpty()) {
            Iterator<T> it = K.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!(((Throwable) it.next()) instanceof CancellationException)) {
                    z3 = false;
                    break;
                }
            }
        }
        if (z3) {
            return;
        }
        throw new AssertionError("Coroutine encountered unhandled exceptions:\n" + aVar.K());
    }

    public static /* synthetic */ void b(a aVar, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            aVar = new a(null, 1, null);
        }
        a(aVar, lVar);
    }
}
