package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.types.w0;
import org.jetbrains.annotations.NotNull;

/* compiled from: TypeAliasExpander.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u0 {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final a f58428c = new a(null);
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final u0 f58429d = new u0(w0.a.f58454a, false);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final w0 f58430a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f58431b;

    /* compiled from: TypeAliasExpander.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i4, kotlin.reflect.jvm.internal.impl.descriptors.z0 z0Var) {
            if (i4 > 100) {
                throw new AssertionError(kotlin.jvm.internal.f0.C("Too deep recursion while expanding type alias ", z0Var.getName()));
            }
        }
    }

    public u0(@NotNull w0 reportStrategy, boolean z3) {
        kotlin.jvm.internal.f0.p(reportStrategy, "reportStrategy");
        this.f58430a = reportStrategy;
        this.f58431b = z3;
    }

    private final void a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar2) {
        HashSet hashSet = new HashSet();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = fVar.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().e());
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar : fVar2) {
            if (hashSet.contains(cVar.e())) {
                this.f58430a.c(cVar);
            }
        }
    }

    private final void b(e0 e0Var, e0 e0Var2) {
        f1 f4 = f1.f(e0Var2);
        kotlin.jvm.internal.f0.o(f4, "create(substitutedType)");
        int i4 = 0;
        for (Object obj : e0Var2.G0()) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.X();
            }
            a1 a1Var = (a1) obj;
            if (!a1Var.b()) {
                e0 type = a1Var.getType();
                kotlin.jvm.internal.f0.o(type, "substitutedArgument.type");
                if (!kotlin.reflect.jvm.internal.impl.types.typeUtil.a.d(type)) {
                    a1 a1Var2 = e0Var.G0().get(i4);
                    kotlin.reflect.jvm.internal.impl.descriptors.a1 typeParameter = e0Var.H0().getParameters().get(i4);
                    if (this.f58431b) {
                        w0 w0Var = this.f58430a;
                        e0 type2 = a1Var2.getType();
                        kotlin.jvm.internal.f0.o(type2, "unsubstitutedArgument.type");
                        e0 type3 = a1Var.getType();
                        kotlin.jvm.internal.f0.o(type3, "substitutedArgument.type");
                        kotlin.jvm.internal.f0.o(typeParameter, "typeParameter");
                        w0Var.a(f4, type2, type3, typeParameter);
                    }
                }
            }
            i4 = i5;
        }
    }

    private final t c(t tVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
        return tVar.N0(h(tVar, fVar));
    }

    private final m0 d(m0 m0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
        return g0.a(m0Var) ? m0Var : e1.f(m0Var, null, h(m0Var, fVar), 1, null);
    }

    private final m0 e(m0 m0Var, e0 e0Var) {
        m0 s3 = h1.s(m0Var, e0Var.I0());
        kotlin.jvm.internal.f0.o(s3, "makeNullableIfNeeded(thi\u2026romType.isMarkedNullable)");
        return s3;
    }

    private final m0 f(m0 m0Var, e0 e0Var) {
        return d(e(m0Var, e0Var), e0Var.getAnnotations());
    }

    private final m0 g(v0 v0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3) {
        y0 j4 = v0Var.b().j();
        kotlin.jvm.internal.f0.o(j4, "descriptor.typeConstructor");
        return f0.l(fVar, j4, v0Var.a(), z3, h.c.f57931b);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f h(e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
        return g0.a(e0Var) ? e0Var.getAnnotations() : kotlin.reflect.jvm.internal.impl.descriptors.annotations.h.a(fVar, e0Var.getAnnotations());
    }

    private final a1 j(a1 a1Var, v0 v0Var, int i4) {
        int Z;
        l1 K0 = a1Var.getType().K0();
        if (u.a(K0)) {
            return a1Var;
        }
        m0 a4 = e1.a(K0);
        if (g0.a(a4) || !kotlin.reflect.jvm.internal.impl.types.typeUtil.a.u(a4)) {
            return a1Var;
        }
        y0 H0 = a4.H0();
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = H0.b();
        H0.getParameters().size();
        a4.G0().size();
        if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1) {
            return a1Var;
        }
        if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.z0) {
            kotlin.reflect.jvm.internal.impl.descriptors.z0 z0Var = (kotlin.reflect.jvm.internal.impl.descriptors.z0) b4;
            if (v0Var.d(z0Var)) {
                this.f58430a.b(z0Var);
                return new c1(Variance.INVARIANT, w.j(kotlin.jvm.internal.f0.C("Recursive type alias: ", z0Var.getName())));
            }
            List<a1> G0 = a4.G0();
            Z = kotlin.collections.y.Z(G0, 10);
            ArrayList arrayList = new ArrayList(Z);
            int i5 = 0;
            for (Object obj : G0) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt__CollectionsKt.X();
                }
                arrayList.add(l((a1) obj, v0Var, H0.getParameters().get(i5), i4 + 1));
                i5 = i6;
            }
            m0 k4 = k(v0.f58437e.a(v0Var, z0Var, arrayList), a4.getAnnotations(), a4.I0(), i4 + 1, false);
            m0 m4 = m(a4, v0Var, i4);
            if (!u.a(k4)) {
                k4 = p0.j(k4, m4);
            }
            return new c1(a1Var.c(), k4);
        }
        m0 m5 = m(a4, v0Var, i4);
        b(a4, m5);
        return new c1(a1Var.c(), m5);
    }

    private final m0 k(v0 v0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, int i4, boolean z4) {
        a1 l4 = l(new c1(Variance.INVARIANT, v0Var.b().r0()), v0Var, null, i4);
        e0 type = l4.getType();
        kotlin.jvm.internal.f0.o(type, "expandedProjection.type");
        m0 a4 = e1.a(type);
        if (g0.a(a4)) {
            return a4;
        }
        l4.c();
        a(a4.getAnnotations(), fVar);
        m0 s3 = h1.s(d(a4, fVar), z3);
        kotlin.jvm.internal.f0.o(s3, "expandedType.combineAnno\u2026fNeeded(it, isNullable) }");
        return z4 ? p0.j(s3, g(v0Var, fVar, z3)) : s3;
    }

    private final a1 l(a1 a1Var, v0 v0Var, kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var2, int i4) {
        e0 f4;
        Variance variance;
        Variance variance2;
        f58428c.b(i4, v0Var.b());
        if (a1Var.b()) {
            kotlin.jvm.internal.f0.m(a1Var2);
            a1 t3 = h1.t(a1Var2);
            kotlin.jvm.internal.f0.o(t3, "makeStarProjection(typeParameterDescriptor!!)");
            return t3;
        }
        e0 type = a1Var.getType();
        kotlin.jvm.internal.f0.o(type, "underlyingProjection.type");
        a1 c4 = v0Var.c(type.H0());
        if (c4 == null) {
            return j(a1Var, v0Var, i4);
        }
        if (c4.b()) {
            kotlin.jvm.internal.f0.m(a1Var2);
            a1 t4 = h1.t(a1Var2);
            kotlin.jvm.internal.f0.o(t4, "makeStarProjection(typeParameterDescriptor!!)");
            return t4;
        }
        l1 K0 = c4.getType().K0();
        Variance c5 = c4.c();
        kotlin.jvm.internal.f0.o(c5, "argument.projectionKind");
        Variance c6 = a1Var.c();
        kotlin.jvm.internal.f0.o(c6, "underlyingProjection.projectionKind");
        if (c6 != c5 && c6 != (variance2 = Variance.INVARIANT)) {
            if (c5 == variance2) {
                c5 = c6;
            } else {
                this.f58430a.d(v0Var.b(), a1Var2, K0);
            }
        }
        Variance o4 = a1Var2 == null ? Variance.INVARIANT : a1Var2.o();
        kotlin.jvm.internal.f0.o(o4, "typeParameterDescriptor?\u2026nce ?: Variance.INVARIANT");
        if (o4 != c5 && o4 != (variance = Variance.INVARIANT)) {
            if (c5 == variance) {
                c5 = variance;
            } else {
                this.f58430a.d(v0Var.b(), a1Var2, K0);
            }
        }
        a(type.getAnnotations(), K0.getAnnotations());
        if (K0 instanceof t) {
            f4 = c((t) K0, type.getAnnotations());
        } else {
            f4 = f(e1.a(K0), type);
        }
        return new c1(c5, f4);
    }

    private final m0 m(m0 m0Var, v0 v0Var, int i4) {
        int Z;
        y0 H0 = m0Var.H0();
        List<a1> G0 = m0Var.G0();
        Z = kotlin.collections.y.Z(G0, 10);
        ArrayList arrayList = new ArrayList(Z);
        int i5 = 0;
        for (Object obj : G0) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt__CollectionsKt.X();
            }
            a1 a1Var = (a1) obj;
            a1 l4 = l(a1Var, v0Var, H0.getParameters().get(i5), i4 + 1);
            if (!l4.b()) {
                l4 = new c1(l4.c(), h1.r(l4.getType(), a1Var.getType().I0()));
            }
            arrayList.add(l4);
            i5 = i6;
        }
        return e1.f(m0Var, arrayList, null, 2, null);
    }

    @NotNull
    public final m0 i(@NotNull v0 typeAliasExpansion, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations) {
        kotlin.jvm.internal.f0.p(typeAliasExpansion, "typeAliasExpansion");
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        return k(typeAliasExpansion, annotations, false, 0, true);
    }
}
