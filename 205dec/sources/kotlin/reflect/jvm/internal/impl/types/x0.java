package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeCapabilities.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x0 {
    @Nullable
    public static final m a(@NotNull e0 e0Var) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        l1 K0 = e0Var.K0();
        m mVar = K0 instanceof m ? (m) K0 : null;
        if (mVar != null && mVar.B()) {
            return mVar;
        }
        return null;
    }

    public static final boolean b(@NotNull e0 e0Var) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        l1 K0 = e0Var.K0();
        m mVar = K0 instanceof m ? (m) K0 : null;
        if (mVar == null) {
            return false;
        }
        return mVar.B();
    }
}
