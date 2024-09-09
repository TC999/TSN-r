package com.qq.e.comm.plugin.q0.s;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f45534a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f45535b;

    public b(String str, JSONObject jSONObject) {
        this.f45534a = str;
        this.f45535b = jSONObject;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("try {");
        sb.append("bridge.dispatch");
        sb.append("({'type':'");
        sb.append(this.f45534a);
        sb.append("','param':");
        JSONObject jSONObject = this.f45535b;
        sb.append(jSONObject == null ? "null" : JSONObject.quote(jSONObject.toString()));
        sb.append("})");
        sb.append("} catch(e) { console.log(e) }");
        return sb.toString();
    }
}
