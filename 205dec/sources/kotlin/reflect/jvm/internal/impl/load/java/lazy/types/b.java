package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.y;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.l;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.y0;
import m2.a0;
import m2.c0;
import m2.g;
import m2.i;
import m2.j;
import m2.v;
import m2.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaTypeResolver.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final h f56941a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final l f56942b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final f f56943c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final d f56944d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JavaTypeResolver.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.a<e0> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a1 f56946b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j f56947c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a f56948d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ y0 f56949e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(a1 a1Var, j jVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, y0 y0Var) {
            super(0);
            this.f56946b = a1Var;
            this.f56947c = jVar;
            this.f56948d = aVar;
            this.f56949e = y0Var;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final e0 invoke() {
            f fVar = b.this.f56943c;
            a1 a1Var = this.f56946b;
            boolean s3 = this.f56947c.s();
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar = this.f56948d;
            kotlin.reflect.jvm.internal.impl.descriptors.f b4 = this.f56949e.b();
            e0 c4 = fVar.c(a1Var, s3, aVar.h(b4 == null ? null : b4.q()));
            f0.o(c4, "typeParameterUpperBoundE\u2026efaultType)\n            )");
            return c4;
        }
    }

    public b(@NotNull h c4, @NotNull l typeParameterResolver) {
        f0.p(c4, "c");
        f0.p(typeParameterResolver, "typeParameterResolver");
        this.f56941a = c4;
        this.f56942b = typeParameterResolver;
        f fVar = new f(null, 1, null);
        this.f56943c = fVar;
        this.f56944d = new d(fVar);
    }

    private final boolean b(j jVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        Object g32;
        Object g33;
        g32 = kotlin.collections.f0.g3(jVar.x());
        if (a0.a((x) g32)) {
            List<a1> parameters = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f56177a.b(dVar).j().getParameters();
            f0.o(parameters, "JavaToKotlinClassMapper.\u2026ypeConstructor.parameters");
            g33 = kotlin.collections.f0.g3(parameters);
            a1 a1Var = (a1) g33;
            if (a1Var == null) {
                return false;
            }
            Variance o4 = a1Var.o();
            f0.o(o4, "JavaToKotlinClassMapper.\u2026.variance ?: return false");
            return o4 != Variance.OUT_VARIANCE;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
        if ((!r0.isEmpty()) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.a1> c(m2.j r7, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a r8, kotlin.reflect.jvm.internal.impl.types.y0 r9) {
        /*
            r6 = this;
            boolean r0 = r7.s()
            r1 = 0
            java.lang.String r2 = "constructor.parameters"
            r3 = 1
            if (r0 != 0) goto L24
            java.util.List r0 = r7.x()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L23
            java.util.List r0 = r9.getParameters()
            kotlin.jvm.internal.f0.o(r0, r2)
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r3
            if (r0 == 0) goto L23
            goto L24
        L23:
            r3 = 0
        L24:
            java.util.List r0 = r9.getParameters()
            kotlin.jvm.internal.f0.o(r0, r2)
            if (r3 == 0) goto L32
            java.util.List r7 = r6.d(r7, r0, r9, r8)
            return r7
        L32:
            int r8 = r0.size()
            java.util.List r9 = r7.x()
            int r9 = r9.size()
            r2 = 10
            if (r8 == r9) goto L75
            java.util.ArrayList r7 = new java.util.ArrayList
            int r8 = kotlin.collections.w.Z(r0, r2)
            r7.<init>(r8)
            java.util.Iterator r8 = r0.iterator()
        L4f:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L70
            java.lang.Object r9 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.a1 r9 = (kotlin.reflect.jvm.internal.impl.descriptors.a1) r9
            kotlin.reflect.jvm.internal.impl.types.c1 r0 = new kotlin.reflect.jvm.internal.impl.types.c1
            kotlin.reflect.jvm.internal.impl.name.f r9 = r9.getName()
            java.lang.String r9 = r9.b()
            kotlin.reflect.jvm.internal.impl.types.m0 r9 = kotlin.reflect.jvm.internal.impl.types.w.j(r9)
            r0.<init>(r9)
            r7.add(r0)
            goto L4f
        L70:
            java.util.List r7 = kotlin.collections.w.G5(r7)
            return r7
        L75:
            java.util.List r7 = r7.x()
            java.lang.Iterable r7 = kotlin.collections.w.S5(r7)
            java.util.ArrayList r8 = new java.util.ArrayList
            int r9 = kotlin.collections.w.Z(r7, r2)
            r8.<init>(r9)
            java.util.Iterator r7 = r7.iterator()
        L8a:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto Lbe
            java.lang.Object r9 = r7.next()
            kotlin.collections.o0 r9 = (kotlin.collections.o0) r9
            int r2 = r9.a()
            java.lang.Object r9 = r9.b()
            m2.x r9 = (m2.x) r9
            r0.size()
            java.lang.Object r2 = r0.get(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.a1 r2 = (kotlin.reflect.jvm.internal.impl.descriptors.a1) r2
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r3 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r4 = 3
            r5 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a r3 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.d(r3, r1, r5, r4, r5)
            java.lang.String r4 = "parameter"
            kotlin.jvm.internal.f0.o(r2, r4)
            kotlin.reflect.jvm.internal.impl.types.a1 r9 = r6.p(r9, r3, r2)
            r8.add(r9)
            goto L8a
        Lbe:
            java.util.List r7 = kotlin.collections.w.G5(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.c(m2.j, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a, kotlin.reflect.jvm.internal.impl.types.y0):java.util.List");
    }

    private final List<kotlin.reflect.jvm.internal.impl.types.a1> d(j jVar, List<? extends a1> list, y0 y0Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        int Z;
        kotlin.reflect.jvm.internal.impl.types.a1 j4;
        Z = y.Z(list, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (a1 a1Var : list) {
            if (kotlin.reflect.jvm.internal.impl.types.typeUtil.a.k(a1Var, null, aVar.f())) {
                j4 = c.b(a1Var, aVar);
            } else {
                j4 = this.f56944d.j(a1Var, jVar.s() ? aVar : aVar.i(JavaTypeFlexibility.INFLEXIBLE), new h0(this.f56941a.e(), new a(a1Var, jVar, aVar, y0Var)));
            }
            arrayList.add(j4);
        }
        return arrayList;
    }

    private final m0 e(j jVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, m0 m0Var) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f eVar = m0Var == null ? new kotlin.reflect.jvm.internal.impl.load.java.lazy.e(this.f56941a, jVar, false, 4, null) : m0Var.getAnnotations();
        y0 f4 = f(jVar, aVar);
        if (f4 == null) {
            return null;
        }
        boolean i4 = i(aVar);
        if (f0.g(m0Var != null ? m0Var.H0() : null, f4) && !jVar.s() && i4) {
            return m0Var.O0(true);
        }
        return kotlin.reflect.jvm.internal.impl.types.f0.j(eVar, f4, c(jVar, aVar, f4), i4, null, 16, null);
    }

    private final y0 f(j jVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        i a4 = jVar.a();
        if (a4 == null) {
            return g(jVar);
        }
        if (a4 instanceof g) {
            g gVar = (g) a4;
            kotlin.reflect.jvm.internal.impl.name.c e4 = gVar.e();
            if (e4 != null) {
                kotlin.reflect.jvm.internal.impl.descriptors.d j4 = j(jVar, aVar, e4);
                if (j4 == null) {
                    j4 = this.f56941a.a().n().a(gVar);
                }
                return j4 == null ? g(jVar) : j4.j();
            }
            throw new AssertionError(f0.C("Class type should have a FQ name: ", a4));
        } else if (a4 instanceof m2.y) {
            a1 a5 = this.f56942b.a((m2.y) a4);
            if (a5 == null) {
                return null;
            }
            return a5.j();
        } else {
            throw new IllegalStateException(f0.C("Unknown classifier kind: ", a4));
        }
    }

    private final y0 g(j jVar) {
        List<Integer> l4;
        kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c(jVar.E()));
        f0.o(m4, "topLevel(FqName(javaType.classifierQualifiedName))");
        kotlin.reflect.jvm.internal.impl.descriptors.f0 q3 = this.f56941a.a().b().e().q();
        l4 = kotlin.collections.x.l(0);
        y0 j4 = q3.d(m4, l4).j();
        f0.o(j4, "c.components.deserialize\u2026istOf(0)).typeConstructor");
        return j4;
    }

    private final boolean h(Variance variance, a1 a1Var) {
        return (a1Var.o() == Variance.INVARIANT || variance == a1Var.o()) ? false : true;
    }

    private final boolean i(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        return (aVar.d() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || aVar.g() || aVar.e() == TypeUsage.SUPERTYPE) ? false : true;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d j(j jVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, kotlin.reflect.jvm.internal.impl.name.c cVar) {
        if (aVar.g() && f0.g(cVar, c.a())) {
            return this.f56941a.a().p().c();
        }
        kotlin.reflect.jvm.internal.impl.builtins.jvm.d dVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f56177a;
        kotlin.reflect.jvm.internal.impl.descriptors.d h4 = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.h(dVar, cVar, this.f56941a.d().k(), null, 4, null);
        if (h4 == null) {
            return null;
        }
        return (dVar.e(h4) && (aVar.d() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || aVar.e() == TypeUsage.SUPERTYPE || b(jVar, h4))) ? dVar.b(h4) : h4;
    }

    public static /* synthetic */ e0 l(b bVar, m2.f fVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, boolean z3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return bVar.k(fVar, aVar, z3);
    }

    private final e0 m(j jVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        boolean z3 = (aVar.g() || aVar.e() == TypeUsage.SUPERTYPE) ? false : true;
        boolean s3 = jVar.s();
        if (!s3 && !z3) {
            m0 e4 = e(jVar, aVar, null);
            return e4 == null ? n(jVar) : e4;
        }
        m0 e5 = e(jVar, aVar.i(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (e5 == null) {
            return n(jVar);
        }
        m0 e6 = e(jVar, aVar.i(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), e5);
        if (e6 == null) {
            return n(jVar);
        }
        if (s3) {
            return new e(e5, e6);
        }
        return kotlin.reflect.jvm.internal.impl.types.f0.d(e5, e6);
    }

    private static final m0 n(j jVar) {
        m0 j4 = w.j(f0.C("Unresolved java class ", jVar.C()));
        f0.o(j4, "createErrorType(\"Unresol\u2026vaType.presentableText}\")");
        return j4;
    }

    private final kotlin.reflect.jvm.internal.impl.types.a1 p(x xVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, a1 a1Var) {
        if (xVar instanceof c0) {
            c0 c0Var = (c0) xVar;
            x bound = c0Var.getBound();
            Variance variance = c0Var.J() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
            if (bound != null && !h(variance, a1Var)) {
                return kotlin.reflect.jvm.internal.impl.types.typeUtil.a.e(o(bound, c.d(TypeUsage.COMMON, false, null, 3, null)), variance, a1Var);
            }
            return c.b(a1Var, aVar);
        }
        return new c1(Variance.INVARIANT, o(xVar, aVar));
    }

    @NotNull
    public final e0 k(@NotNull m2.f arrayType, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a attr, boolean z3) {
        List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> k4;
        f0.p(arrayType, "arrayType");
        f0.p(attr, "attr");
        x l4 = arrayType.l();
        v vVar = l4 instanceof v ? (v) l4 : null;
        PrimitiveType type = vVar == null ? null : vVar.getType();
        kotlin.reflect.jvm.internal.impl.load.java.lazy.e eVar = new kotlin.reflect.jvm.internal.impl.load.java.lazy.e(this.f56941a, arrayType, true);
        if (type != null) {
            m0 O = this.f56941a.d().k().O(type);
            f0.o(O, "c.module.builtIns.getPri\u2026KotlinType(primitiveType)");
            f.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0;
            k4 = kotlin.collections.f0.k4(eVar, O.getAnnotations());
            O.P0(aVar.a(k4));
            return attr.g() ? O : kotlin.reflect.jvm.internal.impl.types.f0.d(O, O.O0(true));
        }
        e0 o4 = o(l4, c.d(TypeUsage.COMMON, attr.g(), null, 2, null));
        if (attr.g()) {
            m0 m4 = this.f56941a.d().k().m(z3 ? Variance.OUT_VARIANCE : Variance.INVARIANT, o4, eVar);
            f0.o(m4, "c.module.builtIns.getArr\u2026mponentType, annotations)");
            return m4;
        }
        m0 m5 = this.f56941a.d().k().m(Variance.INVARIANT, o4, eVar);
        f0.o(m5, "c.module.builtIns.getArr\u2026mponentType, annotations)");
        return kotlin.reflect.jvm.internal.impl.types.f0.d(m5, this.f56941a.d().k().m(Variance.OUT_VARIANCE, o4, eVar).O0(true));
    }

    @NotNull
    public final e0 o(@Nullable x xVar, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a attr) {
        m0 Z;
        f0.p(attr, "attr");
        if (xVar instanceof v) {
            PrimitiveType type = ((v) xVar).getType();
            if (type != null) {
                Z = this.f56941a.d().k().R(type);
            } else {
                Z = this.f56941a.d().k().Z();
            }
            f0.o(Z, "{\n                val pr\u2026ns.unitType\n            }");
            return Z;
        } else if (xVar instanceof j) {
            return m((j) xVar, attr);
        } else {
            if (xVar instanceof m2.f) {
                return l(this, (m2.f) xVar, attr, false, 4, null);
            }
            if (!(xVar instanceof c0)) {
                if (xVar == null) {
                    m0 y3 = this.f56941a.d().k().y();
                    f0.o(y3, "c.module.builtIns.defaultBound");
                    return y3;
                }
                throw new UnsupportedOperationException(f0.C("Unsupported type: ", xVar));
            }
            x bound = ((c0) xVar).getBound();
            if (bound == null) {
                m0 y4 = this.f56941a.d().k().y();
                f0.o(y4, "c.module.builtIns.defaultBound");
                return y4;
            }
            return o(bound, attr);
        }
    }
}
