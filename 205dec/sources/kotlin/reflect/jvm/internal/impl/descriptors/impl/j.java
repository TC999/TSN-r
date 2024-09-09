package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import org.jetbrains.annotations.NotNull;

/* compiled from: DeclarationDescriptorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class j extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.b implements kotlin.reflect.jvm.internal.impl.descriptors.k {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.f f56386b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2) {
        super(fVar);
        if (fVar == null) {
            B(0);
        }
        if (fVar2 == null) {
            B(1);
        }
        this.f56386b = fVar2;
    }

    private static /* synthetic */ void B(int i4) {
        String str = (i4 == 2 || i4 == 3 || i4 == 5 || i4 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 2 || i4 == 3 || i4 == 5 || i4 == 6) ? 2 : 3];
        switch (i4) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i4 == 2) {
            objArr[1] = "getName";
        } else if (i4 == 3) {
            objArr[1] = "getOriginal";
        } else if (i4 == 5 || i4 == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i4 != 2 && i4 != 3) {
            if (i4 == 4) {
                objArr[2] = "toString";
            } else if (i4 != 5 && i4 != 6) {
                objArr[2] = "<init>";
            }
        }
        String format = String.format(str, objArr);
        if (i4 != 2 && i4 != 3 && i4 != 5 && i4 != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static String f0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            B(4);
        }
        try {
            String str = kotlin.reflect.jvm.internal.impl.renderer.b.f57732j.s(kVar) + "[" + kVar.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(kVar)) + "]";
            if (str == null) {
                B(5);
            }
            return str;
        } catch (Throwable unused) {
            String str2 = kVar.getClass().getSimpleName() + " " + kVar.getName();
            if (str2 == null) {
                B(6);
            }
            return str2;
        }
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k a() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        kotlin.reflect.jvm.internal.impl.name.f fVar = this.f56386b;
        if (fVar == null) {
            B(2);
        }
        return fVar;
    }

    public String toString() {
        return f0(this);
    }
}
