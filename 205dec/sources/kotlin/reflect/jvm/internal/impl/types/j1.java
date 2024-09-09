package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeWithEnhancement.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j1 {
    @Nullable
    public static final e0 a(@NotNull e0 e0Var) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        if (e0Var instanceof i1) {
            return ((i1) e0Var).f0();
        }
        return null;
    }

    @NotNull
    public static final l1 b(@NotNull l1 l1Var, @NotNull e0 origin) {
        kotlin.jvm.internal.f0.p(l1Var, "<this>");
        kotlin.jvm.internal.f0.p(origin, "origin");
        return e(l1Var, a(origin));
    }

    @NotNull
    public static final l1 c(@NotNull l1 l1Var, @NotNull e0 origin, @NotNull d2.l<? super e0, ? extends e0> transform) {
        kotlin.jvm.internal.f0.p(l1Var, "<this>");
        kotlin.jvm.internal.f0.p(origin, "origin");
        kotlin.jvm.internal.f0.p(transform, "transform");
        e0 a4 = a(origin);
        return e(l1Var, a4 == null ? null : transform.invoke(a4));
    }

    @NotNull
    public static final e0 d(@NotNull e0 e0Var) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        e0 a4 = a(e0Var);
        return a4 == null ? e0Var : a4;
    }

    @NotNull
    public static final l1 e(@NotNull l1 l1Var, @Nullable e0 e0Var) {
        kotlin.jvm.internal.f0.p(l1Var, "<this>");
        if (l1Var instanceof i1) {
            return e(((i1) l1Var).C0(), e0Var);
        }
        if (e0Var == null || kotlin.jvm.internal.f0.g(e0Var, l1Var)) {
            return l1Var;
        }
        if (l1Var instanceof m0) {
            return new o0((m0) l1Var, e0Var);
        }
        if (l1Var instanceof y) {
            return new a0((y) l1Var, e0Var);
        }
        throw new NoWhenBranchMatchedException();
    }
}
