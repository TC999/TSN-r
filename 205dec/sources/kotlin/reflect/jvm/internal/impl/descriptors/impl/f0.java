package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import org.jetbrains.annotations.NotNull;

/* compiled from: ReceiverParameterDescriptorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f0 extends c {

    /* renamed from: e  reason: collision with root package name */
    static final /* synthetic */ boolean f56369e = false;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.k f56370c;

    /* renamed from: d  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e f56371d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
        super(fVar);
        if (kVar == null) {
            B(0);
        }
        if (eVar == null) {
            B(1);
        }
        if (fVar == null) {
            B(2);
        }
        this.f56370c = kVar;
        this.f56371d = eVar;
    }

    private static /* synthetic */ void B(int i4) {
        String str = (i4 == 3 || i4 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 3 || i4 == 4) ? 2 : 3];
        switch (i4) {
            case 1:
                objArr[0] = "value";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 5:
                objArr[0] = "newOwner";
                break;
            case 6:
                objArr[0] = "outType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i4 == 3) {
            objArr[1] = "getValue";
        } else if (i4 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i4 != 3 && i4 != 4) {
            if (i4 == 5) {
                objArr[2] = "copy";
            } else if (i4 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "setOutType";
            }
        }
        String format = String.format(str, objArr);
        if (i4 != 3 && i4 != 4) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar = this.f56370c;
        if (kVar == null) {
            B(4);
        }
        return kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e getValue() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar = this.f56371d;
        if (eVar == null) {
            B(3);
        }
        return eVar;
    }
}
