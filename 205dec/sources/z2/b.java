package z2;

import d2.l;
import d2.p;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.jvm.internal.e;
import kotlin.d0;
import kotlin.jvm.internal.t0;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.o0;
import kotlinx.coroutines.m2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Undispatched.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001aT\u0010\u000b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a@\u0010\r\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u0007\u001aT\u0010\u000e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\f\u001a9\u0010\u0010\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u001a\u0010\u000f\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0082\b\u001a[\u0010\u0013\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\n\u001a\u00028\u00012'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t\u00a2\u0006\u0002\b\u0012H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a[\u0010\u0015\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\n\u001a\u00028\u00012'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t\u00a2\u0006\u0002\b\u0012H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0014\u001a?\u0010\u001b\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00012\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "completion", "Lkotlin/f1;", "c", "(Ld2/l;Lkotlin/coroutines/c;)V", "R", "Lkotlin/Function2;", "receiver", "d", "(Ld2/p;Ljava/lang/Object;Lkotlin/coroutines/c;)V", "a", "b", "block", "e", "Lkotlinx/coroutines/internal/f0;", "Lkotlin/ExtensionFunctionType;", "f", "(Lkotlinx/coroutines/internal/f0;Ljava/lang/Object;Ld2/p;)Ljava/lang/Object;", "g", "", "", "shouldThrow", "Lkotlin/Function0;", "startBlock", "h", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {
    public static final <T> void a(@NotNull l<? super c<? super T>, ? extends Object> lVar, @NotNull c<? super T> cVar) {
        c a4 = e.a(cVar);
        try {
            f context = cVar.getContext();
            Object c4 = o0.c(context, null);
            if (lVar != null) {
                Object invoke = ((l) t0.q(lVar, 1)).invoke(a4);
                o0.a(context, c4);
                if (invoke != kotlin.coroutines.intrinsics.a.h()) {
                    Result.a aVar = Result.Companion;
                    a4.resumeWith(Result.m119constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a4.resumeWith(Result.m119constructorimpl(d0.a(th)));
        }
    }

    public static final <R, T> void b(@NotNull p<? super R, ? super c<? super T>, ? extends Object> pVar, R r3, @NotNull c<? super T> cVar) {
        c a4 = e.a(cVar);
        try {
            f context = cVar.getContext();
            Object c4 = o0.c(context, null);
            if (pVar != null) {
                Object invoke = ((p) t0.q(pVar, 2)).invoke(r3, a4);
                o0.a(context, c4);
                if (invoke != kotlin.coroutines.intrinsics.a.h()) {
                    Result.a aVar = Result.Companion;
                    a4.resumeWith(Result.m119constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a4.resumeWith(Result.m119constructorimpl(d0.a(th)));
        }
    }

    public static final <T> void c(@NotNull l<? super c<? super T>, ? extends Object> lVar, @NotNull c<? super T> cVar) {
        c a4 = e.a(cVar);
        try {
            if (lVar != null) {
                Object invoke = ((l) t0.q(lVar, 1)).invoke(a4);
                if (invoke != kotlin.coroutines.intrinsics.a.h()) {
                    Result.a aVar = Result.Companion;
                    a4.resumeWith(Result.m119constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a4.resumeWith(Result.m119constructorimpl(d0.a(th)));
        }
    }

    public static final <R, T> void d(@NotNull p<? super R, ? super c<? super T>, ? extends Object> pVar, R r3, @NotNull c<? super T> cVar) {
        c a4 = e.a(cVar);
        try {
            if (pVar != null) {
                Object invoke = ((p) t0.q(pVar, 2)).invoke(r3, a4);
                if (invoke != kotlin.coroutines.intrinsics.a.h()) {
                    Result.a aVar = Result.Companion;
                    a4.resumeWith(Result.m119constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a4.resumeWith(Result.m119constructorimpl(d0.a(th)));
        }
    }

    private static final <T> void e(c<? super T> cVar, l<? super c<? super T>, ? extends Object> lVar) {
        c a4 = e.a(cVar);
        try {
            Object invoke = lVar.invoke(a4);
            if (invoke != kotlin.coroutines.intrinsics.a.h()) {
                Result.a aVar = Result.Companion;
                a4.resumeWith(Result.m119constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a4.resumeWith(Result.m119constructorimpl(d0.a(th)));
        }
    }

    @Nullable
    public static final <T, R> Object f(@NotNull f0<? super T> f0Var, R r3, @NotNull p<? super R, ? super c<? super T>, ? extends Object> pVar) {
        Object d0Var;
        Object K0;
        f0Var.m1();
        try {
        } catch (Throwable th) {
            d0Var = new kotlinx.coroutines.d0(th, false, 2, null);
        }
        if (pVar != null) {
            d0Var = ((p) t0.q(pVar, 2)).invoke(r3, f0Var);
            if (d0Var != kotlin.coroutines.intrinsics.a.h() && (K0 = f0Var.K0(d0Var)) != m2.f60498b) {
                if (!(K0 instanceof kotlinx.coroutines.d0)) {
                    return m2.o(K0);
                }
                throw ((kotlinx.coroutines.d0) K0).f59534a;
            }
            return kotlin.coroutines.intrinsics.a.h();
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @Nullable
    public static final <T, R> Object g(@NotNull f0<? super T> f0Var, R r3, @NotNull p<? super R, ? super c<? super T>, ? extends Object> pVar) {
        Object d0Var;
        Object K0;
        f0Var.m1();
        boolean z3 = false;
        try {
        } catch (Throwable th) {
            d0Var = new kotlinx.coroutines.d0(th, false, 2, null);
        }
        if (pVar != null) {
            d0Var = ((p) t0.q(pVar, 2)).invoke(r3, f0Var);
            if (d0Var != kotlin.coroutines.intrinsics.a.h() && (K0 = f0Var.K0(d0Var)) != m2.f60498b) {
                if (K0 instanceof kotlinx.coroutines.d0) {
                    Throwable th2 = ((kotlinx.coroutines.d0) K0).f59534a;
                    if (((th2 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th2).coroutine == f0Var) ? true : true) {
                        throw th2;
                    }
                    if (d0Var instanceof kotlinx.coroutines.d0) {
                        throw ((kotlinx.coroutines.d0) d0Var).f59534a;
                    }
                    return d0Var;
                }
                return m2.o(K0);
            }
            return kotlin.coroutines.intrinsics.a.h();
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    private static final <T> Object h(f0<? super T> f0Var, l<? super Throwable, Boolean> lVar, d2.a<? extends Object> aVar) {
        Object d0Var;
        Object K0;
        try {
            d0Var = aVar.invoke();
        } catch (Throwable th) {
            d0Var = new kotlinx.coroutines.d0(th, false, 2, null);
        }
        if (d0Var != kotlin.coroutines.intrinsics.a.h() && (K0 = f0Var.K0(d0Var)) != m2.f60498b) {
            if (K0 instanceof kotlinx.coroutines.d0) {
                kotlinx.coroutines.d0 d0Var2 = (kotlinx.coroutines.d0) K0;
                if (!lVar.invoke(d0Var2.f59534a).booleanValue()) {
                    if (d0Var instanceof kotlinx.coroutines.d0) {
                        throw ((kotlinx.coroutines.d0) d0Var).f59534a;
                    }
                    return d0Var;
                }
                throw d0Var2.f59534a;
            }
            return m2.o(K0);
        }
        return kotlin.coroutines.intrinsics.a.h();
    }
}
