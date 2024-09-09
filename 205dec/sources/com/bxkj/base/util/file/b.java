package com.bxkj.base.util.file;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: FileUtil.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class b {
    public static String a(long j4) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j4 == 0) {
            return "0B";
        }
        if (j4 < 1024) {
            return decimalFormat.format(j4) + "B";
        } else if (j4 < 1048576) {
            StringBuilder sb = new StringBuilder();
            double d4 = j4;
            Double.isNaN(d4);
            sb.append(decimalFormat.format(d4 / 1024.0d));
            sb.append("KB");
            return sb.toString();
        } else if (j4 < 1073741824) {
            StringBuilder sb2 = new StringBuilder();
            double d5 = j4;
            Double.isNaN(d5);
            sb2.append(decimalFormat.format(d5 / 1048576.0d));
            sb2.append("MB");
            return sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            double d6 = j4;
            Double.isNaN(d6);
            sb3.append(decimalFormat.format(d6 / 1.073741824E9d));
            sb3.append("GB");
            return sb3.toString();
        }
    }

    public static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            if (!c(file2)) {
                                return false;
                            }
                        } else if (file2.isDirectory() && !b(file2)) {
                            return false;
                        }
                    }
                }
                return file.delete();
            }
            return false;
        }
        return true;
    }

    public static boolean c(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean d(String str) {
        return c(f(str));
    }

    public static String e(Context context) {
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            return context.getCacheDir().getPath();
        }
        return context.getExternalCacheDir().getPath();
    }

    public static File f(String str) {
        if (j(str)) {
            return null;
        }
        return new File(str);
    }

    public static long g(File file) throws Exception {
        if (file.exists()) {
            return new FileInputStream(file).available();
        }
        file.createNewFile();
        Log.e("\u83b7\u53d6\u6587\u4ef6\u5927\u5c0f", "\u6587\u4ef6\u4e0d\u5b58\u5728!");
        return 0L;
    }

    public static long h(File file) throws Exception {
        long g4;
        File[] listFiles = file.listFiles();
        long j4 = 0;
        for (int i4 = 0; i4 < listFiles.length; i4++) {
            if (listFiles[i4].isDirectory()) {
                g4 = h(listFiles[i4]);
            } else {
                g4 = g(listFiles[i4]);
            }
            j4 += g4;
        }
        return j4;
    }

    public static String i(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.d("print", "paramString---->null");
            return "";
        }
        Log.d("print", "paramString:" + str);
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf <= -1) {
            Log.d("print", "i <= -1");
            return "";
        }
        String substring = str.substring(lastIndexOf + 1);
        Log.d("print", "paramString.substring(i + 1)------>" + substring);
        return substring;
    }

    private static boolean j(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (!Character.isWhitespace(str.charAt(i4))) {
                return false;
            }
        }
        return true;
    }
}
