package com.bytedance.sdk.openadsdk.core.dislike.xv;

import com.bytedance.sdk.openadsdk.ys.w.w.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private final int f33181c;

    /* renamed from: f  reason: collision with root package name */
    private final String f33182f;

    /* renamed from: r  reason: collision with root package name */
    private String f33183r;
    private final boolean sr;
    private final String ux;

    /* renamed from: w  reason: collision with root package name */
    private final List<f> f33184w = new ArrayList();
    private String xv;

    public w(JSONObject jSONObject) {
        this.f33181c = jSONObject.optInt("dislike_control", 0);
        this.sr = jSONObject.optBoolean("close_on_dislike", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("filter_words");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                xv c4 = xv.c(optJSONArray.optJSONObject(i4));
                if (c4 != null && c4.ux()) {
                    this.f33184w.add(c4);
                }
            }
        }
        this.ux = jSONObject.optString("ad_id");
        this.f33182f = jSONObject.optString("ext");
    }

    public void c(JSONObject jSONObject) throws JSONException {
        jSONObject.put("dislike_control", this.f33181c);
        jSONObject.put("filter_words", f());
        jSONObject.put("close_on_dislike", ev());
    }

    public boolean ev() {
        return this.sr;
    }

    public JSONArray f() {
        JSONObject r3;
        JSONArray jSONArray = new JSONArray();
        List<f> list = this.f33184w;
        if (list != null) {
            for (f fVar : list) {
                if ((fVar instanceof xv) && (r3 = ((xv) fVar).r()) != null) {
                    jSONArray.put(r3);
                }
            }
        }
        return jSONArray;
    }

    public String r() {
        return this.f33183r;
    }

    public String sr() {
        return this.f33182f;
    }

    public boolean ux() {
        return this.f33181c == 1;
    }

    public String w() {
        return this.xv;
    }

    public String xv() {
        return this.ux;
    }

    public void w(String str) {
        this.f33183r = str;
    }

    public List<f> c() {
        return this.f33184w;
    }

    public void c(String str) {
        this.xv = str;
    }
}
