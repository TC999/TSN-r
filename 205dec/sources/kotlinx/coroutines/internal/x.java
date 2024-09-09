package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.p2;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MainDispatchers.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lkotlinx/coroutines/internal/x;", "", "Lkotlinx/coroutines/p2;", "a", "", "Z", "FAST_SERVICE_LOADER_ENABLED", "b", "Lkotlinx/coroutines/p2;", "dispatcher", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f60446a;
    @JvmField
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final p2 f60447b;

    /* renamed from: c  reason: collision with root package name */
    public static final x f60448c;

    static {
        x xVar = new x();
        f60448c = xVar;
        f60446a = l0.e("kotlinx.coroutines.fast.service.loader", true);
        f60447b = xVar.a();
    }

    private x() {
    }

    private final p2 a() {
        kotlin.sequences.m h4;
        List<MainDispatcherFactory> V2;
        Object next;
        p2 f4;
        try {
            if (f60446a) {
                V2 = l.f60378b.d();
            } else {
                h4 = kotlin.sequences.s.h(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator());
                V2 = SequencesKt___SequencesKt.V2(h4);
            }
            Iterator<T> it = V2.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            return (mainDispatcherFactory == null || (f4 = y.f(mainDispatcherFactory, V2)) == null) ? y.b(null, null, 3, null) : f4;
        } catch (Throwable th) {
            return y.b(th, null, 2, null);
        }
    }
}
