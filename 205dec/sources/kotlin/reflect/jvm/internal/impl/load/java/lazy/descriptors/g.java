package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.c0;
import kotlin.collections.k1;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.collections.y0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.components.j;
import kotlin.reflect.jvm.internal.impl.load.java.d0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j;
import kotlin.reflect.jvm.internal.impl.load.java.n;
import kotlin.reflect.jvm.internal.impl.load.kotlin.u;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.utils.f;
import m2.n;
import m2.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyJavaClassMemberScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g extends kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j {
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f56825n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final m2.g f56826o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f56827p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<List<kotlin.reflect.jvm.internal.impl.descriptors.c>> f56828q;
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<Set<kotlin.reflect.jvm.internal.impl.name.f>> f56829r;
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<Map<kotlin.reflect.jvm.internal.impl.name.f, n>> f56830s;
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.impl.g> f56831t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.l<q, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56832a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull q it) {
            f0.p(it, "it");
            return Boolean.valueOf(!it.O());
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    /* synthetic */ class b extends FunctionReference implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends u0>> {
        b(Object obj) {
            super(1, obj);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: d */
        public final Collection<u0> invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f p02) {
            f0.p(p02, "p0");
            return ((g) this.receiver).I0(p02);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(g.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    /* synthetic */ class c extends FunctionReference implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends u0>> {
        c(Object obj) {
            super(1, obj);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: d */
        public final Collection<u0> invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f p02) {
            f0.p(p02, "p0");
            return ((g) this.receiver).J0(p02);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(g.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends u0>> {
        d() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Collection<u0> invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f it) {
            f0.p(it, "it");
            return g.this.I0(it);
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class e extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends u0>> {
        e() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Collection<u0> invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f it) {
            f0.p(it, "it");
            return g.this.J0(it);
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class f extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.c>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.h f56836b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar) {
            super(0);
            this.f56836b = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
        @Override // d2.a
        @NotNull
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.c> invoke() {
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.c> G5;
            ?? N;
            Collection<m2.k> g4 = g.this.f56826o.g();
            ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.c> arrayList = new ArrayList(g4.size());
            for (m2.k kVar : g4) {
                arrayList.add(g.this.G0(kVar));
            }
            if (g.this.f56826o.o()) {
                kotlin.reflect.jvm.internal.impl.descriptors.c f02 = g.this.f0();
                boolean z3 = false;
                String c4 = u.c(f02, false, false, 2, null);
                if (!arrayList.isEmpty()) {
                    for (kotlin.reflect.jvm.internal.impl.descriptors.c cVar : arrayList) {
                        if (f0.g(u.c(cVar, false, false, 2, null), c4)) {
                            break;
                        }
                    }
                }
                z3 = true;
                if (z3) {
                    arrayList.add(f02);
                    this.f56836b.a().h().c(g.this.f56826o, f02);
                }
            }
            this.f56836b.a().w().b(g.this.D(), arrayList);
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i r3 = this.f56836b.a().r();
            kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar = this.f56836b;
            g gVar = g.this;
            boolean isEmpty = arrayList.isEmpty();
            ArrayList arrayList2 = arrayList;
            if (isEmpty) {
                N = CollectionsKt__CollectionsKt.N(gVar.e0());
                arrayList2 = N;
            }
            G5 = kotlin.collections.f0.G5(r3.e(hVar, arrayList2));
            return G5;
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.g$g  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class C1138g extends Lambda implements d2.a<Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends n>> {
        C1138g() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Map<kotlin.reflect.jvm.internal.impl.name.f, n> invoke() {
            int Z;
            int j4;
            int n4;
            Collection<n> w3 = g.this.f56826o.w();
            ArrayList arrayList = new ArrayList();
            for (Object obj : w3) {
                if (((n) obj).G()) {
                    arrayList.add(obj);
                }
            }
            Z = y.Z(arrayList, 10);
            j4 = y0.j(Z);
            n4 = kotlin.ranges.q.n(j4, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(n4);
            for (Object obj2 : arrayList) {
                linkedHashMap.put(((n) obj2).getName(), obj2);
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class h extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends u0>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u0 f56838a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f56839b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(u0 u0Var, g gVar) {
            super(1);
            this.f56838a = u0Var;
            this.f56839b = gVar;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Collection<u0> invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f accessorName) {
            List o4;
            List l4;
            f0.p(accessorName, "accessorName");
            if (f0.g(this.f56838a.getName(), accessorName)) {
                l4 = x.l(this.f56838a);
                return l4;
            }
            o4 = kotlin.collections.f0.o4(this.f56839b.I0(accessorName), this.f56839b.J0(accessorName));
            return o4;
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class i extends Lambda implements d2.a<Set<? extends kotlin.reflect.jvm.internal.impl.name.f>> {
        i() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Set<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> L5;
            L5 = kotlin.collections.f0.L5(g.this.f56826o.y());
            return L5;
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class j extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.impl.g> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.h f56842b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LazyJavaClassMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends Lambda implements d2.a<Set<? extends kotlin.reflect.jvm.internal.impl.name.f>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f56843a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(0);
                this.f56843a = gVar;
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final Set<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
                Set<kotlin.reflect.jvm.internal.impl.name.f> C;
                C = k1.C(this.f56843a.b(), this.f56843a.d());
                return C;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar) {
            super(1);
            this.f56842b = hVar;
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.impl.g invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            f0.p(name, "name");
            if (!((Set) g.this.f56829r.invoke()).contains(name)) {
                n nVar = (n) ((Map) g.this.f56830s.invoke()).get(name);
                if (nVar != null) {
                    return kotlin.reflect.jvm.internal.impl.descriptors.impl.n.G0(this.f56842b.e(), g.this.D(), name, this.f56842b.e().g(new a(g.this)), kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(this.f56842b, nVar), this.f56842b.a().t().a(nVar));
                }
                return null;
            }
            kotlin.reflect.jvm.internal.impl.load.java.n d4 = this.f56842b.a().d();
            kotlin.reflect.jvm.internal.impl.name.b h4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(g.this.D());
            f0.m(h4);
            kotlin.reflect.jvm.internal.impl.name.b d5 = h4.d(name);
            f0.o(d5, "ownerDescriptor.classId!\u2026createNestedClassId(name)");
            m2.g a4 = d4.a(new n.a(d5, null, g.this.f56826o, 2, null));
            if (a4 == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar = this.f56842b;
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f fVar = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f(hVar, g.this.D(), a4, null, 8, null);
            hVar.a().e().a(fVar);
            return fVar;
        }
    }

    public /* synthetic */ g(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar, m2.g gVar, boolean z3, g gVar2, int i4, kotlin.jvm.internal.u uVar) {
        this(hVar, dVar, gVar, z3, (i4 & 16) != 0 ? null : gVar2);
    }

    private final Set<p0> A0(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        Set<p0> L5;
        int Z;
        Collection<e0> c02 = c0();
        ArrayList arrayList = new ArrayList();
        for (e0 e0Var : c02) {
            Collection<? extends p0> c4 = e0Var.p().c(fVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            Z = y.Z(c4, 10);
            ArrayList arrayList2 = new ArrayList(Z);
            for (p0 p0Var : c4) {
                arrayList2.add(p0Var);
            }
            c0.o0(arrayList, arrayList2);
        }
        L5 = kotlin.collections.f0.L5(arrayList);
        return L5;
    }

    private final boolean B0(u0 u0Var, w wVar) {
        String c4 = u.c(u0Var, false, false, 2, null);
        w a4 = wVar.a();
        f0.o(a4, "builtinWithErasedParameters.original");
        return f0.g(c4, u.c(a4, false, false, 2, null)) && !p0(u0Var, wVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
        if (kotlin.reflect.jvm.internal.impl.load.java.x.d(r4) == false) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0074 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean C0(kotlin.reflect.jvm.internal.impl.descriptors.u0 r7) {
        /*
            r6 = this;
            kotlin.reflect.jvm.internal.impl.name.f r0 = r7.getName()
            java.lang.String r1 = "function.name"
            kotlin.jvm.internal.f0.o(r0, r1)
            java.util.List r0 = kotlin.reflect.jvm.internal.impl.load.java.c0.a(r0)
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1b
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L1b
        L19:
            r0 = 0
            goto L78
        L1b:
            java.util.Iterator r0 = r0.iterator()
        L1f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L19
            java.lang.Object r1 = r0.next()
            kotlin.reflect.jvm.internal.impl.name.f r1 = (kotlin.reflect.jvm.internal.impl.name.f) r1
            java.util.Set r1 = r6.A0(r1)
            boolean r4 = r1 instanceof java.util.Collection
            if (r4 == 0) goto L3b
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L3b
        L39:
            r1 = 0
            goto L75
        L3b:
            java.util.Iterator r1 = r1.iterator()
        L3f:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L39
            java.lang.Object r4 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.p0 r4 = (kotlin.reflect.jvm.internal.impl.descriptors.p0) r4
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.g$h r5 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.g$h
            r5.<init>(r7, r6)
            boolean r5 = r6.o0(r4, r5)
            if (r5 == 0) goto L71
            boolean r4 = r4.O()
            if (r4 != 0) goto L6f
            kotlin.reflect.jvm.internal.impl.name.f r4 = r7.getName()
            java.lang.String r4 = r4.b()
            java.lang.String r5 = "function.name.asString()"
            kotlin.jvm.internal.f0.o(r4, r5)
            boolean r4 = kotlin.reflect.jvm.internal.impl.load.java.x.d(r4)
            if (r4 != 0) goto L71
        L6f:
            r4 = 1
            goto L72
        L71:
            r4 = 0
        L72:
            if (r4 == 0) goto L3f
            r1 = 1
        L75:
            if (r1 == 0) goto L1f
            r0 = 1
        L78:
            if (r0 == 0) goto L7b
            return r3
        L7b:
            boolean r0 = r6.q0(r7)
            if (r0 != 0) goto L8e
            boolean r0 = r6.K0(r7)
            if (r0 != 0) goto L8e
            boolean r7 = r6.s0(r7)
            if (r7 != 0) goto L8e
            goto L8f
        L8e:
            r2 = 0
        L8f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.g.C0(kotlin.reflect.jvm.internal.impl.descriptors.u0):boolean");
    }

    private final u0 D0(u0 u0Var, d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends u0>> lVar, Collection<? extends u0> collection) {
        u0 h02;
        w k4 = kotlin.reflect.jvm.internal.impl.load.java.e.k(u0Var);
        if (k4 == null || (h02 = h0(k4, lVar)) == null) {
            return null;
        }
        if (!C0(h02)) {
            h02 = null;
        }
        if (h02 == null) {
            return null;
        }
        return g0(h02, k4, collection);
    }

    private final u0 E0(u0 u0Var, d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends u0>> lVar, kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<? extends u0> collection) {
        u0 u0Var2 = (u0) d0.d(u0Var);
        if (u0Var2 == null) {
            return null;
        }
        String b4 = d0.b(u0Var2);
        f0.m(b4);
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(b4);
        f0.o(f4, "identifier(nameInJava)");
        for (u0 u0Var3 : lVar.invoke(f4)) {
            u0 m02 = m0(u0Var3, fVar);
            if (r0(u0Var2, m02)) {
                return g0(m02, u0Var2, collection);
            }
        }
        return null;
    }

    private final u0 F0(u0 u0Var, d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends u0>> lVar) {
        if (u0Var.isSuspend()) {
            kotlin.reflect.jvm.internal.impl.name.f name = u0Var.getName();
            f0.o(name, "descriptor.name");
            for (u0 u0Var2 : lVar.invoke(name)) {
                u0 n02 = n0(u0Var2);
                if (n02 == null || !p0(n02, u0Var)) {
                    n02 = null;
                    continue;
                }
                if (n02 != null) {
                    return n02;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.load.java.descriptors.b G0(m2.k kVar) {
        int Z;
        List<a1> o4;
        kotlin.reflect.jvm.internal.impl.descriptors.d D = D();
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.b n12 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.b.n1(D, kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(x(), kVar), false, x().a().t().a(kVar));
        f0.o(n12, "createJavaConstructor(\n \u2026ce(constructor)\n        )");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.h e4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.e(x(), n12, kVar, D.r().size());
        j.b L2 = L(e4, n12, kVar.h());
        List<a1> r3 = D.r();
        f0.o(r3, "classDescriptor.declaredTypeParameters");
        List<m2.y> typeParameters = kVar.getTypeParameters();
        Z = y.Z(typeParameters, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (m2.y yVar : typeParameters) {
            a1 a4 = e4.f().a(yVar);
            f0.m(a4);
            arrayList.add(a4);
        }
        o4 = kotlin.collections.f0.o4(r3, arrayList);
        n12.l1(L2.a(), kotlin.reflect.jvm.internal.impl.load.java.e0.c(kVar.getVisibility()), o4);
        n12.T0(false);
        n12.U0(L2.b());
        n12.b1(D.q());
        e4.a().h().c(kVar, n12);
        return n12;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.e H0(m2.w wVar) {
        List<? extends a1> F;
        List<d1> F2;
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.e k12 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.e.k1(D(), kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(x(), wVar), wVar.getName(), x().a().t().a(wVar), true);
        f0.o(k12, "createJavaMethod(\n      \u2026omponent), true\n        )");
        e0 o4 = x().g().o(wVar.getType(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.d(TypeUsage.COMMON, false, null, 2, null));
        s0 A = A();
        F = CollectionsKt__CollectionsKt.F();
        F2 = CollectionsKt__CollectionsKt.F();
        k12.j1(null, A, F, F2, o4, Modality.Companion.a(false, false, true), r.f56531e, null);
        k12.n1(false, false);
        x().a().h().e(wVar, k12);
        return k12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<u0> I0(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        int Z;
        Collection<m2.r> d4 = z().invoke().d(fVar);
        Z = y.Z(d4, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (m2.r rVar : d4) {
            arrayList.add(J(rVar));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<u0> J0(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        Set<u0> y02 = y0(fVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : y02) {
            u0 u0Var = (u0) obj;
            if (!(d0.a(u0Var) || kotlin.reflect.jvm.internal.impl.load.java.e.k(u0Var) != null)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean K0(u0 u0Var) {
        kotlin.reflect.jvm.internal.impl.load.java.e eVar = kotlin.reflect.jvm.internal.impl.load.java.e.f56730n;
        kotlin.reflect.jvm.internal.impl.name.f name = u0Var.getName();
        f0.o(name, "name");
        if (eVar.l(name)) {
            kotlin.reflect.jvm.internal.impl.name.f name2 = u0Var.getName();
            f0.o(name2, "name");
            Set<u0> y02 = y0(name2);
            ArrayList<w> arrayList = new ArrayList();
            for (u0 u0Var2 : y02) {
                w k4 = kotlin.reflect.jvm.internal.impl.load.java.e.k(u0Var2);
                if (k4 != null) {
                    arrayList.add(k4);
                }
            }
            if (arrayList.isEmpty()) {
                return false;
            }
            for (w wVar : arrayList) {
                if (B0(u0Var, wVar)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private final void V(List<d1> list, kotlin.reflect.jvm.internal.impl.descriptors.j jVar, int i4, m2.r rVar, e0 e0Var, e0 e0Var2) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f b4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
        kotlin.reflect.jvm.internal.impl.name.f name = rVar.getName();
        e0 o4 = h1.o(e0Var);
        f0.o(o4, "makeNotNullable(returnType)");
        list.add(new l0(jVar, null, i4, b4, name, o4, rVar.K(), false, false, e0Var2 == null ? null : h1.o(e0Var2), x().a().t().a(rVar)));
    }

    private final void W(Collection<u0> collection, kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<? extends u0> collection2, boolean z3) {
        List o4;
        int Z;
        Collection<? extends u0> d4 = kotlin.reflect.jvm.internal.impl.load.java.components.a.d(fVar, collection2, collection, D(), x().a().c(), x().a().k().a());
        f0.o(d4, "resolveOverridesForNonSt\u2026.overridingUtil\n        )");
        if (!z3) {
            collection.addAll(d4);
            return;
        }
        o4 = kotlin.collections.f0.o4(collection, d4);
        Z = y.Z(d4, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (u0 resolvedOverride : d4) {
            u0 u0Var = (u0) d0.e(resolvedOverride);
            if (u0Var == null) {
                f0.o(resolvedOverride, "resolvedOverride");
            } else {
                f0.o(resolvedOverride, "resolvedOverride");
                resolvedOverride = g0(resolvedOverride, u0Var, o4);
            }
            arrayList.add(resolvedOverride);
        }
        collection.addAll(arrayList);
    }

    private final void X(kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<? extends u0> collection, Collection<? extends u0> collection2, Collection<u0> collection3, d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends u0>> lVar) {
        for (u0 u0Var : collection2) {
            kotlin.reflect.jvm.internal.impl.utils.a.a(collection3, E0(u0Var, lVar, fVar, collection));
            kotlin.reflect.jvm.internal.impl.utils.a.a(collection3, D0(u0Var, lVar, collection));
            kotlin.reflect.jvm.internal.impl.utils.a.a(collection3, F0(u0Var, lVar));
        }
    }

    private final void Y(Set<? extends p0> set, Collection<p0> collection, Set<p0> set2, d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends u0>> lVar) {
        for (p0 p0Var : set) {
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.f i02 = i0(p0Var, lVar);
            if (i02 != null) {
                collection.add(i02);
                if (set2 == null) {
                    return;
                }
                set2.add(p0Var);
                return;
            }
        }
    }

    private final void Z(kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<p0> collection) {
        Object T4;
        T4 = kotlin.collections.f0.T4(z().invoke().d(fVar));
        m2.r rVar = (m2.r) T4;
        if (rVar == null) {
            return;
        }
        collection.add(k0(this, rVar, null, Modality.FINAL, 2, null));
    }

    private final Collection<e0> c0() {
        if (this.f56827p) {
            Collection<e0> j4 = D().j().j();
            f0.o(j4, "ownerDescriptor.typeConstructor.supertypes");
            return j4;
        }
        return x().a().k().c().g(D());
    }

    private final List<d1> d0(kotlin.reflect.jvm.internal.impl.descriptors.impl.f fVar) {
        Object r22;
        Pair pair;
        Collection<m2.r> z3 = this.f56826o.z();
        ArrayList arrayList = new ArrayList(z3.size());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a d4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.d(TypeUsage.COMMON, true, null, 2, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : z3) {
            if (f0.g(((m2.r) obj).getName(), kotlin.reflect.jvm.internal.impl.load.java.y.f57107c)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        Pair pair2 = new Pair(arrayList2, arrayList3);
        List list = (List) pair2.component1();
        List<m2.r> list2 = (List) pair2.component2();
        list.size();
        r22 = kotlin.collections.f0.r2(list);
        m2.r rVar = (m2.r) r22;
        if (rVar != null) {
            m2.x returnType = rVar.getReturnType();
            if (returnType instanceof m2.f) {
                m2.f fVar2 = (m2.f) returnType;
                pair = new Pair(x().g().k(fVar2, d4, true), x().g().o(fVar2.l(), d4));
            } else {
                pair = new Pair(x().g().o(returnType, d4), null);
            }
            V(arrayList, fVar, 0, rVar, (e0) pair.component1(), (e0) pair.component2());
        }
        int i4 = 0;
        int i5 = rVar == null ? 0 : 1;
        for (m2.r rVar2 : list2) {
            V(arrayList, fVar, i4 + i5, rVar2, x().g().o(rVar2.getReturnType(), d4), null);
            i4++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.c e0() {
        List<d1> emptyList;
        boolean m4 = this.f56826o.m();
        if ((this.f56826o.H() || !this.f56826o.q()) && !m4) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d D = D();
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.b n12 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.b.n1(D, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), true, x().a().t().a(this.f56826o));
        f0.o(n12, "createJavaConstructor(\n \u2026.source(jClass)\n        )");
        if (m4) {
            emptyList = d0(n12);
        } else {
            emptyList = Collections.emptyList();
        }
        n12.U0(false);
        n12.k1(emptyList, w0(D));
        n12.T0(true);
        n12.b1(D.q());
        x().a().h().c(this.f56826o, n12);
        return n12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.c f0() {
        kotlin.reflect.jvm.internal.impl.descriptors.d D = D();
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.b n12 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.b.n1(D, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), true, x().a().t().a(this.f56826o));
        f0.o(n12, "createJavaConstructor(\n \u2026.source(jClass)\n        )");
        List<d1> l02 = l0(n12);
        n12.U0(false);
        n12.k1(l02, w0(D));
        n12.T0(false);
        n12.b1(D.q());
        return n12;
    }

    private final u0 g0(u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, Collection<? extends u0> collection) {
        boolean z3;
        boolean z4 = false;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            for (u0 u0Var2 : collection) {
                if (!f0.g(u0Var, u0Var2) && u0Var2.q0() == null && p0(u0Var2, aVar)) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (z3) {
                    break;
                }
            }
        }
        z4 = true;
        if (z4) {
            return u0Var;
        }
        u0 build = u0Var.x().i().build();
        f0.m(build);
        return build;
    }

    private final u0 h0(w wVar, d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends u0>> lVar) {
        Object obj;
        int Z;
        kotlin.reflect.jvm.internal.impl.name.f name = wVar.getName();
        f0.o(name, "overridden.name");
        Iterator<T> it = lVar.invoke(name).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (B0((u0) obj, wVar)) {
                break;
            }
        }
        u0 u0Var = (u0) obj;
        if (u0Var == null) {
            return null;
        }
        w.a<? extends u0> x3 = u0Var.x();
        List<d1> h4 = wVar.h();
        f0.o(h4, "overridden.valueParameters");
        Z = y.Z(h4, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (d1 d1Var : h4) {
            e0 type = d1Var.getType();
            f0.o(type, "it.type");
            arrayList.add(new kotlin.reflect.jvm.internal.impl.load.java.descriptors.i(type, d1Var.x0()));
        }
        List<d1> h5 = u0Var.h();
        f0.o(h5, "override.valueParameters");
        x3.b(kotlin.reflect.jvm.internal.impl.load.java.descriptors.h.a(arrayList, h5, wVar));
        x3.t();
        x3.l();
        x3.g(kotlin.reflect.jvm.internal.impl.load.java.descriptors.e.G, Boolean.TRUE);
        return x3.build();
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.f i0(p0 p0Var, d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends u0>> lVar) {
        u0 u0Var;
        List<? extends a1> F;
        Object r22;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.e0 e0Var = null;
        if (o0(p0Var, lVar)) {
            u0 u02 = u0(p0Var, lVar);
            f0.m(u02);
            if (p0Var.O()) {
                u0Var = v0(p0Var, lVar);
                f0.m(u0Var);
            } else {
                u0Var = null;
            }
            if (u0Var != null) {
                u0Var.s();
                u02.s();
            }
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.d dVar = new kotlin.reflect.jvm.internal.impl.load.java.descriptors.d(D(), u02, u0Var, p0Var);
            e0 returnType = u02.getReturnType();
            f0.m(returnType);
            F = CollectionsKt__CollectionsKt.F();
            dVar.W0(returnType, F, A(), null);
            kotlin.reflect.jvm.internal.impl.descriptors.impl.d0 h4 = kotlin.reflect.jvm.internal.impl.resolve.c.h(dVar, u02.getAnnotations(), false, false, false, u02.getSource());
            h4.I0(u02);
            h4.L0(dVar.getType());
            f0.o(h4, "createGetter(\n          \u2026escriptor.type)\n        }");
            if (u0Var != null) {
                List<d1> h5 = u0Var.h();
                f0.o(h5, "setterMethod.valueParameters");
                r22 = kotlin.collections.f0.r2(h5);
                d1 d1Var = (d1) r22;
                if (d1Var != null) {
                    e0Var = kotlin.reflect.jvm.internal.impl.resolve.c.j(dVar, u0Var.getAnnotations(), d1Var.getAnnotations(), false, false, false, u0Var.getVisibility(), u0Var.getSource());
                    e0Var.I0(u0Var);
                } else {
                    throw new AssertionError(f0.C("No parameter found for ", u0Var));
                }
            }
            dVar.P0(h4, e0Var);
            return dVar;
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.f j0(m2.r rVar, e0 e0Var, Modality modality) {
        List<? extends a1> F;
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.f Y0 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.f.Y0(D(), kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(x(), rVar), modality, kotlin.reflect.jvm.internal.impl.load.java.e0.c(rVar.getVisibility()), false, rVar.getName(), x().a().t().a(rVar), false);
        f0.o(Y0, "create(\n            owne\u2026inal = */ false\n        )");
        kotlin.reflect.jvm.internal.impl.descriptors.impl.d0 b4 = kotlin.reflect.jvm.internal.impl.resolve.c.b(Y0, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b());
        f0.o(b4, "createDefaultGetter(prop\u2026iptor, Annotations.EMPTY)");
        Y0.P0(b4, null);
        e0 r3 = e0Var == null ? r(rVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.a.f(x(), Y0, rVar, 0, 4, null)) : e0Var;
        F = CollectionsKt__CollectionsKt.F();
        Y0.W0(r3, F, A(), null);
        b4.L0(r3);
        return Y0;
    }

    static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.descriptors.f k0(g gVar, m2.r rVar, e0 e0Var, Modality modality, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            e0Var = null;
        }
        return gVar.j0(rVar, e0Var, modality);
    }

    private final List<d1> l0(kotlin.reflect.jvm.internal.impl.descriptors.impl.f fVar) {
        Collection<m2.w> i4 = this.f56826o.i();
        ArrayList arrayList = new ArrayList(i4.size());
        e0 e0Var = null;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a d4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.d(TypeUsage.COMMON, false, null, 2, null);
        int i5 = 0;
        for (m2.w wVar : i4) {
            int i6 = i5 + 1;
            e0 o4 = x().g().o(wVar.getType(), d4);
            arrayList.add(new l0(fVar, null, i5, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), wVar.getName(), o4, false, false, false, wVar.k() ? x().a().m().k().k(o4) : e0Var, x().a().t().a(wVar)));
            i5 = i6;
            e0Var = null;
        }
        return arrayList;
    }

    private final u0 m0(u0 u0Var, kotlin.reflect.jvm.internal.impl.name.f fVar) {
        w.a<? extends u0> x3 = u0Var.x();
        x3.j(fVar);
        x3.t();
        x3.l();
        u0 build = x3.build();
        f0.m(build);
        return build;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (kotlin.jvm.internal.f0.g(r3, kotlin.reflect.jvm.internal.impl.builtins.j.f56079h) == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.reflect.jvm.internal.impl.descriptors.u0 n0(kotlin.reflect.jvm.internal.impl.descriptors.u0 r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.h()
            java.lang.String r1 = "valueParameters"
            kotlin.jvm.internal.f0.o(r0, r1)
            java.lang.Object r0 = kotlin.collections.w.g3(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.d1 r0 = (kotlin.reflect.jvm.internal.impl.descriptors.d1) r0
            r2 = 0
            if (r0 != 0) goto L14
        L12:
            r0 = r2
            goto L3f
        L14:
            kotlin.reflect.jvm.internal.impl.types.e0 r3 = r0.getType()
            kotlin.reflect.jvm.internal.impl.types.y0 r3 = r3.H0()
            kotlin.reflect.jvm.internal.impl.descriptors.f r3 = r3.b()
            if (r3 != 0) goto L24
        L22:
            r3 = r2
            goto L37
        L24:
            kotlin.reflect.jvm.internal.impl.name.d r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(r3)
            boolean r4 = r3.f()
            if (r4 == 0) goto L2f
            goto L30
        L2f:
            r3 = r2
        L30:
            if (r3 != 0) goto L33
            goto L22
        L33:
            kotlin.reflect.jvm.internal.impl.name.c r3 = r3.l()
        L37:
            kotlin.reflect.jvm.internal.impl.name.c r4 = kotlin.reflect.jvm.internal.impl.builtins.j.f56079h
            boolean r3 = kotlin.jvm.internal.f0.g(r3, r4)
            if (r3 == 0) goto L12
        L3f:
            if (r0 != 0) goto L42
            return r2
        L42:
            kotlin.reflect.jvm.internal.impl.descriptors.w$a r2 = r6.x()
            java.util.List r6 = r6.h()
            kotlin.jvm.internal.f0.o(r6, r1)
            r1 = 1
            java.util.List r6 = kotlin.collections.w.O1(r6, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.w$a r6 = r2.b(r6)
            kotlin.reflect.jvm.internal.impl.types.e0 r0 = r0.getType()
            java.util.List r0 = r0.G0()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            kotlin.reflect.jvm.internal.impl.types.a1 r0 = (kotlin.reflect.jvm.internal.impl.types.a1) r0
            kotlin.reflect.jvm.internal.impl.types.e0 r0 = r0.getType()
            kotlin.reflect.jvm.internal.impl.descriptors.w$a r6 = r6.m(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.w r6 = r6.build()
            kotlin.reflect.jvm.internal.impl.descriptors.u0 r6 = (kotlin.reflect.jvm.internal.impl.descriptors.u0) r6
            r0 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.impl.g0 r0 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.g0) r0
            if (r0 != 0) goto L79
            goto L7c
        L79:
            r0.c1(r1)
        L7c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.g.n0(kotlin.reflect.jvm.internal.impl.descriptors.u0):kotlin.reflect.jvm.internal.impl.descriptors.u0");
    }

    private final boolean o0(p0 p0Var, d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends u0>> lVar) {
        if (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c.a(p0Var)) {
            return false;
        }
        u0 u02 = u0(p0Var, lVar);
        u0 v02 = v0(p0Var, lVar);
        if (u02 == null) {
            return false;
        }
        if (p0Var.O()) {
            return v02 != null && v02.s() == u02.s();
        }
        return true;
    }

    private final boolean p0(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        OverridingUtil.OverrideCompatibilityInfo.Result c4 = OverridingUtil.f57794d.G(aVar2, aVar, true).c();
        f0.o(c4, "DEFAULT.isOverridableByW\u2026iptor, this, true).result");
        return c4 == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && !kotlin.reflect.jvm.internal.impl.load.java.r.f56981a.a(aVar2, aVar);
    }

    private final boolean q0(u0 u0Var) {
        boolean z3;
        SpecialGenericSignatures.a aVar = SpecialGenericSignatures.f56640a;
        kotlin.reflect.jvm.internal.impl.name.f name = u0Var.getName();
        f0.o(name, "name");
        List<kotlin.reflect.jvm.internal.impl.name.f> b4 = aVar.b(name);
        if (!(b4 instanceof Collection) || !b4.isEmpty()) {
            for (kotlin.reflect.jvm.internal.impl.name.f fVar : b4) {
                Set<u0> y02 = y0(fVar);
                ArrayList<u0> arrayList = new ArrayList();
                for (Object obj : y02) {
                    if (d0.a((u0) obj)) {
                        arrayList.add(obj);
                    }
                }
                if (!arrayList.isEmpty()) {
                    u0 m02 = m0(u0Var, fVar);
                    if (!arrayList.isEmpty()) {
                        for (u0 u0Var2 : arrayList) {
                            if (r0(u0Var2, m02)) {
                                z3 = true;
                                continue;
                                break;
                            }
                        }
                    }
                }
                z3 = false;
                continue;
                if (z3) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean r0(u0 u0Var, w wVar) {
        if (kotlin.reflect.jvm.internal.impl.load.java.d.f56716n.k(u0Var)) {
            wVar = wVar.a();
        }
        f0.o(wVar, "if (superDescriptor.isRe\u2026iginal else subDescriptor");
        return p0(wVar, u0Var);
    }

    private final boolean s0(u0 u0Var) {
        boolean z3;
        u0 n02 = n0(u0Var);
        if (n02 == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.name.f name = u0Var.getName();
        f0.o(name, "name");
        Set<u0> y02 = y0(name);
        if ((y02 instanceof Collection) && y02.isEmpty()) {
            return false;
        }
        for (u0 u0Var2 : y02) {
            if (u0Var2.isSuspend() && p0(n02, u0Var2)) {
                z3 = true;
                continue;
            } else {
                z3 = false;
                continue;
            }
            if (z3) {
                return true;
            }
        }
        return false;
    }

    private final u0 t0(p0 p0Var, String str, d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends u0>> lVar) {
        u0 u0Var;
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(str);
        f0.o(f4, "identifier(getterName)");
        Iterator<T> it = lVar.invoke(f4).iterator();
        do {
            u0Var = null;
            if (!it.hasNext()) {
                break;
            }
            u0 u0Var2 = (u0) it.next();
            if (u0Var2.h().size() == 0) {
                kotlin.reflect.jvm.internal.impl.types.checker.e eVar = kotlin.reflect.jvm.internal.impl.types.checker.e.f58276a;
                e0 returnType = u0Var2.getReturnType();
                if (returnType == null ? false : eVar.d(returnType, p0Var.getType())) {
                    u0Var = u0Var2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (u0Var == null);
        return u0Var;
    }

    private final u0 u0(p0 p0Var, d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends u0>> lVar) {
        q0 getter = p0Var.getGetter();
        q0 q0Var = getter == null ? null : (q0) d0.d(getter);
        String a4 = q0Var != null ? kotlin.reflect.jvm.internal.impl.load.java.h.f56738a.a(q0Var) : null;
        if (a4 != null && !d0.f(D(), q0Var)) {
            return t0(p0Var, a4, lVar);
        }
        String b4 = p0Var.getName().b();
        f0.o(b4, "name.asString()");
        return t0(p0Var, kotlin.reflect.jvm.internal.impl.load.java.x.b(b4), lVar);
    }

    private final u0 v0(p0 p0Var, d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends u0>> lVar) {
        u0 u0Var;
        e0 returnType;
        Object S4;
        String b4 = p0Var.getName().b();
        f0.o(b4, "name.asString()");
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(kotlin.reflect.jvm.internal.impl.load.java.x.e(b4));
        f0.o(f4, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> it = lVar.invoke(f4).iterator();
        do {
            u0Var = null;
            if (!it.hasNext()) {
                break;
            }
            u0 u0Var2 = (u0) it.next();
            if (u0Var2.h().size() == 1 && (returnType = u0Var2.getReturnType()) != null && kotlin.reflect.jvm.internal.impl.builtins.h.A0(returnType)) {
                kotlin.reflect.jvm.internal.impl.types.checker.e eVar = kotlin.reflect.jvm.internal.impl.types.checker.e.f58276a;
                List<d1> h4 = u0Var2.h();
                f0.o(h4, "descriptor.valueParameters");
                S4 = kotlin.collections.f0.S4(h4);
                if (eVar.b(((d1) S4).getType(), p0Var.getType())) {
                    u0Var = u0Var2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (u0Var == null);
        return u0Var;
    }

    private final s w0(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        s visibility = dVar.getVisibility();
        f0.o(visibility, "classDescriptor.visibility");
        if (f0.g(visibility, kotlin.reflect.jvm.internal.impl.load.java.q.f56978b)) {
            s PROTECTED_AND_PACKAGE = kotlin.reflect.jvm.internal.impl.load.java.q.f56979c;
            f0.o(PROTECTED_AND_PACKAGE, "PROTECTED_AND_PACKAGE");
            return PROTECTED_AND_PACKAGE;
        }
        return visibility;
    }

    private final Set<u0> y0(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        Collection<e0> c02 = c0();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (e0 e0Var : c02) {
            c0.o0(linkedHashSet, e0Var.p().a(fVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @Nullable
    protected s0 A() {
        return kotlin.reflect.jvm.internal.impl.resolve.d.l(D());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected boolean H(@NotNull kotlin.reflect.jvm.internal.impl.load.java.descriptors.e eVar) {
        f0.p(eVar, "<this>");
        if (this.f56826o.m()) {
            return false;
        }
        return C0(eVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    protected j.a I(@NotNull m2.r method, @NotNull List<? extends a1> methodTypeParameters, @NotNull e0 returnType, @NotNull List<? extends d1> valueParameters) {
        f0.p(method, "method");
        f0.p(methodTypeParameters, "methodTypeParameters");
        f0.p(returnType, "returnType");
        f0.p(valueParameters, "valueParameters");
        j.b b4 = x().a().s().b(method, D(), returnType, null, valueParameters, methodTypeParameters);
        f0.o(b4, "c.components.signaturePr\u2026dTypeParameters\n        )");
        e0 d4 = b4.d();
        f0.o(d4, "propagated.returnType");
        e0 c4 = b4.c();
        List<d1> f4 = b4.f();
        f0.o(f4, "propagated.valueParameters");
        List<a1> e4 = b4.e();
        f0.o(e4, "propagated.typeParameters");
        boolean g4 = b4.g();
        List<String> b5 = b4.b();
        f0.o(b5, "propagated.errors");
        return new j.a(d4, c4, f4, e4, g4, b5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        e(name, location);
        return super.a(name, location);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    /* renamed from: a0 */
    public LinkedHashSet<kotlin.reflect.jvm.internal.impl.name.f> o(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar) {
        f0.p(kindFilter, "kindFilter");
        Collection<e0> j4 = D().j().j();
        f0.o(j4, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<kotlin.reflect.jvm.internal.impl.name.f> linkedHashSet = new LinkedHashSet<>();
        for (e0 e0Var : j4) {
            c0.o0(linkedHashSet, e0Var.p().b());
        }
        linkedHashSet.addAll(z().invoke().a());
        linkedHashSet.addAll(z().invoke().b());
        linkedHashSet.addAll(m(kindFilter, lVar));
        linkedHashSet.addAll(x().a().w().e(D()));
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    /* renamed from: b0 */
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a q() {
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a(this.f56826o, a.f56832a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Collection<p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        e(name, location);
        return super.c(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        j2.a.a(x().a().l(), location, D(), name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f h(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        e(name, location);
        g gVar = (g) C();
        kotlin.reflect.jvm.internal.impl.descriptors.impl.g invoke = gVar == null ? null : gVar.f56831t.invoke(name);
        return invoke == null ? this.f56831t.invoke(name) : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> m(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar) {
        Set<kotlin.reflect.jvm.internal.impl.name.f> C;
        f0.p(kindFilter, "kindFilter");
        C = k1.C(this.f56829r.invoke(), this.f56830s.invoke().keySet());
        return C;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void p(@NotNull Collection<u0> result, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        f0.p(result, "result");
        f0.p(name, "name");
        if (this.f56826o.o() && z().invoke().e(name) != null) {
            boolean z3 = true;
            if (!result.isEmpty()) {
                Iterator<T> it = result.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((u0) it.next()).h().isEmpty()) {
                        z3 = false;
                        break;
                    }
                }
            }
            if (z3) {
                m2.w e4 = z().invoke().e(name);
                f0.m(e4);
                result.add(H0(e4));
            }
        }
        x().a().w().d(D(), name, result);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void s(@NotNull Collection<u0> result, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        List F;
        List o4;
        boolean z3;
        f0.p(result, "result");
        f0.p(name, "name");
        Set<u0> y02 = y0(name);
        if (!SpecialGenericSignatures.f56640a.k(name) && !kotlin.reflect.jvm.internal.impl.load.java.e.f56730n.l(name)) {
            if (!(y02 instanceof Collection) || !y02.isEmpty()) {
                for (w wVar : y02) {
                    if (wVar.isSuspend()) {
                        z3 = false;
                        break;
                    }
                }
            }
            z3 = true;
            if (z3) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : y02) {
                    if (C0((u0) obj)) {
                        arrayList.add(obj);
                    }
                }
                W(result, name, arrayList, false);
                return;
            }
        }
        kotlin.reflect.jvm.internal.impl.utils.f a4 = kotlin.reflect.jvm.internal.impl.utils.f.f58554c.a();
        F = CollectionsKt__CollectionsKt.F();
        Collection<? extends u0> d4 = kotlin.reflect.jvm.internal.impl.load.java.components.a.d(name, y02, F, D(), p.f58159a, x().a().k().a());
        f0.o(d4, "resolveOverridesForNonSt\u2026.overridingUtil\n        )");
        X(name, result, d4, result, new b(this));
        X(name, result, d4, a4, new c(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : y02) {
            if (C0((u0) obj2)) {
                arrayList2.add(obj2);
            }
        }
        o4 = kotlin.collections.f0.o4(arrayList2, a4);
        W(result, name, o4, true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void t(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull Collection<p0> result) {
        Set<? extends p0> x3;
        Set C;
        f0.p(name, "name");
        f0.p(result, "result");
        if (this.f56826o.m()) {
            Z(name, result);
        }
        Set<p0> A0 = A0(name);
        if (A0.isEmpty()) {
            return;
        }
        f.b bVar = kotlin.reflect.jvm.internal.impl.utils.f.f58554c;
        kotlin.reflect.jvm.internal.impl.utils.f a4 = bVar.a();
        kotlin.reflect.jvm.internal.impl.utils.f a5 = bVar.a();
        Y(A0, result, a4, new d());
        x3 = k1.x(A0, a4);
        Y(x3, a5, null, new e());
        C = k1.C(A0, a5);
        Collection<? extends p0> d4 = kotlin.reflect.jvm.internal.impl.load.java.components.a.d(name, C, result, D(), x().a().c(), x().a().k().a());
        f0.o(d4, "resolveOverridesForNonSt\u2026rridingUtil\n            )");
        result.addAll(d4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    public String toString() {
        return f0.C("Lazy Java member scope for ", this.f56826o.e());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> u(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar) {
        f0.p(kindFilter, "kindFilter");
        if (this.f56826o.m()) {
            return b();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(z().invoke().c());
        Collection<e0> j4 = D().j().j();
        f0.o(j4, "ownerDescriptor.typeConstructor.supertypes");
        for (e0 e0Var : j4) {
            c0.o0(linkedHashSet, e0Var.p().d());
        }
        return linkedHashSet;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.storage.i<List<kotlin.reflect.jvm.internal.impl.descriptors.c>> x0() {
        return this.f56828q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    /* renamed from: z0 */
    public kotlin.reflect.jvm.internal.impl.descriptors.d D() {
        return this.f56825n;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d ownerDescriptor, @NotNull m2.g jClass, boolean z3, @Nullable g gVar) {
        super(c4, gVar);
        f0.p(c4, "c");
        f0.p(ownerDescriptor, "ownerDescriptor");
        f0.p(jClass, "jClass");
        this.f56825n = ownerDescriptor;
        this.f56826o = jClass;
        this.f56827p = z3;
        this.f56828q = c4.e().g(new f(c4));
        this.f56829r = c4.e().g(new i());
        this.f56830s = c4.e().g(new C1138g());
        this.f56831t = c4.e().e(new j(c4));
    }
}
