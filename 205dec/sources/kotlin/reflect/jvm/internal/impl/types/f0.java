package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.w0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinTypeFactory.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f0 {
    @NotNull

    /* renamed from: a */
    public static final f0 f58339a = new f0();
    @NotNull

    /* renamed from: b */
    private static final d2.l<kotlin.reflect.jvm.internal.impl.types.checker.g, m0> f58340b = a.f58341a;

    /* compiled from: KotlinTypeFactory.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l {

        /* renamed from: a */
        public static final a f58341a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final Void invoke(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g noName_0) {
            kotlin.jvm.internal.f0.p(noName_0, "$noName_0");
            return null;
        }
    }

    /* compiled from: KotlinTypeFactory.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        @Nullable

        /* renamed from: a */
        private final m0 f58342a;
        @Nullable

        /* renamed from: b */
        private final y0 f58343b;

        public b(@Nullable m0 m0Var, @Nullable y0 y0Var) {
            this.f58342a = m0Var;
            this.f58343b = y0Var;
        }

        @Nullable
        public final m0 a() {
            return this.f58342a;
        }

        @Nullable
        public final y0 b() {
            return this.f58343b;
        }
    }

    /* compiled from: KotlinTypeFactory.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.types.checker.g, m0> {

        /* renamed from: a */
        final /* synthetic */ y0 f58344a;

        /* renamed from: b */
        final /* synthetic */ List<a1> f58345b;

        /* renamed from: c */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f58346c;

        /* renamed from: d */
        final /* synthetic */ boolean f58347d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(y0 y0Var, List<? extends a1> list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3) {
            super(1);
            this.f58344a = y0Var;
            this.f58345b = list;
            this.f58346c = fVar;
            this.f58347d = z3;
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final m0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g refiner) {
            kotlin.jvm.internal.f0.p(refiner, "refiner");
            b f4 = f0.f58339a.f(this.f58344a, refiner, this.f58345b);
            if (f4 == null) {
                return null;
            }
            m0 a4 = f4.a();
            if (a4 == null) {
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar = this.f58346c;
                y0 b4 = f4.b();
                kotlin.jvm.internal.f0.m(b4);
                return f0.h(fVar, b4, this.f58345b, this.f58347d, refiner);
            }
            return a4;
        }
    }

    /* compiled from: KotlinTypeFactory.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.types.checker.g, m0> {

        /* renamed from: a */
        final /* synthetic */ y0 f58348a;

        /* renamed from: b */
        final /* synthetic */ List<a1> f58349b;

        /* renamed from: c */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f58350c;

        /* renamed from: d */
        final /* synthetic */ boolean f58351d;

        /* renamed from: e */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.resolve.scopes.h f58352e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(y0 y0Var, List<? extends a1> list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar) {
            super(1);
            this.f58348a = y0Var;
            this.f58349b = list;
            this.f58350c = fVar;
            this.f58351d = z3;
            this.f58352e = hVar;
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final m0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            b f4 = f0.f58339a.f(this.f58348a, kotlinTypeRefiner, this.f58349b);
            if (f4 == null) {
                return null;
            }
            m0 a4 = f4.a();
            if (a4 == null) {
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar = this.f58350c;
                y0 b4 = f4.b();
                kotlin.jvm.internal.f0.m(b4);
                return f0.l(fVar, b4, this.f58349b, this.f58351d, this.f58352e);
            }
            return a4;
        }
    }

    private f0() {
    }

    @JvmStatic
    @NotNull
    public static final m0 b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.z0 z0Var, @NotNull List<? extends a1> arguments) {
        kotlin.jvm.internal.f0.p(z0Var, "<this>");
        kotlin.jvm.internal.f0.p(arguments, "arguments");
        return new u0(w0.a.f58454a, false).i(v0.f58437e.a(null, z0Var, arguments), kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b());
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h c(y0 y0Var, List<? extends a1> list, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = y0Var.b();
        if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.a1) b4).q().p();
        }
        if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            if (gVar == null) {
                gVar = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.k(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(b4));
            }
            if (list.isEmpty()) {
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.u.b((kotlin.reflect.jvm.internal.impl.descriptors.d) b4, gVar);
            }
            return kotlin.reflect.jvm.internal.impl.descriptors.impl.u.a((kotlin.reflect.jvm.internal.impl.descriptors.d) b4, z0.f58460c.b(y0Var, list), gVar);
        } else if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.z0) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h i4 = w.i(kotlin.jvm.internal.f0.C("Scope for abbreviation: ", ((kotlin.reflect.jvm.internal.impl.descriptors.z0) b4).getName()), true);
            kotlin.jvm.internal.f0.o(i4, "createErrorScope(\"Scope \u2026{descriptor.name}\", true)");
            return i4;
        } else if (y0Var instanceof d0) {
            return ((d0) y0Var).d();
        } else {
            throw new IllegalStateException("Unsupported classifier: " + b4 + " for constructor: " + y0Var);
        }
    }

    @JvmStatic
    @NotNull
    public static final l1 d(@NotNull m0 lowerBound, @NotNull m0 upperBound) {
        kotlin.jvm.internal.f0.p(lowerBound, "lowerBound");
        kotlin.jvm.internal.f0.p(upperBound, "upperBound");
        return kotlin.jvm.internal.f0.g(lowerBound, upperBound) ? lowerBound : new z(lowerBound, upperBound);
    }

    @JvmStatic
    @NotNull
    public static final m0 e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.n constructor, boolean z3) {
        List F;
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        kotlin.jvm.internal.f0.p(constructor, "constructor");
        F = CollectionsKt__CollectionsKt.F();
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h i4 = w.i("Scope for integer literal type", true);
        kotlin.jvm.internal.f0.o(i4, "createErrorScope(\"Scope \u2026eger literal type\", true)");
        return l(annotations, constructor, F, z3, i4);
    }

    public final b f(y0 y0Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, List<? extends a1> list) {
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = y0Var.b();
        kotlin.reflect.jvm.internal.impl.descriptors.f f4 = b4 == null ? null : gVar.f(b4);
        if (f4 == null) {
            return null;
        }
        if (f4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.z0) {
            return new b(b((kotlin.reflect.jvm.internal.impl.descriptors.z0) f4, list), null);
        }
        y0 a4 = f4.j().a(gVar);
        kotlin.jvm.internal.f0.o(a4, "descriptor.typeConstruct\u2026refine(kotlinTypeRefiner)");
        return new b(null, a4);
    }

    @JvmStatic
    @NotNull
    public static final m0 g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d descriptor, @NotNull List<? extends a1> arguments) {
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        kotlin.jvm.internal.f0.p(arguments, "arguments");
        y0 j4 = descriptor.j();
        kotlin.jvm.internal.f0.o(j4, "descriptor.typeConstructor");
        return j(annotations, j4, arguments, false, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final m0 h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull y0 constructor, @NotNull List<? extends a1> arguments, boolean z3, @Nullable kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        kotlin.jvm.internal.f0.p(constructor, "constructor");
        kotlin.jvm.internal.f0.p(arguments, "arguments");
        if (annotations.isEmpty() && arguments.isEmpty() && !z3 && constructor.b() != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.f b4 = constructor.b();
            kotlin.jvm.internal.f0.m(b4);
            m0 q3 = b4.q();
            kotlin.jvm.internal.f0.o(q3, "constructor.declarationDescriptor!!.defaultType");
            return q3;
        }
        return m(annotations, constructor, arguments, z3, f58339a.c(constructor, arguments, gVar), new c(constructor, arguments, annotations, z3));
    }

    @JvmStatic
    @NotNull
    public static final m0 i(@NotNull m0 baseType, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull y0 constructor, @NotNull List<? extends a1> arguments, boolean z3) {
        kotlin.jvm.internal.f0.p(baseType, "baseType");
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        kotlin.jvm.internal.f0.p(constructor, "constructor");
        kotlin.jvm.internal.f0.p(arguments, "arguments");
        return j(annotations, constructor, arguments, z3, null, 16, null);
    }

    public static /* synthetic */ m0 j(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, y0 y0Var, List list, boolean z3, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            gVar = null;
        }
        return h(fVar, y0Var, list, z3, gVar);
    }

    public static /* synthetic */ m0 k(m0 m0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, y0 y0Var, List list, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            fVar = m0Var.getAnnotations();
        }
        if ((i4 & 4) != 0) {
            y0Var = m0Var.H0();
        }
        if ((i4 & 8) != 0) {
            list = m0Var.G0();
        }
        if ((i4 & 16) != 0) {
            z3 = m0Var.I0();
        }
        return i(m0Var, fVar, y0Var, list, z3);
    }

    @JvmStatic
    @NotNull
    public static final m0 l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull y0 constructor, @NotNull List<? extends a1> arguments, boolean z3, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.h memberScope) {
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        kotlin.jvm.internal.f0.p(constructor, "constructor");
        kotlin.jvm.internal.f0.p(arguments, "arguments");
        kotlin.jvm.internal.f0.p(memberScope, "memberScope");
        n0 n0Var = new n0(constructor, arguments, z3, memberScope, new d(constructor, arguments, annotations, z3, memberScope));
        return annotations.isEmpty() ? n0Var : new j(n0Var, annotations);
    }

    @JvmStatic
    @NotNull
    public static final m0 m(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull y0 constructor, @NotNull List<? extends a1> arguments, boolean z3, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.h memberScope, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends m0> refinedTypeFactory) {
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        kotlin.jvm.internal.f0.p(constructor, "constructor");
        kotlin.jvm.internal.f0.p(arguments, "arguments");
        kotlin.jvm.internal.f0.p(memberScope, "memberScope");
        kotlin.jvm.internal.f0.p(refinedTypeFactory, "refinedTypeFactory");
        n0 n0Var = new n0(constructor, arguments, z3, memberScope, refinedTypeFactory);
        return annotations.isEmpty() ? n0Var : new j(n0Var, annotations);
    }
}
