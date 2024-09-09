package com.beizi.ad.lance.a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.beizi.ad.internal.utilities.HaoboLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: FileUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class h {
    public static final File a(Context context) {
        File b4 = b(context);
        if (b4 != null) {
            File file = new File(b4.getPath() + "/Beizi/download/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    public static void b(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
            }
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, "\u542f\u52a8\u5931\u8d25:" + str, 1).show();
        }
    }

    public static File c(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getCacheDir();
        }
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            String str = "/data/data/" + context.getPackageName() + "/cache/";
            HaoboLog.w(HaoboLog.storageUtilsLogTag, "Can't define system cache directory! '" + str + "%s' will be used.");
            cacheDir = new File(str);
        }
        return cacheDir;
    }

    public static File d(Context context) {
        File cacheDir;
        if (Build.VERSION.SDK_INT >= 19) {
            cacheDir = new File(context.getCacheDir().getPath() + "/beizi/material/");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
        } else {
            cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                String str = "/data/data/" + context.getPackageName() + "/cache/beizi/material/";
                HaoboLog.w(HaoboLog.storageUtilsLogTag, "Can't define system cache directory! '" + str + "%s' will be used.");
                cacheDir = new File(str);
                if (!cacheDir.exists()) {
                    cacheDir.mkdirs();
                }
            }
        }
        return cacheDir;
    }

    public static void e(Context context) {
        File[] listFiles;
        try {
            File d4 = d(context);
            if (!d4.exists() || (listFiles = d4.listFiles()) == null) {
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(System.currentTimeMillis() - 1296000000);
            for (File file : listFiles) {
                if (file.isFile()) {
                    try {
                        if (simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(file.lastModified()))).before(date)) {
                            file.delete();
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static File b(Context context) {
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
        } catch (Exception unused) {
            return context.getFilesDir();
        }
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return context.getPackageManager().getApplicationInfo(str, 0) != null;
    }

    public static void a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }
}
