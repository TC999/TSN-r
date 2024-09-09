package com.bytedance.sdk.openadsdk.core.u;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xk {

    /* renamed from: c  reason: collision with root package name */
    private String f34888c;

    /* renamed from: w  reason: collision with root package name */
    private String f34889w;
    private String xv;

    public String c() {
        return this.f34888c;
    }

    public JSONObject sr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("group_id", c());
            jSONObject.put("group_tag", w());
            jSONObject.put("card_tag", xv());
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.xv(e4.toString());
        }
        return jSONObject;
    }

    public String w() {
        return this.f34889w;
    }

    public String xv() {
        return this.xv;
    }

    public void c(String str) {
        this.f34888c = str;
    }

    public void w(String str) {
        this.f34889w = str;
    }

    public void xv(String str) {
        this.xv = str;
    }
}
