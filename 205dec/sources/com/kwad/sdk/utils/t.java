package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class t {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static <T> JSONArray O(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (T t3 : list) {
                        if (t3 != null) {
                            if (t3 instanceof JSONObject) {
                                jSONArray.put(t3);
                            } else if (t3 instanceof com.kwad.sdk.core.b) {
                                jSONArray.put(((com.kwad.sdk.core.b) t3).toJson());
                            } else if (t3 instanceof String) {
                                jSONArray.put(t3);
                            } else {
                                throw new IllegalArgumentException("<T> now suppprt type: " + t3.getClass().getName());
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        return jSONArray;
    }

    public static void a(JSONObject jSONObject, String str, com.kwad.sdk.core.b bVar) {
        if (jSONObject == null || bVar == null) {
            return;
        }
        try {
            jSONObject.put(str, bVar.toJson());
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static <T extends com.kwad.sdk.core.b> T b(@Nullable String str, @NonNull com.kwad.sdk.core.c<T> cVar) {
        T AW = cVar.AW();
        try {
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        if (TextUtils.isEmpty(str)) {
            return AW;
        }
        AW.parseJson(new JSONObject(str));
        return AW;
    }

    public static <T> List<T> gx(String str) {
        return u.gx(str);
    }

    public static <T> List<T> h(JSONArray jSONArray) {
        return u.h(jSONArray);
    }

    public static void merge(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            u.merge(jSONObject, jSONObject2);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        return u.parseJSON2MapString(str);
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        return u.parseMap2JSON(map);
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, str2);
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        return u.toJsonArray(list);
    }

    public static JSONArray a(JSONArray jSONArray, JSONObject jSONObject) {
        try {
            jSONArray.put(jSONObject);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return jSONArray;
    }

    public static void putValue(JSONObject jSONObject, String str, double d4) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, d4);
    }

    public static void putValue(JSONObject jSONObject, String str, int i4) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, i4);
    }

    public static <T extends com.kwad.sdk.core.b> List<T> a(String str, @NonNull com.kwad.sdk.core.c<T> cVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                T AW = cVar.AW();
                AW.parseJson(jSONObject);
                arrayList.add(AW);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return arrayList;
    }

    public static void putValue(JSONObject jSONObject, String str, float f4) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, f4);
    }

    public static void putValue(JSONObject jSONObject, String str, byte b4) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, b4);
    }

    public static void putValue(JSONObject jSONObject, String str, long j4) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, j4);
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z3) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, z3);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, jSONObject2);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, jSONArray);
    }

    public static void putValue(JSONObject jSONObject, String str, List<?> list) {
        if (jSONObject == null || list == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            boolean z3 = false;
            for (Object obj : list) {
                if (obj instanceof com.kwad.sdk.core.b) {
                    a(jSONArray, ((com.kwad.sdk.core.b) obj).toJson());
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof JSONObject) && !(obj instanceof JSONArray) && !(obj instanceof Double) && !(obj instanceof Boolean)) {
                        if (!(obj instanceof Float)) {
                            break;
                        }
                        try {
                            jSONArray.put(((Float) obj).floatValue());
                        } catch (JSONException unused) {
                        }
                    }
                    jSONArray.put(obj);
                }
                z3 = true;
            }
            if (z3) {
                putValue(jSONObject, str, jSONArray);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
