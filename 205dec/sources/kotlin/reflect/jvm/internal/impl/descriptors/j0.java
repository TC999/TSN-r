package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: PackageFragmentProvider.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j0 {
    public static final void a(@NotNull h0 h0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Collection<g0> packageFragments) {
        kotlin.jvm.internal.f0.p(h0Var, "<this>");
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        kotlin.jvm.internal.f0.p(packageFragments, "packageFragments");
        if (h0Var instanceof k0) {
            ((k0) h0Var).b(fqName, packageFragments);
        } else {
            packageFragments.addAll(h0Var.a(fqName));
        }
    }

    public static final boolean b(@NotNull h0 h0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.f0.p(h0Var, "<this>");
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        return h0Var instanceof k0 ? ((k0) h0Var).c(fqName) : c(h0Var, fqName).isEmpty();
    }

    @NotNull
    public static final List<g0> c(@NotNull h0 h0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.f0.p(h0Var, "<this>");
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        a(h0Var, fqName, arrayList);
        return arrayList;
    }
}
