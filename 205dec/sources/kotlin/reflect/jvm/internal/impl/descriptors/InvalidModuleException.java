package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* compiled from: InvalidModuleException.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class InvalidModuleException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidModuleException(@NotNull String message) {
        super(message);
        kotlin.jvm.internal.f0.p(message, "message");
    }
}
