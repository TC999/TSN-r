package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.load.java.d0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.k;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: methodSignatureMapping.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u {
    private static final void a(StringBuilder sb, e0 e0Var) {
        sb.append(g(e0Var));
    }

    @NotNull
    public static final String b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.w wVar, boolean z3, boolean z4) {
        String b4;
        f0.p(wVar, "<this>");
        StringBuilder sb = new StringBuilder();
        if (z4) {
            if (wVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) {
                b4 = "<init>";
            } else {
                b4 = wVar.getName().b();
                f0.o(b4, "name.asString()");
            }
            sb.append(b4);
        }
        sb.append("(");
        s0 Q = wVar.Q();
        if (Q != null) {
            e0 type = Q.getType();
            f0.o(type, "it.type");
            a(sb, type);
        }
        for (d1 d1Var : wVar.h()) {
            e0 type2 = d1Var.getType();
            f0.o(type2, "parameter.type");
            a(sb, type2);
        }
        sb.append(")");
        if (z3) {
            if (c.c(wVar)) {
                sb.append("V");
            } else {
                e0 returnType = wVar.getReturnType();
                f0.m(returnType);
                f0.o(returnType, "returnType!!");
                a(sb, returnType);
            }
        }
        String sb2 = sb.toString();
        f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String c(kotlin.reflect.jvm.internal.impl.descriptors.w wVar, boolean z3, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = true;
        }
        if ((i4 & 2) != 0) {
            z4 = true;
        }
        return b(wVar, z3, z4);
    }

    @Nullable
    public static final String d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        f0.p(aVar, "<this>");
        w wVar = w.f57261a;
        if (kotlin.reflect.jvm.internal.impl.resolve.d.E(aVar)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k b4 = aVar.b();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b4 : null;
        if (dVar == null || dVar.getName().g()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.a a4 = aVar.a();
        u0 u0Var = a4 instanceof u0 ? (u0) a4 : null;
        if (u0Var == null) {
            return null;
        }
        return t.a(wVar, dVar, c(u0Var, false, false, 3, null));
    }

    public static final boolean e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a f4) {
        Object S4;
        kotlin.reflect.jvm.internal.impl.descriptors.w k4;
        Object S42;
        f0.p(f4, "f");
        if (f4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.w) {
            kotlin.reflect.jvm.internal.impl.descriptors.w wVar = (kotlin.reflect.jvm.internal.impl.descriptors.w) f4;
            if (f0.g(wVar.getName().b(), "remove") && wVar.h().size() == 1 && !d0.h((CallableMemberDescriptor) f4)) {
                List<d1> h4 = wVar.a().h();
                f0.o(h4, "f.original.valueParameters");
                S4 = kotlin.collections.f0.S4(h4);
                e0 type = ((d1) S4).getType();
                f0.o(type, "f.original.valueParameters.single().type");
                k g4 = g(type);
                k.d dVar = g4 instanceof k.d ? (k.d) g4 : null;
                if ((dVar != null ? dVar.i() : null) == JvmPrimitiveType.INT && (k4 = kotlin.reflect.jvm.internal.impl.load.java.e.k(wVar)) != null) {
                    List<d1> h5 = k4.a().h();
                    f0.o(h5, "overridden.original.valueParameters");
                    S42 = kotlin.collections.f0.S4(h5);
                    e0 type2 = ((d1) S42).getType();
                    f0.o(type2, "overridden.original.valueParameters.single().type");
                    k g5 = g(type2);
                    kotlin.reflect.jvm.internal.impl.descriptors.k b4 = k4.b();
                    f0.o(b4, "overridden.containingDeclaration");
                    return f0.g(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(b4), j.a.X.j()) && (g5 instanceof k.c) && f0.g(((k.c) g5).i(), "java/lang/Object");
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @NotNull
    public static final String f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        f0.p(dVar, "<this>");
        kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f56159a;
        kotlin.reflect.jvm.internal.impl.name.d j4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(dVar).j();
        f0.o(j4, "fqNameSafe.toUnsafe()");
        kotlin.reflect.jvm.internal.impl.name.b o4 = cVar.o(j4);
        if (o4 == null) {
            return c.b(dVar, null, 2, null);
        }
        String f4 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.b(o4).f();
        f0.o(f4, "byClassId(it).internalName");
        return f4;
    }

    @NotNull
    public static final k g(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        return (k) c.e(e0Var, m.f57248a, z.f57268o, y.f57263a, null, null, 32, null);
    }
}
