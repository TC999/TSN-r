package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMRTLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: DataSpliter.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class q {
    public static JSONObject a(Context context, long j4, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject.has("content")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("content");
                if (jSONObject3.has("analytics")) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("analytics");
                    if (jSONObject4.has("ekv")) {
                        jSONObject4.remove("ekv");
                    }
                    if (jSONObject4.has("gkv")) {
                        jSONObject4.remove("gkv");
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
                if (a(jSONObject2) > j4) {
                    jSONObject2 = null;
                    i.a(context).i();
                    i.a(context).h();
                    i.a(context).b(true, false);
                    i.a(context).a();
                    UMRTLog.i("MobclickRT", "--->>> u-app packet overload !!! ");
                    return null;
                }
                return jSONObject2;
            }
            return jSONObject2;
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    public static long a(JSONObject jSONObject) {
        return jSONObject.toString().getBytes().length;
    }

    public static long a(JSONArray jSONArray) {
        return jSONArray.toString().getBytes().length;
    }
}
