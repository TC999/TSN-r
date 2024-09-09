package xyz.adscope.common.imageloader;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class StorageUtils {
    public static File getCacheDirectory(Context context) {
        File file = null;
        if (context == null) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                    file = context.getExternalCacheDir();
                }
                return file == null ? context.getCacheDir() : file;
            }
            return context.getCacheDir();
        } catch (Throwable unused) {
            return context.getCacheDir();
        }
    }

    public static File getFilesCacheDirectory(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return Build.VERSION.SDK_INT >= 19 ? new File(context.getFilesDir(), str) : new File(context.getFilesDir(), str);
        } catch (Throwable unused) {
            return new File(context.getFilesDir(), str);
        }
    }

    public static File getFilesDirectory(Context context) {
        File file = null;
        if (context == null) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                    file = context.getExternalFilesDir(null);
                }
                return file == null ? context.getFilesDir() : file;
            }
            return context.getFilesDir();
        } catch (Throwable unused) {
            return context.getFilesDir();
        }
    }
}
