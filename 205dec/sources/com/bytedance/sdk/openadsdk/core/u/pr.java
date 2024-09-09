package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class pr {

    /* renamed from: c  reason: collision with root package name */
    private boolean f34807c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private boolean f34808f;

    /* renamed from: r  reason: collision with root package name */
    private int f34809r;
    private int sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private int f34810w;
    private int xv;

    public pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("reward_draw");
        if (optJSONObject != null) {
            this.f34810w = optJSONObject.optInt("max_draw_play_time", 10);
            this.xv = optJSONObject.optInt("draw_rewarded_play_time", 10);
            this.sr = optJSONObject.optInt("skip_btn_left_style", 0);
            this.ux = optJSONObject.optInt("skip_btn_right_style", 0);
            this.f34808f = optJSONObject.optBoolean("auto_slide", false);
            this.f34809r = optJSONObject.optInt("show_time_type", 0);
            this.ev = optJSONObject.optInt("tip_time", 0);
        } else {
            this.f34810w = 10;
            this.xv = 10;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("group_info");
        if (optJSONObject2 != null) {
            this.f34807c = !TextUtils.isEmpty(optJSONObject2.optString("group_id"));
        }
    }

    public static int ev(me meVar) {
        pr gd = gd(meVar);
        if (gd == null) {
            return 25;
        }
        return gd.ev;
    }

    public static boolean f(me meVar) {
        pr gd = gd(meVar);
        if (gd == null) {
            return false;
        }
        return gd.f34808f;
    }

    private static pr gd(me meVar) {
        if (meVar == null) {
            return null;
        }
        return meVar.mm();
    }

    public static int r(me meVar) {
        pr gd = gd(meVar);
        if (gd == null) {
            return 10;
        }
        if (gd.f34809r == 1) {
            return Math.min((int) Math.max(ng.ux(meVar), xv(meVar)), 60);
        }
        return xv(meVar);
    }

    public static int sr(me meVar) {
        pr gd = gd(meVar);
        if (gd == null) {
            return 0;
        }
        return gd.sr;
    }

    public static int ux(me meVar) {
        pr gd = gd(meVar);
        if (gd == null) {
            return 0;
        }
        return gd.ux;
    }

    public static int w(me meVar) {
        int i4;
        pr gd = gd(meVar);
        if (gd != null && (i4 = gd.f34810w) > 0) {
            return i4;
        }
        return 10;
    }

    public static int xv(me meVar) {
        int i4;
        pr gd = gd(meVar);
        if (gd != null && (i4 = gd.xv) > 0) {
            return i4;
        }
        return 10;
    }

    public void c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("max_draw_play_time", this.f34810w);
            jSONObject2.put("draw_rewarded_play_time", this.xv);
            jSONObject2.put("skip_btn_left_style", this.sr);
            jSONObject2.put("skip_btn_right_style", this.ux);
            jSONObject2.put("auto_slide", this.f34808f);
            jSONObject2.put("show_time_type", this.f34809r);
            jSONObject2.put("tip_time", this.ev);
            jSONObject.put("reward_draw", jSONObject2);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public static boolean c(me meVar) {
        pr gd = gd(meVar);
        if (gd == null) {
            return false;
        }
        return gd.f34807c;
    }
}
