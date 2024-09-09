package com.bytedance.sdk.openadsdk.core.u;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class wo {

    /* renamed from: c  reason: collision with root package name */
    private String f34860c;
    private String sr;

    /* renamed from: w  reason: collision with root package name */
    private String f34861w;
    private String xv;

    public wo(String str, String str2, String str3, String str4) {
        this.f34860c = str3;
        this.f34861w = str2;
        this.sr = str;
        this.xv = str4;
    }

    public void c(String str, String str2, String str3, String str4) {
        this.f34860c = str3;
        this.f34861w = str2;
        this.sr = str;
        this.xv = str4;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tk", this.f34860c).put("vd", this.sr).put("cr", this.xv).put("err", this.f34861w);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public String w() {
        return this.f34860c;
    }

    public String c() {
        return this.f34861w;
    }
}
