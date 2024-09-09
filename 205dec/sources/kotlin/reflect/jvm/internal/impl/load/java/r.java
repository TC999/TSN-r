package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.kotlin.k;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r implements ExternalOverridabilityCondition {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f56981a = new a(null);

    /* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        private final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.w wVar) {
            Object S4;
            if (wVar.h().size() != 1) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.k b4 = wVar.b();
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b4 : null;
            if (dVar == null) {
                return false;
            }
            List<d1> h4 = wVar.h();
            f0.o(h4, "f.valueParameters");
            S4 = kotlin.collections.f0.S4(h4);
            kotlin.reflect.jvm.internal.impl.descriptors.f b5 = ((d1) S4).getType().H0().b();
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b5 : null;
            return dVar2 != null && kotlin.reflect.jvm.internal.impl.builtins.h.p0(dVar) && f0.g(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(dVar), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(dVar2));
        }

        private final kotlin.reflect.jvm.internal.impl.load.kotlin.k c(kotlin.reflect.jvm.internal.impl.descriptors.w wVar, d1 d1Var) {
            if (!kotlin.reflect.jvm.internal.impl.load.kotlin.u.e(wVar) && !b(wVar)) {
                kotlin.reflect.jvm.internal.impl.types.e0 type = d1Var.getType();
                f0.o(type, "valueParameterDescriptor.type");
                return kotlin.reflect.jvm.internal.impl.load.kotlin.u.g(type);
            }
            kotlin.reflect.jvm.internal.impl.types.e0 type2 = d1Var.getType();
            f0.o(type2, "valueParameterDescriptor.type");
            return kotlin.reflect.jvm.internal.impl.load.kotlin.u.g(kotlin.reflect.jvm.internal.impl.types.typeUtil.a.q(type2));
        }

        public final boolean a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor) {
            List<Pair> T5;
            f0.p(superDescriptor, "superDescriptor");
            f0.p(subDescriptor, "subDescriptor");
            if ((subDescriptor instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) && (superDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.w)) {
                kotlin.reflect.jvm.internal.impl.load.java.descriptors.e eVar = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) subDescriptor;
                eVar.h().size();
                kotlin.reflect.jvm.internal.impl.descriptors.w wVar = (kotlin.reflect.jvm.internal.impl.descriptors.w) superDescriptor;
                wVar.h().size();
                List<d1> h4 = eVar.h0().h();
                f0.o(h4, "subDescriptor.original.valueParameters");
                List<d1> h5 = wVar.a().h();
                f0.o(h5, "superDescriptor.original.valueParameters");
                T5 = kotlin.collections.f0.T5(h4, h5);
                for (Pair pair : T5) {
                    d1 subParameter = (d1) pair.component1();
                    d1 superParameter = (d1) pair.component2();
                    f0.o(subParameter, "subParameter");
                    boolean z3 = c((kotlin.reflect.jvm.internal.impl.descriptors.w) subDescriptor, subParameter) instanceof k.d;
                    f0.o(superParameter, "superParameter");
                    if (z3 != (c(wVar, superParameter) instanceof k.d)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if ((aVar instanceof CallableMemberDescriptor) && (aVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.w) && !kotlin.reflect.jvm.internal.impl.builtins.h.e0(aVar2)) {
            e eVar = e.f56730n;
            kotlin.reflect.jvm.internal.impl.descriptors.w wVar = (kotlin.reflect.jvm.internal.impl.descriptors.w) aVar2;
            kotlin.reflect.jvm.internal.impl.name.f name = wVar.getName();
            f0.o(name, "subDescriptor.name");
            if (!eVar.l(name)) {
                SpecialGenericSignatures.a aVar3 = SpecialGenericSignatures.f56640a;
                kotlin.reflect.jvm.internal.impl.name.f name2 = wVar.getName();
                f0.o(name2, "subDescriptor.name");
                if (!aVar3.k(name2)) {
                    return false;
                }
            }
            CallableMemberDescriptor e4 = d0.e((CallableMemberDescriptor) aVar);
            boolean z02 = wVar.z0();
            boolean z3 = aVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.w;
            kotlin.reflect.jvm.internal.impl.descriptors.w wVar2 = z3 ? (kotlin.reflect.jvm.internal.impl.descriptors.w) aVar : null;
            if ((!(wVar2 != null && z02 == wVar2.z0())) && (e4 == null || !wVar.z0())) {
                return true;
            }
            if ((dVar instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.c) && wVar.q0() == null && e4 != null && !d0.f(dVar, e4)) {
                if ((e4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.w) && z3 && e.k((kotlin.reflect.jvm.internal.impl.descriptors.w) e4) != null) {
                    String c4 = kotlin.reflect.jvm.internal.impl.load.kotlin.u.c(wVar, false, false, 2, null);
                    kotlin.reflect.jvm.internal.impl.descriptors.w a4 = ((kotlin.reflect.jvm.internal.impl.descriptors.w) aVar).a();
                    f0.o(a4, "superDescriptor.original");
                    if (f0.g(c4, kotlin.reflect.jvm.internal.impl.load.kotlin.u.c(a4, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Contract a() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Result b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        f0.p(superDescriptor, "superDescriptor");
        f0.p(subDescriptor, "subDescriptor");
        if (c(superDescriptor, subDescriptor, dVar)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        if (f56981a.a(superDescriptor, subDescriptor)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
