package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import d2.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.o0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.h;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.checker.e;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.j1;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.r0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.y;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r2.t;

/* compiled from: TypeUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {

    /* compiled from: TypeUtils.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.types.typeUtil.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class C1184a extends Lambda implements l<l1, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final C1184a f58417a = new C1184a();

        C1184a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull l1 it) {
            f0.p(it, "it");
            f b4 = it.H0().b();
            return Boolean.valueOf(b4 == null ? false : a.n(b4));
        }
    }

    /* compiled from: TypeUtils.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements l<l1, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f58418a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull l1 it) {
            f0.p(it, "it");
            f b4 = it.H0().b();
            boolean z3 = false;
            if (b4 != null && ((b4 instanceof z0) || (b4 instanceof a1))) {
                z3 = true;
            }
            return Boolean.valueOf(z3);
        }
    }

    /* compiled from: TypeUtils.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements l<l1, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f58419a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull l1 it) {
            f0.p(it, "it");
            return Boolean.valueOf((it instanceof t0) || (it.H0() instanceof t) || g0.a(it));
        }
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.types.a1 a(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        return new c1(e0Var);
    }

    public static final boolean b(@NotNull e0 e0Var, @NotNull l<? super l1, Boolean> predicate) {
        f0.p(e0Var, "<this>");
        f0.p(predicate, "predicate");
        return h1.c(e0Var, predicate);
    }

    private static final boolean c(e0 e0Var, y0 y0Var, Set<? extends a1> set) {
        Iterable<o0> S5;
        Object H2;
        a1 a1Var;
        boolean z3;
        if (f0.g(e0Var.H0(), y0Var)) {
            return true;
        }
        f b4 = e0Var.H0().b();
        g gVar = b4 instanceof g ? (g) b4 : null;
        List<a1> r3 = gVar == null ? null : gVar.r();
        S5 = kotlin.collections.f0.S5(e0Var.G0());
        if (!(S5 instanceof Collection) || !((Collection) S5).isEmpty()) {
            for (o0 o0Var : S5) {
                int a4 = o0Var.a();
                kotlin.reflect.jvm.internal.impl.types.a1 a1Var2 = (kotlin.reflect.jvm.internal.impl.types.a1) o0Var.b();
                if (r3 == null) {
                    a1Var = null;
                } else {
                    H2 = kotlin.collections.f0.H2(r3, a4);
                    a1Var = (a1) H2;
                }
                if (((a1Var == null || set == null || !set.contains(a1Var)) ? false : true) || a1Var2.b()) {
                    z3 = false;
                    continue;
                } else {
                    e0 type = a1Var2.getType();
                    f0.o(type, "argument.type");
                    z3 = c(type, y0Var, set);
                    continue;
                }
                if (z3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean d(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        return b(e0Var, C1184a.f58417a);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.types.a1 e(@NotNull e0 type, @NotNull Variance projectionKind, @Nullable a1 a1Var) {
        f0.p(type, "type");
        f0.p(projectionKind, "projectionKind");
        if ((a1Var == null ? null : a1Var.o()) == projectionKind) {
            projectionKind = Variance.INVARIANT;
        }
        return new c1(projectionKind, type);
    }

    @NotNull
    public static final Set<a1> f(@NotNull e0 e0Var, @Nullable Set<? extends a1> set) {
        f0.p(e0Var, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        g(e0Var, e0Var, linkedHashSet, set);
        return linkedHashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void g(e0 e0Var, e0 e0Var2, Set<a1> set, Set<? extends a1> set2) {
        Object H2;
        a1 a1Var;
        boolean H1;
        f b4 = e0Var.H0().b();
        if (b4 instanceof a1) {
            if (!f0.g(e0Var.H0(), e0Var2.H0())) {
                set.add(b4);
                return;
            }
            for (e0 upperBound : ((a1) b4).getUpperBounds()) {
                f0.o(upperBound, "upperBound");
                g(upperBound, e0Var2, set, set2);
            }
            return;
        }
        f b5 = e0Var.H0().b();
        g gVar = b5 instanceof g ? (g) b5 : null;
        List<a1> r3 = gVar == null ? null : gVar.r();
        int i4 = 0;
        for (kotlin.reflect.jvm.internal.impl.types.a1 a1Var2 : e0Var.G0()) {
            int i5 = i4 + 1;
            if (r3 == null) {
                a1Var = null;
            } else {
                H2 = kotlin.collections.f0.H2(r3, i4);
                a1Var = (a1) H2;
            }
            if (!((a1Var == null || set2 == null || !set2.contains(a1Var)) ? false : true) && !a1Var2.b()) {
                H1 = kotlin.collections.f0.H1(set, a1Var2.getType().H0().b());
                if (!H1 && !f0.g(a1Var2.getType().H0(), e0Var2.H0())) {
                    e0 type = a1Var2.getType();
                    f0.o(type, "argument.type");
                    g(type, e0Var2, set, set2);
                }
            }
            i4 = i5;
        }
    }

    @NotNull
    public static final h h(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        h k4 = e0Var.H0().k();
        f0.o(k4, "constructor.builtIns");
        return k4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
        r3 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051 A[EDGE_INSN: B:22:0x0051->B:18:0x0051 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0023  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.reflect.jvm.internal.impl.types.e0 i(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.a1 r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.f0.p(r7, r0)
            java.util.List r0 = r7.getUpperBounds()
            java.lang.String r1 = "upperBounds"
            kotlin.jvm.internal.f0.o(r0, r1)
            r0.isEmpty()
            java.util.List r0 = r7.getUpperBounds()
            kotlin.jvm.internal.f0.o(r0, r1)
            java.util.Iterator r0 = r0.iterator()
        L1c:
            boolean r2 = r0.hasNext()
            r3 = 0
            if (r2 == 0) goto L51
            java.lang.Object r2 = r0.next()
            r4 = r2
            kotlin.reflect.jvm.internal.impl.types.e0 r4 = (kotlin.reflect.jvm.internal.impl.types.e0) r4
            kotlin.reflect.jvm.internal.impl.types.y0 r4 = r4.H0()
            kotlin.reflect.jvm.internal.impl.descriptors.f r4 = r4.b()
            boolean r5 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d
            if (r5 == 0) goto L39
            r3 = r4
            kotlin.reflect.jvm.internal.impl.descriptors.d r3 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r3
        L39:
            r4 = 0
            if (r3 != 0) goto L3d
            goto L4e
        L3d:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = r3.i()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r6 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE
            if (r5 == r6) goto L4e
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r3 = r3.i()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS
            if (r3 == r5) goto L4e
            r4 = 1
        L4e:
            if (r4 == 0) goto L1c
            r3 = r2
        L51:
            kotlin.reflect.jvm.internal.impl.types.e0 r3 = (kotlin.reflect.jvm.internal.impl.types.e0) r3
            if (r3 != 0) goto L68
            java.util.List r7 = r7.getUpperBounds()
            kotlin.jvm.internal.f0.o(r7, r1)
            java.lang.Object r7 = kotlin.collections.w.m2(r7)
            java.lang.String r0 = "upperBounds.first()"
            kotlin.jvm.internal.f0.o(r7, r0)
            r3 = r7
            kotlin.reflect.jvm.internal.impl.types.e0 r3 = (kotlin.reflect.jvm.internal.impl.types.e0) r3
        L68:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.a.i(kotlin.reflect.jvm.internal.impl.descriptors.a1):kotlin.reflect.jvm.internal.impl.types.e0");
    }

    @JvmOverloads
    public static final boolean j(@NotNull a1 typeParameter) {
        f0.p(typeParameter, "typeParameter");
        return l(typeParameter, null, null, 6, null);
    }

    @JvmOverloads
    public static final boolean k(@NotNull a1 typeParameter, @Nullable y0 y0Var, @Nullable Set<? extends a1> set) {
        boolean z3;
        f0.p(typeParameter, "typeParameter");
        List<e0> upperBounds = typeParameter.getUpperBounds();
        f0.o(upperBounds, "typeParameter.upperBounds");
        if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
            for (e0 upperBound : upperBounds) {
                f0.o(upperBound, "upperBound");
                if (c(upperBound, typeParameter.q().H0(), set) && (y0Var == null || f0.g(upperBound.H0(), y0Var))) {
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
        }
        return false;
    }

    public static /* synthetic */ boolean l(a1 a1Var, y0 y0Var, Set set, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            y0Var = null;
        }
        if ((i4 & 4) != 0) {
            set = null;
        }
        return k(a1Var, y0Var, set);
    }

    public static final boolean m(@NotNull e0 e0Var, @NotNull e0 superType) {
        f0.p(e0Var, "<this>");
        f0.p(superType, "superType");
        return e.f58276a.d(e0Var, superType);
    }

    public static final boolean n(@NotNull f fVar) {
        f0.p(fVar, "<this>");
        return (fVar instanceof a1) && (((a1) fVar).b() instanceof z0);
    }

    public static final boolean o(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        return h1.n(e0Var);
    }

    @NotNull
    public static final e0 p(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        e0 o4 = h1.o(e0Var);
        f0.o(o4, "makeNotNullable(this)");
        return o4;
    }

    @NotNull
    public static final e0 q(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        e0 p3 = h1.p(e0Var);
        f0.o(p3, "makeNullable(this)");
        return p3;
    }

    @NotNull
    public static final e0 r(@NotNull e0 e0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        f0.p(e0Var, "<this>");
        f0.p(newAnnotations, "newAnnotations");
        return (e0Var.getAnnotations().isEmpty() && newAnnotations.isEmpty()) ? e0Var : e0Var.K0().N0(newAnnotations);
    }

    @NotNull
    public static final e0 s(@NotNull e0 e0Var, @NotNull f1 substitutor, @NotNull Map<y0, ? extends kotlin.reflect.jvm.internal.impl.types.a1> substitutionMap, @NotNull Variance variance, @Nullable Set<? extends a1> set) {
        l1 l1Var;
        int Z;
        Object H2;
        int Z2;
        Object H22;
        int Z3;
        Object H23;
        f0.p(e0Var, "<this>");
        f0.p(substitutor, "substitutor");
        f0.p(substitutionMap, "substitutionMap");
        f0.p(variance, "variance");
        l1 K0 = e0Var.K0();
        if (K0 instanceof y) {
            y yVar = (y) K0;
            m0 P0 = yVar.P0();
            if (!P0.H0().getParameters().isEmpty() && P0.H0().b() != null) {
                List<a1> parameters = P0.H0().getParameters();
                f0.o(parameters, "constructor.parameters");
                Z3 = kotlin.collections.y.Z(parameters, 10);
                ArrayList arrayList = new ArrayList(Z3);
                for (a1 a1Var : parameters) {
                    H23 = kotlin.collections.f0.H2(e0Var.G0(), a1Var.f());
                    kotlin.reflect.jvm.internal.impl.types.a1 a1Var2 = (kotlin.reflect.jvm.internal.impl.types.a1) H23;
                    if ((set != null && set.contains(a1Var)) || a1Var2 == null || !substitutionMap.containsKey(a1Var2.getType().H0())) {
                        a1Var2 = new r0(a1Var);
                    }
                    arrayList.add(a1Var2);
                }
                P0 = e1.f(P0, arrayList, null, 2, null);
            }
            m0 Q0 = yVar.Q0();
            if (!Q0.H0().getParameters().isEmpty() && Q0.H0().b() != null) {
                List<a1> parameters2 = Q0.H0().getParameters();
                f0.o(parameters2, "constructor.parameters");
                Z2 = kotlin.collections.y.Z(parameters2, 10);
                ArrayList arrayList2 = new ArrayList(Z2);
                for (a1 a1Var3 : parameters2) {
                    H22 = kotlin.collections.f0.H2(e0Var.G0(), a1Var3.f());
                    kotlin.reflect.jvm.internal.impl.types.a1 a1Var4 = (kotlin.reflect.jvm.internal.impl.types.a1) H22;
                    if ((set != null && set.contains(a1Var3)) || a1Var4 == null || !substitutionMap.containsKey(a1Var4.getType().H0())) {
                        a1Var4 = new r0(a1Var3);
                    }
                    arrayList2.add(a1Var4);
                }
                Q0 = e1.f(Q0, arrayList2, null, 2, null);
            }
            l1Var = kotlin.reflect.jvm.internal.impl.types.f0.d(P0, Q0);
        } else if (K0 instanceof m0) {
            m0 m0Var = (m0) K0;
            if (m0Var.H0().getParameters().isEmpty() || m0Var.H0().b() == null) {
                l1Var = m0Var;
            } else {
                List<a1> parameters3 = m0Var.H0().getParameters();
                f0.o(parameters3, "constructor.parameters");
                Z = kotlin.collections.y.Z(parameters3, 10);
                ArrayList arrayList3 = new ArrayList(Z);
                for (a1 a1Var5 : parameters3) {
                    H2 = kotlin.collections.f0.H2(e0Var.G0(), a1Var5.f());
                    kotlin.reflect.jvm.internal.impl.types.a1 a1Var6 = (kotlin.reflect.jvm.internal.impl.types.a1) H2;
                    if ((set != null && set.contains(a1Var5)) || a1Var6 == null || !substitutionMap.containsKey(a1Var6.getType().H0())) {
                        a1Var6 = new r0(a1Var5);
                    }
                    arrayList3.add(a1Var6);
                }
                l1Var = e1.f(m0Var, arrayList3, null, 2, null);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        e0 n4 = substitutor.n(j1.b(l1Var, K0), variance);
        f0.o(n4, "replaceArgumentsByParame\u2026ubstitute(it, variance) }");
        return n4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [kotlin.reflect.jvm.internal.impl.types.l1] */
    @NotNull
    public static final e0 t(@NotNull e0 e0Var) {
        int Z;
        m0 m0Var;
        int Z2;
        int Z3;
        f0.p(e0Var, "<this>");
        l1 K0 = e0Var.K0();
        if (K0 instanceof y) {
            y yVar = (y) K0;
            m0 P0 = yVar.P0();
            if (!P0.H0().getParameters().isEmpty() && P0.H0().b() != null) {
                List<a1> parameters = P0.H0().getParameters();
                f0.o(parameters, "constructor.parameters");
                Z3 = kotlin.collections.y.Z(parameters, 10);
                ArrayList arrayList = new ArrayList(Z3);
                for (a1 a1Var : parameters) {
                    arrayList.add(new r0(a1Var));
                }
                P0 = e1.f(P0, arrayList, null, 2, null);
            }
            m0 Q0 = yVar.Q0();
            if (!Q0.H0().getParameters().isEmpty() && Q0.H0().b() != null) {
                List<a1> parameters2 = Q0.H0().getParameters();
                f0.o(parameters2, "constructor.parameters");
                Z2 = kotlin.collections.y.Z(parameters2, 10);
                ArrayList arrayList2 = new ArrayList(Z2);
                for (a1 a1Var2 : parameters2) {
                    arrayList2.add(new r0(a1Var2));
                }
                Q0 = e1.f(Q0, arrayList2, null, 2, null);
            }
            m0Var = kotlin.reflect.jvm.internal.impl.types.f0.d(P0, Q0);
        } else if (K0 instanceof m0) {
            m0 m0Var2 = (m0) K0;
            boolean isEmpty = m0Var2.H0().getParameters().isEmpty();
            m0Var = m0Var2;
            if (!isEmpty) {
                f b4 = m0Var2.H0().b();
                m0Var = m0Var2;
                if (b4 != null) {
                    List<a1> parameters3 = m0Var2.H0().getParameters();
                    f0.o(parameters3, "constructor.parameters");
                    Z = kotlin.collections.y.Z(parameters3, 10);
                    ArrayList arrayList3 = new ArrayList(Z);
                    for (a1 a1Var3 : parameters3) {
                        arrayList3.add(new r0(a1Var3));
                    }
                    m0Var = e1.f(m0Var2, arrayList3, null, 2, null);
                }
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return j1.b(m0Var, K0);
    }

    public static final boolean u(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        return b(e0Var, b.f58418a);
    }

    public static final boolean v(@Nullable e0 e0Var) {
        return e0Var == null || b(e0Var, c.f58419a);
    }
}
