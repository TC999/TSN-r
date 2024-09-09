package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.y;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.b0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.j1;
import kotlin.reflect.jvm.internal.impl.types.l0;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.p0;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: typeEnhancement.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.d f56993a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: typeEnhancement.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final e0 f56994a;

        /* renamed from: b  reason: collision with root package name */
        private final int f56995b;

        public a(@Nullable e0 e0Var, int i4) {
            this.f56994a = e0Var;
            this.f56995b = i4;
        }

        public final int a() {
            return this.f56995b;
        }

        @Nullable
        public final e0 getType() {
            return this.f56994a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: typeEnhancement.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final m0 f56996a;

        /* renamed from: b  reason: collision with root package name */
        private final int f56997b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f56998c;

        public b(@Nullable m0 m0Var, int i4, boolean z3) {
            this.f56996a = m0Var;
            this.f56997b = i4;
            this.f56998c = z3;
        }

        public final boolean a() {
            return this.f56998c;
        }

        public final int b() {
            return this.f56997b;
        }

        @Nullable
        public final m0 getType() {
            return this.f56996a;
        }
    }

    public c(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.d javaResolverSettings) {
        f0.p(javaResolverSettings, "javaResolverSettings");
        this.f56993a = javaResolverSettings;
    }

    private final b b(m0 m0Var, d2.l<? super Integer, d> lVar, int i4, TypeComponentPosition typeComponentPosition, boolean z3, boolean z4) {
        kotlin.reflect.jvm.internal.impl.descriptors.f g4;
        Boolean h4;
        int Z;
        int Z2;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.b bVar;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.b bVar2;
        List O;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f4;
        int Z3;
        int Z4;
        boolean z5;
        boolean z6;
        boolean z7;
        a aVar;
        a1 t3;
        d2.l<? super Integer, d> lVar2 = lVar;
        boolean a4 = m.a(typeComponentPosition);
        boolean z8 = (z4 && z3) ? false : true;
        e0 e0Var = null;
        if (a4 || !m0Var.G0().isEmpty()) {
            kotlin.reflect.jvm.internal.impl.descriptors.f b4 = m0Var.H0().b();
            if (b4 == null) {
                return new b(null, 1, false);
            }
            d invoke = lVar2.invoke(Integer.valueOf(i4));
            g4 = o.g(b4, invoke, typeComponentPosition);
            h4 = o.h(invoke, typeComponentPosition);
            y0 H0 = g4 == null ? m0Var.H0() : g4.j();
            f0.o(H0, "enhancedClassifier?.typeConstructor ?: constructor");
            int i5 = i4 + 1;
            List<a1> G0 = m0Var.G0();
            List<kotlin.reflect.jvm.internal.impl.descriptors.a1> parameters = H0.getParameters();
            f0.o(parameters, "typeConstructor.parameters");
            Iterator<T> it = G0.iterator();
            Iterator<T> it2 = parameters.iterator();
            Z = y.Z(G0, 10);
            Z2 = y.Z(parameters, 10);
            ArrayList<a1> arrayList = new ArrayList(Math.min(Z, Z2));
            while (it.hasNext() && it2.hasNext()) {
                Object next = it.next();
                kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var = (kotlin.reflect.jvm.internal.impl.descriptors.a1) it2.next();
                a1 a1Var2 = (a1) next;
                if (!z8) {
                    z7 = z8;
                    aVar = new a(e0Var, 0);
                } else {
                    z7 = z8;
                    if (!a1Var2.b()) {
                        aVar = d(a1Var2.getType().K0(), lVar2, i5, z4);
                    } else if (lVar2.invoke(Integer.valueOf(i5)).d() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                        l1 K0 = a1Var2.getType().K0();
                        aVar = new a(kotlin.reflect.jvm.internal.impl.types.f0.d(b0.c(K0).O0(false), b0.d(K0).O0(true)), 1);
                    } else {
                        aVar = new a(null, 1);
                    }
                }
                i5 += aVar.a();
                if (aVar.getType() != null) {
                    e0 type = aVar.getType();
                    Variance c4 = a1Var2.c();
                    f0.o(c4, "arg.projectionKind");
                    t3 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.e(type, c4, a1Var);
                } else if (g4 == null || a1Var2.b()) {
                    t3 = g4 != null ? h1.t(a1Var) : null;
                } else {
                    e0 type2 = a1Var2.getType();
                    f0.o(type2, "arg.type");
                    Variance c5 = a1Var2.c();
                    f0.o(c5, "arg.projectionKind");
                    t3 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.e(type2, c5, a1Var);
                }
                arrayList.add(t3);
                lVar2 = lVar;
                z8 = z7;
                e0Var = null;
            }
            int i6 = i5 - i4;
            if (g4 == null && h4 == null) {
                if (!arrayList.isEmpty()) {
                    for (a1 a1Var3 : arrayList) {
                        if (a1Var3 == null) {
                            z5 = true;
                            continue;
                        } else {
                            z5 = false;
                            continue;
                        }
                        if (!z5) {
                            z6 = false;
                            break;
                        }
                    }
                }
                z6 = true;
                if (z6) {
                    return new b(null, i6, false);
                }
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f[] fVarArr = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.f[3];
            fVarArr[0] = m0Var.getAnnotations();
            bVar = o.f57086b;
            if (!(g4 != null)) {
                bVar = null;
            }
            fVarArr[1] = bVar;
            bVar2 = o.f57085a;
            if (!(h4 != null)) {
                bVar2 = null;
            }
            fVarArr[2] = bVar2;
            O = CollectionsKt__CollectionsKt.O(fVarArr);
            f4 = o.f(O);
            List<a1> G02 = m0Var.G0();
            Iterator it3 = arrayList.iterator();
            Iterator<T> it4 = G02.iterator();
            Z3 = y.Z(arrayList, 10);
            Z4 = y.Z(G02, 10);
            ArrayList arrayList2 = new ArrayList(Math.min(Z3, Z4));
            while (it3.hasNext() && it4.hasNext()) {
                Object next2 = it3.next();
                a1 a1Var4 = (a1) it4.next();
                a1 a1Var5 = (a1) next2;
                if (a1Var5 != null) {
                    a1Var4 = a1Var5;
                }
                arrayList2.add(a1Var4);
            }
            m0 j4 = kotlin.reflect.jvm.internal.impl.types.f0.j(f4, H0, arrayList2, h4 == null ? m0Var.I0() : h4.booleanValue(), null, 16, null);
            if (invoke.b()) {
                j4 = e(j4);
            }
            return new b(j4, i6, h4 != null && invoke.e());
        }
        return new b(null, 1, false);
    }

    static /* synthetic */ b c(c cVar, m0 m0Var, d2.l lVar, int i4, TypeComponentPosition typeComponentPosition, boolean z3, boolean z4, int i5, Object obj) {
        return cVar.b(m0Var, lVar, i4, typeComponentPosition, (i5 & 8) != 0 ? false : z3, (i5 & 16) != 0 ? false : z4);
    }

    private final a d(l1 l1Var, d2.l<? super Integer, d> lVar, int i4, boolean z3) {
        e0 d4;
        e0 e0Var = null;
        if (g0.a(l1Var)) {
            return new a(null, 1);
        }
        if (l1Var instanceof kotlin.reflect.jvm.internal.impl.types.y) {
            boolean z4 = l1Var instanceof l0;
            kotlin.reflect.jvm.internal.impl.types.y yVar = (kotlin.reflect.jvm.internal.impl.types.y) l1Var;
            b b4 = b(yVar.P0(), lVar, i4, TypeComponentPosition.FLEXIBLE_LOWER, z4, z3);
            b b5 = b(yVar.Q0(), lVar, i4, TypeComponentPosition.FLEXIBLE_UPPER, z4, z3);
            b4.b();
            b5.b();
            if (b4.getType() != null || b5.getType() != null) {
                if (b4.a() || b5.a()) {
                    m0 type = b5.getType();
                    if (type == null) {
                        d4 = b4.getType();
                        f0.m(d4);
                    } else {
                        m0 type2 = b4.getType();
                        if (type2 == null) {
                            type2 = type;
                        }
                        d4 = kotlin.reflect.jvm.internal.impl.types.f0.d(type2, type);
                    }
                    e0Var = j1.e(l1Var, d4);
                } else if (z4) {
                    m0 type3 = b4.getType();
                    if (type3 == null) {
                        type3 = yVar.P0();
                    }
                    m0 type4 = b5.getType();
                    if (type4 == null) {
                        type4 = yVar.Q0();
                    }
                    e0Var = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.e(type3, type4);
                } else {
                    m0 type5 = b4.getType();
                    if (type5 == null) {
                        type5 = yVar.P0();
                    }
                    m0 type6 = b5.getType();
                    if (type6 == null) {
                        type6 = yVar.Q0();
                    }
                    e0Var = kotlin.reflect.jvm.internal.impl.types.f0.d(type5, type6);
                }
            }
            return new a(e0Var, b4.b());
        } else if (l1Var instanceof m0) {
            b c4 = c(this, (m0) l1Var, lVar, i4, TypeComponentPosition.INFLEXIBLE, false, z3, 8, null);
            return new a(c4.a() ? j1.e(l1Var, c4.getType()) : c4.getType(), c4.b());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final m0 e(m0 m0Var) {
        if (this.f56993a.a()) {
            return p0.h(m0Var, true);
        }
        return new e(m0Var);
    }

    @Nullable
    public final e0 a(@NotNull e0 e0Var, @NotNull d2.l<? super Integer, d> qualifiers, boolean z3) {
        f0.p(e0Var, "<this>");
        f0.p(qualifiers, "qualifiers");
        return d(e0Var.K0(), qualifiers, 0, z3).getType();
    }
}
