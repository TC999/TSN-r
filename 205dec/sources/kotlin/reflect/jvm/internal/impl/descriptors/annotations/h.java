package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Annotations.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @NotNull
    public static final f a(@NotNull f first, @NotNull f second) {
        f0.p(first, "first");
        f0.p(second, "second");
        return first.isEmpty() ? second : second.isEmpty() ? first : new j(first, second);
    }
}
