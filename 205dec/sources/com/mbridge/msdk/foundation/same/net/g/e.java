package com.mbridge.msdk.foundation.same.net.g;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: CommonRequestParamsForAdd.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f39604a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f39605b = "";

    public static void a(d dVar, Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            dVar.a("withGP", t.O() + "");
            dVar.a("has_wx", t.r(com.mbridge.msdk.foundation.controller.a.f().j()) + "");
            dVar.a("integrated_wx", t.v() + "");
            dVar.a("opensdk_ver", t.w() + "");
            dVar.a("wx_api_ver", t.g(com.mbridge.msdk.foundation.controller.a.f().m()) + "");
            com.mbridge.msdk.foundation.controller.authoritycontroller.a.a();
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_DNT, 0) == 1) {
                dVar.a("dnt", "1");
            }
            dVar.a("emu", com.mbridge.msdk.foundation.tools.e.u());
        }
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
            String str = d.f39599f;
            dVar.a(str, aa.b() + "");
            String str2 = d.f39600g;
            dVar.a(str2, aa.a() + "");
            dVar.a("power_rate", com.mbridge.msdk.foundation.tools.b.a() + "");
            dVar.a("charging", com.mbridge.msdk.foundation.tools.b.b() + "");
            dVar.a(d.f39597d, t.J());
        }
        dVar.a("pkg_source", t.a(t.A(context), context));
        if (com.mbridge.msdk.foundation.controller.a.f().o() != null) {
            dVar.a("web_env", com.mbridge.msdk.foundation.controller.a.f().o().toString());
        }
        if (Build.VERSION.SDK_INT > 18) {
            dVar.a("http_req", "2");
        }
        a(dVar, true);
        e(dVar);
        c(dVar);
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 == null) {
            b4 = com.mbridge.msdk.c.b.a().b();
        }
        if (b4.aT()) {
            dVar.a("gdpr_consent", com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().f() + "");
        }
        f(dVar);
    }

    public static void b(d dVar) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            dVar.a("withGP", t.O() + "");
            dVar.a("has_wx", t.r(com.mbridge.msdk.foundation.controller.a.f().j()) + "");
            dVar.a("integrated_wx", t.v() + "");
            dVar.a("opensdk_ver", t.w() + "");
            dVar.a("wx_api_ver", t.g(com.mbridge.msdk.foundation.controller.a.f().m()) + "");
        }
        a(dVar, false);
        e(dVar);
        c(dVar);
        f(dVar);
    }

    public static void c(d dVar) {
        try {
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39391s)) {
                com.mbridge.msdk.foundation.same.a.f39391s = com.mbridge.msdk.foundation.a.a.a.a().b("b");
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39391s)) {
                dVar.a("b", com.mbridge.msdk.foundation.same.a.f39391s);
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39392t)) {
                com.mbridge.msdk.foundation.same.a.f39392t = com.mbridge.msdk.foundation.a.a.a.a().b("c");
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39392t)) {
                return;
            }
            dVar.a("c", com.mbridge.msdk.foundation.same.a.f39392t);
        } catch (Exception e4) {
            x.d("CommonRequestParamsForAdd", e4.getMessage());
        }
    }

    public static void d(d dVar) {
        if (dVar != null) {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                dVar.a("model");
                dVar.a("brand");
                dVar.a("screen_size");
                dVar.a("sub_ip");
                dVar.a("network_type");
                dVar.a("useragent");
                dVar.a("ua");
                dVar.a("language");
                dVar.a("network_str");
                dVar.a("mnc");
                dVar.a("mcc");
                dVar.a("os_version");
                dVar.a("gp_version");
                dVar.a("country_code");
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
                dVar.a(d.f39599f);
                dVar.a(d.f39600g);
                dVar.a("power_rate");
                dVar.a("charging");
                dVar.a("timezone");
            }
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                return;
            }
            dVar.a(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY);
            dVar.a("gaid2");
            dVar.a(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY);
        }
    }

    private static void e(d dVar) {
        int M = t.M();
        if (M != -1) {
            dVar.a("unknown_source", M + "");
        }
    }

    private static void f(d dVar) {
        String N = t.N();
        if (TextUtils.isEmpty(N) || N.equals("android")) {
            return;
        }
        dVar.a("hm_info", N);
    }

    public static void a(d dVar) {
        dVar.a("api_version", com.mbridge.msdk.foundation.same.a.f39378f);
    }

    private static void a(d dVar, boolean z3) {
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 != null) {
            if (!TextUtils.isEmpty(b4.o()) && z3) {
                dVar.a("a_stid", b4.o());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (b4.Z() == 1) {
                    if (com.mbridge.msdk.foundation.tools.e.b(j4) != null && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac")) {
                        jSONObject.put("imei", com.mbridge.msdk.foundation.tools.e.b(j4));
                    }
                    if (com.mbridge.msdk.foundation.tools.e.i(j4) != null && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac")) {
                        jSONObject.put("mac", com.mbridge.msdk.foundation.tools.e.i(j4));
                    }
                    if (com.mbridge.msdk.foundation.tools.e.c(j4) != null && z3 && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac")) {
                        jSONObject.put("imsi", com.mbridge.msdk.foundation.tools.e.c(j4));
                    }
                }
                if (b4.G() == 1 && com.mbridge.msdk.foundation.tools.e.a(j4) != null && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, com.mbridge.msdk.foundation.tools.e.a(j4));
                }
                if (b4.aa() == 1 && com.mbridge.msdk.foundation.tools.e.g(j4) != null && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_android_id")) {
                    jSONObject.put("android_id", com.mbridge.msdk.foundation.tools.e.g(j4));
                }
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put(BidResponsedEx.KEY_CID, com.mbridge.msdk.foundation.tools.e.a() + "");
                    jSONObject.put("dmt", t.L() + "");
                    jSONObject.put("dmf", t.K());
                    jSONObject.put("ct", com.mbridge.msdk.foundation.tools.e.s());
                }
                if (TextUtils.isEmpty(jSONObject.toString())) {
                    return;
                }
                if (!jSONObject.equals(f39604a)) {
                    f39605b = s.a(jSONObject.toString());
                }
                if (TextUtils.isEmpty(f39605b)) {
                    return;
                }
                dVar.a("dvi", f39605b);
            } catch (Exception e4) {
                x.d("CommonRequestParamsForAdd", e4.getMessage());
            }
        }
    }
}
