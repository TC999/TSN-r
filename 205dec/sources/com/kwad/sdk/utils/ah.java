package com.kwad.sdk.utils;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ah {
    public static boolean I(@Nullable List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean P(@Nullable List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj != null && obj.equals(obj2);
    }

    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }
}
