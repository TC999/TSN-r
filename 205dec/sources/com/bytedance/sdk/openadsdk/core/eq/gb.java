package com.bytedance.sdk.openadsdk.core.eq;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class gb {

    /* renamed from: w  reason: collision with root package name */
    private static AtomicBoolean f33243w = new AtomicBoolean(true);

    /* renamed from: c  reason: collision with root package name */
    public static volatile Map<String, Boolean> f33242c = new ConcurrentHashMap();
    private static final com.bytedance.sdk.component.f.c xv = ba.c("tt_scheme_check_list_cache", true);

    private gb() {
    }

    public static void c(String str, Boolean bool) {
        String bool2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bool == null) {
            bool2 = "";
        } else {
            try {
                bool2 = bool.toString();
            } catch (Throwable unused) {
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("value", bool2);
        jSONObject.put("time", System.currentTimeMillis());
        xv.c(str, jSONObject.toString());
        f33243w.set(true);
    }

    public static Map<String, Boolean> w(long j4) {
        HashMap hashMap = new HashMap();
        try {
            Map<String, ?> c4 = xv.c();
            if (c4 != null && !c4.isEmpty()) {
                for (Map.Entry<String, ?> entry : c4.entrySet()) {
                    JSONObject jSONObject = new JSONObject(entry.getValue().toString());
                    long currentTimeMillis = System.currentTimeMillis() - jSONObject.getLong("time");
                    String key = entry.getKey();
                    if (currentTimeMillis > 259200000) {
                        c(key);
                    } else if (currentTimeMillis <= j4) {
                        hashMap.put(key, Boolean.valueOf(Boolean.parseBoolean(jSONObject.get("value").toString())));
                    }
                }
                if (f33242c == null) {
                    f33242c = new ConcurrentHashMap();
                } else {
                    f33242c.clear();
                }
                f33242c.putAll(hashMap);
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    public static Map<String, Boolean> c(long j4) {
        try {
            if (f33243w.get()) {
                synchronized (gb.class) {
                    if (f33243w.get()) {
                        Map<String, Boolean> w3 = w(j4);
                        f33243w.set(false);
                        return w3;
                    }
                }
            }
            return new HashMap(f33242c);
        } catch (Throwable unused) {
            return new HashMap();
        }
    }

    private static JSONObject w(String str) {
        String w3 = xv.w(str, "");
        if (TextUtils.isEmpty(w3)) {
            return null;
        }
        try {
            return new JSONObject(w3);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean c(String str, long j4) {
        JSONObject w3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            w3 = w(str);
        } catch (Throwable unused) {
        }
        if (w3 == null) {
            return null;
        }
        if (System.currentTimeMillis() - w3.getLong("time") <= j4) {
            return Boolean.valueOf(Boolean.parseBoolean(w3.getString("value")));
        }
        return null;
    }

    private static void c(String str) {
        xv.c(str);
    }
}
