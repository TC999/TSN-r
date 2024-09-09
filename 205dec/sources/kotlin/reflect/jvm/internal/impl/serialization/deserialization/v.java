package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: NameResolverUtil.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v {
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.b a(@NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar, int i4) {
        f0.p(cVar, "<this>");
        kotlin.reflect.jvm.internal.impl.name.b f4 = kotlin.reflect.jvm.internal.impl.name.b.f(cVar.b(i4), cVar.a(i4));
        f0.o(f4, "fromString(getQualifiedC\u2026 isLocalClassName(index))");
        return f4;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f b(@NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar, int i4) {
        f0.p(cVar, "<this>");
        kotlin.reflect.jvm.internal.impl.name.f e4 = kotlin.reflect.jvm.internal.impl.name.f.e(cVar.getString(i4));
        f0.o(e4, "guessByFirstCharacter(getString(index))");
        return e4;
    }
}
