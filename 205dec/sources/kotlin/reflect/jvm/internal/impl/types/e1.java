package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;

/* compiled from: TypeSubstitution.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e1 {
    @NotNull
    public static final m0 a(@NotNull e0 e0Var) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        l1 K0 = e0Var.K0();
        m0 m0Var = K0 instanceof m0 ? (m0) K0 : null;
        if (m0Var != null) {
            return m0Var;
        }
        throw new IllegalStateException(kotlin.jvm.internal.f0.C("This is should be simple type: ", e0Var).toString());
    }

    @JvmOverloads
    @NotNull
    public static final e0 b(@NotNull e0 e0Var, @NotNull List<? extends a1> newArguments, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        kotlin.jvm.internal.f0.p(newArguments, "newArguments");
        kotlin.jvm.internal.f0.p(newAnnotations, "newAnnotations");
        return e(e0Var, newArguments, newAnnotations, null, 4, null);
    }

    @JvmOverloads
    @NotNull
    public static final e0 c(@NotNull e0 e0Var, @NotNull List<? extends a1> newArguments, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations, @NotNull List<? extends a1> newArgumentsForUpperBound) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        kotlin.jvm.internal.f0.p(newArguments, "newArguments");
        kotlin.jvm.internal.f0.p(newAnnotations, "newAnnotations");
        kotlin.jvm.internal.f0.p(newArgumentsForUpperBound, "newArgumentsForUpperBound");
        if ((newArguments.isEmpty() || newArguments == e0Var.G0()) && newAnnotations == e0Var.getAnnotations()) {
            return e0Var;
        }
        l1 K0 = e0Var.K0();
        if (K0 instanceof y) {
            y yVar = (y) K0;
            return f0.d(d(yVar.P0(), newArguments, newAnnotations), d(yVar.Q0(), newArgumentsForUpperBound, newAnnotations));
        } else if (K0 instanceof m0) {
            return d((m0) K0, newArguments, newAnnotations);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @JvmOverloads
    @NotNull
    public static final m0 d(@NotNull m0 m0Var, @NotNull List<? extends a1> newArguments, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        kotlin.jvm.internal.f0.p(m0Var, "<this>");
        kotlin.jvm.internal.f0.p(newArguments, "newArguments");
        kotlin.jvm.internal.f0.p(newAnnotations, "newAnnotations");
        if (newArguments.isEmpty() && newAnnotations == m0Var.getAnnotations()) {
            return m0Var;
        }
        if (newArguments.isEmpty()) {
            return m0Var.P0(newAnnotations);
        }
        return f0.j(newAnnotations, m0Var.H0(), newArguments, m0Var.I0(), null, 16, null);
    }

    public static /* synthetic */ e0 e(e0 e0Var, List list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, List list2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = e0Var.G0();
        }
        if ((i4 & 2) != 0) {
            fVar = e0Var.getAnnotations();
        }
        if ((i4 & 4) != 0) {
            list2 = list;
        }
        return c(e0Var, list, fVar, list2);
    }

    public static /* synthetic */ m0 f(m0 m0Var, List list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = m0Var.G0();
        }
        if ((i4 & 2) != 0) {
            fVar = m0Var.getAnnotations();
        }
        return d(m0Var, list, fVar);
    }
}
