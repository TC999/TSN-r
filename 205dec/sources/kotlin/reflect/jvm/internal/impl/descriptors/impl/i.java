package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* compiled from: CompositePackageFragmentProvider.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i implements kotlin.reflect.jvm.internal.impl.descriptors.k0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<kotlin.reflect.jvm.internal.impl.descriptors.h0> f56384a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f56385b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull List<? extends kotlin.reflect.jvm.internal.impl.descriptors.h0> providers, @NotNull String debugName) {
        Set L5;
        kotlin.jvm.internal.f0.p(providers, "providers");
        kotlin.jvm.internal.f0.p(debugName, "debugName");
        this.f56384a = providers;
        this.f56385b = debugName;
        providers.size();
        L5 = kotlin.collections.f0.L5(providers);
        L5.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.g0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.g0> G5;
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.h0 h0Var : this.f56384a) {
            kotlin.reflect.jvm.internal.impl.descriptors.j0.a(h0Var, fqName, arrayList);
        }
        G5 = kotlin.collections.f0.G5(arrayList);
        return G5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k0
    public void b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.g0> packageFragments) {
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        kotlin.jvm.internal.f0.p(packageFragments, "packageFragments");
        for (kotlin.reflect.jvm.internal.impl.descriptors.h0 h0Var : this.f56384a) {
            kotlin.reflect.jvm.internal.impl.descriptors.j0.a(h0Var, fqName, packageFragments);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k0
    public boolean c(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        List<kotlin.reflect.jvm.internal.impl.descriptors.h0> list = this.f56384a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.h0 h0Var : list) {
            if (!kotlin.reflect.jvm.internal.impl.descriptors.j0.b(h0Var, fqName)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public String toString() {
        return this.f56385b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.name.c> u(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        kotlin.jvm.internal.f0.p(nameFilter, "nameFilter");
        HashSet hashSet = new HashSet();
        for (kotlin.reflect.jvm.internal.impl.descriptors.h0 h0Var : this.f56384a) {
            hashSet.addAll(h0Var.u(fqName, nameFilter));
        }
        return hashSet;
    }
}
