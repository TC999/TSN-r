package com.kwad.sdk.core.imageloader.utils;

import android.content.Context;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class StorageUtils {
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String INDIVIDUAL_DIR_NAME = "ksad-images";

    private StorageUtils() {
    }

    public static File getIndividualCacheDirectory(Context context, String str) {
        return getIndividualCacheDirectory(context, str, "ksad-images");
    }

    public static File getIndividualCacheDirectory(Context context, String str, String str2) {
        File file = new File(str);
        File file2 = new File(str, str2);
        return (file2.exists() || file2.mkdir()) ? file2 : file;
    }
}
