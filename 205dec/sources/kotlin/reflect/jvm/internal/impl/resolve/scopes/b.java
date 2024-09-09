package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.c0;
import kotlin.collections.j1;
import kotlin.collections.p;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChainedMemberScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b implements h {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final a f57884d = new a(null);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f57885b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final h[] f57886c;

    /* compiled from: ChainedMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @NotNull
        public final h a(@NotNull String debugName, @NotNull Iterable<? extends h> scopes) {
            f0.p(debugName, "debugName");
            f0.p(scopes, "scopes");
            kotlin.reflect.jvm.internal.impl.utils.e eVar = new kotlin.reflect.jvm.internal.impl.utils.e();
            for (h hVar : scopes) {
                if (hVar != h.c.f57931b) {
                    if (hVar instanceof b) {
                        c0.q0(eVar, ((b) hVar).f57886c);
                    } else {
                        eVar.add(hVar);
                    }
                }
            }
            return b(debugName, eVar);
        }

        @NotNull
        public final h b(@NotNull String debugName, @NotNull List<? extends h> scopes) {
            f0.p(debugName, "debugName");
            f0.p(scopes, "scopes");
            int size = scopes.size();
            if (size != 0) {
                if (size != 1) {
                    Object[] array = scopes.toArray(new h[0]);
                    if (array != null) {
                        return new b(debugName, (h[]) array, null);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                return scopes.get(0);
            }
            return h.c.f57931b;
        }
    }

    private b(String str, h[] hVarArr) {
        this.f57885b = str;
        this.f57886c = hVarArr;
    }

    public /* synthetic */ b(String str, h[] hVarArr, u uVar) {
        this(str, hVarArr);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        List F;
        Set k4;
        f0.p(name, "name");
        f0.p(location, "location");
        h[] hVarArr = this.f57886c;
        int length = hVarArr.length;
        if (length == 0) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        int i4 = 0;
        if (length != 1) {
            Collection<u0> collection = null;
            int length2 = hVarArr.length;
            while (i4 < length2) {
                h hVar = hVarArr[i4];
                i4++;
                collection = t2.a.a(collection, hVar.a(name, location));
            }
            if (collection == null) {
                k4 = j1.k();
                return k4;
            }
            return collection;
        }
        return hVarArr[0].a(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        h[] hVarArr = this.f57886c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = hVarArr.length;
        int i4 = 0;
        while (i4 < length) {
            h hVar = hVarArr[i4];
            i4++;
            c0.o0(linkedHashSet, hVar.b());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Collection<p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        List F;
        Set k4;
        f0.p(name, "name");
        f0.p(location, "location");
        h[] hVarArr = this.f57886c;
        int length = hVarArr.length;
        if (length == 0) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        int i4 = 0;
        if (length != 1) {
            Collection<p0> collection = null;
            int length2 = hVarArr.length;
            while (i4 < length2) {
                h hVar = hVarArr[i4];
                i4++;
                collection = t2.a.a(collection, hVar.c(name, location));
            }
            if (collection == null) {
                k4 = j1.k();
                return k4;
            }
            return collection;
        }
        return hVarArr[0].c(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        h[] hVarArr = this.f57886c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = hVarArr.length;
        int i4 = 0;
        while (i4 < length) {
            h hVar = hVarArr[i4];
            i4++;
            c0.o0(linkedHashSet, hVar.d());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        h[] hVarArr = this.f57886c;
        int length = hVarArr.length;
        int i4 = 0;
        while (i4 < length) {
            h hVar = hVarArr[i4];
            i4++;
            hVar.e(name, location);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        List F;
        Set k4;
        f0.p(kindFilter, "kindFilter");
        f0.p(nameFilter, "nameFilter");
        h[] hVarArr = this.f57886c;
        int length = hVarArr.length;
        if (length == 0) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        int i4 = 0;
        if (length != 1) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> collection = null;
            int length2 = hVarArr.length;
            while (i4 < length2) {
                h hVar = hVarArr[i4];
                i4++;
                collection = t2.a.a(collection, hVar.f(kindFilter, nameFilter));
            }
            if (collection == null) {
                k4 = j1.k();
                return k4;
            }
            return collection;
        }
        return hVarArr[0].f(kindFilter, nameFilter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @Nullable
    public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
        Iterable Y4;
        Y4 = p.Y4(this.f57886c);
        return j.a(Y4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f h(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        h[] hVarArr = this.f57886c;
        int length = hVarArr.length;
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = null;
        int i4 = 0;
        while (i4 < length) {
            h hVar = hVarArr[i4];
            i4++;
            kotlin.reflect.jvm.internal.impl.descriptors.f h4 = hVar.h(name, location);
            if (h4 != null) {
                if (!(h4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) || !((kotlin.reflect.jvm.internal.impl.descriptors.g) h4).i0()) {
                    return h4;
                }
                if (fVar == null) {
                    fVar = h4;
                }
            }
        }
        return fVar;
    }

    @NotNull
    public String toString() {
        return this.f57885b;
    }
}
