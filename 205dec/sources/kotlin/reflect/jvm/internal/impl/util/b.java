package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: modifierChecks.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface b {

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @Nullable
        public static String a(@NotNull b bVar, @NotNull w functionDescriptor) {
            f0.p(bVar, "this");
            f0.p(functionDescriptor, "functionDescriptor");
            if (bVar.b(functionDescriptor)) {
                return null;
            }
            return bVar.getDescription();
        }
    }

    @Nullable
    String a(@NotNull w wVar);

    boolean b(@NotNull w wVar);

    @NotNull
    String getDescription();
}
