package com.bytedance.msdk.core.k;

import com.bytedance.msdk.api.TTRequestExtraParams;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private double f28061c;

    /* renamed from: f  reason: collision with root package name */
    private String f28062f;

    /* renamed from: r  reason: collision with root package name */
    private JSONObject f28063r;
    private String sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private double f28064w;
    private int xv;

    private ux(double d4, double d5, int i4, String str, int i5, String str2, JSONObject jSONObject) {
        this.f28061c = d4;
        this.f28064w = d5;
        this.xv = i4;
        this.sr = str;
        this.ux = i5;
        this.f28062f = str2;
        this.f28063r = jSONObject;
    }

    public static void c(JSONObject jSONObject, Map<String, ux> map) {
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prime_rits")) == null) {
            return;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            try {
                String optString = optJSONArray.optString(i4);
                try {
                    map.put(optString, new ux(jSONObject.optDouble("upper", 0.0d), jSONObject.optDouble("lower", 0.0d), jSONObject.optInt("type"), optString, jSONObject.optInt("js_mode"), jSONObject.optString("rule_id"), jSONObject.optJSONObject(TTRequestExtraParams.PARAM_BANNER_REFRESH_TIME)));
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
    }

    public int getType() {
        return this.xv;
    }

    public String sr() {
        return this.f28062f;
    }

    public boolean ux() {
        return this.f28061c <= 0.0d && this.f28064w <= 0.0d;
    }

    public double w() {
        return this.f28064w;
    }

    public int xv() {
        return this.ux;
    }

    public double c() {
        return this.f28061c;
    }

    public int c(String str) {
        JSONObject jSONObject = this.f28063r;
        if (jSONObject != null) {
            return jSONObject.optInt(str);
        }
        return 0;
    }
}
