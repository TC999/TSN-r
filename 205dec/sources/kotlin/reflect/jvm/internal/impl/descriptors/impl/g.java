package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClassDescriptorBase.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class g extends a {

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.k f56372g;

    /* renamed from: h  reason: collision with root package name */
    private final v0 f56373h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f56374i;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull v0 v0Var, boolean z3) {
        super(nVar, fVar);
        if (nVar == null) {
            h0(0);
        }
        if (kVar == null) {
            h0(1);
        }
        if (fVar == null) {
            h0(2);
        }
        if (v0Var == null) {
            h0(3);
        }
        this.f56372g = kVar;
        this.f56373h = v0Var;
        this.f56374i = z3;
    }

    private static /* synthetic */ void h0(int i4) {
        String str = (i4 == 4 || i4 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 4 || i4 == 5) ? 2 : 3];
        if (i4 == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i4 == 2) {
            objArr[0] = "name";
        } else if (i4 == 3) {
            objArr[0] = "source";
        } else if (i4 == 4 || i4 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i4 == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i4 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i4 != 4 && i4 != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i4 != 4 && i4 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar = this.f56372g;
        if (kVar == null) {
            h0(4);
        }
        return kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public v0 getSource() {
        v0 v0Var = this.f56373h;
        if (v0Var == null) {
            h0(5);
        }
        return v0Var;
    }

    public boolean isExternal() {
        return this.f56374i;
    }
}
