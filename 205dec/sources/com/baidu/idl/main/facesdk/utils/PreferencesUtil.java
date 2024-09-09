package com.baidu.idl.main.facesdk.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@SuppressLint({"NewApi"})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PreferencesUtil {
    private static final String LEFT_MOUNT = "[";
    private static final String LENGTH_SUFFIX = "#LENGTH";
    private static final String RIGHT_MOUNT = "]";
    private static SharedPreferences mPrefs;

    public static boolean contains(String str) {
        return getPreferences().contains(str);
    }

    public static Map<String, ?> getAll() {
        return getPreferences().getAll();
    }

    public static boolean getBoolean(String str, boolean z3) {
        return getPreferences().getBoolean(str, z3);
    }

    public static float getFloat(String str, float f4) {
        return getPreferences().getFloat(str, f4);
    }

    public static int getInt(String str, int i4) {
        return getPreferences().getInt(str, i4);
    }

    public static long getLong(String str, long j4) {
        return getPreferences().getLong(str, j4);
    }

    public static SharedPreferences getPreferences() {
        SharedPreferences sharedPreferences = mPrefs;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        throw new RuntimeException("please call iniPrefs(context) in the Application class onCreate.");
    }

    public static String getString(String str, String str2) {
        return getPreferences().getString(str, str2);
    }

    @TargetApi(11)
    public static Set<String> getStringSet(String str, Set<String> set) {
        return getPreferences().getStringSet(str, set);
    }

    public static void initPrefs(Context context) {
        if (mPrefs == null) {
            String packageName = context.getPackageName();
            if (packageName != null) {
                mPrefs = context.getSharedPreferences(packageName, 4);
                return;
            }
            throw new NullPointerException("Prefs key may not be null");
        }
    }

    public static void putBoolean(String str, boolean z3) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putBoolean(str, z3);
        edit.apply();
    }

    public static void putFloat(String str, float f4) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putFloat(str, f4);
        edit.apply();
    }

    public static void putInt(String str, int i4) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putInt(str, i4);
        edit.apply();
    }

    public static void putLong(String str, long j4) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putLong(str, j4);
        edit.apply();
    }

    public static void putString(String str, String str2) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putString(str, str2);
        edit.apply();
    }

    @TargetApi(11)
    public static void putStringSet(String str, Set<String> set) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putStringSet(str, set);
        edit.apply();
    }

    @Deprecated
    public static void reInit(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            if (packageName != null) {
                mPrefs = context.getSharedPreferences(packageName, 4);
                return;
            }
            throw new NullPointerException("Prefs key may not be null");
        }
    }

    public static void remove(String str) {
        SharedPreferences preferences = getPreferences();
        SharedPreferences.Editor edit = preferences.edit();
        if (preferences.contains(str + "#LENGTH")) {
            int i4 = preferences.getInt(str + "#LENGTH", -1);
            if (i4 >= 0) {
                edit.remove(str + "#LENGTH");
                for (int i5 = 0; i5 < i4; i5++) {
                    edit.remove(str + "[" + i5 + "]");
                }
            }
        }
        edit.remove(str);
        edit.apply();
    }
}
