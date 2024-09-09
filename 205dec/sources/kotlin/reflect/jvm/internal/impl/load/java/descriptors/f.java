package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.o;
import kotlin.reflect.jvm.internal.impl.storage.j;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaPropertyDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f extends c0 implements a {
    private final boolean C;
    @Nullable
    private final Pair<a.InterfaceC1126a<?>, ?> D;
    private e0 E;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull Modality modality, @NotNull s sVar, boolean z3, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @NotNull v0 v0Var, @Nullable p0 p0Var, @NotNull CallableMemberDescriptor.Kind kind, boolean z4, @Nullable Pair<a.InterfaceC1126a<?>, ?> pair) {
        super(kVar, p0Var, fVar, modality, sVar, z3, fVar2, kind, v0Var, false, false, false, false, false, false);
        if (kVar == null) {
            B(0);
        }
        if (fVar == null) {
            B(1);
        }
        if (modality == null) {
            B(2);
        }
        if (sVar == null) {
            B(3);
        }
        if (fVar2 == null) {
            B(4);
        }
        if (v0Var == null) {
            B(5);
        }
        if (kind == null) {
            B(6);
        }
        this.E = null;
        this.C = z4;
        this.D = pair;
    }

    private static /* synthetic */ void B(int i4) {
        String str = i4 != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i4 != 21 ? 3 : 2];
        switch (i4) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case 22:
                objArr[0] = "inType";
                break;
        }
        if (i4 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i4) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            case 22:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i4 == 21) {
            throw new IllegalStateException(format);
        }
    }

    @NotNull
    public static f Y0(@NotNull k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull Modality modality, @NotNull s sVar, boolean z3, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @NotNull v0 v0Var, boolean z4) {
        if (kVar == null) {
            B(7);
        }
        if (fVar == null) {
            B(8);
        }
        if (modality == null) {
            B(9);
        }
        if (sVar == null) {
            B(10);
        }
        if (fVar2 == null) {
            B(11);
        }
        if (v0Var == null) {
            B(12);
        }
        return new f(kVar, fVar, modality, sVar, z3, fVar2, v0Var, null, CallableMemberDescriptor.Kind.DECLARATION, z4, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c0
    @NotNull
    protected c0 K0(@NotNull k kVar, @NotNull Modality modality, @NotNull s sVar, @Nullable p0 p0Var, @NotNull CallableMemberDescriptor.Kind kind, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull v0 v0Var) {
        if (kVar == null) {
            B(13);
        }
        if (modality == null) {
            B(14);
        }
        if (sVar == null) {
            B(15);
        }
        if (kind == null) {
            B(16);
        }
        if (fVar == null) {
            B(17);
        }
        if (v0Var == null) {
            B(18);
        }
        return new f(kVar, getAnnotations(), modality, sVar, O(), fVar, v0Var, p0Var, kind, this.C, this.D);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c0
    public void U0(@NotNull e0 e0Var) {
        if (e0Var == null) {
            B(22);
        }
        this.E = e0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.a
    @NotNull
    public a Z(@Nullable e0 e0Var, @NotNull List<i> list, @NotNull e0 e0Var2, @Nullable Pair<a.InterfaceC1126a<?>, ?> pair) {
        d0 d0Var;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.e0 e0Var3;
        if (list == null) {
            B(19);
        }
        if (e0Var2 == null) {
            B(20);
        }
        p0 h02 = h0() == this ? null : h0();
        f fVar = new f(b(), getAnnotations(), s(), getVisibility(), O(), getName(), getSource(), h02, i(), this.C, pair);
        d0 getter = getGetter();
        if (getter != null) {
            d0Var = r15;
            d0 d0Var2 = new d0(fVar, getter.getAnnotations(), getter.s(), getter.getVisibility(), getter.H(), getter.isExternal(), getter.isInline(), i(), h02 == null ? null : h02.getGetter(), getter.getSource());
            d0Var.I0(getter.q0());
            d0Var.L0(e0Var2);
        } else {
            d0Var = null;
        }
        r0 setter = getSetter();
        if (setter != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.e0 e0Var4 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.e0(fVar, setter.getAnnotations(), setter.s(), setter.getVisibility(), setter.H(), setter.isExternal(), setter.isInline(), i(), h02 == null ? null : h02.getSetter(), setter.getSource());
            e0Var4.I0(e0Var4.q0());
            e0Var4.M0(setter.h().get(0));
            e0Var3 = e0Var4;
        } else {
            e0Var3 = null;
        }
        fVar.Q0(d0Var, e0Var3, u0(), R());
        fVar.V0(R0());
        j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> jVar = this.f56425h;
        if (jVar != null) {
            fVar.G0(jVar);
        }
        fVar.A0(d());
        fVar.W0(e0Var2, getTypeParameters(), M(), e0Var == null ? null : kotlin.reflect.jvm.internal.impl.resolve.c.f(this, e0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b()));
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean e0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c0, kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.f1
    public boolean isConst() {
        e0 type = getType();
        return this.C && kotlin.reflect.jvm.internal.impl.descriptors.h.a(type) && (!o.i(type) || kotlin.reflect.jvm.internal.impl.builtins.h.t0(type));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c0, kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public <V> V s0(a.InterfaceC1126a<V> interfaceC1126a) {
        Pair<a.InterfaceC1126a<?>, ?> pair = this.D;
        if (pair == null || !pair.getFirst().equals(interfaceC1126a)) {
            return null;
        }
        return (V) this.D.getSecond();
    }
}
