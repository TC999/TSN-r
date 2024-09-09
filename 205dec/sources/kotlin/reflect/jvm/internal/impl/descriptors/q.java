package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: descriptorUtil.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q {
    @Nullable
    public static final f a(@NotNull k kVar) {
        kotlin.jvm.internal.f0.p(kVar, "<this>");
        k b4 = kVar.b();
        if (b4 == null || (kVar instanceof g0)) {
            return null;
        }
        if (!b(b4)) {
            return a(b4);
        }
        if (b4 instanceof f) {
            return (f) b4;
        }
        return null;
    }

    public static final boolean b(@NotNull k kVar) {
        kotlin.jvm.internal.f0.p(kVar, "<this>");
        return kVar.b() instanceof g0;
    }

    @Nullable
    public static final d c(@NotNull d0 d0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull k2.b lookupLocation) {
        f h4;
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        kotlin.jvm.internal.f0.p(lookupLocation, "lookupLocation");
        if (fqName.d()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.c e4 = fqName.e();
        kotlin.jvm.internal.f0.o(e4, "fqName.parent()");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h p3 = d0Var.j0(e4).p();
        kotlin.reflect.jvm.internal.impl.name.f g4 = fqName.g();
        kotlin.jvm.internal.f0.o(g4, "fqName.shortName()");
        f h5 = p3.h(g4, lookupLocation);
        d dVar = h5 instanceof d ? (d) h5 : null;
        if (dVar == null) {
            kotlin.reflect.jvm.internal.impl.name.c e5 = fqName.e();
            kotlin.jvm.internal.f0.o(e5, "fqName.parent()");
            d c4 = c(d0Var, e5, lookupLocation);
            if (c4 == null) {
                h4 = null;
            } else {
                kotlin.reflect.jvm.internal.impl.resolve.scopes.h U = c4.U();
                kotlin.reflect.jvm.internal.impl.name.f g5 = fqName.g();
                kotlin.jvm.internal.f0.o(g5, "fqName.shortName()");
                h4 = U.h(g5, lookupLocation);
            }
            if (h4 instanceof d) {
                return (d) h4;
            }
            return null;
        }
        return dVar;
    }
}
