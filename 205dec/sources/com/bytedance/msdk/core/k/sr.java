package com.bytedance.msdk.core.k;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private String f28057c;

    /* renamed from: f  reason: collision with root package name */
    private double f28058f;

    /* renamed from: r  reason: collision with root package name */
    private double f28059r;
    private int sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private String f28060w;
    private String xv;

    public sr(String str, String str2, String str3, int i4, String str4, double d4, double d5) {
        this.f28057c = str;
        this.f28060w = str2;
        this.xv = str3;
        this.sr = i4;
        this.ux = str4;
        this.f28058f = d4;
        this.f28059r = d5;
    }

    public String c() {
        return this.f28060w;
    }

    public double f() {
        return this.f28059r;
    }

    public String sr() {
        return this.ux;
    }

    public double ux() {
        return this.f28058f;
    }

    public String w() {
        return this.xv;
    }

    public int xv() {
        return this.sr;
    }

    public static sr c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return null;
        }
        return new sr(str, jSONObject.optString("label_name"), jSONObject.optString(CampaignEx.JSON_KEY_TIMESTAMP), jSONObject.optInt("label_id"), jSONObject.optString("label_version"), jSONObject.optDouble("upper_bound"), jSONObject.optDouble("lower_bound"));
    }
}
