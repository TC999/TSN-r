package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import d2.l;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.i1;
import kotlin.collections.y;
import kotlin.collections.y0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.l0;
import kotlin.p;
import kotlin.r;
import kotlin.ranges.q;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.storage.g;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeParameterUpperBoundEraser.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.f f56961a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final p f56962b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final d f56963c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final g<a, e0> f56964d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeParameterUpperBoundEraser.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final a1 f56965a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f56966b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a f56967c;

        public a(@NotNull a1 typeParameter, boolean z3, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a typeAttr) {
            f0.p(typeParameter, "typeParameter");
            f0.p(typeAttr, "typeAttr");
            this.f56965a = typeParameter;
            this.f56966b = z3;
            this.f56967c = typeAttr;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a a() {
            return this.f56967c;
        }

        @NotNull
        public final a1 b() {
            return this.f56965a;
        }

        public final boolean c() {
            return this.f56966b;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return f0.g(aVar.f56965a, this.f56965a) && aVar.f56966b == this.f56966b && aVar.f56967c.d() == this.f56967c.d() && aVar.f56967c.e() == this.f56967c.e() && aVar.f56967c.g() == this.f56967c.g() && f0.g(aVar.f56967c.c(), this.f56967c.c());
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f56965a.hashCode();
            int i4 = hashCode + (hashCode * 31) + (this.f56966b ? 1 : 0);
            int hashCode2 = i4 + (i4 * 31) + this.f56967c.d().hashCode();
            int hashCode3 = hashCode2 + (hashCode2 * 31) + this.f56967c.e().hashCode();
            int i5 = hashCode3 + (hashCode3 * 31) + (this.f56967c.g() ? 1 : 0);
            int i6 = i5 * 31;
            m0 c4 = this.f56967c.c();
            return i5 + i6 + (c4 == null ? 0 : c4.hashCode());
        }

        @NotNull
        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.f56965a + ", isRaw=" + this.f56966b + ", typeAttr=" + this.f56967c + ')';
        }
    }

    /* compiled from: TypeParameterUpperBoundEraser.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<m0> {
        b() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final m0 invoke() {
            return w.j("Can't compute erased upper bound of type parameter `" + f.this + '`');
        }
    }

    /* compiled from: TypeParameterUpperBoundEraser.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements l<a, e0> {
        c() {
            super(1);
        }

        @Override // d2.l
        /* renamed from: a */
        public final e0 invoke(a aVar) {
            return f.this.d(aVar.b(), aVar.c(), aVar.a());
        }
    }

    public f() {
        this(null, 1, null);
    }

    public f(@Nullable d dVar) {
        p a4;
        kotlin.reflect.jvm.internal.impl.storage.f fVar = new kotlin.reflect.jvm.internal.impl.storage.f("Type parameter upper bound erasion results");
        this.f56961a = fVar;
        a4 = r.a(new b());
        this.f56962b = a4;
        this.f56963c = dVar == null ? new d(this) : dVar;
        g<a, e0> c4 = fVar.c(new c());
        f0.o(c4, "storage.createMemoizedFu\u2026 isRaw, typeAttr) }\n    }");
        this.f56964d = c4;
    }

    private final e0 b(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        m0 c4 = aVar.c();
        if (c4 == null) {
            m0 erroneousErasedBound = e();
            f0.o(erroneousErasedBound, "erroneousErasedBound");
            return erroneousErasedBound;
        }
        return kotlin.reflect.jvm.internal.impl.types.typeUtil.a.t(c4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e0 d(a1 a1Var, boolean z3, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        int Z;
        int j4;
        int n4;
        Object m22;
        Object m23;
        kotlin.reflect.jvm.internal.impl.types.a1 j5;
        Set<a1> f4 = aVar.f();
        if (f4 != null && f4.contains(a1Var.a())) {
            return b(aVar);
        }
        m0 q3 = a1Var.q();
        f0.o(q3, "typeParameter.defaultType");
        Set<a1> f5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.f(q3, f4);
        Z = y.Z(f5, 10);
        j4 = y0.j(Z);
        n4 = q.n(j4, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(n4);
        for (a1 a1Var2 : f5) {
            if (f4 != null && f4.contains(a1Var2)) {
                j5 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.b(a1Var2, aVar);
            } else {
                d dVar = this.f56963c;
                kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a i4 = z3 ? aVar : aVar.i(JavaTypeFlexibility.INFLEXIBLE);
                e0 c4 = c(a1Var2, z3, aVar.j(a1Var));
                f0.o(c4, "getErasedUpperBound(it, \u2026Parameter(typeParameter))");
                j5 = dVar.j(a1Var2, i4, c4);
            }
            Pair a4 = l0.a(a1Var2.j(), j5);
            linkedHashMap.put(a4.getFirst(), a4.getSecond());
        }
        f1 g4 = f1.g(z0.a.e(z0.f58460c, linkedHashMap, false, 2, null));
        f0.o(g4, "create(TypeConstructorSu\u2026rsMap(erasedUpperBounds))");
        List<e0> upperBounds = a1Var.getUpperBounds();
        f0.o(upperBounds, "typeParameter.upperBounds");
        m22 = kotlin.collections.f0.m2(upperBounds);
        e0 firstUpperBound = (e0) m22;
        if (firstUpperBound.H0().b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            f0.o(firstUpperBound, "firstUpperBound");
            return kotlin.reflect.jvm.internal.impl.types.typeUtil.a.s(firstUpperBound, g4, linkedHashMap, Variance.OUT_VARIANCE, aVar.f());
        }
        Set<a1> f6 = aVar.f();
        if (f6 == null) {
            f6 = i1.f(this);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = firstUpperBound.H0().b();
        if (b4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
        while (true) {
            a1 a1Var3 = (a1) b4;
            if (!f6.contains(a1Var3)) {
                List<e0> upperBounds2 = a1Var3.getUpperBounds();
                f0.o(upperBounds2, "current.upperBounds");
                m23 = kotlin.collections.f0.m2(upperBounds2);
                e0 nextUpperBound = (e0) m23;
                if (nextUpperBound.H0().b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                    f0.o(nextUpperBound, "nextUpperBound");
                    return kotlin.reflect.jvm.internal.impl.types.typeUtil.a.s(nextUpperBound, g4, linkedHashMap, Variance.OUT_VARIANCE, aVar.f());
                }
                b4 = nextUpperBound.H0().b();
                if (b4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                }
            } else {
                return b(aVar);
            }
        }
    }

    private final m0 e() {
        return (m0) this.f56962b.getValue();
    }

    public final e0 c(@NotNull a1 typeParameter, boolean z3, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a typeAttr) {
        f0.p(typeParameter, "typeParameter");
        f0.p(typeAttr, "typeAttr");
        return this.f56964d.invoke(new a(typeParameter, z3, typeAttr));
    }

    public /* synthetic */ f(d dVar, int i4, u uVar) {
        this((i4 & 1) != 0 ? null : dVar);
    }
}
