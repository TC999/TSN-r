package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.f0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IntegerLiteralTypeConstructor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n implements y0 {
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final a f57838f = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final long f57839a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d0 f57840b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Set<e0> f57841c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final m0 f57842d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.p f57843e;

    /* compiled from: IntegerLiteralTypeConstructor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IntegerLiteralTypeConstructor.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.constants.n$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public enum EnumC1166a {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE
        }

        /* compiled from: IntegerLiteralTypeConstructor.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public /* synthetic */ class b {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f57847a;

            static {
                int[] iArr = new int[EnumC1166a.values().length];
                iArr[EnumC1166a.COMMON_SUPER_TYPE.ordinal()] = 1;
                iArr[EnumC1166a.INTERSECTION_TYPE.ordinal()] = 2;
                f57847a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        private final m0 a(Collection<? extends m0> collection, EnumC1166a enumC1166a) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    a aVar = n.f57838f;
                    next = aVar.e((m0) next, (m0) it.next(), enumC1166a);
                }
                return (m0) next;
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final m0 c(n nVar, n nVar2, EnumC1166a enumC1166a) {
            Set T2;
            int i4 = b.f57847a[enumC1166a.ordinal()];
            if (i4 == 1) {
                T2 = f0.T2(nVar.h(), nVar2.h());
            } else if (i4 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                T2 = f0.N5(nVar.h(), nVar2.h());
            }
            return kotlin.reflect.jvm.internal.impl.types.f0.e(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), new n(nVar.f57839a, nVar.f57840b, T2, null), false);
        }

        private final m0 d(n nVar, m0 m0Var) {
            if (nVar.h().contains(m0Var)) {
                return m0Var;
            }
            return null;
        }

        private final m0 e(m0 m0Var, m0 m0Var2, EnumC1166a enumC1166a) {
            if (m0Var == null || m0Var2 == null) {
                return null;
            }
            y0 H0 = m0Var.H0();
            y0 H02 = m0Var2.H0();
            boolean z3 = H0 instanceof n;
            if (z3 && (H02 instanceof n)) {
                return c((n) H0, (n) H02, enumC1166a);
            }
            if (z3) {
                return d((n) H0, m0Var2);
            }
            if (H02 instanceof n) {
                return d((n) H02, m0Var);
            }
            return null;
        }

        @Nullable
        public final m0 b(@NotNull Collection<? extends m0> types) {
            kotlin.jvm.internal.f0.p(types, "types");
            return a(types, EnumC1166a.INTERSECTION_TYPE);
        }
    }

    /* compiled from: IntegerLiteralTypeConstructor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<List<m0>> {
        b() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        public final List<m0> invoke() {
            List l4;
            List<m0> Q;
            m0 q3 = n.this.k().x().q();
            kotlin.jvm.internal.f0.o(q3, "builtIns.comparable.defaultType");
            l4 = kotlin.collections.x.l(new c1(Variance.IN_VARIANCE, n.this.f57842d));
            Q = CollectionsKt__CollectionsKt.Q(e1.f(q3, l4, null, 2, null));
            if (!n.this.l()) {
                Q.add(n.this.k().L());
            }
            return Q;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntegerLiteralTypeConstructor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.l<e0, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f57849a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull e0 it) {
            kotlin.jvm.internal.f0.p(it, "it");
            return it.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private n(long j4, d0 d0Var, Set<? extends e0> set) {
        kotlin.p a4;
        this.f57842d = kotlin.reflect.jvm.internal.impl.types.f0.e(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), this, false);
        a4 = kotlin.r.a(new b());
        this.f57843e = a4;
        this.f57839a = j4;
        this.f57840b = d0Var;
        this.f57841c = set;
    }

    public /* synthetic */ n(long j4, d0 d0Var, Set set, kotlin.jvm.internal.u uVar) {
        this(j4, d0Var, set);
    }

    private final List<e0> i() {
        return (List) this.f57843e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l() {
        Collection<e0> a4 = t.a(this.f57840b);
        if ((a4 instanceof Collection) && a4.isEmpty()) {
            return true;
        }
        for (e0 e0Var : a4) {
            if (!(!h().contains(e0Var))) {
                return false;
            }
        }
        return true;
    }

    private final String m() {
        String X2;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        X2 = f0.X2(this.f57841c, ",", null, null, 0, null, c.f57849a, 30, null);
        sb.append(X2);
        sb.append(']');
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public y0 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f b() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    public boolean c() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public List<a1> getParameters() {
        List<a1> F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @NotNull
    public final Set<e0> h() {
        return this.f57841c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public Collection<e0> j() {
        return i();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.h k() {
        return this.f57840b.k();
    }

    @NotNull
    public String toString() {
        return kotlin.jvm.internal.f0.C("IntegerLiteralType", m());
    }
}
