package com.bxkj.student.common.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.math.BigDecimal;

/* renamed from: com.bxkj.student.common.utils.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class DataCleanManager {
    /* renamed from: a */
    public static void m42861a(Context context, String... filepath) {
        m42855g(context);
        m42857e(context);
        m42858d(context);
        m42854h(context);
        m42856f(context);
        if (filepath == null) {
            return;
        }
        for (String str : filepath) {
            m42860b(str);
        }
    }

    /* renamed from: b */
    public static void m42860b(String filePath) {
        m42853i(new File(filePath));
    }

    /* renamed from: c */
    public static void m42859c(Context context, String dbName) {
        context.deleteDatabase(dbName);
    }

    /* renamed from: d */
    public static void m42858d(Context context) {
        m42853i(new File("/data/data/" + context.getPackageName() + "/databases"));
    }

    /* renamed from: e */
    public static void m42857e(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            m42853i(context.getExternalCacheDir());
        }
    }

    /* renamed from: f */
    public static void m42856f(Context context) {
        m42853i(context.getFilesDir());
    }

    /* renamed from: g */
    public static void m42855g(Context context) {
        m42853i(context.getCacheDir());
    }

    /* renamed from: h */
    public static void m42854h(Context context) {
        m42853i(new File("/data/data/" + context.getPackageName() + "/shared_prefs"));
    }

    /* renamed from: i */
    private static void m42853i(File directory) {
        if (directory != null && directory.exists() && directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                file.delete();
            }
        }
    }

    /* renamed from: j */
    public static void m42852j(String filePath, boolean deleteThisPath) {
        if (TextUtils.isEmpty(filePath)) {
            return;
        }
        try {
            File file = new File(filePath);
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    m42852j(file2.getAbsolutePath(), true);
                }
            }
            if (deleteThisPath) {
                if (!file.isDirectory()) {
                    file.delete();
                } else if (file.listFiles().length == 0) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    public static String m42851k(Context context) throws Exception {
        return m42849m(m42850l(context.getExternalCacheDir()));
    }

    /* renamed from: l */
    public static long m42850l(File file) throws Exception {
        long length;
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    length = m42850l(listFiles[i]);
                } else {
                    length = listFiles[i].length();
                }
                j += length;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    /* renamed from: m */
    public static String m42849m(double size) {
        double d = size / 1024.0d;
        if (d < 1.0d) {
            return size + "Byte";
        }
        double d2 = d / 1024.0d;
        if (d2 < 1.0d) {
            BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
            return bigDecimal.setScale(2, 4).toPlainString() + "KB";
        }
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d2));
            return bigDecimal2.setScale(2, 4).toPlainString() + "MB";
        }
        double d4 = d3 / 1024.0d;
        if (d4 < 1.0d) {
            BigDecimal bigDecimal3 = new BigDecimal(Double.toString(d3));
            return bigDecimal3.setScale(2, 4).toPlainString() + "GB";
        }
        BigDecimal bigDecimal4 = new BigDecimal(d4);
        return bigDecimal4.setScale(2, 4).toPlainString() + "TB";
    }
}
