package com.bytedance.sdk.openadsdk.core.u;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ls {

    /* renamed from: c  reason: collision with root package name */
    private int f34709c;
    private boolean sr;

    /* renamed from: w  reason: collision with root package name */
    private long f34710w;
    private int xv;

    public static ls c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ls lsVar = new ls();
        lsVar.f34709c = jSONObject.optInt("refresh_control", 0);
        lsVar.f34710w = jSONObject.optLong("refresh_imp_max_time", 0L);
        lsVar.xv = jSONObject.optInt("refresh_num", 0);
        lsVar.sr = jSONObject.optBoolean("is_force_show_skip", false);
        return lsVar;
    }

    public boolean sr() {
        return this.sr;
    }

    public void w(JSONObject jSONObject) {
        try {
            jSONObject.put("refresh_control", this.f34709c);
            jSONObject.put("refresh_imp_max_time", this.f34710w);
            jSONObject.put("refresh_num", this.xv);
            jSONObject.put("is_force_show_skip", this.sr);
        } catch (JSONException unused) {
        }
    }

    public int xv() {
        return this.xv;
    }

    public long w() {
        return this.f34710w;
    }

    public static boolean c(me meVar) {
        ls dc;
        return (meVar == null || (dc = meVar.dc()) == null || dc.c() != 1) ? false : true;
    }

    public int c() {
        return this.f34709c;
    }

    public void c(boolean z3) {
        this.sr = z3;
    }
}
