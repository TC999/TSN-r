package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import org.jetbrains.annotations.NotNull;

/* compiled from: LazyClassReceiverParameterDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class q extends c {

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f56475c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.c f56476d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b());
        if (dVar == null) {
            B(0);
        }
        this.f56475c = dVar;
        this.f56476d = new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.c(dVar, null);
    }

    private static /* synthetic */ void B(int i4) {
        String str = (i4 == 1 || i4 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 1 || i4 == 2) ? 2 : 3];
        if (i4 == 1 || i4 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i4 != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i4 == 1) {
            objArr[1] = "getValue";
        } else if (i4 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i4 != 1 && i4 != 2) {
            if (i4 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String format = String.format(str, objArr);
        if (i4 != 1 && i4 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = this.f56475c;
        if (dVar == null) {
            B(2);
        }
        return dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e getValue() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.c cVar = this.f56476d;
        if (cVar == null) {
            B(1);
        }
        return cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j
    public String toString() {
        return "class " + this.f56475c.getName() + "::this";
    }
}
