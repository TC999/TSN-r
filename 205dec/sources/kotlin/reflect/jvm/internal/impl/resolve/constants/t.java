package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: PrimitiveTypeUtil.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t {
    @NotNull
    public static final Collection<e0> a(@NotNull d0 d0Var) {
        List M;
        f0.p(d0Var, "<this>");
        M = CollectionsKt__CollectionsKt.M(d0Var.k().D(), d0Var.k().F(), d0Var.k().t(), d0Var.k().T());
        return M;
    }
}
