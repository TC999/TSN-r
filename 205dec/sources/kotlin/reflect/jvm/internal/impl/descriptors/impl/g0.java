package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SimpleFunctionDescriptorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class g0 extends p implements u0 {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable u0 u0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull v0 v0Var) {
        super(kVar, u0Var, fVar, fVar2, kind, v0Var);
        if (kVar == null) {
            B(0);
        }
        if (fVar == null) {
            B(1);
        }
        if (fVar2 == null) {
            B(2);
        }
        if (kind == null) {
            B(3);
        }
        if (v0Var == null) {
            B(4);
        }
    }

    private static /* synthetic */ void B(int i4) {
        String str = (i4 == 13 || i4 == 17 || i4 == 18 || i4 == 23 || i4 == 24) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 13 || i4 == 17 || i4 == 18 || i4 == 23 || i4 == 24) ? 2 : 3];
        switch (i4) {
            case 1:
            case 6:
            case 21:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case 20:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 22:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 15:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 16:
                objArr[0] = "visibility";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 19:
                objArr[0] = "newOwner";
                break;
        }
        if (i4 == 13 || i4 == 17) {
            objArr[1] = "initialize";
        } else if (i4 == 18) {
            objArr[1] = "getOriginal";
        } else if (i4 == 23) {
            objArr[1] = "copy";
        } else if (i4 != 24) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i4) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
                objArr[2] = "initialize";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i4 != 13 && i4 != 17 && i4 != 18 && i4 != 23 && i4 != 24) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static g0 g1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull v0 v0Var) {
        if (kVar == null) {
            B(5);
        }
        if (fVar == null) {
            B(6);
        }
        if (fVar2 == null) {
            B(7);
        }
        if (kind == null) {
            B(8);
        }
        if (v0Var == null) {
            B(9);
        }
        return new g0(kVar, null, fVar, fVar2, kind, v0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    @NotNull
    protected p G0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.w wVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar2, @NotNull v0 v0Var) {
        if (kVar == null) {
            B(19);
        }
        if (kind == null) {
            B(20);
        }
        if (fVar2 == null) {
            B(21);
        }
        if (v0Var == null) {
            B(22);
        }
        u0 u0Var = (u0) wVar;
        if (fVar == null) {
            fVar = getName();
        }
        return new g0(kVar, u0Var, fVar2, fVar, kind, v0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: f1 */
    public u0 P(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.s sVar, CallableMemberDescriptor.Kind kind, boolean z3) {
        u0 u0Var = (u0) super.P(kVar, modality, sVar, kind, z3);
        if (u0Var == null) {
            B(23);
        }
        return u0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    @NotNull
    /* renamed from: h1 */
    public u0 h0() {
        u0 u0Var = (u0) super.h0();
        if (u0Var == null) {
            B(18);
        }
        return u0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    @NotNull
    /* renamed from: i1 */
    public g0 M0(@Nullable s0 s0Var, @Nullable s0 s0Var2, @NotNull List<? extends a1> list, @NotNull List<d1> list2, @Nullable kotlin.reflect.jvm.internal.impl.types.e0 e0Var, @Nullable Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        if (list == null) {
            B(10);
        }
        if (list2 == null) {
            B(11);
        }
        if (sVar == null) {
            B(12);
        }
        g0 j12 = j1(s0Var, s0Var2, list, list2, e0Var, modality, sVar, null);
        if (j12 == null) {
            B(13);
        }
        return j12;
    }

    @NotNull
    public g0 j1(@Nullable s0 s0Var, @Nullable s0 s0Var2, @NotNull List<? extends a1> list, @NotNull List<d1> list2, @Nullable kotlin.reflect.jvm.internal.impl.types.e0 e0Var, @Nullable Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, @Nullable Map<? extends a.InterfaceC1126a<?>, ?> map) {
        if (list == null) {
            B(14);
        }
        if (list2 == null) {
            B(15);
        }
        if (sVar == null) {
            B(16);
        }
        super.M0(s0Var, s0Var2, list, list2, e0Var, modality, sVar);
        if (map != null && !map.isEmpty()) {
            this.C = new LinkedHashMap(map);
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.w
    @NotNull
    public w.a<? extends u0> x() {
        w.a x3 = super.x();
        if (x3 == null) {
            B(24);
        }
        return x3;
    }
}
