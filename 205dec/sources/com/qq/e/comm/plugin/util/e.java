package com.qq.e.comm.plugin.util;

import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {
    public static com.qq.e.comm.plugin.g0.b a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        com.qq.e.comm.plugin.g0.b bVar = new com.qq.e.comm.plugin.g0.b();
        JSONObject optJSONObject3 = jSONObject.optJSONObject("ext");
        if (optJSONObject3 != null && (optJSONObject2 = optJSONObject3.optJSONObject("app_channel_info")) != null) {
            bVar.a(b(optJSONObject2));
        }
        if (e(jSONObject) && optJSONObject3 != null) {
            bVar.c(optJSONObject3.optString("pkg_name"));
            bVar.b(optJSONObject3.optInt("appscore", 5));
            bVar.a(optJSONObject3.optLong("appdownloadnum", 100000L));
            bVar.a(optJSONObject3.optDouble("appprice"));
            bVar.a(optJSONObject3.optString("appname"));
            bVar.b(optJSONObject3.optString("applogo"));
            bVar.d(optJSONObject3.optString("appvername"));
            bVar.b(optJSONObject3.optLong("pkgsize"));
            bVar.c(com.qq.e.comm.plugin.apkmanager.k.e().b(bVar.e()));
            return bVar;
        }
        if (d(jSONObject) && optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("alist")) != null) {
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("2022");
            if (optJSONObject4 != null) {
                bVar.c(optJSONObject4.optString("aid"));
            } else {
                bVar.c(optJSONObject.optString("packagename"));
            }
            bVar.b(optJSONObject3.optInt("appscore"));
            bVar.a(optJSONObject3.optDouble("appprice"));
            bVar.a(optJSONObject3.optString("appname"));
            bVar.d(optJSONObject3.optString("appvername"));
            bVar.b(optJSONObject3.optLong("pkgsize"));
            bVar.c(com.qq.e.comm.plugin.apkmanager.k.e().b(bVar.e()));
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("2025");
            if (optJSONObject5 != null) {
                JSONObject optJSONObject6 = optJSONObject5.optJSONObject("aid");
                if (optJSONObject6 != null) {
                    bVar.a(optJSONObject6.optLong("total"));
                    bVar.b(optJSONObject6.optString("iconurl"));
                } else {
                    bVar.a(optJSONObject3.optLong("appdownloadnum"));
                }
            } else {
                bVar.a(optJSONObject3.optLong("downloadnum"));
                bVar.b(optJSONObject3.optString("applogo"));
            }
        }
        return bVar;
    }

    private static boolean a(int i4) {
        return i4 == 19 || i4 == 12 || i4 == 5 || i4 == 38;
    }

    private static com.qq.e.comm.plugin.g0.a b(JSONObject jSONObject) {
        com.qq.e.comm.plugin.g0.a aVar = new com.qq.e.comm.plugin.g0.a();
        aVar.a(jSONObject.optString("app_name"));
        aVar.b(jSONObject.optString("author_name"));
        aVar.a(jSONObject.optLong("package_size_bytes"));
        aVar.e(jSONObject.optString("permissions_url"));
        aVar.f(jSONObject.optString("privacy_agreement"));
        aVar.h(jSONObject.optString("version_name"));
        aVar.c(jSONObject.optString("description_url"));
        aVar.d(jSONObject.optString("icp_number"));
        aVar.g(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.SUITABLE_AGE));
        return aVar;
    }

    public static boolean b(int i4) {
        return i4 == 19 || i4 == 12;
    }

    public static String c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("ext");
        if (e(jSONObject) && optJSONObject2 != null) {
            return optJSONObject2.optString("pkg_name");
        }
        if (!d(jSONObject) || optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("alist")) == null) {
            return null;
        }
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("2022");
        if (optJSONObject3 != null) {
            return optJSONObject3.optString("aid");
        }
        return optJSONObject.optString("packagename");
    }

    public static boolean d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        boolean z3 = jSONObject.optInt("is_app_subscribe") == 1;
        int optInt = jSONObject.optInt("producttype");
        if (z3 && b(optInt)) {
            return false;
        }
        return a(optInt);
    }

    public static boolean e(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("producttype") == 38;
    }
}
