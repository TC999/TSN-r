package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TransientReceiver.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class h extends a {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(@NotNull e0 e0Var) {
        this(e0Var, null);
        if (e0Var == null) {
            b(0);
        }
    }

    private static /* synthetic */ void b(int i4) {
        Object[] objArr = new Object[3];
        if (i4 != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i4 != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        return "{Transient} : " + getType();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private h(@NotNull e0 e0Var, @Nullable e eVar) {
        super(e0Var, eVar);
        if (e0Var == null) {
            b(1);
        }
    }
}
