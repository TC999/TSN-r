package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractReceiverParameterDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class c extends j implements s0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
        super(fVar, kotlin.reflect.jvm.internal.impl.name.h.f57584h);
        if (fVar == null) {
            B(0);
        }
    }

    private static /* synthetic */ void B(int i4) {
        String str;
        int i5;
        switch (i4) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i4) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                i5 = 2;
                break;
            default:
                i5 = 3;
                break;
        }
        Object[] objArr = new Object[i5];
        switch (i4) {
            case 1:
                objArr[0] = "substitutor";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i4) {
            case 2:
                objArr[1] = "getTypeParameters";
                break;
            case 3:
                objArr[1] = "getType";
                break;
            case 4:
                objArr[1] = "getValueParameters";
                break;
            case 5:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 6:
                objArr[1] = "getVisibility";
                break;
            case 7:
                objArr[1] = "getOriginal";
                break;
            case 8:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i4) {
            case 1:
                objArr[2] = "substitute";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i4) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d4) {
        return mVar.l(this, d4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public s0 M() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public s0 Q() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> d() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            B(5);
        }
        return emptySet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean e0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public kotlin.reflect.jvm.internal.impl.types.e0 getReturnType() {
        return getType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public v0 getSource() {
        v0 v0Var = v0.f56634a;
        if (v0Var == null) {
            B(8);
        }
        return v0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.e0 getType() {
        kotlin.reflect.jvm.internal.impl.types.e0 type = getValue().getType();
        if (type == null) {
            B(3);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<a1> getTypeParameters() {
        List<a1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            B(2);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = kotlin.reflect.jvm.internal.impl.descriptors.r.f56532f;
        if (sVar == null) {
            B(6);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<d1> h() {
        List<d1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            B(4);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    /* renamed from: h0 */
    public kotlin.reflect.jvm.internal.impl.descriptors.m0 a() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public <V> V s0(a.InterfaceC1126a<V> interfaceC1126a) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.x0
    @Nullable
    public s0 c(@NotNull f1 f1Var) {
        kotlin.reflect.jvm.internal.impl.types.e0 p3;
        if (f1Var == null) {
            B(1);
        }
        if (f1Var.k()) {
            return this;
        }
        if (b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            p3 = f1Var.p(getType(), Variance.OUT_VARIANCE);
        } else {
            p3 = f1Var.p(getType(), Variance.INVARIANT);
        }
        if (p3 == null) {
            return null;
        }
        return p3 == getType() ? this : new f0(b(), new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h(p3), getAnnotations());
    }
}
