package com.beizi.p051ad.lance.p062a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.beizi.ad.lance.a.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FileUtil {
    /* renamed from: a */
    public static final File m49060a(Context context) {
        File m49057b = m49057b(context);
        if (m49057b != null) {
            File file = new File(m49057b.getPath() + "/Beizi/download/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    /* renamed from: b */
    public static void m49056b(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
            }
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, "启动失败:" + str, 1).show();
        }
    }

    /* renamed from: c */
    public static File m49055c(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getCacheDir();
        }
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            String str = "/data/data/" + context.getPackageName() + "/cache/";
            HaoboLog.m49284w(HaoboLog.storageUtilsLogTag, "Can't define system cache directory! '" + str + "%s' will be used.");
            cacheDir = new File(str);
        }
        return cacheDir;
    }

    /* renamed from: d */
    public static File m49054d(Context context) {
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
                HaoboLog.m49284w(HaoboLog.storageUtilsLogTag, "Can't define system cache directory! '" + str + "%s' will be used.");
                cacheDir = new File(str);
                if (!cacheDir.exists()) {
                    cacheDir.mkdirs();
                }
            }
        }
        return cacheDir;
    }

    /* renamed from: e */
    public static void m49053e(Context context) {
        File[] listFiles;
        try {
            File m49054d = m49054d(context);
            if (!m49054d.exists() || (listFiles = m49054d.listFiles()) == null) {
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
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public static File m49057b(Context context) {
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

    /* renamed from: a */
    public static boolean m49059a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return context.getPackageManager().getApplicationInfo(str, 0) != null;
    }

    /* renamed from: a */
    public static void m49058a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }
}
