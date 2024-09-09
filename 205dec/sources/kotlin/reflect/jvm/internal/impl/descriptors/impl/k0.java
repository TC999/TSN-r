package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeParameterDescriptorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class k0 extends e {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final d2.l<kotlin.reflect.jvm.internal.impl.types.e0, Void> f56391k;

    /* renamed from: l  reason: collision with root package name */
    private final List<kotlin.reflect.jvm.internal.impl.types.e0> f56392l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f56393m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private k0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, @NotNull Variance variance, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, int i4, @NotNull v0 v0Var, @Nullable d2.l<kotlin.reflect.jvm.internal.impl.types.e0, Void> lVar, @NotNull y0 y0Var, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        super(nVar, kVar, fVar, fVar2, variance, z3, i4, v0Var, y0Var);
        if (kVar == null) {
            B(19);
        }
        if (fVar == null) {
            B(20);
        }
        if (variance == null) {
            B(21);
        }
        if (fVar2 == null) {
            B(22);
        }
        if (v0Var == null) {
            B(23);
        }
        if (y0Var == null) {
            B(24);
        }
        if (nVar == null) {
            B(25);
        }
        this.f56392l = new ArrayList(1);
        this.f56393m = false;
        this.f56391k = lVar;
    }

    private static /* synthetic */ void B(int i4) {
        String str = (i4 == 5 || i4 == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 5 || i4 == 28) ? 2 : 3];
        switch (i4) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i4 == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i4 != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i4) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String format = String.format(str, objArr);
        if (i4 != 5 && i4 != 28) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    private void I0() {
        if (this.f56393m) {
            return;
        }
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + P0());
    }

    private void J0() {
        if (this.f56393m) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + P0());
        }
    }

    public static k0 K0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, @NotNull Variance variance, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, int i4, @NotNull v0 v0Var, @Nullable d2.l<kotlin.reflect.jvm.internal.impl.types.e0, Void> lVar, @NotNull y0 y0Var, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        if (kVar == null) {
            B(12);
        }
        if (fVar == null) {
            B(13);
        }
        if (variance == null) {
            B(14);
        }
        if (fVar2 == null) {
            B(15);
        }
        if (v0Var == null) {
            B(16);
        }
        if (y0Var == null) {
            B(17);
        }
        if (nVar == null) {
            B(18);
        }
        return new k0(kVar, fVar, z3, variance, fVar2, i4, v0Var, lVar, y0Var, nVar);
    }

    public static k0 L0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, @NotNull Variance variance, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, int i4, @NotNull v0 v0Var, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        if (kVar == null) {
            B(6);
        }
        if (fVar == null) {
            B(7);
        }
        if (variance == null) {
            B(8);
        }
        if (fVar2 == null) {
            B(9);
        }
        if (v0Var == null) {
            B(10);
        }
        if (nVar == null) {
            B(11);
        }
        return K0(kVar, fVar, z3, variance, fVar2, i4, v0Var, null, y0.a.f56639a, nVar);
    }

    @NotNull
    public static a1 M0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, @NotNull Variance variance, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, int i4, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        if (kVar == null) {
            B(0);
        }
        if (fVar == null) {
            B(1);
        }
        if (variance == null) {
            B(2);
        }
        if (fVar2 == null) {
            B(3);
        }
        if (nVar == null) {
            B(4);
        }
        k0 L0 = L0(kVar, fVar, z3, variance, fVar2, i4, v0.f56634a, nVar);
        L0.H0(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(kVar).y());
        L0.Q0();
        return L0;
    }

    private void N0(kotlin.reflect.jvm.internal.impl.types.e0 e0Var) {
        if (kotlin.reflect.jvm.internal.impl.types.g0.a(e0Var)) {
            return;
        }
        this.f56392l.add(e0Var);
    }

    private String P0() {
        return getName() + " declared in " + kotlin.reflect.jvm.internal.impl.resolve.d.m(b());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    protected void F0(@NotNull kotlin.reflect.jvm.internal.impl.types.e0 e0Var) {
        if (e0Var == null) {
            B(27);
        }
        d2.l<kotlin.reflect.jvm.internal.impl.types.e0, Void> lVar = this.f56391k;
        if (lVar == null) {
            return;
        }
        lVar.invoke(e0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    @NotNull
    protected List<kotlin.reflect.jvm.internal.impl.types.e0> G0() {
        I0();
        List<kotlin.reflect.jvm.internal.impl.types.e0> list = this.f56392l;
        if (list == null) {
            B(28);
        }
        return list;
    }

    public void H0(@NotNull kotlin.reflect.jvm.internal.impl.types.e0 e0Var) {
        if (e0Var == null) {
            B(26);
        }
        J0();
        N0(e0Var);
    }

    public boolean O0() {
        return this.f56393m;
    }

    public void Q0() {
        J0();
        this.f56393m = true;
    }
}
