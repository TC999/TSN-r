package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VariableDescriptorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class m0 extends k implements f1 {

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ boolean f56403f = false;

    /* renamed from: e  reason: collision with root package name */
    protected kotlin.reflect.jvm.internal.impl.types.e0 f56404e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @Nullable kotlin.reflect.jvm.internal.impl.types.e0 e0Var, @NotNull v0 v0Var) {
        super(kVar, fVar, fVar2, v0Var);
        if (kVar == null) {
            B(0);
        }
        if (fVar == null) {
            B(1);
        }
        if (fVar2 == null) {
            B(2);
        }
        if (v0Var == null) {
            B(3);
        }
        this.f56404e = e0Var;
    }

    private static /* synthetic */ void B(int i4) {
        String str;
        int i5;
        switch (i4) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i4) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                i5 = 2;
                break;
            default:
                i5 = 3;
                break;
        }
        Object[] objArr = new Object[i5];
        switch (i4) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i4) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i4) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i4) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    @NotNull
    /* renamed from: C0 */
    public f1 h0() {
        f1 f1Var = (f1) super.a();
        if (f1Var == null) {
            B(5);
        }
        return f1Var;
    }

    public void F0(kotlin.reflect.jvm.internal.impl.types.e0 e0Var) {
        this.f56404e = e0Var;
    }

    public s0 M() {
        return null;
    }

    public s0 Q() {
        return null;
    }

    @NotNull
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> d() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            B(7);
        }
        return emptySet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean e0() {
        return false;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.e0 getReturnType() {
        kotlin.reflect.jvm.internal.impl.types.e0 type = getType();
        if (type == null) {
            B(9);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.e0 getType() {
        kotlin.reflect.jvm.internal.impl.types.e0 e0Var = this.f56404e;
        if (e0Var == null) {
            B(4);
        }
        return e0Var;
    }

    @NotNull
    public List<a1> getTypeParameters() {
        List<a1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            B(8);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<d1> h() {
        List<d1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            B(6);
        }
        return emptyList;
    }

    public boolean isConst() {
        return false;
    }

    @Nullable
    public <V> V s0(a.InterfaceC1126a<V> interfaceC1126a) {
        return null;
    }
}
