package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.p;
import kotlin.r;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.d1;
import kotlin.reflect.jvm.internal.impl.types.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SubstitutingScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m implements h {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final h f57936b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final f1 f57937c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Map<kotlin.reflect.jvm.internal.impl.descriptors.k, kotlin.reflect.jvm.internal.impl.descriptors.k> f57938d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final p f57939e;

    /* compiled from: SubstitutingScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.k>> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> invoke() {
            m mVar = m.this;
            return mVar.l(k.a.a(mVar.f57936b, null, null, 3, null));
        }
    }

    public m(@NotNull h workerScope, @NotNull f1 givenSubstitutor) {
        p a4;
        f0.p(workerScope, "workerScope");
        f0.p(givenSubstitutor, "givenSubstitutor");
        this.f57936b = workerScope;
        d1 j4 = givenSubstitutor.j();
        f0.o(j4, "givenSubstitutor.substitution");
        this.f57937c = kotlin.reflect.jvm.internal.impl.resolve.calls.inference.d.f(j4, false, 1, null).c();
        a4 = r.a(new a());
        this.f57939e = a4;
    }

    private final Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> k() {
        return (Collection) this.f57939e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends kotlin.reflect.jvm.internal.impl.descriptors.k> Collection<D> l(Collection<? extends D> collection) {
        if (this.f57937c.k() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet g4 = kotlin.reflect.jvm.internal.impl.utils.a.g(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            g4.add(m((kotlin.reflect.jvm.internal.impl.descriptors.k) it.next()));
        }
        return g4;
    }

    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.k> D m(D d4) {
        if (this.f57937c.k()) {
            return d4;
        }
        if (this.f57938d == null) {
            this.f57938d = new HashMap();
        }
        Map<kotlin.reflect.jvm.internal.impl.descriptors.k, kotlin.reflect.jvm.internal.impl.descriptors.k> map = this.f57938d;
        f0.m(map);
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar = map.get(d4);
        if (kVar == null) {
            if (!(d4 instanceof x0)) {
                throw new IllegalStateException(f0.C("Unknown descriptor in scope: ", d4).toString());
            }
            kVar = ((x0) d4).c(this.f57937c);
            if (kVar != null) {
                map.put(d4, kVar);
            } else {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d4 + " substitution fails");
            }
        }
        return (D) kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<? extends u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        return l(this.f57936b.a(name, location));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        return this.f57936b.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Collection<? extends p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        return l(this.f57936b.c(name, location));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        return this.f57936b.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar) {
        h.b.a(this, fVar, bVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        f0.p(kindFilter, "kindFilter");
        f0.p(nameFilter, "nameFilter");
        return k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @Nullable
    public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
        return this.f57936b.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f h(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        kotlin.reflect.jvm.internal.impl.descriptors.f h4 = this.f57936b.h(name, location);
        if (h4 == null) {
            return null;
        }
        return (kotlin.reflect.jvm.internal.impl.descriptors.f) m(h4);
    }
}
