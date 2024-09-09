package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ErasedOverridabilityCondition.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k implements ExternalOverridabilityCondition {

    /* compiled from: ErasedOverridabilityCondition.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56741a;

        static {
            int[] iArr = new int[OverridingUtil.OverrideCompatibilityInfo.Result.values().length];
            iArr[OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            f56741a = iArr;
        }
    }

    /* compiled from: ErasedOverridabilityCondition.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.l<d1, kotlin.reflect.jvm.internal.impl.types.e0> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56742a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.types.e0 invoke(d1 d1Var) {
            return d1Var.getType();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Contract a() {
        return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Result b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.sequences.m l12;
        kotlin.sequences.m d12;
        kotlin.sequences.m g22;
        List N;
        kotlin.sequences.m f22;
        boolean z3;
        kotlin.reflect.jvm.internal.impl.descriptors.a c4;
        List<a1> F;
        boolean z4;
        f0.p(superDescriptor, "superDescriptor");
        f0.p(subDescriptor, "subDescriptor");
        if (subDescriptor instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) {
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.e eVar = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) subDescriptor;
            List<a1> typeParameters = eVar.getTypeParameters();
            f0.o(typeParameters, "subDescriptor.typeParameters");
            if (!(!typeParameters.isEmpty())) {
                OverridingUtil.OverrideCompatibilityInfo x3 = OverridingUtil.x(superDescriptor, subDescriptor);
                if ((x3 == null ? null : x3.c()) != null) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                List<d1> h4 = eVar.h();
                f0.o(h4, "subDescriptor.valueParameters");
                l12 = kotlin.collections.f0.l1(h4);
                d12 = SequencesKt___SequencesKt.d1(l12, b.f56742a);
                kotlin.reflect.jvm.internal.impl.types.e0 returnType = eVar.getReturnType();
                f0.m(returnType);
                g22 = SequencesKt___SequencesKt.g2(d12, returnType);
                s0 Q = eVar.Q();
                N = CollectionsKt__CollectionsKt.N(Q == null ? null : Q.getType());
                f22 = SequencesKt___SequencesKt.f2(g22, N);
                Iterator it = f22.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    }
                    kotlin.reflect.jvm.internal.impl.types.e0 e0Var = (kotlin.reflect.jvm.internal.impl.types.e0) it.next();
                    if (!(!e0Var.G0().isEmpty()) || (e0Var.K0() instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.types.e)) {
                        z4 = false;
                        continue;
                    } else {
                        z4 = true;
                        continue;
                    }
                    if (z4) {
                        z3 = true;
                        break;
                    }
                }
                if (!z3 && (c4 = superDescriptor.c(new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.d(null, 1, null).c())) != null) {
                    if (c4 instanceof u0) {
                        u0 u0Var = (u0) c4;
                        List<a1> typeParameters2 = u0Var.getTypeParameters();
                        f0.o(typeParameters2, "erasedSuper.typeParameters");
                        if (!typeParameters2.isEmpty()) {
                            w.a<? extends u0> x4 = u0Var.x();
                            F = CollectionsKt__CollectionsKt.F();
                            c4 = x4.p(F).build();
                            f0.m(c4);
                        }
                    }
                    OverridingUtil.OverrideCompatibilityInfo.Result c5 = OverridingUtil.f57794d.G(c4, subDescriptor, false).c();
                    f0.o(c5, "DEFAULT.isOverridableByW\u2026Descriptor, false).result");
                    if (a.f56741a[c5.ordinal()] == 1) {
                        return ExternalOverridabilityCondition.Result.OVERRIDABLE;
                    }
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                return ExternalOverridabilityCondition.Result.UNKNOWN;
            }
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
