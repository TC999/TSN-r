package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.c;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.g1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: typeSignatureMapping.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a0 {
    @NotNull
    public static final <T> T a(@NotNull l<T> lVar, @NotNull T possiblyPrimitiveType, boolean z3) {
        f0.p(lVar, "<this>");
        f0.p(possiblyPrimitiveType, "possiblyPrimitiveType");
        return z3 ? lVar.b(possiblyPrimitiveType) : possiblyPrimitiveType;
    }

    @Nullable
    public static final <T> T b(@NotNull g1 g1Var, @NotNull r2.g type, @NotNull l<T> typeFactory, @NotNull z mode) {
        f0.p(g1Var, "<this>");
        f0.p(type, "type");
        f0.p(typeFactory, "typeFactory");
        f0.p(mode, "mode");
        r2.m V = g1Var.V(type);
        if (g1Var.w0(V)) {
            PrimitiveType U = g1Var.U(V);
            boolean z3 = true;
            if (U != null) {
                T c4 = typeFactory.c(U);
                if (!g1Var.l0(type) && !kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.p.b(g1Var, type)) {
                    z3 = false;
                }
                return (T) a(typeFactory, c4, z3);
            }
            PrimitiveType D = g1Var.D(V);
            if (D != null) {
                return typeFactory.a(f0.C("[", JvmPrimitiveType.get(D).getDesc()));
            }
            if (g1Var.Z(V)) {
                kotlin.reflect.jvm.internal.impl.name.d x3 = g1Var.x(V);
                kotlin.reflect.jvm.internal.impl.name.b o4 = x3 == null ? null : kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f56159a.o(x3);
                if (o4 != null) {
                    if (!mode.a()) {
                        List<c.a> j4 = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f56159a.j();
                        if (!(j4 instanceof Collection) || !j4.isEmpty()) {
                            for (c.a aVar : j4) {
                                if (f0.g(aVar.d(), o4)) {
                                    break;
                                }
                            }
                        }
                        z3 = false;
                        if (z3) {
                            return null;
                        }
                    }
                    String f4 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.b(o4).f();
                    f0.o(f4, "byClassId(classId).internalName");
                    return typeFactory.e(f4);
                }
            }
            return null;
        }
        return null;
    }
}
