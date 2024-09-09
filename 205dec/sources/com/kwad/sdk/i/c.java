package com.kwad.sdk.i;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (obj == null || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (Throwable unused) {
            j.Jm();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putValue(JSONObject jSONObject, String str, List<k> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (k kVar : list) {
                        jSONArray.put(kVar.toJson());
                    }
                    jSONObject.put(str, jSONArray);
                }
            } catch (Throwable unused) {
                j.Jm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putValue(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Throwable unused) {
            j.Jm();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putValue(JSONObject jSONObject, String str, long j4) {
        try {
            jSONObject.put(str, j4);
        } catch (Throwable unused) {
            j.Jm();
        }
    }
}
