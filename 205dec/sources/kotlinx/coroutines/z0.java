package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Delay.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH&J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00022\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/z0;", "", "", "time", "Lkotlin/f1;", "o", "(JLkotlin/coroutines/c;)Ljava/lang/Object;", "timeMillis", "Lkotlinx/coroutines/o;", "continuation", "d", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/coroutines/f;", "context", "Lkotlinx/coroutines/i1;", "f", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface z0 {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Delay.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @Nullable
        public static Object a(@NotNull z0 z0Var, long j4, @NotNull kotlin.coroutines.c<? super kotlin.f1> cVar) {
            kotlin.coroutines.c d4;
            Object h4;
            if (j4 <= 0) {
                return kotlin.f1.f55527a;
            }
            d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
            p pVar = new p(d4, 1);
            pVar.H();
            z0Var.d(j4, pVar);
            Object y3 = pVar.y();
            h4 = kotlin.coroutines.intrinsics.b.h();
            if (y3 == h4) {
                kotlin.coroutines.jvm.internal.e.c(cVar);
            }
            return y3;
        }

        @NotNull
        public static i1 b(@NotNull z0 z0Var, long j4, @NotNull Runnable runnable, @NotNull kotlin.coroutines.f fVar) {
            return w0.a().f(j4, runnable, fVar);
        }
    }

    void d(long j4, @NotNull o<? super kotlin.f1> oVar);

    @NotNull
    i1 f(long j4, @NotNull Runnable runnable, @NotNull kotlin.coroutines.f fVar);

    @Nullable
    Object o(long j4, @NotNull kotlin.coroutines.c<? super kotlin.f1> cVar);
}
