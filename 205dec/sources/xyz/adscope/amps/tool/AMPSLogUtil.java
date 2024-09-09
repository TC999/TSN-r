package xyz.adscope.amps.tool;

import android.util.Log;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSLogUtil {
    private static final boolean isDebug = true;

    public static void d(String str, String str2) {
        Log.d(str, str2);
    }

    public static void dd(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return;
        }
        if (str2.length() <= 3072) {
            Log.d(str, str2);
            return;
        }
        while (str2.length() > 3072) {
            String substring = str2.substring(0, 3072);
            str2 = str2.replace(substring, "");
            Log.d(str, substring);
        }
        Log.d(str, str2);
    }

    public static void e(String str, String str2) {
        Log.e(str, str2);
    }

    public static void i(String str, String str2) {
        Log.i(str, str2);
    }
}
