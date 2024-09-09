package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import d2.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.y;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.h;
import kotlin.reflect.jvm.internal.impl.renderer.a;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.b0;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.j1;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.y0;
import kotlin.reflect.jvm.internal.impl.types.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CapturedTypeApproximation.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {

    /* compiled from: CapturedTypeApproximation.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f58422a;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.INVARIANT.ordinal()] = 1;
            iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            f58422a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CapturedTypeApproximation.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.types.typesApproximation.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1185b extends Lambda implements l<l1, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final C1185b f58423a = new C1185b();

        C1185b() {
            super(1);
        }

        @Override // d2.l
        /* renamed from: a */
        public final Boolean invoke(l1 it) {
            f0.o(it, "it");
            return Boolean.valueOf(kotlin.reflect.jvm.internal.impl.resolve.calls.inference.d.d(it));
        }
    }

    /* compiled from: CapturedTypeApproximation.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends z0 {
        c() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.z0
        @Nullable
        public a1 k(@NotNull y0 key) {
            f0.p(key, "key");
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b bVar = key instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b ? (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b) key : null;
            if (bVar == null) {
                return null;
            }
            if (bVar.getProjection().b()) {
                return new c1(Variance.OUT_VARIANCE, bVar.getProjection().getType());
            }
            return bVar.getProjection();
        }
    }

    /* compiled from: CapturedTypeApproximation.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements l<kotlin.reflect.jvm.internal.impl.renderer.d, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f58424a = new d();

        d() {
            super(1);
        }

        public final void a(@NotNull kotlin.reflect.jvm.internal.impl.renderer.d withOptions) {
            f0.p(withOptions, "$this$withOptions");
            withOptions.o(a.C1161a.f57720a);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(kotlin.reflect.jvm.internal.impl.renderer.d dVar) {
            a(dVar);
            return f1.f55527a;
        }
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<e0> a(@NotNull e0 type) {
        List<Pair> T5;
        Object e4;
        f0.p(type, "type");
        if (b0.b(type)) {
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<e0> a4 = a(b0.c(type));
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<e0> a5 = a(b0.d(type));
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<>(j1.b(kotlin.reflect.jvm.internal.impl.types.f0.d(b0.c(a4.c()), b0.d(a5.c())), type), j1.b(kotlin.reflect.jvm.internal.impl.types.f0.d(b0.c(a4.d()), b0.d(a5.d())), type));
        }
        y0 H0 = type.H0();
        if (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.d.d(type)) {
            a1 projection = ((kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b) H0).getProjection();
            e0 type2 = projection.getType();
            f0.o(type2, "typeProjection.type");
            e0 b4 = b(type2, type);
            int i4 = a.f58422a[projection.c().ordinal()];
            if (i4 == 2) {
                m0 I = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.h(type).I();
                f0.o(I, "type.builtIns.nullableAnyType");
                return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<>(b4, I);
            } else if (i4 == 3) {
                m0 H = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.h(type).H();
                f0.o(H, "type.builtIns.nothingType");
                return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<>(b(H, type), b4);
            } else {
                throw new AssertionError(f0.C("Only nontrivial projections should have been captured, not: ", projection));
            }
        } else if (!type.G0().isEmpty() && type.G0().size() == H0.getParameters().size()) {
            ArrayList<kotlin.reflect.jvm.internal.impl.types.typesApproximation.c> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<a1> G0 = type.G0();
            List<kotlin.reflect.jvm.internal.impl.descriptors.a1> parameters = H0.getParameters();
            f0.o(parameters, "typeConstructor.parameters");
            T5 = kotlin.collections.f0.T5(G0, parameters);
            for (Pair pair : T5) {
                a1 a1Var = (a1) pair.component1();
                kotlin.reflect.jvm.internal.impl.descriptors.a1 typeParameter = (kotlin.reflect.jvm.internal.impl.descriptors.a1) pair.component2();
                f0.o(typeParameter, "typeParameter");
                kotlin.reflect.jvm.internal.impl.types.typesApproximation.c g4 = g(a1Var, typeParameter);
                if (a1Var.b()) {
                    arrayList.add(g4);
                    arrayList2.add(g4);
                } else {
                    kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<kotlin.reflect.jvm.internal.impl.types.typesApproximation.c> d4 = d(g4);
                    arrayList.add(d4.a());
                    arrayList2.add(d4.b());
                }
            }
            boolean z3 = true;
            if (!arrayList.isEmpty()) {
                for (kotlin.reflect.jvm.internal.impl.types.typesApproximation.c cVar : arrayList) {
                    if (!cVar.d()) {
                        break;
                    }
                }
            }
            z3 = false;
            if (z3) {
                e4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.h(type).H();
                f0.o(e4, "type.builtIns.nothingType");
            } else {
                e4 = e(type, arrayList);
            }
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<>(e4, e(type, arrayList2));
        } else {
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<>(type, type);
        }
    }

    private static final e0 b(e0 e0Var, e0 e0Var2) {
        e0 r3 = h1.r(e0Var, e0Var2.I0());
        f0.o(r3, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return r3;
    }

    @Nullable
    public static final a1 c(@Nullable a1 a1Var, boolean z3) {
        if (a1Var == null) {
            return null;
        }
        if (a1Var.b()) {
            return a1Var;
        }
        e0 type = a1Var.getType();
        f0.o(type, "typeProjection.type");
        if (h1.c(type, C1185b.f58423a)) {
            Variance c4 = a1Var.c();
            f0.o(c4, "typeProjection.projectionKind");
            if (c4 == Variance.OUT_VARIANCE) {
                return new c1(c4, a(type).d());
            }
            if (z3) {
                return new c1(c4, a(type).c());
            }
            return f(a1Var);
        }
        return a1Var;
    }

    private static final kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<kotlin.reflect.jvm.internal.impl.types.typesApproximation.c> d(kotlin.reflect.jvm.internal.impl.types.typesApproximation.c cVar) {
        kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<e0> a4 = a(cVar.a());
        kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<e0> a5 = a(cVar.b());
        return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<>(new kotlin.reflect.jvm.internal.impl.types.typesApproximation.c(cVar.c(), a4.b(), a5.a()), new kotlin.reflect.jvm.internal.impl.types.typesApproximation.c(cVar.c(), a4.a(), a5.b()));
    }

    private static final e0 e(e0 e0Var, List<kotlin.reflect.jvm.internal.impl.types.typesApproximation.c> list) {
        int Z;
        e0Var.G0().size();
        list.size();
        Z = y.Z(list, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (kotlin.reflect.jvm.internal.impl.types.typesApproximation.c cVar : list) {
            arrayList.add(h(cVar));
        }
        return e1.e(e0Var, arrayList, null, null, 6, null);
    }

    private static final a1 f(a1 a1Var) {
        kotlin.reflect.jvm.internal.impl.types.f1 g4 = kotlin.reflect.jvm.internal.impl.types.f1.g(new c());
        f0.o(g4, "create(object : TypeCons\u2026ojection\n        }\n    })");
        return g4.t(a1Var);
    }

    private static final kotlin.reflect.jvm.internal.impl.types.typesApproximation.c g(a1 a1Var, kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var2) {
        int i4 = a.f58422a[kotlin.reflect.jvm.internal.impl.types.f1.c(a1Var2.o(), a1Var).ordinal()];
        if (i4 == 1) {
            e0 type = a1Var.getType();
            f0.o(type, "type");
            e0 type2 = a1Var.getType();
            f0.o(type2, "type");
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.c(a1Var2, type, type2);
        } else if (i4 == 2) {
            e0 type3 = a1Var.getType();
            f0.o(type3, "type");
            m0 I = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(a1Var2).I();
            f0.o(I, "typeParameter.builtIns.nullableAnyType");
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.c(a1Var2, type3, I);
        } else if (i4 == 3) {
            m0 H = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(a1Var2).H();
            f0.o(H, "typeParameter.builtIns.nothingType");
            e0 type4 = a1Var.getType();
            f0.o(type4, "type");
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.c(a1Var2, H, type4);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final a1 h(kotlin.reflect.jvm.internal.impl.types.typesApproximation.c cVar) {
        cVar.d();
        if (!f0.g(cVar.a(), cVar.b())) {
            Variance o4 = cVar.c().o();
            Variance variance = Variance.IN_VARIANCE;
            if (o4 != variance) {
                if (!h.l0(cVar.a()) || cVar.c().o() == variance) {
                    return h.n0(cVar.b()) ? new c1(i(cVar, variance), cVar.a()) : new c1(i(cVar, Variance.OUT_VARIANCE), cVar.b());
                }
                return new c1(i(cVar, Variance.OUT_VARIANCE), cVar.b());
            }
        }
        return new c1(cVar.a());
    }

    private static final Variance i(kotlin.reflect.jvm.internal.impl.types.typesApproximation.c cVar, Variance variance) {
        return variance == cVar.c().o() ? Variance.INVARIANT : variance;
    }
}
