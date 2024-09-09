package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Set;
import kotlin.collections.k1;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.load.java.y;
import kotlin.reflect.jvm.internal.impl.types.g1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: typeEnhancementUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p {
    @NotNull
    public static final d a(@Nullable NullabilityQualifier nullabilityQualifier, @Nullable MutabilityQualifier mutabilityQualifier, boolean z3, boolean z4) {
        if (z4 && nullabilityQualifier == NullabilityQualifier.NOT_NULL) {
            return new d(nullabilityQualifier, mutabilityQualifier, true, z3);
        }
        return new d(nullabilityQualifier, mutabilityQualifier, false, z3);
    }

    public static final boolean b(@NotNull g1 g1Var, @NotNull r2.g type) {
        f0.p(g1Var, "<this>");
        f0.p(type, "type");
        kotlin.reflect.jvm.internal.impl.name.c ENHANCED_NULLABILITY_ANNOTATION = y.f57123s;
        f0.o(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return g1Var.v0(type, ENHANCED_NULLABILITY_ANNOTATION);
    }

    @Nullable
    public static final <T> T c(@NotNull Set<? extends T> set, @NotNull T low, @NotNull T high, @Nullable T t3, boolean z3) {
        Set D;
        Object T4;
        f0.p(set, "<this>");
        f0.p(low, "low");
        f0.p(high, "high");
        if (z3) {
            T t4 = set.contains(low) ? low : set.contains(high) ? high : null;
            if (f0.g(t4, low) && f0.g(t3, high)) {
                return null;
            }
            return t3 == null ? t4 : t3;
        }
        if (t3 != null) {
            D = k1.D(set, t3);
            set = kotlin.collections.f0.L5(D);
        }
        T4 = kotlin.collections.f0.T4(set);
        return (T) T4;
    }

    @Nullable
    public static final NullabilityQualifier d(@NotNull Set<? extends NullabilityQualifier> set, @Nullable NullabilityQualifier nullabilityQualifier, boolean z3) {
        f0.p(set, "<this>");
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) c(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z3);
    }
}
