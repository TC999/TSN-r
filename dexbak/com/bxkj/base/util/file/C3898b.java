package com.bxkj.base.util.file;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: FileUtil.java */
/* renamed from: com.bxkj.base.util.file.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3898b {
    /* renamed from: a */
    public static String m44110a(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j == 0) {
            return "0B";
        }
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        } else if (j < 1048576) {
            StringBuilder sb = new StringBuilder();
            double d = j;
            Double.isNaN(d);
            sb.append(decimalFormat.format(d / 1024.0d));
            sb.append("KB");
            return sb.toString();
        } else if (j < IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            StringBuilder sb2 = new StringBuilder();
            double d2 = j;
            Double.isNaN(d2);
            sb2.append(decimalFormat.format(d2 / 1048576.0d));
            sb2.append("MB");
            return sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            double d3 = j;
            Double.isNaN(d3);
            sb3.append(decimalFormat.format(d3 / 1.073741824E9d));
            sb3.append("GB");
            return sb3.toString();
        }
    }

    /* renamed from: b */
    public static boolean m44109b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            if (!m44108c(file2)) {
                                return false;
                            }
                        } else if (file2.isDirectory() && !m44109b(file2)) {
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

    /* renamed from: c */
    public static boolean m44108c(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    /* renamed from: d */
    public static boolean m44107d(String str) {
        return m44108c(m44105f(str));
    }

    /* renamed from: e */
    public static String m44106e(Context context) {
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            return context.getCacheDir().getPath();
        }
        return context.getExternalCacheDir().getPath();
    }

    /* renamed from: f */
    public static File m44105f(String str) {
        if (m44101j(str)) {
            return null;
        }
        return new File(str);
    }

    /* renamed from: g */
    public static long m44104g(File file) throws Exception {
        if (file.exists()) {
            return new FileInputStream(file).available();
        }
        file.createNewFile();
        Log.e("获取文件大小", "文件不存在!");
        return 0L;
    }

    /* renamed from: h */
    public static long m44103h(File file) throws Exception {
        long m44104g;
        File[] listFiles = file.listFiles();
        long j = 0;
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isDirectory()) {
                m44104g = m44103h(listFiles[i]);
            } else {
                m44104g = m44104g(listFiles[i]);
            }
            j += m44104g;
        }
        return j;
    }

    /* renamed from: i */
    public static String m44102i(String str) {
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

    /* renamed from: j */
    private static boolean m44101j(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
