package com.mbridge.msdk.splash.a;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.foundation.tools.t;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: DeviceInfo.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public String f40472d;

    /* renamed from: e  reason: collision with root package name */
    public String f40473e;

    /* renamed from: g  reason: collision with root package name */
    public String f40475g;

    /* renamed from: h  reason: collision with root package name */
    public String f40476h;

    /* renamed from: i  reason: collision with root package name */
    public String f40477i;

    /* renamed from: j  reason: collision with root package name */
    public String f40478j;

    /* renamed from: k  reason: collision with root package name */
    public String f40479k;

    /* renamed from: l  reason: collision with root package name */
    public String f40480l;

    /* renamed from: m  reason: collision with root package name */
    public String f40481m;

    /* renamed from: n  reason: collision with root package name */
    public String f40482n;

    /* renamed from: o  reason: collision with root package name */
    public String f40483o;

    /* renamed from: p  reason: collision with root package name */
    public String f40484p;

    /* renamed from: c  reason: collision with root package name */
    public String f40471c = "android";

    /* renamed from: a  reason: collision with root package name */
    public String f40469a = t.y();

    /* renamed from: b  reason: collision with root package name */
    public String f40470b = t.C();

    /* renamed from: f  reason: collision with root package name */
    public String f40474f = t.E();

    public a(Context context) {
        this.f40472d = e.b(context);
        this.f40473e = e.g(context);
        int D = t.D(context);
        this.f40476h = String.valueOf(D);
        this.f40477i = t.a(context, D);
        this.f40478j = t.C(context);
        this.f40479k = com.mbridge.msdk.foundation.controller.a.f().l();
        this.f40480l = com.mbridge.msdk.foundation.controller.a.f().k();
        this.f40481m = String.valueOf(ac.h(context));
        this.f40482n = String.valueOf(ac.g(context));
        this.f40484p = String.valueOf(ac.d(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f40483o = "landscape";
        } else {
            this.f40483o = "portrait";
        }
        this.f40475g = e.a(context);
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.f40469a);
                jSONObject.put("system_version", this.f40470b);
                jSONObject.put("network_type", this.f40476h);
                jSONObject.put("network_type_str", this.f40477i);
                jSONObject.put("device_ua", this.f40478j);
                jSONObject.put("has_wx", t.r(com.mbridge.msdk.foundation.controller.a.f().j()));
                jSONObject.put("integrated_wx", t.v());
                jSONObject.put("opensdk_ver", t.w() + "");
                jSONObject.put("wx_api_ver", t.g(com.mbridge.msdk.foundation.controller.a.f().m()) + "");
                jSONObject.put("emu", e.u());
            }
            jSONObject.put("plantform", this.f40471c);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac")) {
                jSONObject.put("device_imei", this.f40472d);
            }
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_android_id")) {
                jSONObject.put("android_id", this.f40473e);
            }
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.f40474f);
                jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, this.f40475g);
            }
            jSONObject.put("appkey", this.f40479k);
            jSONObject.put("appId", this.f40480l);
            jSONObject.put("screen_width", this.f40481m);
            jSONObject.put("screen_height", this.f40482n);
            jSONObject.put("orientation", this.f40483o);
            jSONObject.put("scale", this.f40484p);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }
}
