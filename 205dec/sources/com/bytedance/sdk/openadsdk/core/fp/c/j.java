package com.bytedance.sdk.openadsdk.core.fp.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class j extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.me f33558c;

    private j(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        this.f33558c = meVar;
    }

    private int w(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("video".equals(str)) {
            return 2;
        }
        return "canvas".equals(str) ? 3 : 0;
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        sVar.c("reportPlayableScreenshot", (com.bytedance.sdk.component.c.ux<?, ?>) new j(meVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        return c(jSONObject);
    }

    private JSONObject c(JSONObject jSONObject) {
        String optString;
        Bitmap c4;
        com.bytedance.sdk.component.utils.a.w("ReportPlayableScreenshotMethod", "reportPlayableScreenshot ");
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            c(jSONObject2, 1, "params is null");
            return jSONObject2;
        }
        try {
            String optString2 = jSONObject.optString("image");
            optString = jSONObject.optString("type");
            c4 = com.bytedance.sdk.component.utils.sr.c(optString2);
        } catch (Throwable unused) {
        }
        if (c4 == null) {
            c(jSONObject2, 1, "imageBase64 to Bitmap error");
            return jSONObject2;
        } else if (this.f33558c == null) {
            c(jSONObject2, 1, "materialMeta is null");
            return jSONObject2;
        } else {
            Bitmap c5 = com.bytedance.sdk.component.utils.sr.c(c4, c4.getWidth() / 6, c4.getHeight() / 6);
            Context context = com.bytedance.sdk.openadsdk.core.ls.getContext();
            com.bytedance.sdk.openadsdk.core.u.me meVar = this.f33558c;
            xk.c(context, meVar, wv.c(meVar), "playable_show_status", c5, true, w(optString));
            return jSONObject2;
        }
    }

    private void c(JSONObject jSONObject, int i4, String str) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("code", i4);
            jSONObject.put("codeMsg", str);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.a.w("ReportPlayableScreenshotMethod", str);
        }
    }
}
