package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractReceiverValue.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    protected final e0 f57947a;

    /* renamed from: b  reason: collision with root package name */
    private final e f57948b;

    public a(@NotNull e0 e0Var, @Nullable e eVar) {
        if (e0Var == null) {
            b(0);
        }
        this.f57947a = e0Var;
        this.f57948b = eVar == null ? this : eVar;
    }

    private static /* synthetic */ void b(int i4) {
        String str = (i4 == 1 || i4 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 1 || i4 == 2) ? 2 : 3];
        if (i4 == 1 || i4 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i4 == 1) {
            objArr[1] = "getType";
        } else if (i4 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i4 != 1 && i4 != 2) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i4 != 1 && i4 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e
    @NotNull
    public e0 getType() {
        e0 e0Var = this.f57947a;
        if (e0Var == null) {
            b(1);
        }
        return e0Var;
    }
}
