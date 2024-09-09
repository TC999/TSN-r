package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: exceptionUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    public static final boolean a(@NotNull Throwable th) {
        f0.p(th, "<this>");
        Class<?> cls = th.getClass();
        while (!f0.g(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final RuntimeException b(@NotNull Throwable e4) {
        f0.p(e4, "e");
        throw e4;
    }
}
