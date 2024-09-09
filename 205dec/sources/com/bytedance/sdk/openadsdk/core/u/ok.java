package com.bytedance.sdk.openadsdk.core.u;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ok {

    /* renamed from: c  reason: collision with root package name */
    private String f34795c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private int f34796f;

    /* renamed from: r  reason: collision with root package name */
    private String f34797r;
    private String sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private int f34798w;
    private String xv;

    public String c() {
        return this.f34795c;
    }

    public String ev() {
        return this.ev;
    }

    public int f() {
        return this.f34796f;
    }

    public JSONObject gd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wc_skip_type", w());
            jSONObject.put("wc_miniapp_link", c());
            jSONObject.put(DomainCampaignEx.JSON_KEY_ADV_ID, xv());
            jSONObject.put("site_id", sr());
            jSONObject.put("wc_open_method", f());
            jSONObject.put("wc_miniapp_sdk", r());
            jSONObject.put("wc_appid", ev());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.w("toString failed:" + th.getMessage());
        }
        return jSONObject;
    }

    public String r() {
        return this.f34797r;
    }

    public String sr() {
        return this.sr;
    }

    public String toString() {
        return gd().toString();
    }

    public int ux() {
        return this.ux;
    }

    public int w() {
        return this.f34798w;
    }

    public String xv() {
        return this.xv;
    }

    public void c(String str) {
        this.f34795c = str;
    }

    public void sr(String str) {
        this.f34797r = str;
    }

    public void ux(String str) {
        this.ev = str;
    }

    public void w(String str) {
        this.xv = str;
    }

    public void xv(String str) {
        this.sr = str;
    }

    public void c(int i4) {
        this.f34798w = i4;
    }

    public void w(int i4) {
        this.ux = i4;
    }

    public void xv(int i4) {
        this.f34796f = i4;
    }

    public static ok c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ok okVar = new ok();
        try {
            okVar.c(jSONObject.optInt("wc_skip_type"));
            okVar.c(jSONObject.optString("wc_miniapp_link"));
            okVar.w(jSONObject.optString(DomainCampaignEx.JSON_KEY_ADV_ID));
            okVar.xv(jSONObject.optString("site_id"));
            okVar.xv(jSONObject.optInt("wc_open_method"));
            okVar.sr(jSONObject.optString("wc_miniapp_sdk"));
            okVar.ux(jSONObject.optString("wc_appid"));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.w("parse WechatData failed:" + th.getMessage());
        }
        return okVar;
    }
}
