package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DispatchedTask.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0011\u001a \u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a.\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002\u001a'\u0010\u0010\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0080\b\u001a\u0019\u0010\u0013\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0080\b\"\u0014\u0010\u0015\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014\"\u001a\u0010\u0019\u001a\u00020\u00028\u0000X\u0081T\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0014\u0012\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u001b\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014\"\u0014\u0010\u001d\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0014\"\u0014\u0010\u001e\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014\"\u0018\u0010 \u001a\u00020\b*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001f\"\u0018\u0010!\u001a\u00020\b*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001f\u00a8\u0006\""}, d2 = {"T", "Lkotlinx/coroutines/c1;", "", "mode", "Lkotlin/f1;", "a", "Lkotlin/coroutines/c;", "delegate", "", "undispatched", "e", "f", "Lkotlinx/coroutines/m1;", "eventLoop", "Lkotlin/Function0;", "block", "h", "", "exception", "g", "I", "MODE_ATOMIC", "b", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE", "c", "MODE_CANCELLABLE_REUSABLE", "d", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "(I)Z", "isCancellableMode", "isReusableMode", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d1 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f59535a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f59536b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f59537c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f59538d = 4;

    /* renamed from: e  reason: collision with root package name */
    public static final int f59539e = -1;

    public static final <T> void a(@NotNull c1<? super T> c1Var, int i4) {
        kotlin.coroutines.c<? super T> e4 = c1Var.e();
        boolean z3 = i4 == 4;
        if (!z3 && (e4 instanceof kotlinx.coroutines.internal.j) && c(i4) == c(c1Var.f59070c)) {
            l0 l0Var = ((kotlinx.coroutines.internal.j) e4).f60372g;
            kotlin.coroutines.f context = e4.getContext();
            if (l0Var.isDispatchNeeded(context)) {
                l0Var.dispatch(context, c1Var);
                return;
            } else {
                f(c1Var);
                return;
            }
        }
        e(c1Var, e4, z3);
    }

    @PublishedApi
    public static /* synthetic */ void b() {
    }

    public static final boolean c(int i4) {
        return i4 == 1 || i4 == 2;
    }

    public static final boolean d(int i4) {
        return i4 == 2;
    }

    public static final <T> void e(@NotNull c1<? super T> c1Var, @NotNull kotlin.coroutines.c<? super T> cVar, boolean z3) {
        Object g4;
        Object i4 = c1Var.i();
        Throwable f4 = c1Var.f(i4);
        if (f4 != null) {
            Result.a aVar = Result.Companion;
            g4 = kotlin.d0.a(f4);
        } else {
            Result.a aVar2 = Result.Companion;
            g4 = c1Var.g(i4);
        }
        Object m119constructorimpl = Result.m119constructorimpl(g4);
        if (!z3) {
            cVar.resumeWith(m119constructorimpl);
        } else if (cVar != null) {
            kotlinx.coroutines.internal.j jVar = (kotlinx.coroutines.internal.j) cVar;
            kotlin.coroutines.f context = jVar.getContext();
            Object c4 = kotlinx.coroutines.internal.o0.c(context, jVar.f60371f);
            try {
                jVar.f60373h.resumeWith(m119constructorimpl);
                kotlin.f1 f1Var = kotlin.f1.f55527a;
            } finally {
                kotlinx.coroutines.internal.o0.a(context, c4);
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        }
    }

    private static final void f(c1<?> c1Var) {
        m1 b4 = k3.f60465b.b();
        if (b4.F()) {
            b4.t(c1Var);
            return;
        }
        b4.C(true);
        try {
            e(c1Var, c1Var.e(), true);
            do {
            } while (b4.I());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final void g(@NotNull kotlin.coroutines.c<?> cVar, @NotNull Throwable th) {
        Result.a aVar = Result.Companion;
        cVar.resumeWith(Result.m119constructorimpl(kotlin.d0.a(th)));
    }

    public static final void h(@NotNull c1<?> c1Var, @NotNull m1 m1Var, @NotNull d2.a<kotlin.f1> aVar) {
        m1Var.C(true);
        try {
            aVar.invoke();
            do {
            } while (m1Var.I());
            kotlin.jvm.internal.c0.d(1);
        } catch (Throwable th) {
            try {
                c1Var.h(th, null);
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.c0.d(1);
                m1Var.p(true);
                kotlin.jvm.internal.c0.c(1);
                throw th2;
            }
        }
        m1Var.p(true);
        kotlin.jvm.internal.c0.c(1);
    }
}
