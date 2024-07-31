package com.bxkj.base.p085v2.data.spp;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.bxkj.base.v2.data.spp.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PreferencesUtils {
    /* renamed from: a */
    public static boolean m43565a(Context context, String str, String str2) {
        return m43564b(context, str, str2, false);
    }

    /* renamed from: b */
    public static boolean m43564b(Context context, String str, String str2, boolean z) {
        return context.getSharedPreferences(str, 0).getBoolean(str2, z);
    }

    /* renamed from: c */
    public static SharedPreferences.Editor m43563c(Context context, String str) {
        return context.getSharedPreferences(str, 0).edit();
    }

    /* renamed from: d */
    public static float m43562d(Context context, String str, String str2) {
        return m43561e(context, str, str2, -1.0f);
    }

    /* renamed from: e */
    public static float m43561e(Context context, String str, String str2, float f) {
        return context.getSharedPreferences(str, 0).getFloat(str2, f);
    }

    /* renamed from: f */
    public static int m43560f(Context context, String str, String str2) {
        return m43559g(context, str, str2, -1);
    }

    /* renamed from: g */
    public static int m43559g(Context context, String str, String str2, int i) {
        return context.getSharedPreferences(str, 0).getInt(str2, i);
    }

    /* renamed from: h */
    public static long m43558h(Context context, String str, String str2) {
        return m43557i(context, str, str2, -1L);
    }

    /* renamed from: i */
    public static long m43557i(Context context, String str, String str2, long j) {
        return context.getSharedPreferences(str, 0).getLong(str2, j);
    }

    /* renamed from: j */
    public static String m43556j(Context context, String str, String str2) {
        return m43555k(context, str, str2, null);
    }

    /* renamed from: k */
    public static String m43555k(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    /* renamed from: l */
    public static boolean m43554l(Context context, String str, String str2, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putBoolean(str2, z);
        return edit.commit();
    }

    /* renamed from: m */
    public static boolean m43553m(Context context, String str, String str2, float f) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putFloat(str2, f);
        return edit.commit();
    }

    /* renamed from: n */
    public static boolean m43552n(Context context, String str, String str2, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putInt(str2, i);
        return edit.commit();
    }

    /* renamed from: o */
    public static boolean m43551o(Context context, String str, String str2, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putLong(str2, j);
        return edit.commit();
    }

    /* renamed from: p */
    public static boolean m43550p(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        return edit.commit();
    }

    /* renamed from: q */
    public static boolean m43549q(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.remove(str2);
        return edit.commit();
    }
}
