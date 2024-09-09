package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PreferenceTools.java */
/* renamed from: com.amap.api.col.3l.q2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class q2 {
    public static Long a(Context context, String str, String str2, Long l4) {
        Object d4 = d(context, str, str2, l4);
        return d4 != null ? (Long) d4 : l4;
    }

    public static String b(Context context, String str, String str2, String str3) {
        Object d4 = d(context, str, str2, str3);
        return d4 != null ? (String) d4 : str3;
    }

    public static void c(Context context, String str, String str2, Object obj) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        if (obj instanceof String) {
            edit.putString(str2, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str2, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str2, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str2, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str2, ((Long) obj).longValue());
        } else {
            edit.putString(str2, obj.toString());
        }
        edit.apply();
    }

    private static Object d(Context context, String str, String str2, Object obj) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (obj instanceof String) {
            return sharedPreferences.getString(str2, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str2, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str2, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str2, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str2, ((Long) obj).longValue()));
        }
        return null;
    }
}
