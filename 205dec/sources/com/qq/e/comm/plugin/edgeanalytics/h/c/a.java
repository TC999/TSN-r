package com.qq.e.comm.plugin.edgeanalytics.h.c;

import android.content.SharedPreferences;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {
    public static String a(String str, String str2) {
        return c().getString(str, str2);
    }

    public static void b(String str, String str2) {
        b().putString(str, str2).apply();
    }

    private static SharedPreferences c() {
        return com.qq.e.comm.plugin.d0.a.d().a().getSharedPreferences("com.qq.e.eaconfig", 0);
    }

    public static long a(String str, long j4) {
        return c().getLong(str, j4);
    }

    public static void b(String str, long j4) {
        b().putLong(str, j4).apply();
    }

    public static boolean a(String str, boolean z3) {
        return c().getBoolean(str, z3);
    }

    public static void b(String str, boolean z3) {
        b().putBoolean(str, z3).apply();
    }

    public static void a() {
        b().clear().apply();
    }

    private static SharedPreferences.Editor b() {
        return c().edit();
    }

    public static void a(String str) {
        if (c().contains(str)) {
            b().remove(str).apply();
        }
    }
}
