package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class x1 {
    public static int a(String str, int i4) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i4;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c4 : str.toCharArray()) {
            sb.append(c4);
            sb.append('\u200b');
        }
        return sb.toString();
    }

    public static float a(String str, float f4) {
        try {
            return Float.parseFloat(str);
        } catch (Throwable unused) {
            return f4;
        }
    }

    public static String a(String str, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (str != null && i4 != 0) {
                    stringBuffer.append(str);
                }
                stringBuffer.append(strArr[i4]);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean b(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String a() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    public static Pair<String, String> a(long j4) {
        double d4;
        String str = "B";
        if (j4 <= 0) {
            return new Pair<>("0", "B");
        }
        if (j4 < 1000) {
            d4 = j4;
        } else if (j4 < C.MICROS_PER_SECOND) {
            double d5 = j4;
            Double.isNaN(d5);
            d4 = d5 / 1000.0d;
            str = "KB";
        } else {
            int i4 = (j4 > C.NANOS_PER_SECOND ? 1 : (j4 == C.NANOS_PER_SECOND ? 0 : -1));
            double d6 = j4;
            if (i4 < 0) {
                Double.isNaN(d6);
                d4 = d6 / 1000000.0d;
                str = "MB";
            } else {
                Double.isNaN(d6);
                d4 = d6 / 1.0E9d;
                str = "GB";
            }
        }
        return new Pair<>(String.format(Locale.getDefault(), "%.1f", Double.valueOf(d4)), str);
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : new String(Base64.decode(str.getBytes(com.qq.e.comm.plugin.k.a.f44515a), 10), com.qq.e.comm.plugin.k.a.f44515a);
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "null";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
