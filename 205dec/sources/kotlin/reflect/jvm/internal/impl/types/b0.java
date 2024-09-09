package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

/* compiled from: flexibleTypes.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b0 {
    @NotNull
    public static final y a(@NotNull e0 e0Var) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        return (y) e0Var.K0();
    }

    public static final boolean b(@NotNull e0 e0Var) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        return e0Var.K0() instanceof y;
    }

    @NotNull
    public static final m0 c(@NotNull e0 e0Var) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        l1 K0 = e0Var.K0();
        if (K0 instanceof y) {
            return ((y) K0).P0();
        }
        if (K0 instanceof m0) {
            return (m0) K0;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final m0 d(@NotNull e0 e0Var) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        l1 K0 = e0Var.K0();
        if (K0 instanceof y) {
            return ((y) K0).Q0();
        }
        if (K0 instanceof m0) {
            return (m0) K0;
        }
        throw new NoWhenBranchMatchedException();
    }
}
