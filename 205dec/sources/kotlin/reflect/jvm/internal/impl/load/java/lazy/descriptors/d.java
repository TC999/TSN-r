package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.j1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.p;
import kotlin.reflect.n;
import m2.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JvmPackageScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d implements kotlin.reflect.jvm.internal.impl.resolve.scopes.h {

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f56784f = {n0.u(new PropertyReference1Impl(n0.d(d.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.h f56785b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final h f56786c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final i f56787d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56788e;

    /* compiled from: JvmPackageScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.resolve.scopes.h[]> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] invoke() {
            Collection<p> values = d.this.f56786c.H0().values();
            d dVar = d.this;
            ArrayList arrayList = new ArrayList();
            for (p pVar : values) {
                kotlin.reflect.jvm.internal.impl.resolve.scopes.h c4 = dVar.f56785b.a().b().c(dVar.f56786c, pVar);
                if (c4 != null) {
                    arrayList.add(c4);
                }
            }
            Object[] array = t2.a.b(arrayList).toArray(new kotlin.reflect.jvm.internal.impl.resolve.scopes.h[0]);
            if (array != null) {
                return (kotlin.reflect.jvm.internal.impl.resolve.scopes.h[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    public d(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4, @NotNull u jPackage, @NotNull h packageFragment) {
        f0.p(c4, "c");
        f0.p(jPackage, "jPackage");
        f0.p(packageFragment, "packageFragment");
        this.f56785b = c4;
        this.f56786c = packageFragment;
        this.f56787d = new i(c4, jPackage, packageFragment);
        this.f56788e = c4.e().g(new a());
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] l() {
        return (kotlin.reflect.jvm.internal.impl.resolve.scopes.h[]) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f56788e, this, f56784f[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        Set k4;
        f0.p(name, "name");
        f0.p(location, "location");
        e(name, location);
        i iVar = this.f56787d;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] l4 = l();
        Collection<? extends u0> a4 = iVar.a(name, location);
        int length = l4.length;
        int i4 = 0;
        Collection collection = a4;
        while (i4 < length) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = l4[i4];
            i4++;
            collection = t2.a.a(collection, hVar.a(name, location));
        }
        if (collection == null) {
            k4 = j1.k();
            return k4;
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] l4 = l();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = l4.length;
        int i4 = 0;
        while (i4 < length) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = l4[i4];
            i4++;
            c0.o0(linkedHashSet, hVar.b());
        }
        linkedHashSet.addAll(k().b());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Collection<p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        Set k4;
        f0.p(name, "name");
        f0.p(location, "location");
        e(name, location);
        i iVar = this.f56787d;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] l4 = l();
        Collection<? extends p0> c4 = iVar.c(name, location);
        int length = l4.length;
        int i4 = 0;
        Collection collection = c4;
        while (i4 < length) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = l4[i4];
            i4++;
            collection = t2.a.a(collection, hVar.c(name, location));
        }
        if (collection == null) {
            k4 = j1.k();
            return k4;
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] l4 = l();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = l4.length;
        int i4 = 0;
        while (i4 < length) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = l4[i4];
            i4++;
            c0.o0(linkedHashSet, hVar.d());
        }
        linkedHashSet.addAll(k().d());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        j2.a.b(this.f56785b.a().l(), location, this.f56786c, name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        Set k4;
        f0.p(kindFilter, "kindFilter");
        f0.p(nameFilter, "nameFilter");
        i iVar = this.f56787d;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] l4 = l();
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f4 = iVar.f(kindFilter, nameFilter);
        int length = l4.length;
        int i4 = 0;
        while (i4 < length) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = l4[i4];
            i4++;
            f4 = t2.a.a(f4, hVar.f(kindFilter, nameFilter));
        }
        if (f4 == null) {
            k4 = j1.k();
            return k4;
        }
        return f4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @Nullable
    public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
        Iterable Y4;
        Y4 = kotlin.collections.p.Y4(l());
        Set<kotlin.reflect.jvm.internal.impl.name.f> a4 = kotlin.reflect.jvm.internal.impl.resolve.scopes.j.a(Y4);
        if (a4 == null) {
            return null;
        }
        a4.addAll(k().g());
        return a4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f h(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        e(name, location);
        kotlin.reflect.jvm.internal.impl.descriptors.d h4 = this.f56787d.h(name, location);
        if (h4 != null) {
            return h4;
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] l4 = l();
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = null;
        int i4 = 0;
        int length = l4.length;
        while (i4 < length) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = l4[i4];
            i4++;
            kotlin.reflect.jvm.internal.impl.descriptors.f h5 = hVar.h(name, location);
            if (h5 != null) {
                if (!(h5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) || !((kotlin.reflect.jvm.internal.impl.descriptors.g) h5).i0()) {
                    return h5;
                }
                if (fVar == null) {
                    fVar = h5;
                }
            }
        }
        return fVar;
    }

    @NotNull
    public final i k() {
        return this.f56787d;
    }

    @NotNull
    public String toString() {
        return f0.C("scope for ", this.f56786c);
    }
}
