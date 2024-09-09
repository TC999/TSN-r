package com.bytedance.sdk.openadsdk.core.fp.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ys.c;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {
    public static void c(com.bytedance.sdk.component.c.s sVar) {
        sVar.c("getDownloadStatus", (com.bytedance.sdk.component.c.ux<?, ?>) new p());
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        return c(jSONObject);
    }

    public static JSONObject c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            c(jSONObject2, 1, "params is null", 1, 1);
            return jSONObject2;
        }
        try {
            String optString = jSONObject.optString("ad_down_load_id");
            if (TextUtils.isEmpty(optString)) {
                c(jSONObject2, 1, "ad_down_load_id is null", 1, 1);
                return jSONObject2;
            }
            com.bytedance.sdk.component.utils.a.w("GetDownloadStatusMethod", "GetDownloadStatusMethod analysisJson downloadId " + optString);
            JSONObject c4 = c.C0525c.c(optString);
            com.bytedance.sdk.component.utils.a.w("GetDownloadStatusMethod", "GetDownloadStatusMethod analysisJson downloadJson " + c4.toString());
            return c4;
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    private static void c(JSONObject jSONObject, int i4, String str, int i5, int i6) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("code", i4);
            jSONObject.put("codeMsg", str);
            jSONObject.put("downloadStatus", i5);
            jSONObject.put("downloadProcessRate", i6);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.a.w("GetDownloadStatusMethod", str);
        }
    }
}
