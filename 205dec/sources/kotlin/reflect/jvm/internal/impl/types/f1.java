package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeSubstitutor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f1 {

    /* renamed from: b  reason: collision with root package name */
    public static final f1 f58353b = g(d1.f58327b);

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f58354c = false;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final d1 f58355a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeSubstitutor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a implements d2.l<kotlin.reflect.jvm.internal.impl.name.c, Boolean> {
        a() {
        }

        private static /* synthetic */ void a(int i4) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        @Override // d2.l
        /* renamed from: b */
        public Boolean invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
            if (cVar == null) {
                a(0);
            }
            return Boolean.valueOf(!cVar.equals(j.a.f56090L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeSubstitutor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f58356a;

        static {
            int[] iArr = new int[d.values().length];
            f58356a = iArr;
            try {
                iArr[d.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f58356a[d.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f58356a[d.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeSubstitutor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Exception {
        public c(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeSubstitutor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum d {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    protected f1(@NotNull d1 d1Var) {
        if (d1Var == null) {
            a(7);
        }
        this.f58355a = d1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00fc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r13) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.f1.a(int):void");
    }

    private static void b(int i4, a1 a1Var, d1 d1Var) {
        if (i4 <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(a1Var) + "; substitution: " + o(d1Var));
    }

    @NotNull
    public static Variance c(@NotNull Variance variance, @NotNull a1 a1Var) {
        if (variance == null) {
            a(35);
        }
        if (a1Var == null) {
            a(36);
        }
        if (a1Var.b()) {
            Variance variance2 = Variance.OUT_VARIANCE;
            if (variance2 == null) {
                a(37);
            }
            return variance2;
        }
        return d(variance, a1Var.c());
    }

    @NotNull
    public static Variance d(@NotNull Variance variance, @NotNull Variance variance2) {
        if (variance == null) {
            a(38);
        }
        if (variance2 == null) {
            a(39);
        }
        Variance variance3 = Variance.INVARIANT;
        if (variance == variance3) {
            if (variance2 == null) {
                a(40);
            }
            return variance2;
        } else if (variance2 == variance3) {
            if (variance == null) {
                a(41);
            }
            return variance;
        } else if (variance == variance2) {
            if (variance2 == null) {
                a(42);
            }
            return variance2;
        } else {
            throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and projection kind '" + variance2 + "' cannot be combined");
        }
    }

    private static d e(Variance variance, Variance variance2) {
        Variance variance3 = Variance.IN_VARIANCE;
        if (variance == variance3 && variance2 == Variance.OUT_VARIANCE) {
            return d.OUT_IN_IN_POSITION;
        }
        if (variance == Variance.OUT_VARIANCE && variance2 == variance3) {
            return d.IN_IN_OUT_POSITION;
        }
        return d.NO_CONFLICT;
    }

    @NotNull
    public static f1 f(@NotNull e0 e0Var) {
        if (e0Var == null) {
            a(6);
        }
        return g(z0.i(e0Var.H0(), e0Var.G0()));
    }

    @NotNull
    public static f1 g(@NotNull d1 d1Var) {
        if (d1Var == null) {
            a(0);
        }
        return new f1(d1Var);
    }

    @NotNull
    public static f1 h(@NotNull d1 d1Var, @NotNull d1 d1Var2) {
        if (d1Var == null) {
            a(3);
        }
        if (d1Var2 == null) {
            a(4);
        }
        return g(s.i(d1Var, d1Var2));
    }

    @NotNull
    private static kotlin.reflect.jvm.internal.impl.descriptors.annotations.f i(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
        if (fVar == null) {
            a(33);
        }
        return !fVar.i(j.a.f56090L) ? fVar : new kotlin.reflect.jvm.internal.impl.descriptors.annotations.k(fVar, new a());
    }

    @NotNull
    private static a1 l(@NotNull e0 e0Var, @NotNull a1 a1Var, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var2, @NotNull a1 a1Var3) {
        if (e0Var == null) {
            a(26);
        }
        if (a1Var == null) {
            a(27);
        }
        if (a1Var3 == null) {
            a(28);
        }
        if (!e0Var.getAnnotations().i(j.a.f56090L)) {
            if (a1Var == null) {
                a(29);
            }
            return a1Var;
        }
        y0 H0 = a1Var.getType().H0();
        if (H0 instanceof kotlin.reflect.jvm.internal.impl.types.checker.j) {
            a1 projection = ((kotlin.reflect.jvm.internal.impl.types.checker.j) H0).getProjection();
            Variance c4 = projection.c();
            d e4 = e(a1Var3.c(), c4);
            d dVar = d.OUT_IN_IN_POSITION;
            if (e4 == dVar) {
                return new c1(projection.getType());
            }
            return (a1Var2 != null && e(a1Var2.o(), c4) == dVar) ? new c1(projection.getType()) : a1Var;
        }
        return a1Var;
    }

    private static String o(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (!kotlin.reflect.jvm.internal.impl.utils.c.a(th)) {
                return "[Exception while computing toString(): " + th + "]";
            }
            throw th;
        }
    }

    private a1 r(a1 a1Var, int i4) throws c {
        e0 type = a1Var.getType();
        Variance c4 = a1Var.c();
        if (type.H0().b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1) {
            return a1Var;
        }
        m0 b4 = p0.b(type);
        e0 p3 = b4 != null ? m().p(b4, Variance.INVARIANT) : null;
        e0 b5 = e1.b(type, s(type.H0().getParameters(), type.G0(), i4), this.f58355a.d(type.getAnnotations()));
        if ((b5 instanceof m0) && (p3 instanceof m0)) {
            b5 = p0.j((m0) b5, (m0) p3);
        }
        return new c1(c4, b5);
    }

    private List<a1> s(List<kotlin.reflect.jvm.internal.impl.descriptors.a1> list, List<a1> list2, int i4) throws c {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z3 = false;
        for (int i5 = 0; i5 < list.size(); i5++) {
            kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var = list.get(i5);
            a1 a1Var2 = list2.get(i5);
            a1 u3 = u(a1Var2, a1Var, i4 + 1);
            int i6 = b.f58356a[e(a1Var.o(), u3.c()).ordinal()];
            if (i6 == 1 || i6 == 2) {
                u3 = h1.t(a1Var);
            } else if (i6 == 3) {
                Variance o4 = a1Var.o();
                Variance variance = Variance.INVARIANT;
                if (o4 != variance && !u3.b()) {
                    u3 = new c1(variance, u3.getType());
                }
            }
            if (u3 != a1Var2) {
                z3 = true;
            }
            arrayList.add(u3);
        }
        return !z3 ? list2 : arrayList;
    }

    @NotNull
    private a1 u(@NotNull a1 a1Var, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var2, int i4) throws c {
        e0 r3;
        if (a1Var == null) {
            a(18);
        }
        b(i4, a1Var, this.f58355a);
        if (a1Var.b()) {
            return a1Var;
        }
        e0 type = a1Var.getType();
        if (type instanceof i1) {
            i1 i1Var = (i1) type;
            l1 C0 = i1Var.C0();
            e0 f02 = i1Var.f0();
            a1 u3 = u(new c1(a1Var.c(), C0), a1Var2, i4 + 1);
            if (u3.b()) {
                return u3;
            }
            e0 p3 = p(f02, a1Var.c());
            l1 K0 = u3.getType().K0();
            if (p3 instanceof i1) {
                p3 = ((i1) p3).f0();
            }
            return new c1(u3.c(), j1.e(K0, p3));
        }
        if (!u.a(type) && !(type.K0() instanceof l0)) {
            a1 e4 = this.f58355a.e(type);
            a1 l4 = e4 != null ? l(type, e4, a1Var2, a1Var) : null;
            Variance c4 = a1Var.c();
            if (l4 == null && b0.b(type) && !x0.b(type)) {
                y a4 = b0.a(type);
                int i5 = i4 + 1;
                a1 u4 = u(new c1(c4, a4.P0()), a1Var2, i5);
                a1 u5 = u(new c1(c4, a4.Q0()), a1Var2, i5);
                return (u4.getType() == a4.P0() && u5.getType() == a4.Q0()) ? a1Var : new c1(u4.c(), f0.d(e1.a(u4.getType()), e1.a(u5.getType())));
            } else if (!kotlin.reflect.jvm.internal.impl.builtins.h.l0(type) && !g0.a(type)) {
                if (l4 != null) {
                    d e5 = e(c4, l4.c());
                    if (!kotlin.reflect.jvm.internal.impl.resolve.calls.inference.d.d(type)) {
                        int i6 = b.f58356a[e5.ordinal()];
                        if (i6 == 1) {
                            throw new c("Out-projection in in-position");
                        }
                        if (i6 == 2) {
                            return new c1(Variance.OUT_VARIANCE, type.H0().k().I());
                        }
                    }
                    m a5 = x0.a(type);
                    if (l4.b()) {
                        return l4;
                    }
                    if (a5 != null) {
                        r3 = a5.h0(l4.getType());
                    } else {
                        r3 = h1.r(l4.getType(), type.I0());
                    }
                    if (!type.getAnnotations().isEmpty()) {
                        r3 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.r(r3, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.j(r3.getAnnotations(), i(this.f58355a.d(type.getAnnotations()))));
                    }
                    if (e5 == d.NO_CONFLICT) {
                        c4 = d(c4, l4.c());
                    }
                    return new c1(c4, r3);
                }
                a1Var = r(a1Var, i4);
                if (a1Var == null) {
                    a(25);
                }
            }
        }
        return a1Var;
    }

    @NotNull
    public d1 j() {
        d1 d1Var = this.f58355a;
        if (d1Var == null) {
            a(8);
        }
        return d1Var;
    }

    public boolean k() {
        return this.f58355a.f();
    }

    @NotNull
    public f1 m() {
        d1 d1Var = this.f58355a;
        return ((d1Var instanceof c0) && d1Var.b()) ? new f1(new c0(((c0) this.f58355a).j(), ((c0) this.f58355a).i(), false)) : this;
    }

    @NotNull
    public e0 n(@NotNull e0 e0Var, @NotNull Variance variance) {
        if (e0Var == null) {
            a(9);
        }
        if (variance == null) {
            a(10);
        }
        if (k()) {
            if (e0Var == null) {
                a(11);
            }
            return e0Var;
        }
        try {
            e0 type = u(new c1(variance, e0Var), null, 0).getType();
            if (type == null) {
                a(12);
            }
            return type;
        } catch (c e4) {
            m0 j4 = w.j(e4.getMessage());
            if (j4 == null) {
                a(13);
            }
            return j4;
        }
    }

    @Nullable
    public e0 p(@NotNull e0 e0Var, @NotNull Variance variance) {
        if (e0Var == null) {
            a(14);
        }
        if (variance == null) {
            a(15);
        }
        a1 q3 = q(new c1(variance, j().g(e0Var, variance)));
        if (q3 == null) {
            return null;
        }
        return q3.getType();
    }

    @Nullable
    public a1 q(@NotNull a1 a1Var) {
        if (a1Var == null) {
            a(16);
        }
        a1 t3 = t(a1Var);
        return (this.f58355a.a() || this.f58355a.b()) ? kotlin.reflect.jvm.internal.impl.types.typesApproximation.b.c(t3, this.f58355a.b()) : t3;
    }

    @Nullable
    public a1 t(@NotNull a1 a1Var) {
        if (a1Var == null) {
            a(17);
        }
        if (k()) {
            return a1Var;
        }
        try {
            return u(a1Var, null, 0);
        } catch (c unused) {
            return null;
        }
    }
}
