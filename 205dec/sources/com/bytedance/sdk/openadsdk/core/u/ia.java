package com.bytedance.sdk.openadsdk.core.u;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ia {

    /* renamed from: a  reason: collision with root package name */
    private int f34696a;
    private int bk;

    /* renamed from: c  reason: collision with root package name */
    private int f34697c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private int f34698f;
    private int fp;
    private String fz;
    private int gd;
    private int ia;

    /* renamed from: k  reason: collision with root package name */
    private int f34699k;

    /* renamed from: p  reason: collision with root package name */
    private int f34700p;

    /* renamed from: r  reason: collision with root package name */
    private int f34701r;

    /* renamed from: s  reason: collision with root package name */
    private String f34702s;
    private int sr;

    /* renamed from: t  reason: collision with root package name */
    private int f34703t;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private int f34704w;
    private int xv;
    private int ys;

    public ia(JSONObject jSONObject) {
        this.f34697c = 0;
        this.f34704w = 1;
        this.xv = 1;
        this.sr = 1;
        this.ux = 1;
        this.f34698f = 1;
        this.f34701r = 0;
        this.ev = 0;
        this.gd = 0;
        this.f34700p = 300;
        this.f34699k = -1;
        this.f34696a = 1;
        this.bk = 1;
        this.f34703t = 31457280;
        this.ys = 0;
        this.fp = 0;
        this.ia = 0;
        if (jSONObject == null) {
            return;
        }
        this.f34698f = jSONObject.optInt("auto_open", 1);
        this.f34701r = jSONObject.optInt("download_mode", 0);
        this.ev = jSONObject.optInt("auto_control", 0);
        this.gd = jSONObject.optInt("auto_control_choose", 0);
        this.f34700p = jSONObject.optInt("auto_control_time", 300);
        this.f34699k = jSONObject.optInt("download_type", -1);
        this.f34696a = jSONObject.optInt("if_suspend_download", 1);
        this.f34697c = jSONObject.optInt("if_send_click", 0);
        this.f34704w = jSONObject.optInt("dl_popup", 1);
        this.xv = jSONObject.optInt("market_popup", 1);
        this.sr = jSONObject.optInt("if_pop_lp", 1);
        this.ux = jSONObject.optInt("pop_up_style_id", 1);
        this.bk = jSONObject.optInt("dl_network", 1);
        this.f34703t = jSONObject.optInt("dl_size", 31457280);
        this.ys = jSONObject.optInt("if_toast_market", 0);
        this.fp = jSONObject.optInt("enable_download_opt", 0);
        this.ia = jSONObject.optInt("dl_suspend_popup", 0);
        this.f34702s = jSONObject.optString("ugen_url");
        String optString = jSONObject.optString("ugen_md5");
        this.fz = optString;
        com.bytedance.sdk.openadsdk.core.ugeno.f.c(this.f34702s, optString);
    }

    public static int a(me meVar) {
        ia u3 = u(meVar);
        if (u3 == null) {
            return 1;
        }
        return u3.sr;
    }

    public static int bk(me meVar) {
        ia u3 = u(meVar);
        if (u3 == null) {
            return 1;
        }
        return u3.bk;
    }

    public static boolean c(me meVar) {
        ia u3 = u(meVar);
        return u3 != null && u3.fp == 1;
    }

    public static boolean ev(me meVar) {
        ia u3 = u(meVar);
        return u3 != null && u3.f34696a == 1;
    }

    public static boolean f(me meVar) {
        ia u3 = u(meVar);
        return u3 != null && u3.gd == 1;
    }

    public static int fp(me meVar) {
        ia u3 = u(meVar);
        if (u3 == null) {
            return 1;
        }
        return u3.ux;
    }

    public static String fz(me meVar) {
        ia u3 = u(meVar);
        return u3 == null ? "" : u3.fz;
    }

    public static int gd(me meVar) {
        ia u3 = u(meVar);
        if (u3 == null) {
            return 0;
        }
        return u3.f34697c;
    }

    public static int ia(me meVar) {
        ia u3 = u(meVar);
        if (u3 == null) {
            return 0;
        }
        return u3.ia;
    }

    public static int k(me meVar) {
        ia u3 = u(meVar);
        if (u3 == null) {
            return 1;
        }
        return u3.xv;
    }

    public static int p(me meVar) {
        ia u3 = u(meVar);
        if (u3 == null) {
            return 1;
        }
        return u3.f34704w;
    }

    public static int r(me meVar) {
        ia u3 = u(meVar);
        if (u3 == null) {
            return 300;
        }
        return u3.f34700p;
    }

    public static String s(me meVar) {
        ia u3 = u(meVar);
        return u3 == null ? "" : u3.f34702s;
    }

    public static int sr(me meVar) {
        ia u3 = u(meVar);
        if (u3 == null) {
            return -1;
        }
        return u3.f34699k;
    }

    public static int t(me meVar) {
        ia u3 = u(meVar);
        if (u3 == null) {
            return 31457280;
        }
        return u3.f34703t * 1048576;
    }

    private static ia u(me meVar) {
        if (meVar == null) {
            return null;
        }
        return meVar.iw();
    }

    public static boolean ux(me meVar) {
        ia u3 = u(meVar);
        return u3 != null && u3.ev == 1;
    }

    public static int w(me meVar) {
        ia u3 = u(meVar);
        if (u3 == null) {
            return 1;
        }
        return u3.f34698f;
    }

    public static int xv(me meVar) {
        ia u3 = u(meVar);
        if (u3 == null) {
            return 0;
        }
        return u3.f34701r;
    }

    public static boolean ys(me meVar) {
        ia u3 = u(meVar);
        return u3 != null && u3.ys == 1;
    }

    public int c() {
        return this.f34704w;
    }

    public boolean w() {
        return this.f34696a == 1;
    }

    public int xv() {
        return this.ia;
    }

    public void c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("auto_open", this.f34698f);
            jSONObject2.put("download_mode", this.f34701r);
            jSONObject2.put("download_type", this.f34699k);
            jSONObject2.put("auto_control", this.ev);
            jSONObject2.put("auto_control_choose", this.gd);
            jSONObject2.put("auto_control_time", this.f34700p);
            jSONObject2.put("if_suspend_download", this.f34696a);
            jSONObject2.put("if_send_click", this.f34697c);
            jSONObject2.put("dl_popup", this.f34704w);
            jSONObject2.put("market_popup", this.xv);
            jSONObject2.put("if_pop_lp", this.sr);
            jSONObject2.put("pop_up_style_id", this.ux);
            jSONObject2.put("dl_network", this.bk);
            jSONObject2.put("dl_size", this.f34703t);
            jSONObject2.put("if_toast_market", this.ys);
            jSONObject2.put("enable_download_opt", this.fp);
            jSONObject2.put("dl_suspend_popup", this.ia);
            jSONObject2.put("ugen_url", this.f34702s);
            jSONObject2.put("ugen_md5", this.fz);
            jSONObject.put("download_conf", jSONObject2);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }
}
