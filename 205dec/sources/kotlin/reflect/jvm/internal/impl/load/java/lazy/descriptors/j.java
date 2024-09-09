package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.o0;
import kotlin.collections.y0;
import kotlin.collections.z0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.u;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.c;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.n;
import m2.b0;
import m2.r;
import m2.x;
import m2.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyJavaScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class j extends kotlin.reflect.jvm.internal.impl.resolve.scopes.i {

    /* renamed from: m  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f56869m = {n0.u(new PropertyReference1Impl(n0.d(j.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), n0.u(new PropertyReference1Impl(n0.d(j.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), n0.u(new PropertyReference1Impl(n0.d(j.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.h f56870b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final j f56871c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.k>> f56872d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b> f56873e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, Collection<u0>> f56874f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.f, p0> f56875g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, Collection<u0>> f56876h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56877i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56878j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56879k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, List<p0>> f56880l;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: LazyJavaScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final e0 f56881a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final e0 f56882b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final List<d1> f56883c;
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final List<a1> f56884d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f56885e;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final List<String> f56886f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull e0 returnType, @Nullable e0 e0Var, @NotNull List<? extends d1> valueParameters, @NotNull List<? extends a1> typeParameters, boolean z3, @NotNull List<String> errors) {
            f0.p(returnType, "returnType");
            f0.p(valueParameters, "valueParameters");
            f0.p(typeParameters, "typeParameters");
            f0.p(errors, "errors");
            this.f56881a = returnType;
            this.f56882b = e0Var;
            this.f56883c = valueParameters;
            this.f56884d = typeParameters;
            this.f56885e = z3;
            this.f56886f = errors;
        }

        @NotNull
        public final List<String> a() {
            return this.f56886f;
        }

        public final boolean b() {
            return this.f56885e;
        }

        @Nullable
        public final e0 c() {
            return this.f56882b;
        }

        @NotNull
        public final e0 d() {
            return this.f56881a;
        }

        @NotNull
        public final List<a1> e() {
            return this.f56884d;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return f0.g(this.f56881a, aVar.f56881a) && f0.g(this.f56882b, aVar.f56882b) && f0.g(this.f56883c, aVar.f56883c) && f0.g(this.f56884d, aVar.f56884d) && this.f56885e == aVar.f56885e && f0.g(this.f56886f, aVar.f56886f);
            }
            return false;
        }

        @NotNull
        public final List<d1> f() {
            return this.f56883c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f56881a.hashCode() * 31;
            e0 e0Var = this.f56882b;
            int hashCode2 = (((((hashCode + (e0Var == null ? 0 : e0Var.hashCode())) * 31) + this.f56883c.hashCode()) * 31) + this.f56884d.hashCode()) * 31;
            boolean z3 = this.f56885e;
            int i4 = z3;
            if (z3 != 0) {
                i4 = 1;
            }
            return ((hashCode2 + i4) * 31) + this.f56886f.hashCode();
        }

        @NotNull
        public String toString() {
            return "MethodSignatureData(returnType=" + this.f56881a + ", receiverType=" + this.f56882b + ", valueParameters=" + this.f56883c + ", typeParameters=" + this.f56884d + ", hasStableParameterNames=" + this.f56885e + ", errors=" + this.f56886f + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: LazyJavaScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final List<d1> f56887a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f56888b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull List<? extends d1> descriptors, boolean z3) {
            f0.p(descriptors, "descriptors");
            this.f56887a = descriptors;
            this.f56888b = z3;
        }

        @NotNull
        public final List<d1> a() {
            return this.f56887a;
        }

        public final boolean b() {
            return this.f56888b;
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.k>> {
        c() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> invoke() {
            return j.this.n(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57902o, kotlin.reflect.jvm.internal.impl.resolve.scopes.h.f57927a.a());
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.a<Set<? extends kotlin.reflect.jvm.internal.impl.name.f>> {
        d() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Set<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
            return j.this.m(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57907t, null);
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class e extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, p0> {
        e() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final p0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            f0.p(name, "name");
            if (j.this.C() != null) {
                return (p0) j.this.C().f56875g.invoke(name);
            }
            m2.n f4 = j.this.z().invoke().f(name);
            if (f4 == null || f4.G()) {
                return null;
            }
            return j.this.K(f4);
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class f extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends u0>> {
        f() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Collection<u0> invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            f0.p(name, "name");
            if (j.this.C() != null) {
                return (Collection) j.this.C().f56874f.invoke(name);
            }
            ArrayList arrayList = new ArrayList();
            for (r rVar : j.this.z().invoke().d(name)) {
                kotlin.reflect.jvm.internal.impl.load.java.descriptors.e J = j.this.J(rVar);
                if (j.this.H(J)) {
                    j.this.x().a().h().e(rVar, J);
                    arrayList.add(J);
                }
            }
            j.this.p(arrayList, name);
            return arrayList;
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class g extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b> {
        g() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b invoke() {
            return j.this.q();
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class h extends Lambda implements d2.a<Set<? extends kotlin.reflect.jvm.internal.impl.name.f>> {
        h() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Set<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
            return j.this.o(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57909v, null);
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class i extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends u0>> {
        i() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Collection<u0> invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            List G5;
            f0.p(name, "name");
            LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) j.this.f56874f.invoke(name));
            j.this.M(linkedHashSet);
            j.this.s(linkedHashSet, name);
            G5 = kotlin.collections.f0.G5(j.this.x().a().r().e(j.this.x(), linkedHashSet));
            return G5;
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j$j  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class C1140j extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, List<? extends p0>> {
        C1140j() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final List<p0> invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            List<p0> G5;
            List<p0> G52;
            f0.p(name, "name");
            ArrayList arrayList = new ArrayList();
            kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, j.this.f56875g.invoke(name));
            j.this.t(name, arrayList);
            if (kotlin.reflect.jvm.internal.impl.resolve.d.t(j.this.D())) {
                G52 = kotlin.collections.f0.G5(arrayList);
                return G52;
            }
            G5 = kotlin.collections.f0.G5(j.this.x().a().r().e(j.this.x(), arrayList));
            return G5;
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class k extends Lambda implements d2.a<Set<? extends kotlin.reflect.jvm.internal.impl.name.f>> {
        k() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Set<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
            return j.this.u(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57910w, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class l extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m2.n f56899b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c0 f56900c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(m2.n nVar, c0 c0Var) {
            super(0);
            this.f56899b = nVar;
            this.f56900c = c0Var;
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> invoke() {
            return j.this.x().a().g().a(this.f56899b, this.f56900c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class m extends Lambda implements d2.l<u0, kotlin.reflect.jvm.internal.impl.descriptors.a> {

        /* renamed from: a  reason: collision with root package name */
        public static final m f56901a = new m();

        m() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.a invoke(@NotNull u0 selectMostSpecificInEachOverridableGroup) {
            f0.p(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
            return selectMostSpecificInEachOverridableGroup;
        }
    }

    public /* synthetic */ j(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, j jVar, int i4, u uVar) {
        this(hVar, (i4 & 2) != 0 ? null : jVar);
    }

    private final Set<kotlin.reflect.jvm.internal.impl.name.f> B() {
        return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f56877i, this, f56869m[0]);
    }

    private final Set<kotlin.reflect.jvm.internal.impl.name.f> E() {
        return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f56878j, this, f56869m[1]);
    }

    private final e0 F(m2.n nVar) {
        boolean z3 = false;
        e0 o4 = this.f56870b.g().o(nVar.getType(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.d(TypeUsage.COMMON, false, null, 3, null));
        if ((kotlin.reflect.jvm.internal.impl.builtins.h.q0(o4) || kotlin.reflect.jvm.internal.impl.builtins.h.t0(o4)) && G(nVar) && nVar.M()) {
            z3 = true;
        }
        if (z3) {
            e0 o5 = h1.o(o4);
            f0.o(o5, "makeNotNullable(propertyType)");
            return o5;
        }
        return o4;
    }

    private final boolean G(m2.n nVar) {
        return nVar.isFinal() && nVar.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p0 K(m2.n nVar) {
        List<? extends a1> F;
        c0 v3 = v(nVar);
        v3.Q0(null, null, null, null);
        e0 F2 = F(nVar);
        F = CollectionsKt__CollectionsKt.F();
        v3.W0(F2, F, A(), null);
        if (kotlin.reflect.jvm.internal.impl.resolve.d.K(v3, v3.getType())) {
            v3.G0(this.f56870b.e().i(new l(nVar, v3)));
        }
        this.f56870b.a().h().b(nVar, v3);
        return v3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(Set<u0> set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String c4 = kotlin.reflect.jvm.internal.impl.load.kotlin.u.c((u0) obj, false, false, 2, null);
            Object obj2 = linkedHashMap.get(c4);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(c4, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection<? extends u0> a4 = kotlin.reflect.jvm.internal.impl.resolve.j.a(list, m.f56901a);
                set.removeAll(list);
                set.addAll(a4);
            }
        }
    }

    private final c0 v(m2.n nVar) {
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.f Y0 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.f.Y0(D(), kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(this.f56870b, nVar), Modality.FINAL, kotlin.reflect.jvm.internal.impl.load.java.e0.c(nVar.getVisibility()), !nVar.isFinal(), nVar.getName(), this.f56870b.a().t().a(nVar), G(nVar));
        f0.o(Y0, "create(\n            owne\u2026d.isFinalStatic\n        )");
        return Y0;
    }

    private final Set<kotlin.reflect.jvm.internal.impl.name.f> y() {
        return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f56879k, this, f56869m[2]);
    }

    @Nullable
    protected abstract s0 A();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final j C() {
        return this.f56871c;
    }

    @NotNull
    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.k D();

    protected boolean H(@NotNull kotlin.reflect.jvm.internal.impl.load.java.descriptors.e eVar) {
        f0.p(eVar, "<this>");
        return true;
    }

    @NotNull
    protected abstract a I(@NotNull r rVar, @NotNull List<? extends a1> list, @NotNull e0 e0Var, @NotNull List<? extends d1> list2);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.descriptors.e J(@NotNull r method) {
        int Z;
        Map<? extends a.InterfaceC1126a<?>, ?> z3;
        Object m22;
        f0.p(method, "method");
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.e k12 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.e.k1(D(), kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(this.f56870b, method), method.getName(), this.f56870b.a().t().a(method), this.f56873e.invoke().e(method.getName()) != null && method.h().isEmpty());
        f0.o(k12, "createJavaMethod(\n      \u2026eters.isEmpty()\n        )");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.h f4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.f(this.f56870b, k12, method, 0, 4, null);
        List<y> typeParameters = method.getTypeParameters();
        Z = kotlin.collections.y.Z(typeParameters, 10);
        List<? extends a1> arrayList = new ArrayList<>(Z);
        for (y yVar : typeParameters) {
            a1 a4 = f4.f().a(yVar);
            f0.m(a4);
            arrayList.add(a4);
        }
        b L2 = L(f4, k12, method.h());
        a I = I(method, arrayList, r(method, f4), L2.a());
        e0 c4 = I.c();
        s0 f5 = c4 == null ? null : kotlin.reflect.jvm.internal.impl.resolve.c.f(k12, c4, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b());
        s0 A = A();
        List<a1> e4 = I.e();
        List<d1> f6 = I.f();
        e0 d4 = I.d();
        Modality a5 = Modality.Companion.a(false, method.isAbstract(), !method.isFinal());
        s c5 = kotlin.reflect.jvm.internal.impl.load.java.e0.c(method.getVisibility());
        if (I.c() != null) {
            a.InterfaceC1126a<d1> interfaceC1126a = kotlin.reflect.jvm.internal.impl.load.java.descriptors.e.F;
            m22 = kotlin.collections.f0.m2(L2.a());
            z3 = y0.k(l0.a(interfaceC1126a, m22));
        } else {
            z3 = z0.z();
        }
        k12.j1(f5, A, e4, f6, d4, a5, c5, z3);
        k12.n1(I.b(), L2.b());
        if (!I.a().isEmpty()) {
            f4.a().s().a(k12, I.a());
        }
        return k12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final b L(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, @NotNull w function, @NotNull List<? extends b0> jValueParameters) {
        Iterable<o0> S5;
        int Z;
        List G5;
        Pair a4;
        kotlin.reflect.jvm.internal.impl.name.f name;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4 = hVar;
        f0.p(c4, "c");
        f0.p(function, "function");
        f0.p(jValueParameters, "jValueParameters");
        S5 = kotlin.collections.f0.S5(jValueParameters);
        Z = kotlin.collections.y.Z(S5, 10);
        ArrayList arrayList = new ArrayList(Z);
        boolean z3 = false;
        boolean z4 = false;
        for (o0 o0Var : S5) {
            int a5 = o0Var.a();
            b0 b0Var = (b0) o0Var.b();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f a6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(c4, b0Var);
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a d4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.d(TypeUsage.COMMON, z3, null, 3, null);
            if (b0Var.k()) {
                x type = b0Var.getType();
                m2.f fVar = type instanceof m2.f ? (m2.f) type : null;
                if (fVar != null) {
                    e0 k4 = hVar.g().k(fVar, d4, true);
                    a4 = l0.a(k4, hVar.d().k().k(k4));
                } else {
                    throw new AssertionError(f0.C("Vararg parameter should be an array: ", b0Var));
                }
            } else {
                a4 = l0.a(hVar.g().o(b0Var.getType(), d4), null);
            }
            e0 e0Var = (e0) a4.component1();
            e0 e0Var2 = (e0) a4.component2();
            if (f0.g(function.getName().b(), "equals") && jValueParameters.size() == 1 && f0.g(hVar.d().k().I(), e0Var)) {
                name = kotlin.reflect.jvm.internal.impl.name.f.f("other");
            } else {
                name = b0Var.getName();
                if (name == null) {
                    z4 = true;
                }
                if (name == null) {
                    name = kotlin.reflect.jvm.internal.impl.name.f.f(f0.C("p", Integer.valueOf(a5)));
                    f0.o(name, "identifier(\"p$index\")");
                }
            }
            kotlin.reflect.jvm.internal.impl.name.f fVar2 = name;
            f0.o(fVar2, "if (function.name.asStri\u2026(\"p$index\")\n            }");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.l0(function, null, a5, a6, fVar2, e0Var, false, false, false, e0Var2, hVar.a().t().a(b0Var)));
            arrayList = arrayList2;
            z4 = z4;
            z3 = false;
            c4 = hVar;
        }
        G5 = kotlin.collections.f0.G5(arrayList);
        return new b(G5, z4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        List F;
        f0.p(name, "name");
        f0.p(location, "location");
        if (b().contains(name)) {
            return this.f56876h.invoke(name);
        }
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        return B();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Collection<p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        List F;
        f0.p(name, "name");
        f0.p(location, "location");
        if (d().contains(name)) {
            return this.f56880l.invoke(name);
        }
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        return E();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        f0.p(kindFilter, "kindFilter");
        f0.p(nameFilter, "nameFilter");
        return this.f56872d.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
        return y();
    }

    @NotNull
    protected abstract Set<kotlin.reflect.jvm.internal.impl.name.f> m(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, @Nullable d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar);

    @NotNull
    protected final List<kotlin.reflect.jvm.internal.impl.descriptors.k> n(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.k> G5;
        f0.p(kindFilter, "kindFilter");
        f0.p(nameFilter, "nameFilter");
        NoLookupLocation noLookupLocation = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57890c.c())) {
            for (kotlin.reflect.jvm.internal.impl.name.f fVar : m(kindFilter, nameFilter)) {
                if (nameFilter.invoke(fVar).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.a.a(linkedHashSet, h(fVar, noLookupLocation));
                }
            }
        }
        if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57890c.d()) && !kindFilter.l().contains(c.a.f57887a)) {
            for (kotlin.reflect.jvm.internal.impl.name.f fVar2 : o(kindFilter, nameFilter)) {
                if (nameFilter.invoke(fVar2).booleanValue()) {
                    linkedHashSet.addAll(a(fVar2, noLookupLocation));
                }
            }
        }
        if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57890c.i()) && !kindFilter.l().contains(c.a.f57887a)) {
            for (kotlin.reflect.jvm.internal.impl.name.f fVar3 : u(kindFilter, nameFilter)) {
                if (nameFilter.invoke(fVar3).booleanValue()) {
                    linkedHashSet.addAll(c(fVar3, noLookupLocation));
                }
            }
        }
        G5 = kotlin.collections.f0.G5(linkedHashSet);
        return G5;
    }

    @NotNull
    protected abstract Set<kotlin.reflect.jvm.internal.impl.name.f> o(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, @Nullable d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar);

    protected void p(@NotNull Collection<u0> result, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        f0.p(result, "result");
        f0.p(name, "name");
    }

    @NotNull
    protected abstract kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b q();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final e0 r(@NotNull r method, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4) {
        f0.p(method, "method");
        f0.p(c4, "c");
        return c4.g().o(method.getReturnType(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.d(TypeUsage.COMMON, method.N().m(), null, 2, null));
    }

    protected abstract void s(@NotNull Collection<u0> collection, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

    protected abstract void t(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Collection<p0> collection);

    @NotNull
    public String toString() {
        return f0.C("Lazy scope for ", D());
    }

    @NotNull
    protected abstract Set<kotlin.reflect.jvm.internal.impl.name.f> u(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, @Nullable d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final kotlin.reflect.jvm.internal.impl.storage.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.k>> w() {
        return this.f56872d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.h x() {
        return this.f56870b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final kotlin.reflect.jvm.internal.impl.storage.i<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b> z() {
        return this.f56873e;
    }

    public j(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4, @Nullable j jVar) {
        List F;
        f0.p(c4, "c");
        this.f56870b = c4;
        this.f56871c = jVar;
        kotlin.reflect.jvm.internal.impl.storage.n e4 = c4.e();
        c cVar = new c();
        F = CollectionsKt__CollectionsKt.F();
        this.f56872d = e4.h(cVar, F);
        this.f56873e = c4.e().g(new g());
        this.f56874f = c4.e().c(new f());
        this.f56875g = c4.e().e(new e());
        this.f56876h = c4.e().c(new i());
        this.f56877i = c4.e().g(new h());
        this.f56878j = c4.e().g(new k());
        this.f56879k = c4.e().g(new d());
        this.f56880l = c4.e().c(new C1140j());
    }
}
