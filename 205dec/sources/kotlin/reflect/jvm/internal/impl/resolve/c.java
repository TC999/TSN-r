package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DescriptorFactory.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c {

    /* compiled from: DescriptorFactory.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static class a extends kotlin.reflect.jvm.internal.impl.descriptors.impl.f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull v0 v0Var, boolean z3) {
            super(dVar, null, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), true, CallableMemberDescriptor.Kind.DECLARATION, v0Var);
            if (dVar == null) {
                B(0);
            }
            if (v0Var == null) {
                B(1);
            }
            k1(Collections.emptyList(), d.k(dVar, z3));
        }

        private static /* synthetic */ void B(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = "source";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    private static /* synthetic */ void a(int i4) {
        String str = (i4 == 12 || i4 == 23 || i4 == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 12 || i4 == 23 || i4 == 25) ? 2 : 3];
        switch (i4) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 30:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = "source";
                break;
            case 22:
            case 24:
                objArr[0] = "enumClass";
                break;
            case 26:
            case 27:
            case 28:
                objArr[0] = "descriptor";
                break;
            case 29:
                objArr[0] = "owner";
                break;
        }
        if (i4 == 12) {
            objArr[1] = "createSetter";
        } else if (i4 == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i4 != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i4) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 27:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 28:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 29:
            case 30:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String format = String.format(str, objArr);
        if (i4 != 12 && i4 != 23 && i4 != 25) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static d0 b(@NotNull p0 p0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
        if (p0Var == null) {
            a(13);
        }
        if (fVar == null) {
            a(14);
        }
        return g(p0Var, fVar, true, false, false);
    }

    @NotNull
    public static e0 c(@NotNull p0 p0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar2) {
        if (p0Var == null) {
            a(0);
        }
        if (fVar == null) {
            a(1);
        }
        if (fVar2 == null) {
            a(2);
        }
        return k(p0Var, fVar, fVar2, true, false, false, p0Var.getSource());
    }

    @NotNull
    public static u0 d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(24);
        }
        f.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0;
        g0 g12 = g0.g1(dVar, aVar.b(), kotlin.reflect.jvm.internal.impl.builtins.j.f56074c, CallableMemberDescriptor.Kind.SYNTHESIZED, dVar.getSource());
        g0 M0 = g12.M0(null, null, Collections.emptyList(), Collections.singletonList(new l0(g12, null, 0, aVar.b(), kotlin.reflect.jvm.internal.impl.name.f.f("value"), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(dVar).W(), false, false, false, null, dVar.getSource())), dVar.q(), Modality.FINAL, r.f56531e);
        if (M0 == null) {
            a(25);
        }
        return M0;
    }

    @NotNull
    public static u0 e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(22);
        }
        g0 M0 = g0.g1(dVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), kotlin.reflect.jvm.internal.impl.builtins.j.f56073b, CallableMemberDescriptor.Kind.SYNTHESIZED, dVar.getSource()).M0(null, null, Collections.emptyList(), Collections.emptyList(), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(dVar).l(Variance.INVARIANT, dVar.q()), Modality.FINAL, r.f56531e);
        if (M0 == null) {
            a(23);
        }
        return M0;
    }

    @Nullable
    public static s0 f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @Nullable kotlin.reflect.jvm.internal.impl.types.e0 e0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
        if (aVar == null) {
            a(29);
        }
        if (fVar == null) {
            a(30);
        }
        if (e0Var == null) {
            return null;
        }
        return new f0(aVar, new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.b(aVar, e0Var, null), fVar);
    }

    @NotNull
    public static d0 g(@NotNull p0 p0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, boolean z4, boolean z5) {
        if (p0Var == null) {
            a(15);
        }
        if (fVar == null) {
            a(16);
        }
        return h(p0Var, fVar, z3, z4, z5, p0Var.getSource());
    }

    @NotNull
    public static d0 h(@NotNull p0 p0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, boolean z4, boolean z5, @NotNull v0 v0Var) {
        if (p0Var == null) {
            a(17);
        }
        if (fVar == null) {
            a(18);
        }
        if (v0Var == null) {
            a(19);
        }
        return new d0(p0Var, fVar, p0Var.s(), p0Var.getVisibility(), z3, z4, z5, CallableMemberDescriptor.Kind.DECLARATION, null, v0Var);
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.descriptors.impl.f i(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull v0 v0Var) {
        if (dVar == null) {
            a(20);
        }
        if (v0Var == null) {
            a(21);
        }
        return new a(dVar, v0Var, false);
    }

    @NotNull
    public static e0 j(@NotNull p0 p0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar2, boolean z3, boolean z4, boolean z5, @NotNull s sVar, @NotNull v0 v0Var) {
        if (p0Var == null) {
            a(7);
        }
        if (fVar == null) {
            a(8);
        }
        if (fVar2 == null) {
            a(9);
        }
        if (sVar == null) {
            a(10);
        }
        if (v0Var == null) {
            a(11);
        }
        e0 e0Var = new e0(p0Var, fVar, p0Var.s(), sVar, z3, z4, z5, CallableMemberDescriptor.Kind.DECLARATION, null, v0Var);
        e0Var.M0(e0.K0(e0Var, p0Var.getType(), fVar2));
        return e0Var;
    }

    @NotNull
    public static e0 k(@NotNull p0 p0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar2, boolean z3, boolean z4, boolean z5, @NotNull v0 v0Var) {
        if (p0Var == null) {
            a(3);
        }
        if (fVar == null) {
            a(4);
        }
        if (fVar2 == null) {
            a(5);
        }
        if (v0Var == null) {
            a(6);
        }
        return j(p0Var, fVar, fVar2, z3, z4, z5, p0Var.getVisibility(), v0Var);
    }

    private static boolean l(@NotNull w wVar) {
        if (wVar == null) {
            a(28);
        }
        return wVar.i() == CallableMemberDescriptor.Kind.SYNTHESIZED && d.A(wVar.b());
    }

    public static boolean m(@NotNull w wVar) {
        if (wVar == null) {
            a(27);
        }
        return wVar.getName().equals(kotlin.reflect.jvm.internal.impl.builtins.j.f56074c) && l(wVar);
    }

    public static boolean n(@NotNull w wVar) {
        if (wVar == null) {
            a(26);
        }
        return wVar.getName().equals(kotlin.reflect.jvm.internal.impl.builtins.j.f56073b) && l(wVar);
    }
}
