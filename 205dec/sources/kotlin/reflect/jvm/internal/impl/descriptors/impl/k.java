package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import org.jetbrains.annotations.NotNull;

/* compiled from: DeclarationDescriptorNonRootImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class k extends j implements kotlin.reflect.jvm.internal.impl.descriptors.l {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.k f56389c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final v0 f56390d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @NotNull v0 v0Var) {
        super(fVar, fVar2);
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
        this.f56389c = kVar;
        this.f56390d = v0Var;
    }

    private static /* synthetic */ void B(int i4) {
        String str = (i4 == 4 || i4 == 5 || i4 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 4 || i4 == 5 || i4 == 6) ? 2 : 3];
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
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i4 == 4) {
            objArr[1] = "getOriginal";
        } else if (i4 == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i4 != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i4 != 4 && i4 != 5 && i4 != 6) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i4 != 4 && i4 != 5 && i4 != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar = this.f56389c;
        if (kVar == null) {
            B(5);
        }
        return kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public v0 getSource() {
        v0 v0Var = this.f56390d;
        if (v0Var == null) {
            B(6);
        }
        return v0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    /* renamed from: h0 */
    public kotlin.reflect.jvm.internal.impl.descriptors.n a() {
        kotlin.reflect.jvm.internal.impl.descriptors.n nVar = (kotlin.reflect.jvm.internal.impl.descriptors.n) super.a();
        if (nVar == null) {
            B(4);
        }
        return nVar;
    }
}
