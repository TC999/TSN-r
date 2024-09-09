package com.qq.e.comm.plugin.g0;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f43487a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f43488b;

    public b0(JSONObject jSONObject) {
        this.f43487a = jSONObject;
        this.f43488b = jSONObject == null ? null : jSONObject.optJSONObject("playcfg");
    }

    public JSONObject a() {
        return this.f43487a;
    }

    public String toString() {
        JSONObject jSONObject = this.f43487a;
        return jSONObject == null ? "{}" : jSONObject.toString();
    }
}
