package com.umeng.socialize.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SocializeSpUtils {
    public static int getInt(Context context, String str, int i4) {
        return getSharedPreferences(context).getInt(str, i4);
    }

    public static String getMac(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("mac", null);
        }
        return null;
    }

    public static synchronized String getShareBoardConfig(Context context) {
        synchronized (SocializeSpUtils.class) {
            SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (sharedPreferences == null) {
                return null;
            }
            return sharedPreferences.getString("shareboardconfig", null);
        }
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("umeng_socialize", 0);
    }

    public static String getString(Context context, String str) {
        return getSharedPreferences(context).getString(str, "");
    }

    public static long getTime(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("request_time", 0L);
        }
        return 0L;
    }

    public static String getUMEk(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("ek", null);
        }
        return null;
    }

    public static String getUMId(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("uid", null);
        }
        return null;
    }

    public static void putInt(Context context, String str, int i4) {
        getSharedPreferences(context).edit().putInt(str, i4).commit();
    }

    public static boolean putMac(Context context, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return sharedPreferences.edit().putString("mac", str).commit();
    }

    public static synchronized boolean putShareBoardConfig(Context context, String str) {
        synchronized (SocializeSpUtils.class) {
            SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.edit().putString("shareboardconfig", str).commit();
        }
    }

    public static void putString(Context context, String str, String str2) {
        getSharedPreferences(context).edit().putString(str, str2).commit();
    }

    public static boolean putTime(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences != null && sharedPreferences.edit().putLong("request_time", System.currentTimeMillis()).commit();
    }

    public static boolean putUMEk(Context context, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return sharedPreferences.edit().putString("ek", str).commit();
    }

    public static boolean putUMId(Context context, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return sharedPreferences.edit().putString("uid", str).commit();
    }

    public static void remove(Context context, String str) {
        getSharedPreferences(context).edit().remove(str).commit();
    }
}
