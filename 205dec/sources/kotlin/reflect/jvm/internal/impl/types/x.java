package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: expandedTypeUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x {
    @Nullable
    public static final r2.g a(@NotNull g1 g1Var, @NotNull r2.g inlineClassType) {
        kotlin.jvm.internal.f0.p(g1Var, "<this>");
        kotlin.jvm.internal.f0.p(inlineClassType, "inlineClassType");
        return b(g1Var, inlineClassType, new HashSet());
    }

    private static final r2.g b(g1 g1Var, r2.g gVar, HashSet<r2.m> hashSet) {
        r2.g b4;
        r2.m V = g1Var.V(gVar);
        if (hashSet.add(V)) {
            r2.n g02 = g1Var.g0(V);
            if (g02 != null) {
                b4 = b(g1Var, g1Var.n(g02), hashSet);
                if (b4 == null) {
                    return null;
                }
                if (!g1Var.l0(b4) && g1Var.T(gVar)) {
                    return g1Var.v(b4);
                }
            } else if (!g1Var.p(V)) {
                return gVar;
            } else {
                r2.g y3 = g1Var.y(gVar);
                if (y3 == null || (b4 = b(g1Var, y3, hashSet)) == null) {
                    return null;
                }
                if (g1Var.l0(gVar)) {
                    return g1Var.l0(b4) ? gVar : ((b4 instanceof r2.i) && g1Var.a0((r2.i) b4)) ? gVar : g1Var.v(b4);
                }
            }
            return b4;
        }
        return null;
    }
}
