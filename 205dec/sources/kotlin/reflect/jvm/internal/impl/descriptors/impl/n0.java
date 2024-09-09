package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VariableDescriptorWithInitializerImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class n0 extends m0 {

    /* renamed from: i  reason: collision with root package name */
    static final /* synthetic */ boolean f56423i = false;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f56424g;

    /* renamed from: h  reason: collision with root package name */
    protected kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f56425h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @Nullable kotlin.reflect.jvm.internal.impl.types.e0 e0Var, boolean z3, @NotNull v0 v0Var) {
        super(kVar, fVar, fVar2, e0Var, v0Var);
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
        this.f56424g = z3;
    }

    private static /* synthetic */ void B(int i4) {
        Object[] objArr = new Object[3];
        if (i4 == 1) {
            objArr[0] = "annotations";
        } else if (i4 == 2) {
            objArr[0] = "name";
        } else if (i4 == 3) {
            objArr[0] = "source";
        } else if (i4 != 4) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "compileTimeInitializer";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i4 != 4) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public void G0(@NotNull kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> jVar) {
        if (jVar == null) {
            B(4);
        }
        this.f56425h = jVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public boolean O() {
        return this.f56424g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    @Nullable
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> m0() {
        kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> jVar = this.f56425h;
        if (jVar != null) {
            return jVar.invoke();
        }
        return null;
    }
}
