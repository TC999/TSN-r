package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC10229c;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.utils.t */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C11126t {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: O */
    public static <T> JSONArray m23681O(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (T t : list) {
                        if (t != null) {
                            if (t instanceof JSONObject) {
                                jSONArray.put(t);
                            } else if (t instanceof InterfaceC9914b) {
                                jSONArray.put(((InterfaceC9914b) t).toJson());
                            } else if (t instanceof String) {
                                jSONArray.put(t);
                            } else {
                                throw new IllegalArgumentException("<T> now suppprt type: " + t.getClass().getName());
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

    /* renamed from: a */
    public static void m23678a(JSONObject jSONObject, String str, InterfaceC9914b interfaceC9914b) {
        if (jSONObject == null || interfaceC9914b == null) {
            return;
        }
        try {
            jSONObject.put(str, interfaceC9914b.toJson());
        } catch (JSONException unused) {
        }
    }

    @NonNull
    /* renamed from: b */
    public static <T extends InterfaceC9914b> T m23677b(@Nullable String str, @NonNull InterfaceC10229c<T> interfaceC10229c) {
        T mo23794AW = interfaceC10229c.mo23794AW();
        try {
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        if (TextUtils.isEmpty(str)) {
            return mo23794AW;
        }
        mo23794AW.parseJson(new JSONObject(str));
        return mo23794AW;
    }

    /* renamed from: gx */
    public static <T> List<T> m23676gx(String str) {
        return C11127u.m23674gx(str);
    }

    /* renamed from: h */
    public static <T> List<T> m23675h(JSONArray jSONArray) {
        return C11127u.m23673h(jSONArray);
    }

    public static void merge(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            C11127u.merge(jSONObject, jSONObject2);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        return C11127u.parseJSON2MapString(str);
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        return C11127u.parseMap2JSON(map);
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return;
        }
        C11127u.putValue(jSONObject, str, str2);
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        return C11127u.toJsonArray(list);
    }

    /* renamed from: a */
    public static JSONArray m23679a(JSONArray jSONArray, JSONObject jSONObject) {
        try {
            jSONArray.put(jSONObject);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return jSONArray;
    }

    public static void putValue(JSONObject jSONObject, String str, double d) {
        if (jSONObject == null) {
            return;
        }
        C11127u.putValue(jSONObject, str, d);
    }

    public static void putValue(JSONObject jSONObject, String str, int i) {
        if (jSONObject == null) {
            return;
        }
        C11127u.putValue(jSONObject, str, i);
    }

    /* renamed from: a */
    public static <T extends InterfaceC9914b> List<T> m23680a(String str, @NonNull InterfaceC10229c<T> interfaceC10229c) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                T mo23794AW = interfaceC10229c.mo23794AW();
                mo23794AW.parseJson(jSONObject);
                arrayList.add(mo23794AW);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return arrayList;
    }

    public static void putValue(JSONObject jSONObject, String str, float f) {
        if (jSONObject == null) {
            return;
        }
        C11127u.putValue(jSONObject, str, f);
    }

    public static void putValue(JSONObject jSONObject, String str, byte b) {
        if (jSONObject == null) {
            return;
        }
        C11127u.putValue(jSONObject, str, b);
    }

    public static void putValue(JSONObject jSONObject, String str, long j) {
        if (jSONObject == null) {
            return;
        }
        C11127u.putValue(jSONObject, str, j);
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null) {
            return;
        }
        C11127u.putValue(jSONObject, str, z);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        C11127u.putValue(jSONObject, str, jSONObject2);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONObject == null) {
            return;
        }
        C11127u.putValue(jSONObject, str, jSONArray);
    }

    public static void putValue(JSONObject jSONObject, String str, List<?> list) {
        if (jSONObject == null || list == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            boolean z = false;
            for (Object obj : list) {
                if (obj instanceof InterfaceC9914b) {
                    m23679a(jSONArray, ((InterfaceC9914b) obj).toJson());
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
                z = true;
            }
            if (z) {
                putValue(jSONObject, str, jSONArray);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
