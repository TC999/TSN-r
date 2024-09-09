package androidx.room.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class SneakyThrow {
    private SneakyThrow() {
    }

    public static void reThrow(@NonNull Exception e4) {
        sneakyThrow(e4);
    }

    private static <E extends Throwable> void sneakyThrow(@NonNull Throwable e4) throws Throwable {
        throw e4;
    }
}
