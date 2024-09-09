package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.j1;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SubpackagesScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class h0 extends kotlin.reflect.jvm.internal.impl.resolve.scopes.i {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d0 f56382b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.c f56383c;

    public h0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d0 moduleDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.f0.p(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        this.f56382b = moduleDescriptor;
        this.f56383c = fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        List F;
        List F2;
        kotlin.jvm.internal.f0.p(kindFilter, "kindFilter");
        kotlin.jvm.internal.f0.p(nameFilter, "nameFilter");
        if (!kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57890c.f())) {
            F2 = CollectionsKt__CollectionsKt.F();
            return F2;
        } else if (this.f56383c.d() && kindFilter.l().contains(c.b.f57889a)) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        } else {
            Collection<kotlin.reflect.jvm.internal.impl.name.c> u3 = this.f56382b.u(this.f56383c, nameFilter);
            ArrayList arrayList = new ArrayList(u3.size());
            for (kotlin.reflect.jvm.internal.impl.name.c cVar : u3) {
                kotlin.reflect.jvm.internal.impl.name.f g4 = cVar.g();
                kotlin.jvm.internal.f0.o(g4, "subFqName.shortName()");
                if (nameFilter.invoke(g4).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, i(g4));
                }
            }
            return arrayList;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
        Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
        k4 = j1.k();
        return k4;
    }

    @Nullable
    protected final kotlin.reflect.jvm.internal.impl.descriptors.l0 i(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.f0.p(name, "name");
        if (name.g()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var = this.f56382b;
        kotlin.reflect.jvm.internal.impl.name.c c4 = this.f56383c.c(name);
        kotlin.jvm.internal.f0.o(c4, "fqName.child(name)");
        kotlin.reflect.jvm.internal.impl.descriptors.l0 j02 = d0Var.j0(c4);
        if (j02.isEmpty()) {
            return null;
        }
        return j02;
    }

    @NotNull
    public String toString() {
        return "subpackages of " + this.f56383c + " from " + this.f56382b;
    }
}
