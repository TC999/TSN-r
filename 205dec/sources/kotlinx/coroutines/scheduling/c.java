package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.ranges.q;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.n0;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Dispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0007R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/scheduling/c;", "Lkotlinx/coroutines/scheduling/d;", "Lkotlin/f1;", "close", "", "toString", "I", "Lkotlinx/coroutines/l0;", "g", "Lkotlinx/coroutines/l0;", "H", "()Lkotlinx/coroutines/l0;", "IO", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c extends d {
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final l0 f60592g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f60593h;

    static {
        int n4;
        int d4;
        c cVar = new c();
        f60593h = cVar;
        n4 = q.n(64, kotlinx.coroutines.internal.l0.a());
        d4 = n0.d("kotlinx.coroutines.io.parallelism", n4, 0, 0, 12, null);
        f60592g = new f(cVar, d4, "Dispatchers.IO", 1);
    }

    private c() {
        super(0, 0, null, 7, null);
    }

    @NotNull
    public final l0 H() {
        return f60592g;
    }

    @InternalCoroutinesApi
    @NotNull
    public final String I() {
        return super.toString();
    }

    @Override // kotlinx.coroutines.scheduling.d, kotlinx.coroutines.s1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.scheduling.d, kotlinx.coroutines.l0
    @NotNull
    public String toString() {
        return "Dispatchers.Default";
    }
}
