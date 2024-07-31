package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: EventLoop.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0004"}, m12616d2 = {"Lkotlinx/coroutines/m1;", "a", "", "b", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.p1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15155p1 {
    @NotNull
    /* renamed from: a */
    public static final AbstractC15133m1 m3877a() {
        return new EventLoop(Thread.currentThread());
    }

    @InternalCoroutinesApi
    /* renamed from: b */
    public static final long m3876b() {
        AbstractC15133m1 m4084a = C15120k3.f43148b.m4084a();
        if (m4084a != null) {
            return m4084a.mo3563J();
        }
        return Long.MAX_VALUE;
    }
}
