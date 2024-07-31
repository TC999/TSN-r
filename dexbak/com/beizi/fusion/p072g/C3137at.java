package com.beizi.fusion.p072g;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/* compiled from: SpUtil.java */
/* renamed from: com.beizi.fusion.g.at */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3137at {
    /* renamed from: a */
    public static void m48315a(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("fusion_config", 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (obj instanceof Boolean) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Integer) {
                edit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                edit.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else if (obj instanceof Set) {
                edit.remove(str);
                edit.putStringSet(str, (Set) obj);
            }
            edit.apply();
        }
    }

    /* renamed from: b */
    public static Object m48313b(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences("fusion_config", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sharedPreferences == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Set) {
            return sharedPreferences.getStringSet(str, (Set) obj);
        }
        return null;
    }

    /* renamed from: a */
    public static String m48316a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("beizisdk_config", 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(str, "");
    }

    /* renamed from: a */
    public static void m48314a(Context context, String str, String str2) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("beizisdk_config", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }
}
