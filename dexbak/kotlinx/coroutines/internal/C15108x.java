package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.sequences.C14520s;
import kotlin.sequences.Sequence;
import kotlin.sequences._Sequences;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: MainDispatchers.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, m12616d2 = {"Lkotlinx/coroutines/internal/x;", "", "Lkotlinx/coroutines/p2;", "a", "", "Z", "FAST_SERVICE_LOADER_ENABLED", "b", "Lkotlinx/coroutines/p2;", "dispatcher", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.x */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15108x {

    /* renamed from: a */
    private static final boolean f43129a;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: b */
    public static final MainCoroutineDispatcher f43130b;

    /* renamed from: c */
    public static final C15108x f43131c;

    static {
        C15108x c15108x = new C15108x();
        f43131c = c15108x;
        f43129a = C15082l0.m4277e("kotlinx.coroutines.fast.service.loader", true);
        f43130b = c15108x.m4141a();
    }

    private C15108x() {
    }

    /* renamed from: a */
    private final MainCoroutineDispatcher m4141a() {
        Sequence m6990h;
        List<MainDispatcherFactory> m7189V2;
        Object next;
        MainCoroutineDispatcher m4135f;
        try {
            if (f43129a) {
                m7189V2 = FastServiceLoader.f43061b.m4286d();
            } else {
                m6990h = C14520s.m6990h(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator());
                m7189V2 = _Sequences.m7189V2(m6990h);
            }
            Iterator<T> it = m7189V2.iterator();
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
            return (mainDispatcherFactory == null || (m4135f = C15109y.m4135f(mainDispatcherFactory, m7189V2)) == null) ? C15109y.m4139b(null, null, 3, null) : m4135f;
        } catch (Throwable th) {
            return C15109y.m4139b(th, null, 2, null);
        }
    }
}
