package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PropertySetterDescriptorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class e0 extends b0 implements r0 {

    /* renamed from: p  reason: collision with root package name */
    static final /* synthetic */ boolean f56366p = false;

    /* renamed from: n  reason: collision with root package name */
    private d1 f56367n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final r0 f56368o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e0(@NotNull p0 p0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, boolean z3, boolean z4, boolean z5, @NotNull CallableMemberDescriptor.Kind kind, @Nullable r0 r0Var, @NotNull v0 v0Var) {
        super(modality, sVar, p0Var, fVar, kotlin.reflect.jvm.internal.impl.name.f.i("<set-" + p0Var.getName() + ">"), z3, z4, z5, kind, v0Var);
        e0 e0Var;
        e0 e0Var2;
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
        if (r0Var != 0) {
            e0Var2 = this;
            e0Var = r0Var;
        } else {
            e0Var = this;
            e0Var2 = e0Var;
        }
        e0Var2.f56368o = e0Var;
    }

    private static /* synthetic */ void B(int i4) {
        String str;
        int i5;
        switch (i4) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i4) {
            case 10:
            case 11:
            case 12:
            case 13:
                i5 = 2;
                break;
            default:
                i5 = 3;
                break;
        }
        Object[] objArr = new Object[i5];
        switch (i4) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i4) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i4) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i4) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static l0 K0(@NotNull r0 r0Var, @NotNull kotlin.reflect.jvm.internal.impl.types.e0 e0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
        if (r0Var == null) {
            B(7);
        }
        if (e0Var == null) {
            B(8);
        }
        if (fVar == null) {
            B(9);
        }
        return new l0(r0Var, null, 0, fVar, kotlin.reflect.jvm.internal.impl.name.f.i("<set-?>"), e0Var, false, false, false, null, v0.f56634a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d4) {
        return mVar.e(this, d4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b0, kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    @NotNull
    /* renamed from: L0 */
    public r0 h0() {
        r0 r0Var = this.f56368o;
        if (r0Var == null) {
            B(13);
        }
        return r0Var;
    }

    public void M0(@NotNull d1 d1Var) {
        if (d1Var == null) {
            B(6);
        }
        this.f56367n = d1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public Collection<? extends r0> d() {
        Collection<o0> G0 = super.G0(false);
        if (G0 == null) {
            B(10);
        }
        return G0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.e0 getReturnType() {
        kotlin.reflect.jvm.internal.impl.types.m0 Z = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(this).Z();
        if (Z == null) {
            B(12);
        }
        return Z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<d1> h() {
        d1 d1Var = this.f56367n;
        if (d1Var != null) {
            List<d1> singletonList = Collections.singletonList(d1Var);
            if (singletonList == null) {
                B(11);
            }
            return singletonList;
        }
        throw new IllegalStateException();
    }
}
