package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.k3;
import kotlinx.coroutines.m1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DispatchedContinuation.kt */
@Metadata(bv = {}, d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aW\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\u0012\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\t0\rH\u0000\u001a;\u0010\u0017\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H\u0082\b\"\u001a\u0010\u001d\u001a\u00020\u00188\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001b\u0010\u001c\"\u001a\u0010\u001f\u001a\u00020\u00188\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001a\u0012\u0004\b\u001e\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"T", "Lkotlin/coroutines/c;", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "onCancellation", "f", "(Lkotlin/coroutines/c;Ljava/lang/Object;Ld2/l;)V", "Lkotlinx/coroutines/internal/j;", "", "h", "", "contState", "", "mode", "doYield", "Lkotlin/Function0;", "block", "b", "Lkotlinx/coroutines/internal/j0;", "a", "Lkotlinx/coroutines/internal/j0;", "getUNDEFINED$annotations", "()V", "UNDEFINED", "getREUSABLE_CLAIMED$annotations", "REUSABLE_CLAIMED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k {

    /* renamed from: a */
    private static final j0 f60375a = new j0("UNDEFINED");
    @JvmField
    @NotNull

    /* renamed from: b */
    public static final j0 f60376b = new j0("REUSABLE_CLAIMED");

    public static final /* synthetic */ j0 a() {
        return f60375a;
    }

    private static final boolean b(j<?> jVar, Object obj, int i4, boolean z3, d2.a<f1> aVar) {
        m1 b4 = k3.f60465b.b();
        if (z3 && b4.G()) {
            return false;
        }
        if (b4.F()) {
            jVar.f60369d = obj;
            jVar.f59070c = i4;
            b4.t(jVar);
            return true;
        }
        b4.C(true);
        try {
            aVar.invoke();
            do {
            } while (b4.I());
            kotlin.jvm.internal.c0.d(1);
        } catch (Throwable th) {
            try {
                jVar.h(th, null);
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.c0.d(1);
                b4.p(true);
                kotlin.jvm.internal.c0.c(1);
                throw th2;
            }
        }
        b4.p(true);
        kotlin.jvm.internal.c0.c(1);
        return false;
    }

    static /* synthetic */ boolean c(j jVar, Object obj, int i4, boolean z3, d2.a aVar, int i5, Object obj2) {
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        m1 b4 = k3.f60465b.b();
        if (z3 && b4.G()) {
            return false;
        }
        if (b4.F()) {
            jVar.f60369d = obj;
            jVar.f59070c = i4;
            b4.t(jVar);
            return true;
        }
        b4.C(true);
        try {
            aVar.invoke();
            do {
            } while (b4.I());
            kotlin.jvm.internal.c0.d(1);
        } catch (Throwable th) {
            try {
                jVar.h(th, null);
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.c0.d(1);
                b4.p(true);
                kotlin.jvm.internal.c0.c(1);
                throw th2;
            }
        }
        b4.p(true);
        kotlin.jvm.internal.c0.c(1);
        return false;
    }

    public static /* synthetic */ void d() {
    }

    private static /* synthetic */ void e() {
    }

    @InternalCoroutinesApi
    public static final <T> void f(@NotNull kotlin.coroutines.c<? super T> cVar, @NotNull Object obj, @Nullable d2.l<? super Throwable, f1> lVar) {
        boolean z3;
        if (cVar instanceof j) {
            j jVar = (j) cVar;
            Object b4 = kotlinx.coroutines.i0.b(obj, lVar);
            if (jVar.f60372g.isDispatchNeeded(jVar.getContext())) {
                jVar.f60369d = b4;
                jVar.f59070c = 1;
                jVar.f60372g.dispatch(jVar.getContext(), jVar);
                return;
            }
            m1 b5 = k3.f60465b.b();
            if (b5.F()) {
                jVar.f60369d = b4;
                jVar.f59070c = 1;
                b5.t(jVar);
                return;
            }
            b5.C(true);
            try {
                e2 e2Var = (e2) jVar.getContext().get(e2.f59626i0);
                if (e2Var == null || e2Var.isActive()) {
                    z3 = false;
                } else {
                    CancellationException l4 = e2Var.l();
                    jVar.c(b4, l4);
                    Result.a aVar = Result.Companion;
                    jVar.resumeWith(Result.m119constructorimpl(kotlin.d0.a(l4)));
                    z3 = true;
                }
                if (!z3) {
                    kotlin.coroutines.f context = jVar.getContext();
                    Object c4 = o0.c(context, jVar.f60371f);
                    jVar.f60373h.resumeWith(obj);
                    f1 f1Var = f1.f55527a;
                    o0.a(context, c4);
                }
                do {
                } while (b5.I());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        cVar.resumeWith(obj);
    }

    public static /* synthetic */ void g(kotlin.coroutines.c cVar, Object obj, d2.l lVar, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            lVar = null;
        }
        f(cVar, obj, lVar);
    }

    public static final boolean h(@NotNull j<? super f1> jVar) {
        f1 f1Var = f1.f55527a;
        m1 b4 = k3.f60465b.b();
        if (b4.G()) {
            return false;
        }
        if (b4.F()) {
            jVar.f60369d = f1Var;
            jVar.f59070c = 1;
            b4.t(jVar);
            return true;
        }
        b4.C(true);
        try {
            jVar.run();
            do {
            } while (b4.I());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
