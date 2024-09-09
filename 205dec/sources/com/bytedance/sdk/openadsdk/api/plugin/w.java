package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.FileFilter;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class w {
    private static File c(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean sr(Context context) {
        File[] listFiles;
        File file = new File(context.getFilesDir(), "/pangle_p/com.byted.pangle");
        return (!file.exists() || (listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.w.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2 != null && file2.getName().matches("^version-(\\d+)$");
            }
        })) == null || listFiles.length == 0) ? false : true;
    }

    public static File w(Context context) {
        return c(new File(context.getCacheDir(), "pangle_com.byted.pangle"));
    }

    public static File xv(Context context) {
        return c(new File(context.getExternalCacheDir(), "pangle_com.byted.pangle"));
    }

    public static SharedPreferences w(Context context, String str, int i4) {
        if (i4 == 0) {
            str = c(str);
        }
        return context.getSharedPreferences(str, i4);
    }

    public static File c(Context context) {
        return c(new File(context.getFilesDir(), "pangle_com.byted.pangle"));
    }

    public static File c(Context context, String str) {
        return c(new File(context.getExternalFilesDir(str), "pangle_com.byted.pangle"));
    }

    public static File c(Context context, String str, int i4) {
        return i4 == 0 ? c(new File(context.getDir(str, i4), "pangle_com.byted.pangle")) : context.getDir(str, i4);
    }

    private static String c(String str) {
        return "pangle_com.byted.pangle_" + str;
    }
}
