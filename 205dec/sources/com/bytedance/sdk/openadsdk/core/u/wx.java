package com.bytedance.sdk.openadsdk.core.u;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class wx {

    /* renamed from: a  reason: collision with root package name */
    private int f34870a;
    private String ba;
    private int bk;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34871c;
    private boolean ck;
    private boolean eq;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private String f34872f;
    private int fp;
    private boolean fz;
    private boolean gb;
    private int gd;

    /* renamed from: i  reason: collision with root package name */
    private String f34873i;
    private int ia;

    /* renamed from: j  reason: collision with root package name */
    private String f34874j;

    /* renamed from: k  reason: collision with root package name */
    private int f34875k;
    private String ls;

    /* renamed from: n  reason: collision with root package name */
    private int f34876n;

    /* renamed from: p  reason: collision with root package name */
    private int f34877p;

    /* renamed from: q  reason: collision with root package name */
    private int f34878q;

    /* renamed from: r  reason: collision with root package name */
    private int f34879r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f34880s;
    private int sr;

    /* renamed from: t  reason: collision with root package name */
    private int f34881t;

    /* renamed from: u  reason: collision with root package name */
    private int f34882u;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private int f34883w;
    private String xv;

    /* renamed from: y  reason: collision with root package name */
    private String f34884y;
    private int ys;

    /* renamed from: z  reason: collision with root package name */
    private boolean f34885z;

    public wx(JSONObject jSONObject) {
        this.sr = 0;
        this.f34877p = 0;
        this.f34875k = 0;
        this.f34870a = 10;
        this.bk = 10;
        this.f34881t = 0;
        this.ys = -1;
        this.fp = 0;
        this.ia = 0;
        this.f34880s = false;
        this.f34878q = 0;
        this.f34876n = 0;
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("playable");
        if (optJSONObject != null) {
            this.ux = optJSONObject.optString("playable_url", "");
            this.f34872f = optJSONObject.optString("playable_download_url", "");
            this.gd = optJSONObject.optInt("playable_orientation", 0);
            this.f34877p = optJSONObject.optInt("playable_auto_convert", 0);
            this.f34875k = optJSONObject.optInt("playable_backup_enable", 0);
            this.f34870a = optJSONObject.optInt("playable_webview_timeout", 10);
            this.bk = optJSONObject.optInt("playable_js_timeout", 10);
            this.f34876n = optJSONObject.optInt("is_play_with_download", 0);
            this.gb = optJSONObject.optBoolean("allow_open_playable_landing_page", true);
            this.ck = optJSONObject.optBoolean("is_playable_pre_render", false);
            this.f34885z = optJSONObject.optBoolean("is_play_with_watching", false);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("playable_video");
            if (optJSONObject2 != null) {
                this.ba = optJSONObject2.optString(CampaignEx.JSON_KEY_VIDEO_URL);
                this.f34884y = optJSONObject2.optString("resolution");
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("playable_common");
        if (optJSONObject3 != null) {
            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("loading_page");
            if (optJSONObject4 != null) {
                this.f34879r = optJSONObject4.optInt("if_playable_loading_show", 0);
                this.ev = optJSONObject4.optInt("remove_loading_page_type", 0);
                this.f34878q = w(optJSONObject4);
                this.f34874j = optJSONObject4.optString("playable_loading_img_url", "");
                this.ls = optJSONObject4.optString("playable_loading_icon_url", "");
                this.f34873i = optJSONObject4.optString("playable_loading_tips", "");
            }
            this.eq = optJSONObject3.optBoolean("is_playable_top_priority", false);
        }
        this.f34871c = jSONObject.optBoolean("is_playable");
        this.f34883w = jSONObject.optInt("playable_type", 0);
        this.xv = jSONObject.optString("playable_style");
        this.f34881t = jSONObject.optInt("playable_duration_time", 0);
        this.ys = jSONObject.optInt("playable_close_time", -1);
        this.fp = jSONObject.optInt("playable_endcard_close_time", 0);
        this.ia = jSONObject.optInt("playable_reward_type", 0);
        this.sr = jSONObject.optInt("playable_convert_type", 0);
        this.f34880s = jSONObject.optBoolean("has_pre_playable", false);
        this.fz = jSONObject.optBoolean("is_pl_pre_5element", false);
        this.f34882u = jSONObject.optInt("pl_pre_5element_version", 1);
    }

    public static boolean a(me meVar) {
        wx eq = eq(meVar);
        return eq != null && eq.f34875k == 1;
    }

    public static String ba(me meVar) {
        wx eq = eq(meVar);
        return eq == null ? "" : eq.f34884y;
    }

    public static int bk(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return 10;
        }
        return eq.f34870a;
    }

    public static boolean ck(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return false;
        }
        return eq.f34885z;
    }

    private static wx eq(me meVar) {
        if (meVar == null) {
            return null;
        }
        return meVar.wv();
    }

    public static boolean ev(me meVar) {
        wx eq = eq(meVar);
        return r(meVar) && (eq != null ? eq.ev : 0) != 1;
    }

    public static String f(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return null;
        }
        return eq.f34872f;
    }

    public static boolean fp(me meVar) {
        return c(meVar) && me(meVar) == 0;
    }

    public static int fz(me meVar) {
        wx eq;
        if (com.bytedance.sdk.openadsdk.core.ls.w().zt() || (eq = eq(meVar)) == null) {
            return 0;
        }
        return eq.fp;
    }

    public static boolean gb(me meVar) {
        wx eq = eq(meVar);
        return eq != null && eq.f34882u == 2;
    }

    public static boolean gd(me meVar) {
        wx eq = eq(meVar);
        return r(meVar) && (eq != null ? eq.ev : 0) == 1;
    }

    public static boolean i(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return true;
        }
        int i4 = eq.sr;
        if (i4 < 0 || i4 > 2) {
            eq.sr = 0;
        }
        int i5 = eq.sr;
        return i5 == 0 || i5 == 2;
    }

    public static int ia(me meVar) {
        int i4;
        wx eq = eq(meVar);
        if (eq != null && (i4 = eq.f34881t) >= 0) {
            return i4;
        }
        return 0;
    }

    public static boolean j(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return false;
        }
        return eq.f34880s;
    }

    public static boolean k(me meVar) {
        wx eq = eq(meVar);
        return eq != null && eq.f34877p == 1;
    }

    public static boolean ls(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return false;
        }
        return eq.fz;
    }

    private static int me(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return 0;
        }
        return eq.f34883w;
    }

    public static boolean n(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return false;
        }
        return eq.ck;
    }

    public static int p(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return 0;
        }
        return eq.gd;
    }

    public static boolean q(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return true;
        }
        int i4 = eq.sr;
        if (i4 < 0 || i4 > 2) {
            eq.sr = 0;
        }
        int i5 = eq.sr;
        return i5 == 0 || i5 == 1;
    }

    public static boolean r(me meVar) {
        if (gw.c(meVar)) {
            return false;
        }
        wx eq = eq(meVar);
        return (eq != null ? eq.f34879r : 0) != 1;
    }

    public static int s(me meVar) {
        wx eq;
        int i4;
        if (com.bytedance.sdk.openadsdk.core.ls.w().zt() || (eq = eq(meVar)) == null || (i4 = eq.ys) < 0) {
            return 0;
        }
        return i4;
    }

    public static boolean sr(me meVar) {
        wx eq = eq(meVar);
        return eq != null && eq.f34876n == 1;
    }

    public static int t(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return 10;
        }
        return eq.bk;
    }

    public static int u(me meVar) {
        int i4;
        wx eq = eq(meVar);
        if (eq != null && (i4 = eq.ia) >= 0 && i4 <= 1) {
            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.ls.w().ck()) || fp.k(meVar)) {
                return eq.ia;
            }
            return 1;
        }
        return 0;
    }

    public static boolean ux(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return true;
        }
        return eq.gb;
    }

    private int w(JSONObject jSONObject) {
        String optString = jSONObject.optString("playable_loading_style", "0");
        optString.hashCode();
        if (optString.equals("1")) {
            return 1;
        }
        return !optString.equals("2") ? 0 : 2;
    }

    public static String xv(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return null;
        }
        return eq.ux;
    }

    public static boolean y(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return false;
        }
        return eq.eq;
    }

    public static boolean ys(me meVar) {
        return c(meVar) && me(meVar) == 1;
    }

    public static String z(me meVar) {
        wx eq = eq(meVar);
        return eq == null ? "" : eq.ba;
    }

    public void c(JSONObject jSONObject) {
        try {
            jSONObject.put("is_playable", this.f34871c);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("playable_url", this.ux);
            jSONObject2.put("playable_download_url", this.f34872f);
            jSONObject2.put("playable_orientation", this.gd);
            jSONObject2.put("playable_auto_convert", this.f34877p);
            jSONObject2.put("playable_backup_enable", this.f34875k);
            jSONObject2.put("playable_webview_timeout", this.f34870a);
            jSONObject2.put("playable_js_timeout", this.bk);
            jSONObject2.put("is_play_with_download", this.f34876n);
            jSONObject2.put("allow_open_playable_landing_page", this.gb);
            jSONObject2.put("is_pl_pre_5element", this.fz);
            jSONObject2.put("pl_pre_5element_version", this.f34882u);
            jSONObject2.put("is_playable_pre_render", this.ck);
            jSONObject2.put("is_play_with_watching", this.f34885z);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(CampaignEx.JSON_KEY_VIDEO_URL, this.ba);
            jSONObject3.put("resolution", this.f34884y);
            jSONObject2.put("playable_video", jSONObject3);
            jSONObject.put("playable", jSONObject2);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("if_playable_loading_show", this.f34879r);
            jSONObject5.put("remove_loading_page_type", this.ev);
            jSONObject5.put("playable_loading_style", this.f34878q);
            jSONObject5.put("playable_loading_img_url", this.f34874j);
            jSONObject5.put("playable_loading_icon_url", this.ls);
            jSONObject5.put("playable_loading_tips", this.f34873i);
            jSONObject4.put("loading_page", jSONObject5);
            jSONObject4.put("is_playable_top_priority", this.eq);
            jSONObject.put("playable_common", jSONObject4);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("playable_type", this.f34883w);
        } catch (JSONException e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put("playable_style", this.xv);
        } catch (JSONException e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("playable_duration_time", this.f34881t);
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("playable_close_time", this.ys);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put("playable_endcard_close_time", this.fp);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("playable_reward_type", this.ia);
        } catch (JSONException e12) {
            e12.printStackTrace();
        }
        try {
            jSONObject.put("playable_convert_type", this.sr);
        } catch (JSONException e13) {
            e13.printStackTrace();
        }
        try {
            jSONObject.put("has_pre_playable", this.f34880s);
        } catch (JSONException e14) {
            e14.printStackTrace();
        }
        try {
            jSONObject.put("is_pl_pre_5element", this.fz);
        } catch (JSONException e15) {
            e15.printStackTrace();
        }
        try {
            jSONObject.put("pl_pre_5element_version", this.f34882u);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public static String w(me meVar) {
        wx eq = eq(meVar);
        if (eq == null) {
            return null;
        }
        return eq.xv;
    }

    public static boolean c(me meVar) {
        wx eq = eq(meVar);
        return (eq == null || !eq.f34871c || TextUtils.isEmpty(eq.ux)) ? false : true;
    }

    public static int c(me meVar, int i4) {
        com.bykv.vk.openvk.component.video.api.xv.xv c4 = ng.c(meVar, i4);
        String gd = c4 != null ? c4.gd() : null;
        if (TextUtils.isEmpty(gd)) {
            return 0;
        }
        String[] split = gd.split("x");
        if (split.length < 2) {
            return 0;
        }
        return Integer.parseInt(split[0]) > Integer.parseInt(split[1]) ? 1 : 0;
    }

    public static int c(Context context, me meVar, boolean z3) {
        if (meVar == null) {
            return 0;
        }
        if (z3) {
            int p3 = p(meVar);
            if (p3 == 0 || p3 == 1) {
                return com.bytedance.sdk.openadsdk.core.eq.xk.ux(context, 63.0f);
            }
            if (p3 != 2) {
                return 0;
            }
            return com.bytedance.sdk.openadsdk.core.eq.xk.ux(context, 34.0f);
        }
        int fh = meVar.fh();
        if (fh != 1) {
            if (fh != 2) {
                return 0;
            }
            return com.bytedance.sdk.openadsdk.core.eq.xk.ux(context, 34.0f);
        }
        return com.bytedance.sdk.openadsdk.core.eq.xk.ux(context, 63.0f);
    }

    public static int c(Context context, me meVar) {
        if (ls(meVar) && gb(meVar) && com.bytedance.sdk.openadsdk.core.p.xv.k.sr(meVar)) {
            return c(context, meVar, true);
        }
        return 0;
    }
}
