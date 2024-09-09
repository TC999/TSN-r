package com.bxkj.student.common.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.math.BigDecimal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DataCleanManager.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class d {
    public static void a(Context context, String... filepath) {
        g(context);
        e(context);
        d(context);
        h(context);
        f(context);
        if (filepath == null) {
            return;
        }
        for (String str : filepath) {
            b(str);
        }
    }

    public static void b(String filePath) {
        i(new File(filePath));
    }

    public static void c(Context context, String dbName) {
        context.deleteDatabase(dbName);
    }

    public static void d(Context context) {
        i(new File("/data/data/" + context.getPackageName() + "/databases"));
    }

    public static void e(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            i(context.getExternalCacheDir());
        }
    }

    public static void f(Context context) {
        i(context.getFilesDir());
    }

    public static void g(Context context) {
        i(context.getCacheDir());
    }

    public static void h(Context context) {
        i(new File("/data/data/" + context.getPackageName() + "/shared_prefs"));
    }

    private static void i(File directory) {
        if (directory != null && directory.exists() && directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                file.delete();
            }
        }
    }

    public static void j(String filePath, boolean deleteThisPath) {
        if (TextUtils.isEmpty(filePath)) {
            return;
        }
        try {
            File file = new File(filePath);
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    j(file2.getAbsolutePath(), true);
                }
            }
            if (deleteThisPath) {
                if (!file.isDirectory()) {
                    file.delete();
                } else if (file.listFiles().length == 0) {
                    file.delete();
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static String k(Context context) throws Exception {
        return m(l(context.getExternalCacheDir()));
    }

    public static long l(File file) throws Exception {
        long length;
        long j4 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i4 = 0; i4 < listFiles.length; i4++) {
                if (listFiles[i4].isDirectory()) {
                    length = l(listFiles[i4]);
                } else {
                    length = listFiles[i4].length();
                }
                j4 += length;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return j4;
    }

    public static String m(double size) {
        double d4 = size / 1024.0d;
        if (d4 < 1.0d) {
            return size + "Byte";
        }
        double d5 = d4 / 1024.0d;
        if (d5 < 1.0d) {
            BigDecimal bigDecimal = new BigDecimal(Double.toString(d4));
            return bigDecimal.setScale(2, 4).toPlainString() + "KB";
        }
        double d6 = d5 / 1024.0d;
        if (d6 < 1.0d) {
            BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d5));
            return bigDecimal2.setScale(2, 4).toPlainString() + "MB";
        }
        double d7 = d6 / 1024.0d;
        if (d7 < 1.0d) {
            BigDecimal bigDecimal3 = new BigDecimal(Double.toString(d6));
            return bigDecimal3.setScale(2, 4).toPlainString() + "GB";
        }
        BigDecimal bigDecimal4 = new BigDecimal(d7);
        return bigDecimal4.setScale(2, 4).toPlainString() + "TB";
    }
}
