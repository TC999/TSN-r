package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.y0;
import kotlin.reflect.jvm.internal.impl.types.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: utils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y {
    private static final e0 a(e0 e0Var) {
        return kotlin.reflect.jvm.internal.impl.types.typesApproximation.b.a(e0Var).d();
    }

    private static final String b(y0 y0Var) {
        StringBuilder sb = new StringBuilder();
        c(f0.C("type: ", y0Var), sb);
        c(f0.C("hashCode: ", Integer.valueOf(y0Var.hashCode())), sb);
        c(f0.C("javaClass: ", y0Var.getClass().getCanonicalName()), sb);
        for (kotlin.reflect.jvm.internal.impl.descriptors.k b4 = y0Var.b(); b4 != null; b4 = b4.b()) {
            c(f0.C("fqName: ", kotlin.reflect.jvm.internal.impl.renderer.b.f57729g.s(b4)), sb);
            c(f0.C("javaClass: ", b4.getClass().getCanonicalName()), sb);
        }
        String sb2 = sb.toString();
        f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final StringBuilder c(String str, StringBuilder sb) {
        f0.p(str, "<this>");
        sb.append(str);
        f0.o(sb, "append(value)");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @Nullable
    public static final e0 d(@NotNull e0 subtype, @NotNull e0 supertype, @NotNull v typeCheckingProcedureCallbacks) {
        boolean z3;
        boolean z4;
        f0.p(subtype, "subtype");
        f0.p(supertype, "supertype");
        f0.p(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new s(subtype, null));
        y0 H0 = supertype.H0();
        while (!arrayDeque.isEmpty()) {
            s sVar = (s) arrayDeque.poll();
            e0 type = sVar.getType();
            y0 H02 = type.H0();
            if (typeCheckingProcedureCallbacks.a(H02, H0)) {
                boolean I0 = type.I0();
                for (s a4 = sVar.a(); a4 != null; a4 = a4.a()) {
                    e0 type2 = a4.getType();
                    List<a1> G0 = type2.G0();
                    if (!(G0 instanceof Collection) || !G0.isEmpty()) {
                        for (a1 a1Var : G0) {
                            if (a1Var.c() != Variance.INVARIANT) {
                                z3 = true;
                                continue;
                            } else {
                                z3 = false;
                                continue;
                            }
                            if (z3) {
                                z4 = true;
                                break;
                            }
                        }
                    }
                    z4 = false;
                    if (z4) {
                        e0 n4 = kotlin.reflect.jvm.internal.impl.resolve.calls.inference.d.f(z0.f58460c.a(type2), false, 1, null).c().n(type, Variance.INVARIANT);
                        f0.o(n4, "TypeConstructorSubstitut\u2026uted, Variance.INVARIANT)");
                        type = a(n4);
                    } else {
                        type = z0.f58460c.a(type2).c().n(type, Variance.INVARIANT);
                        f0.o(type, "{\n                    Ty\u2026ARIANT)\n                }");
                    }
                    I0 = I0 || type2.I0();
                }
                y0 H03 = type.H0();
                if (typeCheckingProcedureCallbacks.a(H03, H0)) {
                    return h1.q(type, I0);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(H03) + ", \n\nsupertype: " + b(H0) + " \n" + typeCheckingProcedureCallbacks.a(H03, H0));
            }
            for (e0 immediateSupertype : H02.j()) {
                f0.o(immediateSupertype, "immediateSupertype");
                arrayDeque.add(new s(immediateSupertype, sVar));
            }
        }
        return null;
    }
}
