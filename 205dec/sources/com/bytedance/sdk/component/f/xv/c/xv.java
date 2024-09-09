package com.bytedance.sdk.component.f.xv.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class xv {

    /* renamed from: c  reason: collision with root package name */
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> f29800c;

    private static String c(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static void w(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f29800c;
        if (softReference == null || softReference.get() == null || (map = f29800c.get().get(c(str))) == null) {
            return;
        }
        map.clear();
    }

    private static SharedPreferences xv(Context context, String str) {
        if (context == null) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.api.plugin.w.w(context, c(str), 0);
    }

    private static Object c(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f29800c;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(c(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static String xv(Context context, String str, String str2, String str3) {
        SharedPreferences xv = xv(context, str);
        return xv == null ? str3 : xv.getString(str2, str3);
    }

    private static Object w(Context context, String str, String str2, String str3) {
        String c4 = c(str);
        if (c(context, c4, str2)) {
            if (str3.equalsIgnoreCase("string")) {
                return xv(context, c4, str2, null);
            }
            if (str3.equalsIgnoreCase("boolean")) {
                return Boolean.valueOf(c(context, c4, str2, false));
            }
            if (str3.equalsIgnoreCase("int")) {
                return Integer.valueOf(c(context, c4, str2, 0));
            }
            if (str3.equalsIgnoreCase("long")) {
                return Long.valueOf(c(context, c4, str2, 0L));
            }
            if (str3.equalsIgnoreCase("float")) {
                return Float.valueOf(c(context, c4, str2, 0.0f));
            }
            if (str3.equalsIgnoreCase("string_set")) {
                return xv(context, c4, str2, null);
            }
            return null;
        }
        return null;
    }

    private static void c(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f29800c;
        if (softReference == null || softReference.get() == null) {
            f29800c = new SoftReference<>(new ConcurrentHashMap());
        }
        String c4 = c(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = f29800c.get();
        if (concurrentHashMap.get(c4) == null) {
            concurrentHashMap.put(c4, new HashMap());
        }
        concurrentHashMap.get(c4).put(str2, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized <T> void c(Context context, String str, String str2, T t3) {
        synchronized (xv.class) {
            SharedPreferences xv = xv(context, str);
            if (xv == null) {
                return;
            }
            if (t3.equals(c(str, str2))) {
                return;
            }
            SharedPreferences.Editor edit = xv.edit();
            if (t3 instanceof Boolean) {
                edit.putBoolean(str2, ((Boolean) t3).booleanValue());
            }
            if (t3 instanceof String) {
                edit.putString(str2, (String) t3);
            }
            if (t3 instanceof Integer) {
                edit.putInt(str2, ((Integer) t3).intValue());
            }
            if (t3 instanceof Long) {
                edit.putLong(str2, ((Long) t3).longValue());
            }
            if (t3 instanceof Float) {
                edit.putFloat(str2, ((Float) t3).floatValue());
            }
            edit.apply();
            c(str, str2, t3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(Context context, String str, String str2) {
        Map<String, Object> map;
        try {
            SharedPreferences xv = xv(context, str);
            if (xv == null) {
                return;
            }
            SharedPreferences.Editor edit = xv.edit();
            edit.remove(str2);
            edit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f29800c;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            String c4 = c(str);
            if (!TextUtils.isEmpty(c4) && (map = f29800c.get().get(c4)) != null && map.size() != 0) {
                map.remove(str2);
                SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference2 = f29800c;
                if (softReference2 == null || softReference2.get() == null) {
                    return;
                }
                f29800c.get().put(c4, map);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, ?> w(Context context, String str) {
        return xv(context, str).getAll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Context context, String str, String str2, String str3) {
        Object c4 = c(str, str2);
        if (c4 != null) {
            return c4 + "";
        }
        Object w3 = w(context, str, str2, str3);
        c(str, str2, w3);
        return w3 + "";
    }

    private static int c(Context context, String str, String str2, int i4) {
        SharedPreferences xv = xv(context, str);
        return xv == null ? i4 : xv.getInt(str2, i4);
    }

    private static float c(Context context, String str, String str2, float f4) {
        SharedPreferences xv = xv(context, str);
        return xv == null ? f4 : xv.getFloat(str2, f4);
    }

    private static boolean c(Context context, String str, String str2, boolean z3) {
        SharedPreferences xv = xv(context, str);
        return xv == null ? z3 : xv.getBoolean(str2, z3);
    }

    private static long c(Context context, String str, String str2, long j4) {
        SharedPreferences xv = xv(context, str);
        return xv == null ? j4 : xv.getLong(str2, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Context context, String str, String str2) {
        SharedPreferences xv = xv(context, str);
        return xv != null && xv.contains(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context, String str) {
        SharedPreferences.Editor edit = xv(context, str).edit();
        edit.clear();
        edit.apply();
        w(str);
    }
}
