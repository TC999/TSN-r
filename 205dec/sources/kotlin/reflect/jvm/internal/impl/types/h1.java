package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeUtils.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public static final m0 f58382a = w.p("DONT_CARE");

    /* renamed from: b  reason: collision with root package name */
    public static final m0 f58383b = w.j("Cannot be inferred");
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final m0 f58384c = new a("NO_EXPECTED_TYPE");

    /* renamed from: d  reason: collision with root package name */
    public static final m0 f58385d = new a("UNIT_EXPECTED_TYPE");

    /* renamed from: e  reason: collision with root package name */
    static final /* synthetic */ boolean f58386e = false;

    /* compiled from: TypeUtils.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a extends p {

        /* renamed from: b  reason: collision with root package name */
        private final String f58387b;

        public a(String str) {
            this.f58387b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void T0(int r9) {
            /*
                r0 = 4
                r1 = 1
                if (r9 == r1) goto L9
                if (r9 == r0) goto L9
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto Lb
            L9:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            Lb:
                r3 = 3
                r4 = 2
                if (r9 == r1) goto L13
                if (r9 == r0) goto L13
                r5 = 3
                goto L14
            L13:
                r5 = 2
            L14:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType"
                r7 = 0
                if (r9 == r1) goto L30
                if (r9 == r4) goto L2b
                if (r9 == r3) goto L26
                if (r9 == r0) goto L30
                java.lang.String r8 = "newAnnotations"
                r5[r7] = r8
                goto L32
            L26:
                java.lang.String r8 = "kotlinTypeRefiner"
                r5[r7] = r8
                goto L32
            L2b:
                java.lang.String r8 = "delegate"
                r5[r7] = r8
                goto L32
            L30:
                r5[r7] = r6
            L32:
                java.lang.String r7 = "refine"
                if (r9 == r1) goto L3e
                if (r9 == r0) goto L3b
                r5[r1] = r6
                goto L42
            L3b:
                r5[r1] = r7
                goto L42
            L3e:
                java.lang.String r6 = "toString"
                r5[r1] = r6
            L42:
                if (r9 == r1) goto L56
                if (r9 == r4) goto L52
                if (r9 == r3) goto L4f
                if (r9 == r0) goto L56
                java.lang.String r3 = "replaceAnnotations"
                r5[r4] = r3
                goto L56
            L4f:
                r5[r4] = r7
                goto L56
            L52:
                java.lang.String r3 = "replaceDelegate"
                r5[r4] = r3
            L56:
                java.lang.String r2 = java.lang.String.format(r2, r5)
                if (r9 == r1) goto L64
                if (r9 == r0) goto L64
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r2)
                goto L69
            L64:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>(r2)
            L69:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.h1.a.T0(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.l1
        @NotNull
        /* renamed from: O0 */
        public m0 L0(boolean z3) {
            throw new IllegalStateException(this.f58387b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.l1
        @NotNull
        /* renamed from: P0 */
        public m0 N0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
            if (fVar == null) {
                T0(0);
            }
            throw new IllegalStateException(this.f58387b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.p
        @NotNull
        protected m0 Q0() {
            throw new IllegalStateException(this.f58387b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.p
        @NotNull
        public p S0(@NotNull m0 m0Var) {
            if (m0Var == null) {
                T0(2);
            }
            throw new IllegalStateException(this.f58387b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.p
        @NotNull
        /* renamed from: U0 */
        public a R0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            if (gVar == null) {
                T0(3);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.m0
        @NotNull
        public String toString() {
            String str = this.f58387b;
            if (str == null) {
                T0(1);
            }
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01cd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r24) {
        /*
            Method dump skipped, instructions count: 796
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.h1.a(int):void");
    }

    public static boolean b(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(28);
        }
        if (e0Var.I0()) {
            return true;
        }
        return b0.b(e0Var) && b(b0.a(e0Var).Q0());
    }

    public static boolean c(@Nullable e0 e0Var, @NotNull d2.l<l1, Boolean> lVar) {
        if (lVar == null) {
            a(43);
        }
        return d(e0Var, lVar, null, null);
    }

    private static boolean d(@Nullable e0 e0Var, @NotNull d2.l<l1, Boolean> lVar, @Nullable d2.l<e0, Boolean> lVar2, kotlin.reflect.jvm.internal.impl.utils.f<e0> fVar) {
        if (lVar == null) {
            a(46);
        }
        if (e0Var == null) {
            return false;
        }
        l1 K0 = e0Var.K0();
        if (w(e0Var)) {
            return lVar.invoke(K0).booleanValue();
        }
        if (fVar == null || !fVar.contains(e0Var)) {
            if (lVar.invoke(K0).booleanValue()) {
                return true;
            }
            if (lVar2 == null || !lVar2.invoke(K0).booleanValue()) {
                if (fVar == null) {
                    fVar = kotlin.reflect.jvm.internal.impl.utils.f.a();
                }
                fVar.add(e0Var);
                y yVar = K0 instanceof y ? (y) K0 : null;
                if (yVar == null || !(d(yVar.P0(), lVar, lVar2, fVar) || d(yVar.Q0(), lVar, lVar2, fVar))) {
                    if ((K0 instanceof n) && d(((n) K0).T0(), lVar, lVar2, fVar)) {
                        return true;
                    }
                    y0 H0 = e0Var.H0();
                    if (H0 instanceof d0) {
                        for (e0 e0Var2 : ((d0) H0).j()) {
                            if (d(e0Var2, lVar, lVar2, fVar)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    for (a1 a1Var : e0Var.G0()) {
                        if (!a1Var.b()) {
                            if (d(a1Var.getType(), lVar, lVar2, fVar)) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean e(@Nullable e0 e0Var, @NotNull d2.l<l1, Boolean> lVar, @NotNull d2.l<e0, Boolean> lVar2) {
        if (lVar == null) {
            a(44);
        }
        if (lVar2 == null) {
            a(45);
        }
        return d(e0Var, lVar, lVar2, null);
    }

    @Nullable
    public static e0 f(@NotNull e0 e0Var, @NotNull e0 e0Var2, @NotNull f1 f1Var) {
        if (e0Var == null) {
            a(20);
        }
        if (e0Var2 == null) {
            a(21);
        }
        if (f1Var == null) {
            a(22);
        }
        e0 p3 = f1Var.p(e0Var2, Variance.INVARIANT);
        if (p3 != null) {
            return r(p3, e0Var.I0());
        }
        return null;
    }

    @Nullable
    public static kotlin.reflect.jvm.internal.impl.descriptors.d g(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(30);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.d) b4;
        }
        return null;
    }

    @NotNull
    public static List<a1> h(@NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.a1> list) {
        List<a1> G5;
        if (list == null) {
            a(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var : list) {
            arrayList.add(new c1(a1Var.q()));
        }
        G5 = kotlin.collections.f0.G5(arrayList);
        if (G5 == null) {
            a(17);
        }
        return G5;
    }

    @NotNull
    public static List<e0> i(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(18);
        }
        f1 f4 = f1.f(e0Var);
        Collection<e0> j4 = e0Var.H0().j();
        ArrayList arrayList = new ArrayList(j4.size());
        for (e0 e0Var2 : j4) {
            e0 f5 = f(e0Var, e0Var2, f4);
            if (f5 != null) {
                arrayList.add(f5);
            }
        }
        return arrayList;
    }

    @Nullable
    public static kotlin.reflect.jvm.internal.impl.descriptors.a1 j(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(64);
        }
        if (e0Var.H0().b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.a1) e0Var.H0().b();
        }
        return null;
    }

    public static boolean k(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(29);
        }
        if (e0Var.H0().b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return false;
        }
        for (e0 e0Var2 : i(e0Var)) {
            if (m(e0Var2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean l(@Nullable e0 e0Var) {
        return e0Var != null && e0Var.H0() == f58382a.H0();
    }

    public static boolean m(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(27);
        }
        if (e0Var.I0()) {
            return true;
        }
        if (b0.b(e0Var) && m(b0.a(e0Var).Q0())) {
            return true;
        }
        if (p0.c(e0Var)) {
            return false;
        }
        if (n(e0Var)) {
            return k(e0Var);
        }
        if (e0Var instanceof e) {
            kotlin.reflect.jvm.internal.impl.descriptors.a1 a4 = ((kotlin.reflect.jvm.internal.impl.types.checker.n) ((e) e0Var).Q0()).a();
            return a4 == null || k(a4.q());
        }
        y0 H0 = e0Var.H0();
        if (H0 instanceof d0) {
            for (e0 e0Var2 : H0.j()) {
                if (m(e0Var2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean n(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(61);
        }
        return j(e0Var) != null || (e0Var.H0() instanceof kotlin.reflect.jvm.internal.impl.types.checker.n);
    }

    @NotNull
    public static e0 o(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(2);
        }
        return q(e0Var, false);
    }

    @NotNull
    public static e0 p(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(1);
        }
        return q(e0Var, true);
    }

    @NotNull
    public static e0 q(@NotNull e0 e0Var, boolean z3) {
        if (e0Var == null) {
            a(3);
        }
        l1 L0 = e0Var.K0().L0(z3);
        if (L0 == null) {
            a(4);
        }
        return L0;
    }

    @NotNull
    public static e0 r(@NotNull e0 e0Var, boolean z3) {
        if (e0Var == null) {
            a(8);
        }
        if (z3) {
            return p(e0Var);
        }
        if (e0Var == null) {
            a(9);
        }
        return e0Var;
    }

    @NotNull
    public static m0 s(@NotNull m0 m0Var, boolean z3) {
        if (m0Var == null) {
            a(5);
        }
        if (!z3) {
            if (m0Var == null) {
                a(7);
            }
            return m0Var;
        }
        m0 O0 = m0Var.O0(true);
        if (O0 == null) {
            a(6);
        }
        return O0;
    }

    @NotNull
    public static a1 t(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var) {
        if (a1Var == null) {
            a(47);
        }
        return new r0(a1Var);
    }

    @NotNull
    public static m0 u(kotlin.reflect.jvm.internal.impl.descriptors.f fVar, kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar, d2.l<kotlin.reflect.jvm.internal.impl.types.checker.g, m0> lVar) {
        if (w.r(fVar)) {
            m0 j4 = w.j("Unsubstituted type for " + fVar);
            if (j4 == null) {
                a(11);
            }
            return j4;
        }
        return v(fVar.j(), hVar, lVar);
    }

    @NotNull
    public static m0 v(@NotNull y0 y0Var, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar, @NotNull d2.l<kotlin.reflect.jvm.internal.impl.types.checker.g, m0> lVar) {
        if (y0Var == null) {
            a(12);
        }
        if (hVar == null) {
            a(13);
        }
        if (lVar == null) {
            a(14);
        }
        m0 m4 = f0.m(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), y0Var, h(y0Var.getParameters()), false, hVar, lVar);
        if (m4 == null) {
            a(15);
        }
        return m4;
    }

    public static boolean w(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(0);
        }
        return e0Var == f58384c || e0Var == f58385d;
    }
}
