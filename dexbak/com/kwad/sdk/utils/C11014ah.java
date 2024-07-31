package com.kwad.sdk.utils;

import androidx.annotation.Nullable;
import java.util.List;

/* renamed from: com.kwad.sdk.utils.ah */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11014ah {
    /* renamed from: I */
    public static boolean m24126I(@Nullable List<?> list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: P */
    public static boolean m24125P(@Nullable List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    /* renamed from: a */
    public static boolean m24124a(@Nullable Object obj, @Nullable Object obj2) {
        return obj != null && obj.equals(obj2);
    }

    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }
}
