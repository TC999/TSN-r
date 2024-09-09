package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: inlineClassManglingRules.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {
    private static final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        return f0.g(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(dVar), j.f56080i);
    }

    public static final boolean b(@NotNull k kVar) {
        f0.p(kVar, "<this>");
        return kotlin.reflect.jvm.internal.impl.resolve.e.b(kVar) && !a((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar);
    }

    public static final boolean c(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        f b4 = e0Var.H0().b();
        return b4 != null && b(b4);
    }

    private static final boolean d(e0 e0Var) {
        f b4 = e0Var.H0().b();
        a1 a1Var = b4 instanceof a1 ? (a1) b4 : null;
        if (a1Var == null) {
            return false;
        }
        return e(kotlin.reflect.jvm.internal.impl.types.typeUtil.a.i(a1Var));
    }

    private static final boolean e(e0 e0Var) {
        return c(e0Var) || d(e0Var);
    }

    public static final boolean f(@NotNull CallableMemberDescriptor descriptor) {
        f0.p(descriptor, "descriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.c cVar = descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.c ? (kotlin.reflect.jvm.internal.impl.descriptors.c) descriptor : null;
        if (cVar == null || r.g(cVar.getVisibility())) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d c02 = cVar.c0();
        f0.o(c02, "constructorDescriptor.constructedClass");
        if (kotlin.reflect.jvm.internal.impl.resolve.e.b(c02) || kotlin.reflect.jvm.internal.impl.resolve.d.G(cVar.c0())) {
            return false;
        }
        List<d1> h4 = cVar.h();
        f0.o(h4, "constructorDescriptor.valueParameters");
        if ((h4 instanceof Collection) && h4.isEmpty()) {
            return false;
        }
        for (d1 d1Var : h4) {
            e0 type = d1Var.getType();
            f0.o(type, "it.type");
            if (e(type)) {
                return true;
            }
        }
        return false;
    }
}
