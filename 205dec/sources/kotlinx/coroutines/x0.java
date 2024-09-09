package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Deferred.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0003\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H'R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/x0;", "T", "Lkotlinx/coroutines/e2;", "k", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "e", "()Ljava/lang/Object;", "", "j", "Lkotlinx/coroutines/selects/d;", "y", "()Lkotlinx/coroutines/selects/d;", "onAwait", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface x0<T> extends e2 {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Deferred.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        public static <T, R> R b(@NotNull x0<? extends T> x0Var, R r3, @NotNull d2.p<? super R, ? super f.b, ? extends R> pVar) {
            return (R) e2.a.d(x0Var, r3, pVar);
        }

        @Nullable
        public static <T, E extends f.b> E c(@NotNull x0<? extends T> x0Var, @NotNull f.c<E> cVar) {
            return (E) e2.a.e(x0Var, cVar);
        }

        @NotNull
        public static <T> kotlin.coroutines.f d(@NotNull x0<? extends T> x0Var, @NotNull f.c<?> cVar) {
            return e2.a.g(x0Var, cVar);
        }

        @NotNull
        public static <T> kotlin.coroutines.f e(@NotNull x0<? extends T> x0Var, @NotNull kotlin.coroutines.f fVar) {
            return e2.a.h(x0Var, fVar);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        public static <T> e2 f(@NotNull x0<? extends T> x0Var, @NotNull e2 e2Var) {
            return e2.a.i(x0Var, e2Var);
        }
    }

    @ExperimentalCoroutinesApi
    T e();

    @ExperimentalCoroutinesApi
    @Nullable
    Throwable j();

    @Nullable
    Object k(@NotNull kotlin.coroutines.c<? super T> cVar);

    @NotNull
    kotlinx.coroutines.selects.d<T> y();
}
