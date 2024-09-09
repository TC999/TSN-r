package com.bytedance.sdk.openadsdk.core.u;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ba {

    /* renamed from: a  reason: collision with root package name */
    private int f34591a;
    private boolean bk;

    /* renamed from: c  reason: collision with root package name */
    private int f34592c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private String f34593f;
    private int gd;

    /* renamed from: k  reason: collision with root package name */
    private int f34594k;

    /* renamed from: p  reason: collision with root package name */
    private int f34595p;

    /* renamed from: r  reason: collision with root package name */
    private String f34596r;
    private int sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private String f34597w;
    private int xv;

    public ba(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("live_ad")) == null) {
            return;
        }
        this.bk = true;
        c(optJSONObject.optInt("live_show_time", 60));
        this.f34597w = optJSONObject.optString("live_author_nickname");
        this.xv = optJSONObject.optInt("live_author_follower_count", -1);
        this.sr = optJSONObject.optInt("live_watch_count", -1);
        this.ux = optJSONObject.optString("live_description");
        this.f34593f = optJSONObject.optString("live_feed_url");
        this.f34596r = optJSONObject.optString("live_cover_image_url");
        this.ev = optJSONObject.optString("live_avatar_url");
        this.gd = optJSONObject.optInt("live_avatar_width");
        this.f34595p = optJSONObject.optInt("live_avatar_height");
        this.f34594k = optJSONObject.optInt("live_cover_width");
        this.f34591a = optJSONObject.optInt("live_cover_height");
    }

    public static int a(me meVar) {
        ba t3 = t(meVar);
        if (t3 == null) {
            return 0;
        }
        return t3.f34594k;
    }

    public static int bk(me meVar) {
        ba t3 = t(meVar);
        if (t3 == null) {
            return 0;
        }
        return t3.f34591a;
    }

    public static String ev(me meVar) {
        ba t3 = t(meVar);
        return t3 == null ? "" : t3.f34596r;
    }

    public static String f(me meVar) {
        ba t3 = t(meVar);
        return t3 == null ? "" : t3.ux;
    }

    public static String gd(me meVar) {
        ba t3 = t(meVar);
        return t3 == null ? "" : t3.ev;
    }

    public static int k(me meVar) {
        ba t3 = t(meVar);
        if (t3 == null) {
            return 0;
        }
        return t3.f34595p;
    }

    public static int p(me meVar) {
        ba t3 = t(meVar);
        if (t3 == null) {
            return 0;
        }
        return t3.gd;
    }

    public static String r(me meVar) {
        ba t3 = t(meVar);
        return t3 == null ? "" : t3.f34593f;
    }

    public static int sr(me meVar) {
        ba t3 = t(meVar);
        if (t3 == null) {
            return 0;
        }
        return t3.xv;
    }

    private static ba t(me meVar) {
        if (meVar == null) {
            return null;
        }
        return meVar.du();
    }

    public static int ux(me meVar) {
        ba t3 = t(meVar);
        if (t3 == null) {
            return 0;
        }
        return t3.sr;
    }

    public static int w(me meVar) {
        ba t3 = t(meVar);
        if (t3 == null) {
            return 0;
        }
        return t3.f34592c;
    }

    public static String xv(me meVar) {
        ba t3 = t(meVar);
        return t3 == null ? "" : t3.f34597w;
    }

    public boolean c() {
        return this.bk;
    }

    public void c(JSONObject jSONObject) {
        if (this.bk) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("live_show_time", this.f34592c);
                jSONObject2.put("live_author_nickname", this.f34597w);
                jSONObject2.put("live_author_follower_count", this.xv);
                jSONObject2.put("live_watch_count", this.sr);
                jSONObject2.put("live_description", this.ux);
                jSONObject2.put("live_feed_url", this.f34593f);
                jSONObject2.put("live_cover_image_url", this.f34596r);
                jSONObject2.put("live_avatar_url", this.ev);
                jSONObject2.put("live_cover_width", this.f34594k);
                jSONObject2.put("live_cover_height", this.f34591a);
                jSONObject2.put("live_avatar_width", this.gd);
                jSONObject2.put("live_avatar_height", this.f34595p);
                jSONObject.put("live_ad", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean c(me meVar) {
        ba t3 = t(meVar);
        if (t3 == null) {
            return false;
        }
        return t3.bk;
    }

    public void c(int i4) {
        this.f34592c = (i4 < 1 || i4 > 300) ? 60 : 60;
    }
}
