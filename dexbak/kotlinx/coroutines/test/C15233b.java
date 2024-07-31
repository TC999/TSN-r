package kotlinx.coroutines.test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: TestCoroutineContext.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0007¨\u0006\u0007"}, m12616d2 = {"Lkotlinx/coroutines/test/a;", "testContext", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "testBody", "a", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.test.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C15233b {
    @Annotations(level = DeprecationLevel.WARNING, message = "This API has been deprecated to integrate with Structured Concurrency.", replaceWith = @ReplaceWith(expression = "testContext.runBlockingTest(testBody)", imports = {"kotlin.coroutines.test"}))
    /* renamed from: a */
    public static final void m3561a(@NotNull TestCoroutineContext testCoroutineContext, @NotNull InterfaceC15280l<? super TestCoroutineContext, Unit> interfaceC15280l) {
        interfaceC15280l.invoke(testCoroutineContext);
        List<Throwable> m3582K = testCoroutineContext.m3582K();
        boolean z = true;
        if (!(m3582K instanceof Collection) || !m3582K.isEmpty()) {
            Iterator<T> it = m3582K.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!(((Throwable) it.next()) instanceof CancellationException)) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            return;
        }
        throw new AssertionError("Coroutine encountered unhandled exceptions:\n" + testCoroutineContext.m3582K());
    }

    /* renamed from: b */
    public static /* synthetic */ void m3560b(TestCoroutineContext testCoroutineContext, InterfaceC15280l interfaceC15280l, int i, Object obj) {
        if ((i & 1) != 0) {
            testCoroutineContext = new TestCoroutineContext(null, 1, null);
        }
        m3561a(testCoroutineContext, interfaceC15280l);
    }
}
