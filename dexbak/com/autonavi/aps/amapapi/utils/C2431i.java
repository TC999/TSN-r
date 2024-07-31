package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SPUtil.java */
/* renamed from: com.autonavi.aps.amapapi.utils.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2431i {
    /* renamed from: a */
    public static SharedPreferences.Editor m51222a(Context context, String str) {
        return context.getSharedPreferences(str, 0).edit();
    }

    /* renamed from: a */
    public static void m51217a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        editor.apply();
    }

    /* renamed from: a */
    public static void m51216a(SharedPreferences.Editor editor, String str) {
        try {
            editor.remove(str);
        } catch (Throwable th) {
            C2428b.m51299a(th, "SpUtil", "setPrefsLong");
        }
    }

    /* renamed from: a */
    public static void m51214a(SharedPreferences.Editor editor, String str, long j) {
        try {
            editor.putLong(str, j);
        } catch (Throwable th) {
            C2428b.m51299a(th, "SpUtil", "setPrefsLong");
        }
    }

    /* renamed from: a */
    public static void m51212a(SharedPreferences.Editor editor, String str, boolean z) {
        try {
            editor.putBoolean(str, z);
        } catch (Throwable th) {
            C2428b.m51299a(th, "SpUtil", "updatePrefsBoolean");
        }
    }

    /* renamed from: a */
    public static void m51213a(SharedPreferences.Editor editor, String str, String str2) {
        try {
            editor.putString(str, str2);
        } catch (Throwable th) {
            C2428b.m51299a(th, "SpUtil", "setPrefsStr");
        }
    }

    /* renamed from: a */
    public static void m51215a(SharedPreferences.Editor editor, String str, int i) {
        try {
            editor.putInt(str, i);
        } catch (Throwable th) {
            C2428b.m51299a(th, "SpUtil", "setPrefsInt");
        }
    }

    /* renamed from: a */
    public static long m51220a(Context context, String str, String str2, long j) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Throwable th) {
            C2428b.m51299a(th, "SpUtil", "getPrefsLong");
            return j;
        }
    }

    /* renamed from: a */
    public static int m51221a(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            C2428b.m51299a(th, "SpUtil", "getPrefsInt");
            return i;
        }
    }

    /* renamed from: a */
    public static boolean m51218a(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            C2428b.m51299a(th, "SpUtil", "getPrefsBoolean");
            return z;
        }
    }

    /* renamed from: a */
    public static String m51219a(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            C2428b.m51299a(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    /* renamed from: a */
    public static String m51223a(Context context) {
        return context == null ? "00:00:00:00:00:00" : m51219a(context, "pref", "smac", "00:00:00:00:00:00");
    }
}
