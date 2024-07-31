package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMRTLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.q */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DataSpliter {
    /* renamed from: a */
    public static JSONObject m14215a(Context context, long j, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject.has("content")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("content");
                if (jSONObject3.has("analytics")) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("analytics");
                    if (jSONObject4.has("ekv")) {
                        jSONObject4.remove("ekv");
                    }
                    if (jSONObject4.has(UContent.f38095Z)) {
                        jSONObject4.remove(UContent.f38095Z);
                    }
                    if (jSONObject4.has("error")) {
                        jSONObject4.remove("error");
                    }
                    jSONObject3.put("analytics", jSONObject4);
                }
                jSONObject2.put("content", jSONObject3);
                if (jSONObject.has("header")) {
                    jSONObject2.put("header", jSONObject.getJSONObject("header"));
                }
                if (m14213a(jSONObject2) > j) {
                    jSONObject2 = null;
                    UMStoreManager.m14345a(context).m14315i();
                    UMStoreManager.m14345a(context).m14316h();
                    UMStoreManager.m14345a(context).m14325b(true, false);
                    UMStoreManager.m14345a(context).m14346a();
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> u-app packet overload !!! ");
                    return null;
                }
                return jSONObject2;
            }
            return jSONObject2;
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    /* renamed from: a */
    public static long m14213a(JSONObject jSONObject) {
        return jSONObject.toString().getBytes().length;
    }

    /* renamed from: a */
    public static long m14214a(JSONArray jSONArray) {
        return jSONArray.toString().getBytes().length;
    }
}
