package com.bytedance.msdk.core.xv;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f28293c;

    /* renamed from: f  reason: collision with root package name */
    private String f28294f;

    /* renamed from: r  reason: collision with root package name */
    private int f28295r;
    private String sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private JSONObject f28296w;
    private int xv;

    public w(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("behavior_state");
        if (optJSONArray != null) {
            this.f28293c = new LinkedList();
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                try {
                    this.f28293c.add(Integer.valueOf(optJSONArray.getInt(i4)));
                } catch (JSONException e4) {
                    throw new RuntimeException(e4);
                }
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("rule_excs");
        if (optJSONObject != null) {
            this.f28295r = optJSONObject.optInt("condition");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("perform");
            this.f28296w = optJSONObject2;
            if (optJSONObject2 != null) {
                this.xv = optJSONObject2.optInt("condition");
                this.sr = this.f28296w.optString("opt");
                this.ux = this.f28296w.optString("rule_id");
                this.f28294f = this.f28296w.optString("rule_timestamp");
            }
        }
    }

    public int c() {
        return this.xv;
    }

    public String f() {
        return this.sr;
    }

    public boolean r() {
        return "1".equals(this.sr) || "2".equals(this.sr) || "3".equals(this.sr) || "4".equals(this.sr) || "5".equals(this.sr);
    }

    public String sr() {
        return this.f28294f;
    }

    public JSONObject ux() {
        return this.f28296w;
    }

    public int w() {
        return this.f28295r;
    }

    public String xv() {
        return this.ux;
    }

    public boolean c(int i4) {
        List<Integer> list = this.f28293c;
        if (list != null) {
            return list.contains(Integer.valueOf(i4));
        }
        return false;
    }

    public double w(String str, String str2) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.f28296w) == null || (optJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (optJSONObject2 = optJSONObject.optJSONObject(str2)) == null || (optJSONObject3 = optJSONObject2.optJSONObject("srr")) == null) {
            return 0.0d;
        }
        return optJSONObject3.optDouble(str, 0.0d);
    }

    public boolean c(String str) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = this.f28296w.optJSONObject("prime_rits");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject(str)) == null) {
            return false;
        }
        return (optJSONObject.optJSONObject("ssr") == null && optJSONObject.optJSONObject("srr") == null) ? false : true;
    }

    public double c(String str, String str2) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.f28296w) == null || (optJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (optJSONObject2 = optJSONObject.optJSONObject(str2)) == null || (optJSONObject3 = optJSONObject2.optJSONObject("ssr")) == null) {
            return 0.0d;
        }
        return optJSONObject3.optDouble(str, 0.0d);
    }
}
