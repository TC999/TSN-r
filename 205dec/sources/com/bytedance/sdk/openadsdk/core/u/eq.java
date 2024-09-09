package com.bytedance.sdk.openadsdk.core.u;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class eq {

    /* renamed from: c  reason: collision with root package name */
    private int f34635c;
    private String sr;

    /* renamed from: w  reason: collision with root package name */
    private int f34636w;
    private String xv;

    public static eq c(String str) {
        try {
            return c(new JSONObject(str));
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.a.sr("LiveSdkConfig", "parse failed:" + e4);
            return new eq();
        }
    }

    public String sr() {
        return this.sr;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_live_status", c());
            jSONObject.put("app_id", w());
            jSONObject.put("partner", xv());
            jSONObject.put("secure_key", sr());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }

    public boolean ux() {
        return this.f34635c == 1;
    }

    public int w() {
        return this.f34636w;
    }

    public String xv() {
        return this.xv;
    }

    public void w(int i4) {
        this.f34636w = i4;
    }

    public void xv(String str) {
        this.sr = str;
    }

    public void w(String str) {
        this.xv = str;
    }

    public static eq c(JSONObject jSONObject) {
        eq eqVar = new eq();
        eqVar.c(jSONObject.optInt("ad_live_status"));
        eqVar.w(jSONObject.optInt("app_id"));
        eqVar.w(jSONObject.optString("partner"));
        eqVar.xv(jSONObject.optString("secure_key"));
        return eqVar;
    }

    public int c() {
        return this.f34635c;
    }

    public void c(int i4) {
        this.f34635c = i4;
    }
}
