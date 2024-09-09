package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: EventLoop.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/m1;", "a", "", "b", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p1 {
    @NotNull
    public static final m1 a() {
        return new g(Thread.currentThread());
    }

    @InternalCoroutinesApi
    public static final long b() {
        m1 a4 = k3.f60465b.a();
        if (a4 != null) {
            return a4.H();
        }
        return Long.MAX_VALUE;
    }
}
