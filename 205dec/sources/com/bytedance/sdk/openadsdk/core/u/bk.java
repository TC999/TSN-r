package com.bytedance.sdk.openadsdk.core.u;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk {

    /* renamed from: a  reason: collision with root package name */
    private int f34614a;
    private long bk;

    /* renamed from: c  reason: collision with root package name */
    private long f34615c;
    private long ev;

    /* renamed from: f  reason: collision with root package name */
    private int f34616f;
    private String fp;
    private String gd;
    private String ia;

    /* renamed from: k  reason: collision with root package name */
    private long f34617k;

    /* renamed from: p  reason: collision with root package name */
    private long f34618p;

    /* renamed from: r  reason: collision with root package name */
    private int f34619r;

    /* renamed from: s  reason: collision with root package name */
    private String f34620s;
    private long sr;

    /* renamed from: t  reason: collision with root package name */
    private String f34621t;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private String f34622w;
    private String xv;
    private String ys;

    public static bk c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bk bkVar = new bk();
        bkVar.f34615c = jSONObject.optLong("user_id");
        bkVar.f34622w = jSONObject.optString("coupon_meta_id");
        bkVar.xv = jSONObject.optString("unique_id");
        bkVar.sr = jSONObject.optLong("device_id");
        bkVar.ux = jSONObject.optBoolean("has_coupon");
        bkVar.f34616f = jSONObject.optInt("coupon_scene");
        bkVar.f34619r = jSONObject.optInt("type");
        bkVar.ev = jSONObject.optLong("threshold");
        bkVar.gd = jSONObject.optString("scene_key");
        bkVar.f34618p = jSONObject.optLong("activity_id");
        bkVar.f34617k = jSONObject.optLong(RewardPlus.AMOUNT);
        bkVar.f34614a = jSONObject.optInt("action");
        bkVar.bk = jSONObject.optLong("style");
        bkVar.f34621t = jSONObject.optString("start_time");
        bkVar.ys = jSONObject.optString("expire_time");
        bkVar.fp = jSONObject.optString("button_text");
        bkVar.ia = jSONObject.optString("extra");
        bkVar.f34620s = jSONObject.optString("toast");
        return bkVar;
    }

    public int getType() {
        return this.f34619r;
    }

    public String sr() {
        return this.f34620s;
    }

    public boolean ux() {
        return this.ux && this.f34617k > 0;
    }

    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.f34615c);
            jSONObject.put("coupon_meta_id", this.f34622w);
            jSONObject.put("unique_id", this.xv);
            jSONObject.put("device_id", this.sr);
            jSONObject.put("type", this.f34619r);
            jSONObject.put("scene_key", this.gd);
            jSONObject.put("activity_id", this.f34618p);
            jSONObject.put("value", this.f34617k);
            jSONObject.put("threshold", this.ev);
            jSONObject.put("extra", this.ia);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public int xv() {
        return this.f34616f;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.f34615c);
            jSONObject.put("coupon_meta_id", this.f34622w);
            jSONObject.put("unique_id", this.xv);
            jSONObject.put("device_id", this.sr);
            jSONObject.put("has_coupon", this.ux);
            jSONObject.put("coupon_scene", this.f34616f);
            jSONObject.put("type", this.f34619r);
            jSONObject.put("threshold", this.ev);
            jSONObject.put("scene_key", this.gd);
            jSONObject.put("activity_id", this.f34618p);
            jSONObject.put(RewardPlus.AMOUNT, this.f34617k);
            jSONObject.put("action", this.f34614a);
            jSONObject.put("style", this.bk);
            jSONObject.put("start_time", this.f34621t);
            jSONObject.put("expire_time", this.ys);
            jSONObject.put("button_text", this.fp);
            jSONObject.put("extra", this.ia);
            jSONObject.put("toast", this.f34620s);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }
}
