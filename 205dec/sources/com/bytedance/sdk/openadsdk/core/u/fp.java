package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fp {

    /* renamed from: c  reason: collision with root package name */
    private String f34667c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private int f34668f;
    private String gd;

    /* renamed from: p  reason: collision with root package name */
    private int f34669p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f34670r;
    private int sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private int f34671w;
    private int xv;

    public fp(JSONObject jSONObject) {
        this.f34671w = 0;
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("reward_browse_type", 0);
        this.f34671w = optInt;
        if (optInt < 0 || optInt > 3) {
            this.f34671w = 0;
        }
        if (this.f34671w == 2) {
            this.f34671w = 3;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("direct_landing_page_info");
        if (optJSONObject != null) {
            this.f34667c = optJSONObject.optString("direct_landing_url");
            this.xv = optJSONObject.optInt("display_duration", 0);
            this.sr = optJSONObject.optInt("close_time", 0);
            this.ux = optJSONObject.optInt("page_type");
            this.f34668f = optJSONObject.optInt("show_type");
            this.f34670r = optJSONObject.optBoolean("is_landing_with_sound", false);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward_browse_banner");
            if (optJSONObject2 != null) {
                this.ev = optJSONObject2.optString("ugen_url");
                this.gd = optJSONObject2.optString("ugen_md5");
            }
            this.f34669p = optJSONObject.optInt("close_btn_position");
        }
    }

    public static com.bytedance.sdk.openadsdk.core.ugeno.f.c a(me meVar) {
        fp ys = ys(meVar);
        if (ys == null || TextUtils.isEmpty(ys.ev)) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.f.c cVar = new com.bytedance.sdk.openadsdk.core.ugeno.f.c();
        cVar.xv(ys.ev);
        cVar.w(ys.gd);
        cVar.c(ys.ev);
        return cVar;
    }

    public static boolean bk(me meVar) {
        fp ys = ys(meVar);
        return ys != null && ys.f34669p == 1;
    }

    public static int ev(me meVar) {
        fp ys = ys(meVar);
        if (ys == null) {
            return 0;
        }
        return ys.f34671w;
    }

    public static String f(me meVar) {
        fp ys = ys(meVar);
        return ys == null ? "" : ys.f34667c;
    }

    public static int gd(me meVar) {
        int i4;
        fp ys = ys(meVar);
        if (ys != null && (i4 = ys.xv) >= 0) {
            return i4;
        }
        return 0;
    }

    public static boolean k(me meVar) {
        return ys(meVar) != null && ev(meVar) == 3 && c(meVar);
    }

    public static int p(me meVar) {
        int i4;
        fp ys = ys(meVar);
        if (ys != null && (i4 = ys.sr) >= 0) {
            return i4;
        }
        return 0;
    }

    public static boolean r(me meVar) {
        fp ys = ys(meVar);
        if (ys == null) {
            return false;
        }
        return ys.f34670r;
    }

    public static boolean sr(me meVar) {
        fp ys = ys(meVar);
        return ys != null && c(meVar) && ys.f34671w == 1 && ys.ux == 2;
    }

    public static int t(me meVar) {
        fp ys = ys(meVar);
        if (ys == null) {
            return 0;
        }
        return ys.f34669p;
    }

    public static boolean ux(me meVar) {
        fp ys = ys(meVar);
        return ys != null && ys.f34668f == 3;
    }

    public static boolean w(me meVar) {
        if (c(meVar)) {
            return r(meVar);
        }
        return false;
    }

    public static boolean xv(me meVar) {
        fp ys = ys(meVar);
        return ys != null && ys.f34671w == 1 && ys.ux == 1;
    }

    private static fp ys(me meVar) {
        if (meVar == null) {
            return null;
        }
        return meVar.pr();
    }

    public void c(JSONObject jSONObject) {
        try {
            jSONObject.put("reward_browse_type", this.f34671w);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("direct_landing_url", this.f34667c);
            jSONObject2.put("display_duration", this.xv);
            jSONObject2.put("close_time", this.sr);
            jSONObject2.put("page_type", this.ux);
            jSONObject2.put("show_type", this.f34668f);
            jSONObject2.put("close_btn_position", this.f34669p);
            jSONObject2.put("is_landing_with_sound", this.f34670r);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ugen_url", this.ev);
            jSONObject3.put("ugen_md5", this.gd);
            jSONObject2.put("reward_browse_banner", jSONObject3);
            jSONObject.put("direct_landing_page_info", jSONObject2);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public static boolean c(me meVar) {
        fp ys = ys(meVar);
        return (ys == null || ev(meVar) == 0 || TextUtils.isEmpty(ys.f34667c)) ? false : true;
    }
}
