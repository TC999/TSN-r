package com.acse.ottn.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.math.BigDecimal;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class J {
    public static long a(File file) throws Exception {
        long j4 = 0;
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                for (int i4 = 0; i4 < length; i4++) {
                    j4 += listFiles[i4].isDirectory() ? a(listFiles[i4]) : listFiles[i4].length();
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return j4;
    }

    public static String a(double d4) {
        double d5 = d4 / 1024.0d;
        if (d5 < 1.0d) {
            return "0K";
        }
        double d6 = d5 / 1024.0d;
        if (d6 < 1.0d) {
            BigDecimal bigDecimal = new BigDecimal(Double.toString(d5));
            return bigDecimal.setScale(2, 4).toPlainString() + "KB";
        }
        double d7 = d6 / 1024.0d;
        if (d7 < 1.0d) {
            BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d6));
            return bigDecimal2.setScale(2, 4).toPlainString() + "MB";
        }
        double d8 = d7 / 1024.0d;
        if (d8 < 1.0d) {
            BigDecimal bigDecimal3 = new BigDecimal(Double.toString(d7));
            return bigDecimal3.setScale(2, 4).toPlainString() + "GB";
        }
        BigDecimal bigDecimal4 = new BigDecimal(d8);
        return bigDecimal4.setScale(2, 4).toPlainString() + "TB";
    }

    public static void a(Context context) {
        b(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            b(context.getExternalCacheDir());
        }
    }

    public static String b(Context context) throws Exception {
        long a4 = a(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            a4 += a(context.getExternalCacheDir());
        }
        return a(a4);
    }

    private static boolean b(File file) {
        String[] list;
        if (file != null && file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!b(new File(file, str))) {
                    return false;
                }
            }
        }
        if (file == null) {
            return true;
        }
        return file.delete();
    }
}
