package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinClassFinder.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o {
    @Nullable
    public static final p a(@NotNull n nVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        f0.p(nVar, "<this>");
        f0.p(classId, "classId");
        n.a c4 = nVar.c(classId);
        if (c4 == null) {
            return null;
        }
        return c4.a();
    }

    @Nullable
    public static final p b(@NotNull n nVar, @NotNull m2.g javaClass) {
        f0.p(nVar, "<this>");
        f0.p(javaClass, "javaClass");
        n.a b4 = nVar.b(javaClass);
        if (b4 == null) {
            return null;
        }
        return b4.a();
    }
}
