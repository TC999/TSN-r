package k2;

import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import org.jetbrains.annotations.NotNull;

/* compiled from: LookupLocation.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface a {
    @NotNull
    String getFilePath();

    @NotNull
    Position getPosition();
}
