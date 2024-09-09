package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpecialTypes.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p0 {
    @Nullable
    public static final a a(@NotNull e0 e0Var) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        l1 K0 = e0Var.K0();
        if (K0 instanceof a) {
            return (a) K0;
        }
        return null;
    }

    @Nullable
    public static final m0 b(@NotNull e0 e0Var) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        a a4 = a(e0Var);
        if (a4 == null) {
            return null;
        }
        return a4.T0();
    }

    public static final boolean c(@NotNull e0 e0Var) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        return e0Var.K0() instanceof n;
    }

    private static final d0 d(d0 d0Var) {
        int Z;
        e0 e0Var;
        Collection<e0> j4 = d0Var.j();
        Z = kotlin.collections.y.Z(j4, 10);
        ArrayList arrayList = new ArrayList(Z);
        Iterator<T> it = j4.iterator();
        boolean z3 = false;
        while (true) {
            e0Var = null;
            if (!it.hasNext()) {
                break;
            }
            e0 e0Var2 = (e0) it.next();
            if (h1.m(e0Var2)) {
                e0Var2 = f(e0Var2.K0(), false, 1, null);
                z3 = true;
            }
            arrayList.add(e0Var2);
        }
        if (z3) {
            e0 f4 = d0Var.f();
            if (f4 != null) {
                if (h1.m(f4)) {
                    f4 = f(f4.K0(), false, 1, null);
                }
                e0Var = f4;
            }
            return new d0(arrayList).l(e0Var);
        }
        return null;
    }

    @NotNull
    public static final l1 e(@NotNull l1 l1Var, boolean z3) {
        kotlin.jvm.internal.f0.p(l1Var, "<this>");
        n b4 = n.f58394d.b(l1Var, z3);
        if (b4 == null) {
            m0 g4 = g(l1Var);
            return g4 == null ? l1Var.L0(false) : g4;
        }
        return b4;
    }

    public static /* synthetic */ l1 f(l1 l1Var, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        return e(l1Var, z3);
    }

    private static final m0 g(e0 e0Var) {
        d0 d4;
        y0 H0 = e0Var.H0();
        d0 d0Var = H0 instanceof d0 ? (d0) H0 : null;
        if (d0Var == null || (d4 = d(d0Var)) == null) {
            return null;
        }
        return d4.e();
    }

    @NotNull
    public static final m0 h(@NotNull m0 m0Var, boolean z3) {
        kotlin.jvm.internal.f0.p(m0Var, "<this>");
        n b4 = n.f58394d.b(m0Var, z3);
        if (b4 == null) {
            m0 g4 = g(m0Var);
            return g4 == null ? m0Var.O0(false) : g4;
        }
        return b4;
    }

    public static /* synthetic */ m0 i(m0 m0Var, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        return h(m0Var, z3);
    }

    @NotNull
    public static final m0 j(@NotNull m0 m0Var, @NotNull m0 abbreviatedType) {
        kotlin.jvm.internal.f0.p(m0Var, "<this>");
        kotlin.jvm.internal.f0.p(abbreviatedType, "abbreviatedType");
        return g0.a(m0Var) ? m0Var : new a(m0Var, abbreviatedType);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.types.checker.i k(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.i iVar) {
        kotlin.jvm.internal.f0.p(iVar, "<this>");
        return new kotlin.reflect.jvm.internal.impl.types.checker.i(iVar.Q0(), iVar.H0(), iVar.S0(), iVar.getAnnotations(), iVar.I0(), true);
    }
}
