package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Job.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\f\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'\u00a8\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/u2;", "Lkotlinx/coroutines/e2;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "x", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface u2 extends e2 {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Job.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        public static <R> R b(@NotNull u2 u2Var, R r3, @NotNull d2.p<? super R, ? super f.b, ? extends R> pVar) {
            return (R) e2.a.d(u2Var, r3, pVar);
        }

        @Nullable
        public static <E extends f.b> E c(@NotNull u2 u2Var, @NotNull f.c<E> cVar) {
            return (E) e2.a.e(u2Var, cVar);
        }

        @NotNull
        public static kotlin.coroutines.f d(@NotNull u2 u2Var, @NotNull f.c<?> cVar) {
            return e2.a.g(u2Var, cVar);
        }

        @NotNull
        public static kotlin.coroutines.f e(@NotNull u2 u2Var, @NotNull kotlin.coroutines.f fVar) {
            return e2.a.h(u2Var, fVar);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        public static e2 f(@NotNull u2 u2Var, @NotNull e2 e2Var) {
            return e2.a.i(u2Var, e2Var);
        }
    }

    @InternalCoroutinesApi
    @NotNull
    CancellationException x();
}
