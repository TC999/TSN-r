package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class u {
    public static <T> List<T> gx(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            return h(new JSONArray(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
            return arrayList;
        }
    }

    public static <T> List<T> h(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            try {
                Object obj = jSONArray.get(i4);
                if (obj != null) {
                    arrayList.add(obj);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
        return arrayList;
    }

    public static void merge(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            Object opt = jSONObject2.opt(obj);
            if (opt != null) {
                try {
                    jSONObject.put(obj, opt);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next, "");
                if (TextUtils.isEmpty(optString) || TextUtils.equals("null", optString)) {
                    optString = "";
                }
                hashMap.put(next, optString);
            }
        } catch (JSONException unused) {
        }
        return hashMap;
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Throwable unused) {
        }
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    public static void putValue(JSONObject jSONObject, String str, double d4) {
        try {
            jSONObject.put(str, d4);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, int i4) {
        try {
            jSONObject.put(str, i4);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, float f4) {
        try {
            jSONObject.put(str, f4);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, byte b4) {
        try {
            jSONObject.put(str, (int) b4);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, long j4) {
        try {
            jSONObject.put(str, j4);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z3) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, z3);
            } catch (Throwable unused) {
            }
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, jSONObject2);
            } catch (Throwable unused) {
            }
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0 && jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, jSONArray);
            } catch (Throwable unused) {
            }
        }
    }
}
