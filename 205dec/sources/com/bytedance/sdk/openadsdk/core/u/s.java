package com.bytedance.sdk.openadsdk.core.u;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class s {

    /* renamed from: c  reason: collision with root package name */
    int f34816c = 1;

    /* renamed from: w  reason: collision with root package name */
    int f34817w = 1;

    public void c(int i4) {
        this.f34816c = i4;
    }

    public void w(int i4) {
        this.f34817w = i4;
    }

    public JSONObject xv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ah", this.f34816c);
            jSONObject.put("am", this.f34817w);
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.xv(e4.toString());
        }
        return jSONObject;
    }

    public boolean c() {
        return this.f34816c == 1;
    }

    public boolean w() {
        return this.f34817w == 1;
    }
}
