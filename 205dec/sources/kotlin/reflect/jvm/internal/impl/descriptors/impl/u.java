package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.types.d1;
import org.jetbrains.annotations.NotNull;

/* compiled from: ModuleAwareClassDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u {
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.h a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull d1 typeSubstitution, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(dVar, "<this>");
        kotlin.jvm.internal.f0.p(typeSubstitution, "typeSubstitution");
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return t.f56494a.a(dVar, typeSubstitution, kotlinTypeRefiner);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.h b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(dVar, "<this>");
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return t.f56494a.b(dVar, kotlinTypeRefiner);
    }
}
