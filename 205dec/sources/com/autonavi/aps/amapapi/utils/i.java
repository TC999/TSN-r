package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SPUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i {
    public static SharedPreferences.Editor a(Context context, String str) {
        return context.getSharedPreferences(str, 0).edit();
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        editor.apply();
    }

    public static void a(SharedPreferences.Editor editor, String str) {
        try {
            editor.remove(str);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "setPrefsLong");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, long j4) {
        try {
            editor.putLong(str, j4);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "setPrefsLong");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, boolean z3) {
        try {
            editor.putBoolean(str, z3);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "updatePrefsBoolean");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, String str2) {
        try {
            editor.putString(str, str2);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "setPrefsStr");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, int i4) {
        try {
            editor.putInt(str, i4);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "setPrefsInt");
        }
    }

    public static long a(Context context, String str, String str2, long j4) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j4);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "getPrefsLong");
            return j4;
        }
    }

    public static int a(Context context, String str, String str2, int i4) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i4);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "getPrefsInt");
            return i4;
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z3) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z3);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "getPrefsBoolean");
            return z3;
        }
    }

    public static String a(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    public static String a(Context context) {
        return context == null ? "00:00:00:00:00:00" : a(context, "pref", "smac", "00:00:00:00:00:00");
    }
}
