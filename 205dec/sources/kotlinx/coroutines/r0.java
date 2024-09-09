package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineScope.kt */
@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002\u001a\u0006\u0010\u0004\u001a\u00020\u0000\u001aO\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006\u00a2\u0006\u0002\b\tH\u0086@\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001c\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f\u001a\u001e\u0010\u0016\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0015\u001a\n\u0010\u0017\u001a\u00020\u0011*\u00020\u0000\u001a\u0013\u0010\u0018\u001a\u00020\u0001H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\"\u001b\u0010\u001f\u001a\u00020\u001a*\u00020\u00008F\u00a2\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/f;", "context", "m", "b", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "g", "(Ld2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Lkotlin/f1;", "d", "", "message", "", "c", "j", "h", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "k", "(Lkotlinx/coroutines/q0;)Z", "isActive$annotations", "(Lkotlinx/coroutines/q0;)V", "isActive", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r0 {
    @NotNull
    public static final q0 a(@NotNull kotlin.coroutines.f fVar) {
        b0 d4;
        if (fVar.get(e2.f59626i0) == null) {
            d4 = j2.d(null, 1, null);
            fVar = fVar.plus(d4);
        }
        return new kotlinx.coroutines.internal.i(fVar);
    }

    @NotNull
    public static final q0 b() {
        return new kotlinx.coroutines.internal.i(h3.c(null, 1, null).plus(f1.e()));
    }

    public static final void c(@NotNull q0 q0Var, @NotNull String str, @Nullable Throwable th) {
        d(q0Var, r1.a(str, th));
    }

    public static final void d(@NotNull q0 q0Var, @Nullable CancellationException cancellationException) {
        e2 e2Var = (e2) q0Var.getCoroutineContext().get(e2.f59626i0);
        if (e2Var != null) {
            e2Var.b(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + q0Var).toString());
    }

    public static /* synthetic */ void e(q0 q0Var, String str, Throwable th, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            th = null;
        }
        c(q0Var, str, th);
    }

    public static /* synthetic */ void f(q0 q0Var, CancellationException cancellationException, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            cancellationException = null;
        }
        d(q0Var, cancellationException);
    }

    @Nullable
    public static final <R> Object g(@NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super R> cVar) {
        Object h4;
        kotlinx.coroutines.internal.f0 f0Var = new kotlinx.coroutines.internal.f0(cVar.getContext(), cVar);
        Object f4 = z2.b.f(f0Var, f0Var, pVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (f4 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return f4;
    }

    @Nullable
    public static final Object h(@NotNull kotlin.coroutines.c<? super kotlin.coroutines.f> cVar) {
        return cVar.getContext();
    }

    @Nullable
    private static final Object i(@NotNull kotlin.coroutines.c cVar) {
        kotlin.jvm.internal.c0.e(3);
        throw null;
    }

    public static final void j(@NotNull q0 q0Var) {
        h2.A(q0Var.getCoroutineContext());
    }

    public static final boolean k(@NotNull q0 q0Var) {
        e2 e2Var = (e2) q0Var.getCoroutineContext().get(e2.f59626i0);
        if (e2Var != null) {
            return e2Var.isActive();
        }
        return true;
    }

    public static /* synthetic */ void l(q0 q0Var) {
    }

    @NotNull
    public static final q0 m(@NotNull q0 q0Var, @NotNull kotlin.coroutines.f fVar) {
        return new kotlinx.coroutines.internal.i(q0Var.getCoroutineContext().plus(fVar));
    }
}
