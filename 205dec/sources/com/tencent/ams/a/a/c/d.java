package com.tencent.ams.a.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {
    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    public static String b(Context context, String str, String str2) {
        return (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : context.getSharedPreferences(str, 0).getString(str2, "");
    }

    public static void a(Context context, String str, String str2, long j4) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putLong(str2, j4);
        edit.commit();
    }

    public static long a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0L;
        }
        return context.getSharedPreferences(str, 0).getLong(str2, 0L);
    }
}
