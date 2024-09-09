package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ys {

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f34908c;
    private int sr;
    private JSONObject ux;

    /* renamed from: w  reason: collision with root package name */
    private String f34909w;
    private String xv;

    public ys() {
    }

    public static void c(String str) {
        f34908c = str;
    }

    private String sr(String str) {
        if (this.ux != null && !TextUtils.isEmpty(str) && this.f34909w != null) {
            String optString = this.ux.optString(str);
            if (!TextUtils.isEmpty(optString)) {
                String str2 = this.f34909w.contains("?") ? "&" : "?";
                return this.f34909w + str2 + optString;
            }
        }
        return this.f34909w;
    }

    public void w(String str) {
        this.f34909w = str;
    }

    public void xv(String str) {
        this.xv = str;
    }

    public ys(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        w(jSONObject.optString("deeplink_url"));
        xv(jSONObject.optString("fallback_url"));
        c(jSONObject.optInt("fallback_type"));
        this.ux = jSONObject.optJSONObject("addon_params");
    }

    public void c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("deeplink_url", c());
            jSONObject2.put("fallback_url", w());
            jSONObject2.put("fallback_type", xv());
            jSONObject2.put("addon_params", this.ux);
            jSONObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, jSONObject2);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public String w() {
        return this.xv;
    }

    public int xv() {
        return this.sr;
    }

    public String c() {
        return sr(f34908c);
    }

    public void c(int i4) {
        this.sr = i4;
    }

    public void c(ys ysVar) {
        if (ysVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(ysVar.c())) {
            w(ysVar.c());
        }
        if (!TextUtils.isEmpty(ysVar.w())) {
            xv(ysVar.w());
        }
        if (ysVar.xv() != 0) {
            c(ysVar.xv());
        }
    }
}
