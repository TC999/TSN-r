package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlinx.coroutines.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableDeferred.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lkotlinx/coroutines/y;", "T", "Lkotlinx/coroutines/x0;", "value", "", "v", "(Ljava/lang/Object;)Z", "", "exception", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface y<T> extends x0<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: CompletableDeferred.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        public static <T, R> R b(@NotNull y<T> yVar, R r3, @NotNull d2.p<? super R, ? super f.b, ? extends R> pVar) {
            return (R) x0.a.b(yVar, r3, pVar);
        }

        @Nullable
        public static <T, E extends f.b> E c(@NotNull y<T> yVar, @NotNull f.c<E> cVar) {
            return (E) x0.a.c(yVar, cVar);
        }

        @NotNull
        public static <T> kotlin.coroutines.f d(@NotNull y<T> yVar, @NotNull f.c<?> cVar) {
            return x0.a.d(yVar, cVar);
        }

        @NotNull
        public static <T> kotlin.coroutines.f e(@NotNull y<T> yVar, @NotNull kotlin.coroutines.f fVar) {
            return x0.a.e(yVar, fVar);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        public static <T> e2 f(@NotNull y<T> yVar, @NotNull e2 e2Var) {
            return x0.a.f(yVar, e2Var);
        }
    }

    boolean c(@NotNull Throwable th);

    boolean v(T t3);
}
