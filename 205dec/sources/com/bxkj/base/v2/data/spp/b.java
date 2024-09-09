package com.bxkj.base.v2.data.spp;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PreferencesUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class b {
    public static boolean a(Context context, String str, String str2) {
        return b(context, str, str2, false);
    }

    public static boolean b(Context context, String str, String str2, boolean z3) {
        return context.getSharedPreferences(str, 0).getBoolean(str2, z3);
    }

    public static SharedPreferences.Editor c(Context context, String str) {
        return context.getSharedPreferences(str, 0).edit();
    }

    public static float d(Context context, String str, String str2) {
        return e(context, str, str2, -1.0f);
    }

    public static float e(Context context, String str, String str2, float f4) {
        return context.getSharedPreferences(str, 0).getFloat(str2, f4);
    }

    public static int f(Context context, String str, String str2) {
        return g(context, str, str2, -1);
    }

    public static int g(Context context, String str, String str2, int i4) {
        return context.getSharedPreferences(str, 0).getInt(str2, i4);
    }

    public static long h(Context context, String str, String str2) {
        return i(context, str, str2, -1L);
    }

    public static long i(Context context, String str, String str2, long j4) {
        return context.getSharedPreferences(str, 0).getLong(str2, j4);
    }

    public static String j(Context context, String str, String str2) {
        return k(context, str, str2, null);
    }

    public static String k(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static boolean l(Context context, String str, String str2, boolean z3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putBoolean(str2, z3);
        return edit.commit();
    }

    public static boolean m(Context context, String str, String str2, float f4) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putFloat(str2, f4);
        return edit.commit();
    }

    public static boolean n(Context context, String str, String str2, int i4) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putInt(str2, i4);
        return edit.commit();
    }

    public static boolean o(Context context, String str, String str2, long j4) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putLong(str2, j4);
        return edit.commit();
    }

    public static boolean p(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        return edit.commit();
    }

    public static boolean q(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.remove(str2);
        return edit.commit();
    }
}
