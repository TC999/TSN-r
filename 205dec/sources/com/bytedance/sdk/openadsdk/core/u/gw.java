package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gw {

    /* renamed from: c  reason: collision with root package name */
    private boolean f34692c;
    private int sr;

    /* renamed from: w  reason: collision with root package name */
    private boolean f34693w;
    private int xv;

    public gw(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("window_landing");
        if (optJSONObject == null) {
            return;
        }
        this.f34692c = optJSONObject.optBoolean("can_jump_to_landing", false);
        this.f34693w = optJSONObject.optBoolean("can_click_to_landing", false);
        this.xv = optJSONObject.optInt("auto_to_landing_type", 0);
        this.sr = optJSONObject.optInt("auto_to_landing_time", 0);
    }

    public static int sr(me meVar) {
        gw q3 = m.q(meVar);
        if (q3 == null) {
            return 0;
        }
        return q3.sr;
    }

    public static String ux(me meVar) {
        return meVar == null ? "" : meVar.pu();
    }

    public static boolean w(me meVar) {
        gw q3 = m.q(meVar);
        if (q3 == null) {
            return false;
        }
        return q3.f34693w;
    }

    public static int xv(me meVar) {
        gw q3 = m.q(meVar);
        if (q3 == null) {
            return 0;
        }
        return q3.xv;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("can_jump_to_landing", this.f34692c);
            jSONObject2.put("can_click_to_landing", this.f34693w);
            jSONObject2.put("auto_to_landing_type", this.xv);
            jSONObject2.put("auto_to_landing_time", this.sr);
            jSONObject.put("window_landing", jSONObject2);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.a.xv("parse json:" + e4.getMessage());
        }
    }

    public static boolean c(me meVar) {
        gw q3 = m.q(meVar);
        if (q3 == null || !q3.f34692c || meVar.y() == 1) {
            return false;
        }
        if (meVar.y() == 2 && meVar.ld() == 3) {
            return false;
        }
        if (meVar.y() == 2 && meVar.ld() == 7) {
            return false;
        }
        if (meVar.tz() == 5 || meVar.tz() == 15) {
            return !TextUtils.isEmpty(ux(meVar));
        }
        return false;
    }
}
