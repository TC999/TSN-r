package com.bytedance.sdk.openadsdk.core.u;

import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class y {

    /* renamed from: c  reason: collision with root package name */
    private String f34899c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private String f34900f;
    private w gd;

    /* renamed from: p  reason: collision with root package name */
    private c f34901p;

    /* renamed from: r  reason: collision with root package name */
    private JSONArray f34902r;
    private String sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private boolean f34903w;
    private boolean xv;

    public static y c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        y yVar = new y();
        yVar.f34899c = jSONObject.optString("promotion_id");
        yVar.f34903w = jSONObject.optBoolean("is_silent_auth", false);
        yVar.xv = jSONObject.optBoolean("enable_playable_auth", false);
        yVar.sr = jSONObject.optString("aweme_agreements");
        yVar.ux = jSONObject.optString("aweme_privacy");
        yVar.f34900f = jSONObject.optString("live_csj_libra_param");
        yVar.f34902r = jSONObject.optJSONArray("tasks");
        yVar.ev = jSONObject.optInt("live_playable");
        yVar.f34901p = c.c(jSONObject.optJSONObject(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
        yVar.gd = w.c(jSONObject.optJSONObject(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
        return yVar;
    }

    public JSONArray ev() {
        return this.f34902r;
    }

    public String f() {
        return this.ux;
    }

    public boolean gd() {
        return this.ev == 2 && this.xv;
    }

    public c k() {
        return this.f34901p;
    }

    public w p() {
        return this.gd;
    }

    public String r() {
        return this.f34900f;
    }

    public boolean sr() {
        return this.xv;
    }

    public String ux() {
        return this.sr;
    }

    public String w() {
        return this.f34899c;
    }

    public boolean xv() {
        return this.f34903w;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        int f34906c;

        /* renamed from: w  reason: collision with root package name */
        int f34907w;

        public static w c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            w wVar = new w();
            wVar.f34906c = jSONObject.optInt(RewardPlus.AMOUNT);
            wVar.f34907w = jSONObject.optInt("threshold");
            return wVar;
        }

        public int w() {
            return this.f34907w;
        }

        public JSONObject xv() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(RewardPlus.AMOUNT, this.f34906c);
                jSONObject.put("threshold", this.f34907w);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public int c() {
            return this.f34906c;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        String f34904c;
        double sr;

        /* renamed from: w  reason: collision with root package name */
        String f34905w;
        double xv;

        public static c c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            c cVar = new c();
            cVar.f34904c = jSONObject.optString("title");
            cVar.f34905w = jSONObject.optString("image");
            cVar.sr = jSONObject.optDouble(BidResponsed.KEY_PRICE);
            cVar.xv = jSONObject.optDouble("origin_price");
            return cVar;
        }

        public double sr() {
            return this.sr;
        }

        public JSONObject ux() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.f34904c);
                jSONObject.put("image", this.f34905w);
                jSONObject.put(BidResponsed.KEY_PRICE, this.sr);
                jSONObject.put("origin_price", this.xv);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public String w() {
            return this.f34905w;
        }

        public double xv() {
            return this.xv;
        }

        public String c() {
            return this.f34904c;
        }
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promotion_id", this.f34899c);
            jSONObject.put("is_silent_auth", this.f34903w);
            jSONObject.put("enable_playable_auth", this.xv);
            jSONObject.put("aweme_agreements", this.sr);
            jSONObject.put("aweme_privacy", this.ux);
            jSONObject.put("live_csj_libra_param", this.f34900f);
            jSONObject.put("tasks", this.f34902r);
            jSONObject.put("live_playable", this.ev);
            c cVar = this.f34901p;
            if (cVar != null) {
                jSONObject.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, cVar.ux());
            }
            w wVar = this.gd;
            if (wVar != null) {
                jSONObject.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, wVar.xv());
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }
}
