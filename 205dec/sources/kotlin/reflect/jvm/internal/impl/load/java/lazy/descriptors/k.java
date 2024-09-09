package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.c0;
import kotlin.collections.j1;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.utils.b;
import kotlin.sequences.SequencesKt___SequencesKt;
import m2.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyJavaStaticClassScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k extends l {
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final m2.g f56902n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final f f56903o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaStaticClassScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.l<q, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56904a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull q it) {
            f0.p(it, "it");
            return Boolean.valueOf(it.O());
        }
    }

    /* compiled from: LazyJavaStaticClassScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.resolve.scopes.h, Collection<? extends p0>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.f f56905a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            super(1);
            this.f56905a = fVar;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Collection<? extends p0> invoke(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.h it) {
            f0.p(it, "it");
            return it.c(this.f56905a, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
        }
    }

    /* compiled from: LazyJavaStaticClassScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.resolve.scopes.h, Collection<? extends kotlin.reflect.jvm.internal.impl.name.f>> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f56906a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Collection<kotlin.reflect.jvm.internal.impl.name.f> invoke(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.h it) {
            f0.p(it, "it");
            return it.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaStaticClassScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<N> implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public static final d<N> f56907a = new d<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LazyJavaStaticClassScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends Lambda implements d2.l<e0, kotlin.reflect.jvm.internal.impl.descriptors.d> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f56908a = new a();

            a() {
                super(1);
            }

            @Override // d2.l
            @Nullable
            /* renamed from: a */
            public final kotlin.reflect.jvm.internal.impl.descriptors.d invoke(e0 e0Var) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
                if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                    return (kotlin.reflect.jvm.internal.impl.descriptors.d) b4;
                }
                return null;
            }
        }

        d() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        @NotNull
        /* renamed from: b */
        public final Iterable<kotlin.reflect.jvm.internal.impl.descriptors.d> a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
            kotlin.sequences.m l12;
            kotlin.sequences.m i12;
            Iterable<kotlin.reflect.jvm.internal.impl.descriptors.d> G;
            Collection<e0> j4 = dVar.j().j();
            f0.o(j4, "it.typeConstructor.supertypes");
            l12 = kotlin.collections.f0.l1(j4);
            i12 = SequencesKt___SequencesKt.i1(l12, a.f56908a);
            G = SequencesKt___SequencesKt.G(i12);
            return G;
        }
    }

    /* compiled from: LazyJavaStaticClassScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends b.AbstractC1189b<kotlin.reflect.jvm.internal.impl.descriptors.d, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d f56909a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Set<R> f56910b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d2.l<kotlin.reflect.jvm.internal.impl.resolve.scopes.h, Collection<R>> f56911c;

        /* JADX WARN: Multi-variable type inference failed */
        e(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, Set<R> set, d2.l<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.h, ? extends Collection<? extends R>> lVar) {
            this.f56909a = dVar;
            this.f56910b = set;
            this.f56911c = lVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        public /* bridge */ /* synthetic */ Object a() {
            e();
            return f1.f55527a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.AbstractC1189b, kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: d */
        public boolean c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d current) {
            f0.p(current, "current");
            if (current == this.f56909a) {
                return true;
            }
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h k02 = current.k0();
            f0.o(k02, "current.staticScope");
            if (k02 instanceof l) {
                this.f56910b.addAll((Collection) this.f56911c.invoke(k02));
                return false;
            }
            return true;
        }

        public void e() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4, @NotNull m2.g jClass, @NotNull f ownerDescriptor) {
        super(c4);
        f0.p(c4, "c");
        f0.p(jClass, "jClass");
        f0.p(ownerDescriptor, "ownerDescriptor");
        this.f56902n = jClass;
        this.f56903o = ownerDescriptor;
    }

    private final <R> Set<R> O(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, Set<R> set, d2.l<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.h, ? extends Collection<? extends R>> lVar) {
        List l4;
        l4 = x.l(dVar);
        kotlin.reflect.jvm.internal.impl.utils.b.b(l4, d.f56907a, new e(dVar, set, lVar));
        return set;
    }

    private final p0 Q(p0 p0Var) {
        int Z;
        List L1;
        Object S4;
        if (p0Var.i().isReal()) {
            return p0Var;
        }
        Collection<? extends p0> d4 = p0Var.d();
        f0.o(d4, "this.overriddenDescriptors");
        Z = y.Z(d4, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (p0 it : d4) {
            f0.o(it, "it");
            arrayList.add(Q(it));
        }
        L1 = kotlin.collections.f0.L1(arrayList);
        S4 = kotlin.collections.f0.S4(L1);
        return (p0) S4;
    }

    private final Set<u0> R(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        Set<u0> L5;
        Set<u0> k4;
        k b4 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.h.b(dVar);
        if (b4 == null) {
            k4 = j1.k();
            return k4;
        }
        L5 = kotlin.collections.f0.L5(b4.a(fVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        return L5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    /* renamed from: N */
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a q() {
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a(this.f56902n, a.f56904a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    /* renamed from: P */
    public f D() {
        return this.f56903o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f h(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> m(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar) {
        Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
        f0.p(kindFilter, "kindFilter");
        k4 = j1.k();
        return k4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> o(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar) {
        Set<kotlin.reflect.jvm.internal.impl.name.f> K5;
        List M;
        f0.p(kindFilter, "kindFilter");
        K5 = kotlin.collections.f0.K5(z().invoke().a());
        k b4 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.h.b(D());
        Set<kotlin.reflect.jvm.internal.impl.name.f> b5 = b4 == null ? null : b4.b();
        if (b5 == null) {
            b5 = j1.k();
        }
        K5.addAll(b5);
        if (this.f56902n.v()) {
            M = CollectionsKt__CollectionsKt.M(kotlin.reflect.jvm.internal.impl.builtins.j.f56074c, kotlin.reflect.jvm.internal.impl.builtins.j.f56073b);
            K5.addAll(M);
        }
        K5.addAll(x().a().w().a(D()));
        return K5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void p(@NotNull Collection<u0> result, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        f0.p(result, "result");
        f0.p(name, "name");
        x().a().w().c(D(), name, result);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void s(@NotNull Collection<u0> result, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        f0.p(result, "result");
        f0.p(name, "name");
        Collection<? extends u0> e4 = kotlin.reflect.jvm.internal.impl.load.java.components.a.e(name, R(name, D()), result, D(), x().a().c(), x().a().k().a());
        f0.o(e4, "resolveOverridesForStati\u2026.overridingUtil\n        )");
        result.addAll(e4);
        if (this.f56902n.v()) {
            if (f0.g(name, kotlin.reflect.jvm.internal.impl.builtins.j.f56074c)) {
                u0 d4 = kotlin.reflect.jvm.internal.impl.resolve.c.d(D());
                f0.o(d4, "createEnumValueOfMethod(ownerDescriptor)");
                result.add(d4);
            } else if (f0.g(name, kotlin.reflect.jvm.internal.impl.builtins.j.f56073b)) {
                u0 e5 = kotlin.reflect.jvm.internal.impl.resolve.c.e(D());
                f0.o(e5, "createEnumValuesMethod(ownerDescriptor)");
                result.add(e5);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.l, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void t(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull Collection<p0> result) {
        f0.p(name, "name");
        f0.p(result, "result");
        Set O = O(D(), new LinkedHashSet(), new b(name));
        if (!result.isEmpty()) {
            Collection<? extends p0> e4 = kotlin.reflect.jvm.internal.impl.load.java.components.a.e(name, O, result, D(), x().a().c(), x().a().k().a());
            f0.o(e4, "resolveOverridesForStati\u2026ingUtil\n                )");
            result.addAll(e4);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : O) {
            p0 Q = Q((p0) obj);
            Object obj2 = linkedHashMap.get(Q);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(Q, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Collection e5 = kotlin.reflect.jvm.internal.impl.load.java.components.a.e(name, (Collection) entry.getValue(), result, D(), x().a().c(), x().a().k().a());
            f0.o(e5, "resolveOverridesForStati\u2026ingUtil\n                )");
            c0.o0(arrayList, e5);
        }
        result.addAll(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> u(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar) {
        Set<kotlin.reflect.jvm.internal.impl.name.f> K5;
        f0.p(kindFilter, "kindFilter");
        K5 = kotlin.collections.f0.K5(z().invoke().c());
        O(D(), K5, c.f56906a);
        return K5;
    }
}
