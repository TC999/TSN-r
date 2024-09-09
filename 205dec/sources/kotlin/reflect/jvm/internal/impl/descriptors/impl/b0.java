package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.types.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PropertyAccessorDescriptorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b0 extends k implements o0 {

    /* renamed from: m  reason: collision with root package name */
    static final /* synthetic */ boolean f56305m = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f56306e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f56307f;

    /* renamed from: g  reason: collision with root package name */
    private final Modality f56308g;

    /* renamed from: h  reason: collision with root package name */
    private final p0 f56309h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f56310i;

    /* renamed from: j  reason: collision with root package name */
    private final CallableMemberDescriptor.Kind f56311j;

    /* renamed from: k  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.s f56312k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.w f56313l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(@NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, @NotNull p0 p0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, boolean z3, boolean z4, boolean z5, CallableMemberDescriptor.Kind kind, @NotNull v0 v0Var) {
        super(p0Var.b(), fVar, fVar2, v0Var);
        if (modality == null) {
            B(0);
        }
        if (sVar == null) {
            B(1);
        }
        if (p0Var == null) {
            B(2);
        }
        if (fVar == null) {
            B(3);
        }
        if (fVar2 == null) {
            B(4);
        }
        if (v0Var == null) {
            B(5);
        }
        this.f56313l = null;
        this.f56308g = modality;
        this.f56312k = sVar;
        this.f56309h = p0Var;
        this.f56306e = z3;
        this.f56307f = z4;
        this.f56310i = z5;
        this.f56311j = kind;
    }

    private static /* synthetic */ void B(int i4) {
        String str;
        int i5;
        switch (i4) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i4) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                i5 = 2;
                break;
            case 7:
            default:
                i5 = 3;
                break;
        }
        Object[] objArr = new Object[i5];
        switch (i4) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 14:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i4) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getModality";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 12:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 13:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i4) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 14:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i4) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(format);
            case 7:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void A0(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            B(14);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean B0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: C0 */
    public o0 P(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.s sVar, CallableMemberDescriptor.Kind kind, boolean z3) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean E() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    @NotNull
    /* renamed from: F0 */
    public abstract o0 h0();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Collection<o0> G0(boolean z3) {
        ArrayList arrayList = new ArrayList(0);
        for (p0 p0Var : V().d()) {
            o0 getter = z3 ? p0Var.getGetter() : p0Var.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o0
    public boolean H() {
        return this.f56306e;
    }

    public void H0(boolean z3) {
        this.f56306e = z3;
    }

    public void I0(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.w wVar) {
        this.f56313l = wVar;
    }

    public void J0(kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        this.f56312k = sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public s0 M() {
        return V().M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public s0 Q() {
        return V().Q();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o0
    @NotNull
    public p0 V() {
        p0 p0Var = this.f56309h;
        if (p0Var == null) {
            B(12);
        }
        return p0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean X() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean e0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<a1> getTypeParameters() {
        List<a1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            B(8);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = this.f56312k;
        if (sVar == null) {
            B(10);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind i() {
        CallableMemberDescriptor.Kind kind = this.f56311j;
        if (kind == null) {
            B(6);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean i0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean isExternal() {
        return this.f56307f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean isInfix() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean isInline() {
        return this.f56310i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean isOperator() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.w q0() {
        return this.f56313l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public Modality s() {
        Modality modality = this.f56308g;
        if (modality == null) {
            B(9);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public <V> V s0(a.InterfaceC1126a<V> interfaceC1126a) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    @NotNull
    public w.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.w> x() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean z0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.x0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.w c(@NotNull f1 f1Var) {
        if (f1Var == null) {
            B(7);
        }
        throw new UnsupportedOperationException();
    }
}
