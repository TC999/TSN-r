package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DescriptorSubstitutor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class r {
    private static /* synthetic */ void a(int i4) {
        String str = i4 != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i4 != 4 ? 3 : 2];
        switch (i4) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i4 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i4 != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String format = String.format(str, objArr);
        if (i4 == 4) {
            throw new IllegalStateException(format);
        }
    }

    @NotNull
    public static f1 b(@NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.a1> list, @NotNull d1 d1Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.a1> list2) {
        if (list == null) {
            a(0);
        }
        if (d1Var == null) {
            a(1);
        }
        if (kVar == null) {
            a(2);
        }
        if (list2 == null) {
            a(3);
        }
        f1 c4 = c(list, d1Var, kVar, list2, null);
        if (c4 != null) {
            return c4;
        }
        throw new AssertionError("Substitution failed");
    }

    @Nullable
    public static f1 c(@NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.a1> list, @NotNull d1 d1Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.a1> list2, @Nullable boolean[] zArr) {
        if (list == null) {
            a(5);
        }
        if (d1Var == null) {
            a(6);
        }
        if (kVar == null) {
            a(7);
        }
        if (list2 == null) {
            a(8);
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i4 = 0;
        for (kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var : list) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.k0 L0 = kotlin.reflect.jvm.internal.impl.descriptors.impl.k0.L0(kVar, a1Var.getAnnotations(), a1Var.l(), a1Var.o(), a1Var.getName(), i4, kotlin.reflect.jvm.internal.impl.descriptors.v0.f56634a, a1Var.N());
            hashMap.put(a1Var.j(), new c1(L0.q()));
            hashMap2.put(a1Var, L0);
            list2.add(L0);
            i4++;
        }
        z0 j4 = z0.j(hashMap);
        f1 h4 = f1.h(d1Var, j4);
        f1 h5 = f1.h(d1Var.h(), j4);
        for (kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var2 : list) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.k0 k0Var = (kotlin.reflect.jvm.internal.impl.descriptors.impl.k0) hashMap2.get(a1Var2);
            for (e0 e0Var : a1Var2.getUpperBounds()) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
                e0 p3 = (((b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1) && kotlin.reflect.jvm.internal.impl.types.typeUtil.a.j((kotlin.reflect.jvm.internal.impl.descriptors.a1) b4)) ? h4 : h5).p(e0Var, Variance.OUT_VARIANCE);
                if (p3 == null) {
                    return null;
                }
                if (p3 != e0Var && zArr != null) {
                    zArr[0] = true;
                }
                k0Var.H0(p3);
            }
            k0Var.Q0();
        }
        return h4;
    }
}
