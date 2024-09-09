package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: storage.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m {
    @NotNull
    public static final <T> T a(@NotNull i<? extends T> iVar, @Nullable Object obj, @NotNull kotlin.reflect.n<?> p3) {
        f0.p(iVar, "<this>");
        f0.p(p3, "p");
        return iVar.invoke();
    }

    @Nullable
    public static final <T> T b(@NotNull j<? extends T> jVar, @Nullable Object obj, @NotNull kotlin.reflect.n<?> p3) {
        f0.p(jVar, "<this>");
        f0.p(p3, "p");
        return jVar.invoke();
    }
}
