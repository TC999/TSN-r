package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import d2.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.builtins.h;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.b0;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.d1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RawType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d extends d1 {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final a f56951d = new a(null);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a f56952e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a f56953f;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final f f56954c;

    /* compiled from: RawType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* compiled from: RawType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56955a;

        static {
            int[] iArr = new int[JavaTypeFlexibility.values().length];
            iArr[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            iArr[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            iArr[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
            f56955a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RawType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements l<g, m0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d f56956a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f56957b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ m0 f56958c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a f56959d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, d dVar2, m0 m0Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
            super(1);
            this.f56956a = dVar;
            this.f56957b = dVar2;
            this.f56958c = m0Var;
            this.f56959d = aVar;
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final m0 invoke(@NotNull g kotlinTypeRefiner) {
            kotlin.reflect.jvm.internal.impl.descriptors.d b4;
            f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = this.f56956a;
            if (!(dVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
                dVar = null;
            }
            kotlin.reflect.jvm.internal.impl.name.b h4 = dVar == null ? null : kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(dVar);
            if (h4 == null || (b4 = kotlinTypeRefiner.b(h4)) == null || f0.g(b4, this.f56956a)) {
                return null;
            }
            return (m0) this.f56957b.l(this.f56958c, b4, this.f56959d).getFirst();
        }
    }

    static {
        TypeUsage typeUsage = TypeUsage.COMMON;
        f56952e = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.d(typeUsage, false, null, 3, null).i(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
        f56953f = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.d(typeUsage, false, null, 3, null).i(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    }

    public d() {
        this(null, 1, null);
    }

    public d(@Nullable f fVar) {
        this.f56954c = fVar == null ? new f(this) : fVar;
    }

    public static /* synthetic */ a1 k(d dVar, kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, e0 e0Var, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            e0Var = dVar.f56954c.c(a1Var, true, aVar);
            f0.o(e0Var, "fun computeProjection(\n \u2026er, attr)\n        }\n    }");
        }
        return dVar.j(a1Var, aVar, e0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<m0, Boolean> l(m0 m0Var, kotlin.reflect.jvm.internal.impl.descriptors.d dVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        int Z;
        List l4;
        if (m0Var.H0().getParameters().isEmpty()) {
            return l0.a(m0Var, Boolean.FALSE);
        }
        if (h.c0(m0Var)) {
            a1 a1Var = m0Var.G0().get(0);
            Variance c4 = a1Var.c();
            e0 type = a1Var.getType();
            f0.o(type, "componentTypeProjection.type");
            l4 = x.l(new c1(c4, m(type, aVar)));
            return l0.a(kotlin.reflect.jvm.internal.impl.types.f0.j(m0Var.getAnnotations(), m0Var.H0(), l4, m0Var.I0(), null, 16, null), Boolean.FALSE);
        } else if (g0.a(m0Var)) {
            m0 j4 = w.j(f0.C("Raw error type: ", m0Var.H0()));
            f0.o(j4, "createErrorType(\"Raw err\u2026pe: ${type.constructor}\")");
            return l0.a(j4, Boolean.FALSE);
        } else {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h o02 = dVar.o0(this);
            f0.o(o02, "declaration.getMemberScope(this)");
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = m0Var.getAnnotations();
            y0 j5 = dVar.j();
            f0.o(j5, "declaration.typeConstructor");
            List<kotlin.reflect.jvm.internal.impl.descriptors.a1> parameters = dVar.j().getParameters();
            f0.o(parameters, "declaration.typeConstructor.parameters");
            Z = y.Z(parameters, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (kotlin.reflect.jvm.internal.impl.descriptors.a1 parameter : parameters) {
                f0.o(parameter, "parameter");
                arrayList.add(k(this, parameter, aVar, null, 4, null));
            }
            return l0.a(kotlin.reflect.jvm.internal.impl.types.f0.m(annotations, j5, arrayList, m0Var.I0(), o02, new c(dVar, this, m0Var, aVar)), Boolean.TRUE);
        }
    }

    private final e0 m(e0 e0Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1) {
            e0 c4 = this.f56954c.c((kotlin.reflect.jvm.internal.impl.descriptors.a1) b4, true, aVar);
            f0.o(c4, "typeParameterUpperBoundE\u2026tion, isRaw = true, attr)");
            return m(c4, aVar);
        } else if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            kotlin.reflect.jvm.internal.impl.descriptors.f b5 = b0.d(e0Var).H0().b();
            if (b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                Pair<m0, Boolean> l4 = l(b0.c(e0Var), (kotlin.reflect.jvm.internal.impl.descriptors.d) b4, f56952e);
                m0 component1 = l4.component1();
                boolean booleanValue = l4.component2().booleanValue();
                Pair<m0, Boolean> l5 = l(b0.d(e0Var), (kotlin.reflect.jvm.internal.impl.descriptors.d) b5, f56953f);
                m0 component12 = l5.component1();
                boolean booleanValue2 = l5.component2().booleanValue();
                if (!booleanValue && !booleanValue2) {
                    return kotlin.reflect.jvm.internal.impl.types.f0.d(component1, component12);
                }
                return new e(component1, component12);
            }
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + b5 + "\" while for lower it's \"" + b4 + '\"').toString());
        } else {
            throw new IllegalStateException(f0.C("Unexpected declaration kind: ", b4).toString());
        }
    }

    static /* synthetic */ e0 n(d dVar, e0 e0Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            aVar = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a(TypeUsage.COMMON, null, false, null, null, 30, null);
        }
        return dVar.m(e0Var, aVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    public boolean f() {
        return false;
    }

    @NotNull
    public final a1 j(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a1 parameter, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a attr, @NotNull e0 erasedUpperBound) {
        f0.p(parameter, "parameter");
        f0.p(attr, "attr");
        f0.p(erasedUpperBound, "erasedUpperBound");
        int i4 = b.f56955a[attr.d().ordinal()];
        if (i4 != 1) {
            if (i4 != 2 && i4 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (!parameter.o().getAllowsOutPosition()) {
                return new c1(Variance.INVARIANT, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(parameter).H());
            }
            List<kotlin.reflect.jvm.internal.impl.descriptors.a1> parameters = erasedUpperBound.H0().getParameters();
            f0.o(parameters, "erasedUpperBound.constructor.parameters");
            if (!parameters.isEmpty()) {
                return new c1(Variance.OUT_VARIANCE, erasedUpperBound);
            }
            return kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.b(parameter, attr);
        }
        return new c1(Variance.INVARIANT, erasedUpperBound);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    @NotNull
    /* renamed from: o */
    public c1 e(@NotNull e0 key) {
        f0.p(key, "key");
        return new c1(n(this, key, null, 2, null));
    }

    public /* synthetic */ d(f fVar, int i4, u uVar) {
        this((i4 & 1) != 0 ? null : fVar);
    }
}
