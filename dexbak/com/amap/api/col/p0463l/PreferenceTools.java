package com.amap.api.col.p0463l;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.amap.api.col.3l.q2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class PreferenceTools {
    /* renamed from: a */
    public static Long m54148a(Context context, String str, String str2, Long l) {
        Object m54145d = m54145d(context, str, str2, l);
        return m54145d != null ? (Long) m54145d : l;
    }

    /* renamed from: b */
    public static String m54147b(Context context, String str, String str2, String str3) {
        Object m54145d = m54145d(context, str, str2, str3);
        return m54145d != null ? (String) m54145d : str3;
    }

    /* renamed from: c */
    public static void m54146c(Context context, String str, String str2, Object obj) {
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

    /* renamed from: d */
    private static Object m54145d(Context context, String str, String str2, Object obj) {
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