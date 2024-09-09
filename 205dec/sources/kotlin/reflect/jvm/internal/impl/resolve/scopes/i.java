package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MemberScopeImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class i implements h {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<? extends u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        List F;
        f0.p(name, "name");
        f0.p(location, "location");
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f4 = f(d.f57909v, kotlin.reflect.jvm.internal.impl.utils.d.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : f4) {
            if (obj instanceof u0) {
                kotlin.reflect.jvm.internal.impl.name.f name = ((u0) obj).getName();
                f0.o(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Collection<? extends p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        List F;
        f0.p(name, "name");
        f0.p(location, "location");
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f4 = f(d.f57910w, kotlin.reflect.jvm.internal.impl.utils.d.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : f4) {
            if (obj instanceof u0) {
                kotlin.reflect.jvm.internal.impl.name.f name = ((u0) obj).getName();
                f0.o(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar) {
        h.b.a(this, fVar, bVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        List F;
        f0.p(kindFilter, "kindFilter");
        f0.p(nameFilter, "nameFilter");
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @Nullable
    public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f h(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        return null;
    }
}
