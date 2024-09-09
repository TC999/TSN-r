package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.j1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b;
import kotlin.reflect.jvm.internal.impl.load.java.n;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import kotlin.reflect.jvm.internal.impl.load.kotlin.o;
import kotlin.reflect.jvm.internal.impl.load.kotlin.p;
import m2.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyJavaPackageScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i extends l {
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final u f56856n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final h f56857o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.j<Set<String>> f56858p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.h<a, kotlin.reflect.jvm.internal.impl.descriptors.d> f56859q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyJavaPackageScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.name.f f56860a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final m2.g f56861b;

        public a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @Nullable m2.g gVar) {
            f0.p(name, "name");
            this.f56860a = name;
            this.f56861b = gVar;
        }

        @Nullable
        public final m2.g a() {
            return this.f56861b;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.f b() {
            return this.f56860a;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && f0.g(this.f56860a, ((a) obj).f56860a);
        }

        public int hashCode() {
            return this.f56860a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyJavaPackageScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class b {

        /* compiled from: LazyJavaPackageScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends b {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final kotlin.reflect.jvm.internal.impl.descriptors.d f56862a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d descriptor) {
                super(null);
                f0.p(descriptor, "descriptor");
                this.f56862a = descriptor;
            }

            @NotNull
            public final kotlin.reflect.jvm.internal.impl.descriptors.d a() {
                return this.f56862a;
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.i$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1139b extends b {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final C1139b f56863a = new C1139b();

            private C1139b() {
                super(null);
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class c extends b {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final c f56864a = new c();

            private c() {
                super(null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    /* compiled from: LazyJavaPackageScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.l<a, kotlin.reflect.jvm.internal.impl.descriptors.d> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.h f56866b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar) {
            super(1);
            this.f56866b = hVar;
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.d invoke(@NotNull a request) {
            n.a c4;
            byte[] b4;
            f0.p(request, "request");
            kotlin.reflect.jvm.internal.impl.name.b bVar = new kotlin.reflect.jvm.internal.impl.name.b(i.this.D().e(), request.b());
            if (request.a() != null) {
                c4 = this.f56866b.a().j().b(request.a());
            } else {
                c4 = this.f56866b.a().j().c(bVar);
            }
            p a4 = c4 == null ? null : c4.a();
            kotlin.reflect.jvm.internal.impl.name.b c5 = a4 == null ? null : a4.c();
            if (c5 == null || !(c5.l() || c5.k())) {
                b S = i.this.S(a4);
                if (S instanceof b.a) {
                    return ((b.a) S).a();
                }
                if (S instanceof b.c) {
                    return null;
                }
                if (S instanceof b.C1139b) {
                    m2.g a5 = request.a();
                    if (a5 == null) {
                        kotlin.reflect.jvm.internal.impl.load.java.n d4 = this.f56866b.a().d();
                        if (c4 != null) {
                            if (!(c4 instanceof n.a.C1154a)) {
                                c4 = null;
                            }
                            n.a.C1154a c1154a = (n.a.C1154a) c4;
                            if (c1154a != null) {
                                b4 = c1154a.b();
                                a5 = d4.a(new n.a(bVar, b4, null, 4, null));
                            }
                        }
                        b4 = null;
                        a5 = d4.a(new n.a(bVar, b4, null, 4, null));
                    }
                    m2.g gVar = a5;
                    if ((gVar == null ? null : gVar.I()) != LightClassOriginKind.BINARY) {
                        kotlin.reflect.jvm.internal.impl.name.c e4 = gVar == null ? null : gVar.e();
                        if (e4 == null || e4.d() || !f0.g(e4.e(), i.this.D().e())) {
                            return null;
                        }
                        f fVar = new f(this.f56866b, i.this.D(), gVar, null, 8, null);
                        this.f56866b.a().e().a(fVar);
                        return fVar;
                    }
                    throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + gVar + "\nClassId: " + bVar + "\nfindKotlinClass(JavaClass) = " + o.b(this.f56866b.a().j(), gVar) + "\nfindKotlinClass(ClassId) = " + o.a(this.f56866b.a().j(), bVar) + '\n');
                }
                throw new NoWhenBranchMatchedException();
            }
            return null;
        }
    }

    /* compiled from: LazyJavaPackageScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.a<Set<? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.h f56867a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f56868b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, i iVar) {
            super(0);
            this.f56867a = hVar;
            this.f56868b = iVar;
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final Set<String> invoke() {
            return this.f56867a.a().d().c(this.f56868b.D().e());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4, @NotNull u jPackage, @NotNull h ownerDescriptor) {
        super(c4);
        f0.p(c4, "c");
        f0.p(jPackage, "jPackage");
        f0.p(ownerDescriptor, "ownerDescriptor");
        this.f56856n = jPackage;
        this.f56857o = ownerDescriptor;
        this.f56858p = c4.e().i(new d(c4, this));
        this.f56859q = c4.e().e(new c(c4));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d O(kotlin.reflect.jvm.internal.impl.name.f fVar, m2.g gVar) {
        if (kotlin.reflect.jvm.internal.impl.name.h.f57577a.a(fVar)) {
            Set<String> invoke = this.f56858p.invoke();
            if (gVar != null || invoke == null || invoke.contains(fVar.b())) {
                return this.f56859q.invoke(new a(fVar, gVar));
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b S(p pVar) {
        if (pVar == null) {
            return b.C1139b.f56863a;
        }
        if (pVar.e().c() == KotlinClassHeader.Kind.CLASS) {
            kotlin.reflect.jvm.internal.impl.descriptors.d l4 = x().a().b().l(pVar);
            return l4 != null ? new b.a(l4) : b.C1139b.f56863a;
        }
        return b.c.f56864a;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d P(@NotNull m2.g javaClass) {
        f0.p(javaClass, "javaClass");
        return O(javaClass.getName(), javaClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    /* renamed from: Q */
    public kotlin.reflect.jvm.internal.impl.descriptors.d h(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        return O(name, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    /* renamed from: R */
    public h D() {
        return this.f56857o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Collection<p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        List F;
        f0.p(name, "name");
        f0.p(location, "location");
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0033 A[SYNTHETIC] */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d r5, @org.jetbrains.annotations.NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, java.lang.Boolean> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "kindFilter"
            kotlin.jvm.internal.f0.p(r5, r0)
            java.lang.String r0 = "nameFilter"
            kotlin.jvm.internal.f0.p(r6, r0)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.d$a r0 = kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57890c
            int r1 = r0.c()
            int r0 = r0.e()
            r0 = r0 | r1
            boolean r5 = r5.a(r0)
            if (r5 != 0) goto L20
            java.util.List r5 = kotlin.collections.w.F()
            goto L65
        L20:
            kotlin.reflect.jvm.internal.impl.storage.i r5 = r4.w()
            java.lang.Object r5 = r5.invoke()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L33:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L64
            java.lang.Object r1 = r5.next()
            r2 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.k r2 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r2
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d
            if (r3 == 0) goto L5d
            kotlin.reflect.jvm.internal.impl.descriptors.d r2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r2
            kotlin.reflect.jvm.internal.impl.name.f r2 = r2.getName()
            java.lang.String r3 = "it.name"
            kotlin.jvm.internal.f0.o(r2, r3)
            java.lang.Object r2 = r6.invoke(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L5d
            r2 = 1
            goto L5e
        L5d:
            r2 = 0
        L5e:
            if (r2 == 0) goto L33
            r0.add(r1)
            goto L33
        L64:
            r5 = r0
        L65:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.i.f(kotlin.reflect.jvm.internal.impl.resolve.scopes.d, d2.l):java.util.Collection");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> m(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar) {
        Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
        f0.p(kindFilter, "kindFilter");
        if (!kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57890c.e())) {
            k4 = j1.k();
            return k4;
        }
        Set<String> invoke = this.f56858p.invoke();
        if (invoke != null) {
            HashSet hashSet = new HashSet();
            for (String str : invoke) {
                hashSet.add(kotlin.reflect.jvm.internal.impl.name.f.f(str));
            }
            return hashSet;
        }
        u uVar = this.f56856n;
        if (lVar == null) {
            lVar = kotlin.reflect.jvm.internal.impl.utils.d.a();
        }
        Collection<m2.g> L2 = uVar.L(lVar);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (m2.g gVar : L2) {
            kotlin.reflect.jvm.internal.impl.name.f name = gVar.I() == LightClassOriginKind.SOURCE ? null : gVar.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> o(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar) {
        Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
        f0.p(kindFilter, "kindFilter");
        k4 = j1.k();
        return k4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    protected kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b q() {
        return b.a.f56783a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void s(@NotNull Collection<u0> result, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        f0.p(result, "result");
        f0.p(name, "name");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> u(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar) {
        Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
        f0.p(kindFilter, "kindFilter");
        k4 = j1.k();
        return k4;
    }
}
