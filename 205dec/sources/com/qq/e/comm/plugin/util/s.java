package com.qq.e.comm.plugin.util;

import android.util.Pair;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46600a = "s";

    public static String a(Map<String, Object> map) {
        int a4;
        com.qq.e.comm.plugin.n0.v.a(1408000, (com.qq.e.comm.plugin.n0.c) null);
        int i4 = -1;
        if (map != null) {
            try {
                Object obj = map.get("staIn");
                a4 = obj instanceof String ? com.qq.e.comm.plugin.util.u2.e.b().a((String) obj) : -1;
                Object obj2 = map.get("meSrc");
                if (obj2 instanceof Integer) {
                    i4 = ((Integer) obj2).intValue();
                    com.qq.e.comm.plugin.util.u2.e.b().a(i4);
                }
            } catch (Exception e4) {
                d1.b(f46600a, e4.getMessage());
                return "";
            }
        } else {
            a4 = -1;
        }
        JSONObject jSONObject = new JSONObject();
        boolean z3 = com.qq.e.comm.plugin.d0.a.d().f().a("sgbcids", 1) == 1;
        Pair<String, String> d4 = a2.d();
        if (d4 != null) {
            jSONObject.put("taid", d4.first);
            if (z3) {
                jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, d4.second);
            }
        }
        if (z3) {
            jSONObject.put("anid", com.qq.e.comm.plugin.m.b.f44640f.b().a(com.qq.e.comm.plugin.d0.a.d().a()));
            jSONObject.put("imei", com.qq.e.comm.plugin.m.b.f44639e.b().a(com.qq.e.comm.plugin.d0.a.d().a()));
        }
        jSONObject.put("sdkver", e1.c());
        if (i4 > 0) {
            jSONObject.put("mc_f", i4);
        }
        if (a4 > 0) {
            jSONObject.put("mc_s", a4);
        }
        jSONObject.put("c_ori", y0.a());
        jSONObject.put("support_features", y1.a());
        jSONObject.put("tpl2_info", b(null));
        jSONObject.put("support_h265", com.qq.e.comm.plugin.o0.b.a().a(com.qq.e.comm.plugin.d0.a.d()));
        String jSONObject2 = jSONObject.toString();
        String a5 = o1.a(jSONObject2);
        d1.a(f46600a, "getBuyerId, originString: %s, buyerId: %s", jSONObject2, a5);
        return a5;
    }

    private static JSONObject b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (com.qq.e.comm.plugin.splash.j.f()) {
            jSONObject.put(String.valueOf(com.qq.e.comm.plugin.b.g.SPLASH.f42000e), 2);
        }
        jSONObject.put(String.valueOf(com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.f42000e), 2);
        if (com.qq.e.comm.plugin.gdtnativead.d.b(str)) {
            jSONObject.put(String.valueOf(com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD.f42000e), 2);
        }
        if (com.qq.e.comm.plugin.t.b.a(str)) {
            jSONObject.put(String.valueOf(com.qq.e.comm.plugin.b.g.UNIFIED_BANNER.f42000e), 2);
        }
        if (k1.a(str)) {
            jSONObject.put(String.valueOf(com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD.f42000e), 2);
        }
        jSONObject.put(String.valueOf(com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL_FULLSCREEN.f42000e), 2);
        jSONObject.put(String.valueOf(com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.f42000e), 2);
        return jSONObject;
    }

    public static String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("wx_installed", com.qq.e.comm.plugin.s0.b.a(true));
            jSONObject.put("opensdk_ver", com.qq.e.comm.plugin.s0.b.a());
            jSONObject.put("support_features", y1.a());
            jSONObject.put("qq_ver", n.a());
            jSONObject.put("tpl2_info", b(str));
            String jSONObject2 = jSONObject.toString();
            String a4 = o1.a(jSONObject2);
            d1.a(f46600a, "getSDKInfo, sdk_info: originString: %s, rtbData: %s", jSONObject2, a4);
            return a4;
        } catch (Exception e4) {
            d1.b(f46600a, e4.getMessage());
            return "";
        }
    }
}
