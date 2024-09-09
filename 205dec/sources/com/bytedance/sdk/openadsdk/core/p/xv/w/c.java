package com.bytedance.sdk.openadsdk.core.p.xv.w;

import com.bytedance.sdk.openadsdk.core.u.me;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public me f34380c;
    public JSONObject sr;

    /* renamed from: w  reason: collision with root package name */
    public String f34381w;
    public String xv;

    public static c c() {
        return new c();
    }

    public c w(String str) {
        this.xv = str;
        return this;
    }

    public static c c(JSONObject jSONObject) {
        String str;
        String str2;
        JSONObject jSONObject2;
        me meVar = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            str = jSONObject.optString("tag", null);
            try {
                str2 = jSONObject.optString("label", null);
                try {
                    jSONObject2 = jSONObject.optJSONObject("extra");
                    try {
                        meVar = com.bytedance.sdk.openadsdk.core.w.c(jSONObject.optJSONObject("material_meta"));
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    jSONObject2 = null;
                }
            } catch (Exception unused3) {
                str2 = null;
                jSONObject2 = str2;
                return c().c(str).w(str2).w(jSONObject2).c(meVar);
            }
        } catch (Exception unused4) {
            str = null;
            str2 = null;
        }
        return c().c(str).w(str2).w(jSONObject2).c(meVar);
    }

    public c w(JSONObject jSONObject) {
        this.sr = jSONObject;
        return this;
    }

    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", this.f34381w);
            jSONObject.put("label", this.xv);
            JSONObject jSONObject2 = this.sr;
            if (jSONObject2 != null) {
                jSONObject.put("extra", jSONObject2);
            }
            me meVar = this.f34380c;
            if (meVar != null) {
                jSONObject.put("material_meta", meVar.mo());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public c c(me meVar) {
        this.f34380c = meVar;
        return this;
    }

    public c c(String str) {
        this.f34381w = str;
        return this;
    }
}
