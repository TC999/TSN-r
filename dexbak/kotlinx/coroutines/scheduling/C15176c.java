package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.ranges._Ranges;
import kotlinx.coroutines.C15054g1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.C15082l0;
import kotlinx.coroutines.internal.C15084n0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Dispatcher.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0007R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/scheduling/c;", "Lkotlinx/coroutines/scheduling/d;", "Lkotlin/f1;", "close", "", "toString", "H", "Lkotlinx/coroutines/l0;", "g", "Lkotlinx/coroutines/l0;", "G", "()Lkotlinx/coroutines/l0;", "IO", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.scheduling.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15176c extends C15177d {
    @NotNull

    /* renamed from: g */
    private static final CoroutineDispatcher f43275g;

    /* renamed from: h */
    public static final C15176c f43276h;

    static {
        int m7481n;
        int m4258d;
        C15176c c15176c = new C15176c();
        f43276h = c15176c;
        m7481n = _Ranges.m7481n(64, C15082l0.m4281a());
        m4258d = C15084n0.m4258d(C15054g1.f43017a, m7481n, 0, 0, 12, null);
        f43275g = new ExecutorC15178f(c15176c, m4258d, "Dispatchers.IO", 1);
    }

    private C15176c() {
        super(0, 0, null, 7, null);
    }

    @NotNull
    /* renamed from: G */
    public final CoroutineDispatcher m3751G() {
        return f43275g;
    }

    @InternalCoroutinesApi
    @NotNull
    /* renamed from: H */
    public final String m3750H() {
        return super.toString();
    }

    @Override // kotlinx.coroutines.scheduling.C15177d, kotlinx.coroutines.AbstractC15168s1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.scheduling.C15177d, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return C15184l.f43294a;
    }
}
