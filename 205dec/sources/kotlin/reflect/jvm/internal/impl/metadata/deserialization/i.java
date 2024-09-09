package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: versionSpecificBehavior.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i {
    public static final boolean a(@NotNull a version) {
        f0.p(version, "version");
        return version.a() == 1 && version.b() >= 4;
    }

    public static final boolean b(@NotNull a version) {
        f0.p(version, "version");
        return a(version);
    }
}
