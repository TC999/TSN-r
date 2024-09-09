package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtensionReceiver.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b extends a implements d {

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.a f57949c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull e0 e0Var, @Nullable e eVar) {
        super(e0Var, eVar);
        if (aVar == null) {
            b(0);
        }
        if (e0Var == null) {
            b(1);
        }
        this.f57949c = aVar;
    }

    private static /* synthetic */ void b(int i4) {
        String str = i4 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i4 != 2 ? 3 : 2];
        if (i4 == 1) {
            objArr[0] = "receiverType";
        } else if (i4 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else if (i4 != 3) {
            objArr[0] = "callableDescriptor";
        } else {
            objArr[0] = "newType";
        }
        if (i4 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else {
            objArr[1] = "getDeclarationDescriptor";
        }
        if (i4 != 2) {
            if (i4 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "replaceType";
            }
        }
        String format = String.format(str, objArr);
        if (i4 == 2) {
            throw new IllegalStateException(format);
        }
    }

    public String toString() {
        return getType() + ": Ext {" + this.f57949c + "}";
    }
}
