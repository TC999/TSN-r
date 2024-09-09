package com.bytedance.sdk.openadsdk.core.fz.c;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.gd;
import com.bytedance.sdk.openadsdk.core.eq.i;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.fz.c.xv;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.r;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv<T extends xv> implements c {

    /* renamed from: a  reason: collision with root package name */
    private String f33666a;
    private String bk;

    /* renamed from: c  reason: collision with root package name */
    private String f33667c;
    private String ev;

    /* renamed from: k  reason: collision with root package name */
    private String f33669k;

    /* renamed from: p  reason: collision with root package name */
    private String f33670p;

    /* renamed from: t  reason: collision with root package name */
    private String f33672t;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private String f33673w;
    private String xv;
    private String ys;
    private String sr = eq.xv;

    /* renamed from: f  reason: collision with root package name */
    private long f33668f = System.currentTimeMillis() / 1000;

    /* renamed from: r  reason: collision with root package name */
    private int f33671r = 0;
    private int gd = 0;

    private JSONObject ia() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            com.bytedance.sdk.openadsdk.t.c.w(ls.getContext(), jSONObject);
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, i.c());
            jSONObject.put("model", com.bytedance.sdk.openadsdk.core.i.u());
            jSONObject.put("android_id", com.bytedance.sdk.openadsdk.core.i.ux());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("package_name", wv.ev());
            jSONObject.put("ua", wv.f());
            jSONObject.put("applog_did", r.c().w());
            jSONObject.put("ip", gd.r());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private T s() {
        return this;
    }

    public static xv<xv> w() {
        return new xv<>();
    }

    public int a() {
        return this.gd;
    }

    public String bk() {
        return this.f33670p;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fz.c.c
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getType())) {
                jSONObject.put("type", getType());
            }
            if (!TextUtils.isEmpty(sr())) {
                jSONObject.put("rit", sr());
            }
            if (!TextUtils.isEmpty(ux())) {
                jSONObject.put(CampaignEx.JSON_KEY_CREATIVE_ID, ux());
            }
            if (!TextUtils.isEmpty(f())) {
                jSONObject.put("ad_sdk_version", f());
            }
            if (!TextUtils.isEmpty(ev())) {
                jSONObject.put("app_version", ev());
            } else {
                jSONObject.put("app_version", wv.p());
            }
            if (gd() > 0) {
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, gd());
            }
            if (p() > 0) {
                jSONObject.put("adtype", p());
            }
            if (!TextUtils.isEmpty(k())) {
                jSONObject.put("req_id", k());
            }
            jSONObject.put("error_code", a());
            if (!TextUtils.isEmpty(bk())) {
                jSONObject.put("error_msg", bk());
            }
            if (!TextUtils.isEmpty(t())) {
                jSONObject.put("extra", t());
            }
            if (!TextUtils.isEmpty(ys())) {
                jSONObject.put(CampaignEx.JSON_KEY_IMAGE_URL, ys());
            }
            if (!TextUtils.isEmpty(xv())) {
                jSONObject.put(EventMonitor.EVENT_EXTRA, xv());
            }
            if (!TextUtils.isEmpty(r())) {
                jSONObject.put("duration", r());
            }
            if (!TextUtils.isEmpty(k.sr().ev())) {
                jSONObject.put("appid", k.sr().ev());
            }
            if (!TextUtils.isEmpty(fp())) {
                jSONObject.put("ad_info", fp());
            }
            jSONObject.put("plugin_version", "6.1.0.6");
            jSONObject.put("is_plugin", eq.c());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("conn_type", ys.w(ls.getContext()));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("device_info", ia());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public String ev() {
        return this.ux;
    }

    public String f() {
        return this.sr;
    }

    public String fp() {
        return this.ys;
    }

    public long gd() {
        return this.f33668f;
    }

    public String getType() {
        return this.f33667c;
    }

    public String k() {
        return this.ev;
    }

    public int p() {
        return this.f33671r;
    }

    public String r() {
        return this.f33672t;
    }

    public String sr() {
        return this.f33673w;
    }

    public String t() {
        return this.f33669k;
    }

    public String ux() {
        return this.xv;
    }

    public String xv() {
        return this.bk;
    }

    public String ys() {
        return this.f33666a;
    }

    public T ev(String str) {
        this.f33669k = str;
        return s();
    }

    public T f(String str) {
        this.ev = str;
        return s();
    }

    public T gd(String str) {
        this.ys = str;
        return s();
    }

    public T r(String str) {
        this.f33670p = str;
        return s();
    }

    public T sr(String str) {
        this.xv = str;
        return s();
    }

    public T ux(String str) {
        this.f33672t = str;
        return s();
    }

    public T w(String str) {
        this.bk = str;
        return s();
    }

    public T xv(String str) {
        this.f33673w = str;
        return s();
    }

    public T w(int i4) {
        this.gd = i4;
        return s();
    }

    public T c(String str) {
        this.f33667c = str;
        return s();
    }

    public T c(long j4) {
        this.f33668f = j4;
        return s();
    }

    public T c(int i4) {
        this.f33671r = i4;
        return s();
    }
}
