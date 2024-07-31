package com.baidu.idl.main.facesdk.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

@SuppressLint({"NewApi"})
/* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    public static boolean getBoolean(String str, boolean z) {
        return getPreferences().getBoolean(str, z);
    }

    public static float getFloat(String str, float f) {
        return getPreferences().getFloat(str, f);
    }

    public static int getInt(String str, int i) {
        return getPreferences().getInt(str, i);
    }

    public static long getLong(String str, long j) {
        return getPreferences().getLong(str, j);
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

    public static void putBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void putFloat(String str, float f) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putFloat(str, f);
        edit.apply();
    }

    public static void putInt(String str, int i) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static void putLong(String str, long j) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putLong(str, j);
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
        if (preferences.contains(str + LENGTH_SUFFIX)) {
            int i = preferences.getInt(str + LENGTH_SUFFIX, -1);
            if (i >= 0) {
                edit.remove(str + LENGTH_SUFFIX);
                for (int i2 = 0; i2 < i; i2++) {
                    edit.remove(str + LEFT_MOUNT + i2 + RIGHT_MOUNT);
                }
            }
        }
        edit.remove(str);
        edit.apply();
    }
}
