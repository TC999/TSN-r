package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PropertyGetterDescriptorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d0 extends b0 implements q0 {

    /* renamed from: n  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.types.e0 f56350n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final q0 f56351o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d0(@NotNull p0 p0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, boolean z3, boolean z4, boolean z5, @NotNull CallableMemberDescriptor.Kind kind, @Nullable q0 q0Var, @NotNull v0 v0Var) {
        super(modality, sVar, p0Var, fVar, kotlin.reflect.jvm.internal.impl.name.f.i("<get-" + p0Var.getName() + ">"), z3, z4, z5, kind, v0Var);
        d0 d0Var;
        d0 d0Var2;
        if (p0Var == null) {
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
        if (kind == null) {
            B(4);
        }
        if (v0Var == null) {
            B(5);
        }
        if (q0Var != 0) {
            d0Var2 = this;
            d0Var = q0Var;
        } else {
            d0Var = this;
            d0Var2 = d0Var;
        }
        d0Var2.f56351o = d0Var;
    }

    private static /* synthetic */ void B(int i4) {
        String str = (i4 == 6 || i4 == 7 || i4 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 6 || i4 == 7 || i4 == 8) ? 2 : 3];
        switch (i4) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i4 == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i4 == 7) {
            objArr[1] = "getValueParameters";
        } else if (i4 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i4 != 6 && i4 != 7 && i4 != 8) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i4 != 6 && i4 != 7 && i4 != 8) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d4) {
        return mVar.g(this, d4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b0, kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    @NotNull
    /* renamed from: K0 */
    public q0 h0() {
        q0 q0Var = this.f56351o;
        if (q0Var == null) {
            B(8);
        }
        return q0Var;
    }

    public void L0(kotlin.reflect.jvm.internal.impl.types.e0 e0Var) {
        if (e0Var == null) {
            e0Var = V().getType();
        }
        this.f56350n = e0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public Collection<? extends q0> d() {
        Collection<o0> G0 = super.G0(true);
        if (G0 == null) {
            B(6);
        }
        return G0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public kotlin.reflect.jvm.internal.impl.types.e0 getReturnType() {
        return this.f56350n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<d1> h() {
        List<d1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            B(7);
        }
        return emptyList;
    }
}
