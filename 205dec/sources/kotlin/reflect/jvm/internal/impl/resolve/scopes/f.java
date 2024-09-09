package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InnerClassesScopeWrapper.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f extends i {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final h f57924b;

    public f(@NotNull h workerScope) {
        f0.p(workerScope, "workerScope");
        this.f57924b = workerScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        return this.f57924b.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        return this.f57924b.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        this.f57924b.e(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @Nullable
    public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
        return this.f57924b.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f h(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        kotlin.reflect.jvm.internal.impl.descriptors.f h4 = this.f57924b.h(name, location);
        if (h4 == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = h4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) h4 : null;
        if (dVar == null) {
            if (h4 instanceof z0) {
                return (z0) h4;
            }
            return null;
        }
        return dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    /* renamed from: i */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.f> f(@NotNull d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.f> F;
        f0.p(kindFilter, "kindFilter");
        f0.p(nameFilter, "nameFilter");
        d n4 = kindFilter.n(d.f57890c.c());
        if (n4 == null) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f4 = this.f57924b.f(n4, nameFilter);
        ArrayList arrayList = new ArrayList();
        for (Object obj : f4) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public String toString() {
        return f0.C("Classes from ", this.f57924b);
    }
}
