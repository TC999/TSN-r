package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {}, d1 = {"kotlinx/coroutines/i", "kotlinx/coroutines/j"}, d2 = {}, k = 4, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @NotNull
    public static final <T> x0<T> a(@NotNull q0 q0Var, @NotNull kotlin.coroutines.f fVar, @NotNull CoroutineStart coroutineStart, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        return j.a(q0Var, fVar, coroutineStart, pVar);
    }

    @Nullable
    public static final <T> Object c(@NotNull l0 l0Var, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return j.c(l0Var, pVar, cVar);
    }

    @Nullable
    private static final Object d(@NotNull l0 l0Var, @NotNull d2.p pVar, @NotNull kotlin.coroutines.c cVar) {
        return j.c(l0Var, pVar, cVar);
    }

    @NotNull
    public static final e2 e(@NotNull q0 q0Var, @NotNull kotlin.coroutines.f fVar, @NotNull CoroutineStart coroutineStart, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super kotlin.f1>, ? extends Object> pVar) {
        return j.e(q0Var, fVar, coroutineStart, pVar);
    }

    public static /* synthetic */ e2 f(q0 q0Var, kotlin.coroutines.f fVar, CoroutineStart coroutineStart, d2.p pVar, int i4, Object obj) {
        return j.f(q0Var, fVar, coroutineStart, pVar, i4, obj);
    }

    public static final <T> T g(@NotNull kotlin.coroutines.f fVar, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) throws InterruptedException {
        return (T) i.a(fVar, pVar);
    }

    public static /* synthetic */ Object h(kotlin.coroutines.f fVar, d2.p pVar, int i4, Object obj) throws InterruptedException {
        return i.b(fVar, pVar, i4, obj);
    }

    @Nullable
    public static final <T> Object i(@NotNull kotlin.coroutines.f fVar, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return j.g(fVar, pVar, cVar);
    }
}
