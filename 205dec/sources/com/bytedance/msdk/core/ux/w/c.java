package com.bytedance.msdk.core.ux.w;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private int f28220c;

    /* renamed from: f  reason: collision with root package name */
    private int f28221f;

    /* renamed from: r  reason: collision with root package name */
    private int f28222r;
    private String sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private int f28223w;
    private String xv;

    public String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reason", this.f28220c);
            jSONObject.put("fill_error_code", this.f28223w);
            jSONObject.put("fill_error_msg", this.xv);
            jSONObject.put("mediation_rit", this.sr);
            jSONObject.put("load_sort", this.ux);
            jSONObject.put("show_sort", this.f28221f);
            jSONObject.put("has_shown", this.f28222r);
            return jSONObject.toString();
        } catch (JSONException e4) {
            e4.printStackTrace();
            return "{\"name\": \"json err\"}";
        }
    }

    public void sr(int i4) {
        this.ux = i4;
    }

    public void ux(int i4) {
        this.f28221f = i4;
    }

    public void w(int i4) {
        this.f28220c = i4;
    }

    public void xv(int i4) {
        this.f28223w = i4;
    }

    public void w(String str) {
        this.sr = str;
    }

    public void c(int i4) {
        this.f28222r = i4;
    }

    public void c(String str) {
        this.xv = str;
    }
}
