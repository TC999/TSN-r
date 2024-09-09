package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractLazyTypeParameterDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b extends e {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @NotNull Variance variance, boolean z3, int i4, @NotNull v0 v0Var, @NotNull y0 y0Var) {
        super(nVar, kVar, fVar, fVar2, variance, z3, i4, v0Var, y0Var);
        if (nVar == null) {
            B(0);
        }
        if (kVar == null) {
            B(1);
        }
        if (fVar == null) {
            B(2);
        }
        if (fVar2 == null) {
            B(3);
        }
        if (variance == null) {
            B(4);
        }
        if (v0Var == null) {
            B(5);
        }
        if (y0Var == null) {
            B(6);
        }
    }

    private static /* synthetic */ void B(int i4) {
        Object[] objArr = new Object[3];
        switch (i4) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j
    public String toString() {
        Object[] objArr = new Object[3];
        String str = "";
        objArr[0] = l() ? "reified " : "";
        if (o() != Variance.INVARIANT) {
            str = o() + " ";
        }
        objArr[1] = str;
        objArr[2] = getName();
        return String.format("%s%s%s", objArr);
    }
}
