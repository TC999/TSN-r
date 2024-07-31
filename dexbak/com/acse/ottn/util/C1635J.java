package com.acse.ottn.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.math.BigDecimal;

/* renamed from: com.acse.ottn.util.J */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1635J {
    /* renamed from: a */
    public static long m56235a(File file) throws Exception {
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    j += listFiles[i].isDirectory() ? m56235a(listFiles[i]) : listFiles[i].length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    /* renamed from: a */
    public static String m56237a(double d) {
        double d2 = d / 1024.0d;
        if (d2 < 1.0d) {
            return "0K";
        }
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            BigDecimal bigDecimal = new BigDecimal(Double.toString(d2));
            return bigDecimal.setScale(2, 4).toPlainString() + "KB";
        }
        double d4 = d3 / 1024.0d;
        if (d4 < 1.0d) {
            BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d3));
            return bigDecimal2.setScale(2, 4).toPlainString() + "MB";
        }
        double d5 = d4 / 1024.0d;
        if (d5 < 1.0d) {
            BigDecimal bigDecimal3 = new BigDecimal(Double.toString(d4));
            return bigDecimal3.setScale(2, 4).toPlainString() + "GB";
        }
        BigDecimal bigDecimal4 = new BigDecimal(d5);
        return bigDecimal4.setScale(2, 4).toPlainString() + "TB";
    }

    /* renamed from: a */
    public static void m56236a(Context context) {
        m56233b(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            m56233b(context.getExternalCacheDir());
        }
    }

    /* renamed from: b */
    public static String m56234b(Context context) throws Exception {
        long m56235a = m56235a(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            m56235a += m56235a(context.getExternalCacheDir());
        }
        return m56237a(m56235a);
    }

    /* renamed from: b */
    private static boolean m56233b(File file) {
        String[] list;
        if (file != null && file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!m56233b(new File(file, str))) {
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
