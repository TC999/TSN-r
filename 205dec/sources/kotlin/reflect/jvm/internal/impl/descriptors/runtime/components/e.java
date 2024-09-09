package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaClassFinder.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {
    @Nullable
    public static final Class<?> a(@NotNull ClassLoader classLoader, @NotNull String fqName) {
        f0.p(classLoader, "<this>");
        f0.p(fqName, "fqName");
        try {
            return Class.forName(fqName, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
