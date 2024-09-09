package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StarProjectionImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s0 {

    /* compiled from: StarProjectionImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends z0 {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List<y0> f58413d;

        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends y0> list) {
            this.f58413d = list;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.z0
        @Nullable
        public a1 k(@NotNull y0 key) {
            kotlin.jvm.internal.f0.p(key, "key");
            if (this.f58413d.contains(key)) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = key.b();
                if (b4 != null) {
                    return h1.t((kotlin.reflect.jvm.internal.impl.descriptors.a1) b4);
                }
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            }
            return null;
        }
    }

    private static final e0 a(List<? extends y0> list, List<? extends e0> list2, kotlin.reflect.jvm.internal.impl.builtins.h hVar) {
        Object m22;
        f1 g4 = f1.g(new a(list));
        m22 = kotlin.collections.f0.m2(list2);
        e0 p3 = g4.p((e0) m22, Variance.OUT_VARIANCE);
        if (p3 == null) {
            p3 = hVar.y();
        }
        kotlin.jvm.internal.f0.o(p3, "typeParameters: List<Typ\u2026 ?: builtIns.defaultBound");
        return p3;
    }

    @NotNull
    public static final e0 b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var) {
        int Z;
        int Z2;
        kotlin.jvm.internal.f0.p(a1Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.k b4 = a1Var.b();
        kotlin.jvm.internal.f0.o(b4, "this.containingDeclaration");
        if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) {
            List<kotlin.reflect.jvm.internal.impl.descriptors.a1> parameters = ((kotlin.reflect.jvm.internal.impl.descriptors.g) b4).j().getParameters();
            kotlin.jvm.internal.f0.o(parameters, "descriptor.typeConstructor.parameters");
            Z2 = kotlin.collections.y.Z(parameters, 10);
            ArrayList arrayList = new ArrayList(Z2);
            for (kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var2 : parameters) {
                y0 j4 = a1Var2.j();
                kotlin.jvm.internal.f0.o(j4, "it.typeConstructor");
                arrayList.add(j4);
            }
            List<e0> upperBounds = a1Var.getUpperBounds();
            kotlin.jvm.internal.f0.o(upperBounds, "upperBounds");
            return a(arrayList, upperBounds, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(a1Var));
        } else if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.w) {
            List<kotlin.reflect.jvm.internal.impl.descriptors.a1> typeParameters = ((kotlin.reflect.jvm.internal.impl.descriptors.w) b4).getTypeParameters();
            kotlin.jvm.internal.f0.o(typeParameters, "descriptor.typeParameters");
            Z = kotlin.collections.y.Z(typeParameters, 10);
            ArrayList arrayList2 = new ArrayList(Z);
            for (kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var3 : typeParameters) {
                y0 j5 = a1Var3.j();
                kotlin.jvm.internal.f0.o(j5, "it.typeConstructor");
                arrayList2.add(j5);
            }
            List<e0> upperBounds2 = a1Var.getUpperBounds();
            kotlin.jvm.internal.f0.o(upperBounds2, "upperBounds");
            return a(arrayList2, upperBounds2, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(a1Var));
        } else {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
    }
}
