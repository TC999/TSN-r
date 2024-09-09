package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: DomainDeviceInfo.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {

    /* renamed from: d  reason: collision with root package name */
    public String f39802d;

    /* renamed from: e  reason: collision with root package name */
    public String f39803e;

    /* renamed from: g  reason: collision with root package name */
    public String f39805g;

    /* renamed from: h  reason: collision with root package name */
    public String f39806h;

    /* renamed from: i  reason: collision with root package name */
    public String f39807i;

    /* renamed from: j  reason: collision with root package name */
    public String f39808j;

    /* renamed from: k  reason: collision with root package name */
    public String f39809k;

    /* renamed from: l  reason: collision with root package name */
    public String f39810l;

    /* renamed from: m  reason: collision with root package name */
    public String f39811m;

    /* renamed from: n  reason: collision with root package name */
    public String f39812n;

    /* renamed from: o  reason: collision with root package name */
    public String f39813o;

    /* renamed from: p  reason: collision with root package name */
    public String f39814p;

    /* renamed from: q  reason: collision with root package name */
    public String f39815q;

    /* renamed from: r  reason: collision with root package name */
    public String f39816r;

    /* renamed from: s  reason: collision with root package name */
    public String f39817s;

    /* renamed from: t  reason: collision with root package name */
    public String f39818t;

    /* renamed from: u  reason: collision with root package name */
    public String f39819u;

    /* renamed from: v  reason: collision with root package name */
    public int f39820v;

    /* renamed from: w  reason: collision with root package name */
    public JSONObject f39821w;

    /* renamed from: c  reason: collision with root package name */
    public String f39801c = "android";

    /* renamed from: a  reason: collision with root package name */
    public String f39799a = t.y();

    /* renamed from: b  reason: collision with root package name */
    public String f39800b = t.C();

    /* renamed from: f  reason: collision with root package name */
    public String f39804f = t.E();

    public d(Context context) {
        this.f39802d = e.b(context);
        this.f39803e = e.g(context);
        int D = t.D(context);
        this.f39805g = String.valueOf(D);
        this.f39806h = t.a(context, D);
        this.f39807i = t.C(context);
        this.f39808j = com.mbridge.msdk.foundation.controller.a.f().l();
        this.f39809k = com.mbridge.msdk.foundation.controller.a.f().k();
        this.f39810l = String.valueOf(ac.h(context));
        this.f39811m = String.valueOf(ac.g(context));
        this.f39815q = String.valueOf(ac.d(context));
        this.f39817s = com.mbridge.msdk.foundation.controller.a.f().o().toString();
        this.f39819u = t.z();
        this.f39820v = ac.e();
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f39812n = "landscape";
        } else {
            this.f39812n = "portrait";
        }
        this.f39816r = e.a(context);
        this.f39813o = com.mbridge.msdk.foundation.same.a.f39391s;
        this.f39814p = com.mbridge.msdk.foundation.same.a.f39392t;
        this.f39818t = t.J();
        this.f39821w = a(context, true);
    }

    private JSONObject a(Context context, boolean z3) {
        com.mbridge.msdk.c.a b4;
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put(BidResponsedEx.KEY_CID, e.a() + "");
                jSONObject.put("dmt", t.L() + "");
                jSONObject.put("dmf", t.K());
                jSONObject.put("ct", e.s());
            }
            b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        } catch (JSONException e4) {
            x.d("DomainDeviceInfo", e4.getMessage());
        }
        if (b4 != null && context != null) {
            if (b4.Z() == 1) {
                if (e.b(context) != null && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac")) {
                    jSONObject.put("imei", e.b(context));
                }
                if (e.i(context) != null && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac")) {
                    jSONObject.put("mac", e.i(context));
                }
                if (e.c(context) != null && z3 && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac")) {
                    jSONObject.put("imsi", e.c(context));
                }
            }
            if (b4.G() == 1 && e.a(context) != null && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, e.a(context));
            }
            if (b4.aa() == 1 && e.g(context) != null && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_android_id")) {
                jSONObject.put("android_id", e.g(context));
            }
            return jSONObject;
        }
        return jSONObject;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.f39799a);
                jSONObject.put("system_version", this.f39800b);
                jSONObject.put("network_type", this.f39805g);
                jSONObject.put("network_type_str", this.f39806h);
                jSONObject.put("device_ua", this.f39807i);
                jSONObject.put("has_wx", t.r(com.mbridge.msdk.foundation.controller.a.f().j()));
                jSONObject.put("integrated_wx", t.v());
                jSONObject.put("opensdk_ver", t.w() + "");
                jSONObject.put("wx_api_ver", t.g(com.mbridge.msdk.foundation.controller.a.f().m()) + "");
                jSONObject.put("emu", e.u());
                jSONObject.put("brand", this.f39819u);
            }
            jSONObject.put("plantform", this.f39801c);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac")) {
                jSONObject.put("device_imei", this.f39802d);
            }
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_android_id")) {
                jSONObject.put("android_id", this.f39803e);
            }
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.f39804f);
                jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, this.f39816r);
            }
            jSONObject.put("appkey", this.f39808j);
            jSONObject.put("appId", this.f39809k);
            jSONObject.put("screen_width", this.f39810l);
            jSONObject.put("screen_height", this.f39811m);
            jSONObject.put("orientation", this.f39812n);
            jSONObject.put("scale", this.f39815q);
            jSONObject.put("b", this.f39813o);
            jSONObject.put("c", this.f39814p);
            jSONObject.put("web_env", this.f39817s);
            jSONObject.put("f", this.f39818t);
            jSONObject.put("misk_spt", this.f39820v);
            jSONObject.put("dvi", s.a(this.f39821w.toString()));
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                jSONObject.put("dev_source", "2");
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }
}
