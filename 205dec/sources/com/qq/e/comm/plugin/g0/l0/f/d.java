package com.qq.e.comm.plugin.g0.l0.f;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f43718a;

    /* renamed from: b  reason: collision with root package name */
    private int f43719b;

    public void a(JSONObject jSONObject) {
        this.f43718a = jSONObject;
    }

    public JSONObject b() {
        return this.f43718a;
    }

    public int a() {
        return this.f43719b;
    }

    public void a(int i4) {
        this.f43719b = i4;
    }

    public void a(long j4) {
        JSONObject jSONObject = this.f43718a;
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("adReturnTime", j4);
        } catch (JSONException unused) {
        }
    }
}
