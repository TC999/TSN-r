package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@Metadata(bv = {}, d1 = {"kotlinx/coroutines/i2", "kotlinx/coroutines/j2"}, d2 = {}, k = 4, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h2 {
    public static final void A(@NotNull kotlin.coroutines.f fVar) {
        j2.y(fVar);
    }

    public static final void B(@NotNull e2 e2Var) {
        j2.z(e2Var);
    }

    @NotNull
    public static final e2 C(@NotNull kotlin.coroutines.f fVar) {
        return j2.A(fVar);
    }

    public static final boolean D(@NotNull kotlin.coroutines.f fVar) {
        return j2.B(fVar);
    }

    @InternalCoroutinesApi
    @NotNull
    public static final i1 a(@NotNull d2.a<kotlin.f1> aVar) {
        return j2.a(aVar);
    }

    @NotNull
    public static final b0 b(@Nullable e2 e2Var) {
        return j2.b(e2Var);
    }

    public static final void g(@NotNull kotlin.coroutines.f fVar, @Nullable CancellationException cancellationException) {
        j2.g(fVar, cancellationException);
    }

    public static final void h(@NotNull e2 e2Var, @NotNull String str, @Nullable Throwable th) {
        j2.h(e2Var, str, th);
    }

    @Nullable
    public static final Object m(@NotNull e2 e2Var, @NotNull kotlin.coroutines.c<? super kotlin.f1> cVar) {
        return j2.m(e2Var, cVar);
    }

    public static final void p(@NotNull kotlin.coroutines.f fVar, @Nullable CancellationException cancellationException) {
        j2.p(fVar, cancellationException);
    }

    public static final void s(@NotNull e2 e2Var, @Nullable CancellationException cancellationException) {
        j2.s(e2Var, cancellationException);
    }

    public static final void x(@NotNull o<?> oVar, @NotNull Future<?> future) {
        i2.a(oVar, future);
    }

    @InternalCoroutinesApi
    @NotNull
    public static final i1 y(@NotNull e2 e2Var, @NotNull Future<?> future) {
        return i2.b(e2Var, future);
    }

    @NotNull
    public static final i1 z(@NotNull e2 e2Var, @NotNull i1 i1Var) {
        return j2.x(e2Var, i1Var);
    }
}
