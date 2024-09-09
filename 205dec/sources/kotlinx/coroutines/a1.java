package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Delay.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0001\u001a\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0001\u0010\u0002\u001a\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u0016\u0010\f\u001a\u00020\u0003*\u00020\bH\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\"\u0018\u0010\u0012\u001a\u00020\u000f*\u00020\u000e8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "timeMillis", "Lkotlin/f1;", "b", "(JLkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/time/d;", "duration", "c", "(DLkotlin/coroutines/c;)Ljava/lang/Object;", "e", "(D)J", "Lkotlin/coroutines/f;", "Lkotlinx/coroutines/z0;", "d", "(Lkotlin/coroutines/f;)Lkotlinx/coroutines/z0;", "delay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a1 {
    @Nullable
    public static final Object a(@NotNull kotlin.coroutines.c<?> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        p pVar = new p(d4, 1);
        pVar.H();
        Object y3 = pVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    @Nullable
    public static final Object b(long j4, @NotNull kotlin.coroutines.c<? super kotlin.f1> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        if (j4 <= 0) {
            return kotlin.f1.f55527a;
        }
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        p pVar = new p(d4, 1);
        pVar.H();
        if (j4 < Long.MAX_VALUE) {
            d(pVar.getContext()).d(j4, pVar);
        }
        Object y3 = pVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    @ExperimentalTime
    @Nullable
    public static final Object c(double d4, @NotNull kotlin.coroutines.c<? super kotlin.f1> cVar) {
        Object h4;
        Object b4 = b(e(d4), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return b4 == h4 ? b4 : kotlin.f1.f55527a;
    }

    @NotNull
    public static final z0 d(@NotNull kotlin.coroutines.f fVar) {
        f.b bVar = fVar.get(kotlin.coroutines.d.f55503f0);
        if (!(bVar instanceof z0)) {
            bVar = null;
        }
        z0 z0Var = (z0) bVar;
        return z0Var != null ? z0Var : w0.a();
    }

    @ExperimentalTime
    public static final long e(double d4) {
        long o4;
        if (kotlin.time.d.compareTo-LRDsOJo(d4, kotlin.time.d.f58993b.getZERO-UwyO8pc()) > 0) {
            o4 = kotlin.ranges.q.o(kotlin.time.d.toLongMilliseconds-impl(d4), 1L);
            return o4;
        }
        return 0L;
    }
}
