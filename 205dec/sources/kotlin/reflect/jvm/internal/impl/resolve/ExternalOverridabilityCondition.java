package kotlin.reflect.jvm.internal.impl.resolve;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface ExternalOverridabilityCondition {

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum Contract {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum Result {
        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN
    }

    @NotNull
    Contract a();

    @NotNull
    Result b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar);
}
