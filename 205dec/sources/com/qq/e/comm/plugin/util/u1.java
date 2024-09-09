package com.qq.e.comm.plugin.util;

import android.content.SharedPreferences;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class u1 {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f46615a;

    public static int a(String str, int i4) {
        return b().getInt(str, i4);
    }

    public static void b(String str, int i4) {
        a().putInt(str, i4).apply();
    }

    public static String a(String str, String str2) {
        return b().getString(str, str2);
    }

    public static void b(String str, String str2) {
        a().putString(str, str2).apply();
    }

    public static long a(String str, long j4) {
        return b().getLong(str, j4);
    }

    public static void b(String str, long j4) {
        a().putLong(str, j4).apply();
    }

    public static boolean a(String str, boolean z3) {
        return b().getBoolean(str, z3);
    }

    public static void b(String str, boolean z3) {
        a().putBoolean(str, z3).apply();
    }

    public static void a(String str) {
        a().remove(str).apply();
    }

    private static SharedPreferences b() {
        if (f46615a == null) {
            f46615a = com.qq.e.comm.plugin.d0.a.d().a().getSharedPreferences("com.qq.e.sdkconfig", 0);
        }
        return f46615a;
    }

    private static SharedPreferences.Editor a() {
        return b().edit();
    }
}
