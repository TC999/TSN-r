package com.bytedance.sdk.openadsdk.core.u;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ox {

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f34803c;
    private String sr;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private int f34804w;
    private String xv;

    public ox(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f34803c = jSONObject;
            this.f34804w = jSONObject.optInt("dialog_type");
            this.xv = jSONObject.optString("template_url");
            this.sr = jSONObject.optString("template_md5");
        }
        com.bytedance.sdk.openadsdk.core.ugeno.f.c cVar = new com.bytedance.sdk.openadsdk.core.ugeno.f.c();
        cVar.w(ux());
        cVar.xv(sr());
    }

    public JSONObject c() {
        return this.f34803c;
    }

    public boolean f() {
        return this.ux;
    }

    public String sr() {
        return this.xv;
    }

    public String ux() {
        return this.sr;
    }

    public JSONObject w() {
        return this.f34803c;
    }

    public int xv() {
        return this.f34804w;
    }

    public void c(boolean z3) {
        this.ux = z3;
    }
}
