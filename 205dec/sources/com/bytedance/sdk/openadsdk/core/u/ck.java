package com.bytedance.sdk.openadsdk.core.u;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ck {

    /* renamed from: c  reason: collision with root package name */
    private boolean f34633c;

    /* renamed from: w  reason: collision with root package name */
    private int f34634w;

    public ck(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("landing_page_conf");
        if (optJSONObject != null) {
            this.f34633c = optJSONObject.optInt("swipe_back_type", 0) == 1;
            this.f34634w = optJSONObject.optInt("filter_track", 0);
        }
    }

    public static boolean w(me meVar) {
        ck xv = xv(meVar);
        return xv != null && xv.f34634w == 1;
    }

    private static ck xv(me meVar) {
        if (meVar == null) {
            return null;
        }
        return meVar.pl();
    }

    public void c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("swipe_back_type", this.f34633c ? 1 : 0);
            jSONObject2.put("filter_track", this.f34634w);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("landing_page_conf", jSONObject2);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    public static boolean c(me meVar) {
        ck xv = xv(meVar);
        if (xv == null) {
            return false;
        }
        return xv.f34633c;
    }
}
