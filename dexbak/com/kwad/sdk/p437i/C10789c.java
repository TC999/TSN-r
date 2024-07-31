package com.kwad.sdk.p437i;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.i.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C10789c {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m24866a(JSONObject jSONObject, String str, Object obj) {
        if (obj == null || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (Throwable unused) {
            C10800j.m24813Jm();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putValue(JSONObject jSONObject, String str, List<C10802k> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (C10802k c10802k : list) {
                        jSONArray.put(c10802k.toJson());
                    }
                    jSONObject.put(str, jSONArray);
                }
            } catch (Throwable unused) {
                C10800j.m24813Jm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putValue(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Throwable unused) {
            C10800j.m24813Jm();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putValue(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (Throwable unused) {
            C10800j.m24813Jm();
        }
    }
}
